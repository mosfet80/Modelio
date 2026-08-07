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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnCatchEventSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnThrowEventSmClass;
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
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("60a0168a-f7a2-4200-952d-c4446d0864aa")
public class BpmnDataAssociationSmClass extends BpmnBaseElementSmClass {
    @objid ("daf2b39d-3f44-48b3-86bc-1d05383ae278")
    private SmAttribute assignmentAtt;

    @objid ("b0238f76-222d-4835-a0f6-2190f1828e0c")
    private SmAttribute transfomationAtt;

    @objid ("d956bdfc-107e-48aa-b45f-30104d93cc11")
    private SmAttribute languageAtt;

    @objid ("b560285c-56aa-4704-9d42-e8f49708a61d")
    private SmDependency sourceRefDep;

    @objid ("290421ff-fabf-443b-8549-f45019b4fd35")
    private SmDependency targetRefDep;

    @objid ("7e769fe2-e2d1-4446-b351-868832334c03")
    private SmDependency endingActivityDep;

    @objid ("1c667979-fa26-40b4-8aab-a7c38154a77b")
    private SmDependency startingActivityDep;

    @objid ("c505b981-7fdb-4e8b-82d0-3b58e6e7152e")
    private SmDependency startingEventDep;

    @objid ("257292bd-539d-498e-a8ed-f0884064e49b")
    private SmDependency visualShortCutDep;

    @objid ("d4e15da9-0179-4ceb-8d6b-14e8547965a6")
    private SmDependency endingEventDep;

    @objid ("60ce9950-067e-4442-9f17-53d788e05b7f")
    public BpmnDataAssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("89aa8047-30b9-44c8-a94b-16f49db08906")
    @Override
    public String getName() {
        return "BpmnDataAssociation";

    }

    @objid ("9592b357-c32a-44b5-81c0-db735161f94b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f3e6a549-89e4-492c-be6a-63a1694394b0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataAssociation.class;

    }

    @objid ("3053b612-0d5f-49ca-8ccf-b06a1048aa8f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b57af0ce-006c-496f-a576-c77d8ba25ce0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("065f7965-caf8-4083-ac4a-a50a9708f87d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnDataAssociationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.assignmentAtt = new AssignmentSmAttribute();
        this.assignmentAtt.init("Assignment", this, String.class );
        registerAttribute(this.assignmentAtt);

        this.transfomationAtt = new TransfomationSmAttribute();
        this.transfomationAtt.init("Transfomation", this, String.class );
        registerAttribute(this.transfomationAtt);

        this.languageAtt = new LanguageSmAttribute();
        this.languageAtt.init("Language", this, String.class );
        registerAttribute(this.languageAtt);


        // Initialize and register the SmDependency
        this.sourceRefDep = new SourceRefSmDependency();
        this.sourceRefDep.init("SourceRef", this, metamodel.getMClass(BpmnItemAwareElement.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.sourceRefDep);

        this.targetRefDep = new TargetRefSmDependency();
        this.targetRefDep.init("TargetRef", this, metamodel.getMClass(BpmnItemAwareElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.targetRefDep);

        this.endingActivityDep = new EndingActivitySmDependency();
        this.endingActivityDep.init("EndingActivity", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 );
        registerDependency(this.endingActivityDep);

        this.startingActivityDep = new StartingActivitySmDependency();
        this.startingActivityDep.init("StartingActivity", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 );
        registerDependency(this.startingActivityDep);

        this.startingEventDep = new StartingEventSmDependency();
        this.startingEventDep.init("StartingEvent", this, metamodel.getMClass(BpmnThrowEvent.MQNAME), 0, 1 );
        registerDependency(this.startingEventDep);

        this.visualShortCutDep = new VisualShortCutSmDependency();
        this.visualShortCutDep.init("VisualShortCut", this, metamodel.getMClass(BpmnSequenceFlowDataAssociation.MQNAME), 0, -1 );
        registerDependency(this.visualShortCutDep);

        this.endingEventDep = new EndingEventSmDependency();
        this.endingEventDep.init("EndingEvent", this, metamodel.getMClass(BpmnCatchEvent.MQNAME), 0, 1 );
        registerDependency(this.endingEventDep);

    }

    @objid ("be6c4f96-64aa-4b23-9a31-bfff7457b265")
    public SmAttribute getAssignmentAtt() {
        if (this.assignmentAtt == null) {
        	this.assignmentAtt = this.getAttributeDef("Assignment");
        }
        return this.assignmentAtt;
    }

    @objid ("3354631c-066b-493f-8cae-8115db9e57b0")
    public SmAttribute getTransfomationAtt() {
        if (this.transfomationAtt == null) {
        	this.transfomationAtt = this.getAttributeDef("Transfomation");
        }
        return this.transfomationAtt;
    }

    @objid ("2300be49-d297-4646-aca2-0e37f3592ae7")
    public SmAttribute getLanguageAtt() {
        if (this.languageAtt == null) {
        	this.languageAtt = this.getAttributeDef("Language");
        }
        return this.languageAtt;
    }

    @objid ("5541e134-6554-4d06-bcf1-ba166d4ca1d5")
    public SmDependency getSourceRefDep() {
        if (this.sourceRefDep == null) {
        	this.sourceRefDep = this.getDependencyDef("SourceRef");
        }
        return this.sourceRefDep;
    }

    @objid ("124fc47f-78e7-428d-8a64-9435f24c316d")
    public SmDependency getTargetRefDep() {
        if (this.targetRefDep == null) {
        	this.targetRefDep = this.getDependencyDef("TargetRef");
        }
        return this.targetRefDep;
    }

    @objid ("8fe1d8f5-62d9-4d2b-8da2-141492536b2b")
    public SmDependency getEndingActivityDep() {
        if (this.endingActivityDep == null) {
        	this.endingActivityDep = this.getDependencyDef("EndingActivity");
        }
        return this.endingActivityDep;
    }

    @objid ("a4528a3b-8b70-4949-91fa-d6c1b9f8c1c2")
    public SmDependency getStartingActivityDep() {
        if (this.startingActivityDep == null) {
        	this.startingActivityDep = this.getDependencyDef("StartingActivity");
        }
        return this.startingActivityDep;
    }

    @objid ("0a817f76-9d1c-43b1-baf7-3a130d3e1ff4")
    public SmDependency getStartingEventDep() {
        if (this.startingEventDep == null) {
        	this.startingEventDep = this.getDependencyDef("StartingEvent");
        }
        return this.startingEventDep;
    }

    @objid ("31513e3e-f0f2-4712-8995-b6368712e4e1")
    public SmDependency getVisualShortCutDep() {
        if (this.visualShortCutDep == null) {
        	this.visualShortCutDep = this.getDependencyDef("VisualShortCut");
        }
        return this.visualShortCutDep;
    }

    @objid ("da024b8b-6f9c-4873-ace3-4c319b7b7fd6")
    public SmDependency getEndingEventDep() {
        if (this.endingEventDep == null) {
        	this.endingEventDep = this.getDependencyDef("EndingEvent");
        }
        return this.endingEventDep;
    }

    @objid ("ca57127e-5b57-4ffa-9ad4-090ed8d9810b")
    private static class BpmnDataAssociationObjectFactory implements ISmObjectFactory {
        @objid ("24262c92-66c1-448b-8145-b6f84b7f9362")
        private BpmnDataAssociationSmClass smClass;

        @objid ("ba0a6234-6028-4e50-bfbe-58dd748e59dc")
        public BpmnDataAssociationObjectFactory(BpmnDataAssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7c87eb01-57d9-4713-aa1a-651328d29af4")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataAssociationData(this.smClass);
        }

        @objid ("996beb55-631a-489b-bc18-f354e368fff3")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataAssociationImpl();
        }

    }

    @objid ("42d862f7-c6a3-4e76-b02b-3f4a2d709c2d")
    public static class AssignmentSmAttribute extends SmAttribute {
        @objid ("6d79b403-c84c-444d-a125-83c9966daf6f")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mAssignment;
        }

        @objid ("210cc71b-c2cc-4932-91f5-5dafb14bf447")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataAssociationData) data).mAssignment = value;
        }

    }

    @objid ("93fcdcbe-7aac-4924-b9cc-defc1f7d5b2c")
    public static class TransfomationSmAttribute extends SmAttribute {
        @objid ("0260ccb4-390a-4837-b7a5-76f99dcd89f2")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mTransfomation;
        }

        @objid ("27558d89-a449-4a76-b754-d312d803b2d7")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataAssociationData) data).mTransfomation = value;
        }

    }

    @objid ("c7e04443-686c-4f77-8315-7a33fe4d72a4")
    public static class LanguageSmAttribute extends SmAttribute {
        @objid ("d727eacb-4bc3-4991-b082-878f32cb264a")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mLanguage;
        }

        @objid ("a83875ed-b425-4e1a-ae91-9eab2911024b")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataAssociationData) data).mLanguage = value;
        }

    }

    @objid ("56d4102d-09d0-4f63-aa3e-307280b9aab7")
    public static class SourceRefSmDependency extends SmMultipleDependency {
        @objid ("1f92b9ae-056a-4896-8833-8312836f44d7")
        private SmDependency symetricDep;

        @objid ("72a47351-c573-4c29-8954-d07908db72a5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnDataAssociationData)data).mSourceRef != null)? ((BpmnDataAssociationData)data).mSourceRef:SmMultipleDependency.EMPTY;
        }

        @objid ("91a66c5a-0047-46bd-88ae-3c18a58f9e26")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnDataAssociationData) data).mSourceRef = values;

        }

        @objid ("b3f1a25d-1940-4545-83c6-4bb6cc9cafc2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemAwareElementSmClass)this.getTarget()).getSourceOfDataAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bfad54b5-7b34-486b-be97-416d6bd7002c")
    public static class TargetRefSmDependency extends SmSingleDependency {
        @objid ("6f323c41-873b-4117-ad90-2fb0417ad3d8")
        private SmDependency symetricDep;

        @objid ("048128c2-972c-4c0d-87df-25bd0f57c9bd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mTargetRef;
        }

        @objid ("45863d46-8f4c-4141-a9c0-206971589618")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataAssociationData) data).mTargetRef = value;
        }

        @objid ("e46c8e76-bf5e-461a-ad7a-1ac2f2d8f87e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemAwareElementSmClass)this.getTarget()).getTargetOfDataAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c37b2a49-e3b6-4bd1-a244-88bd4a6e5c84")
    public static class EndingActivitySmDependency extends SmSingleDependency {
        @objid ("3c257a3d-edc4-4200-8e6c-7b7b37ab8c04")
        private SmDependency symetricDep;

        @objid ("3c98d27c-47ee-4375-a4e4-91ad42b28dd0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mEndingActivity;
        }

        @objid ("631659fb-673f-4827-8fa9-2d879d83e5f1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataAssociationData) data).mEndingActivity = value;
        }

        @objid ("feef1806-096a-46a8-9e28-0b806b14f25d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getDataOutputAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4e9835e2-8528-4474-a5f3-750320ab2f52")
    public static class StartingActivitySmDependency extends SmSingleDependency {
        @objid ("5a6b5121-d164-4167-b2d3-f335202f9ffe")
        private SmDependency symetricDep;

        @objid ("19ff1c7f-1f7b-404b-99fa-b23cc3816847")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mStartingActivity;
        }

        @objid ("af27ced6-b1e1-4d9f-9890-e2663a0be26b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataAssociationData) data).mStartingActivity = value;
        }

        @objid ("38bf92c3-2256-4326-9c41-432b85d7a4bb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getDataInputAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("73c7a97e-0ae7-4fe2-9d5a-668c6598fd9a")
    public static class StartingEventSmDependency extends SmSingleDependency {
        @objid ("7b5722f2-8027-470e-a7af-3dc024cf1b69")
        private SmDependency symetricDep;

        @objid ("0faba3cf-d742-43e4-907c-f4721af470e5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mStartingEvent;
        }

        @objid ("44a70fb9-fe1e-4b9b-9476-9e626b44d62f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataAssociationData) data).mStartingEvent = value;
        }

        @objid ("06844af7-fca6-4a87-8959-6d1e46253db0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnThrowEventSmClass)this.getTarget()).getDataInputAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("866f7c6e-8201-45f8-b2ca-67baa92df961")
    public static class VisualShortCutSmDependency extends SmMultipleDependency {
        @objid ("b87413c0-3766-4e40-9dbc-77a42e0d21c7")
        private SmDependency symetricDep;

        @objid ("c50ff666-37ba-435d-a113-c0e7a22cdf8e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnDataAssociationData)data).mVisualShortCut != null)? ((BpmnDataAssociationData)data).mVisualShortCut:SmMultipleDependency.EMPTY;
        }

        @objid ("25f42708-53e0-4721-9ef2-57e9187b7274")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnDataAssociationData) data).mVisualShortCut = values;

        }

        @objid ("bd099572-d8b7-456b-83a1-e0c7c0d6c042")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowDataAssociationSmClass)this.getTarget()).getDataAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c3722a64-6e68-4872-849e-4c301f56acd7")
    public static class EndingEventSmDependency extends SmSingleDependency {
        @objid ("aa1cacca-08ea-47b8-8bc0-a7a5b585eafa")
        private SmDependency symetricDep;

        @objid ("96c29f5a-356c-4051-b346-3ed44854243d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataAssociationData) data).mEndingEvent;
        }

        @objid ("10070def-1737-470a-8bfd-5401a4980e6d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataAssociationData) data).mEndingEvent = value;
        }

        @objid ("b3dc8d7b-3d4c-4cdc-8d8b-b25e7d524040")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCatchEventSmClass)this.getTarget()).getDataOutputAssociationDep();
            }
            return this.symetricDep;

        }

    }

}
