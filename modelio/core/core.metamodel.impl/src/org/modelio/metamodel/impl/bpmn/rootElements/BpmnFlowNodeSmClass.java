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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
import org.modelio.metamodel.impl.bpmn.resources.BpmnResourceRoleSmClass;
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

@objid ("099437a9-c4b0-48dd-8511-54c9ea9b442e")
public class BpmnFlowNodeSmClass extends BpmnFlowElementSmClass {
    @objid ("578c2669-cbb2-4f53-9add-5999c3327b2a")
    private SmDependency outgoingDep;

    @objid ("8cbee8de-0346-45f5-b0e5-d48b3c004252")
    private SmDependency resourceDep;

    @objid ("72b0be27-5e2a-4e38-8643-dd4264a3003e")
    private SmDependency incomingDep;

    @objid ("dd392dbd-495c-40db-af3b-5bb1332bee01")
    public BpmnFlowNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("23f60d57-3e72-4b9f-a33a-960f0ecce189")
    @Override
    public String getName() {
        return "BpmnFlowNode";

    }

    @objid ("c4c5d4c4-948e-4b8e-9603-7c65f4f4076e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("627250f3-942b-4dc7-ae4e-cc00bd22dc69")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnFlowNode.class;

    }

    @objid ("01a6e619-df0f-4510-a2a0-bf24b20925ac")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7c129f98-ca46-4e53-a155-cbfabf58eb6b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("9ea23283-e207-4859-8fdd-bf702294a480")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowElement.MQNAME);
        this.registerFactory(new BpmnFlowNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.outgoingDep = new OutgoingSmDependency();
        this.outgoingDep.init("Outgoing", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.outgoingDep);

        this.resourceDep = new ResourceSmDependency();
        this.resourceDep.init("Resource", this, metamodel.getMClass(BpmnResourceRole.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.resourceDep);

        this.incomingDep = new IncomingSmDependency();
        this.incomingDep.init("Incoming", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.incomingDep);

    }

    @objid ("85664fe1-fb23-4e0e-bffd-8bd18921d1ea")
    public SmDependency getOutgoingDep() {
        if (this.outgoingDep == null) {
        	this.outgoingDep = this.getDependencyDef("Outgoing");
        }
        return this.outgoingDep;
    }

    @objid ("103331c2-88ef-4adf-abbf-9eddaa5ce3b7")
    public SmDependency getResourceDep() {
        if (this.resourceDep == null) {
        	this.resourceDep = this.getDependencyDef("Resource");
        }
        return this.resourceDep;
    }

    @objid ("88c31e5b-2906-4f31-8f85-c56797386371")
    public SmDependency getIncomingDep() {
        if (this.incomingDep == null) {
        	this.incomingDep = this.getDependencyDef("Incoming");
        }
        return this.incomingDep;
    }

    @objid ("a9d53b0e-f2a9-44f7-bcfc-bb5a7a92af15")
    private static class BpmnFlowNodeObjectFactory implements ISmObjectFactory {
        @objid ("52a542bd-12e0-4d48-9e6c-2d9b85c36447")
        private BpmnFlowNodeSmClass smClass;

        @objid ("a9d95a7a-f772-45e6-a6f2-5ee431fa5b37")
        public BpmnFlowNodeObjectFactory(BpmnFlowNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("65f764f4-9fec-4f7c-b1d3-16a99df562de")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("651590fc-a1cf-4fde-8958-fa7edef1b323")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("0c939c36-4ac9-4718-ac28-932b475c79e4")
    public static class OutgoingSmDependency extends SmMultipleDependency {
        @objid ("8afe7116-2bfc-47bd-8612-183d7c9dec87")
        private SmDependency symetricDep;

        @objid ("d7e4ec3a-1449-4a4c-8651-a81e5205f0bf")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnFlowNodeData)data).mOutgoing != null)? ((BpmnFlowNodeData)data).mOutgoing:SmMultipleDependency.EMPTY;
        }

        @objid ("ea7d5838-af37-4640-8a5e-2d4179adf674")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnFlowNodeData) data).mOutgoing = values;

        }

        @objid ("6b8871fe-7b26-4312-97e9-ff74e49ba79f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getSourceRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("23080d3b-a187-4d65-bb86-082e7d7b0ada")
    public static class ResourceSmDependency extends SmMultipleDependency {
        @objid ("5d636534-cdca-46dc-8314-bf559304ee0e")
        private SmDependency symetricDep;

        @objid ("99396f9b-6c0c-4326-a4c1-2f941309482a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnFlowNodeData)data).mResource != null)? ((BpmnFlowNodeData)data).mResource:SmMultipleDependency.EMPTY;
        }

        @objid ("261652eb-83f7-4aad-b50f-58351fe56b59")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnFlowNodeData) data).mResource = values;

        }

        @objid ("98a965cf-474c-48b6-9dbc-e9ff0e8690e6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceRoleSmClass)this.getTarget()).getAnnotatedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e1f7770f-0139-46f8-9bf8-944cb24621ac")
    public static class IncomingSmDependency extends SmMultipleDependency {
        @objid ("eae51fed-59d5-4629-a304-f13583aad756")
        private SmDependency symetricDep;

        @objid ("008041b7-560d-4a11-84af-c48526ce1678")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnFlowNodeData)data).mIncoming != null)? ((BpmnFlowNodeData)data).mIncoming:SmMultipleDependency.EMPTY;
        }

        @objid ("31b6a085-d2de-4a0b-9453-e72430f45b9e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnFlowNodeData) data).mIncoming = values;

        }

        @objid ("b7e119f4-c78f-48fb-bd28-c763bf2a7b56")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getTargetRefDep();
            }
            return this.symetricDep;

        }

    }

}
