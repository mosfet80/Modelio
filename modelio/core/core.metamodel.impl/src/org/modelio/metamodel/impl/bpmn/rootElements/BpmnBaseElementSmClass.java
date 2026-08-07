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
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageFlowSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnLaneSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
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

@objid ("1c593681-5de5-4212-904d-ddce18beddaf")
public class BpmnBaseElementSmClass extends ModelElementSmClass {
    @objid ("7c5a3d2b-fb2b-4ef7-ad19-c6e61047cda8")
    private SmDependency outgoingAssocDep;

    @objid ("d118a070-a556-42b4-97b0-b731e4a576b5")
    private SmDependency incomingAssocDep;

    @objid ("d8266c6a-ad58-4988-9e83-ef75efc69426")
    private SmDependency incomingFlowDep;

    @objid ("0664980f-d09f-4af2-9ec8-651683d20305")
    private SmDependency outgoingFlowDep;

    @objid ("b7b78680-7e80-4d8e-b5c8-24d7ad7159cb")
    private SmDependency partitionedLaneRefsDep;

    @objid ("3fcaa0ca-5d1d-4525-9ec8-57c6057fc795")
    public BpmnBaseElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b801df27-f8d5-4c37-abc7-86e431fff4a1")
    @Override
    public String getName() {
        return "BpmnBaseElement";

    }

    @objid ("ad997d2b-e98f-4063-bfbb-7ae47d2e94af")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e2fd8690-f9f9-4dad-84ba-ee4470e0a7da")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnBaseElement.class;

    }

    @objid ("bd58c8ba-7cbf-4692-ba2e-3ff2437a0a66")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a495ed64-4fdd-4f2c-b730-44539523ed2a")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("ec3e7b5a-f62b-46a7-9ba3-815674c1de72")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ModelElement.MQNAME);
        this.registerFactory(new BpmnBaseElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.outgoingAssocDep = new OutgoingAssocSmDependency();
        this.outgoingAssocDep.init("OutgoingAssoc", this, metamodel.getMClass(BpmnAssociation.MQNAME), 0, -1 );
        registerDependency(this.outgoingAssocDep);

        this.incomingAssocDep = new IncomingAssocSmDependency();
        this.incomingAssocDep.init("IncomingAssoc", this, metamodel.getMClass(BpmnAssociation.MQNAME), 0, -1 );
        registerDependency(this.incomingAssocDep);

        this.incomingFlowDep = new IncomingFlowSmDependency();
        this.incomingFlowDep.init("IncomingFlow", this, metamodel.getMClass(BpmnMessageFlow.MQNAME), 0, -1 );
        registerDependency(this.incomingFlowDep);

        this.outgoingFlowDep = new OutgoingFlowSmDependency();
        this.outgoingFlowDep.init("OutgoingFlow", this, metamodel.getMClass(BpmnMessageFlow.MQNAME), 0, -1 );
        registerDependency(this.outgoingFlowDep);

        this.partitionedLaneRefsDep = new PartitionedLaneRefsSmDependency();
        this.partitionedLaneRefsDep.init("PartitionedLaneRefs", this, metamodel.getMClass(BpmnLane.MQNAME), 0, -1 );
        registerDependency(this.partitionedLaneRefsDep);

    }

    @objid ("7e5ba773-9fe4-419d-bc15-28215d54cefe")
    public SmDependency getOutgoingAssocDep() {
        if (this.outgoingAssocDep == null) {
        	this.outgoingAssocDep = this.getDependencyDef("OutgoingAssoc");
        }
        return this.outgoingAssocDep;
    }

    @objid ("0bb02047-235b-4fb2-ade6-b69923639deb")
    public SmDependency getIncomingAssocDep() {
        if (this.incomingAssocDep == null) {
        	this.incomingAssocDep = this.getDependencyDef("IncomingAssoc");
        }
        return this.incomingAssocDep;
    }

    @objid ("10e0b81a-750a-4a4c-8a48-54d29f7acfab")
    public SmDependency getIncomingFlowDep() {
        if (this.incomingFlowDep == null) {
        	this.incomingFlowDep = this.getDependencyDef("IncomingFlow");
        }
        return this.incomingFlowDep;
    }

    @objid ("484241f7-58cb-47ef-8eda-092c56db5e5b")
    public SmDependency getOutgoingFlowDep() {
        if (this.outgoingFlowDep == null) {
        	this.outgoingFlowDep = this.getDependencyDef("OutgoingFlow");
        }
        return this.outgoingFlowDep;
    }

    @objid ("d89bff4d-ea9b-4a8b-b5cc-820003c96176")
    public SmDependency getPartitionedLaneRefsDep() {
        if (this.partitionedLaneRefsDep == null) {
        	this.partitionedLaneRefsDep = this.getDependencyDef("PartitionedLaneRefs");
        }
        return this.partitionedLaneRefsDep;
    }

    @objid ("edb4462d-ec32-4450-a18e-768ff71e38e5")
    private static class BpmnBaseElementObjectFactory implements ISmObjectFactory {
        @objid ("3ac299ef-1234-4279-a3a7-510dd8c5c1e2")
        private BpmnBaseElementSmClass smClass;

        @objid ("bffb029c-8a41-4a39-ad06-4591e16b3c8b")
        public BpmnBaseElementObjectFactory(BpmnBaseElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e1a5da90-4b1c-4469-87af-6756f44e5b88")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("2a053d4b-0461-4f8f-94f8-7e97a477c0e7")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("f3906013-4c31-48e7-9e19-6540108e8126")
    public static class OutgoingAssocSmDependency extends SmMultipleDependency {
        @objid ("0808f20a-1531-4670-aa86-f7f3434814c0")
        private SmDependency symetricDep;

        @objid ("a1bdaccb-40ca-4b1d-b0b6-811cfd9d6829")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnBaseElementData)data).mOutgoingAssoc != null)? ((BpmnBaseElementData)data).mOutgoingAssoc:SmMultipleDependency.EMPTY;
        }

        @objid ("998a8543-422c-4b2d-98a6-b9ef10ec9a21")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnBaseElementData) data).mOutgoingAssoc = values;

        }

        @objid ("a3c5b019-fe0c-440a-a55b-cc845c72606c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnAssociationSmClass)this.getTarget()).getSourceRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("60f47c8d-0013-4449-8901-361802718c09")
    public static class IncomingAssocSmDependency extends SmMultipleDependency {
        @objid ("cd89d330-10ef-45f9-bbe2-7d49ad14625b")
        private SmDependency symetricDep;

        @objid ("2acb91b3-81cb-4cd4-a83c-51ae32815746")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnBaseElementData)data).mIncomingAssoc != null)? ((BpmnBaseElementData)data).mIncomingAssoc:SmMultipleDependency.EMPTY;
        }

        @objid ("48682550-12d4-4eac-9925-0ea94df1bca8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnBaseElementData) data).mIncomingAssoc = values;

        }

        @objid ("a60e72e6-cc7a-45f4-8fb7-9b6c8e9647a2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnAssociationSmClass)this.getTarget()).getTargetRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("220d558d-0e1d-462e-9034-c66fc29104b4")
    public static class IncomingFlowSmDependency extends SmMultipleDependency {
        @objid ("4c08abe0-96f7-4796-a459-6064a0b62056")
        private SmDependency symetricDep;

        @objid ("835c5dc1-9310-48a6-9bcd-e70b85631af1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnBaseElementData)data).mIncomingFlow != null)? ((BpmnBaseElementData)data).mIncomingFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("c8cd24f1-124d-4456-b42a-c341cbb50477")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnBaseElementData) data).mIncomingFlow = values;

        }

        @objid ("22ea23ae-85b8-4327-b61e-c87ff9bbcabf")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageFlowSmClass)this.getTarget()).getTargetRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bc869713-1441-485a-9cec-34cd71f54395")
    public static class OutgoingFlowSmDependency extends SmMultipleDependency {
        @objid ("ee9ab9e4-3596-4cd9-bc0d-ea0e08aa2503")
        private SmDependency symetricDep;

        @objid ("082dd621-8c51-473c-994e-f9981ab82ad5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnBaseElementData)data).mOutgoingFlow != null)? ((BpmnBaseElementData)data).mOutgoingFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("fb7d3487-334d-4a03-bba5-540fc80bc25b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnBaseElementData) data).mOutgoingFlow = values;

        }

        @objid ("860eeb6e-d71b-4e09-a4be-8d114ef205e9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageFlowSmClass)this.getTarget()).getSourceRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c7b88133-046a-4e5e-96ed-f017c1c89c03")
    public static class PartitionedLaneRefsSmDependency extends SmMultipleDependency {
        @objid ("8bdac845-0a9a-4861-94af-310c0f0cce8c")
        private SmDependency symetricDep;

        @objid ("8abc7e46-bc35-49d8-886d-ddff1c995c73")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnBaseElementData)data).mPartitionedLaneRefs != null)? ((BpmnBaseElementData)data).mPartitionedLaneRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("facc8b5d-8eea-4524-b987-0f4178c811ae")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnBaseElementData) data).mPartitionedLaneRefs = values;

        }

        @objid ("757c9f58-52b6-4672-b13f-1333773004f9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSmClass)this.getTarget()).getBpmnPartitionElementRefDep();
            }
            return this.symetricDep;

        }

    }

}
