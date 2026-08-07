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
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataState;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
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

@objid ("9d09d883-ae4e-4654-8809-ad2a3437581b")
public class BpmnItemAwareElementSmClass extends BpmnFlowElementSmClass {
    @objid ("68ae94c2-c07b-4f34-8935-f5ee859e9d2d")
    private SmDependency targetOfDataAssociationDep;

    @objid ("eb5bb338-8d0d-4b20-bb34-a7b3535e8037")
    private SmDependency itemSubjectRefDep;

    @objid ("fdfcfd99-cb56-46ef-b323-f663e1def800")
    private SmDependency dataStateDep;

    @objid ("2a51c236-c77d-453a-8349-b82c833e79ee")
    private SmDependency sourceOfDataAssociationDep;

    @objid ("7c019cf3-3bc6-4482-93b5-ddcd3174f2ec")
    public BpmnItemAwareElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ebb0c665-e24f-4136-a873-0a6748f5689b")
    @Override
    public String getName() {
        return "BpmnItemAwareElement";

    }

    @objid ("45fb2de9-e64f-43a9-ae03-4737fe74dbb4")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3aea22ef-625a-448d-b63f-2ec954925440")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnItemAwareElement.class;

    }

    @objid ("b66cfebc-8347-468d-9bbd-77183e9aa76c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7f059e4c-a5b4-46e9-ad2e-c47f33ebf857")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("18f532f4-5265-494c-9f5c-2f624b193b41")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowElement.MQNAME);
        this.registerFactory(new BpmnItemAwareElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.targetOfDataAssociationDep = new TargetOfDataAssociationSmDependency();
        this.targetOfDataAssociationDep.init("TargetOfDataAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 );
        registerDependency(this.targetOfDataAssociationDep);

        this.itemSubjectRefDep = new ItemSubjectRefSmDependency();
        this.itemSubjectRefDep.init("ItemSubjectRef", this, metamodel.getMClass(BpmnItemDefinition.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.itemSubjectRefDep);

        this.dataStateDep = new DataStateSmDependency();
        this.dataStateDep.init("DataState", this, metamodel.getMClass(BpmnDataState.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataStateDep);

        this.sourceOfDataAssociationDep = new SourceOfDataAssociationSmDependency();
        this.sourceOfDataAssociationDep.init("SourceOfDataAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 );
        registerDependency(this.sourceOfDataAssociationDep);

    }

    @objid ("d32ded84-2538-48f7-b04f-bf250f059740")
    public SmDependency getTargetOfDataAssociationDep() {
        if (this.targetOfDataAssociationDep == null) {
        	this.targetOfDataAssociationDep = this.getDependencyDef("TargetOfDataAssociation");
        }
        return this.targetOfDataAssociationDep;
    }

    @objid ("8850f149-bb4b-4bcf-be73-b3c8119a6ed7")
    public SmDependency getItemSubjectRefDep() {
        if (this.itemSubjectRefDep == null) {
        	this.itemSubjectRefDep = this.getDependencyDef("ItemSubjectRef");
        }
        return this.itemSubjectRefDep;
    }

    @objid ("1ead7ce9-c9db-4777-b276-6fe8bbd32c2e")
    public SmDependency getDataStateDep() {
        if (this.dataStateDep == null) {
        	this.dataStateDep = this.getDependencyDef("DataState");
        }
        return this.dataStateDep;
    }

    @objid ("65a033aa-0799-41af-a51f-d8c962c3e4b8")
    public SmDependency getSourceOfDataAssociationDep() {
        if (this.sourceOfDataAssociationDep == null) {
        	this.sourceOfDataAssociationDep = this.getDependencyDef("SourceOfDataAssociation");
        }
        return this.sourceOfDataAssociationDep;
    }

    @objid ("9c40cf60-4c7a-40a6-b2a9-b2c42198fd15")
    private static class BpmnItemAwareElementObjectFactory implements ISmObjectFactory {
        @objid ("81792d40-8aca-4533-ae0d-ff4ceee27cb5")
        private BpmnItemAwareElementSmClass smClass;

        @objid ("8af67450-722b-4edd-b7fa-be04af44f238")
        public BpmnItemAwareElementObjectFactory(BpmnItemAwareElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("483c3260-f4b1-4852-8b19-f1f42f6ebbf7")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("cd0b5241-6a5b-4e11-b092-0c39f1166790")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("9832015c-71f6-4200-9fcf-fe1e4aaca4c8")
    public static class TargetOfDataAssociationSmDependency extends SmMultipleDependency {
        @objid ("a793acd0-f8c9-437e-835d-5e645db1486f")
        private SmDependency symetricDep;

        @objid ("6da1a7bd-db3d-4885-b0f2-f66fa10ae66e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnItemAwareElementData)data).mTargetOfDataAssociation != null)? ((BpmnItemAwareElementData)data).mTargetOfDataAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("45e9a6b9-54aa-42fb-a1c9-fb080655ec2d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnItemAwareElementData) data).mTargetOfDataAssociation = values;

        }

        @objid ("703e9b0f-9a9b-423f-be27-92410e2a25ee")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getTargetRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("36c9a21f-0a0a-42be-ac55-af8389ec3745")
    public static class ItemSubjectRefSmDependency extends SmSingleDependency {
        @objid ("5d88dcbb-35c1-42a1-bb38-151daa6af46b")
        private SmDependency symetricDep;

        @objid ("ab9d2161-a7b0-4a70-86d2-09eea9cb5066")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnItemAwareElementData) data).mItemSubjectRef;
        }

        @objid ("55ab620f-e79b-4662-8a75-24be7d263e89")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnItemAwareElementData) data).mItemSubjectRef = value;
        }

        @objid ("a7b688cb-1e10-4e7c-9701-0f71dcd928bd")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemDefinitionSmClass)this.getTarget()).getTypedItemDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("72fda9e9-167a-4d0c-a052-6828812f01d6")
    public static class DataStateSmDependency extends SmSingleDependency {
        @objid ("c0e21020-ab87-4728-855b-c53548f31783")
        private SmDependency symetricDep;

        @objid ("d9fe4e72-d3fb-468b-8bad-5522be36e37a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnItemAwareElementData) data).mDataState;
        }

        @objid ("d772c444-e810-49f3-bef5-92f35fdb66cb")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnItemAwareElementData) data).mDataState = value;
        }

        @objid ("4b90f5f3-3a66-4597-ba9d-b07bf18a708f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataStateSmClass)this.getTarget()).getItemDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8adfb522-b3c4-428e-94d2-34bf0f7aa494")
    public static class SourceOfDataAssociationSmDependency extends SmMultipleDependency {
        @objid ("54e3d588-d64c-4319-9970-82cfa07fb0db")
        private SmDependency symetricDep;

        @objid ("83f3bdbc-6770-4fb1-b98a-655fa51191f6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnItemAwareElementData)data).mSourceOfDataAssociation != null)? ((BpmnItemAwareElementData)data).mSourceOfDataAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("7cb722f0-7aad-46ba-9c78-b1b77437c581")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnItemAwareElementData) data).mSourceOfDataAssociation = values;

        }

        @objid ("9400b7f7-0548-4c95-bd32-97eb7631331e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getSourceRefDep();
            }
            return this.symetricDep;

        }

    }

}
