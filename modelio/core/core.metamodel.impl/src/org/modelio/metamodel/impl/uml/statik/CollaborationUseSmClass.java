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
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
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

@objid ("4b183c29-53e2-461f-8c9e-7d497ca87002")
public class CollaborationUseSmClass extends UmlModelElementSmClass {
    @objid ("113cd551-4833-423d-baa6-d795c64c6bb9")
    private SmDependency typeDep;

    @objid ("29faaf84-f6de-4a0d-b175-c0dc0a9cd2fe")
    private SmDependency nRepresentedDep;

    @objid ("b0199b0c-405d-4598-a029-65e09e4a77d6")
    private SmDependency oRepresentedDep;

    @objid ("3798d6e4-361e-40d3-859e-bd9a280c20a5")
    private SmDependency roleBindingDep;

    @objid ("91d000ea-02d4-40cd-a42f-f46848e9b29d")
    public CollaborationUseSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cd8cb957-3bdb-49e5-ae37-69271a318632")
    @Override
    public String getName() {
        return "CollaborationUse";

    }

    @objid ("91c8ff50-95a4-4f88-92fb-ef77ca8d6d19")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c6cc1827-df27-4129-9db7-d1ee46880801")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CollaborationUse.class;

    }

    @objid ("efee44fb-3417-476c-8f49-eee3827383a2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("30e30823-6a94-4049-8a9d-b6c6b0dd1b7d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("70c27477-ff47-4032-94ac-1851a383e16b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new CollaborationUseObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(Collaboration.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.nRepresentedDep = new NRepresentedSmDependency();
        this.nRepresentedDep.init("NRepresented", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 );
        registerDependency(this.nRepresentedDep);

        this.oRepresentedDep = new ORepresentedSmDependency();
        this.oRepresentedDep.init("ORepresented", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.oRepresentedDep);

        this.roleBindingDep = new RoleBindingSmDependency();
        this.roleBindingDep.init("RoleBinding", this, metamodel.getMClass(Binding.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.roleBindingDep);

    }

    @objid ("f39f2373-169f-4b4c-8940-4c88b0040478")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("2704204d-9796-4c80-abed-9650ae0e686a")
    public SmDependency getNRepresentedDep() {
        if (this.nRepresentedDep == null) {
        	this.nRepresentedDep = this.getDependencyDef("NRepresented");
        }
        return this.nRepresentedDep;
    }

    @objid ("11c08f70-19d5-4dde-8350-b64a8ddf2a36")
    public SmDependency getORepresentedDep() {
        if (this.oRepresentedDep == null) {
        	this.oRepresentedDep = this.getDependencyDef("ORepresented");
        }
        return this.oRepresentedDep;
    }

    @objid ("4639882c-cb7b-49b2-b971-ca2a86343f35")
    public SmDependency getRoleBindingDep() {
        if (this.roleBindingDep == null) {
        	this.roleBindingDep = this.getDependencyDef("RoleBinding");
        }
        return this.roleBindingDep;
    }

    @objid ("9e00541f-6f03-465e-9e62-9605dc546c1d")
    private static class CollaborationUseObjectFactory implements ISmObjectFactory {
        @objid ("82a7975f-c38a-411e-8ede-36ca99fb0951")
        private CollaborationUseSmClass smClass;

        @objid ("820ec9e5-79c7-4f70-bfce-64c5cbddf593")
        public CollaborationUseObjectFactory(CollaborationUseSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6f79ff0e-a015-4802-9502-9c6de9a67b36")
        @Override
        public ISmObjectData createData() {
            return new CollaborationUseData(this.smClass);
        }

        @objid ("f34cef6e-045a-4868-b730-2e0e17c3f57b")
        @Override
        public SmObjectImpl createImpl() {
            return new CollaborationUseImpl();
        }

    }

    @objid ("c07ef95f-fdb5-4a55-9ffb-4c2edf9d2bd0")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("4f87be51-c88a-42a3-b73b-381184e4378f")
        private SmDependency symetricDep;

        @objid ("76583fab-cd93-42fb-b2b8-0cc16c22381c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CollaborationUseData) data).mType;
        }

        @objid ("e4240152-035c-40dc-8422-ad91d244346d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CollaborationUseData) data).mType = value;
        }

        @objid ("08aac4ac-7029-4291-b7b5-06aed5332429")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationSmClass)this.getTarget()).getOccurrenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("95b70866-165b-4ac5-ab17-ed43a1f4213f")
    public static class NRepresentedSmDependency extends SmSingleDependency {
        @objid ("46250a36-5f22-4280-bc80-32ec91366f67")
        private SmDependency symetricDep;

        @objid ("15af78da-701b-4393-b5d5-514870e08a59")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CollaborationUseData) data).mNRepresented;
        }

        @objid ("9ee39dba-5f99-4926-8bd2-d4c8b8fe80e6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CollaborationUseData) data).mNRepresented = value;
        }

        @objid ("48c5be92-92e8-434e-a8c0-561814ea735e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedCollaborationUseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("67af4c08-244b-4a3f-8c26-7c731716c5c0")
    public static class ORepresentedSmDependency extends SmSingleDependency {
        @objid ("3253fa05-1003-48c8-a467-182a7cae55e6")
        private SmDependency symetricDep;

        @objid ("c317d949-6d8a-494e-bb5e-59258d985bf9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CollaborationUseData) data).mORepresented;
        }

        @objid ("7ed73375-fd96-437b-a059-50b2dcceb297")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CollaborationUseData) data).mORepresented = value;
        }

        @objid ("0edf90c6-8a7c-4a7f-bb58-abfab3f3d99b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOwnedCollaborationUseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cf19e713-b0d8-423e-9ece-70892f402cf5")
    public static class RoleBindingSmDependency extends SmMultipleDependency {
        @objid ("d971eaa9-7ab8-4026-8d5c-cfb6080f2272")
        private SmDependency symetricDep;

        @objid ("8de1b1da-02b3-4103-9c7c-e1cba8479e69")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CollaborationUseData)data).mRoleBinding != null)? ((CollaborationUseData)data).mRoleBinding:SmMultipleDependency.EMPTY;
        }

        @objid ("fcb5bcbd-5b9a-4913-836f-599cd988ab3d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CollaborationUseData) data).mRoleBinding = values;

        }

        @objid ("519dff30-1768-411a-afd4-e122b678f46b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindingSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
