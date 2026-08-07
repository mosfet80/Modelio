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
package org.modelio.archimate.metamodel.impl.core.structure.folder;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderSmClass;
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

@objid ("56dd685a-c5ad-489a-8214-25703a95ae14")
public class PhysicalFolderSmClass extends FolderSmClass {
    @objid ("15b87e43-69e1-485c-82e8-1818eb2aa2e7")
    private SmDependency folderDep;

    @objid ("469c7345-4eb9-4746-a79a-98165214c5a3")
    private SmDependency ownerFolderDep;

    @objid ("9ea209a5-a830-4424-9fa7-9fcfc0f6a6b2")
    public PhysicalFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ec4f8940-bbdd-4ff8-ac66-b8ee6d7bf590")
    @Override
    public String getName() {
        return "PhysicalFolder";

    }

    @objid ("af34a369-2807-4ece-858f-6c6e26254205")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("38b938ff-4887-4af7-9338-7ab72c8d3371")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return PhysicalFolder.class;

    }

    @objid ("a02f079b-2199-40ef-9f84-cc25c0be39c7")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("4971de3c-48f3-4aa0-afab-59d98f5fbf56")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("dc92505b-76ec-4ffe-9332-484a36c7fa00")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new PhysicalFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(PhysicalFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(PhysicalFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

    }

    @objid ("047220c9-8121-4d26-bdaa-fc24d0ac654b")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("14d2356f-2b53-446b-8e36-ab759c64852b")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("acbca310-ba17-46f8-aa91-686b5c5118c3")
    private static class PhysicalFolderObjectFactory implements ISmObjectFactory {
        @objid ("2dd0d512-ce11-4f46-bdd9-ade3ba2b1b13")
        private PhysicalFolderSmClass smClass;

        @objid ("969e8e69-087b-4304-bf1b-f973655fc243")
        public PhysicalFolderObjectFactory(PhysicalFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d2f7e041-07a5-4d71-884c-030f7248ad1c")
        @Override
        public ISmObjectData createData() {
            return new PhysicalFolderData(this.smClass);
        }

        @objid ("2ccd1d39-a65d-4e1b-ba03-488df218783c")
        @Override
        public SmObjectImpl createImpl() {
            return new PhysicalFolderImpl();
        }

    }

    @objid ("f315703d-04d2-4a1e-93bb-848c8fd18634")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("6ba98a5e-65b2-41a3-afd8-584e8c6d7145")
        private SmDependency symetricDep;

        @objid ("cc25e31f-26ee-4a9f-8f23-cda4de278c61")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PhysicalFolderData)data).mFolder != null)? ((PhysicalFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("589900f1-5d60-4954-84a7-4aa85827c989")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PhysicalFolderData) data).mFolder = values;

        }

        @objid ("95f1112b-556b-4574-98fd-6f6b0772b9a0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PhysicalFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("67d51270-fcbf-47cf-84b8-8426eefe356e")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("55b085d3-121e-483e-bd40-c43b9967817b")
        private SmDependency symetricDep;

        @objid ("e3190674-b029-4466-9c70-674e5a35c899")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PhysicalFolderData) data).mOwnerFolder;
        }

        @objid ("53387d14-feed-4317-8762-45ffe9030d0b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PhysicalFolderData) data).mOwnerFolder = value;
        }

        @objid ("8901f554-bd58-428d-9f11-0a1a130e8b3f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PhysicalFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
