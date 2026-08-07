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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementSmClass;
import org.modelio.archimate.metamodel.impl.core.ConceptSmClass;
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

@objid ("e34bfb1d-6cc9-4d52-a84b-0acedb94789b")
public class FolderSmClass extends ArchimateAbstractElementSmClass {
    @objid ("d93591fd-055c-40c5-9c01-4101738c8472")
    private SmDependency contentDep;

    @objid ("c3b3a13b-6ad3-4d7d-ac68-08c9ca4491d7")
    private SmDependency ownerDep;

    @objid ("18b69397-b1c9-42f6-a635-2f32b7dd6bd8")
    public FolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bcc2fea8-a3e4-487f-807b-6e7cb6b29bdb")
    @Override
    public String getName() {
        return "Folder";

    }

    @objid ("69734dc2-bddb-4a4c-930c-ece67b1b27e5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("e9387f02-bb0e-4958-9f8a-7f50e3846526")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Folder.class;

    }

    @objid ("1759ccc9-c2da-43ef-abc6-afcc93fde80f")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("93c8ea04-4f37-47e6-856f-ceab15407712")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("d52ca6b9-43ea-46b8-b654-cf5ad4633e3e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ArchimateAbstractElement.MQNAME);
        this.registerFactory(new FolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.contentDep = new ContentSmDependency();
        this.contentDep.init("content", this, metamodel.getMClass(Concept.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.contentDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("owner", this, metamodel.getMClass(Model.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("546399b2-e099-454c-9895-efee1c0eb3ba")
    public SmDependency getContentDep() {
        if (this.contentDep == null) {
        	this.contentDep = this.getDependencyDef("content");
        }
        return this.contentDep;
    }

    @objid ("e411d019-d184-47c5-8160-7f7f5387723e")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("owner");
        }
        return this.ownerDep;
    }

    @objid ("1c3c5ad6-391c-4bcc-95ea-020cb95fa699")
    private static class FolderObjectFactory implements ISmObjectFactory {
        @objid ("2cc8fa3a-e223-455c-82fe-d830e33ea754")
        private FolderSmClass smClass;

        @objid ("724194d8-f16f-43d8-96b5-5490f06798f0")
        public FolderObjectFactory(FolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c0d2e458-325e-4566-98c3-41e31055422b")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("ea70fe9c-3441-4765-ae18-70ac508ff38e")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("55c1c99b-a22f-464e-a9d1-205428c41064")
    public static class ContentSmDependency extends SmMultipleDependency {
        @objid ("68a3430d-a125-4a20-a6ff-3a9071a4f66a")
        private SmDependency symetricDep;

        @objid ("5017df68-9b14-43e8-9f61-79a3a5eb1cbf")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((FolderData)data).mContent != null)? ((FolderData)data).mContent:SmMultipleDependency.EMPTY;
        }

        @objid ("2b49ff5e-94f9-4a4c-99f0-d2e6c480a6d1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((FolderData) data).mContent = values;

        }

        @objid ("feef32ba-8647-4375-962f-ea023ab65ce8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConceptSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("aeb7df0d-2c41-432e-9669-1d1f370fb74f")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("5ebe8ea1-340c-4fac-9055-db908f923859")
        private SmDependency symetricDep;

        @objid ("ed50df1a-64b5-43e0-aecd-2d1567a60c23")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((FolderData) data).mOwner;
        }

        @objid ("e9259b5e-7b53-4302-a59c-d1ca11b68cbe")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((FolderData) data).mOwner = value;
        }

        @objid ("cb3e82cc-63ed-4221-8375-5faf3e38d43b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
