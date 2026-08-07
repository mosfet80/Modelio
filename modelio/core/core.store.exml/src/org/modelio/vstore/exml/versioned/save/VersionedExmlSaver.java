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
package org.modelio.vstore.exml.versioned.save;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.xml.CloseableXMLStreamWriter;
import org.modelio.vcore.session.api.repository.StorageErrorSupport;
import org.modelio.vcore.session.impl.storage.nullz.NullRepository;
import org.modelio.vcore.smkernel.DeadObjectException;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.SmLiveId;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MStatus;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vstore.exml.common.ExmlStorageHandler;
import org.modelio.vstore.exml.common.model.ExmlTags;
import org.modelio.vstore.exml.common.utils.ExmlUtils;
import org.modelio.vstore.exml.plugin.VStoreExml;
import org.modelio.vstore.exml.resource.IExmlResourceProvider.ExmlResource;

/**
 * Save a CMS node in an EXML file.
 */
@objid ("3de290fb-121a-11e2-816a-001ec947ccaf")
public class VersionedExmlSaver implements ExmlTags {
    /**
     *
     * @since 3.6 14/12/2016
     */
    @objid ("5754417a-592b-4fd3-8e90-5423ff1a1701")
    private static final boolean REFOBJ_SANITY_CHECK = false;

    @objid ("3de2910d-121a-11e2-816a-001ec947ccaf")
    private XMLStreamWriter out;

    @objid ("4c05400f-1224-11e2-816a-001ec947ccaf")
    private LocalSaver localSaver = null;

    @objid ("bf3d5873-921d-4dea-9c2c-a31216106fc0")
    private StorageErrorSupport errSupport;

    @objid ("3de290fe-121a-11e2-816a-001ec947ccaf")
    private static SmObjectImpl getParentExt(final SmObjectImpl object) {
        SmObjectImpl parent = object.getCompositionOwner();
        while (parent != null && !parent.getClassOf().isCmsNode()) {
            parent = parent.getCompositionOwner();
        }
        return parent;
    }

    /**
     * Constructor.
     *
     * @param errSupport to report errors.
     */
    @objid ("3de290ff-121a-11e2-816a-001ec947ccaf")
    public VersionedExmlSaver(StorageErrorSupport errSupport) {
        this.errSupport = errSupport;
    }

    /**
     * Save the given CMS node.
     *
     * @param object a CMS node
     * @param os an output stream for the versioned part
     * @param localResource an output stream for the non versioned part
     * @throws IOException in case of failure.
     */
    @objid ("3de29100-121a-11e2-816a-001ec947ccaf")
    public void externalize(final SmObjectImpl object, final OutputStream os, final ExmlResource localResource) throws IOException {
        // Note : http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        // In a try-with-resources statement, any catch or finally block
        // is run after the resources declared have been closed.
        try (CloseableXMLStreamWriter closeableWriter = new CloseableXMLStreamWriter(os, ExmlTags.INDENT_FILES);
                LocalSaver aLocalSaver = new LocalSaver(localResource)){

            this.localSaver = aLocalSaver;
            this.out = closeableWriter.getW();

            this.out.writeStartDocument();
            this.out.writeComment("GENERATED FILE, PLEASE DO NOT EDIT!!!");

            dumpEXT(object);
        } catch (FactoryConfigurationError e) {
            throw new IOException(e);
        } catch (XMLStreamException e) {
            throw new IOException(e);
        } finally {
            this.out = null;
            this.localSaver = null;
        }
    }

    @objid ("3de29101-121a-11e2-816a-001ec947ccaf")
    private final void dumpOBJECT(final SmObjectImpl object, Collection<SmObjectImpl> recursionContext, boolean withPid) throws XMLStreamException {
        if (recursionContext.contains(object)) {
            // Object already being externalized, skip it
            return;
        }

        // Process it, add it to context
        recursionContext.add(object);


        this.out.writeStartElement(TAG_OBJECT);

        dumpID(TAG_ID, object);
        if (withPid) {
            SmObjectImpl parent = getParentExt(object);
            if (parent != null) {
                dumpID(TAG_CMSNODE_PID, parent);
            }
        }

        dumpATTRIBUTES(object);
        dumpDEPENDENCIES(object, recursionContext);

        this.out.writeEndElement();

        // // Processed, remove from context
        // recursionContext.remove(object);
    }

    @objid ("3de29102-121a-11e2-816a-001ec947ccaf")
    private void dumpATT(final SmObjectImpl object, final SmAttribute att) throws XMLStreamException {
        this.out.writeStartElement(TAG_ATT);
        this.out.writeAttribute(ATT_NAME, att.getName());

        Object attVal = object.getAttVal(att);
        if (attVal == null) {
            //TODO what to do ??
        } else {
            String stringVal = attVal.toString();
            if (att.getType() == String.class) {
                if (!stringVal.isEmpty()) {
                    this.out.writeCData(getCDataForm(stringVal));
                }
            } else {
                this.out.writeCharacters(stringVal);
            }
        }
        this.out.writeEndElement();
    }

    @objid ("3de29103-121a-11e2-816a-001ec947ccaf")
    private void dumpATTRIBUTES(final SmObjectImpl object) throws XMLStreamException {
        this.out.writeStartElement(TAG_ATTRIBUTES);

        for (SmAttribute att : object.getClassOf().getAllAttDef()) {
            dumpATT(object, att);
        }
        this.out.writeEndElement();
    }

    @objid ("3de29104-121a-11e2-816a-001ec947ccaf")
    private void dumpCOMPS(final SmObjectImpl object, final SmDependency dep, final List<SmObjectImpl> targets, Collection<SmObjectImpl> recursionContext) throws XMLStreamException {
        boolean tagWritten = false;
        List<SmObjectImpl> localTargets = null;
        IRepositoryObject objectHandle = object.getRepositoryObject();

        for (SmObjectImpl target : targets) {
            // FIXME Desperate attempt to resolve wrong repository (LazyLoadingRepository ?)
            target.getSmStatusFlags();

            if (! ExmlUtils.sameRepository(object, target)) {
                // Unexpected case, should never happen
                reportCompToForeign(object, dep, object, false);
                tagWritten = writeCompTag(tagWritten, dep );
                dumpID(TAG_FOREIGNID, target);
            } else if (target.getClassOf().isCmsNode()) {
                MStatus status = target.getStatus();
                if (status.isCmsManaged() || status.isCmsToAdd()) {
                    tagWritten = writeCompTag(tagWritten, dep );
                    dumpID(TAG_COMPID, target);
                } else {
                    if (localTargets == null) {
                        localTargets = new ArrayList<>(3);
                    }
                    localTargets.add(target);
                }
            } else if (recursionContext.contains(target) ) {
                // composed by value but already externalized, ref it
                tagWritten = writeCompTag(tagWritten, dep );
                dumpID(TAG_COMPID, target);
            } else if (safeGetRepositoryObject(target) == NullRepository.getInstance()) {
                // Orphan object, report it and forget
                reportRefToOrphan(object,dep, target);
            } else if (safeGetRepositoryObject(target) != objectHandle) {
                // Different handle ==> different file
                // This should happen only on Associations and LinkEnd and Constraints and Connectors
                tagWritten = writeCompTag(tagWritten, dep );
                if (isComplexCompositionMetaclass(target)) {
                    // Expected case, write a reference to the object
                    assert (target.getRepositoryObject() instanceof ExmlStorageHandler) : String.format("Broken object: %s has %s as storage handler while saving %s->%s", target, target.getRepositoryObject(), object, dep);
                    dumpREFOBJ(object, dep, target);
                } else {
                    // Unexpected case, report it and dump the whole object anyway
                    reportCompToForeign(object, dep, target, false);
                    dumpOBJECT( target, recursionContext, false);
                }
            } else {
                // composed by value, recursive call
                tagWritten = writeCompTag(tagWritten, dep );
                dumpOBJECT( target, recursionContext, false);
            }

        }

        if (tagWritten) {
            this.out.writeEndElement();
        }

        if (localTargets != null) {
            this.localSaver.dumpCompId(object, dep, localTargets);
        }
    }

    @objid ("2f7526ad-fa8d-41a2-aada-2abfc2d7426c")
    private static boolean isComplexCompositionMetaclass(SmObjectImpl obj) {
        String qname = obj.getMClass().getQualifiedName();
        switch (qname) {
            case "Standard.AssociationEnd":
            case "Standard.Association":
            case "Standard.LinkEnd":
            case "Standard.Link":
            case "Standard.Constraint":
            case "Standard.Connector":
            case "Standard.ConnectorEnd":
                return true;
        }
        return false;
    }

    /**
     * Write the object SmDependencies.
     *
     * @param object the CMS node
     * @param recursionContext to avoid cycles.
     * @throws XMLStreamException in case of XML writing error.
     */
    @objid ("3de29105-121a-11e2-816a-001ec947ccaf")
    private void dumpDEPENDENCIES(final SmObjectImpl object, Collection<SmObjectImpl> recursionContext) throws XMLStreamException {
        this.out.writeStartElement(TAG_DEPENDENCIES);

        List<SmDependency > dependencies = ExmlUtils.getExternalisableDeps(object);

        for (SmDependency dep : dependencies) {

            List<SmObjectImpl> content = object.getDepValList(dep);

            if (! content.isEmpty()) {
                if (ExmlUtils.isDepComponent(dep)) {
                    dumpCOMPS(object, dep, content, recursionContext);
                } else {
                    dumpLINKS(object, dep, content);
                }
            }
        }

        this.out.writeEndElement();
    }

    /**
     * Write the root {@link ExmlTags#TAG_EXT} node.
     *
     * @param object the CMS node
     * @throws XMLStreamException on failure
     */
    @objid ("3de29107-121a-11e2-816a-001ec947ccaf")
    private void dumpEXT(final SmObjectImpl object) throws XMLStreamException {
        this.out.writeStartElement(TAG_EXT);
        this.out.writeAttribute(ATT_EXT_OBJECT, object.getName());
        this.out.writeAttribute(ATT_EXT_VERSION, String.valueOf(FORMAT_VERSION));

        this.localSaver.begin(object);

        dumpCmsNodeOBJECT(object);

        this.out.writeEndElement();
    }

    @objid ("3de29109-121a-11e2-816a-001ec947ccaf")
    private void dumpID(final String xmlkey, final MObject object) throws XMLStreamException {
        this.out.writeEmptyElement(xmlkey);
        try {
            this.out.writeAttribute(ATT_ID_NAME, object.getName());
        } catch (DeadObjectException e) {
            this.out.writeAttribute(ATT_ID_NAME, "*dead*");
        } catch (NullPointerException e) {
            // Should not happen
            if (object == null)
                throw e;
            // ... This happened once :( log for debugging.
            this.out.writeAttribute(ATT_ID_NAME, "");
            Log.warning(new IllegalArgumentException(String.format("%s name is null", object), e));
        }

        this.out.writeAttribute(ATT_ID_MC, object.getMClass().getQualifiedName());
        this.out.writeAttribute(ATT_ID_UID, object.getUuid().toString());
        //out.writeEndElement();
    }

    @objid ("3de2910a-121a-11e2-816a-001ec947ccaf")
    private void dumpLINKS(final SmObjectImpl object, final SmDependency dep, final List<SmObjectImpl> targets) throws XMLStreamException {
        this.out.writeStartElement(TAG_LINK);
        this.out.writeAttribute(ATT_RELATION, dep.getName());
        for (SmObjectImpl t : targets) {
            if (!ExmlUtils.sameRepository(t, object)) {
                dumpID(TAG_FOREIGNID, t);
            } else if (t.getClassOf().isCmsNode()) {
                dumpID(TAG_ID, t);
            } else {
                dumpREFOBJ(object, dep, t);
            }
        }
        this.out.writeEndElement();
    }

    @objid ("3de2910b-121a-11e2-816a-001ec947ccaf")
    private final void dumpCmsNodeOBJECT(final SmObjectImpl object) throws XMLStreamException {
        dumpOBJECT(object, new HashSet<SmObjectImpl>(), true);
    }

    @objid ("3de2910c-121a-11e2-816a-001ec947ccaf")
    private void dumpREFOBJ(final SmObjectImpl from, final SmDependency dep, final SmObjectImpl object) throws XMLStreamException {
        if (REFOBJ_SANITY_CHECK) {
            // Model sanity check : check 'object' is in an EXML repository and is not orphan
            boolean valid = true;
            IRepositoryObject repositoryObject = safeGetRepositoryObject(object);
            if (repositoryObject instanceof ExmlStorageHandler) {
                ExmlStorageHandler h = (ExmlStorageHandler) repositoryObject;
                MObject parent = h.getCmsNode();
                valid = (parent != null) ;
            } else {
                valid = false;
            }

            // Write the ID only if the model is valid
            if (valid) {
                dumpID(TAG_ID, object);
            } else {
                // The model is broken
                reportRefToOrphan(from, dep, object);
            }
        } else {
            // Write always the id.
            dumpID(TAG_ID, object);
        }
    }

    /**
     * Split all CDATA end tags in 2 CDATA sections to avoid XML parse error.
     * This code must be obfuscated to avoid being itself broken on Modelio EXML save
     * in the case this method wouldn't work.
     * <p><code>
     * "&#x5d; &#x5d;&gt;" <b>---></b> "]"(1) <b>+</b> "&#x5d; &#x5d;&gt;&lt;![CDATA[" <b>+</b> "]&gt;"(2)
     * </code>
     *
     * @param aString a future CDATA string
     * @return a CDATA ready string
     */
    @objid ("3de2910e-121a-11e2-816a-001ec947ccaf")
    private static String getCDataForm(String aString) {
        // split all CDATA end tags in 2 CDATA sections to avoid XML parse error
        // This code must be obfuscated to avoid being itself broken on Modelio EXML save if this code doesn't work.
        // "&#x5d; &#x5d;&gt;" --> "]"(1) + "&#x5d; &#x5d;&gt;<![CDATA[" + "]>"(2)
        return aString.replace("]"+"]"+">", "]"+"]]"+"><![CDATA["+"]>");
    }

    @objid ("616e5792-79d7-426a-b7c1-c83510702852")
    private void reportRefToOrphan(final SmObjectImpl object, SmDependency dep, SmObjectImpl t) {
        String msg = t+" is not owned by any CMS node, it will be not saved. "+
                "It is referenced by "+object+"."+dep+" relation.";

        Throwable err = new IllegalArgumentException(msg);
        this.errSupport.fireWarning(err);
    }

    @objid ("14d771ba-9999-403e-af41-be5d28c60a7d")
    private void reportCompToForeign(final SmObjectImpl object, SmDependency dep, SmObjectImpl target, boolean logOnly) {
        IRepositoryObject objectRepositoryObject = safeGetRepositoryObject(object);
        IRepositoryObject targetRepositoryObject = safeGetRepositoryObject(target);
        String msg;
        try {
            Object[] args = {
                    object,
                    target,
                    dep,
                    objectRepositoryObject,
                    targetRepositoryObject ,
                    objectRepositoryObject.getRepositoryId(), targetRepositoryObject.getRepositoryId(),
                    object.getStatusLazy(), target.getStatusLazy(),
                    SmLiveId.getRid(object.getLiveId()),
                    SmLiveId.getRid(target.getLiveId())};

            msg = MessageFormat.format("""
                    Consistency error : {0} owns {1} through {2} , but they are not in the same repository .
                    - {0} storage is handled by {3} (rid={5})
                    - {1} storage is handled by {4} (rid={6})
                    - {0} status : {7} ; live rid = {9}
                    - {1} status : {8} ; live rid = {10}
                    """,
                    args);

            if (! ExmlUtils.areTargetsAlwaysInSameRepository(dep)) {
                Log.trace(msg);
                return;
            }

            Log.error(msg);

            Throwable err = new IllegalArgumentException(VStoreExml.I18N.getMessage("VersionedExmlSaver.reportCompToForeign", args));
            if (logOnly) {
                Log.error(err);
            } else {
                this.errSupport.fireWarning(err);
            }
        } catch (RuntimeException e) {
            Log.error(e);
            msg = MessageFormat.format("""
                    Consistency error : {0} owns {1} through {2} , but they are not in the same repository handle.
                    (Also an exception was thrown while formatting the message: {3})
                    """,
                    object, target, dep, e);
            if (logOnly) {
                Log.error(new IllegalStateException(msg, e));
            } else {
                this.errSupport.fireWarning(new IllegalStateException(msg, e));
            }
        }
    }

    /**
     * Write the COMP tag begin if not already done.
     *
     * @param written whether the tag has already been written.
     * @param dep the dependency
     * @return always <code>true</code>
     * @throws XMLStreamException in case of XML writing error.
     */
    @objid ("2f8c0032-a3c1-4d74-bab3-129bf4a54c62")
    private boolean writeCompTag(final boolean written, final SmDependency dep) throws XMLStreamException {
        if (! written) {
            this.out.writeStartElement(TAG_COMP);
            this.out.writeAttribute(ATT_RELATION, dep.getName());
        }
        return true;
    }

    @objid ("144660e9-6a12-4510-8dee-109cf0cc1872")
    private static IRepositoryObject safeGetRepositoryObject(SmObjectImpl target) {
        try {
            return target.getRepositoryObject();
        } catch (@SuppressWarnings ("unused") DeadObjectException e) {
            return  NullRepository.getInstance();
        }
    }

}
