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
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.impl.core.ArchimateViewSmClass;
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

@objid ("42a0d1b8-428f-46fa-86ee-01d43cadd209")
public class ModelSmClass extends FolderSmClass {
    @objid ("6b600852-1c70-484c-90a2-314bced24d10")
    private SmDependency projectDep;

    @objid ("e05d7abf-af51-4ff7-9f1d-e702b1383d06")
    private SmDependency referencedByDep;

    @objid ("12810819-0e38-4589-a6ba-4b94d5b1ee55")
    private SmDependency referencedByViewDep;

    @objid ("611bfa42-9e49-4fca-aa5c-4770b2baea5d")
    private SmDependency folderDep;

    @objid ("03a8303a-0b11-453f-943b-9dc95be1953b")
    public ModelSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("57a1730d-0b35-4d7d-95b2-1328e6e49f60")
    @Override
    public String getName() {
        return "Model";

    }

    @objid ("f35f2dd1-00bd-47e9-8228-3636ca2a3fe7")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c31cded8-b089-47b5-b440-68792705211c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Model.class;

    }

    @objid ("6120f088-f866-4859-92c3-6cfdec03e3de")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9acb9ab7-c338-4595-8970-ba84a2593cb8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("59580ca8-113d-4b23-97b2-9ea178787934")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Folder.MQNAME);
        this.registerFactory(new ModelObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.projectDep = new ProjectSmDependency();
        this.projectDep.init("project", this, metamodel.getMClass(ArchimateProject.MQNAME), 1, 1 );
        registerDependency(this.projectDep);

        this.referencedByDep = new ReferencedBySmDependency();
        this.referencedByDep.init("referencedBy", this, metamodel.getMClass(ViewPoint.MQNAME), 0, -1 );
        registerDependency(this.referencedByDep);

        this.referencedByViewDep = new ReferencedByViewSmDependency();
        this.referencedByViewDep.init("referencedByView", this, metamodel.getMClass(ArchimateView.MQNAME), 0, -1 );
        registerDependency(this.referencedByViewDep);

        this.folderDep = new FolderSmDependency();
        this.folderDep.init("folder", this, metamodel.getMClass(Folder.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.folderDep);

    }

    @objid ("5f3ca6f9-fdce-45d9-a29a-5da2cfa56a6e")
    public SmDependency getProjectDep() {
        if (this.projectDep == null) {
        	this.projectDep = this.getDependencyDef("project");
        }
        return this.projectDep;
    }

    @objid ("89d6ed19-08d8-43ae-9553-47a2311cd423")
    public SmDependency getReferencedByDep() {
        if (this.referencedByDep == null) {
        	this.referencedByDep = this.getDependencyDef("referencedBy");
        }
        return this.referencedByDep;
    }

    @objid ("fdbc352b-ab8d-4978-a854-3902160826e3")
    public SmDependency getReferencedByViewDep() {
        if (this.referencedByViewDep == null) {
        	this.referencedByViewDep = this.getDependencyDef("referencedByView");
        }
        return this.referencedByViewDep;
    }

    @objid ("58fb7d76-2990-41d5-a56a-d146d6fb405d")
    public SmDependency getFolderDep() {
        if (this.folderDep == null) {
        	this.folderDep = this.getDependencyDef("folder");
        }
        return this.folderDep;
    }

    @objid ("eb42eec6-ae6a-4f2e-94f6-096b731e22ba")
    private static class ModelObjectFactory implements ISmObjectFactory {
        @objid ("63e7a681-0560-4fcf-84a8-06bb88568fbf")
        private ModelSmClass smClass;

        @objid ("6481feb2-9529-485e-93df-89efbc84e362")
        public ModelObjectFactory(ModelSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5283cce4-3efb-4c0f-93e7-b842f492c483")
        @Override
        public ISmObjectData createData() {
            return new ModelData(this.smClass);
        }

        @objid ("aa20232f-a69d-46f9-9887-4c07672a7c39")
        @Override
        public SmObjectImpl createImpl() {
            return new ModelImpl();
        }

    }

    @objid ("eaaf2fb5-9a8a-4ebf-bb24-9d45335f4af9")
    public static class ProjectSmDependency extends SmSingleDependency {
        @objid ("9095184b-1aba-42f2-a0a9-98c8f35cc142")
        private SmDependency symetricDep;

        @objid ("a6878d69-540d-45f6-8cba-73144ce238c3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ModelData) data).mProject;
        }

        @objid ("f29cce62-ad1f-4380-89de-2cf3870eee5f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ModelData) data).mProject = value;
        }

        @objid ("8ff70d0f-8fd8-4a9f-8389-dedb10f12849")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ArchimateProjectSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("466f4730-3590-46fe-bb22-a67a70f415cb")
    public static class ReferencedBySmDependency extends SmMultipleDependency {
        @objid ("ef00e765-88e8-4544-af3a-992224c15a3c")
        private SmDependency symetricDep;

        @objid ("609f2f7f-9cc0-4956-ac50-d0048ff6ac61")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ModelData)data).mReferencedBy != null)? ((ModelData)data).mReferencedBy:SmMultipleDependency.EMPTY;
        }

        @objid ("a237cb56-563d-496a-906b-c7fb6fed7fb3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ModelData) data).mReferencedBy = values;

        }

        @objid ("80b0951e-b15a-4d71-8a06-16adce3c9c12")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ViewPointSmClass)this.getTarget()).getContextDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b14f48d3-5804-4ebd-9cc6-f59f42ff30ba")
    public static class ReferencedByViewSmDependency extends SmMultipleDependency {
        @objid ("649feefd-5461-46f7-abc3-037bd180a74c")
        private SmDependency symetricDep;

        @objid ("cdb61da7-2687-4687-af51-a147f4dd43bb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ModelData)data).mReferencedByView != null)? ((ModelData)data).mReferencedByView:SmMultipleDependency.EMPTY;
        }

        @objid ("43d9d2ab-05a8-4bb9-83cc-b473518f6807")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ModelData) data).mReferencedByView = values;

        }

        @objid ("543df96d-5f66-4f52-9187-d140b9f6e80b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ArchimateViewSmClass)this.getTarget()).getContextDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("47f7f00b-10d1-4fbd-9061-36acda92b64f")
    public static class FolderSmDependency extends SmMultipleDependency {
        @objid ("7f9c731b-fde1-47c4-99e7-a1203d85bcb3")
        private SmDependency symetricDep;

        @objid ("4f177dbb-b70c-4991-82c6-bf780862b1e8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ModelData)data).mFolder != null)? ((ModelData)data).mFolder:SmMultipleDependency.EMPTY;
        }

        @objid ("94975772-a2ac-46f9-9642-cdd80a608045")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ModelData) data).mFolder = values;

        }

        @objid ("a9c8b0ee-a76b-4758-96b7-5413ff5e541f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((FolderSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
