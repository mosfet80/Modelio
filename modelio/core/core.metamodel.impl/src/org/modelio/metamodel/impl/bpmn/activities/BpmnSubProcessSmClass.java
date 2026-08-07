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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnLaneSetSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnArtifactSmClass;
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

@objid ("ca96dca3-70f3-4113-bfa9-e4768ccb42e1")
public class BpmnSubProcessSmClass extends BpmnActivitySmClass {
    @objid ("e6f83d0e-eeef-489e-a6ea-c4dfbfab4b47")
    private SmDependency artifactDep;

    @objid ("b0843d87-d2ab-48d0-a0d1-449d5bf6f254")
    private SmDependency flowElementDep;

    @objid ("2816a8cf-98ec-4f86-acc0-222e6807d7f8")
    private SmDependency laneSetDep;

    @objid ("3ef6845e-427b-41c6-8e95-1dc6235ea412")
    public BpmnSubProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("89a883b8-7366-4145-98b1-66b6beef89d4")
    @Override
    public String getName() {
        return "BpmnSubProcess";

    }

    @objid ("a1d18762-2dff-4eb9-beb3-6934ad9827e5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f569df08-ef02-41b4-ac8f-a51d33d24854")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSubProcess.class;

    }

    @objid ("c1202c79-0036-4b53-afbd-bf4706093375")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1ab88101-d646-4ff9-a07b-3a08d5cdd365")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("37970a5f-ac54-42bb-bb96-d6502c915607")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnActivity.MQNAME);
        this.registerFactory(new BpmnSubProcessObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.artifactDep = new ArtifactSmDependency();
        this.artifactDep.init("Artifact", this, metamodel.getMClass(BpmnArtifact.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.artifactDep);

        this.flowElementDep = new FlowElementSmDependency();
        this.flowElementDep.init("FlowElement", this, metamodel.getMClass(BpmnFlowElement.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.flowElementDep);

        this.laneSetDep = new LaneSetSmDependency();
        this.laneSetDep.init("LaneSet", this, metamodel.getMClass(BpmnLaneSet.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.laneSetDep);

    }

    @objid ("00759285-d87c-4897-8bf6-a089ed084b03")
    public SmDependency getArtifactDep() {
        if (this.artifactDep == null) {
        	this.artifactDep = this.getDependencyDef("Artifact");
        }
        return this.artifactDep;
    }

    @objid ("e7761aab-c271-4e79-9861-9f678f8aef95")
    public SmDependency getFlowElementDep() {
        if (this.flowElementDep == null) {
        	this.flowElementDep = this.getDependencyDef("FlowElement");
        }
        return this.flowElementDep;
    }

    @objid ("7a0e41f6-ebf1-4e3a-9c7f-8cc90ce2ef3d")
    public SmDependency getLaneSetDep() {
        if (this.laneSetDep == null) {
        	this.laneSetDep = this.getDependencyDef("LaneSet");
        }
        return this.laneSetDep;
    }

    @objid ("0b070c73-6f8f-4c0f-b950-8e0b8a996709")
    private static class BpmnSubProcessObjectFactory implements ISmObjectFactory {
        @objid ("17ae3b7b-34ef-40dd-b7af-c33aa11c6824")
        private BpmnSubProcessSmClass smClass;

        @objid ("0f683349-4ad2-4b1c-b516-36b6b2e26728")
        public BpmnSubProcessObjectFactory(BpmnSubProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c07b1ae6-2f56-48e9-a3cb-826d97adf433")
        @Override
        public ISmObjectData createData() {
            return new BpmnSubProcessData(this.smClass);
        }

        @objid ("595c3db8-9065-4d39-bc3b-638990939111")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSubProcessImpl();
        }

    }

    @objid ("639a833a-d610-4ad7-97eb-6090e00ea15a")
    public static class ArtifactSmDependency extends SmMultipleDependency {
        @objid ("6d06f2b3-de4f-41f6-8beb-01f8edcc75cd")
        private SmDependency symetricDep;

        @objid ("d97f4994-e9fb-4b2a-9711-16e85d5b823a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnSubProcessData)data).mArtifact != null)? ((BpmnSubProcessData)data).mArtifact:SmMultipleDependency.EMPTY;
        }

        @objid ("116d5d87-f119-42e2-810e-9eabe544e595")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnSubProcessData) data).mArtifact = values;

        }

        @objid ("eca19669-545a-45a4-8f35-7174c24d1b63")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnArtifactSmClass)this.getTarget()).getSubProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1149619f-fb1d-4b04-a3da-0a45b2392d93")
    public static class FlowElementSmDependency extends SmMultipleDependency {
        @objid ("91aa81c2-7fb9-46c1-a27f-f22518836128")
        private SmDependency symetricDep;

        @objid ("a2b841b7-10eb-4d80-b488-a1f3aef9b9f6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnSubProcessData)data).mFlowElement != null)? ((BpmnSubProcessData)data).mFlowElement:SmMultipleDependency.EMPTY;
        }

        @objid ("abdebdb9-db18-4d30-aab7-e3c3d2ef097d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnSubProcessData) data).mFlowElement = values;

        }

        @objid ("d1bfe9fb-5591-4cd4-8b0e-f2ecf1f70949")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowElementSmClass)this.getTarget()).getSubProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("37a8d9ac-5f4b-44f8-98d4-0250ec62975b")
    public static class LaneSetSmDependency extends SmSingleDependency {
        @objid ("064c1d59-c93e-4579-9026-378b5c8efd01")
        private SmDependency symetricDep;

        @objid ("b7113b02-e246-4ecd-9c77-a1e042751cb6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSubProcessData) data).mLaneSet;
        }

        @objid ("cc0398aa-b573-4c69-92bc-8ead0f20fee9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSubProcessData) data).mLaneSet = value;
        }

        @objid ("89c98433-a0a4-44e6-92d9-eb0257403eb9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSetSmClass)this.getTarget()).getSubProcessDep();
            }
            return this.symetricDep;

        }

    }

}
