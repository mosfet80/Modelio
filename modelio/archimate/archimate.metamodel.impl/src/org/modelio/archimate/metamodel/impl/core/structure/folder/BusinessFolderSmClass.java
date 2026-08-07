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
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
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

@objid ("6ffeeb04-0cfd-44ae-b947-bb1ca4256c77")
public class BusinessFolderSmClass extends FolderSmClass {
    @objid ("c2f205e6-9346-42f8-b1d4-a6fef189b7b4")
    private SmDependency ownerFolderDep;

    @objid ("3075fb74-f4ca-4154-94eb-c1c849077ee5")
    private SmDependency folderDep;

    @objid ("26203c2f-165c-45f5-a2b1-ed462b5434c6")
    public BusinessFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8b7b4554-bdd0-4095-9332-1fe44632c54e")
    @Override
    public String getName() {
        return "BusinessFolder";

    }

    @objid ("23a0d169-bbf5-47c6-8025-0e6bcf18cc2f")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("66fa53f9-604e-42cc-91a7-310265e8c00b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessFolder.class;

    }

    @objid ("cbcce77e-71e4-4c79-a470-c53063b61cbe")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("327b7712-2992-4e1c-81a6-06660495fb8a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d1eccc14-e0c2-4007-91c9-08764070bff9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new BusinessFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(BusinessFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(BusinessFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

    }

    @objid ("eae8cf66-bbf9-41be-95ac-b9f9d7e4ae63")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("40ba0c19-e4db-4955-8de5-dcc65be8bc53")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("faf9f078-f48f-4168-a30d-deba414bac6f")
    private static class BusinessFolderObjectFactory implements ISmObjectFactory {
        @objid ("cb0665be-4783-4f01-942f-4164f56a1fd7")
        private BusinessFolderSmClass smClass;

        @objid ("979ffadb-8c65-42ae-9038-67e6b92737d5")
        public BusinessFolderObjectFactory(BusinessFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0d9b4e46-5e8b-49e5-9fff-d8da0866a143")
        @Override
        public ISmObjectData createData() {
            return new BusinessFolderData(this.smClass);
        }

        @objid ("7490d9f6-2419-4120-a368-2a1fcd31c453")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessFolderImpl();
        }

    }

    @objid ("44e35376-6ebf-473f-91d6-d62f2844d032")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("6883f2bc-9c7d-4b63-a2ff-0da484427287")
        private SmDependency symetricDep;

        @objid ("c5d33358-bb89-4333-b869-6b6f1676e077")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BusinessFolderData)data).mFolder != null)? ((BusinessFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("6624bf01-18f6-4b02-ba45-b2a2742c0971")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BusinessFolderData) data).mFolder = values;

        }

        @objid ("a6f2b497-a5bf-40a5-8b2c-6a6267b958a3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BusinessFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("79aa430c-c941-4096-ac4b-ec9e4ba0819e")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("8a56dfa8-e9c5-4d16-9539-fe8ae7767bcb")
        private SmDependency symetricDep;

        @objid ("3fd509ad-ac8e-41c4-a636-7dc7379392a9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BusinessFolderData) data).mOwnerFolder;
        }

        @objid ("320eaeba-c7ad-429c-a759-d552671aa971")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BusinessFolderData) data).mOwnerFolder = value;
        }

        @objid ("0dcb5716-95fe-4390-a9f9-20c05480a957")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BusinessFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
