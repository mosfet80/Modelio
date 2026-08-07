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

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CompletionException;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.hsqldb.server.ServerConstants;
import org.modelio.vbasic.files.FileUtils;
import org.modelio.vbasic.files.StreamException;
import org.modelio.vbasic.log.IBasicLogger;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vstore.exml.common.index.ICmsNodeIndex;
import org.modelio.vstore.exml.common.index.IIndexDb;
import org.modelio.vstore.exml.common.index.IUserNodeIndex;
import org.modelio.vstore.exml.common.index.IndexException;
import org.modelio.vstore.exml.common.index.IndexOutdatedException;
import org.modelio.vstore.exml.common.index.hsqldb.SqlOperationRunner.PreparedStatementConsumer;
import org.modelio.vstore.exml.resource.IExmlResourceProvider;

@objid ("57a48161-740d-48b6-9bd0-2fe0599ae39e")
public class HsqlIndexes implements IIndexDb, SqlOperationRunner {
    @objid ("794c08cf-974b-47d1-ac90-7cd42b50cd91")
    static final int VERSION = 5;

    @objid ("f3371716-0b1b-4d14-a632-8bd982298369")
    private String host;

    @objid ("3b13076f-d30d-4c3a-a6fa-728f3dfd92de")
    private int port;

    @objid ("977b5d1a-058f-4b0c-9e67-7e19ec30952c")
    private final String projectName;

    @objid ("dc3ce70d-28df-4257-b6f8-c7ed326a8164")
    private final boolean canCreateDb;

    /**
     * Set this static attribute to 'true' before loading any index to start a local HSQLDB server in this VM.
     * <p>
     * Note this is not needed to open a database in this process, it could be needed only to share the server with another process.
     */
    @objid ("e4c46aa7-bb9b-4df3-bfb8-6f63984781e3")
    public static boolean RUN_SERVER = false;

    @objid ("7dbf8bec-c247-4882-906a-00c43ffc4fab")
    private static final boolean TRACE = false;

    @objid ("a3baad36-8965-4fdc-8284-d1c90bd9a908")
    private static final IBasicLogger LOG = Log.getLogger();

    @objid ("366e143e-96a4-4a39-a835-e17fc7f0485e")
    private HSqlCmsNodeIndex cmsNodeIndex;

    @objid ("3229789c-388c-49fc-97e5-2af781579c7e")
    private HsqlConnectionPool connPool;

    @objid ("97a4fd3e-7359-44dd-ba80-c641456df544")
    private final Path indexDbPath;

    @objid ("c408e12d-c541-4a15-8366-e92c3be2180f")
    private HSqlUsesIndex userNodeIndex;

    /**
     * For embedded server : connect to a file based database.
     *
     * @param indexDbPath the db directory
     * @param projectName the project name, used as database name.
     */
    @objid ("e1d21a33-7ef2-41e7-8abd-7e2320d60821")
    public HsqlIndexes(Path indexDbPath, String projectName, boolean canCreateDb) {
        this.canCreateDb = canCreateDb;
        this.indexDbPath = Objects.requireNonNull(indexDbPath);
        this.projectName = Objects.requireNonNull(projectName);
    }

    /**
     * For remote database server
     *
     * @param host the host name
     * @param port the port.
     * @param indexDbPath the db directory
     * @param projectName the project name, used as database name.
     * @param canCreateDb whether the server may create the database if missing
     */
    @objid ("e6135119-ff09-4bca-acc5-0277b4f0d180")
    public HsqlIndexes(String host, int port, Path indexDbPath, String projectName, boolean canCreateDb) {
        this.indexDbPath = indexDbPath;
        this.canCreateDb = canCreateDb;
        this.host = Objects.requireNonNull(host);
        this.port = port;
        this.projectName = Objects.requireNonNull(projectName);
    }

    @objid ("06211a30-cdc2-412f-9a9a-9b0a393d6da2")
    @Override
    public void checkIndexFormat() throws IndexException, IndexOutdatedException {
        int storedVersion = getStoredVersion();
        if (storedVersion != VERSION) {
            throw new IndexOutdatedException(String.format("Index format mismatch, version is %d , expected %d", storedVersion, VERSION));
        }
    }

    @objid ("7f267b43-d634-4dc9-903d-6022ca0ce5e7")
    @Override
    public void close() throws IndexException {
        if (this.connPool != null ) {
            runIndexOperation((connection) -> {
                try (Statement wipeStatement = connection.createStatement()) {
                    if (TRACE) LOG.trace("Shutting down '%s' database server", this.projectName);
                    wipeStatement.execute("SHUTDOWN");
                    if (wipeStatement.getWarnings() != null)
                        LOG.warning("SHUTDOWN:", wipeStatement.getWarnings());
                }
                connection.commit();
            });

            this.connPool.dispose();
            this.connPool = null;
        }
    }

    @objid ("333dbcd8-c2d7-4284-8181-957cdfefb7b5")
    @Override
    public void deleteIndexes() throws IndexException {
        if ( this.connPool != null) {
            runIndexOperation((connection) -> {
                if (TRACE) LOG.trace("Deleting '%s' database schema", this.projectName);
                try (Statement wipeStatement = connection.createStatement()) {
                    wipeStatement.execute("DROP SCHEMA PUBLIC CASCADE");
                    if (wipeStatement.getWarnings() != null)
                        LOG.warning("drop schema:", wipeStatement.getWarnings());
                }
                connection.commit();
            });
        }

        {
            try {
                close();

                if (RUN_SERVER) HsqlIndexes.LocalServer.instance.stop();

                FileUtils.delete(this.indexDbPath);

                if (RUN_SERVER) HsqlIndexes.LocalServer.instance.start();
            } catch (IOException e) {
                throw new IndexException(FileUtils.getLocalizedMessage(e), e);
            }
        }
    }

    @objid ("5b2db3ca-7dbc-4525-8aba-42f99fe529e0")
    @Override
    public void commit() throws IndexException {
        runIndexFunction(c -> {
            if (! c.getAutoCommit()) {
                c.commit();
            }
            return null;
        });
    }

    @objid ("cfda96bd-45c3-4d44-ae21-5b01926f01f7")
    @Override
    public void compress(final IModelioProgress monitor) throws IndexException {
        runIndexOperation(c -> {
            try (Statement st = c.createStatement()){
                st.execute("SHUTDOWN COMPACT");
            }
        });
        reconnectToDatabase();
    }

    @objid ("0154bdb7-c88c-4203-98df-3fa81115e610")
    @Override
    public ICmsNodeIndex getCmsNodeIndex() {
        return this.cmsNodeIndex;
    }

    @objid ("43be9ba4-c705-4267-a39b-20e53079f6b7")
    @Override
    public String getStoredStamp() throws IndexException {
        return getMetaProp("stamp", "");
    }

    @objid ("72af42e4-51dc-46a0-8a02-7973523b1b8c")
    @Override
    public int getStoredVersion() throws IndexException {
        try {
            return Integer.parseInt(getMetaProp("version", "-1"));
        } catch (IndexException e) {
            if (e.getMessage().startsWith("user lacks privilege or object not found")) {
                // "user lacks privilege or object not found: KEY" means invalid schema and too old version
                //throw new IndexOutdatedException(e.getMessage(), e);
                return -1;
            }
            throw e;
        }
    }

    @objid ("5ed1a0f4-f8a5-4b91-b1e5-b4bd6006a67c")
    @Override
    public IUserNodeIndex getUserNodeIndex() {
        return this.userNodeIndex;
    }

    @objid ("a098d821-5ad3-4b11-9ca9-cde0d329b821")
    @Override
    public void open(IModelioProgress aMonitor, IExmlResourceProvider resProvider, SmMetamodel metamodel) throws IndexException {
        if (this.connPool != null) {
            //throw new IllegalStateException(String.format("%s indexes are already open.", this.projectName));
            try {
                initDb();
            } catch (SQLException e) {
                throw translateSqlExc(e);
            } catch (IOException e) {
                throw new IndexException(FileUtils.getLocalizedMessage(e), e);
            }
            return;
        }

        try {
            if (this.canCreateDb) {
                InetAddress inetHost = InetAddress.getByName(this.host);
                if (inetHost.equals(InetAddress.getLocalHost()) || inetHost.isLoopbackAddress()) {
                    Files.createDirectories(this.indexDbPath);
                }
            }

            reconnectToDatabase();

            initDb();

            this.cmsNodeIndex = new HSqlCmsNodeIndex(this, this.projectName, metamodel);
            this.userNodeIndex = new HSqlUsesIndex(metamodel, this, this.projectName);

        } catch (SQLException e) {
            throw translateSqlExc(e);
        } catch (IOException e) {
            throw new IndexException(FileUtils.getLocalizedMessage(e), e);
        }
    }

    @objid ("5d1138df-9bfd-4913-949e-7d05b7746d41")
    @Override
    public void setStamp(final String stamp) throws IndexException {
        setMetaProp("stamp", stamp);
    }

    @objid ("6637ba31-0109-45a7-81cb-2178fccacbb1")
    @Override
    public void setStoredVersion() throws IndexException {
        setMetaProp("version", String.valueOf(VERSION));
    }

    @objid ("10d15ca2-0c11-4cd6-9b62-62990c80b41d")
    private String getMetaProp(String key, String defaultVal) throws IndexException {
        try {
            return runSqlOperation(cnx -> {
                PreparedStatement st = cnx.prepareStatement("select \"val\" from \"metadatas\" where \"key\" = ?");
                st.setString(1, key);
                try (ResultSet res = st.executeQuery();) {
                    logSqlWarnings(st);
                    if (res.next()) {
                        String strRes = res.getString(1);
                        return strRes;
                    } else {
                        return defaultVal;
                    }
                }
            });
        } catch (SQLException e) {
            throw translateSqlExc(e);
        }
    }

    @objid ("16a50a28-83a0-4057-87de-2f3bd5cf0cf2")
    private void initDb() throws SQLException, IOException {
        boolean isToCreate = runSqlOperation(conn -> {
            try (ResultSet tables = conn.getMetaData().getTables(null, null, "metadatas", new String[]{"TABLE"});) {
                return (! tables.next()) ;
            } catch (@SuppressWarnings ("unused") SQLException e) {
                return true;
            }
        });


        if (isToCreate) {
            if (! this.canCreateDb) {
                throw new NoSuchFileException(
                        getJdbcUrl(),
                        this.indexDbPath.toString(),
                        MessageFormat.format("The ''{0}'' database has not been initialized by the server.",
                                this.projectName));
            }

            String schema_file_name = "res/hsqldb_index_schema.sql";
            if (TRACE) {
                LOG.trace("Creating '%s' HSQL database...", this.projectName);
                LOG.trace("  Found '%s' in %s",schema_file_name,
                        Collections.list(getClass().getClassLoader().getResources(schema_file_name)));
            }

            try (InputStream is = getClass().getResourceAsStream("/"+schema_file_name);) {
                if (is == null) {
                    throw new NoSuchFileException(schema_file_name, null, getClass().getClassLoader().toString());
                }

                String sqls = FileUtils.readWhole(is, "UTF-8");
                this.connPool.runSqlOperation((Connection conn) -> {
                    for (String sql : sqls.split(Pattern.quote("-- **commit**"))) {
                        //log.trace("Running from '%s' :\n-------\n%s\n--------",schema_file_name,sql);
                        try (Statement createStatement = conn.createStatement()) {
                            createStatement.execute(sql);
                            logSqlWarnings(createStatement);
                        }
                    }
                });
            }
        }
    }

    @objid ("529bf1b9-918d-4d57-8c11-2cd3673e5b86")
    private void setMetaProp(String key, String value) throws IndexException {
        runIndexOperation(conn -> {
            try (PreparedStatement st = conn.prepareStatement("update \"metadatas\" set \"val\" = ? where \"key\" = ?")){
                st.setString(1, value);
                st.setString(2, key);

                int count = st.executeUpdate();
                if (count == 0) {
                    try (PreparedStatement st2 = conn.prepareStatement("insert into \"metadatas\" (\"key\", \"val\") values(  ? , ?)")){
                        st2.setString(1, key);
                        st2.setString(2, value);
                        count = st2.executeUpdate();
                        logSqlWarnings(st2);
                    }
                } else {
                    logSqlWarnings(st);
                }
            }
        });
    }

    @objid ("79e77a07-93e8-4404-b9bc-79ff6d99cb42")
    private void logSqlWarnings(Statement st) throws SQLException {
        if (st.getWarnings() != null) {
            LOG.warning("%s: %s execution returned warnings: %s", getClass().getSimpleName(), st, st.getWarnings());
        }
    }

    @objid ("269224cb-335c-493e-8316-84b416034cfb")
    private IndexException translateSqlExc(final SQLException e) {
        return new IndexException(e.getLocalizedMessage(), e);
    }

    @objid ("310b165f-270a-4e8f-87c1-03c0bad708f4")
    private String getJdbcUrl() {
        String ifExistProp = this.canCreateDb ? "" : ";ifexists=true";
        String filepathProp = "";
        Path dbPath = null;

        if (this.indexDbPath != null)  {
            dbPath = this.indexDbPath.resolve(this.projectName).toAbsolutePath();
            // http://hsqldb.org/doc/2.0/guide/listeners-chapt.html
            // http://hsqldb.org/doc/2.0/apidocs/org/hsqldb/server/Server.html
            filepathProp = ";filepath=file:"+dbPath;
        }

        // Added Options:
        //
        // - hsqldb.log_data=false         :
        //     logging data change. set to false when database recovery in the event of an unexpected crash is not necessary.
        //
        // - hsqldb.reconfig_logging=false :
        //     false avoids reconfiguring the framework logging system such as Log4J or java.util.Logging.
        //
        // See http://hsqldb.org/doc/2.0/guide/dbproperties-chapt.html .
        //
        if (this.host == null) {
            @SuppressWarnings ("null")
            URI file = dbPath.toUri();
            return MessageFormat.format(
                    "jdbc:hsqldb:file:/{0}{1}{2};hsqldb.reconfig_logging=false",
                    file.getPath(),
                    filepathProp,
                    ifExistProp
                    );
        } else {
            String loc = this.host;
            if (this.port > 0) {
                loc = this.host + ":" + this.port;
            }


            return MessageFormat.format(
                    "jdbc:hsqldb:hsql://{0}/{1}{2}{3};hsqldb.reconfig_logging=false",
                    loc,
                    this.projectName,
                    filepathProp,
                    ifExistProp
                    );
        }
    }

    @objid ("d3f19b18-64dc-4ce9-becf-78c39151fc65")
    @Override
    public void runSqlOperation(SqlOperation<Connection> torun) throws SQLException {
        callOrRetry(() -> { this.connPool.runSqlOperation(torun); return null;});
    }

    @objid ("822a5881-f2a4-46a9-9f6e-37c2f4671121")
    @Override
    public Stream<ResultSet> streamPreparedSqlStatement(String sql, SqlOperation<PreparedStatement> sqlOp) throws SQLException, StreamException {
        return callOrRetry(() -> this.connPool.streamPreparedSqlStatement(sql, sqlOp));
    }

    @objid ("0bef3d2f-117e-449b-8629-23b55a4a0d4e")
    @Override
    public boolean isWritable() {
        return true;
    }

    @objid ("12701185-8c4a-41ad-b90b-319c063da489")
    private void reconnectToDatabase() {
        String dburl = getJdbcUrl();

        HsqlConnectionPool oldPool = this.connPool;
        if (oldPool != null) {
            if (TRACE) LOG.trace("Disconnect to reconnect to '%s' database...", dburl);
            oldPool.dispose();
        }

        if (TRACE) {
            if (this.host == null) {
                LOG.trace("Opening local '%s' database in '%s'...", dburl, this.indexDbPath);
            } else {
                LOG.trace("Connecting to '%s' database...", dburl);
            }
        }

        this.connPool = new HsqlConnectionPool(dburl);
    }

    @objid ("406f1891-f191-493f-b561-1bb7dc75c4dd")
    @Override
    public <T> T runSqlOperation(SqlFunction<Connection, T> torun) throws SQLException {
        return callOrRetry(() -> this.connPool.runSqlOperation(torun));
    }

    @objid ("7e9fd4d2-9f43-488a-8edc-20aff76f0458")
    private <T> T callOrRetry(SqlCallable<T> torun) throws SQLException {
        try {
            return torun.call();
        } catch (java.sql.SQLNonTransientConnectionException e) {
            // handle "java.sql.SQLNonTransientConnectionException: connection exception: closed"
            if (!e.getMessage().contains("connection exception: closed") ) {
                throw e;
            }

            try {
                // try reconnect
                reconnectToDatabase();
                // try once again
                return torun.call();
            } catch (SQLException e2) {
                e2.addSuppressed(e);
                throw e2;
            }

        } catch (SQLTransientConnectionException e) {
            try {
                // try reconnect
                reconnectToDatabase();
                // try once again
                return torun.call();
            } catch (SQLException e2) {
                e2.addSuppressed(e);
                throw e2;
            }
        }
    }

    @objid ("156009fe-e32b-4df4-8337-76099b6ba1bd")
    @Override
    public <T> T withPreparedSqlStatement(String sql, PreparedStatementConsumer<T> sqlOp) throws SQLException {
        return callOrRetry(() -> this.connPool.withPreparedSqlStatement(sql, sqlOp));
    }

    @objid ("13fca358-dc88-45ea-9836-62be846d3ecd")
    public static void setRunServer(boolean runServer) {
        if (runServer && ! RUN_SERVER) {
            HsqlIndexes.LocalServer.instance.start();
        }
        RUN_SERVER = runServer;
    }

static {
                        if (RUN_SERVER) HsqlIndexes.LocalServer.instance.start();
                    }

    /**
     * In-process embedded HSQL server that allows other process to access this server.
     */
    @objid ("c7fae7a2-fa19-4967-a155-1d70b9589c1c")
    public static class LocalServer {
        @objid ("1dc8b3b5-9256-48c2-a6d1-9e6bbe3bc3d0")
        private org.hsqldb.server.Server server = new Server();

        /**
         * the singleton instance
         */
        @objid ("9a88586d-01f4-4e5c-ae12-efb4ee5b16b9")
        public static final LocalServer instance = new LocalServer();

        /**
         * Start the HSQL server.
         *
         * @throws IllegalStateException on unexpected startup failure
         */
        @objid ("4cb27ab3-a37d-4c5a-b09c-669156d6eae1")
        public void start() throws IllegalStateException {
            LOG.trace("Starting HSQL server in this local JVM ...");
            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
            } catch (ClassNotFoundException e) {
                throw new LinkageError("Missing HSQLDB class:"+e.getMessage(), e);
            }

            try {
                // Allow remote clients to open databases
                HsqlProperties props = new HsqlProperties();
                props.setProperty("server.remote_open", true);
                this.server.setProperties(props);
                this.server.start();
                if (this.server.getState() != ServerConstants.SERVER_STATE_ONLINE ) {
                    LOG.trace("   HSQL server state is %s.", this.server.getStateDescriptor());
                    Thread.sleep(100);
                    LOG.trace("   HSQL server state is now %s.", this.server.getStateDescriptor());
                }
                this.server.checkRunning(true);
                LOG.trace("  Started HSQL server.");
            } catch (IOException e) {
                throw new IllegalStateException(FileUtils.getLocalizedMessage(e), e);
            } catch (AclFormatException e) {
                throw new IllegalStateException(e.getLocalizedMessage(), e);
            } catch (InterruptedException e) {
                // Thread.sleep(100) interrupted
                throw new IllegalStateException("Wait for HSQL server being ready interrupted", e);
            }
        }

        /**
         * Stop the HSQL server.
         */
        @objid ("f986dbc7-9998-4e18-b045-abfdb04f60ee")
        public void stop() {
            LOG.trace("Stopping HSQL server ...");
            this.server.setRestartOnShutdown(false);
            this.server.shutdownWithCatalogs(org.hsqldb.Database.CLOSEMODE_NORMAL);
            this.server.stop();


            for (int i=0; i<10 && this.server.getState() != ServerConstants.SERVER_STATE_SHUTDOWN; i++) {
                LOG.trace("  Waiting for HSQL server to stop %d/10 , state = %d:%s...", i,
                        this.server.getState(),
                        this.server.getStateDescriptor());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new CompletionException(e);
                }
            }

            if (this.server.getState() != ServerConstants.SERVER_STATE_SHUTDOWN) {
                throw new IllegalStateException(String.format(
                        "HSQL server still running, state = %d:%s",
                        this.server.getState(),
                        this.server.getStateDescriptor()));
            }

            LOG.trace("HSQL server stopped, state = %d:%s",
                        this.server.getState(),
                        this.server.getStateDescriptor());
        }

    }

    @objid ("ceecf917-22b3-45c5-aaed-47417d74681f")
    @FunctionalInterface
    interface SqlCallable<T> {
        @objid ("f1623e38-f0f9-4167-8996-e7afec62a9b8")
        T call() throws SQLException;

    }

}
