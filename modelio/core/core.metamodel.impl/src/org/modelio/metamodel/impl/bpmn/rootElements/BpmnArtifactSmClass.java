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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnSubProcessSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnCollaborationSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnProcessSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a0fecca7-2a0e-44e5-9042-68ec6e233e00")
public class BpmnArtifactSmClass extends BpmnBaseElementSmClass {
    @objid ("50023f4b-314b-49f9-9192-9a9ae3939b88")
    private SmDependency subProcessDep;

    @objid ("bc055887-ba6e-430e-9c6b-b74bdee82fb5")
    private SmDependency collaborationDep;

    @objid ("c9ff319c-ae94-41aa-9fd2-9309e233c228")
    private SmDependency processDep;

    @objid ("03905aaa-d3ae-49f7-ae7c-2f6b5aabf780")
    public BpmnArtifactSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("119a6b66-ca96-45f2-be6c-fbac395c7343")
    @Override
    public String getName() {
        return "BpmnArtifact";

    }

    @objid ("abc63050-a77a-43e5-9f9b-f215ab0c7819")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("16c86690-861e-42fd-b739-5917a7d769b5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnArtifact.class;

    }

    @objid ("37a20f0e-3a55-4dbb-bd04-b56d043ca5bd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c650d5fa-b66f-41c7-b275-cf9fb4d62de3")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("5372e3c5-8c33-4a70-925f-f4dcb6182cd7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnArtifactObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.subProcessDep = new SubProcessSmDependency();
        this.subProcessDep.init("SubProcess", this, metamodel.getMClass(BpmnSubProcess.MQNAME), 0, 1 );
        registerDependency(this.subProcessDep);

        this.collaborationDep = new CollaborationSmDependency();
        this.collaborationDep.init("Collaboration", this, metamodel.getMClass(BpmnCollaboration.MQNAME), 0, 1 );
        registerDependency(this.collaborationDep);

        this.processDep = new ProcessSmDependency();
        this.processDep.init("Process", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 );
        registerDependency(this.processDep);

    }

    @objid ("27a28ab1-95e4-4f4c-9df5-617c145dee35")
    public SmDependency getSubProcessDep() {
        if (this.subProcessDep == null) {
        	this.subProcessDep = this.getDependencyDef("SubProcess");
        }
        return this.subProcessDep;
    }

    @objid ("c4a380db-1004-46f1-8eab-f479e3049f74")
    public SmDependency getCollaborationDep() {
        if (this.collaborationDep == null) {
        	this.collaborationDep = this.getDependencyDef("Collaboration");
        }
        return this.collaborationDep;
    }

    @objid ("9bd8c95b-24e5-4d0f-b7f4-31285009e6e1")
    public SmDependency getProcessDep() {
        if (this.processDep == null) {
        	this.processDep = this.getDependencyDef("Process");
        }
        return this.processDep;
    }

    @objid ("b2130f92-fa36-4160-9219-d1296cfe8853")
    private static class BpmnArtifactObjectFactory implements ISmObjectFactory {
        @objid ("b8842b77-feed-4c62-b236-e49812ce28dd")
        private BpmnArtifactSmClass smClass;

        @objid ("2e9d0691-0104-4edb-b643-e13e6e5ac9b0")
        public BpmnArtifactObjectFactory(BpmnArtifactSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b99acce1-2558-40ca-ac84-fbcf68707938")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("e5ec1c10-1dd7-4de8-84de-fcd62068b891")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("84bde060-8f13-495b-856b-5124db653b9f")
    public static class SubProcessSmDependency extends SmSingleDependency {
        @objid ("d9e6c8ee-22f6-40e2-a2cb-4119b7d5120f")
        private SmDependency symetricDep;

        @objid ("f6cd6658-1957-4f3c-b3cb-30451e2bc439")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnArtifactData) data).mSubProcess;
        }

        @objid ("09ea6555-db4c-4399-9f4f-3eb3c54daa07")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnArtifactData) data).mSubProcess = value;
        }

        @objid ("b938f9f9-a05a-4559-a01c-f9078fcf7683")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSubProcessSmClass)this.getTarget()).getArtifactDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cc420b2c-dd9d-499c-ba87-f4ecf630bdf1")
    public static class CollaborationSmDependency extends SmSingleDependency {
        @objid ("ea382608-9838-4f89-9cf5-5410c45e6433")
        private SmDependency symetricDep;

        @objid ("49be7647-e170-4f3d-83e5-f2f2d1b1f730")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnArtifactData) data).mCollaboration;
        }

        @objid ("9f70504e-5266-4dc9-a782-f4c10376938f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnArtifactData) data).mCollaboration = value;
        }

        @objid ("3d2d0d00-fa1c-4c56-adf1-2b59d9dc72fd")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCollaborationSmClass)this.getTarget()).getArtifactDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("401b0419-13da-428e-b88e-69b78957b6f4")
    public static class ProcessSmDependency extends SmSingleDependency {
        @objid ("194a96eb-8002-456d-bae5-087789ccd168")
        private SmDependency symetricDep;

        @objid ("fc34668e-3b33-4909-9b2f-f62ed4dcfd3f")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnArtifactData) data).mProcess;
        }

        @objid ("bd9e7cf5-8fde-4ea8-b25d-bcc0de4f329a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnArtifactData) data).mProcess = value;
        }

        @objid ("734863a0-da2f-46c5-b836-4c781e5d5fc8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getArtifactDep();
            }
            return this.symetricDep;

        }

    }

}
