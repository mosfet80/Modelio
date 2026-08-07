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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnParticipantSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6656867f-8de6-4af5-9946-c6cc4acc1e7c")
public class BpmnInterfaceSmClass extends BpmnSharedElementSmClass {
    @objid ("f0a987d8-be50-47ea-9eee-a01bc088912e")
    private SmDependency operationDep;

    @objid ("24e5cca9-11fe-453e-a632-83b08095d41a")
    private SmDependency participantRefDep;

    @objid ("966d37a1-7349-42a3-bb16-3df9a335eb03")
    public BpmnInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b509ff52-d471-4bba-8fdc-c3dbe597c313")
    @Override
    public String getName() {
        return "BpmnInterface";

    }

    @objid ("6e3a0017-99e4-44c4-b52c-086553e5351f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("4c52b30a-e87a-44c2-83fb-81ee569f0092")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnInterface.class;

    }

    @objid ("01db66f3-8e5a-442c-b73f-f5da95d35f65")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a5251718-70a8-42c8-91c5-1ea1927dc73b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("03ad81a1-33b3-4614-a85c-4fc64038fef8")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSharedElement.MQNAME);
        this.registerFactory(new BpmnInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.operationDep = new OperationSmDependency();
        this.operationDep.init("Operation", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.operationDep);

        this.participantRefDep = new ParticipantRefSmDependency();
        this.participantRefDep.init("ParticipantRef", this, metamodel.getMClass(BpmnParticipant.MQNAME), 0, -1 );
        registerDependency(this.participantRefDep);

    }

    @objid ("8b3c033c-3165-48dd-91ae-a9d5d27b26e9")
    public SmDependency getOperationDep() {
        if (this.operationDep == null) {
        	this.operationDep = this.getDependencyDef("Operation");
        }
        return this.operationDep;
    }

    @objid ("2c4590d7-dddf-458a-bfca-ff956faa3726")
    public SmDependency getParticipantRefDep() {
        if (this.participantRefDep == null) {
        	this.participantRefDep = this.getDependencyDef("ParticipantRef");
        }
        return this.participantRefDep;
    }

    @objid ("a6dac772-9968-40f2-85bb-9a038721c785")
    private static class BpmnInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("38eedb5d-70ba-4ddd-a492-6f1841590592")
        private BpmnInterfaceSmClass smClass;

        @objid ("3e3d2228-c7f3-4489-895b-aaf49d63965f")
        public BpmnInterfaceObjectFactory(BpmnInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("23bee63b-155f-427c-9cd8-29c44fd70769")
        @Override
        public ISmObjectData createData() {
            return new BpmnInterfaceData(this.smClass);
        }

        @objid ("ce6e2600-4e4d-408a-a424-9a0b317f25fc")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnInterfaceImpl();
        }

    }

    @objid ("13f6bfcd-dcd9-4e4a-b153-7ad57ac1d615")
    public static class OperationSmDependency extends SmMultipleDependency {
        @objid ("461e3c64-a1fa-4fb5-8a27-ecf2f0dc7fba")
        private SmDependency symetricDep;

        @objid ("d00e14a0-19e0-4b57-b412-4e74218e084f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnInterfaceData)data).mOperation != null)? ((BpmnInterfaceData)data).mOperation:SmMultipleDependency.EMPTY;
        }

        @objid ("00e9fb3b-9b52-4df3-aca3-d1be6cc1d87b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnInterfaceData) data).mOperation = values;

        }

        @objid ("f69c178b-96ec-40a3-8e64-9e94c1079255")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getBpmnInterfaceRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("240f0cc2-41b9-4fe3-a599-00128c8720e6")
    public static class ParticipantRefSmDependency extends SmMultipleDependency {
        @objid ("f577f744-3fa5-45c4-9a9e-42fa29ce4d91")
        private SmDependency symetricDep;

        @objid ("ef06c203-39ee-456a-9a08-9cfaf8a5de36")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnInterfaceData)data).mParticipantRef != null)? ((BpmnInterfaceData)data).mParticipantRef:SmMultipleDependency.EMPTY;
        }

        @objid ("7cf550f2-0743-406f-9b41-28a96d858e8a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnInterfaceData) data).mParticipantRef = values;

        }

        @objid ("15e332a6-35f8-4fa4-ae50-458e96def3ad")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnParticipantSmClass)this.getTarget()).getInterfaceRefsDep();
            }
            return this.symetricDep;

        }

    }

}
