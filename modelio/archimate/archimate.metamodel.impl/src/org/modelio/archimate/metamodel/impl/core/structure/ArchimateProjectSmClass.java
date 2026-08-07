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
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectSmClass;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("85d84515-24f6-4b50-90e2-327af18980b5")
public class ArchimateProjectSmClass extends AbstractProjectSmClass {
    @objid ("10c9ba0d-8d0b-4784-bcdc-b53158522ff4")
    private SmDependency modelDep;

    @objid ("c2215978-ad38-4ae6-83b5-3d8bc9c65e87")
    private SmDependency viewPointsDep;

    @objid ("5d3bb568-33dc-42ce-9425-7d696d4d4eb1")
    public ArchimateProjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("08fb49c9-7f21-42d4-9950-0afae2555cc4")
    @Override
    public String getName() {
        return "ArchimateProject";

    }

    @objid ("92c6a1c7-624b-4c01-8a74-e07ebb4ac09b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ffd7da6f-e43d-4e4e-9210-b37d277e3737")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ArchimateProject.class;

    }

    @objid ("5a0e30c8-1bc9-4013-b588-20ff8fed4c3a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("e7ef2fc3-656c-42f1-95ce-1c588d0a42de")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f11f2a2e-a5f9-46b6-bbdf-0416fb8d0906")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractProject.MQNAME);
        this.registerFactory(new ArchimateProjectObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.modelDep = new ModelSmDependency();
        this.modelDep.init("model", this, metamodel.getMClass(Model.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.modelDep);

        this.viewPointsDep = new ViewPointsSmDependency();
        this.viewPointsDep.init("viewPoints", this, metamodel.getMClass(ViewPoint.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.viewPointsDep);

    }

    @objid ("abbf9a22-c767-46a4-a9b2-3fd453028388")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("model");
        }
        return this.modelDep;
    }

    @objid ("076bb1d0-93f0-4e71-a5da-3473b146eca4")
    public SmDependency getViewPointsDep() {
        if (this.viewPointsDep == null) {
        	this.viewPointsDep = this.getDependencyDef("viewPoints");
        }
        return this.viewPointsDep;
    }

    @objid ("5ab37c0d-85d5-491e-af75-58acc3cbde7e")
    @Override
    public boolean areOrphansAllowed() {
        return true;

    }

    @objid ("fe943eb4-4c21-4d4b-bcc0-55fd5ac2fc46")
    private static class ArchimateProjectObjectFactory implements ISmObjectFactory {
        @objid ("2898cd74-228c-462f-9b13-d09c28cbc832")
        private ArchimateProjectSmClass smClass;

        @objid ("98f6c871-4e25-4150-857f-1367f65e759e")
        public ArchimateProjectObjectFactory(ArchimateProjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5669d453-882f-4ce6-8280-5e813c6beeb5")
        @Override
        public ISmObjectData createData() {
            return new ArchimateProjectData(this.smClass);
        }

        @objid ("fb05d53b-be02-40d2-bc77-34567564be16")
        @Override
        public SmObjectImpl createImpl() {
            return new ArchimateProjectImpl();
        }

    }

    @objid ("2282fd45-7395-4223-b65c-f65ca63db61a")
    public static class ModelSmDependency extends SmMultipleDependency {
        @objid ("14c034b9-5558-4857-8fb3-f8ef8a1c37ed")
        private SmDependency symetricDep;

        @objid ("fea589a9-7935-4f8a-a221-5cdde9f82aa8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ArchimateProjectData)data).mModel != null)? ((ArchimateProjectData)data).mModel:SmMultipleDependency.EMPTY;
        }

        @objid ("8fa4c9ec-7b6d-4e43-b801-d0291ccb4e7f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ArchimateProjectData) data).mModel = values;

        }

        @objid ("38106048-8697-4764-af7d-aee5bb156a00")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelSmClass)this.getTarget()).getProjectDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("30263a51-1ccd-439b-849e-17f7ef18c32f")
    public static class ViewPointsSmDependency extends SmMultipleDependency {
        @objid ("1c978e5e-5a28-4a2a-8d17-95edc3a7e03c")
        private SmDependency symetricDep;

        @objid ("045b3790-2904-4f36-94aa-62c17ad4269a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ArchimateProjectData)data).mViewPoints != null)? ((ArchimateProjectData)data).mViewPoints:SmMultipleDependency.EMPTY;
        }

        @objid ("c6e1b5fd-4abc-4603-a48c-b5b6a4a07f61")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ArchimateProjectData) data).mViewPoints = values;

        }

        @objid ("df9855f8-f3a6-4098-a7de-8fb848490857")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ViewPointSmClass)this.getTarget()).getProjectDep();
            }
            return this.symetricDep;

        }

    }

}
