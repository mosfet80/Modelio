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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.mda;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectSmClass;
import org.modelio.metamodel.impl.uml.statik.PackageSmClass;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("89372670-8d71-4434-8d2f-26ea95be7263")
public class ProjectSmClass extends AbstractProjectSmClass {
    @objid ("c93c21ce-02ba-4f80-b414-5ef69d273fb3")
    private SmAttribute projectContextAtt;

    @objid ("123a7a4f-140b-4762-9aa9-7848a302ab22")
    private SmAttribute projectDescrAtt;

    @objid ("c1de4871-e31e-4848-9ca9-41e0beb24e3b")
    private SmDependency modelDep;

    @objid ("10c17841-5183-4c9d-a14d-81ddddc0c5b3")
    public ProjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4e1a08da-b100-49a0-ac60-b06027b8b974")
    @Override
    public String getName() {
        return "Project";

    }

    @objid ("36678720-cfea-4450-9f60-e0adaadce7d5")
    @Override
    public Version getVersion() {
        return new Version("1.1.1");
    }

    @objid ("1661ace8-a6bd-431c-8ce7-d8e0b36ab71f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Project.class;

    }

    @objid ("6d299cdd-6abf-42fe-be41-9e570589104c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9342ce3a-3b3a-4162-8a63-fa84412db07f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2fd56fde-cc53-4510-85f6-0f38b779d645")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractProject.MQNAME);
        this.registerFactory(new ProjectObjectFactory(this));


        // Initialize and register the SmAttribute
        this.projectContextAtt = new ProjectContextSmAttribute();
        this.projectContextAtt.init("ProjectContext", this, String.class );
        registerAttribute(this.projectContextAtt);

        this.projectDescrAtt = new ProjectDescrSmAttribute();
        this.projectDescrAtt.init("ProjectDescr", this, String.class );
        registerAttribute(this.projectDescrAtt);


        // Initialize and register the SmDependency
        this.modelDep = new ModelSmDependency();
        this.modelDep.init("Model", this, metamodel.getMClass(Package.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.modelDep);

    }

    @objid ("3717970f-256b-4a29-89e1-79959ca8a24d")
    public SmAttribute getProjectContextAtt() {
        if (this.projectContextAtt == null) {
        	this.projectContextAtt = this.getAttributeDef("ProjectContext");
        }
        return this.projectContextAtt;
    }

    @objid ("dcd8097a-0e1a-48d4-a9ce-5e63bcacde8f")
    public SmAttribute getProjectDescrAtt() {
        if (this.projectDescrAtt == null) {
        	this.projectDescrAtt = this.getAttributeDef("ProjectDescr");
        }
        return this.projectDescrAtt;
    }

    @objid ("86722396-78d1-4a6e-aec6-65267406ba92")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("Model");
        }
        return this.modelDep;
    }

    @objid ("181900d8-2920-40d1-8c76-508c0f2d8dea")
    @Override
    public boolean areOrphansAllowed() {
        return true;

    }

    @objid ("8184752d-2599-450a-9246-e93681627a23")
    private static class ProjectObjectFactory implements ISmObjectFactory {
        @objid ("f391cc15-2124-44bc-bb53-d3f01e5dd31c")
        private ProjectSmClass smClass;

        @objid ("fdd475e2-0604-4f43-9934-730fd0fb916f")
        public ProjectObjectFactory(ProjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e59ede96-95ef-47c2-bbbb-64b2a4bf3546")
        @Override
        public ISmObjectData createData() {
            return new ProjectData(this.smClass);
        }

        @objid ("fc5df0c1-7d6b-4a58-93d3-f4951767a516")
        @Override
        public SmObjectImpl createImpl() {
            return new ProjectImpl();
        }

    }

    @objid ("2efdf20b-cca3-46fe-aa1c-2646ca9c10ff")
    public static class ProjectContextSmAttribute extends SmAttribute {
        @objid ("d0bc438e-48c4-4963-ab80-14d7283dab95")
        public Object getValue(ISmObjectData data) {
            return ((ProjectData) data).mProjectContext;
        }

        @objid ("9dcf1a1e-d0e1-4713-892f-7b06c0bc36bd")
        public void setValue(ISmObjectData data, Object value) {
            ((ProjectData) data).mProjectContext = value;
        }

    }

    @objid ("c71b1c26-1dd3-402e-bac4-acbbc0aa9196")
    public static class ProjectDescrSmAttribute extends SmAttribute {
        @objid ("24acc1d3-1976-432b-b169-369c4f7af44f")
        public Object getValue(ISmObjectData data) {
            return ((ProjectData) data).mProjectDescr;
        }

        @objid ("1cbfcb62-6d8c-4af5-aca6-a3c0cdbab4eb")
        public void setValue(ISmObjectData data, Object value) {
            ((ProjectData) data).mProjectDescr = value;
        }

    }

    @objid ("be0afe4a-c8bb-4d94-b258-cc355d2809ba")
    public static class ModelSmDependency extends SmMultipleDependency {
        @objid ("888b0e1c-543f-415c-8ba9-a8b5422d0169")
        private SmDependency symetricDep;

        @objid ("f926a51d-e974-435d-afdd-e84f165c894c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ProjectData)data).mModel != null)? ((ProjectData)data).mModel:SmMultipleDependency.EMPTY;
        }

        @objid ("0022eb0e-026e-421c-82fe-b0b39fe6327a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ProjectData) data).mModel = values;

        }

        @objid ("3c77334f-9c1d-4f07-a21f-8ace128bac31")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

}
