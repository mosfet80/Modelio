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
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
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

@objid ("3f0d167f-f8f6-4084-b5f9-ccbcaa07e981")
public class TemplateBindingSmClass extends UmlModelElementSmClass {
    @objid ("267d05d3-2ac2-4b7c-b13c-4c6467fb83c0")
    private SmDependency parameterSubstitutionDep;

    @objid ("f46e45eb-d920-462d-ad83-218b7f33601f")
    private SmDependency boundOperationDep;

    @objid ("ecca5bcf-8834-4eb7-abf0-5f2f1634890b")
    private SmDependency instanciatedTemplateOperationDep;

    @objid ("a43cf6fc-3f5f-4bbf-9fe6-c3f881ab10b4")
    private SmDependency instanciatedTemplateDep;

    @objid ("23040257-88a7-4ee4-9407-50b4ebe729aa")
    private SmDependency boundElementDep;

    @objid ("785bb2d9-4f4a-4add-bfeb-c35765d50fe7")
    public TemplateBindingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d2101317-8998-4335-8951-7580a3b08abc")
    @Override
    public String getName() {
        return "TemplateBinding";

    }

    @objid ("3519dc27-5158-44bd-9d57-fbec52a4195d")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("afbca7e2-2157-419f-8109-d55c23549095")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TemplateBinding.class;

    }

    @objid ("67e7d665-e2e8-4dea-a52f-5eb3529a0c4f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e6e687ce-b486-4188-b278-15fd90c9cbb4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("18bb2ed2-d536-4f78-b62d-390308e08647")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new TemplateBindingObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.parameterSubstitutionDep = new ParameterSubstitutionSmDependency();
        this.parameterSubstitutionDep.init("ParameterSubstitution", this, metamodel.getMClass(TemplateParameterSubstitution.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.parameterSubstitutionDep);

        this.boundOperationDep = new BoundOperationSmDependency();
        this.boundOperationDep.init("BoundOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.boundOperationDep);

        this.instanciatedTemplateOperationDep = new InstanciatedTemplateOperationSmDependency();
        this.instanciatedTemplateOperationDep.init("InstanciatedTemplateOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.instanciatedTemplateOperationDep);

        this.instanciatedTemplateDep = new InstanciatedTemplateSmDependency();
        this.instanciatedTemplateDep.init("InstanciatedTemplate", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.instanciatedTemplateDep);

        this.boundElementDep = new BoundElementSmDependency();
        this.boundElementDep.init("BoundElement", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.boundElementDep);

    }

    @objid ("f7aac4cf-752c-42c8-bbf1-919be4c58680")
    public SmDependency getParameterSubstitutionDep() {
        if (this.parameterSubstitutionDep == null) {
        	this.parameterSubstitutionDep = this.getDependencyDef("ParameterSubstitution");
        }
        return this.parameterSubstitutionDep;
    }

    @objid ("e8985f8f-9973-4ef8-8b08-3ae5dde42f66")
    public SmDependency getBoundOperationDep() {
        if (this.boundOperationDep == null) {
        	this.boundOperationDep = this.getDependencyDef("BoundOperation");
        }
        return this.boundOperationDep;
    }

    @objid ("91541444-f8dd-42e2-9ea8-e67573fa55ef")
    public SmDependency getInstanciatedTemplateOperationDep() {
        if (this.instanciatedTemplateOperationDep == null) {
        	this.instanciatedTemplateOperationDep = this.getDependencyDef("InstanciatedTemplateOperation");
        }
        return this.instanciatedTemplateOperationDep;
    }

    @objid ("8921e2e7-1dba-4028-9780-ea2b11e54b64")
    public SmDependency getInstanciatedTemplateDep() {
        if (this.instanciatedTemplateDep == null) {
        	this.instanciatedTemplateDep = this.getDependencyDef("InstanciatedTemplate");
        }
        return this.instanciatedTemplateDep;
    }

    @objid ("2bf2fc5f-48d1-436b-8e55-a004566b99cd")
    public SmDependency getBoundElementDep() {
        if (this.boundElementDep == null) {
        	this.boundElementDep = this.getDependencyDef("BoundElement");
        }
        return this.boundElementDep;
    }

    @objid ("89df4860-b2b0-4f4f-b55d-d03b33971a55")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("b8cd215f-0433-4ad5-862d-93d9b8b8a1ed")
    private static class TemplateBindingObjectFactory implements ISmObjectFactory {
        @objid ("4f60797b-17b6-47ac-8773-466dfdc70649")
        private TemplateBindingSmClass smClass;

        @objid ("ed533c46-e607-49e8-a038-f3415ca69ad5")
        public TemplateBindingObjectFactory(TemplateBindingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("50d2a3a2-2ba5-4157-be6f-4d074acb3b8a")
        @Override
        public ISmObjectData createData() {
            return new TemplateBindingData(this.smClass);
        }

        @objid ("631056fa-e05a-4d96-97d9-c720e1950248")
        @Override
        public SmObjectImpl createImpl() {
            return new TemplateBindingImpl();
        }

    }

    @objid ("3af81550-c36a-46ea-9c25-6107e01ba5bf")
    public static class ParameterSubstitutionSmDependency extends SmMultipleDependency {
        @objid ("6192f9e8-b7ea-4cff-8b9b-01313386014c")
        private SmDependency symetricDep;

        @objid ("3d6b913a-6b88-4b49-91ae-02834c5a6275")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((TemplateBindingData)data).mParameterSubstitution != null)? ((TemplateBindingData)data).mParameterSubstitution:SmMultipleDependency.EMPTY;
        }

        @objid ("890c0d47-845b-4fb9-ad80-f495366b872a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((TemplateBindingData) data).mParameterSubstitution = values;

        }

        @objid ("1ffff572-4bfc-43a8-bbb2-cfc134026965")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSubstitutionSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5370731f-9e57-467c-bc29-1212756e865e")
    public static class BoundOperationSmDependency extends SmSingleDependency {
        @objid ("70698cf7-fe54-4b37-a0e1-d52eb4671c84")
        private SmDependency symetricDep;

        @objid ("081fca19-0167-4dad-816c-ac60b2bf6221")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateBindingData) data).mBoundOperation;
        }

        @objid ("09e18eb7-0bae-4195-87ea-1b2d99147d09")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateBindingData) data).mBoundOperation = value;
        }

        @objid ("578d32eb-8fb6-494c-b1a5-a3c146c11dd9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getTemplateInstanciationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2579c941-6b53-482c-a7f4-dafe893730da")
    public static class InstanciatedTemplateOperationSmDependency extends SmSingleDependency {
        @objid ("55f078c9-d918-403a-9fb6-bd2678aad088")
        private SmDependency symetricDep;

        @objid ("c9b76620-542b-4bea-8648-ae2dc8c3ce02")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateBindingData) data).mInstanciatedTemplateOperation;
        }

        @objid ("5316651c-8a16-4c8c-9e6b-f71e1400bfa2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateBindingData) data).mInstanciatedTemplateOperation = value;
        }

        @objid ("acbca5d0-1583-4b5f-9123-5958b0e6f19a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getInstanciatingBindingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d9ed676d-eb32-423c-962f-3c85da0cb88c")
    public static class InstanciatedTemplateSmDependency extends SmSingleDependency {
        @objid ("453ac4c0-634d-49cc-8e16-41d6a65ca0fa")
        private SmDependency symetricDep;

        @objid ("ec08b04f-2e3c-4d05-a35a-c1af1db85d1c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateBindingData) data).mInstanciatedTemplate;
        }

        @objid ("9f02f3e2-58e2-44ad-8cd5-4d231117fa3b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateBindingData) data).mInstanciatedTemplate = value;
        }

        @objid ("8476f350-c198-4c1a-bea7-e150a4c4af85")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getInstanciatingBindingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("27564942-710e-4d5d-b792-d8121468fa00")
    public static class BoundElementSmDependency extends SmSingleDependency {
        @objid ("a40c81ef-476c-4b49-a019-e1ff71cfce32")
        private SmDependency symetricDep;

        @objid ("705d7b8d-0d2a-4c81-92d5-f16f4909a3ce")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TemplateBindingData) data).mBoundElement;
        }

        @objid ("314648d1-4bd6-482c-856f-50426457eb49")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TemplateBindingData) data).mBoundElement = value;
        }

        @objid ("eec36ecd-0923-4f0d-b364-201a6322bcf6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getTemplateInstanciationDep();
            }
            return this.symetricDep;

        }

    }

}
