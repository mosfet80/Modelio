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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.events.BpmnImplicitThrowEventSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1ff7f11f-681a-4bbf-915b-70cf03d97e97")
public class BpmnComplexBehaviorDefinitionSmClass extends BpmnBaseElementSmClass {
    @objid ("aa2f928f-4e06-40f2-8402-d6f48b941f31")
    private SmAttribute conditionAtt;

    @objid ("bf0efd03-426a-4184-bec5-491664881e86")
    private SmDependency ownerDep;

    @objid ("1facd200-1e8d-4e4b-a7ee-2f92bd1313ce")
    private SmDependency eventDep;

    @objid ("7dabbb78-0442-4cd1-a05a-a4eae9249c3e")
    public BpmnComplexBehaviorDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e91afc4e-4580-43b9-b5aa-1e1bf818cd77")
    @Override
    public String getName() {
        return "BpmnComplexBehaviorDefinition";

    }

    @objid ("bae6ac66-1f03-4266-8e18-5621c8c99c93")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c4306910-928a-415f-9616-5fe6adbebe73")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnComplexBehaviorDefinition.class;

    }

    @objid ("ceb4f403-5c3f-4288-b6fa-bb3a4c7b1508")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fa3bb68d-6742-496f-86c6-19ae3780fb0c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("453dee02-da83-4458-994f-953186dc5c76")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnComplexBehaviorDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.conditionAtt = new ConditionSmAttribute();
        this.conditionAtt.init("Condition", this, String.class );
        registerAttribute(this.conditionAtt);


        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(BpmnMultiInstanceLoopCharacteristics.MQNAME), 1, 1 );
        registerDependency(this.ownerDep);

        this.eventDep = new EventSmDependency();
        this.eventDep.init("Event", this, metamodel.getMClass(BpmnImplicitThrowEvent.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.eventDep);

    }

    @objid ("ab0ee280-fab7-4bfb-90a6-8cc6e7aa6b74")
    public SmAttribute getConditionAtt() {
        if (this.conditionAtt == null) {
        	this.conditionAtt = this.getAttributeDef("Condition");
        }
        return this.conditionAtt;
    }

    @objid ("5e500eb0-6351-4777-a952-e7b93e605e15")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("d6dcb8ce-cfbd-4b64-809e-04c05179670b")
    public SmDependency getEventDep() {
        if (this.eventDep == null) {
        	this.eventDep = this.getDependencyDef("Event");
        }
        return this.eventDep;
    }

    @objid ("0f87b3e2-1040-46b9-9e43-556f78a3adac")
    private static class BpmnComplexBehaviorDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("117a6d4b-f60f-4f6a-a983-aca1071ad819")
        private BpmnComplexBehaviorDefinitionSmClass smClass;

        @objid ("3ed86f23-ded1-4212-8fb0-15056a9baa10")
        public BpmnComplexBehaviorDefinitionObjectFactory(BpmnComplexBehaviorDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("132fee66-33ed-4372-a5d2-111b5ecbda15")
        @Override
        public ISmObjectData createData() {
            return new BpmnComplexBehaviorDefinitionData(this.smClass);
        }

        @objid ("65eb82db-809e-4a3d-8eb0-1d67707ea1ae")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnComplexBehaviorDefinitionImpl();
        }

    }

    @objid ("b2e9132b-b740-4a52-8ace-88a624d33771")
    public static class ConditionSmAttribute extends SmAttribute {
        @objid ("0b55d511-ff80-4cee-9bdf-a8ed972ef25b")
        public Object getValue(ISmObjectData data) {
            return ((BpmnComplexBehaviorDefinitionData) data).mCondition;
        }

        @objid ("4fa34585-f477-4b0a-a390-ba9fb813b171")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnComplexBehaviorDefinitionData) data).mCondition = value;
        }

    }

    @objid ("54aeea88-4ab7-45cc-94ec-c6799458397c")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("d3ae18b0-0b52-46ea-aeb2-d2028a125ac1")
        private SmDependency symetricDep;

        @objid ("a9cddab8-fa52-4cc3-b938-3bbc6e9eb446")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnComplexBehaviorDefinitionData) data).mOwner;
        }

        @objid ("2247fed2-e4da-4e5e-b67f-d1e5d7f9296f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnComplexBehaviorDefinitionData) data).mOwner = value;
        }

        @objid ("6704e09e-8a4e-44e0-85bc-07821f73c6d9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMultiInstanceLoopCharacteristicsSmClass)this.getTarget()).getComplexBehaviorDefinitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3b73df91-d11a-4417-b276-f9bccb49f5d1")
    public static class EventSmDependency extends SmSingleDependency {
        @objid ("4c2da251-716b-495c-8876-3b2dce5545cd")
        private SmDependency symetricDep;

        @objid ("8b95f398-f532-41e9-9805-5d8608fd90d4")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnComplexBehaviorDefinitionData) data).mEvent;
        }

        @objid ("3f4dd3be-f611-4fa8-9f4b-d7a8eb98f4ff")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnComplexBehaviorDefinitionData) data).mEvent = value;
        }

        @objid ("a3015e6a-cfd5-44ac-a5b6-9a4d27916e45")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnImplicitThrowEventSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
