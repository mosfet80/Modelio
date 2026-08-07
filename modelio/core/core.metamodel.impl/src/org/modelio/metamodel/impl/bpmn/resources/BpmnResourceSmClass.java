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
package org.modelio.metamodel.impl.bpmn.resources;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementSmClass;
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

@objid ("c1f59956-870a-44c7-bfe4-146d808cbdbe")
public class BpmnResourceSmClass extends BpmnSharedElementSmClass {
    @objid ("d6aed52b-5551-425b-907b-1bf42d9935a5")
    private SmDependency resourceroleRefsDep;

    @objid ("1647773e-ed50-4a76-baa7-e2c837254f5f")
    private SmDependency parameterDep;

    @objid ("53562160-eda9-491a-b962-3cd879d5d3c4")
    public BpmnResourceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9a85a49b-b4df-4d11-844f-d5b78d8ac351")
    @Override
    public String getName() {
        return "BpmnResource";

    }

    @objid ("5b3d9a84-e316-4f1a-ae72-70a1cbb6a8c5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("8cb0e20f-851b-47c1-a610-a540b7ba45dd")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnResource.class;

    }

    @objid ("48170e0e-ec2e-4bd5-90ca-b26fe4d82fe0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("23d4a519-6168-4ada-ab7b-902875bfbe4a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("38586462-7387-4f5f-b42a-dfad4f519321")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSharedElement.MQNAME);
        this.registerFactory(new BpmnResourceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.resourceroleRefsDep = new ResourceroleRefsSmDependency();
        this.resourceroleRefsDep.init("ResourceroleRefs", this, metamodel.getMClass(BpmnResourceRole.MQNAME), 0, -1 );
        registerDependency(this.resourceroleRefsDep);

        this.parameterDep = new ParameterSmDependency();
        this.parameterDep.init("Parameter", this, metamodel.getMClass(BpmnResourceParameter.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.parameterDep);

    }

    @objid ("885799ee-cb69-4f75-b710-7bcd1530f5b6")
    public SmDependency getResourceroleRefsDep() {
        if (this.resourceroleRefsDep == null) {
        	this.resourceroleRefsDep = this.getDependencyDef("ResourceroleRefs");
        }
        return this.resourceroleRefsDep;
    }

    @objid ("285f973f-3941-438f-a0af-b6fc558e51a5")
    public SmDependency getParameterDep() {
        if (this.parameterDep == null) {
        	this.parameterDep = this.getDependencyDef("Parameter");
        }
        return this.parameterDep;
    }

    @objid ("eb39271a-cc23-4083-9253-c22071448d50")
    private static class BpmnResourceObjectFactory implements ISmObjectFactory {
        @objid ("596a7b81-e8b1-48f7-b862-731cf66f8095")
        private BpmnResourceSmClass smClass;

        @objid ("85b68b3f-46f9-44b6-9947-2106c25bd5df")
        public BpmnResourceObjectFactory(BpmnResourceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fb023b68-9658-4d69-8552-ca561d036c6f")
        @Override
        public ISmObjectData createData() {
            return new BpmnResourceData(this.smClass);
        }

        @objid ("31758c25-ef04-472b-afd7-733e4a49cc1e")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnResourceImpl();
        }

    }

    @objid ("cbb529de-8aa9-420c-960d-e27e161207ad")
    public static class ResourceroleRefsSmDependency extends SmMultipleDependency {
        @objid ("0343d306-f2bf-4d94-8239-f61eb5614be0")
        private SmDependency symetricDep;

        @objid ("68ca3b62-1d7f-43fb-af91-900f64cd02a5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnResourceData)data).mResourceroleRefs != null)? ((BpmnResourceData)data).mResourceroleRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("1ca9b0d2-7a8d-43e6-9b6d-274ff6576cc9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnResourceData) data).mResourceroleRefs = values;

        }

        @objid ("430823a9-3aba-45dd-99e4-291ddb149870")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceRoleSmClass)this.getTarget()).getResourceRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("423189b3-1d27-427e-9115-710f00724fd3")
    public static class ParameterSmDependency extends SmMultipleDependency {
        @objid ("6a7da1ad-51d3-41d8-affd-663efe466ddb")
        private SmDependency symetricDep;

        @objid ("7f810439-0817-4b17-8679-6ffaf3c7a4b8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnResourceData)data).mParameter != null)? ((BpmnResourceData)data).mParameter:SmMultipleDependency.EMPTY;
        }

        @objid ("c282a2d7-1d75-4012-9407-4f13df20e854")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnResourceData) data).mParameter = values;

        }

        @objid ("200643ca-073f-45df-8cbe-25050b846dd4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceParameterSmClass)this.getTarget()).getResourceDep();
            }
            return this.symetricDep;

        }

    }

}
