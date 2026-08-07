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
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
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

@objid ("71f18b68-be51-4c91-92d9-4fa73ef3ee84")
public class TechnologyFolderSmClass extends FolderSmClass {
    @objid ("7e427fc1-80a2-4431-8811-dcf30ebe0041")
    private SmDependency ownerFolderDep;

    @objid ("4139e5ae-10fb-4555-a7a3-a14c79f81825")
    private SmDependency folderDep;

    @objid ("6c4762b4-9912-4760-848b-f18ca22fcaf4")
    public TechnologyFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("767f079c-8ab8-4678-bfc5-0d1c1808c4c7")
    @Override
    public String getName() {
        return "TechnologyFolder";

    }

    @objid ("d470d581-c2bf-4d50-932d-51145da2ad05")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("e268c8fe-8781-4ec2-95cd-e60c445a0d34")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyFolder.class;

    }

    @objid ("372da31e-b6ec-4a86-af4c-d69d88208675")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("fe2df12f-2e34-43f5-8f8b-8e6c87249576")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("80c3e03e-601b-4c28-8c2b-b052f0595bfb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new TechnologyFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(TechnologyFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(TechnologyFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

    }

    @objid ("6994b686-3332-4717-b0b8-7e43ef62701b")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("cac1bb50-3af4-40b5-ae89-d963f359da0d")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("1b90c957-fe87-42fb-9917-f5011580181f")
    private static class TechnologyFolderObjectFactory implements ISmObjectFactory {
        @objid ("ccea18a2-27b7-4718-9165-01ce8b86d9a7")
        private TechnologyFolderSmClass smClass;

        @objid ("002e358e-f31c-4361-9a87-b71f8833dcd2")
        public TechnologyFolderObjectFactory(TechnologyFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c21bfd03-e0f0-41af-b019-7bb7cbc538b3")
        @Override
        public ISmObjectData createData() {
            return new TechnologyFolderData(this.smClass);
        }

        @objid ("cd953edf-ed8e-48b3-b669-6f5388e97965")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyFolderImpl();
        }

    }

    @objid ("36be213a-3de7-4726-96de-b3b7fcf676ce")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("b2c847b0-bf8b-443e-838f-50967d124010")
        private SmDependency symetricDep;

        @objid ("a54b97a0-2136-4b21-9a0d-b74d4122ac00")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((TechnologyFolderData)data).mFolder != null)? ((TechnologyFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("725beaf7-ab6a-47ff-85ab-94b4bd0b4015")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((TechnologyFolderData) data).mFolder = values;

        }

        @objid ("b8ff6cd7-e74d-4969-8f87-3e9dfbfcb5c2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TechnologyFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fd65197e-040b-4bbf-a6ca-f570322532fe")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("f09e0057-2a9b-4f96-b5cc-3e22f1c1325a")
        private SmDependency symetricDep;

        @objid ("5f8ec4b5-4713-43f9-a6de-128cc947646a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TechnologyFolderData) data).mOwnerFolder;
        }

        @objid ("d327a41e-5f6b-45b3-8508-72850f619b6d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TechnologyFolderData) data).mOwnerFolder = value;
        }

        @objid ("c2d32a0a-c925-4613-aff0-609b9c9f4fdb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TechnologyFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
