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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;

@objid ("3558d948-08fc-43d1-8725-5c1e26bd748d")
class HsqlConnection {
    @objid ("80c9a46d-aaa2-43c7-bde9-76a31d3bbf5f")
    private final String dburl;


    @mdl.prop
    @objid ("a61b526c-1e24-4c4a-96d8-02cca42a7b69")
    private Connection jdbcConnection;

    @objid ("8eb4524b-fe9c-4e48-a3db-9d34e1df3e11")
    private final Map<String, PreparedStatement> statCache = new HashMap<>();

    @objid ("8ed37890-05b6-44ee-afea-ae39f2cf6145")
    private List<PreparedStatement> statement;

    @objid ("337cd18b-a39d-48c6-a298-e288db1cb192")
    public HsqlConnection(String dburl) {
        this.dburl = dburl;
    }

    @objid ("42a0b38e-5e92-48ee-a184-3030597acd59")
    public Connection getJdbcConnection() throws SQLException {
        if (this.jdbcConnection == null)
            this.jdbcConnection = DriverManager.getConnection(this.dburl, "SA", "");
        return this.jdbcConnection;
    }

    @objid ("74278a66-f161-4596-9797-d66b3d6d91c7")
    public void dispose() {
        if (this.jdbcConnection==null)
            return;

        try {
            this.jdbcConnection.close();
            this.jdbcConnection = null;
        } catch (SQLException e) {
            Log.warning(e);
        }

    }

    @objid ("8914b014-d2c9-4625-a862-aac0c45496a8")
    @SuppressWarnings ("resource")
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        PreparedStatement st = this.statCache.get(sql);
        if (st != null)
            return st;

        st = getJdbcConnection().prepareStatement(sql);
        this.statCache.put(sql, st);
        return st;
    }

}
