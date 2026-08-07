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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.IBasicLogger;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vstore.exml.common.index.IUserNodeIndex;
import org.modelio.vstore.exml.common.index.IndexException;
import org.modelio.vstore.exml.common.model.ObjId;

/**
 * HSQLDB implementation of {@link IUserNodeIndex}
 */
@objid ("d6f34e47-13a5-453b-93f3-cb12d0ed597a")
public class HSqlUsesIndex implements IUserNodeIndex {
    @objid ("944da7df-5a18-4639-9681-db9bcd2bfec1")
    private static final String SQL_GET_SOURCES_FROM_TARGET = "SELECT e.clsname, e.id, e.name FROM \"elements\" as e, \"dependencies\" as d WHERE d.targetid=? and d.depname=? and e.id=d.srcid ";

    @objid ("965cae22-d0e2-44e4-a1d6-529b219f03a1")
    private static final String SQL_ADD_USE = "INSERT INTO \"dependencies\" (srcid, depname, targetid) values (?, ?, ?)";

    @objid ("c7db2385-29e3-4fa7-bcb5-d296f6c14d3f")
    private static final String SQL_DELETE_CMSNODE_USES = "DELETE FROM \"dependencies\" WHERE srcid IN (SELECT id FROM \"elements\" WHERE cmsnodeid=?)";

    @objid ("99fbe6c6-f97f-4b14-a2d3-c65c292aab59")
    private final IBasicLogger log;

    @objid ("15c3350e-d514-4bd4-8861-7a432e2d5ef5")
    private final SqlOperationRunner sqlRunner;

    @objid ("acebb2cb-e070-41d5-9732-d26a31f5d0e6")
    private final SmMetamodel metamodel;

    @objid ("a2d032ea-9bb1-412b-8798-d79e78836616")
    public HSqlUsesIndex(SmMetamodel metamodel, final SqlOperationRunner sqlRunner, String projectName) throws SQLException {
        this.sqlRunner = sqlRunner;
        this.log =  Log.getLogger(); // LoggerFactory.getLogger(HSqlUsesIndex.class.getName()+"."+projectName);
        this.metamodel = metamodel;

    }

    @objid ("b0193e86-7b52-4258-92ea-720c2c6e46f0")
    @Override
    public void remove(ObjId id) throws IndexException {
        this.sqlRunner.withPreparedIndexStatement(SQL_DELETE_CMSNODE_USES, insertObjectSt-> {
            insertObjectSt.setString(1, id.id);
            insertObjectSt.execute();
            return null;
        });

    }

    @objid ("ef55d46f-5496-462d-b679-7e8ea4ded730")
    @Override
    public void addUsed(ObjId userNodeId, String depName, ObjId usedObjectId) throws IndexException {
        this.sqlRunner.withPreparedIndexStatement(SQL_ADD_USE, insertObjectSt-> {
            int i=1;
            insertObjectSt.setString(i++, userNodeId.id);
            //insertObjectSt.setString(i++, userNodeId.mc);
            //insertObjectSt.setString(i++, userNodeId.name);
            insertObjectSt.setString(i++, depName);
            insertObjectSt.setString(i++, usedObjectId.id);
            //insertObjectSt.setString(i++, usedObjectId.mc);
            //insertObjectSt.setString(i++, usedObjectId.name);
            return insertObjectSt.execute();
        });

    }

    @objid ("fff1babb-a60f-444b-8d16-7cf6e1a01651")
    @Override
    public Collection<ObjId> getObjectUsers(ObjId objectId, String depName) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_SOURCES_FROM_TARGET, req -> {
            req.setString(1, objectId.id);
            req.setString(2, depName);

            Collection<ObjId> ret = new ArrayList<>();
            try (ResultSet res = req.executeQuery()) {
                while (res.next()) {
                    ObjId ref = new ObjId(
                            this.metamodel.getMClass(res.getString(1)),
                            res.getString(2)/*,
                               res.getString(3)*/);
                    ret.add(ref);
                }
            }

            return ret;
        });

    }

}
