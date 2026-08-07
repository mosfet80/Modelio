/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.vstore.exml.common.index.hsqldb;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.debug.ThreadDumper;
import org.modelio.vbasic.log.Log;
import org.modelio.vstore.exml.common.index.hsqldb.SqlOperationRunner.PreparedStatementConsumer;

/**
 * HSQL connections pool.
 * <p>
 * It is a fixed size pool containing {@link Runtime#availableProcessors()} * 2 lazy connections.
 *
 * @since 5.4.1.20240123
 */
@objid ("98bd1924-e0b4-4a67-b077-95324e202076")
class HsqlConnectionPool implements SqlOperationRunner {
    @objid ("344c2bec-d121-4392-ae5b-d54888de8539")
    private final String dburl;

    @objid ("4cd47901-4943-4324-9c36-d7eb0e4fa2b6")
    private final int maxSize;

    @objid ("cb727a89-09d4-4f71-ba02-48c6a762d3ea")
    private boolean threadsDumped;

    @objid ("d6fd0430-d0f3-4eba-bf1d-9c4c3a5d4222")
    private volatile boolean disposed;

    @objid ("22604429-e66d-4fba-94e8-3ecf4f3b4c02")
    private final BlockingQueue<HsqlConnection> connections;

    @objid ("0a997b6b-23a1-4295-a676-e9f4342d6ed9")
    private static final Cleaner cleaner = Cleaner.create();

    @objid ("159131f9-d3f5-4e22-b8d1-4d173f4e1241")
    public HsqlConnectionPool(String dburl) {
        this.dburl = dburl;
        this.maxSize = Runtime.getRuntime().availableProcessors() * 2;
        this.connections = new ArrayBlockingQueue<>(this.maxSize);
        for (int i=0; i<this.maxSize; i++) {
            this.connections.add(new HsqlConnection(this.dburl));
        }
    }

    /**
     * Poll a {@link HsqlConnection} from the pool.
     * <p>
     * Instantiate a new one if the pool is empty.
     *
     * @return a {@link HsqlConnection}
     * @throws SQLException on failure creating a new JDBC connection
     * @throws IllegalStateException if too much connections already exist. A threads dump is then added as suppressed exceptions the first time this error occur.
     * @throws CancellationException if the thread was interrupted while waiting for an HSQLDB connection
     */
    @objid ("fa7c690f-b072-49ab-aa5c-fc731e0b7eac")
    public HsqlConnection get() throws SQLException, IllegalStateException, CancellationException {
        if (this.disposed)
            throw new IllegalStateException(String.format("'%s': disposed.", this.dburl, this.maxSize));

        try {
            HsqlConnection ret = this.connections.poll(1, TimeUnit.SECONDS);

            if (ret != null)
                return ret;
        } catch (InterruptedException e) {
            CancellationException ex = new CancellationException(String.format("'%s': interrupted waiting for a SQL connection.", this.dburl, this.maxSize));
            ex.initCause(e);
            Thread.currentThread().interrupt();
            throw ex;
        }

        IllegalStateException ex = new IllegalStateException(String.format("'%s': Too much connections : %d maximum.", this.dburl, this.maxSize));
        if (! this.threadsDumped) {
            ThreadDumper.get().getAllThreads(true).addAsSupressed(ex);
            this.threadsDumped = true;
        }
        throw ex;
    }

    /**
     * Close all inactive connections.
     */
    @objid ("9f97b3b0-8613-4ba9-95df-1979a2d715b7")
    public void dispose() {
        this.disposed = true;

        HsqlConnection c;
        while ((c = this.connections.poll()) != null) {
            c.dispose();
        }
    }

    @objid ("5601a217-94ab-4595-938b-fe6f7766815f")
    public boolean isDisposed() {
        return this.disposed;
    }

    @objid ("e62fbb83-1096-412d-b4fa-e5fbf8643aa5")
    @SuppressWarnings("resource")
    @Override
    public <T> T runSqlOperation(SqlFunction<Connection, T> sqlOp) throws SQLException {
        HsqlConnection aConn = get();
        try {
            return sqlOp.run(aConn.getJdbcConnection());
        } finally {
            release(aConn);
        }
    }

    @objid ("26fa5231-e1f8-4e81-88ae-95e30e063391")
    private void release(HsqlConnection aConn) {
        try {
            if (this.disposed) {
                aConn.dispose();
            } else {
                this.connections.add(aConn);
            }
        } catch (Throwable e) {
            Log.warning(e);
        }
    }

    @objid ("64f2466e-68cf-474a-bfa6-7691b38225ff")
    @SuppressWarnings("resource")
    @Override
    public void runSqlOperation(SqlOperation<Connection> sqlOp) throws SQLException {
        HsqlConnection aConn = get();
        try {
            sqlOp.run(aConn.getJdbcConnection());
        } finally {
            release(aConn);
        }
    }

    @objid ("3ef4b05f-d226-4b0a-9caa-dbbce197706c")
    @SuppressWarnings("resource")
    @Override
    public <T> T withPreparedSqlStatement(String sql, PreparedStatementConsumer<T> sqlOp) throws SQLException {
        HsqlConnection aConn = get();
        try {
            PreparedStatement statement = aConn.getPreparedStatement(sql);
            return sqlOp.acceptPreparedStatement(statement);
        } finally {
            release(aConn);
        }
    }

    @objid ("bd7f93c6-e34a-4510-b463-b8137fbc906c")
    @SuppressWarnings("resource")
    @Override
    public Stream<ResultSet> streamPreparedSqlStatement(String sql, SqlOperation<PreparedStatement> sqlOp) throws SQLException {
        boolean ok = false;
        HsqlConnection aConn = get();
        try {
            PreparedStatement statement = aConn.getPreparedStatement(sql);
            sqlOp.run(statement);

            Stream<ResultSet> ret = SqlOperationRunner
                    .toStream(statement.executeQuery());

            // Ensure DB connection is eventually released even if Stream not closed.
            Cleanable cleanable = cleaner.register(ret, () -> release(aConn));

            ok = true;

            return ret.onClose(cleanable::clean);
        } finally {
            if (! ok)
                release(aConn);
        }
    }

}
