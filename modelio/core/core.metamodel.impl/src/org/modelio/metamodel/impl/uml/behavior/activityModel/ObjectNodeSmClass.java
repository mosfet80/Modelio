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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorParameterSmClass;
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.StateSmClass;
import org.modelio.metamodel.impl.uml.statik.AssociationEndSmClass;
import org.modelio.metamodel.impl.uml.statik.AttributeSmClass;
import org.modelio.metamodel.impl.uml.statik.GeneralClassSmClass;
import org.modelio.metamodel.impl.uml.statik.InstanceSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNodeOrderingKind;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Instance;
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

@objid ("60b71769-0305-4555-b642-3fd3eccd55e4")
public class ObjectNodeSmClass extends ActivityNodeSmClass {
    @objid ("2074ab22-6360-4e9b-a1a0-d4b01548c5c2")
    private SmAttribute isControlTypeAtt;

    @objid ("53444b5a-8c3c-485c-9435-3d67308ee113")
    private SmAttribute orderingAtt;

    @objid ("4c5f3802-e7ca-4e14-8247-f3b2561546d1")
    private SmAttribute selectionBehaviorAtt;

    @objid ("75a0ac3a-21bf-4b5b-82d3-8dd74e8d5fb2")
    private SmAttribute upperBoundAtt;

    @objid ("aa7315e7-c282-4a87-914d-6c77ba3c6658")
    private SmDependency representedDep;

    @objid ("b8b1d67f-32a5-4cce-9440-5f4abafae946")
    private SmDependency representedRealParameterDep;

    @objid ("38e610f5-2da0-4011-8e3f-b0b3a884dfd8")
    private SmDependency typeDep;

    @objid ("1ce06b82-1df0-409e-9668-208c934a1fb9")
    private SmDependency representedRoleDep;

    @objid ("2f95df21-946d-472a-92cb-a560811c6aae")
    private SmDependency representedAttributeDep;

    @objid ("5c378124-a673-42fc-8dbb-9605a2803794")
    private SmDependency inStateDep;

    @objid ("c08eeb80-1974-4aa0-8cd8-a634d06c69d1")
    public ObjectNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("66628e4a-5382-4555-bbcb-451826fdb960")
    @Override
    public String getName() {
        return "ObjectNode";

    }

    @objid ("cb0e23a6-6e87-4e6d-83a1-22ff0566d2e6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("be227d35-5521-4c11-aec3-db38131a7e8b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ObjectNode.class;

    }

    @objid ("cf1d21a1-ec65-46eb-a972-fe9fa211582e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("cd4e2cbd-058e-4995-82ea-cd99c8a50a3b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("cd2e06f8-2feb-460b-ac6d-465c617dd07b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityNode.MQNAME);
        this.registerFactory(new ObjectNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isControlTypeAtt = new IsControlTypeSmAttribute();
        this.isControlTypeAtt.init("IsControlType", this, Boolean.class );
        registerAttribute(this.isControlTypeAtt);

        this.orderingAtt = new OrderingSmAttribute();
        this.orderingAtt.init("Ordering", this, ObjectNodeOrderingKind.class );
        registerAttribute(this.orderingAtt);

        this.selectionBehaviorAtt = new SelectionBehaviorSmAttribute();
        this.selectionBehaviorAtt.init("SelectionBehavior", this, String.class );
        registerAttribute(this.selectionBehaviorAtt);

        this.upperBoundAtt = new UpperBoundSmAttribute();
        this.upperBoundAtt.init("UpperBound", this, String.class );
        registerAttribute(this.upperBoundAtt);


        // Initialize and register the SmDependency
        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(Instance.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedDep);

        this.representedRealParameterDep = new RepresentedRealParameterSmDependency();
        this.representedRealParameterDep.init("RepresentedRealParameter", this, metamodel.getMClass(BehaviorParameter.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedRealParameterDep);

        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(GeneralClass.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.representedRoleDep = new RepresentedRoleSmDependency();
        this.representedRoleDep.init("RepresentedRole", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedRoleDep);

        this.representedAttributeDep = new RepresentedAttributeSmDependency();
        this.representedAttributeDep.init("RepresentedAttribute", this, metamodel.getMClass(Attribute.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedAttributeDep);

        this.inStateDep = new InStateSmDependency();
        this.inStateDep.init("InState", this, metamodel.getMClass(State.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.inStateDep);

    }

    @objid ("9c82e6d4-8de9-4da3-9c0f-dd4b8836895f")
    public SmAttribute getIsControlTypeAtt() {
        if (this.isControlTypeAtt == null) {
        	this.isControlTypeAtt = this.getAttributeDef("IsControlType");
        }
        return this.isControlTypeAtt;
    }

    @objid ("cb78f583-0e1c-4480-b802-f35249d36cdc")
    public SmAttribute getOrderingAtt() {
        if (this.orderingAtt == null) {
        	this.orderingAtt = this.getAttributeDef("Ordering");
        }
        return this.orderingAtt;
    }

    @objid ("deeb7bdb-4d3b-4bf0-b319-bc43986bb237")
    public SmAttribute getSelectionBehaviorAtt() {
        if (this.selectionBehaviorAtt == null) {
        	this.selectionBehaviorAtt = this.getAttributeDef("SelectionBehavior");
        }
        return this.selectionBehaviorAtt;
    }

    @objid ("231d0acb-377b-4588-8a76-a5541d68ca13")
    public SmAttribute getUpperBoundAtt() {
        if (this.upperBoundAtt == null) {
        	this.upperBoundAtt = this.getAttributeDef("UpperBound");
        }
        return this.upperBoundAtt;
    }

    @objid ("a638cd90-a01a-42c6-a06d-af4277ce5fbb")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("5d07071d-39ad-472c-b987-fc54f6878088")
    public SmDependency getRepresentedRealParameterDep() {
        if (this.representedRealParameterDep == null) {
        	this.representedRealParameterDep = this.getDependencyDef("RepresentedRealParameter");
        }
        return this.representedRealParameterDep;
    }

    @objid ("27adf386-53f8-47d1-82b6-538649953b44")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("280fbfcf-d135-484a-bd43-bde2a9aa879c")
    public SmDependency getRepresentedRoleDep() {
        if (this.representedRoleDep == null) {
        	this.representedRoleDep = this.getDependencyDef("RepresentedRole");
        }
        return this.representedRoleDep;
    }

    @objid ("c5265132-64ff-4519-aa33-baa8c00cdac6")
    public SmDependency getRepresentedAttributeDep() {
        if (this.representedAttributeDep == null) {
        	this.representedAttributeDep = this.getDependencyDef("RepresentedAttribute");
        }
        return this.representedAttributeDep;
    }

    @objid ("2cdd20a7-8387-4940-b6a6-8195c56f8def")
    public SmDependency getInStateDep() {
        if (this.inStateDep == null) {
        	this.inStateDep = this.getDependencyDef("InState");
        }
        return this.inStateDep;
    }

    @objid ("8d702db0-816c-4aaa-ab3e-6fd472d71dac")
    private static class ObjectNodeObjectFactory implements ISmObjectFactory {
        @objid ("8b4b8aaa-50cf-42a4-91ee-68b33250f02a")
        private ObjectNodeSmClass smClass;

        @objid ("42f2f583-52e4-497a-8a22-0eb089e92be2")
        public ObjectNodeObjectFactory(ObjectNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e7533053-c4e1-4114-9fea-81e96c3e485c")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("19fa6b0f-c6e5-4ff2-9269-938cce1d98f9")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("c1c2ceac-ade9-4745-a65b-be2cb3948436")
    public static class IsControlTypeSmAttribute extends SmAttribute {
        @objid ("7fa91d44-6dbb-42d8-ac86-e68e27b6f7b4")
        public Object getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mIsControlType;
        }

        @objid ("af71f2f2-f28c-4647-9e53-0852ef1d8dca")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectNodeData) data).mIsControlType = value;
        }

    }

    @objid ("ef835d23-f5ff-426f-9d5c-e655989df510")
    public static class OrderingSmAttribute extends SmAttribute {
        @objid ("8a63656f-aa4a-4167-a47a-47fe9be60b83")
        public Object getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mOrdering;
        }

        @objid ("ba2f6702-6191-432e-9d68-0104cff08f58")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectNodeData) data).mOrdering = value;
        }

    }

    @objid ("b65e9545-3654-4c03-96d0-f02afdf6d742")
    public static class SelectionBehaviorSmAttribute extends SmAttribute {
        @objid ("a2e32a38-8013-4e61-bfdc-7d341f61f165")
        public Object getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mSelectionBehavior;
        }

        @objid ("5ef20e44-313c-4341-ade9-bd4bfc37e9ee")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectNodeData) data).mSelectionBehavior = value;
        }

    }

    @objid ("c75ddb12-8275-458e-bdf2-dc60a48862cc")
    public static class UpperBoundSmAttribute extends SmAttribute {
        @objid ("a90f3575-045f-4b70-9229-529652b98adc")
        public Object getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mUpperBound;
        }

        @objid ("213a63fc-bb75-432c-8f56-80cdb487911f")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectNodeData) data).mUpperBound = value;
        }

    }

    @objid ("75a21422-376f-4e30-9f2e-fe27274eb332")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("900677ba-1767-4248-a6b1-f31f787ad9aa")
        private SmDependency symetricDep;

        @objid ("a8e234bd-50a5-4450-b991-f16a5cc82e33")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mRepresented;
        }

        @objid ("e0ef69ba-a693-4fdc-ba6b-646e57d526c6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mRepresented = value;
        }

        @objid ("109cdfa9-595a-40c9-bb4f-6899023c0517")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getRepresentingObjectNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c9739744-7fc6-4022-a005-398fda16305c")
    public static class RepresentedRealParameterSmDependency extends SmSingleDependency {
        @objid ("791564ca-ca46-4312-9f6c-800e499d238f")
        private SmDependency symetricDep;

        @objid ("abe501d0-e243-4f7d-9fa5-6c2b81e8e9d1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mRepresentedRealParameter;
        }

        @objid ("8b46b0f9-8c47-4668-8bd6-8a9298ae04aa")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mRepresentedRealParameter = value;
        }

        @objid ("0b41b597-dfc4-466e-a203-22c568dc70fc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorParameterSmClass)this.getTarget()).getRepresentingObjectNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c5a029a8-71e1-4322-afa3-549a91c26977")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("0920332e-c983-46e9-a419-2317b6856801")
        private SmDependency symetricDep;

        @objid ("76bd4630-f6e2-47d1-b099-5ad642ac582d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mType;
        }

        @objid ("6259fa86-f730-466f-a5c8-f714597ba9ed")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mType = value;
        }

        @objid ("0a59b2f1-0ad7-468f-b822-8288a2a9b622")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralClassSmClass)this.getTarget()).getOccurenceObjectNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bad2b412-4720-4f4f-a88c-69d0368edacd")
    public static class RepresentedRoleSmDependency extends SmSingleDependency {
        @objid ("92b087ca-6952-470f-9743-6ce5e0f12d45")
        private SmDependency symetricDep;

        @objid ("62e13fb4-c7f7-460a-97cb-0015ed9f78d9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mRepresentedRole;
        }

        @objid ("53c3abb6-694d-4405-9831-5751d4ae64ce")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mRepresentedRole = value;
        }

        @objid ("68c888eb-63f3-4022-8031-b30a8b497722")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getRepresentingObjectNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("22ca8cf9-82a9-4cf3-8e68-d2c67e3e6d63")
    public static class RepresentedAttributeSmDependency extends SmSingleDependency {
        @objid ("bdce3a59-49a1-4797-9050-9d0649edc87f")
        private SmDependency symetricDep;

        @objid ("63331d58-8019-4e4d-8b25-de02eb4fd0a0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mRepresentedAttribute;
        }

        @objid ("799909f0-4c6e-42ac-a861-261dff65a3cc")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mRepresentedAttribute = value;
        }

        @objid ("db5a77f5-b9dd-402e-a4ab-9fd9afc6e73b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeSmClass)this.getTarget()).getRepresentingObjectNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e92027ed-2556-43eb-b758-74fc84a22c5f")
    public static class InStateSmDependency extends SmSingleDependency {
        @objid ("54b01a8c-221c-47fb-9032-afc77c0c67ed")
        private SmDependency symetricDep;

        @objid ("0c204ecf-620c-4ed4-9be3-75f5fbdaf4f3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ObjectNodeData) data).mInState;
        }

        @objid ("e3807301-2fcd-4bb0-a724-5c230a297e5a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ObjectNodeData) data).mInState = value;
        }

        @objid ("79f67a07-0632-40f3-9cad-f6c62e9d1415")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getRequiredStateOfDep();
            }
            return this.symetricDep;

        }

    }

}
