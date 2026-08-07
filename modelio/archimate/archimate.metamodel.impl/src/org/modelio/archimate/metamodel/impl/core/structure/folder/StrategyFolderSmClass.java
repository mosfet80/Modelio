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
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
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

@objid ("993cd373-2f07-4fbd-a7cc-038400a9c87a")
public class StrategyFolderSmClass extends FolderSmClass {
    @objid ("bf80d66f-06fa-4daa-bd0b-402857c98936")
    private SmDependency ownerFolderDep;

    @objid ("4d1db0ae-baf1-4e62-9add-1bc03a9cfa95")
    private SmDependency folderDep;

    @objid ("d8ed9f91-1103-44e7-9ed0-ba698da6dcf5")
    public StrategyFolderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("177f9cf2-61fd-47a5-84af-068cbfa25bd9")
    @Override
    public String getName() {
        return "StrategyFolder";

    }

    @objid ("77bf33a6-e337-49cb-bd5d-c0cab536f286")
    @Override
    public Version getVersion() {
        return new Version("1.0.00");
    }

    @objid ("3b99fca7-2d57-46d5-9449-0b0f440901ff")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StrategyFolder.class;

    }

    @objid ("45ef7851-f942-4f31-9754-340f78dc8786")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("58f337fa-f893-406a-ab71-610027707e57")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("07435344-a2c0-453c-ab8f-d5ea28bff133")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new StrategyFolderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(StrategyFolder.MQNAME), 0, 1 );
        registerDependency(this.ownerFolderDep);

        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(StrategyFolder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

    }

    @objid ("c3ee51b2-3dda-4aee-9145-317b327f57b9")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("2b425167-30cf-4886-8b83-4569e096aa6b")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("80fab798-ec47-45cc-b5cb-70c503c7e838")
    private static class StrategyFolderObjectFactory implements ISmObjectFactory {
        @objid ("a142ac70-b8e6-4171-abde-608fd8f5dfb2")
        private StrategyFolderSmClass smClass;

        @objid ("1c4c3f71-2e84-4921-a156-88750aacbbd8")
        public StrategyFolderObjectFactory(StrategyFolderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f2f8aa91-e636-4627-bae7-08a3033e6cf1")
        @Override
        public ISmObjectData createData() {
            return new StrategyFolderData(this.smClass);
        }

        @objid ("0afdfdfc-b2b0-4dd2-a20a-7c7eb67fe7b2")
        @Override
        public SmObjectImpl createImpl() {
            return new StrategyFolderImpl();
        }

    }

    @objid ("c4ca0a3c-bb88-466f-9686-281ffaf1c250")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("2fe11b40-d0c7-42e2-96ef-6ad905891d9e")
        private SmDependency symetricDep;

        @objid ("b1b52c36-c982-46d0-a95f-487bd8e4ae1c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StrategyFolderData)data).mFolder != null)? ((StrategyFolderData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("1d5e9acc-3019-4523-b8ab-ddfd05d843cb")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StrategyFolderData) data).mFolder = values;

        }

        @objid ("8d4e1e53-28e1-4cea-a48c-e3d4b2bcd879")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StrategyFolderSmClass)this.getTarget()).getOwnerFolderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7cc2b5f2-ed2d-4a36-8c23-89c3a6fcd44b")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("14591459-b54e-465f-8bc0-91241b7e226f")
        private SmDependency symetricDep;

        @objid ("9a249755-e949-4207-bde0-31fd15e9478e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((StrategyFolderData) data).mOwnerFolder;
        }

        @objid ("410743be-d873-48d3-a8fc-c025c3edacf7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((StrategyFolderData) data).mOwnerFolder = value;
        }

        @objid ("07a533b2-f06a-44c7-ad35-b59db3417651")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StrategyFolderSmClass)this.getTarget()).getFolderDep();
            }
            return this.symetricDep;

        }

    }

}
