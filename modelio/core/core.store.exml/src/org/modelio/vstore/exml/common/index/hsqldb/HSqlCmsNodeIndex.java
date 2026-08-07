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
/*
 * Copyright 2013-2024 Docaposte
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.files.StreamException;
import org.modelio.vbasic.log.IBasicLogger;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vstore.exml.common.index.ICmsNodeIndex;
import org.modelio.vstore.exml.common.index.IndexException;
import org.modelio.vstore.exml.common.model.IndexElement;
import org.modelio.vstore.exml.common.model.ObjId;
import org.modelio.vstore.exml.common.model.ObjIdName;

@objid ("24c77292-67ec-43bc-b58e-b75222a7e3f9")
public class HSqlCmsNodeIndex implements ICmsNodeIndex {
    @objid ("4ae825cf-f55b-4d87-a749-9f5c80a37330")
    private static final String SQL_GET_CMSNODE_CONTENT = "SELECT id, clsname, name FROM \"elements\" WHERE cmsnodeid=? AND cmsnodecls=?";

    @objid ("d0d6c44b-d1ca-43c4-a7f3-246a079d4784")
    private static final String SQL_GET_BY_MCLASS = "SELECT clsname, id, name from \"elements\" where clsname=?";

    @objid ("4c33bd5e-bdba-4a47-93a6-5cd32c63bc1b")
    private static final String SQL_SET_PARENT_OF_CMS_NODE = "MERGE INTO \"cmsnode\" as cmsnode USING (VALUES(?, ?, ?, ?)) "
                                + "   AS vals(id, clsname, parentid, parentcls) ON cmsnode.id = vals.id "
                                + "   WHEN MATCHED THEN UPDATE SET cmsnode.clsname = vals.clsname, cmsnode.parentid = vals.parentid, cmsnode.parentcls = vals.parentcls "
                                + "   WHEN NOT MATCHED THEN INSERT VALUES vals.id, vals.clsname, vals.parentid, vals.parentcls";

    @objid ("2ab9f882-8c31-43a8-a55b-e06f9ba2e6dd")
    private static final String SQL_DELETE_CMS_CHILDREN_OF = "DELETE FROM \"cmsnode\" WHERE parentid=?";

    @objid ("1145d7ca-e635-4d96-b90a-b68514f32c38")
    private static final String SQL_DELETE_OBJ_1 = "DELETE FROM \"elements\" WHERE id=? OR cmsnodeid=?";

    @objid ("e6372fcf-10e7-40cb-a1fa-2f1f2e72ef73")
    private static final String SQL_GET_CMS_NODE_PARENT = "SELECT p.parentid, e.clsname, e.name FROM \"cmsnode\" p, \"elements\" as e WHERE p.id=? and p.clsname=? and p.parentid = e.id";

    @objid ("c3a3f602-d58d-44a0-b249-c68b82c61265")
    private static final String SQL_GET_ELEMENT_NAME = "SELECT name FROM \"elements\" WHERE id = ? and clsname=?";

    @objid ("b39a2d5a-ff5b-4002-aad5-6bbda8f9a6d6")
    private static final String SQL_GET_CMSNODE = "SELECT c.cmsnodeid, c.cmsnodecls FROM \"elements\" as c WHERE c.id=? and c.clsname=?";

    @objid ("450941c6-c80a-4915-9510-86cb003644fb")
    private static final String SQL_GET_BY_NAME = "SELECT c.id, c.cmsnodeid, c.cmsnodecls FROM \"elements\" as c WHERE c.name=? and c.clsname=?";

    /**
     * Find only with an identifier, without metaclass.
     */
    @objid ("becd73ba-4220-43d6-b52a-7c7994966292")
    private static final String SQL_FIND_BY_ID = "SELECT c.clsname, c.name, c.cmsnodeid, c.cmsnodecls FROM \"elements\" as c WHERE c.id=? ";

    @objid ("96a2b112-4c15-49ac-9939-f9e1f846f847")
    private static final String SQL_ADD_OBJECT = "MERGE INTO \"elements\" as elements USING (VALUES(?, ?, ?, ?, ?)) "
                                + "   AS vals(id, clsname, name, cmsnodeid, cmsnodecls) ON elements.id = vals.id "
                                + "   WHEN MATCHED THEN UPDATE SET elements.name = vals.name, elements.clsname = vals.clsname, elements.cmsnodeid = vals.cmsnodeid, elements.cmsnodecls = vals.cmsnodecls "
                                + "   WHEN NOT MATCHED THEN INSERT VALUES vals.id, vals.clsname, vals.name, vals.cmsnodeid, vals.cmsnodecls";

    @objid ("c3f9a1ec-33c7-4591-be2d-cb12ce5d161b")
    private static final String SQL_GET_BY_MC = "SELECT id from \"elements\" where clsname=?";

    @objid ("8c7c4e2e-76c0-4170-ae00-fad26068983f")
    private final IBasicLogger log;

    @objid ("b42077da-a9a1-43bb-b612-dae3645e1b53")
    private final SqlOperationRunner sqlRunner;

    @objid ("0e6947c3-a651-4002-8cf2-428694c88573")
    private final SmMetamodel metamodel;

    @objid ("6a2eba9f-1c24-4c95-8460-c0572a04ba45")
    public HSqlCmsNodeIndex(final SqlOperationRunner sqlRunner, String projectName, SmMetamodel metamodel) {
        this.sqlRunner = sqlRunner;
        this.metamodel = metamodel;
        this.log = Log.getLogger();

        // table object : id, clsname, name, cmsnodeid, cmsnodecls
        //   idx : clsname
        //   idx : id
        //   idx : parentid+parentcls

        // table cmsnode : id, clsname, name, parentid, parentcls
        //   idx : clsname
        //   idx : id
        //   idx : parentid+parentcls
    }

    @objid ("3e430b4a-a874-47d2-90cc-f56f14948b52")
    @Override
    public void addCmsNode(final ObjIdName id) throws IndexException {
        addObject( new ObjId(id.classof, id.id), id);
    }

    @objid ("d602096f-ee79-42fd-86dd-3992d84dd713")
    @Override
    public void addObject(final ObjId cmsNodeId, final ObjIdName objectId) throws IndexException {
        this.sqlRunner.withPreparedIndexStatement(SQL_ADD_OBJECT, insertObjectSt -> {

            int i=1;
            // Truncate name if needed
            String lname = objectId.name;
            if (lname.length()> 1023)
                lname = lname.substring(0, 1023);

            insertObjectSt.setString(i++, objectId.id);
            insertObjectSt.setString(i++, objectId.classof.getQualifiedName());
            insertObjectSt.setString(i++, lname);
            insertObjectSt.setString(i++, cmsNodeId.id);
            insertObjectSt.setString(i++, cmsNodeId.classof.getQualifiedName());
            insertObjectSt.execute();
            return null;

        });
    }

    @objid ("44edf5f1-bb52-42e6-860d-3f34c7b0af05")
    @Override
    public Collection<String> getByMClass(SmClass cls) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_BY_MC, req_getByMClass -> {
            req_getByMClass.setString(1, cls.getQualifiedName());

            try (ResultSet res = req_getByMClass.executeQuery()) {

                Collection<String> ret = new ArrayList<>();
                while (res.next()) {
                    ret.add(res.getString(1));
                }
                return ret;
            }
        });
    }

    @objid ("201e1b44-d216-42fb-b691-742db841bd67")
    @Override
    public ObjId getCmsNodeOf(ObjId id) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_CMSNODE, req_getCmsNodeOf -> {
            req_getCmsNodeOf.setString(1, id.id);
            req_getCmsNodeOf.setString(2, id.classof.getQualifiedName());

            try (ResultSet res = req_getCmsNodeOf.executeQuery()) {
                if (res.next()) {
                    String parentId = res.getString(1);
                    String parentCls = res.getString(2);
                    //String parentName = res.getString(3);

                    return new ObjId(this.metamodel.getMClass(parentCls), parentId);
                }
                return null;
            }
        } );
    }

    @objid ("67204202-2c8d-442a-baed-74fc4655cbdd")
    @Override
    public IndexElement findById(String uuid) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_FIND_BY_ID, req_getCmsNodeOf -> {
            req_getCmsNodeOf.setString(1, uuid);

            try (ResultSet res = req_getCmsNodeOf.executeQuery()) {
                if (res.next()) {
                    int i = 1;
                    String elCls = res.getString(i++);
                    String elName = res.getString(i++);
                    String parentId = res.getString(i++);
                    String parentCls = res.getString(i++);

                    ObjId cmsNode = new ObjId(this.metamodel.getMClass(parentCls), parentId);
                    ObjIdName elId = new ObjIdName(this.metamodel.getMClass(elCls), elName, uuid);

                    return new IndexElement(elId, cmsNode);
                }
                return null;
            }
        } );
    }

    @objid ("16c4c3f7-c4e2-4f53-b7c8-a44a73153d3b")
    @Override
    public String getName(final ObjId id) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_ELEMENT_NAME, req_getName -> {
            req_getName.setString(1, id.id);
            req_getName.setString(2, id.classof.getQualifiedName());

            try (ResultSet res = req_getName.executeQuery()) {
                if (res.next()) {
                    return res.getString(1);
                }
                return null;
            }
        });
    }

    @objid ("34064060-2a23-4841-9fe0-175ea18eda00")
    @Override
    public ObjId getParentNodeOf(final ObjId id) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_CMS_NODE_PARENT, req_getParentNodeOf -> {
            req_getParentNodeOf.setString(1, id.id);
            req_getParentNodeOf.setString(2, id.classof.getQualifiedName());

            try (ResultSet res = req_getParentNodeOf.executeQuery()) {
                if (res.next()) {
                    String parentId = res.getString(1);
                    String parentCls = res.getString(2);

                    return new ObjId(this.metamodel.getMClass(parentCls), parentId);
                }
                return null;
            }

        });
    }

    @objid ("a2893241-a7d1-494d-a7fd-99b77f56fdde")
    @Override
    public boolean isEmpty() {
        try {
            return this.sqlRunner.withPreparedIndexStatement("SELECT COUNT(*) FROM \"elements\"", st -> {
                try(ResultSet res = st.executeQuery();) {
                    if (res.next()) {
                        return res.getInt(1) <= 0;
                    } else {
                        return false;
                    }
                }
            } );
        } catch (IndexException e) {
            this.log.warning(e.getLocalizedMessage(), e);
            return true;
        }
    }

    @objid ("b2b740e9-3b7e-44bd-91de-5ac7765fae9b")
    @Override
    public boolean isStored(final ObjId id) throws IndexException {
        return getCmsNodeOf(id) != null;
    }

    @objid ("9b8e7253-4765-45a5-86cc-c43cd67afb95")
    @Override
    public void removeObj(final ObjId id) throws IndexException {
        this.sqlRunner.withPreparedIndexStatement(SQL_DELETE_OBJ_1, st -> {
            st.setString(1, id.id);
            st.setString(2, id.id);
            st.executeUpdate();
            return null;
        });

        this.sqlRunner.withPreparedIndexStatement(SQL_DELETE_CMS_CHILDREN_OF, st -> {
            st.setString(1, id.id);
            st.executeUpdate();
            return null;
        });
    }

    @objid ("b56b76cc-ac5c-47ed-a4fa-e5fddb8f8287")
    @SuppressWarnings("resource")
    @Override
    public void setParent(final ObjId cmsNodeId, final ObjId parentId) throws IndexException {
        //final String sql0 = "INSERT INTO \"cmsnode\" (id, clsname, parentid, parentcls) values (?, ?, ?, ?)";
        this.sqlRunner.withPreparedIndexStatement(SQL_SET_PARENT_OF_CMS_NODE, insertCmsNodeSt -> {
            try {
                int i = 1;
                insertCmsNodeSt.setString(i++, cmsNodeId.id);
                insertCmsNodeSt.setString(i++, cmsNodeId.classof.getQualifiedName());
                insertCmsNodeSt.setString(i++, parentId.id);
                insertCmsNodeSt.setString(i++, parentId.classof.getQualifiedName());
                insertCmsNodeSt.executeUpdate();
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                ObjId oldParentId;
                try {
                    oldParentId = getParentNodeOf(cmsNodeId);
                } catch (IndexException e1) {
                    e.addSuppressed(e1);
                    throw e;
                }
                if (! Objects.equals(parentId, oldParentId)) {
                    e.addSuppressed(new Throwable(String.format("%s parent is already %s, cannot set parent to %s.", cmsNodeId, oldParentId, parentId)));
                    throw e;
                }
                this.log.trace("setParent(%s, %s): parent already set, ignore call", cmsNodeId, parentId);
            }
            return null;
        });
    }

    @objid ("be6bcb75-8423-4e7b-b6c2-f03b0147cd82")
    @Override
    public Stream<ObjIdName> idByMClass(SmClass cls) throws StreamException, IndexException {
        try {
            return this.sqlRunner.streamPreparedSqlStatement(
                    SQL_GET_BY_MCLASS,
                    req-> req.setString(1, cls.getQualifiedName()))
            .map(res -> {
                try {
                    return new ObjIdName(
                            this.metamodel.getMClass(res.getString(1)),
                            res.getString(3),
                            res.getString(2));
                } catch (SQLException e) {
                    throw new StreamException(e);
                }
            } );
        } catch (SQLException e1) {
            throw this.sqlRunner.translateSqlException(e1);
        }
    }

    @objid ("65416c88-a371-4011-8d91-48bf4b99b9bf")
    @Override
    public Collection<IndexElement> findByName(SmClass cls, String name) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_BY_NAME, st -> {
            st.setString(1, name);
            st.setString(2, cls.getQualifiedName());
            try (ResultSet res = st.executeQuery();) {
                Collection<IndexElement> ret = new ArrayList<>(100);
                while (res.next()) {
                    ret.add( new IndexElement(
                            new ObjIdName(cls, name, res.getString(1)),
                            new ObjId(this.metamodel.getMClass(res.getString(3)), res.getString(2))));
                }
                return ret;
            }
        });
    }

    @objid ("4037a52e-4115-42e1-b599-ff11596063d1")
    @Override
    public Collection<ObjId> getCmsNodeContent(ObjId cmsNodeId) throws IndexException {
        return this.sqlRunner.withPreparedIndexStatement(SQL_GET_CMSNODE_CONTENT, st -> {
            st.setString(1, cmsNodeId.id);
            st.setString(2, cmsNodeId.classof.getQualifiedName());
            try (ResultSet res = st.executeQuery();) {
                Collection<ObjId> ret = new ArrayList<>(100);
                while (res.next()) {
                    ret.add(new ObjId(
                            this.metamodel.getMClass(res.getString(2)),
                            res.getString(1)));
                }
                return ret;
            }
        });
    }

    @objid ("1645568c-e4d9-44d7-9499-f319a171658a")
    @Deprecated
    private static class ResultSetIterator implements Iterator<ResultSet> {
        @objid ("8340ec18-f1ff-4ade-b0f7-d2a93316aea0")
        private int state;

        @objid ("80191ea7-2a27-4c0f-9b6a-ede3e6f0b681")
        private final ResultSet resultSet;

        @objid ("e86e366e-0f35-42db-bffc-52967da01cd5")
        private ResultSetIterator(ResultSet resultSet) {
            this.resultSet = resultSet;
            this.state = 0;
        }

        @objid ("002325d4-309e-4e6e-9187-416d3239a616")
        private void advance() {
            if (this.state == 1) {
                return;
            } else if (this.state == 0) {
                try {
                    if (this.resultSet.next()) {
                        this.state = 1;
                    } else {
                        this.state = 2;
                    }
                } catch (SQLException e) {
                    this.state = 2;
                    throw new StreamException(e);
                }
            }
        }

        @objid ("5deb8db7-b5c1-4484-bf64-bbee9795bba1")
        @Override
        public boolean hasNext() {
            advance();
            return this.state==1;
        }

        @objid ("872acaa1-262c-47cc-9909-b8a8bb83f513")
        @Override
        public ResultSet next() {
            advance();
            if (this.state == 1) {
                this.state = 0;
                return this.resultSet;
            }

            if (this.state==2) {
                throw new NoSuchElementException();
            } else {
                throw new IllegalStateException(String.format("Unexpected state : %d", this.state));
            }
        }

    }

}
