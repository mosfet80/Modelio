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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.TemplateBinding;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4be06bc1-c4cd-476a-beed-ac5652682111")
public class TemplateParameterSubstitutionSmClass extends UmlModelElementSmClass {
    @objid ("e31506a0-babc-4ac4-992e-e213afb97499")
    private SmAttribute valueAtt;

    @objid ("81a5cd32-cc5e-431f-a9e2-6a4050f1e16f")
    private SmDependency ownerDep;

    @objid ("fec900dc-f89c-46e4-bfbe-b76571c353f4")
    private SmDependency actualDep;

    @objid ("87b55872-d92a-4090-94db-34ac268216dd")
    private SmDependency formalParameterDep;

    @objid ("65331842-c881-4930-b338-317ecea4ea35")
    public TemplateParameterSubstitutionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9c669e8f-d540-4fa0-b4af-84a12ee4bca4")
    @Override
    public String getName() {
        return "TemplateParameterSubstitution";

    }

    @objid ("90ee760d-d0a0-48e2-be90-7beabeb470b3")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("651006da-939a-4f14-b876-bf90658b2f7d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TemplateParameterSubstitution.class;

    }

    @objid ("050627c9-8847-4a55-93e1-91f125a7b585")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6a9e3b2f-b82f-4415-b1eb-9f2b56018dae")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f8745a12-1c56-4635-b769-5acf858cc0a8")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new TemplateParameterSubstitutionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.valueAtt = new ValueSmAttribute();
        this.valueAtt.init("Value", this, String.class );
        registerAttribute(this.valueAtt);


        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(TemplateBinding.MQNAME), 1, 1 );
        registerDependency(this.ownerDep);

        this.actualDep = new ActualSmDependency();
        this.actualDep.init("Actual", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.actualDep);

        this.formalParameterDep = new FormalParameterSmDependency();
        this.formalParameterDep.init("FormalParameter", this, metamodel.getMClass(TemplateParameter.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.formalParameterDep);

    }

    @objid ("afc1cbb4-c9d7-429a-a1c3-3e878a88420b")
    public SmAttribute getValueAtt() {
        if (this.valueAtt == null) {
        	this.valueAtt = this.getAttributeDef("Value");
        }
        return this.valueAtt;
    }

    @objid ("b8b4b3df-c25f-4253-a841-7675aee62c3b")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("7a618854-5610-4425-93b5-949ddf09adfd")
    public SmDependency getActualDep() {
        if (this.actualDep == null) {
        	this.actualDep = this.getDependencyDef("Actual");
        }
        return this.actualDep;
    }

    @objid ("00ff9c86-483f-46dd-87a5-212fdbd4dbac")
    public SmDependency getFormalParameterDep() {
        if (this.formalParameterDep == null) {
        	this.formalParameterDep = this.getDependencyDef("FormalParameter");
        }
        return this.formalParameterDep;
    }

    @objid ("589a4bd2-962b-4f44-843f-26743d79dd04")
    private static class TemplateParameterSubstitutionObjectFactory implements ISmObjectFactory {
        @objid ("7b92a9b2-e3ba-4606-8fdb-c0601a5beded")
        private TemplateParameterSubstitutionSmClass smClass;

        @objid ("2e25a370-af75-4239-b598-419f9c083614")
        public TemplateParameterSubstitutionObjectFactory(TemplateParameterSubstitutionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d31bf5de-cc1c-4cdd-9b06-03721e88ccee")
        @Override
        public ISmObjectData createData() {
            return new TemplateParameterSubstitutionData(this.smClass);
        }

        @objid ("50512327-3e72-49e0-b612-14ae8c25b742")
        @Override
        public SmObjectImpl createImpl() {
            return new TemplateParameterSubstitutionImpl();
        }

    }

    @objid ("a8b27f99-56d1-45d3-9310-37cc0352dbd9")
    public static class ValueSmAttribute extends SmAttribute {
        @objid ("e16e7657-3899-4ede-909d-4184143be530")
        public Object getValue(ISmObjectData data) {
            return ((TemplateParameterSubstitutionData) data).mValue;
        }

        @objid ("345ac7cd-05f4-4f09-b9a1-fa2fbbc57f7a")
        public void setValue(ISmObjectData data, Object value) {
            ((TemplateParameterSubstitutionData) data).mValue = value;
        }

    }

    @objid ("853891e5-b3d6-45df-8be1-7e6d12ffd916")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("bf294cf2-81eb-420f-af9a-4ad77215d9b3")
        private SmDependency symetricDep;

        @objid ("841b36c0-ed7c-4243-9388-70d295aacfac")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterSubstitutionData) data).mOwner;
        }

        @objid ("f92cc1b2-b312-4689-bbc8-cd46aeff738e")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterSubstitutionData) data).mOwner = value;
        }

        @objid ("ecfc3277-75e2-4489-bd77-481055a8d99c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateBindingSmClass)this.getTarget()).getParameterSubstitutionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("31665b4f-4977-48e2-9794-2279b0a17488")
    public static class ActualSmDependency extends SmSingleDependency {
        @objid ("a3e846e5-0453-4bbd-a543-2eeab8c731b8")
        private SmDependency symetricDep;

        @objid ("049642a1-81fa-418a-8cdc-7b12d24edb89")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterSubstitutionData) data).mActual;
        }

        @objid ("2ea9873a-9312-4469-9e09-b13603608dfc")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterSubstitutionData) data).mActual = value;
        }

        @objid ("43196ce4-2bba-479b-af5d-ebac4f6498d2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getTemplateSubstitutionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fbfa80a2-f7b7-4a05-9c02-f3ecbef64e19")
    public static class FormalParameterSmDependency extends SmSingleDependency {
        @objid ("0d1a56bc-4d19-4277-85e9-9f3ae16a79a1")
        private SmDependency symetricDep;

        @objid ("08d1303b-983f-476b-9fd8-60dbd3a13215")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateParameterSubstitutionData) data).mFormalParameter;
        }

        @objid ("aec7cb7a-483e-4d2f-a5fb-dbac46764ae7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateParameterSubstitutionData) data).mFormalParameter = value;
        }

        @objid ("6b697a3e-ebfe-4db4-9492-1625a58b35e9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getParameterSubstitutionDep();
            }
            return this.symetricDep;

        }

    }

}
