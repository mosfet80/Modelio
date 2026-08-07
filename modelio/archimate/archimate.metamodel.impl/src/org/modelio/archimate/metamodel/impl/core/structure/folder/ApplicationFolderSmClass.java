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
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
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

@objid ("74ecb67a-6949-4387-b9e7-6da7304ea683")
public class ApplicationFolderSmClass extends FolderSmClass {
    @objid ("7e267066-260b-40a4-8dd7-7e8e9c156b95")
    private SmDependency folderDep;

    @objid ("3e3c9497-9161-4fe8-9c3d-3852299433d2")
    private SmDependency ownerFolderDep;

    @objid ("379632c7-527d-4b45-bb25-55d60e8aced8")
    public ApplicationFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("67e1f3e4-5a56-43d5-9655-f7f7a97eb4bc")
    @Override
    public String getName() {
        return "ApplicationFolder";

    }

    @objid ("7e8db26a-65f4-4978-9bf1-36d915d01245")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("3728d50b-a2f5-49f2-a576-899004c60fe2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationFolder.class;

    }

    @objid ("c42c5b01-ecfd-4e50-bc18-6c2ecb48dff8")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("dfa86712-f68a-40d8-9d46-0e7f4432ce8e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("df94e34f-e93a-4e5e-a239-830cdead99ef")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new ApplicationFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(ApplicationFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(ApplicationFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

    }

    @objid ("9d24f744-c9e7-43a8-981b-a14781167f2c")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("8fb69393-f323-40f0-9ecd-fa7f7cf474dd")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("44f7a495-79de-4730-b997-4dbb3aaee2a2")
    private static class ApplicationFolderObjectFactory implements ISmObjectFactory {
        @objid ("f9e4d88f-2904-4bdb-a284-053906d5e1e0")
        private ApplicationFolderSmClass smClass;

        @objid ("2202fa4f-48fb-4a10-8832-1a4c547cc5a1")
        public ApplicationFolderObjectFactory(ApplicationFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c3a4ad35-86ef-467f-93a7-67dd82754a19")
        @Override
        public ISmObjectData createData() {
            return new ApplicationFolderData(this.smClass);
        }

        @objid ("f59dd844-e354-4e62-9a55-d6929eb6f5a9")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationFolderImpl();
        }

    }

    @objid ("fffc766d-92a5-4ad3-a936-ece53f27c47b")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("c6af3465-1bde-4ba6-8a74-0853eb1758bd")
        private SmDependency symetricDep;

        @objid ("4a0ac8a4-e6d1-48f0-a239-40e8df4b285c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ApplicationFolderData)data).mFolder != null)? ((ApplicationFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("b6ec49b7-25a4-43f2-adc5-4de710679582")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ApplicationFolderData) data).mFolder = values;

        }

        @objid ("bbaafe32-850a-489f-badf-25700a3ad7ad")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ApplicationFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3722a68a-75ef-4ee4-8f36-ee2e0e993dd5")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("9cf11575-1860-4941-8afe-6167642a1025")
        private SmDependency symetricDep;

        @objid ("2d8259c1-cb10-4bda-a3db-ddb71bde0d31")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ApplicationFolderData) data).mOwnerFolder;
        }

        @objid ("bd2feadd-6742-4f2b-868a-ea3a91fa27ad")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ApplicationFolderData) data).mOwnerFolder = value;
        }

        @objid ("240dce09-9edc-4590-86a5-2816dc3498d4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ApplicationFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
