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
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.events.BpmnBoundaryEventSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnCompensateEventDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataAssociationSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataInputSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataOutputSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeSmClass;
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

@objid ("aae718e0-b605-413c-a620-6fb67af356c4")
public class BpmnActivitySmClass extends BpmnFlowNodeSmClass {
    @objid ("538e4c42-52d6-4513-883e-fe35c6459f90")
    private SmAttribute isForCompensationAtt;

    @objid ("b0bd105f-2fbd-4c55-a356-9b68b890706f")
    private SmAttribute startQuantityAtt;

    @objid ("6ca6ce04-fd9f-41c4-9f19-9ed5d87f29cf")
    private SmAttribute completionQuantityAtt;

    @objid ("e760972c-b1e6-4501-b420-7159f3bc1c86")
    private SmDependency compensateEventDefinitionsDep;

    @objid ("a2e50483-d41f-468c-b24c-906441dd337e")
    private SmDependency inputSpecificationDep;

    @objid ("38edce79-a805-4ca0-b677-b7852f36a4e1")
    private SmDependency dataInputAssociationDep;

    @objid ("76fcde92-6f00-42b2-8c8e-89666f88d4f6")
    private SmDependency outputSpecificationDep;

    @objid ("8d73e7c4-8540-426d-b3b2-9353651bde58")
    private SmDependency loopCharacteristicsDep;

    @objid ("8fa536eb-d523-41b6-8943-c8f66bac1e5e")
    private SmDependency boundaryEventRefDep;

    @objid ("6524d6c3-9b53-42f9-918c-cefed9909379")
    private SmDependency dataOutputAssociationDep;

    @objid ("03c2199e-1b67-49dd-a842-acb817652c67")
    private SmDependency defaultFlowDep;

    @objid ("bacf77f0-3285-4980-b79b-da503b7b2249")
    public BpmnActivitySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5d5fbb4b-320a-4d0b-a481-b46acaaeccfb")
    @Override
    public String getName() {
        return "BpmnActivity";

    }

    @objid ("c4e94f3b-bfb1-43be-a88b-bbcd9f538b0a")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("69006555-991d-4c08-b95a-ffc6e8fd6885")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnActivity.class;

    }

    @objid ("f0f284e4-42c1-4689-8b48-5fc38dc556c9")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9a63c97b-4f46-45b9-9a71-244f0f51852b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e71f6124-1d76-4fbc-b508-5f4cafb94c20")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowNode.MQNAME);
        this.registerFactory(new BpmnActivityObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isForCompensationAtt = new IsForCompensationSmAttribute();
        this.isForCompensationAtt.init("IsForCompensation", this, Boolean.class );
        registerAttribute(this.isForCompensationAtt);

        this.startQuantityAtt = new StartQuantitySmAttribute();
        this.startQuantityAtt.init("StartQuantity", this, Integer.class );
        registerAttribute(this.startQuantityAtt);

        this.completionQuantityAtt = new CompletionQuantitySmAttribute();
        this.completionQuantityAtt.init("CompletionQuantity", this, Integer.class );
        registerAttribute(this.completionQuantityAtt);


        // Initialize and register the SmDependency
        this.compensateEventDefinitionsDep = new CompensateEventDefinitionsSmDependency();
        this.compensateEventDefinitionsDep.init("CompensateEventDefinitions", this, metamodel.getMClass(BpmnCompensateEventDefinition.MQNAME), 0, -1 );
        registerDependency(this.compensateEventDefinitionsDep);

        this.inputSpecificationDep = new InputSpecificationSmDependency();
        this.inputSpecificationDep.init("InputSpecification", this, metamodel.getMClass(BpmnDataInput.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.inputSpecificationDep);

        this.dataInputAssociationDep = new DataInputAssociationSmDependency();
        this.dataInputAssociationDep.init("DataInputAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataInputAssociationDep);

        this.outputSpecificationDep = new OutputSpecificationSmDependency();
        this.outputSpecificationDep.init("OutputSpecification", this, metamodel.getMClass(BpmnDataOutput.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.outputSpecificationDep);

        this.loopCharacteristicsDep = new LoopCharacteristicsSmDependency();
        this.loopCharacteristicsDep.init("LoopCharacteristics", this, metamodel.getMClass(BpmnLoopCharacteristics.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.loopCharacteristicsDep);

        this.boundaryEventRefDep = new BoundaryEventRefSmDependency();
        this.boundaryEventRefDep.init("BoundaryEventRef", this, metamodel.getMClass(BpmnBoundaryEvent.MQNAME), 0, -1 , SmDirective.SMCDPARTOF, SmDirective.SMCDTODELETE);
        registerDependency(this.boundaryEventRefDep);

        this.dataOutputAssociationDep = new DataOutputAssociationSmDependency();
        this.dataOutputAssociationDep.init("DataOutputAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataOutputAssociationDep);

        this.defaultFlowDep = new DefaultFlowSmDependency();
        this.defaultFlowDep.init("DefaultFlow", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defaultFlowDep);

    }

    @objid ("6a9f418a-d861-48c1-9b8a-377dce738c24")
    public SmAttribute getIsForCompensationAtt() {
        if (this.isForCompensationAtt == null) {
        	this.isForCompensationAtt = this.getAttributeDef("IsForCompensation");
        }
        return this.isForCompensationAtt;
    }

    @objid ("9a073ce2-03fd-4b9e-bf84-edfe91f02f08")
    public SmAttribute getStartQuantityAtt() {
        if (this.startQuantityAtt == null) {
        	this.startQuantityAtt = this.getAttributeDef("StartQuantity");
        }
        return this.startQuantityAtt;
    }

    @objid ("8284e529-371e-4b15-8871-f61bc0636947")
    public SmAttribute getCompletionQuantityAtt() {
        if (this.completionQuantityAtt == null) {
        	this.completionQuantityAtt = this.getAttributeDef("CompletionQuantity");
        }
        return this.completionQuantityAtt;
    }

    @objid ("d883e935-c74d-407d-9fb2-293ef1d11873")
    public SmDependency getCompensateEventDefinitionsDep() {
        if (this.compensateEventDefinitionsDep == null) {
        	this.compensateEventDefinitionsDep = this.getDependencyDef("CompensateEventDefinitions");
        }
        return this.compensateEventDefinitionsDep;
    }

    @objid ("c355bafd-867d-4b92-8a77-3f0b86c6803e")
    public SmDependency getInputSpecificationDep() {
        if (this.inputSpecificationDep == null) {
        	this.inputSpecificationDep = this.getDependencyDef("InputSpecification");
        }
        return this.inputSpecificationDep;
    }

    @objid ("a717e0f1-0b63-4942-87b3-bb4e07ecb017")
    public SmDependency getDataInputAssociationDep() {
        if (this.dataInputAssociationDep == null) {
        	this.dataInputAssociationDep = this.getDependencyDef("DataInputAssociation");
        }
        return this.dataInputAssociationDep;
    }

    @objid ("99936c3f-5e10-4f61-8be4-5faf979b59f6")
    public SmDependency getOutputSpecificationDep() {
        if (this.outputSpecificationDep == null) {
        	this.outputSpecificationDep = this.getDependencyDef("OutputSpecification");
        }
        return this.outputSpecificationDep;
    }

    @objid ("63d0df43-5d5a-4041-b238-e0649fc21983")
    public SmDependency getLoopCharacteristicsDep() {
        if (this.loopCharacteristicsDep == null) {
        	this.loopCharacteristicsDep = this.getDependencyDef("LoopCharacteristics");
        }
        return this.loopCharacteristicsDep;
    }

    @objid ("dff96c41-c761-46aa-88a6-ab6297260628")
    public SmDependency getBoundaryEventRefDep() {
        if (this.boundaryEventRefDep == null) {
        	this.boundaryEventRefDep = this.getDependencyDef("BoundaryEventRef");
        }
        return this.boundaryEventRefDep;
    }

    @objid ("cf8389cf-2f96-454e-91a4-24cf8fdff7e4")
    public SmDependency getDataOutputAssociationDep() {
        if (this.dataOutputAssociationDep == null) {
        	this.dataOutputAssociationDep = this.getDependencyDef("DataOutputAssociation");
        }
        return this.dataOutputAssociationDep;
    }

    @objid ("50b49a68-9d3d-46b7-a4cb-c5468e4e265b")
    public SmDependency getDefaultFlowDep() {
        if (this.defaultFlowDep == null) {
        	this.defaultFlowDep = this.getDependencyDef("DefaultFlow");
        }
        return this.defaultFlowDep;
    }

    @objid ("bfc381b3-9be7-419b-ae39-99d34d909f23")
    private static class BpmnActivityObjectFactory implements ISmObjectFactory {
        @objid ("521746fa-a6b2-4bcd-b652-9ca30f5bcede")
        private BpmnActivitySmClass smClass;

        @objid ("ec7b2bb3-b0fd-485f-80db-ee01441f3b47")
        public BpmnActivityObjectFactory(BpmnActivitySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4a41c3c3-268c-4fc3-aba2-ff8973f70ac0")
        @Override
        public ISmObjectData createData() {
            return new BpmnActivityData(this.smClass);
        }

        @objid ("e471ef37-86ba-4c46-9f2b-48d6bc2afc55")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnActivityImpl();
        }

    }

    @objid ("b5ecf71a-fb7e-47cf-b970-c34f1edc5743")
    public static class IsForCompensationSmAttribute extends SmAttribute {
        @objid ("3d35a554-db9c-4b91-abbb-2b3a9650eeb8")
        public Object getValue(ISmObjectData data) {
            return ((BpmnActivityData) data).mIsForCompensation;
        }

        @objid ("0293e04b-01ea-43ea-9a3b-489b5a63332b")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnActivityData) data).mIsForCompensation = value;
        }

    }

    @objid ("8ba5d71c-61f3-4f7e-bccc-daf415df56f7")
    public static class StartQuantitySmAttribute extends SmAttribute {
        @objid ("5dd11e25-e10f-4426-b3c3-3a8ca9e574c2")
        public Object getValue(ISmObjectData data) {
            return ((BpmnActivityData) data).mStartQuantity;
        }

        @objid ("a960b7ea-242d-458d-8503-a491a7fdffe1")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnActivityData) data).mStartQuantity = value;
        }

    }

    @objid ("d0bf7848-2e42-47cc-a448-5a8f06f45ac8")
    public static class CompletionQuantitySmAttribute extends SmAttribute {
        @objid ("940d984f-7334-44b7-b3ec-301d266556e6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnActivityData) data).mCompletionQuantity;
        }

        @objid ("96f9474e-6993-4656-bbad-827d2c5c1001")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnActivityData) data).mCompletionQuantity = value;
        }

    }

    @objid ("b7253dce-6170-41ef-860f-e2fc4db13a65")
    public static class CompensateEventDefinitionsSmDependency extends SmMultipleDependency {
        @objid ("069c076e-9c78-45b8-97e1-12bfcf94c106")
        private SmDependency symetricDep;

        @objid ("3e1f948c-245d-48a2-b170-ae7dd76f133f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mCompensateEventDefinitions != null)? ((BpmnActivityData)data).mCompensateEventDefinitions:SmMultipleDependency.EMPTY;
        }

        @objid ("aded0eed-4384-4f99-a36e-d65830984dee")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mCompensateEventDefinitions = values;

        }

        @objid ("23373077-7911-4d23-bd8e-55b50cbfc4e0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCompensateEventDefinitionSmClass)this.getTarget()).getActivityRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("56a7e9b8-dc74-4eb7-ae8f-317032638f0a")
    public static class InputSpecificationSmDependency extends SmMultipleDependency {
        @objid ("853a6e1c-71c3-42a8-98bf-dea6d172938c")
        private SmDependency symetricDep;

        @objid ("445dedc9-41b4-4e58-8ece-e0df4473b7c8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mInputSpecification != null)? ((BpmnActivityData)data).mInputSpecification:SmMultipleDependency.EMPTY;
        }

        @objid ("cf0be29b-266a-4d54-aa22-f13a2c6d2347")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mInputSpecification = values;

        }

        @objid ("3ccc61c1-b1a5-491e-a0bd-75bf2286af52")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataInputSmClass)this.getTarget()).getOwnerActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1144f8c3-b2f9-4082-b2c7-3e5744a955db")
    public static class DataInputAssociationSmDependency extends SmMultipleDependency {
        @objid ("a4fefc47-d1a2-49bc-bcce-2f93a4142766")
        private SmDependency symetricDep;

        @objid ("b8bbefa7-7e72-4954-b5a7-21d3da4f74f1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mDataInputAssociation != null)? ((BpmnActivityData)data).mDataInputAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("d388ed22-35cf-42fa-9750-3945d9c6a36a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mDataInputAssociation = values;

        }

        @objid ("3edb8830-06c3-49de-a910-9b8376b57653")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getStartingActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e3367f6c-3463-4697-a655-61ace01697db")
    public static class OutputSpecificationSmDependency extends SmMultipleDependency {
        @objid ("d8abc028-9a7d-4f78-b483-3cd5c8c5ab12")
        private SmDependency symetricDep;

        @objid ("3a60371b-8947-4f3e-b22e-e17fb5e9cfcc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mOutputSpecification != null)? ((BpmnActivityData)data).mOutputSpecification:SmMultipleDependency.EMPTY;
        }

        @objid ("2b1db7b5-a0f1-4d93-bafb-d37c8963f465")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mOutputSpecification = values;

        }

        @objid ("a32511fb-5ee1-4bc2-8cd1-5fdff24a4148")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataOutputSmClass)this.getTarget()).getOwnerActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("beae45fb-1a38-4382-8e03-de1279f14150")
    public static class LoopCharacteristicsSmDependency extends SmSingleDependency {
        @objid ("c28aa29f-d4cd-42c3-b35d-cc3542eb165b")
        private SmDependency symetricDep;

        @objid ("d4973826-a802-41f3-b712-4251f6aff142")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnActivityData) data).mLoopCharacteristics;
        }

        @objid ("2d9917f6-538d-4550-9da2-22f0735214d8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnActivityData) data).mLoopCharacteristics = value;
        }

        @objid ("d738af5a-d91a-40d7-9aa6-d04d8a6eabb4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLoopCharacteristicsSmClass)this.getTarget()).getOwnerActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("723aa153-e04e-40a8-808d-1ffeef5d971f")
    public static class BoundaryEventRefSmDependency extends SmMultipleDependency {
        @objid ("433ed364-81a2-4342-bb53-1317aa51dd00")
        private SmDependency symetricDep;

        @objid ("33e90e11-cac3-4a60-82c6-5b7c141b83e2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mBoundaryEventRef != null)? ((BpmnActivityData)data).mBoundaryEventRef:SmMultipleDependency.EMPTY;
        }

        @objid ("3edd39c4-85a7-4c5c-b0b9-08e4da8f43c7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mBoundaryEventRef = values;

        }

        @objid ("167cb7d8-a1ed-49f3-95b5-ebe1aa50608a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBoundaryEventSmClass)this.getTarget()).getAttachedToRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("83b90c82-7ae5-40cb-aa8f-31afb28e0578")
    public static class DataOutputAssociationSmDependency extends SmMultipleDependency {
        @objid ("0e74eb1b-82bb-442d-b008-2bd9bc83b838")
        private SmDependency symetricDep;

        @objid ("8dacf1e8-f3d6-4695-b01c-8b689553da7a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnActivityData)data).mDataOutputAssociation != null)? ((BpmnActivityData)data).mDataOutputAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("099fbf49-0541-4f55-8d6f-6e76973eb1e3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnActivityData) data).mDataOutputAssociation = values;

        }

        @objid ("66f0f350-6dd1-4a5f-b0d7-ce0968e57714")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getEndingActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("676e5386-2882-4b74-a08f-00c76a73eed1")
    public static class DefaultFlowSmDependency extends SmSingleDependency {
        @objid ("148443e0-b828-4e71-a8c3-85ac8ee8b874")
        private SmDependency symetricDep;

        @objid ("bc78c506-1cc3-4b4d-9394-67a46592bd34")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnActivityData) data).mDefaultFlow;
        }

        @objid ("8d9b5c4f-4830-4860-8310-1895ffad57df")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnActivityData) data).mDefaultFlow = value;
        }

        @objid ("a0447d02-9cd1-495f-a0a2-04ea32c3706b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getDefaultFromDep();
            }
            return this.symetricDep;

        }

    }

}
