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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.StructuralFeature;
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

@objid ("2f1be0bc-d6ac-4f7e-87ff-4cf52bbe2a87")
public class AttributeSmClass extends StructuralFeatureSmClass {
    @objid ("c3d88795-4460-418e-ae4a-68eab1d7c2f1")
    private SmAttribute typeConstraintAtt;

    @objid ("978f29d6-fc69-4e92-b192-c06b336c45cb")
    private SmAttribute valueAtt;

    @objid ("f0f28c7f-27bd-43db-839f-a28791d9bc8b")
    private SmAttribute targetIsClassAtt;

    @objid ("0bc09402-ee33-42f3-a1ec-e82ebf676aa4")
    private SmDependency typeDep;

    @objid ("3a6c4dc6-7ef5-4722-b418-794533fca102")
    private SmDependency ownerDep;

    @objid ("e62631a9-9bf0-4b8c-b5c9-1fa631d146f0")
    private SmDependency occurenceDep;

    @objid ("71a55996-6657-4ba5-a28f-b1a95ddbf810")
    private SmDependency representingObjectNodeDep;

    @objid ("96f2f6f4-fcd9-4608-a2e4-cdecffe2b166")
    private SmDependency qualifiedDep;

    @objid ("a0730a29-0ee4-48e0-90f0-462067c8a13f")
    public AttributeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c12fa277-ce1c-482a-a14c-4bbff4c04dd8")
    @Override
    public String getName() {
        return "Attribute";

    }

    @objid ("920f140b-4347-4c26-9376-74e4c0ba8c2b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("afe09770-57fc-432c-bf8e-32e609f60fd6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Attribute.class;

    }

    @objid ("b98ca008-d12e-43d1-9a7f-141a10068cd1")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("bf306545-f76f-4e20-8098-8f9257de22e4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8707fff5-bb8d-4291-9cb5-26d10ef85f66")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralFeature.MQNAME);
        this.registerFactory(new AttributeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.typeConstraintAtt = new TypeConstraintSmAttribute();
        this.typeConstraintAtt.init("TypeConstraint", this, String.class );
        registerAttribute(this.typeConstraintAtt);

        this.valueAtt = new ValueSmAttribute();
        this.valueAtt.init("Value", this, String.class );
        registerAttribute(this.valueAtt);

        this.targetIsClassAtt = new TargetIsClassSmAttribute();
        this.targetIsClassAtt.init("TargetIsClass", this, Boolean.class );
        registerAttribute(this.targetIsClassAtt);


        // Initialize and register the SmDependency
        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(GeneralClass.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(AttributeLink.MQNAME), 0, -1 );
        registerDependency(this.occurenceDep);

        this.representingObjectNodeDep = new RepresentingObjectNodeSmDependency();
        this.representingObjectNodeDep.init("RepresentingObjectNode", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 );
        registerDependency(this.representingObjectNodeDep);

        this.qualifiedDep = new QualifiedSmDependency();
        this.qualifiedDep.init("Qualified", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, 1 );
        registerDependency(this.qualifiedDep);

    }

    @objid ("1bcdfb2c-0bab-4fcf-8b2d-9399233f9921")
    public SmAttribute getTypeConstraintAtt() {
        if (this.typeConstraintAtt == null) {
        	this.typeConstraintAtt = this.getAttributeDef("TypeConstraint");
        }
        return this.typeConstraintAtt;
    }

    @objid ("aa24eec2-6de2-480e-b894-d6ac04fad837")
    public SmAttribute getValueAtt() {
        if (this.valueAtt == null) {
        	this.valueAtt = this.getAttributeDef("Value");
        }
        return this.valueAtt;
    }

    @objid ("4f56397b-2a41-4b60-9e98-b2e9a7b5bb64")
    public SmAttribute getTargetIsClassAtt() {
        if (this.targetIsClassAtt == null) {
        	this.targetIsClassAtt = this.getAttributeDef("TargetIsClass");
        }
        return this.targetIsClassAtt;
    }

    @objid ("33e9b585-98c8-4bf8-aa17-3dcd513cda73")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("36d1afbc-2e61-4716-b7aa-75dfde739c86")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("c3de1bdd-f5ab-49b6-af63-b26eb32710c8")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("d01d83b6-56fa-4854-b107-a4e047e32f7c")
    public SmDependency getRepresentingObjectNodeDep() {
        if (this.representingObjectNodeDep == null) {
        	this.representingObjectNodeDep = this.getDependencyDef("RepresentingObjectNode");
        }
        return this.representingObjectNodeDep;
    }

    @objid ("03c080d6-842e-47a5-9f00-7db28ab57db0")
    public SmDependency getQualifiedDep() {
        if (this.qualifiedDep == null) {
        	this.qualifiedDep = this.getDependencyDef("Qualified");
        }
        return this.qualifiedDep;
    }

    @objid ("9a80f0bc-70c7-47b4-b14c-5f3afbff35fa")
    private static class AttributeObjectFactory implements ISmObjectFactory {
        @objid ("912f0357-4449-4700-89cb-d1f12c1a5a00")
        private AttributeSmClass smClass;

        @objid ("d144108c-c947-4b4a-8816-c0d468d01dae")
        public AttributeObjectFactory(AttributeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("98dc42b9-2ff2-49f7-9466-e99432139f1d")
        @Override
        public ISmObjectData createData() {
            return new AttributeData(this.smClass);
        }

        @objid ("f031410c-68ff-4235-878d-3ee5de82b60a")
        @Override
        public SmObjectImpl createImpl() {
            return new AttributeImpl();
        }

    }

    @objid ("41ca74dd-0997-41d6-8fd8-ce3170dd3dd3")
    public static class TypeConstraintSmAttribute extends SmAttribute {
        @objid ("5a00aa75-8213-476d-8eaa-44dda2d23e42")
        public Object getValue(ISmObjectData data) {
            return ((AttributeData) data).mTypeConstraint;
        }

        @objid ("6392b609-6a3c-4539-89b9-153b833f805b")
        public void setValue(ISmObjectData data, Object value) {
            ((AttributeData) data).mTypeConstraint = value;
        }

    }

    @objid ("48c2acb0-3a7d-4c24-a6bb-015f84be077a")
    public static class ValueSmAttribute extends SmAttribute {
        @objid ("df294864-d8c4-4c26-b05d-82f8379dd3bb")
        public Object getValue(ISmObjectData data) {
            return ((AttributeData) data).mValue;
        }

        @objid ("506e2005-829d-47e7-b27a-70dcaa1b8f9c")
        public void setValue(ISmObjectData data, Object value) {
            ((AttributeData) data).mValue = value;
        }

    }

    @objid ("d3f5be59-3d87-4541-912b-b9fddf024dfb")
    public static class TargetIsClassSmAttribute extends SmAttribute {
        @objid ("e1f3d507-4181-4ff2-941f-f8482ed4d877")
        public Object getValue(ISmObjectData data) {
            return ((AttributeData) data).mTargetIsClass;
        }

        @objid ("efc83dec-35a7-43e4-95cd-3aa573cdc80d")
        public void setValue(ISmObjectData data, Object value) {
            ((AttributeData) data).mTargetIsClass = value;
        }

    }

    @objid ("8897271b-c0f3-4ad2-92f9-a21d04cebcb0")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("4daa5923-67b4-441b-a35a-70913dc473d6")
        private SmDependency symetricDep;

        @objid ("ff00a7d8-0020-4820-87b3-014d1e325e77")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AttributeData) data).mType;
        }

        @objid ("4a116784-9383-41e1-b6af-0486e2f9473d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AttributeData) data).mType = value;
        }

        @objid ("c183c325-8428-43ff-82ab-5a919de33ae8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralClassSmClass)this.getTarget()).getObjectDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e7c37e2c-4cb8-4613-b6ab-1e31af183544")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("c5d9b29a-eaa8-421d-b7d8-b8a409531c54")
        private SmDependency symetricDep;

        @objid ("efc1c835-f473-4b4f-8042-ffc262d0d9ed")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AttributeData) data).mOwner;
        }

        @objid ("5619610f-07ef-4731-b96f-614a7021a9ce")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AttributeData) data).mOwner = value;
        }

        @objid ("d17e1d47-14ae-4bce-af9d-d1178c7325ad")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getOwnedAttributeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9ec16a8b-66b6-4af3-b1c3-95bd19cd7f13")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("8aad2d0c-ec1b-4aa7-996b-82d1263b2ae7")
        private SmDependency symetricDep;

        @objid ("86dca2b1-5e0b-4af1-9c59-abc66df26dcb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AttributeData)data).mOccurence != null)? ((AttributeData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("f97a9cb9-f736-43f8-b4d7-47c10c84fe2c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AttributeData) data).mOccurence = values;

        }

        @objid ("4c95b763-c0be-4fda-a311-9f32c46f29fc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeLinkSmClass)this.getTarget()).getBaseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9a711e99-228a-4ccb-8ad5-d2d6edba48b7")
    public static class RepresentingObjectNodeSmDependency extends SmMultipleDependency {
        @objid ("56a7722a-a32a-4605-a3e3-750a071a30f2")
        private SmDependency symetricDep;

        @objid ("1053e5c1-72b4-42be-96b7-003e512229b2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AttributeData)data).mRepresentingObjectNode != null)? ((AttributeData)data).mRepresentingObjectNode:SmMultipleDependency.EMPTY;
        }

        @objid ("1a59bd63-9bdd-476c-b9a2-e1946546d2e5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AttributeData) data).mRepresentingObjectNode = values;

        }

        @objid ("73661116-0a4c-4954-9075-0bd7ee421271")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getRepresentedAttributeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("68f08dd2-65f1-4bc0-8c89-d49a1177025b")
    public static class QualifiedSmDependency extends SmSingleDependency {
        @objid ("ad1aafe1-d8ef-42c6-8bb9-63edb8f215fa")
        private SmDependency symetricDep;

        @objid ("cd54dbff-b0cf-470e-b70f-53313c330a2b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AttributeData) data).mQualified;
        }

        @objid ("7741dcd1-460d-41d9-a212-948bd988c145")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AttributeData) data).mQualified = value;
        }

        @objid ("848368ed-000c-42a3-9d5a-6e4ed02cc406")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getQualifierDep();
            }
            return this.symetricDep;

        }

    }

}
