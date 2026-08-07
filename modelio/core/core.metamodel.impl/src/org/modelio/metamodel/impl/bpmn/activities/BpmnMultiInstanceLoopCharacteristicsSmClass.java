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
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.MultiInstanceBehavior;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.impl.bpmn.events.BpmnEventDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataInputSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataOutputSmClass;
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

@objid ("728eb919-46e7-481f-99ed-6fb053421570")
public class BpmnMultiInstanceLoopCharacteristicsSmClass extends BpmnLoopCharacteristicsSmClass {
    @objid ("e00a39cf-3894-4618-a120-fddf36fdb098")
    private SmAttribute isSequencialAtt;

    @objid ("656f6259-c5aa-459e-973b-b5cc0ccb0432")
    private SmAttribute behaviorAtt;

    @objid ("6de42740-7424-48c6-908e-f8d307b2e569")
    private SmAttribute loopCardinalityAtt;

    @objid ("cf169f96-1f26-49fd-92b3-8e335cbddecd")
    private SmAttribute completionConditionAtt;

    @objid ("08f9864e-b1d5-427d-a37c-34678c013fb0")
    private SmDependency loopDataInputDep;

    @objid ("545c02c7-2063-496f-92ee-80657c3e59cd")
    private SmDependency loopDataOutputRefDep;

    @objid ("0da4bedf-c6ee-4d7c-a46e-c56f54161579")
    private SmDependency completionEventRefDep;

    @objid ("163f726c-652f-4851-b670-5241ae9f88c7")
    private SmDependency complexBehaviorDefinitionDep;

    @objid ("cd189769-3fe7-4b7c-a0b7-efcd8d9b70a8")
    public BpmnMultiInstanceLoopCharacteristicsSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9193857f-22ff-4397-8607-5fffa61b6bbe")
    @Override
    public String getName() {
        return "BpmnMultiInstanceLoopCharacteristics";

    }

    @objid ("f1982db6-7951-418b-87ba-1d74a4feea71")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("06bcbf8a-6814-4ce6-962c-37cea03b22d5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnMultiInstanceLoopCharacteristics.class;

    }

    @objid ("3e7dcdd9-02e9-4bd6-9ba3-857c1aeb4486")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5ce9706e-409b-4025-99de-f35e3af1119a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8c3bb34e-bdaa-4542-aba8-c97f2dbf6b5e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnLoopCharacteristics.MQNAME);
        this.registerFactory(new BpmnMultiInstanceLoopCharacteristicsObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isSequencialAtt = new IsSequencialSmAttribute();
        this.isSequencialAtt.init("IsSequencial", this, Boolean.class );
        registerAttribute(this.isSequencialAtt);

        this.behaviorAtt = new BehaviorSmAttribute();
        this.behaviorAtt.init("Behavior", this, MultiInstanceBehavior.class );
        registerAttribute(this.behaviorAtt);

        this.loopCardinalityAtt = new LoopCardinalitySmAttribute();
        this.loopCardinalityAtt.init("LoopCardinality", this, String.class );
        registerAttribute(this.loopCardinalityAtt);

        this.completionConditionAtt = new CompletionConditionSmAttribute();
        this.completionConditionAtt.init("CompletionCondition", this, String.class );
        registerAttribute(this.completionConditionAtt);


        // Initialize and register the SmDependency
        this.loopDataInputDep = new LoopDataInputSmDependency();
        this.loopDataInputDep.init("LoopDataInput", this, metamodel.getMClass(BpmnDataInput.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.loopDataInputDep);

        this.loopDataOutputRefDep = new LoopDataOutputRefSmDependency();
        this.loopDataOutputRefDep.init("LoopDataOutputRef", this, metamodel.getMClass(BpmnDataOutput.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.loopDataOutputRefDep);

        this.completionEventRefDep = new CompletionEventRefSmDependency();
        this.completionEventRefDep.init("CompletionEventRef", this, metamodel.getMClass(BpmnEventDefinition.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.completionEventRefDep);

        this.complexBehaviorDefinitionDep = new ComplexBehaviorDefinitionSmDependency();
        this.complexBehaviorDefinitionDep.init("ComplexBehaviorDefinition", this, metamodel.getMClass(BpmnComplexBehaviorDefinition.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.complexBehaviorDefinitionDep);

    }

    @objid ("aa242597-d689-4e6a-bb18-10ac1b5d6e4a")
    public SmAttribute getIsSequencialAtt() {
        if (this.isSequencialAtt == null) {
        	this.isSequencialAtt = this.getAttributeDef("IsSequencial");
        }
        return this.isSequencialAtt;
    }

    @objid ("1c069c9c-f77d-4d5a-94ae-020fb17a7ab5")
    public SmAttribute getBehaviorAtt() {
        if (this.behaviorAtt == null) {
        	this.behaviorAtt = this.getAttributeDef("Behavior");
        }
        return this.behaviorAtt;
    }

    @objid ("d3b35363-e47a-4cca-b914-95edbbf0c96d")
    public SmAttribute getLoopCardinalityAtt() {
        if (this.loopCardinalityAtt == null) {
        	this.loopCardinalityAtt = this.getAttributeDef("LoopCardinality");
        }
        return this.loopCardinalityAtt;
    }

    @objid ("5263cd9a-3854-4788-9616-5b88d8c5bcfc")
    public SmAttribute getCompletionConditionAtt() {
        if (this.completionConditionAtt == null) {
        	this.completionConditionAtt = this.getAttributeDef("CompletionCondition");
        }
        return this.completionConditionAtt;
    }

    @objid ("a70acf2b-7a91-4855-8996-8d225e88fc98")
    public SmDependency getLoopDataInputDep() {
        if (this.loopDataInputDep == null) {
        	this.loopDataInputDep = this.getDependencyDef("LoopDataInput");
        }
        return this.loopDataInputDep;
    }

    @objid ("092843a7-bb33-44ef-bcee-0ff009d70610")
    public SmDependency getLoopDataOutputRefDep() {
        if (this.loopDataOutputRefDep == null) {
        	this.loopDataOutputRefDep = this.getDependencyDef("LoopDataOutputRef");
        }
        return this.loopDataOutputRefDep;
    }

    @objid ("eab43a50-9897-4d73-86df-b147e9022099")
    public SmDependency getCompletionEventRefDep() {
        if (this.completionEventRefDep == null) {
        	this.completionEventRefDep = this.getDependencyDef("CompletionEventRef");
        }
        return this.completionEventRefDep;
    }

    @objid ("640e769d-a403-47de-8806-f31798424965")
    public SmDependency getComplexBehaviorDefinitionDep() {
        if (this.complexBehaviorDefinitionDep == null) {
        	this.complexBehaviorDefinitionDep = this.getDependencyDef("ComplexBehaviorDefinition");
        }
        return this.complexBehaviorDefinitionDep;
    }

    @objid ("aab2d464-9675-4cd7-be87-07cad63c2e93")
    private static class BpmnMultiInstanceLoopCharacteristicsObjectFactory implements ISmObjectFactory {
        @objid ("628db215-8e2d-45c7-82c6-68de7fae0724")
        private BpmnMultiInstanceLoopCharacteristicsSmClass smClass;

        @objid ("fabb0772-c82d-47dc-9f43-3a23d3f6ae59")
        public BpmnMultiInstanceLoopCharacteristicsObjectFactory(BpmnMultiInstanceLoopCharacteristicsSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c7d4a307-01a3-4285-91c0-1055872d986a")
        @Override
        public ISmObjectData createData() {
            return new BpmnMultiInstanceLoopCharacteristicsData(this.smClass);
        }

        @objid ("1e2b4e82-ad78-4f6d-b632-c5a0c7bbc526")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnMultiInstanceLoopCharacteristicsImpl();
        }

    }

    @objid ("e3706e54-232a-4e57-9012-0c1a2eda559b")
    public static class IsSequencialSmAttribute extends SmAttribute {
        @objid ("caa3be25-4b73-414e-9b6b-f3c1b6e66258")
        public Object getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mIsSequencial;
        }

        @objid ("0147879c-98d2-45e4-b456-c0d9ba49a99c")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mIsSequencial = value;
        }

    }

    @objid ("4da80f46-d54f-4d4c-b9f6-a121218c86a5")
    public static class BehaviorSmAttribute extends SmAttribute {
        @objid ("a860a058-d724-446f-b45e-653c3e5b77a4")
        public Object getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mBehavior;
        }

        @objid ("7396718b-320c-4295-8ceb-3eac2f43fb89")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mBehavior = value;
        }

    }

    @objid ("77e8bd81-ca50-4150-8fe8-1a35f2e4f9c4")
    public static class LoopCardinalitySmAttribute extends SmAttribute {
        @objid ("6473272b-81b3-42c1-8d07-7f5234a709e3")
        public Object getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopCardinality;
        }

        @objid ("df977f8d-6bfe-43d5-a9a3-51649fb11c73")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopCardinality = value;
        }

    }

    @objid ("3eaf4979-d31a-4493-8c40-1c5b0458f8b5")
    public static class CompletionConditionSmAttribute extends SmAttribute {
        @objid ("2013893a-33f6-42bd-99ff-23934c77424a")
        public Object getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mCompletionCondition;
        }

        @objid ("77cd9cad-02e2-4778-9cd7-d61cfc7dd0a8")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mCompletionCondition = value;
        }

    }

    @objid ("e050e52e-81bf-4f54-9f0a-3765855dafb9")
    public static class LoopDataInputSmDependency extends SmSingleDependency {
        @objid ("beca51e4-1b41-48aa-bcb0-df28bf6432ed")
        private SmDependency symetricDep;

        @objid ("a263b089-2302-4c35-aae3-a69d77ae1906")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopDataInput;
        }

        @objid ("c24b8f20-3361-465c-8489-40b887517978")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopDataInput = value;
        }

        @objid ("ba305fc3-e27f-414c-a65c-19b972a666db")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataInputSmClass)this.getTarget()).getOwnerLoopCharacteristicsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2f7564e8-faa9-4d9b-98d5-db8234433109")
    public static class LoopDataOutputRefSmDependency extends SmSingleDependency {
        @objid ("80443fd2-fa43-4f5d-aefb-b92600394fc5")
        private SmDependency symetricDep;

        @objid ("d481c217-62e9-4f0d-9944-cf2581e12371")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopDataOutputRef;
        }

        @objid ("5cb91233-6103-4743-980b-51f56b1e5522")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mLoopDataOutputRef = value;
        }

        @objid ("538b31f5-af88-46e6-b042-f91a99dbb18a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataOutputSmClass)this.getTarget()).getOwnerLoopCharacteristicsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("617ca00c-dd2d-4ebe-89cd-cad1a68db1a0")
    public static class CompletionEventRefSmDependency extends SmSingleDependency {
        @objid ("6654c96a-fd36-4e4d-84d4-dd2e8cc522e7")
        private SmDependency symetricDep;

        @objid ("4d273dc8-d76a-41c9-81da-17605bf05451")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMultiInstanceLoopCharacteristicsData) data).mCompletionEventRef;
        }

        @objid ("d7f3844a-6967-4b81-a4f2-aa34be6824d5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mCompletionEventRef = value;
        }

        @objid ("5a74d28f-be8e-4c2d-9432-5e47c108268a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnEventDefinitionSmClass)this.getTarget()).getLoopRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("175960fb-79c5-4cc5-94ad-bbf5eff52359")
    public static class ComplexBehaviorDefinitionSmDependency extends SmMultipleDependency {
        @objid ("7d0d0734-f32f-481e-be86-9fb8e75fa246")
        private SmDependency symetricDep;

        @objid ("8cc4eaa7-6a57-4e8f-8d09-717b931d90d1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMultiInstanceLoopCharacteristicsData)data).mComplexBehaviorDefinition != null)? ((BpmnMultiInstanceLoopCharacteristicsData)data).mComplexBehaviorDefinition:SmMultipleDependency.EMPTY;
        }

        @objid ("b76d6489-998b-4d50-b3f8-71a68b148382")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMultiInstanceLoopCharacteristicsData) data).mComplexBehaviorDefinition = values;

        }

        @objid ("6f486e59-2d19-417b-b35f-e4f5d4fd578a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnComplexBehaviorDefinitionSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
