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
package org.modelio.vstore.exml.json.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.files.FileUtils;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.model.DuplicateObjectException;
import org.modelio.vcore.session.impl.storage.IModelLoader;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vstore.exml.common.ExmlStorageHandler;
import org.modelio.vstore.exml.common.ILoadHelper;
import org.modelio.vstore.exml.common.index.IndexException;
import org.modelio.vstore.exml.common.model.IllegalReferenceException;
import org.modelio.vstore.exml.common.model.ObjId;
import org.modelio.vstore.exml.common.model.ObjIdName;
import org.modelio.vstore.exml.common.utils.ExmlUtils;
import org.modelio.vstore.exml.local.loader.IExmlLoader;
import org.xml.sax.InputSource;

/**
 * JSON model loader.
 * <p>
 * Usage: instantiate and the call {@link #load(InputSource, IModelLoader)} for each EXML file in the repository.
 * <p>
 * Note : this class is not thread safe nor reentrant.
 *
 * @since 5.5
 */
@objid ("f103ce38-d34e-445c-b05f-e7ed7522c9f1")
public class JsonModelParser implements IExmlLoader {
    @objid ("2dc41702-2e16-45a8-81ec-9f7227fe4452")
    private ILoadHelper loadHelper;

    @objid ("39769397-677f-4ec3-afc9-6f0829952acc")
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Initialize the SAX loader.
     *
     * @param loadHelper a load helper
     */
    @objid ("dbdb16c6-4699-47d7-a84c-eee17bd36b92")
    public JsonModelParser(ILoadHelper loadHelper) {
        this.loadHelper = loadHelper;
    }

    /**
     * Load an JSON EXML resource from an XML {@link InputSource}.
     *
     * @param is the EXML source.
     * @param modelLoader the API to use to load the content.
     * @return the loaded CMS node.
     * @throws DuplicateObjectException if another object with the same identifier as a loaded object already exists in another repository.
     * @throws IOException in case of failure
     */
    @objid ("b1e810aa-61de-4ca0-8ae2-522cb58aa1bc")
    @Override
    public SmObjectImpl load(final InputSource is, IModelLoader modelLoader) throws DuplicateObjectException, IOException {
        return new ParseTask(modelLoader, this.loadHelper).load(is);
    }

    @objid ("f2134f8c-bbb1-4e69-97d6-895d936a861a")
    private static class ParseTask {
        @objid ("55e3344e-9c5c-4e53-8184-2abb8ee5cbe0")
        private final IModelLoader modelLoader;

        @objid ("5c8bde45-aee1-4946-8a23-459c8fd4ebc6")
        private final ILoadHelper loadHelper;

        @objid ("ad4ced32-3cc8-40f3-8367-0e4491663c10")
        private ExmlStorageHandler nodeStorageHandler;

        /**
         *
         * @param modelLoader the API to use to load the content.
         * @param loadHelper a load helper
         */
        @objid ("407bc497-d50d-432a-bbdf-9f3232f24c84")
        public ParseTask(IModelLoader modelLoader, ILoadHelper loadHelper) {
            this.modelLoader = modelLoader;
            this.loadHelper = loadHelper;
        }

        /**
         * Load an EXML resource from an XML {@link InputSource}.
         *
         * @param is the EXML source.
         * @return the loaded CMS node.
         * @throws DuplicateObjectException if another object with the same identifier as a loaded object already exists in another repository.
         * @throws IOException in case of failure
         */
        @objid ("60435574-0d65-4e4e-9eca-7b8663d0b25e")
        public SmObjectImpl load(final InputSource is) throws DuplicateObjectException, IOException {
            try {
                JsonNode jsTree = objectMapper.readTree(is.getByteStream());

                ObjIdName rootRef = readObjIdName(jsTree);

                SmObjectImpl rootObj = pushRootOBJECT(rootRef);

                ObjectNode content = (ObjectNode) jsTree.with("content");

                List<Map.Entry<JsonNode, SmObjectImpl>> loadedList = new ArrayList<>(content.size());
                for (JsonNode objNode : content) {
                    ObjIdName ref = readObjIdName(objNode);

                    try {
                        SmObjectImpl obj = pushObject(ref);
                        if (obj != null) {
                            // load attributes
                            ObjectNode attsNode = (ObjectNode) objNode.with("atts");
                            for (Iterator<Entry<String, JsonNode>> it = attsNode.fields(); it.hasNext();) {
                                Entry<String, JsonNode> attEn = it.next();
                                String attName = attEn.getKey();
                                this.loadHelper.doLoadAtt(this.modelLoader, obj, attName, attEn.getValue().asText());
                            }

                            loadedList.add(Map.entry(objNode, obj));

                            this.loadHelper.initObjectFlags(this.modelLoader, obj);

                        }
                    } catch (IndexException e) {
                        this.loadHelper.loadFailed(rootObj, this.modelLoader, e);
                    }
                }

                // load deps
                for (Entry<JsonNode, SmObjectImpl> entry : loadedList) {
                    loadObjDeps(entry.getKey(), entry.getValue());
                }

                return rootObj;
            } catch (IOException e) {
                String msg = is.getPublicId()+": "+FileUtils.getLocalizedMessage(e);
                throw new IOException (msg, e);
            } catch (Error | RuntimeException e) {
                // just add a debugging exception and rethrow
                e.addSuppressed(new Throwable("Error occurred while reading '"+is.getPublicId()+"'"));
                throw e;
            }
        }

        @objid ("c26da81b-4cbc-499d-abdd-395b81583390")
        protected ObjIdName readObjIdName(JsonNode jsTree) throws IOException {
            JsonNode nameNode = jsTree.get("name");
            String objName = nameNode != null ? nameNode.asText() : null;
            String mcName = jsTree.path("mc").asText();
            String uuid = jsTree.path("uuid").asText();

            if (mcName.isEmpty() || uuid.isEmpty()) {
                throw new IOException("Broken object identifier: "+ jsTree.toPrettyString());
            }

            return new ObjIdName(
                    this.loadHelper.getSmClass(mcName),
                    objName,
                    uuid);
        }

        @objid ("3f7b5af1-5bd1-4e58-99bc-7ce7c295288d")
        private void loadObjDeps(JsonNode objNode, SmObjectImpl obj) throws IOException, DuplicateObjectException {
            ObjectNode depsNode = (ObjectNode) objNode.with("deps");
            Collection<SmDependency> loadedDeps = new HashSet<>(depsNode.size());
            SmClass mc = obj.getClassOf();

            for (Iterator<Entry<String, JsonNode>> it = depsNode.fields(); it.hasNext();) {
                Entry<String, JsonNode> depEn = it.next();
                SmDependency dep = mc.getDependencyDef(depEn.getKey());
                JsonNode jsVals = depEn.getValue();
                boolean isTargetAlwaysInSameRepository = dep.isComposition() || (dep.isCompositionOpposite() && ! dep.getSymetric().isSharedComposition());

                if (! ExmlUtils.isDepToSerialize(dep)) {
                    // buggy JSON file, skip dependency
                    Log.trace("%s: Found non serializable %s dep with %d elements in %s in %s , ignore it .", JsonModelParser.class.getSimpleName(), dep, jsVals.size(), obj, this.nodeStorageHandler );
                    continue;
                }

                loadedDeps.add(dep);


                List<SmObjectImpl> depVals = new ArrayList<>(jsVals.size());

                for (JsonNode valNode : jsVals) {
                    ObjIdName valRef = readObjIdName(valNode);

                    SmObjectImpl val = this.loadHelper.getLoadedObject(valRef.toObjId());
                    if (val == null) {
                        try {
                            if (isTargetAlwaysInSameRepository) {
                                val = this.loadHelper.createStubObject(this.modelLoader, valRef, true);
                                if (dep.isComposition() && valRef.classof.isCmsNode()) {
                                    ((ExmlStorageHandler)val.getRepositoryObject()).setParentLoaded(true);
                                }
                            } else {
                                val = this.loadHelper.getRefObject(this.modelLoader, valRef);
                            }
                        } catch (IllegalReferenceException | IndexException e) {
                            this.loadHelper.loadFailed(obj, this.modelLoader, e);
                        }
                    }

                    if (val != null) {
                        depVals.add(val);
                    }
                }

                this.modelLoader.loadDependency(obj, dep, depVals);
            }

            for (SmDependency dep : ExmlUtils.getExternalisableDeps(obj)) {
                if (! loadedDeps.contains(dep)) {
                    this.modelLoader.loadDependency(obj, dep, Collections.emptyList());
                }
            }
        }

        @objid ("a6032928-0e87-4734-9c4e-bdf922cab4e4")
        private SmObjectImpl pushObject(ObjIdName objidName) throws DuplicateObjectException, IndexException {
            ObjId objid = objidName.toObjId();
            SmObjectImpl obj = this.loadHelper.getLoadedObject(objid);

            if (obj != null) {
                // Already loaded from this repository
                IRepositoryObject objHandler = obj.getRepositoryObject();
                if (objHandler != this.nodeStorageHandler) {
                    // This object moved here from another CMS node or is stored in many EXML files.
                    ObjId realParent = this.loadHelper.getCmsNodeId(objid);
                    if (realParent.equals(this.nodeStorageHandler.getCmsNodeId())) {
                        // The object moved here, change its storage handler
                        obj.setRepositoryObject(this.nodeStorageHandler);
                    } else {
                        // This can happen only for object that are saved in more than 1 EXML file
                        // (Association, Link, Constraint)
                        // It should never happen for other objects.
                        return null;
                    }
                }
            } else if (true) {
                // Not loaded but we know it is present in repository
                obj = this.loadHelper.createObject(this.modelLoader, objid, this.nodeStorageHandler);
                // Code below is deprecated, to be deleted if everything works even with Assoc, Link, Constraint
            } else if (this.loadHelper.isStored(objid)) {
                // Not loaded but present in repository

                obj = this.loadHelper.createObject(this.modelLoader, objid, this.nodeStorageHandler);

            } else {
                // Comes from another repository.
                // This can happen only for object that are saved in more than 1 EXML file
                // (Association, Link, Constraint)
                // It should never happen for other objects.
                obj = this.loadHelper.getForeignObject(this.modelLoader, objidName);
                // ignore the object
                return null;
            }
            return obj;
        }

        @objid ("1255ae78-bbef-4d39-913a-5a2dfe64aba9")
        private final SmObjectImpl pushRootOBJECT(ObjIdName objid) throws DuplicateObjectException {
            if (objid == null) {
                return null;
            }

            SmObjectImpl obj = this.loadHelper.getLoadedObject(objid.toObjId());

            if (obj != null) {
                assert (obj.getClassOf().isCmsNode());

                this.nodeStorageHandler = (ExmlStorageHandler) (obj.getRepositoryObject());
                this.nodeStorageHandler.setLoaded(true);
            } else {
                obj = this.loadHelper.createObject(this.modelLoader, objid.toObjId(), null);

                assert (obj.getClassOf().isCmsNode());

                this.nodeStorageHandler = this.loadHelper.createStorageHandler(obj, true);
                obj.setRepositoryObject(this.nodeStorageHandler);
            }
            return obj;
        }

    }

}
