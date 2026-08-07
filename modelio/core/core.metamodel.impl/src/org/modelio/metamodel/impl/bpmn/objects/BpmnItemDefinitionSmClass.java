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
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnItemKind;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageSmClass;
import org.modelio.metamodel.impl.bpmn.resources.BpmnResourceParameterSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementSmClass;
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
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1c7d8bdd-dbfc-4c81-9979-040335d7b02b")
public class BpmnItemDefinitionSmClass extends BpmnSharedElementSmClass {
    @objid ("64ceb585-cbde-4df9-ba90-2a2a7681b452")
    private SmAttribute itemKindAtt;

    @objid ("93a904d5-7b45-4e7c-bd05-37cd4b38ae1f")
    private SmAttribute isCollectionAtt;

    @objid ("39e1badf-abd9-4ba1-9f47-8c0be4292956")
    private SmDependency typedMessageDep;

    @objid ("8c30838c-7d00-4311-98d8-e7cf471e2e8e")
    private SmDependency typedItemDep;

    @objid ("2e06ed4b-2c8f-4dc6-b40c-74741eaab2a3")
    private SmDependency typedResourceParameterDep;

    @objid ("f01da356-ce89-4cff-8fea-3ea131316032")
    public BpmnItemDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9e68ec52-ef78-4003-a2db-7f5d8977ee65")
    @Override
    public String getName() {
        return "BpmnItemDefinition";

    }

    @objid ("d436bad0-3c94-44fa-969a-519fbf12b207")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("37bdb58f-d582-4296-9f4f-07fc4fab22dd")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnItemDefinition.class;

    }

    @objid ("04b4f089-fd96-4514-a189-c0979365b719")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("aa2bb8d2-a1e5-4527-a8fb-ae944c59a0b0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("dbe8f59c-109e-4d0c-81f3-64b51aff7633")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSharedElement.MQNAME);
        this.registerFactory(new BpmnItemDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.itemKindAtt = new ItemKindSmAttribute();
        this.itemKindAtt.init("ItemKind", this, BpmnItemKind.class );
        registerAttribute(this.itemKindAtt);

        this.isCollectionAtt = new IsCollectionSmAttribute();
        this.isCollectionAtt.init("IsCollection", this, Boolean.class );
        registerAttribute(this.isCollectionAtt);


        // Initialize and register the SmDependency
        this.typedMessageDep = new TypedMessageSmDependency();
        this.typedMessageDep.init("TypedMessage", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, -1 );
        registerDependency(this.typedMessageDep);

        this.typedItemDep = new TypedItemSmDependency();
        this.typedItemDep.init("TypedItem", this, metamodel.getMClass(BpmnItemAwareElement.MQNAME), 0, -1 );
        registerDependency(this.typedItemDep);

        this.typedResourceParameterDep = new TypedResourceParameterSmDependency();
        this.typedResourceParameterDep.init("TypedResourceParameter", this, metamodel.getMClass(BpmnResourceParameter.MQNAME), 0, -1 );
        registerDependency(this.typedResourceParameterDep);

    }

    @objid ("ee8c1761-fab2-4d4c-a8ba-7f84143c8342")
    public SmAttribute getItemKindAtt() {
        if (this.itemKindAtt == null) {
        	this.itemKindAtt = this.getAttributeDef("ItemKind");
        }
        return this.itemKindAtt;
    }

    @objid ("b2684f42-864e-415b-9c70-64ba3d9d9211")
    public SmAttribute getIsCollectionAtt() {
        if (this.isCollectionAtt == null) {
        	this.isCollectionAtt = this.getAttributeDef("IsCollection");
        }
        return this.isCollectionAtt;
    }

    @objid ("e701752e-c579-4493-97a2-d910372271df")
    public SmDependency getTypedMessageDep() {
        if (this.typedMessageDep == null) {
        	this.typedMessageDep = this.getDependencyDef("TypedMessage");
        }
        return this.typedMessageDep;
    }

    @objid ("90a5193d-4f34-449d-a60d-cea5f1e71afe")
    public SmDependency getTypedItemDep() {
        if (this.typedItemDep == null) {
        	this.typedItemDep = this.getDependencyDef("TypedItem");
        }
        return this.typedItemDep;
    }

    @objid ("5a807cbc-f9bb-4e48-ba08-4e989261194d")
    public SmDependency getTypedResourceParameterDep() {
        if (this.typedResourceParameterDep == null) {
        	this.typedResourceParameterDep = this.getDependencyDef("TypedResourceParameter");
        }
        return this.typedResourceParameterDep;
    }

    @objid ("5724a5ce-5bf3-402b-9b00-6a602cc8dabf")
    private static class BpmnItemDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("2dc35ca7-e32c-49f8-8cf2-54abe5b63110")
        private BpmnItemDefinitionSmClass smClass;

        @objid ("387d6584-bdc0-4174-b4de-667de72b49e7")
        public BpmnItemDefinitionObjectFactory(BpmnItemDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("360fe4ff-735d-4989-ae54-3fc8ef2f5f2b")
        @Override
        public ISmObjectData createData() {
            return new BpmnItemDefinitionData(this.smClass);
        }

        @objid ("59b80e86-0998-493f-aee8-679906edd23b")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnItemDefinitionImpl();
        }

    }

    @objid ("5b915c26-3315-4c4f-9d8a-bbbe7f7622a7")
    public static class ItemKindSmAttribute extends SmAttribute {
        @objid ("0af33cb6-67b9-4da2-988d-45adeea6692f")
        public Object getValue(ISmObjectData data) {
            return ((BpmnItemDefinitionData) data).mItemKind;
        }

        @objid ("d9b7d562-0570-46e6-b934-7ec36b1117f3")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnItemDefinitionData) data).mItemKind = value;
        }

    }

    @objid ("267f4aa4-5a61-40df-b221-d854bbb80290")
    public static class IsCollectionSmAttribute extends SmAttribute {
        @objid ("a340ea53-66a5-4b85-b9a6-5edc9e54c2fd")
        public Object getValue(ISmObjectData data) {
            return ((BpmnItemDefinitionData) data).mIsCollection;
        }

        @objid ("7a953fb8-a164-4f20-817e-a6c152e7bac3")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnItemDefinitionData) data).mIsCollection = value;
        }

    }

    @objid ("e6c59e20-11ac-40cf-b760-5460e1ad7630")
    public static class TypedMessageSmDependency extends SmMultipleDependency {
        @objid ("939d09e8-7c5c-439c-b4b9-ecb8d489179b")
        private SmDependency symetricDep;

        @objid ("e6330682-7acf-4332-aac8-9d3ffe242bdd")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnItemDefinitionData)data).mTypedMessage != null)? ((BpmnItemDefinitionData)data).mTypedMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("8c6b3c2d-4ef8-4c60-84a5-4163061804e6")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnItemDefinitionData) data).mTypedMessage = values;

        }

        @objid ("a40c250d-b01b-4077-be83-ef3ef912b15c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getItemRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("800923df-367a-4d34-a759-80f4fbacbdac")
    public static class TypedItemSmDependency extends SmMultipleDependency {
        @objid ("ea489e1d-9ade-466f-8dae-66935cb89489")
        private SmDependency symetricDep;

        @objid ("c718c693-3e0e-43eb-8506-55f1145374e9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnItemDefinitionData)data).mTypedItem != null)? ((BpmnItemDefinitionData)data).mTypedItem:SmMultipleDependency.EMPTY;
        }

        @objid ("6f4b0c40-df3c-46dd-a024-31a85dcd7fc1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnItemDefinitionData) data).mTypedItem = values;

        }

        @objid ("3384d330-cc4d-4887-9246-d221b2f49090")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemAwareElementSmClass)this.getTarget()).getItemSubjectRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ba46c5eb-000e-42ed-bf21-538906a721b6")
    public static class TypedResourceParameterSmDependency extends SmMultipleDependency {
        @objid ("370a3492-4f7d-40ac-8bb6-10949154c726")
        private SmDependency symetricDep;

        @objid ("4dd81d14-e38f-44dc-a71b-c8f440187c77")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnItemDefinitionData)data).mTypedResourceParameter != null)? ((BpmnItemDefinitionData)data).mTypedResourceParameter:SmMultipleDependency.EMPTY;
        }

        @objid ("86907d6a-d331-4a1d-bb80-c568459ee4fd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnItemDefinitionData) data).mTypedResourceParameter = values;

        }

        @objid ("1aaf6f50-4fe1-43e7-b7d0-a9fd70ddcc82")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceParameterSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

}
