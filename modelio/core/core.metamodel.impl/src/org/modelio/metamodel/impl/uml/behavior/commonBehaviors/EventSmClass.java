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
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.StateSmClass;
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.TransitionSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.EventType;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("05712d4f-4cfb-40cc-af04-edb94f0e9624")
public class EventSmClass extends UmlModelElementSmClass {
    @objid ("97526a01-f005-4d39-9efd-d4c39e38e5c6")
    private SmAttribute expressionAtt;

    @objid ("4973ca61-13d6-4c03-9eed-fe9f287c47fb")
    private SmAttribute kindAtt;

    @objid ("b81e2dbb-899f-40e7-9815-9831234599ef")
    private SmDependency triggeredDep;

    @objid ("3fb525d9-088e-4070-8867-17404da872aa")
    private SmDependency modelDep;

    @objid ("bb18a2d6-0cd5-414d-9d0f-9d242dc80530")
    private SmDependency originDep;

    @objid ("e8afc3bd-ed04-4fcf-ad47-9d3bec414cd8")
    private SmDependency calledDep;

    @objid ("4699e348-ffd4-46cb-9839-18cea6509484")
    private SmDependency composedDep;

    @objid ("646d8e29-af0e-4d83-91e7-1f62bfd500f0")
    public EventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("dbc7c60f-a825-4816-9773-321267e2fa1c")
    @Override
    public String getName() {
        return "Event";

    }

    @objid ("e4b15fab-d2f9-45c1-a91e-f35753cdc0f8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("61c18df5-0d2c-4942-906a-c05c4396f8f2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Event.class;

    }

    @objid ("6d9538d2-71a2-4d24-a4c2-8432705fd906")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3ccc59d0-d099-4777-9cdc-63f29b7d3df2")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("12148a70-9858-4078-923e-24a803cba154")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new EventObjectFactory(this));


        // Initialize and register the SmAttribute
        this.expressionAtt = new ExpressionSmAttribute();
        this.expressionAtt.init("Expression", this, String.class );
        registerAttribute(this.expressionAtt);

        this.kindAtt = new KindSmAttribute();
        this.kindAtt.init("Kind", this, EventType.class );
        registerAttribute(this.kindAtt);


        // Initialize and register the SmDependency
        this.triggeredDep = new TriggeredSmDependency();
        this.triggeredDep.init("Triggered", this, metamodel.getMClass(Transition.MQNAME), 0, -1 );
        registerDependency(this.triggeredDep);

        this.modelDep = new ModelSmDependency();
        this.modelDep.init("Model", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.modelDep);

        this.originDep = new OriginSmDependency();
        this.originDep.init("Origin", this, metamodel.getMClass(State.MQNAME), 0, -1 );
        registerDependency(this.originDep);

        this.calledDep = new CalledSmDependency();
        this.calledDep.init("Called", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.calledDep);

        this.composedDep = new ComposedSmDependency();
        this.composedDep.init("Composed", this, metamodel.getMClass(Behavior.MQNAME), 1, 1 );
        registerDependency(this.composedDep);

    }

    @objid ("524851ee-fa0d-4ce4-bf6f-1341c6de27f1")
    public SmAttribute getExpressionAtt() {
        if (this.expressionAtt == null) {
        	this.expressionAtt = this.getAttributeDef("Expression");
        }
        return this.expressionAtt;
    }

    @objid ("3d84aa9b-4e67-43e0-81c6-756cb246c120")
    public SmAttribute getKindAtt() {
        if (this.kindAtt == null) {
        	this.kindAtt = this.getAttributeDef("Kind");
        }
        return this.kindAtt;
    }

    @objid ("255ae74f-cbb8-4660-a5d5-005d29c4fd67")
    public SmDependency getTriggeredDep() {
        if (this.triggeredDep == null) {
        	this.triggeredDep = this.getDependencyDef("Triggered");
        }
        return this.triggeredDep;
    }

    @objid ("6e23a08f-1558-411d-9724-52046eb8b89d")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("Model");
        }
        return this.modelDep;
    }

    @objid ("be8a29b3-9bf9-4a89-bd21-d7110df55706")
    public SmDependency getOriginDep() {
        if (this.originDep == null) {
        	this.originDep = this.getDependencyDef("Origin");
        }
        return this.originDep;
    }

    @objid ("16c15f5f-f312-401a-8575-c1879ea6af06")
    public SmDependency getCalledDep() {
        if (this.calledDep == null) {
        	this.calledDep = this.getDependencyDef("Called");
        }
        return this.calledDep;
    }

    @objid ("bcdb1c42-391b-4a7c-9be2-075f5952261a")
    public SmDependency getComposedDep() {
        if (this.composedDep == null) {
        	this.composedDep = this.getDependencyDef("Composed");
        }
        return this.composedDep;
    }

    @objid ("dda9f412-ae8b-4425-ba67-9674f8a6c336")
    private static class EventObjectFactory implements ISmObjectFactory {
        @objid ("22811a44-2053-4004-a0bc-4ac50c9428d1")
        private EventSmClass smClass;

        @objid ("0a0ad1ec-7a2d-47e0-b2df-f2089fa857d2")
        public EventObjectFactory(EventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("60cd31a6-239e-416d-aa96-da2cd2014b8b")
        @Override
        public ISmObjectData createData() {
            return new EventData(this.smClass);
        }

        @objid ("a9c78000-43a8-49a9-86a5-ae2fc7a9592c")
        @Override
        public SmObjectImpl createImpl() {
            return new EventImpl();
        }

    }

    @objid ("287514de-0c70-44f6-b824-44b62b0d0438")
    public static class ExpressionSmAttribute extends SmAttribute {
        @objid ("78fad1b8-0c5d-4f2d-a327-1fd57f87e622")
        public Object getValue(ISmObjectData data) {
            return ((EventData) data).mExpression;
        }

        @objid ("df4ff713-50af-4e15-a812-576d379602d2")
        public void setValue(ISmObjectData data, Object value) {
            ((EventData) data).mExpression = value;
        }

    }

    @objid ("533272f3-678c-47bd-bda5-045c626400e8")
    public static class KindSmAttribute extends SmAttribute {
        @objid ("9712efaf-ec6a-453d-a604-142f3e14e248")
        public Object getValue(ISmObjectData data) {
            return ((EventData) data).mKind;
        }

        @objid ("ebe321bc-5db9-47fa-a859-c643b3cdeb81")
        public void setValue(ISmObjectData data, Object value) {
            ((EventData) data).mKind = value;
        }

    }

    @objid ("dcc9b19e-208e-4d79-8b20-f9bb65eb12af")
    public static class TriggeredSmDependency extends SmMultipleDependency {
        @objid ("30455a08-e747-43cf-a113-649341379974")
        private SmDependency symetricDep;

        @objid ("96b63692-86d5-4372-94eb-e036fcf5e104")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((EventData)data).mTriggered != null)? ((EventData)data).mTriggered:SmMultipleDependency.EMPTY;
        }

        @objid ("7dde7662-5ff7-45f2-bb27-179e4e93116b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((EventData) data).mTriggered = values;

        }

        @objid ("12658d33-49bc-4973-abfa-0c65ba5e4cfc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getTriggerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("992e1da2-27ab-414b-98ab-13571789fb18")
    public static class ModelSmDependency extends SmSingleDependency {
        @objid ("7daaa387-dfd5-4019-abc9-09255d1e3995")
        private SmDependency symetricDep;

        @objid ("ab8d5f73-76ca-4298-b6b6-010b76edb5aa")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EventData) data).mModel;
        }

        @objid ("3419fda3-c48f-4642-938d-a9a2c3eba0c6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EventData) data).mModel = value;
        }

        @objid ("95f7f7c9-696e-43c2-b2f7-ff9b6ee15a67")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getEOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("719bcb22-ea5d-46db-907b-9feb247b606c")
    public static class OriginSmDependency extends SmMultipleDependency {
        @objid ("10be4cb1-0a28-4f9b-9e22-9791d3cf77d0")
        private SmDependency symetricDep;

        @objid ("cf7d6dbc-964e-46e2-b565-45ba29793ac0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((EventData)data).mOrigin != null)? ((EventData)data).mOrigin:SmMultipleDependency.EMPTY;
        }

        @objid ("fcacbf45-eabb-4074-8aff-39d170ae5102")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((EventData) data).mOrigin = values;

        }

        @objid ("aab91549-3b1b-4a5e-a5bc-c7f657383b00")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getDefferedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6b6ff990-e161-4fb8-b0fe-a67f54645d53")
    public static class CalledSmDependency extends SmSingleDependency {
        @objid ("d8faf3b3-85d0-4931-8169-f3d7877a4f36")
        private SmDependency symetricDep;

        @objid ("9421f74a-0906-4f82-9dff-581f10e85218")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EventData) data).mCalled;
        }

        @objid ("717ebb31-684e-4086-b523-7e03dd8b11c8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EventData) data).mCalled = value;
        }

        @objid ("0dbe120c-7c5c-49eb-abba-8b5e02cb6270")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b3780d04-a999-4e3d-b12b-ef19555757d4")
    public static class ComposedSmDependency extends SmSingleDependency {
        @objid ("3c1bd95c-2aef-4a56-adee-f81a40a6490e")
        private SmDependency symetricDep;

        @objid ("47e17119-9a4c-4650-9ce2-673396260b92")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EventData) data).mComposed;
        }

        @objid ("716871ac-ed92-4e39-87be-9b61aaf360a4")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EventData) data).mComposed = value;
        }

        @objid ("e6d8b0ed-a843-4512-bfb1-f6cc1afdc980")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getEComponentDep();
            }
            return this.symetricDep;

        }

    }

}
