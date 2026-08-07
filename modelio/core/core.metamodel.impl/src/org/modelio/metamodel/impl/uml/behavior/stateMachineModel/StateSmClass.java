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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.EventSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InternalTransition;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
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

@objid ("0a274c48-b40b-4380-aa10-8a641668c3b0")
public class StateSmClass extends StateVertexSmClass {
    @objid ("8ad9dbda-07fa-4cfc-843f-0d3816a99abf")
    private SmDependency exitPointDep;

    @objid ("ca79bda6-1786-4dc2-b340-2f85ef4bc3cc")
    private SmDependency defferedDep;

    @objid ("18094824-9f79-48a8-9c45-c6ad8f21cf6a")
    private SmDependency internalDep;

    @objid ("8fd48955-cb0a-4ee5-9cd4-a9bef27e880d")
    private SmDependency entryPointDep;

    @objid ("730f957e-7fa7-4898-96d6-12986571301d")
    private SmDependency ownedRegionDep;

    @objid ("296f2dc9-5e30-4c07-838b-b4dc05b54e1a")
    private SmDependency requiredStateOfDep;

    @objid ("85af3855-44c5-47fa-af26-4459c387ca7f")
    private SmDependency connectionDep;

    @objid ("7ef5c74a-9d8c-43aa-b9b3-0f0a4aab9a15")
    private SmDependency subMachineDep;

    @objid ("009f3e1e-ad48-4584-af2a-28f307d4d564")
    public StateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6f46aa40-85bf-4fae-8263-8a2668ada6c3")
    @Override
    public String getName() {
        return "State";

    }

    @objid ("f833e22c-502e-4cbe-9dd0-68ce980e79ce")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c48e0efe-7152-4d4a-b712-fd3af0987b23")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return State.class;

    }

    @objid ("277e2cba-a02d-4b37-bde9-1767789ff188")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5eb7c269-cd41-417d-9b46-0e37d20b5935")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bd190843-e188-4014-8e07-bffb073513b9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StateVertex.MQNAME);
        this.registerFactory(new StateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.exitPointDep = new ExitPointSmDependency();
        this.exitPointDep.init("ExitPoint", this, metamodel.getMClass(ExitPointPseudoState.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.exitPointDep);

        this.defferedDep = new DefferedSmDependency();
        this.defferedDep.init("Deffered", this, metamodel.getMClass(Event.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defferedDep);

        this.internalDep = new InternalSmDependency();
        this.internalDep.init("Internal", this, metamodel.getMClass(InternalTransition.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.internalDep);

        this.entryPointDep = new EntryPointSmDependency();
        this.entryPointDep.init("EntryPoint", this, metamodel.getMClass(EntryPointPseudoState.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.entryPointDep);

        this.ownedRegionDep = new OwnedRegionSmDependency();
        this.ownedRegionDep.init("OwnedRegion", this, metamodel.getMClass(Region.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedRegionDep);

        this.requiredStateOfDep = new RequiredStateOfSmDependency();
        this.requiredStateOfDep.init("RequiredStateOf", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 );
        registerDependency(this.requiredStateOfDep);

        this.connectionDep = new ConnectionSmDependency();
        this.connectionDep.init("Connection", this, metamodel.getMClass(ConnectionPointReference.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.connectionDep);

        this.subMachineDep = new SubMachineSmDependency();
        this.subMachineDep.init("SubMachine", this, metamodel.getMClass(StateMachine.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.subMachineDep);

    }

    @objid ("932b9553-41c5-4dfc-a6ca-d1f74c3b24c2")
    public SmDependency getExitPointDep() {
        if (this.exitPointDep == null) {
        	this.exitPointDep = this.getDependencyDef("ExitPoint");
        }
        return this.exitPointDep;
    }

    @objid ("d2b0b079-74e8-4769-9e62-f93e1066ceb8")
    public SmDependency getDefferedDep() {
        if (this.defferedDep == null) {
        	this.defferedDep = this.getDependencyDef("Deffered");
        }
        return this.defferedDep;
    }

    @objid ("dd619876-8de5-4d0a-97ae-4443a6c83dab")
    public SmDependency getInternalDep() {
        if (this.internalDep == null) {
        	this.internalDep = this.getDependencyDef("Internal");
        }
        return this.internalDep;
    }

    @objid ("0754bd2c-c8fe-4fa4-b475-ff730ac7178f")
    public SmDependency getEntryPointDep() {
        if (this.entryPointDep == null) {
        	this.entryPointDep = this.getDependencyDef("EntryPoint");
        }
        return this.entryPointDep;
    }

    @objid ("9385acd5-4029-44d1-8c22-6e5f1f9ecfaa")
    public SmDependency getOwnedRegionDep() {
        if (this.ownedRegionDep == null) {
        	this.ownedRegionDep = this.getDependencyDef("OwnedRegion");
        }
        return this.ownedRegionDep;
    }

    @objid ("e2ab3464-e7ac-432f-a606-5c805f487a2b")
    public SmDependency getRequiredStateOfDep() {
        if (this.requiredStateOfDep == null) {
        	this.requiredStateOfDep = this.getDependencyDef("RequiredStateOf");
        }
        return this.requiredStateOfDep;
    }

    @objid ("bf532adf-f3a1-4669-8567-46752f9e4fea")
    public SmDependency getConnectionDep() {
        if (this.connectionDep == null) {
        	this.connectionDep = this.getDependencyDef("Connection");
        }
        return this.connectionDep;
    }

    @objid ("7a1f65c8-31eb-4b95-be65-8ee30640728c")
    public SmDependency getSubMachineDep() {
        if (this.subMachineDep == null) {
        	this.subMachineDep = this.getDependencyDef("SubMachine");
        }
        return this.subMachineDep;
    }

    @objid ("09c173a5-9ba1-47af-9a5d-db77a82751ed")
    private static class StateObjectFactory implements ISmObjectFactory {
        @objid ("946316b8-ddcf-4a4e-b6ee-4487ea4b53cd")
        private StateSmClass smClass;

        @objid ("054c2b87-6577-4151-acfe-920a182951d6")
        public StateObjectFactory(StateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2179e8da-a2fe-42ee-b5f1-26658ac5cccc")
        @Override
        public ISmObjectData createData() {
            return new StateData(this.smClass);
        }

        @objid ("1dcc0f72-aea6-4749-a871-e2f03e65ca32")
        @Override
        public SmObjectImpl createImpl() {
            return new StateImpl();
        }

    }

    @objid ("69336a78-c8c1-4663-89d6-5965a131036d")
    public static class ExitPointSmDependency extends SmMultipleDependency {
        @objid ("3f297515-107e-48b7-93c7-efb2ccba54c7")
        private SmDependency symetricDep;

        @objid ("ef19b9dc-b690-44f2-8324-27314de9f8af")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mExitPoint != null)? ((StateData)data).mExitPoint:SmMultipleDependency.EMPTY;
        }

        @objid ("07f4b550-0d55-49c2-a9b7-90c9c1a70885")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mExitPoint = values;

        }

        @objid ("d30487dd-37d6-4df5-81de-8ab1f6f0cc16")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExitPointPseudoStateSmClass)this.getTarget()).getExitOfDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("32a104ce-51c0-4a5d-8c02-bc14bb195e23")
    public static class DefferedSmDependency extends SmMultipleDependency {
        @objid ("72e00c18-8475-414f-9cf3-0f36778813f9")
        private SmDependency symetricDep;

        @objid ("dd11b99b-9230-4d51-acf7-0da5f7de856b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mDeffered != null)? ((StateData)data).mDeffered:SmMultipleDependency.EMPTY;
        }

        @objid ("19995ff7-fd2f-4e34-a079-8c1f1f8de7f0")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mDeffered = values;

        }

        @objid ("fe23a0dd-509d-4a36-ac10-cd50b469e37f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EventSmClass)this.getTarget()).getOriginDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9b4c56b5-76a8-4166-8801-faab70ebb9a4")
    public static class InternalSmDependency extends SmMultipleDependency {
        @objid ("36ac8800-d027-4c36-80ce-a5e442e4833c")
        private SmDependency symetricDep;

        @objid ("91fa1925-34bc-4c44-9f73-13d61d9bc741")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mInternal != null)? ((StateData)data).mInternal:SmMultipleDependency.EMPTY;
        }

        @objid ("4e7d6f31-60ce-4c9c-b52f-9d6aa6a8c941")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mInternal = values;

        }

        @objid ("9d698be8-abe0-4065-bfb8-af1e6fe6890c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InternalTransitionSmClass)this.getTarget()).getSComposedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4eacd3b7-6f46-417b-80ea-0e6b54de9da2")
    public static class EntryPointSmDependency extends SmMultipleDependency {
        @objid ("e13f1a56-7170-4f6c-aab1-10cc3060fb02")
        private SmDependency symetricDep;

        @objid ("cef6ea9f-33e4-4387-8ac6-c8f361f076d9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mEntryPoint != null)? ((StateData)data).mEntryPoint:SmMultipleDependency.EMPTY;
        }

        @objid ("3c969293-52cb-4998-b3d5-0717b9b2b728")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mEntryPoint = values;

        }

        @objid ("e12e58b1-7ddf-45e2-bac6-d15dd6ce8e18")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EntryPointPseudoStateSmClass)this.getTarget()).getEntryOfDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("be860d05-553e-45ce-94a4-db7f75460ef1")
    public static class OwnedRegionSmDependency extends SmMultipleDependency {
        @objid ("f39a032f-6f57-4148-9436-8564f38f4ed6")
        private SmDependency symetricDep;

        @objid ("42c24486-9da0-4cc4-ad52-4dcfb6c27690")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mOwnedRegion != null)? ((StateData)data).mOwnedRegion:SmMultipleDependency.EMPTY;
        }

        @objid ("1995840c-3ca6-4a70-bfec-37e5cd718e28")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mOwnedRegion = values;

        }

        @objid ("561c89d4-7085-4371-8e45-75e1d836dc6d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RegionSmClass)this.getTarget()).getParentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("29e4844f-1e65-4af6-b50c-30fe147e3a8d")
    public static class RequiredStateOfSmDependency extends SmMultipleDependency {
        @objid ("85bcec33-f67f-4510-ac8c-947615b12d41")
        private SmDependency symetricDep;

        @objid ("a65d6a7d-09ba-4ad0-8cad-b8c1c485e28b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mRequiredStateOf != null)? ((StateData)data).mRequiredStateOf:SmMultipleDependency.EMPTY;
        }

        @objid ("d89400bc-946b-46a6-9f78-96b7722d97bd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mRequiredStateOf = values;

        }

        @objid ("74e2bd37-1f67-4b3c-a054-efadb5945bf6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getInStateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a8b94ba3-b077-4589-8243-e24d8f5e7010")
    public static class ConnectionSmDependency extends SmMultipleDependency {
        @objid ("0415cb51-505c-4847-a8ab-5fbb0bdff86c")
        private SmDependency symetricDep;

        @objid ("2259eabf-5a7c-47e1-bd87-4bfe62197b52")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateData)data).mConnection != null)? ((StateData)data).mConnection:SmMultipleDependency.EMPTY;
        }

        @objid ("5cb072aa-2354-4152-91bd-9181d912de5a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateData) data).mConnection = values;

        }

        @objid ("39629c32-4089-4ea0-be4a-1ba2616f73eb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConnectionPointReferenceSmClass)this.getTarget()).getOwnerStateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5263e945-55d3-4d52-9810-884911578057")
    public static class SubMachineSmDependency extends SmSingleDependency {
        @objid ("e511bc8d-6bac-4abb-8469-06b7103fd708")
        private SmDependency symetricDep;

        @objid ("7c63cdd3-a89b-439f-a74d-cb976ce2ea04")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((StateData) data).mSubMachine;
        }

        @objid ("9afb7e30-4a2b-4e9b-af5e-ffd21bd28357")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((StateData) data).mSubMachine = value;
        }

        @objid ("42f7914b-abb8-46c6-8e6b-a161cb6a62d7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateMachineSmClass)this.getTarget()).getSubmachineStateDep();
            }
            return this.symetricDep;

        }

    }

}
