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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.files.StreamException;
import org.modelio.vbasic.log.Log;
import org.modelio.vstore.exml.common.index.IndexException;

/**
 * Service to run JDBC SQL operations without minding about closing JDBC resources.
 * <p>
 * The service may run the operation 2 times if the SQL connection is lost.
 */
@objid ("c0ad0095-667a-4ac6-8bdf-5c2df835c325")
interface SqlOperationRunner {
    /**
     * runs a JDBC {@link PreparedStatement} operation.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     *
     * @param <T> the operation return value type
     * @param sql the SQL code
     * @param sqlOp the operation to run
     * @return the operation result
     * @throws IndexException on failure
     */
    @objid ("0305928c-8aa6-4563-becf-f2e8fa2a298b")
    default <T> T withPreparedIndexStatement(String sql, PreparedStatementConsumer<T> sqlOp) throws IndexException {
        try {
            return withPreparedSqlStatement(sql, sqlOp);
        } catch (SQLException e) {
            throw translateSqlException(e);
        }

    }

    /**
     * runs a JDBC PreparedStatement operation.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     *
     * @param <T> the operation return value type
     * @param sql the SQL code
     * @param sqlOp the operation to run
     * @return the operation result
     * @throws SQLException on failure
     */
    @objid ("24724b30-296c-4768-9730-ebad581505c6")
    <T> T withPreparedSqlStatement(String sql, PreparedStatementConsumer<T> sqlOp) throws SQLException;

    /**
     * Prepare, configure, execute a prepared stateement and return the result as a stream.
     * <p>
     * <ol>
     * <li>Prepare a {@link PreparedStatement} from the given SQL code,
     * <li>call statementConfigurer that is expected to call various  {@link PreparedStatement#setString(int, String) setXxxx(...)}
     * <li>{@link PreparedStatement#executeQuery() execute the query}
     * <li>return the result as a stream
     * <li>closes involved resources when the stream is closed.
     * </ol>
     *
     * @param sql the parameterized SQL query
     * @param statementConfigurer code to configure the PreparedStatement before executing it.
     * @return the result stream.
     * @throws SQLException on failure executing the query.
     * @throws StreamException while
     */
    @objid ("c153b7cb-f16a-4f97-93df-c0368796d4f6")
    Stream<ResultSet> streamPreparedSqlStatement(String sql, SqlOperation<PreparedStatement> statementConfigurer) throws SQLException, StreamException;

    /**
     * runs a JDBC SQL operation.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     *
     * @param <T> the operation return value type
     * @param sqlOp the operation to run
     * @return the operation result
     * @throws SQLException on failure
     */
    @objid ("9e086c79-16d2-4204-914a-935e0e3813ff")
    <T> T runSqlOperation(SqlFunction<Connection, T> sqlOp) throws SQLException;

    /**
     * runs a JDBC SQL operation.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     *
     * @param sqlOp the operation to run
     * @throws SQLException on failure
     */
    @objid ("03bb4aa1-1471-46a7-af91-c4e404b0869b")
    void runSqlOperation(SqlOperation<Connection> sqlOp) throws SQLException;

    /**
     * Runs a JDBC SQL operation that returns a value.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     * <p>
     * All other exceptions are wrapped in a {@link IndexException}
     *
     * @param <T> the function return value type
     * @param op the function to run.
     * @return the function return value
     * @throws IndexException on failure
     */
    @objid ("cf0530b9-b13a-4256-b5fb-aaff01e92c22")
    default <T> T runIndexFunction(SqlFunction<Connection, T> op) throws IndexException {
        try {
            return runSqlOperation(op);
        } catch (SQLException e) {
            throw translateSqlException(e);
        }

    }

    /**
     * Runs a JDBC SQL operation that returns a value.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     * <p>
     * All other exceptions are wrapped in a {@link IndexException}
     *
     * @param <T> the function return value type
     * @param op the function to run.
     * @return the function return value
     * @throws StreamException on failure
     */
    @objid ("79999519-0417-4450-b829-0e76d6f4a236")
    default <T> T runIndexFunctionRt(SqlFunction<Connection, T> op) throws StreamException {
        try {
            return runSqlOperation(op);
        } catch (SQLException e) {
            throw translateSqlExceptionRuntime(e);
        }

    }

    /**
     * Runs a JDBC SQL operation that returns nothing.
     * <p>
     * The service may run the operation 2 times if the SQL connection is lost.
     * <p>
     * All other exceptions are wrapped in a {@link IndexException}
     *
     * @param op the operation to run.
     * @throws IndexException on failure
     */
    @objid ("340418ce-5172-444c-939a-7bfcd03df61e")
    default void runIndexOperation(SqlOperation<Connection> op) throws IndexException {
        try {
            runSqlOperation(op);
        } catch (SQLException e) {
            throw translateSqlException(e);
        }

    }

    @objid ("587cf925-bc29-4582-a728-7cd198d30eab")
    default IndexException translateSqlException(final SQLException e) {
        return new IndexException(e.getLocalizedMessage(), e);
    }

    @objid ("c01c51af-fd81-4ab8-94c7-500e4ccbc67f")
    default StreamException translateSqlExceptionRuntime(final SQLException e) {
        return new StreamException(new IndexException(e.getLocalizedMessage(), e));
    }

    /**
     * Transform a JDBD {@link ResultSet} to a {@link Stream}.
     * <p>
     * {@link Stream#close() closing} the stream will close the  ResultSet.
     *
     * @param resultSet a JDBD {@link ResultSet}
     * @return a java Stream.
     */
    @objid ("e6c365c6-616b-45f0-b245-f21de6d6dba8")
    static Stream<ResultSet> toStream(ResultSet resultSet) {
        return StreamSupport
                .stream(new ResultSetSpliterator(resultSet), false)
                .onClose(() -> {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        Log.warning(e.getMessage(), e);
                    }
                });

    }

    /**
     * Transform a Supplier of JDBC {@link ResultSet} to a {@link Stream}.
     * <p>
     * {@link Stream#close() closing} the stream will close the  ResultSet.
     *
     * @param resultSet a JDBC {@link ResultSet}
     * @return a java Stream.
     */
    @objid ("88ef6beb-b775-472d-bb53-ca86e2ddb269")
    static Stream<ResultSet> toStream(Supplier<ResultSet> resultSet) {
        CachedSupplierValue cached = new CachedSupplierValue(resultSet);
        return StreamSupport
                .stream(() -> new ResultSetSpliterator(cached.get()), Spliterator.ORDERED, false)
                .onClose(() -> {
                    cached.close();
                });

    }

    /**
     * Function expected to execute the given {@link PreparedStatement} and process the result.
     *
     * @param <T> the type returned by the function.
     */
    @objid ("36cc9c1f-cb46-4610-914f-9f914ee73839")
    interface PreparedStatementConsumer<T> {
        @objid ("088d71b7-bfb8-4b83-a9c7-3917476239c4")
        T acceptPreparedStatement(PreparedStatement statement) throws SQLException;

    }

    /**
     * {@link Spliterator} implementation for SQL {@link ResultSet}.
     */
    @objid ("69bdf43d-98e1-4e14-93d5-6605d8b726bf")
    static class ResultSetSpliterator extends java.util.Spliterators.AbstractSpliterator<ResultSet> {
        @objid ("793329d4-794a-4414-9a16-9e7f89d2030d")
        private final ResultSet resultSet;

        @objid ("9f689fc9-336c-4861-b8a6-b02692fccb41")
        private ResultSetSpliterator(ResultSet resultSet) {
            super(Long.MAX_VALUE, Spliterator.ORDERED);
            this.resultSet = resultSet;

        }

        @objid ("d8a18d45-fe65-49d5-ab29-d0d41f5bf020")
        @Override
        public boolean tryAdvance(Consumer<? super ResultSet> action) {
            try {
                if (!this.resultSet.next()) {
                    close();
                    return false;
                }

                action.accept(this.resultSet);
                return true;
            } catch (SQLException ex) {
                throw new StreamException(ex);
            }

        }

        @objid ("acc8d0f7-aa8f-4416-8210-11dd2151aea3")
        @Override
        public void forEachRemaining(Consumer<? super ResultSet> action) {
            try {
                while (this.resultSet.next()) {
                    action.accept(this.resultSet);
                }
            } catch (SQLException ex) {
                throw new StreamException(ex);
            } finally {
                close();
            }

        }

        @objid ("a43abbfa-a0c0-4c5c-81f0-76f42be119df")
        void close() {
            try {
                this.resultSet.close();
            } catch (SQLException | RuntimeException e) {
                Log.trace(e);
            }

        }

    }

    @objid ("ec03528c-df3d-4b17-89fb-c74db26d04ee")
    static final class CachedSupplierValue implements Supplier<ResultSet> {
        @objid ("4900dddf-194e-439b-a942-ca03bbed6aee")
        private final Supplier<ResultSet> resultSet;

        @objid ("0072c36d-8ce8-4762-bb53-c3841123ba02")
        private ResultSet val;

        @objid ("951a29a5-98d3-44ee-aa6b-8b699a3bc815")
        private CachedSupplierValue(Supplier<ResultSet> resultSet) {
            this.resultSet = resultSet;
        }

        @objid ("311ebd96-2699-4e86-965c-371ae68710b6")
        @Override
        public ResultSet get() {
            if (this.val == null) {
                this.val = this.resultSet.get();
            }
            return this.val;
        }

        @objid ("6e186e95-545c-4274-b96f-e34d38a607c1")
        public void close() {
            if (this.val != null) {
                try {
                    this.val.close();
                } catch (SQLException e) {
                    Log.trace(e);
                }
            }

        }

    }

}
