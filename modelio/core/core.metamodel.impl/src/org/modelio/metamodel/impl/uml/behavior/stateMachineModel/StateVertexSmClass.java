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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("f5cae989-99d6-4bea-a855-1f1a95220a78")
public class StateVertexSmClass extends UmlModelElementSmClass {
    @objid ("9dcb6f37-3cbc-41dc-a992-dcb57936d00a")
    private SmDependency outGoingDep;

    @objid ("94d38a77-34ea-4701-b1bc-818538917bf5")
    private SmDependency incomingDep;

    @objid ("f752923e-15f2-4e56-a7a8-898c3692830f")
    private SmDependency parentDep;

    @objid ("c8f0d7b8-a78c-4f6c-83ac-eae4ff55eade")
    public StateVertexSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("979e76e3-2828-41eb-b4c0-fdcece4b2b9d")
    @Override
    public String getName() {
        return "StateVertex";

    }

    @objid ("43755b64-0fde-4d83-9e92-703fa2af4b00")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("40910295-c266-44eb-905b-9304c81b4b84")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StateVertex.class;

    }

    @objid ("9e5b38d9-e3e0-4b33-8c75-198d85d7f188")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("641a6d8d-2bc4-4c66-9141-44bb39c70a6d")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("0c6b3068-401c-4f0e-90c6-e0a90f4943d7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new StateVertexObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.outGoingDep = new OutGoingSmDependency();
        this.outGoingDep.init("OutGoing", this, metamodel.getMClass(Transition.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.outGoingDep);

        this.incomingDep = new IncomingSmDependency();
        this.incomingDep.init("Incoming", this, metamodel.getMClass(Transition.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.incomingDep);

        this.parentDep = new ParentSmDependency();
        this.parentDep.init("Parent", this, metamodel.getMClass(Region.MQNAME), 0, 1 );
        registerDependency(this.parentDep);

    }

    @objid ("bb5d35c1-f74c-45dc-98d8-e4cfdbc1b4ae")
    public SmDependency getOutGoingDep() {
        if (this.outGoingDep == null) {
        	this.outGoingDep = this.getDependencyDef("OutGoing");
        }
        return this.outGoingDep;
    }

    @objid ("1f9ddf28-b3ee-488c-abc5-75f33916c485")
    public SmDependency getIncomingDep() {
        if (this.incomingDep == null) {
        	this.incomingDep = this.getDependencyDef("Incoming");
        }
        return this.incomingDep;
    }

    @objid ("a8c7864e-b219-41bb-b929-50e36265b1ae")
    public SmDependency getParentDep() {
        if (this.parentDep == null) {
        	this.parentDep = this.getDependencyDef("Parent");
        }
        return this.parentDep;
    }

    @objid ("4725edae-28c7-437b-88ae-931bee04862d")
    private static class StateVertexObjectFactory implements ISmObjectFactory {
        @objid ("1150f194-34b6-401f-9286-8aff1ef50f71")
        private StateVertexSmClass smClass;

        @objid ("61313230-b57e-4c6a-a3d3-259c8ec13c7f")
        public StateVertexObjectFactory(StateVertexSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("156f9028-291d-47b4-8966-d72516a50d52")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("67892bc1-5df9-4eed-a57b-f55bddeba43f")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("dbf4386d-68d1-4bfd-b199-7fd3c9f2ea47")
    public static class OutGoingSmDependency extends SmMultipleDependency {
        @objid ("5f8f25e4-ddf3-4152-b83b-19afb4a53b4c")
        private SmDependency symetricDep;

        @objid ("c45c5f11-de94-489f-a5a2-1a9578990d1c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateVertexData)data).mOutGoing != null)? ((StateVertexData)data).mOutGoing:SmMultipleDependency.EMPTY;
        }

        @objid ("340e6b18-1d8a-4e0b-9483-462ffb08c777")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateVertexData) data).mOutGoing = values;

        }

        @objid ("6196050f-c164-4745-8b8b-df88e7e82cf8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("92595478-3ada-434c-ac43-7492dc2cf60c")
    public static class IncomingSmDependency extends SmMultipleDependency {
        @objid ("0a6881ec-a95d-4544-96bf-1f12bf7a8534")
        private SmDependency symetricDep;

        @objid ("ef8eb22e-8bc8-407e-ad0d-b70ccaf53a0e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateVertexData)data).mIncoming != null)? ((StateVertexData)data).mIncoming:SmMultipleDependency.EMPTY;
        }

        @objid ("5d0d2e39-1745-4fc5-ab71-46f7542c4679")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateVertexData) data).mIncoming = values;

        }

        @objid ("78c8ac48-04b3-46d7-b118-2abf648878e9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("67d14a4c-489f-4d25-8cea-9ebd0f734ca2")
    public static class ParentSmDependency extends SmSingleDependency {
        @objid ("455ef8ea-9e56-4628-8c2e-e28a7097d9d3")
        private SmDependency symetricDep;

        @objid ("81cbe97e-376a-43ee-bb64-d8eae1a2a5f6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((StateVertexData) data).mParent;
        }

        @objid ("f1469c1a-9031-4122-9df3-b0a406eca016")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((StateVertexData) data).mParent = value;
        }

        @objid ("1b9e4f8d-678b-4a75-bbd4-d761f927961c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RegionSmClass)this.getTarget()).getSubDep();
            }
            return this.symetricDep;

        }

    }

}
