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
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
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

@objid ("db7aad52-55c1-4c00-874d-7199a09876d5")
public class MotivationFolderSmClass extends FolderSmClass {
    @objid ("da4ec5fc-2560-4d50-ab6b-9cde7751f73c")
    private SmDependency ownerFolderDep;

    @objid ("85080686-af59-4c3b-85f6-7d1c9995804a")
    private SmDependency folderDep;

    @objid ("38b016cf-1bd8-4165-b719-57e619a20a54")
    public MotivationFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("86163ed2-979e-4fff-a32f-a55e6e650467")
    @Override
    public String getName() {
        return "MotivationFolder";

    }

    @objid ("dced7ec0-d1d0-45c7-86e2-beea66284baa")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("36f3279c-da85-4b7e-92e0-8ce35611381c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return MotivationFolder.class;

    }

    @objid ("191c209d-7977-4244-abc6-2d5a9cf537cc")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("7f29fc8e-a34b-4d9e-8f66-7e1cdae29450")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("467bc416-e7f4-4a98-bf8b-d9d0ffb612e8")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new MotivationFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(MotivationFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(MotivationFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

    }

    @objid ("e07fe4f9-8f3a-42ec-8292-199dd0c6649d")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("e96a905b-e70d-4ed2-95d6-c6dd0b8bd10a")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("cc01c150-5e9c-4783-952d-4826badf46ae")
    private static class MotivationFolderObjectFactory implements ISmObjectFactory {
        @objid ("bb43ffe6-e12a-40cf-acee-f2943a81b29d")
        private MotivationFolderSmClass smClass;

        @objid ("8b168141-d88e-42ad-ae47-5a5406ce0cc6")
        public MotivationFolderObjectFactory(MotivationFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6921087d-c84b-4330-9157-fa56983fd133")
        @Override
        public ISmObjectData createData() {
            return new MotivationFolderData(this.smClass);
        }

        @objid ("bec70851-dc52-4c6c-be92-27f3153ddf28")
        @Override
        public SmObjectImpl createImpl() {
            return new MotivationFolderImpl();
        }

    }

    @objid ("4f7dc2ee-fa6c-45f0-b0f8-2932f8b9c068")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("f40608d0-4136-4599-9281-3249168fa8b6")
        private SmDependency symetricDep;

        @objid ("23d69052-6e88-4cc1-8165-fa77e3682bd4")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((MotivationFolderData)data).mFolder != null)? ((MotivationFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("cee6c228-32bc-48e3-bfb6-0448aba94677")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((MotivationFolderData) data).mFolder = values;

        }

        @objid ("b29f38d4-f950-4924-8003-0d2f7c5848f1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MotivationFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fdec2bbe-71f0-4140-907f-d0ba9984f286")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("2ccce943-24c9-4f2a-9532-4e3f7df7cde5")
        private SmDependency symetricDep;

        @objid ("e2afa412-9081-4e1a-8e3a-c452fb2c9f43")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MotivationFolderData) data).mOwnerFolder;
        }

        @objid ("f3834659-4a18-4eba-a9fe-dcf8313a6bbe")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MotivationFolderData) data).mOwnerFolder = value;
        }

        @objid ("843b0d16-b157-4d02-9e0c-4936b916c1cb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MotivationFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
