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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("7b1d2689-2014-4c55-a1b7-be6b622341f9")
public class ModelTreeSmClass extends UmlModelElementSmClass {
    @objid ("ec9a25c5-6e30-4c4c-bd54-da769f359f3c")
    private SmDependency ownerDep;

    @objid ("18f32783-bd90-4ac7-a9dc-87fc67269f5b")
    private SmDependency ownedElementDep;

    @objid ("dc41fd07-b511-443a-a7e7-252a992f2c8a")
    public ModelTreeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c3d2a292-4b70-4bb8-b0e6-3fd4f8defeff")
    @Override
    public String getName() {
        return "ModelTree";

    }

    @objid ("a19f315b-0c18-4e73-a861-a27469745ddb")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("09969e98-6f46-4635-9664-bcf45bc72e0a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ModelTree.class;

    }

    @objid ("0e2d553d-a8d8-4def-ab4f-9ba1a0058097")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1466271d-ad45-41b6-8483-6670942c5fe6")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("2995c5c5-3f9b-4e5d-a3d5-df9577af1f26")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ModelTreeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(ModelTree.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.ownedElementDep = new OwnedElementSmDependency();
        this.ownedElementDep.init("OwnedElement", this, metamodel.getMClass(ModelTree.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedElementDep);

    }

    @objid ("3462c9f5-accd-4d9d-b331-ba2180527408")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("8234a7e2-b1a1-4729-9b8a-83f5c751762d")
    public SmDependency getOwnedElementDep() {
        if (this.ownedElementDep == null) {
        	this.ownedElementDep = this.getDependencyDef("OwnedElement");
        }
        return this.ownedElementDep;
    }

    @objid ("2d0110b5-18e6-4be3-be4f-ec778796f31c")
    private static class ModelTreeObjectFactory implements ISmObjectFactory {
        @objid ("b91c59c3-dc1b-4163-aea0-d323a2f20f42")
        private ModelTreeSmClass smClass;

        @objid ("8d6c2ebf-ddb2-4fb3-9d8c-54e2bbddfaf6")
        public ModelTreeObjectFactory(ModelTreeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ef062af8-9d87-4e51-8a7c-5ccfa5c48d5a")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("9c5356dc-867c-4e59-8e87-88eed17abf19")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("57d0f186-e461-438f-b354-a3aceef40f69")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("ff4065b7-87a8-4847-8a5b-7704652e7c72")
        private SmDependency symetricDep;

        @objid ("c5f39a01-e96d-4d0c-b5a4-768a5af220cc")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ModelTreeData) data).mOwner;
        }

        @objid ("17076d5e-128c-460f-91ba-42410a70f561")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ModelTreeData) data).mOwner = value;
        }

        @objid ("450794bf-87ba-4166-b353-be46bc71184c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelTreeSmClass)this.getTarget()).getOwnedElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9b274058-9491-4f7d-a2f4-62838dc7a8bc")
    public static class OwnedElementSmDependency extends SmMultipleDependency {
        @objid ("d46fefd1-0668-4280-ac90-453dc020e875")
        private SmDependency symetricDep;

        @objid ("995275ad-0969-4377-aa6d-050f72813b47")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ModelTreeData)data).mOwnedElement != null)? ((ModelTreeData)data).mOwnedElement:SmMultipleDependency.EMPTY;
        }

        @objid ("3013748d-8f69-4323-ac43-fe1a33417f56")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ModelTreeData) data).mOwnedElement = values;

        }

        @objid ("b441ff1f-b59e-4ea0-8c6d-a7381dba6a7a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelTreeSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
