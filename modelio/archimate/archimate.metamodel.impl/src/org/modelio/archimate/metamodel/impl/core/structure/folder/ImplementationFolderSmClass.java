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
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
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

@objid ("deff9b26-889c-4e59-9c94-139977261892")
public class ImplementationFolderSmClass extends FolderSmClass {
    @objid ("85bbf5cc-b8fb-4751-99fc-b981a82df645")
    private SmDependency folderDep;

    @objid ("82308d01-4637-403e-b94f-bd3042e277c7")
    private SmDependency ownerFolderDep;

    @objid ("099a2a60-b635-4eb1-a3e0-df0686a5a54a")
    public ImplementationFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b33111c3-5d3b-446a-87f9-f90736351fb7")
    @Override
    public String getName() {
        return "ImplementationFolder";

    }

    @objid ("a697cf69-ea87-4264-a02f-a12c0f1caa37")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("bea180a6-3b6e-42c7-be89-116080234563")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ImplementationFolder.class;

    }

    @objid ("5c0e9cdd-6ade-4ead-8020-6d8991a5bc19")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("2ec81628-a221-42f1-9aea-3adf585e0347")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bc8c1c9c-274e-4de5-ac10-7e81e5323758")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new ImplementationFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(ImplementationFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(ImplementationFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

    }

    @objid ("f831929d-5485-4e0c-8324-b3aedb9ec63d")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("13f7a90b-11de-461c-b3f8-71557af5450f")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("f4202101-4c99-4d75-94de-ed2d26b0f3a1")
    private static class ImplementationFolderObjectFactory implements ISmObjectFactory {
        @objid ("3bae178e-c82c-43d5-8632-f73af1f02acd")
        private ImplementationFolderSmClass smClass;

        @objid ("ad57b8fd-2b71-4b7d-b956-87718ea93b91")
        public ImplementationFolderObjectFactory(ImplementationFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("47a2bfe5-c2f3-4bd1-ae37-6586e10c725a")
        @Override
        public ISmObjectData createData() {
            return new ImplementationFolderData(this.smClass);
        }

        @objid ("db6826ca-3231-4444-b573-6b7ea89bcc82")
        @Override
        public SmObjectImpl createImpl() {
            return new ImplementationFolderImpl();
        }

    }

    @objid ("34a9a75e-c9d3-4936-a56e-597cc5552411")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("0c03b858-4234-4e81-822d-b2f535fbc56e")
        private SmDependency symetricDep;

        @objid ("5451858f-ad8f-4416-ae8f-726c92aaeb72")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ImplementationFolderData)data).mFolder != null)? ((ImplementationFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("ae3d8ab9-c9ef-4727-8002-c28548dde4e9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ImplementationFolderData) data).mFolder = values;

        }

        @objid ("b644e0f5-1f04-4e86-a3d8-dacca2f1b93c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ImplementationFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c1f859d6-3286-419c-a274-546bb18636ce")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("9557381b-b666-4a9b-9e9b-5c52a8d8976c")
        private SmDependency symetricDep;

        @objid ("10e91106-53e8-4cc4-b2e9-2107d472bd6a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ImplementationFolderData) data).mOwnerFolder;
        }

        @objid ("6213fd8d-e60a-4031-bfb2-a69ba8f28296")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ImplementationFolderData) data).mOwnerFolder = value;
        }

        @objid ("0dd2aa5f-a5a4-4a92-a7fd-9855f587c1f8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ImplementationFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
