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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
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

@objid ("b5f86fdd-6b97-467b-a13c-48b4ec111c67")
public class TemplateParameterSmClass extends GeneralClassSmClass {
    @objid ("b7fa2ce9-b2fe-48e7-8f6a-724f524a58f4")
    private SmAttribute defaultValueAtt;

    @objid ("b107fcb6-68b0-4442-ab65-06264bd0fddd")
    private SmAttribute isValueParameterAtt;

    @objid ("ac348726-c3d6-4323-9e8a-62cdc03228a2")
    private SmDependency parameterSubstitutionDep;

    @objid ("e15fbedd-d8c2-4ce4-bd51-c0b854786296")
    private SmDependency typeDep;

    @objid ("928a2a82-8d55-4618-acae-ca81c24b5e5f")
    private SmDependency parameterizedDep;

    @objid ("98b251ec-7e80-4699-b283-acd2b939f246")
    private SmDependency ownedParameterElementDep;

    @objid ("a21b3989-4d99-41bb-92c5-1afb975fee02")
    private SmDependency defaultTypeDep;

    @objid ("9117bc8c-1685-4603-9b0c-eafca9ca93e3")
    private SmDependency parameterizedOperationDep;

    @objid ("a3dae4c7-eb22-4f4d-a1a7-c924253d047d")
    public TemplateParameterSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3698660f-3734-4e81-bca2-9bec878864b8")
    @Override
    public String getName() {
        return "TemplateParameter";

    }

    @objid ("b89adf8c-f0bb-4c04-b385-8db4984a8a33")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("765a3321-aee0-4b06-9f4f-3afcaf5cf823")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TemplateParameter.class;

    }

    @objid ("20777f50-cb9e-4baf-b58c-8fb817422992")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ebc9c132-e6af-4bc2-a958-077c783292d7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a15f246d-a8c5-466f-a220-fc5186c75e79")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new TemplateParameterObjectFactory(this));


        // Initialize and register the SmAttribute
        this.defaultValueAtt = new DefaultValueSmAttribute();
        this.defaultValueAtt.init("DefaultValue", this, String.class );
        registerAttribute(this.defaultValueAtt);

        this.isValueParameterAtt = new IsValueParameterSmAttribute();
        this.isValueParameterAtt.init("IsValueParameter", this, Boolean.class );
        registerAttribute(this.isValueParameterAtt);


        // Initialize and register the SmDependency
        this.parameterSubstitutionDep = new ParameterSubstitutionSmDependency();
        this.parameterSubstitutionDep.init("ParameterSubstitution", this, metamodel.getMClass(TemplateParameterSubstitution.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.parameterSubstitutionDep);

        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.parameterizedDep = new ParameterizedSmDependency();
        this.parameterizedDep.init("Parameterized", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 );
        registerDependency(this.parameterizedDep);

        this.ownedParameterElementDep = new OwnedParameterElementSmDependency();
        this.ownedParameterElementDep.init("OwnedParameterElement", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedParameterElementDep);

        this.defaultTypeDep = new DefaultTypeSmDependency();
        this.defaultTypeDep.init("DefaultType", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defaultTypeDep);

        this.parameterizedOperationDep = new ParameterizedOperationSmDependency();
        this.parameterizedOperationDep.init("ParameterizedOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.parameterizedOperationDep);

    }

    @objid ("b1ea3e70-99fc-47d2-91a8-dd7368d2ed75")
    public SmAttribute getDefaultValueAtt() {
        if (this.defaultValueAtt == null) {
        	this.defaultValueAtt = this.getAttributeDef("DefaultValue");
        }
        return this.defaultValueAtt;
    }

    @objid ("89dfad0d-7001-438c-b360-3f60827d83cd")
    public SmAttribute getIsValueParameterAtt() {
        if (this.isValueParameterAtt == null) {
        	this.isValueParameterAtt = this.getAttributeDef("IsValueParameter");
        }
        return this.isValueParameterAtt;
    }

    @objid ("e61a0a7d-056f-4406-af6a-3f54c8b5e3ef")
    public SmDependency getParameterSubstitutionDep() {
        if (this.parameterSubstitutionDep == null) {
        	this.parameterSubstitutionDep = this.getDependencyDef("ParameterSubstitution");
        }
        return this.parameterSubstitutionDep;
    }

    @objid ("5e738aef-f828-4a95-a192-6ceaff485c43")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("b77363c4-17ec-43a4-b2e2-146caa78b122")
    public SmDependency getParameterizedDep() {
        if (this.parameterizedDep == null) {
        	this.parameterizedDep = this.getDependencyDef("Parameterized");
        }
        return this.parameterizedDep;
    }

    @objid ("f7144600-82fd-4e2a-8b19-3068a34523f1")
    public SmDependency getOwnedParameterElementDep() {
        if (this.ownedParameterElementDep == null) {
        	this.ownedParameterElementDep = this.getDependencyDef("OwnedParameterElement");
        }
        return this.ownedParameterElementDep;
    }

    @objid ("807f75f7-a278-4360-a9ca-578a0a6fe3b3")
    public SmDependency getDefaultTypeDep() {
        if (this.defaultTypeDep == null) {
        	this.defaultTypeDep = this.getDependencyDef("DefaultType");
        }
        return this.defaultTypeDep;
    }

    @objid ("233fc9b5-61a2-4330-84ea-8e1db2757ec7")
    public SmDependency getParameterizedOperationDep() {
        if (this.parameterizedOperationDep == null) {
        	this.parameterizedOperationDep = this.getDependencyDef("ParameterizedOperation");
        }
        return this.parameterizedOperationDep;
    }

    @objid ("9aac9ab9-4c7e-47d6-b443-016594c9ab66")
    private static class TemplateParameterObjectFactory implements ISmObjectFactory {
        @objid ("89988728-9836-46ea-9092-79f5db8675e2")
        private TemplateParameterSmClass smClass;

        @objid ("82cbf892-24df-41ba-9284-e44c4773fd6a")
        public TemplateParameterObjectFactory(TemplateParameterSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5b2b9845-6c7f-4130-8def-10eeea7e0674")
        @Override
        public ISmObjectData createData() {
            return new TemplateParameterData(this.smClass);
        }

        @objid ("bf0a2a0f-bb09-4303-ad6e-94e10e56434a")
        @Override
        public SmObjectImpl createImpl() {
            return new TemplateParameterImpl();
        }

    }

    @objid ("725d5a8b-a47e-4c22-b403-30471751d33d")
    public static class DefaultValueSmAttribute extends SmAttribute {
        @objid ("853f69cd-f612-43e2-ba17-5592d80e5c12")
        public Object getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mDefaultValue;
        }

        @objid ("37f806c0-05c6-4d58-bbef-b53cb5cd0c19")
        public void setValue(ISmObjectData data, Object value) {
            ((TemplateParameterData) data).mDefaultValue = value;
        }

    }

    @objid ("f9b98ade-1dae-402b-abf3-d3644ab09be4")
    public static class IsValueParameterSmAttribute extends SmAttribute {
        @objid ("a6069232-c771-44d3-9961-96b3230e776c")
        public Object getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mIsValueParameter;
        }

        @objid ("364f1415-a5c9-4522-bc09-f34bc798040b")
        public void setValue(ISmObjectData data, Object value) {
            ((TemplateParameterData) data).mIsValueParameter = value;
        }

    }

    @objid ("e4d60b13-f683-4af7-9640-6bd0703e5275")
    public static class ParameterSubstitutionSmDependency extends SmMultipleDependency {
        @objid ("963067ac-d312-4dff-805a-9f83760df9c6")
        private SmDependency symetricDep;

        @objid ("31040cbb-c432-404b-9782-06d8e1862e26")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((TemplateParameterData)data).mParameterSubstitution != null)? ((TemplateParameterData)data).mParameterSubstitution:SmMultipleDependency.EMPTY;
        }

        @objid ("d9c698df-9ae2-4c86-91ae-4972ad2f6004")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((TemplateParameterData) data).mParameterSubstitution = values;

        }

        @objid ("42b55b5f-4e5b-41ae-b23d-cfd5023007a1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSubstitutionSmClass)this.getTarget()).getFormalParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1bf3d748-0190-4308-9cba-60661417dc08")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("d9c252d9-6761-43d7-a9ef-af4491ad53ab")
        private SmDependency symetricDep;

        @objid ("6cba5dcd-79ae-4a67-9eb5-0c8b073246b3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mType;
        }

        @objid ("e4f12fdb-144e-4bd4-8a37-9bd401edd151")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterData) data).mType = value;
        }

        @objid ("f8007b48-66e5-4106-89c2-09cfe03dfb02")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getTypingParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2704724d-fa1d-44a4-8535-3e172edc2877")
    public static class ParameterizedSmDependency extends SmSingleDependency {
        @objid ("9fcfc31c-70a3-43fa-b4e9-7a4a525c2b99")
        private SmDependency symetricDep;

        @objid ("4042943e-d47c-4341-a5a3-bb18e9fc1bdc")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mParameterized;
        }

        @objid ("244da621-9433-4d62-a6f9-705bb410a20d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterData) data).mParameterized = value;
        }

        @objid ("d893246b-2de8-4cdc-a8b1-b1711d69779a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getTemplateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8c566423-4278-4817-9b76-82afdc102c7f")
    public static class OwnedParameterElementSmDependency extends SmSingleDependency {
        @objid ("b03fb6e4-e9e9-4922-b335-25ab92673e72")
        private SmDependency symetricDep;

        @objid ("a899889f-9dfd-4b6a-b380-e2f2cfb76945")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mOwnedParameterElement;
        }

        @objid ("5d042498-18df-4940-88a2-337967c389d0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterData) data).mOwnedParameterElement = value;
        }

        @objid ("8400c5ee-6eef-446c-b9f2-e286d0b6c126")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getOwnerTemplateParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3bc93f4e-44aa-4fc7-988e-e19aa32b153a")
    public static class DefaultTypeSmDependency extends SmSingleDependency {
        @objid ("f7ab1bfd-644f-4ea2-a6cd-eb047b893b29")
        private SmDependency symetricDep;

        @objid ("7842bbf9-1341-4e5a-8d48-1f634ae66560")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mDefaultType;
        }

        @objid ("07fa1cf0-b89d-44d1-9f0e-0c2e27ed484d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterData) data).mDefaultType = value;
        }

        @objid ("85f6ef05-ac0f-4edf-a712-ddebcccc23f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getDefaultParameteringDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8386e796-2d60-4bb0-b4e2-d10f0bb0fe68")
    public static class ParameterizedOperationSmDependency extends SmSingleDependency {
        @objid ("f77e42a6-9a0f-40cd-80aa-6158d68583d9")
        private SmDependency symetricDep;

        @objid ("709c04c4-8237-4310-925b-ab7fb1798c8d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterData) data).mParameterizedOperation;
        }

        @objid ("5f87b875-adbe-453d-ad7e-28ad6715b845")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterData) data).mParameterizedOperation = value;
        }

        @objid ("fa4ef54f-5243-4ffe-a480-b2936c4553aa")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getTemplateDep();
            }
            return this.symetricDep;

        }

    }

}
