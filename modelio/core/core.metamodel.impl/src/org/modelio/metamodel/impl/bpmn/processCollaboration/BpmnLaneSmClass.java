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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f00c3564-2a53-4a36-aee2-6bf19fcf1f74")
public class BpmnLaneSmClass extends BpmnBaseElementSmClass {
    @objid ("1fe31abb-5766-4813-8347-124fe3b7155f")
    private SmDependency childLaneSetDep;

    @objid ("74ad16f4-0b03-4443-b04e-fd12a26dbe46")
    private SmDependency flowElementRefDep;

    @objid ("35a06ed6-6623-4341-8f9b-3b30e231090f")
    private SmDependency laneSetDep;

    @objid ("29a4cad3-329f-41a2-b372-00586fc1d353")
    private SmDependency bpmnPartitionElementRefDep;

    @objid ("dfd463a3-7c1f-4603-84c3-35ca01c3cb50")
    public BpmnLaneSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c325f861-8fbc-45c6-8292-6cf1cb29e123")
    @Override
    public String getName() {
        return "BpmnLane";

    }

    @objid ("8c6a9d40-f836-4d47-ac9a-e17c74e7d401")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("8a16ba2d-7330-493d-8613-a946d25dce21")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnLane.class;

    }

    @objid ("3f7a042f-0c95-4f37-b46a-dc3ad7ec2c50")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1546ee12-c3e5-4d0e-95ee-4c9341b40087")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b92faf23-b4e5-4024-9890-127b659febab")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnLaneObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.childLaneSetDep = new ChildLaneSetSmDependency();
        this.childLaneSetDep.init("ChildLaneSet", this, metamodel.getMClass(BpmnLaneSet.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.childLaneSetDep);

        this.flowElementRefDep = new FlowElementRefSmDependency();
        this.flowElementRefDep.init("FlowElementRef", this, metamodel.getMClass(BpmnFlowElement.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.flowElementRefDep);

        this.laneSetDep = new LaneSetSmDependency();
        this.laneSetDep.init("LaneSet", this, metamodel.getMClass(BpmnLaneSet.MQNAME), 1, 1 );
        registerDependency(this.laneSetDep);

        this.bpmnPartitionElementRefDep = new BpmnPartitionElementRefSmDependency();
        this.bpmnPartitionElementRefDep.init("BpmnPartitionElementRef", this, metamodel.getMClass(BpmnBaseElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.bpmnPartitionElementRefDep);

    }

    @objid ("1ddaabdf-f8bc-443a-aaf9-5778d2bf1b99")
    public SmDependency getChildLaneSetDep() {
        if (this.childLaneSetDep == null) {
        	this.childLaneSetDep = this.getDependencyDef("ChildLaneSet");
        }
        return this.childLaneSetDep;
    }

    @objid ("1709b720-cdf1-41cd-ad32-120ff8df1644")
    public SmDependency getFlowElementRefDep() {
        if (this.flowElementRefDep == null) {
        	this.flowElementRefDep = this.getDependencyDef("FlowElementRef");
        }
        return this.flowElementRefDep;
    }

    @objid ("a2c30c11-c3a0-4799-b759-49835e763272")
    public SmDependency getLaneSetDep() {
        if (this.laneSetDep == null) {
        	this.laneSetDep = this.getDependencyDef("LaneSet");
        }
        return this.laneSetDep;
    }

    @objid ("99d26adb-d547-4e35-a9f3-58155b4ec775")
    public SmDependency getBpmnPartitionElementRefDep() {
        if (this.bpmnPartitionElementRefDep == null) {
        	this.bpmnPartitionElementRefDep = this.getDependencyDef("BpmnPartitionElementRef");
        }
        return this.bpmnPartitionElementRefDep;
    }

    @objid ("297e5501-8fc6-4e62-8030-36a32fa31b4d")
    private static class BpmnLaneObjectFactory implements ISmObjectFactory {
        @objid ("30b55c1d-9749-4f1b-81d3-957e9eb659dd")
        private BpmnLaneSmClass smClass;

        @objid ("b0c64de0-81b1-47b4-8d94-1ea69855b666")
        public BpmnLaneObjectFactory(BpmnLaneSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("943c6639-26d4-45ca-ac7e-7257b5e1c159")
        @Override
        public ISmObjectData createData() {
            return new BpmnLaneData(this.smClass);
        }

        @objid ("b1026db9-a108-411f-a583-ee065e42588e")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnLaneImpl();
        }

    }

    @objid ("85be006f-d5d2-4217-b167-64926023caa2")
    public static class ChildLaneSetSmDependency extends SmSingleDependency {
        @objid ("ecb88453-44a3-484f-88fe-38ce7df657ee")
        private SmDependency symetricDep;

        @objid ("0438e206-08db-486a-ae19-1b84d98fd8df")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneData) data).mChildLaneSet;
        }

        @objid ("851085a2-bf16-4445-b601-3f5ff4e7bd74")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneData) data).mChildLaneSet = value;
        }

        @objid ("ad9e7276-5681-422a-8779-2d34521df79b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSetSmClass)this.getTarget()).getParentLaneDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f5b6c2d5-c1aa-4b2d-97b2-14cb0a45bb79")
    public static class FlowElementRefSmDependency extends SmMultipleDependency {
        @objid ("0c7bf390-39c2-40cd-974a-4d1bd5c56765")
        private SmDependency symetricDep;

        @objid ("859224f0-b428-4a0f-8919-3c87210422fa")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnLaneData)data).mFlowElementRef != null)? ((BpmnLaneData)data).mFlowElementRef:SmMultipleDependency.EMPTY;
        }

        @objid ("f3ec9e21-3179-4c86-9b8c-5c3e4cb578bb")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnLaneData) data).mFlowElementRef = values;

        }

        @objid ("b7405a88-b3af-470e-8878-ce6d54e17a46")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowElementSmClass)this.getTarget()).getLaneDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5254483f-5c3c-40cf-96d1-dc9c7a75ff1e")
    public static class LaneSetSmDependency extends SmSingleDependency {
        @objid ("2c6aeeb5-2ac9-4a34-8b27-82ab5e606132")
        private SmDependency symetricDep;

        @objid ("bab56a91-c6ba-4609-83c2-700b04323da1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneData) data).mLaneSet;
        }

        @objid ("62419f07-141e-40a9-8c38-684fe4b3660a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneData) data).mLaneSet = value;
        }

        @objid ("73e1be3d-9e68-49d3-9d84-4fd54a60896d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSetSmClass)this.getTarget()).getLaneDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6cb42e13-e876-4d46-b81e-5ac07fb88bb2")
    public static class BpmnPartitionElementRefSmDependency extends SmSingleDependency {
        @objid ("9dec8bb8-8785-4fd3-8c3a-02c271447eaa")
        private SmDependency symetricDep;

        @objid ("c2201b7f-77fb-4e0b-b590-11d8a8b982cb")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneData) data).mBpmnPartitionElementRef;
        }

        @objid ("d716669d-51ad-43e6-a9d3-c822a3f9e8ea")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneData) data).mBpmnPartitionElementRef = value;
        }

        @objid ("b41e6618-262d-4330-9852-9ffbbb418763")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBaseElementSmClass)this.getTarget()).getPartitionedLaneRefsDep();
            }
            return this.symetricDep;

        }

    }

}
