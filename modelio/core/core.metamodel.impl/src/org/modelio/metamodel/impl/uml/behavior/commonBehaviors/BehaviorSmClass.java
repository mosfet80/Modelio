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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.CallBehaviorActionSmClass;
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.TransitionSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.CollaborationSmClass;
import org.modelio.metamodel.impl.uml.statik.NameSpaceSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.CallBehaviorAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("263559ae-b792-4606-bc85-3bc49331fac4")
public class BehaviorSmClass extends UmlModelElementSmClass {
    @objid ("96235f8d-43cb-41f1-8093-66f734668463")
    private SmAttribute isReentrantAtt;

    @objid ("7e0c3926-58e5-466a-9855-5101ad098d4c")
    private SmDependency ownerDep;

    @objid ("1f978aba-36d7-4b64-b1dc-2dac7504a994")
    private SmDependency parameterDep;

    @objid ("d2ecde72-d251-4292-89eb-24e018865d6a")
    private SmDependency ownerOperationDep;

    @objid ("39ef783a-2d0f-4e35-ba1d-1921440e93af")
    private SmDependency ownedCollaborationDep;

    @objid ("8f6ba073-37dc-4773-9a1a-7c47f69380c6")
    private SmDependency callerDep;

    @objid ("3a7f0247-70fa-4d8f-bd39-fdffe551b367")
    private SmDependency eComponentDep;

    @objid ("d0088f69-cab4-404d-8f7d-5e6376e2637f")
    private SmDependency effectOfDep;

    @objid ("9fafbc23-6a43-4c23-b9bf-b68097ccdcf5")
    public BehaviorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9a95b33f-a119-4ccf-a0f9-39d77eceef0a")
    @Override
    public String getName() {
        return "Behavior";

    }

    @objid ("eab4f797-41bf-455c-9c06-5f6198b36429")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("4af401f0-58d6-46d8-a230-489a1d69d810")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Behavior.class;

    }

    @objid ("739df72e-c411-4b00-b771-8d4c58d75658")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("65554e74-ec8a-4154-92ef-cae8dbe7deb3")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("0fa97d47-0cd5-40a4-ab14-175f01cd4848")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new BehaviorObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isReentrantAtt = new IsReentrantSmAttribute();
        this.isReentrantAtt.init("IsReentrant", this, Boolean.class );
        registerAttribute(this.isReentrantAtt);


        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.parameterDep = new ParameterSmDependency();
        this.parameterDep.init("Parameter", this, metamodel.getMClass(BehaviorParameter.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.parameterDep);

        this.ownerOperationDep = new OwnerOperationSmDependency();
        this.ownerOperationDep.init("OwnerOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.ownerOperationDep);

        this.ownedCollaborationDep = new OwnedCollaborationSmDependency();
        this.ownedCollaborationDep.init("OwnedCollaboration", this, metamodel.getMClass(Collaboration.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedCollaborationDep);

        this.callerDep = new CallerSmDependency();
        this.callerDep.init("Caller", this, metamodel.getMClass(CallBehaviorAction.MQNAME), 0, -1 );
        registerDependency(this.callerDep);

        this.eComponentDep = new EComponentSmDependency();
        this.eComponentDep.init("EComponent", this, metamodel.getMClass(Event.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.eComponentDep);

        this.effectOfDep = new EffectOfSmDependency();
        this.effectOfDep.init("EffectOf", this, metamodel.getMClass(Transition.MQNAME), 0, -1 );
        registerDependency(this.effectOfDep);

    }

    @objid ("b628fca1-c86a-4e84-afaf-b81488ede58c")
    public SmAttribute getIsReentrantAtt() {
        if (this.isReentrantAtt == null) {
        	this.isReentrantAtt = this.getAttributeDef("IsReentrant");
        }
        return this.isReentrantAtt;
    }

    @objid ("ae18edeb-4122-4826-917b-eb3d584be007")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("9c314b09-aaa8-43a6-8bb5-844627ec1636")
    public SmDependency getParameterDep() {
        if (this.parameterDep == null) {
        	this.parameterDep = this.getDependencyDef("Parameter");
        }
        return this.parameterDep;
    }

    @objid ("1923b1ad-3ba0-4333-a8a0-6ac6924fef2f")
    public SmDependency getOwnerOperationDep() {
        if (this.ownerOperationDep == null) {
        	this.ownerOperationDep = this.getDependencyDef("OwnerOperation");
        }
        return this.ownerOperationDep;
    }

    @objid ("1f7a9fe6-889d-409f-a0c1-72570d79913b")
    public SmDependency getOwnedCollaborationDep() {
        if (this.ownedCollaborationDep == null) {
        	this.ownedCollaborationDep = this.getDependencyDef("OwnedCollaboration");
        }
        return this.ownedCollaborationDep;
    }

    @objid ("25ea68cb-b5e3-4232-a04a-2947163d82c5")
    public SmDependency getCallerDep() {
        if (this.callerDep == null) {
        	this.callerDep = this.getDependencyDef("Caller");
        }
        return this.callerDep;
    }

    @objid ("230df737-bfb7-4277-be41-beead6208781")
    public SmDependency getEComponentDep() {
        if (this.eComponentDep == null) {
        	this.eComponentDep = this.getDependencyDef("EComponent");
        }
        return this.eComponentDep;
    }

    @objid ("2cb48fe3-b13b-47d6-b534-8b88efcb8964")
    public SmDependency getEffectOfDep() {
        if (this.effectOfDep == null) {
        	this.effectOfDep = this.getDependencyDef("EffectOf");
        }
        return this.effectOfDep;
    }

    @objid ("a904cfd4-9f8d-43c8-aebe-c37f5f7e8ab8")
    private static class BehaviorObjectFactory implements ISmObjectFactory {
        @objid ("b89940c5-f7c8-4c3a-8dd3-5665edcbc298")
        private BehaviorSmClass smClass;

        @objid ("cf890f52-79db-4b0d-898e-dba26b2bfa38")
        public BehaviorObjectFactory(BehaviorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8074b576-3204-41dc-864d-083166e99ba7")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("a5a7dada-ce06-4518-9966-6167e4f1f90d")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("27531df8-2475-4c87-bf97-1c4f5236ac27")
    public static class IsReentrantSmAttribute extends SmAttribute {
        @objid ("8e7ac835-0d82-45d0-aa27-77ec810a44d2")
        public Object getValue(ISmObjectData data) {
            return ((BehaviorData) data).mIsReentrant;
        }

        @objid ("b2e7cc51-2035-4fba-923c-3c56eaf01b16")
        public void setValue(ISmObjectData data, Object value) {
            ((BehaviorData) data).mIsReentrant = value;
        }

    }

    @objid ("ac1d0444-b5cd-4d44-8010-ff5541ed274e")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("63e28f59-d52e-41bb-9729-10c5761cb856")
        private SmDependency symetricDep;

        @objid ("e9086117-3c92-432a-8d5d-f197ae05e0cd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BehaviorData) data).mOwner;
        }

        @objid ("545af01a-da11-481a-ad23-f636e1e93e69")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BehaviorData) data).mOwner = value;
        }

        @objid ("afbccae1-b481-4310-beda-d5d8111e2e71")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedBehaviorDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a91e9eaa-2798-4694-a33d-cff4cde37c4a")
    public static class ParameterSmDependency extends SmMultipleDependency {
        @objid ("c1cd3109-1d0f-4d52-a792-7a623437b5f6")
        private SmDependency symetricDep;

        @objid ("e7961233-fa25-46fe-9630-d488424ffb93")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorData)data).mParameter != null)? ((BehaviorData)data).mParameter:SmMultipleDependency.EMPTY;
        }

        @objid ("c11ae6b4-b9a2-430c-82de-a65bd92015c4")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorData) data).mParameter = values;

        }

        @objid ("0647d2ce-a30d-4351-b620-64d316a64a17")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorParameterSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2f9465e7-2701-41e4-b1a7-fcc8b7c43fa4")
    public static class OwnerOperationSmDependency extends SmSingleDependency {
        @objid ("6b06c0e5-198b-4372-9adc-f0217d662c64")
        private SmDependency symetricDep;

        @objid ("9fb6f5d1-50ae-41e3-b87b-61aa383ccfa8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BehaviorData) data).mOwnerOperation;
        }

        @objid ("41ccef2a-5739-47d4-8864-1d2be32ee1ae")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BehaviorData) data).mOwnerOperation = value;
        }

        @objid ("2f48efeb-679a-46dc-bfb5-f95546c3ef4c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOwnedBehaviorDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("522b5a55-072b-4ba2-a9cb-72331a7aecdb")
    public static class OwnedCollaborationSmDependency extends SmMultipleDependency {
        @objid ("e72b0ea2-24df-48d1-979b-8fd53a44870e")
        private SmDependency symetricDep;

        @objid ("51c95d2c-c0d1-427d-8b5c-c92ad4211a78")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorData)data).mOwnedCollaboration != null)? ((BehaviorData)data).mOwnedCollaboration:SmMultipleDependency.EMPTY;
        }

        @objid ("ba64ead9-0c6c-4734-9e55-90d8de838940")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorData) data).mOwnedCollaboration = values;

        }

        @objid ("0e4b0dd8-8f62-4168-9b6b-a1d1c34b31a9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationSmClass)this.getTarget()).getBRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9fbed98a-4910-4fb5-9478-d48e7fbc8954")
    public static class CallerSmDependency extends SmMultipleDependency {
        @objid ("13f9fdc3-9382-48a4-990b-2aadf4eac382")
        private SmDependency symetricDep;

        @objid ("91cb06d8-29c6-4c16-b33e-b0bdee38b360")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorData)data).mCaller != null)? ((BehaviorData)data).mCaller:SmMultipleDependency.EMPTY;
        }

        @objid ("5cb858a4-ba23-4524-9ce1-83c340ae6fc6")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorData) data).mCaller = values;

        }

        @objid ("5faa0ccf-55da-4bc0-8b78-760c23826fae")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CallBehaviorActionSmClass)this.getTarget()).getCalledDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("91f067a3-654a-426b-8463-ab91e6e4d30c")
    public static class EComponentSmDependency extends SmMultipleDependency {
        @objid ("fdcab367-f5ba-46f2-9590-96be061416cc")
        private SmDependency symetricDep;

        @objid ("e42cd503-7273-4dd8-99ee-4a5b1f3c079d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorData)data).mEComponent != null)? ((BehaviorData)data).mEComponent:SmMultipleDependency.EMPTY;
        }

        @objid ("dfe150c1-d75e-4691-ad7b-99aeb20a19ca")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorData) data).mEComponent = values;

        }

        @objid ("5b489f61-9585-4054-a929-b0ce44ad02e2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EventSmClass)this.getTarget()).getComposedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7893f36d-c3bf-4e52-8ac5-1d379b9bdc1b")
    public static class EffectOfSmDependency extends SmMultipleDependency {
        @objid ("4bff2aa6-d6c5-4c35-8fdd-f56876a6f9f1")
        private SmDependency symetricDep;

        @objid ("0a344d8b-3e68-4a11-b44c-cb4e77af82bc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorData)data).mEffectOf != null)? ((BehaviorData)data).mEffectOf:SmMultipleDependency.EMPTY;
        }

        @objid ("efe84d85-7952-4010-a588-43b7d5708042")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorData) data).mEffectOf = values;

        }

        @objid ("076a3476-13ee-4b63-a7d3-8ceb3d2457bf")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getBehaviorEffectDep();
            }
            return this.symetricDep;

        }

    }

}
