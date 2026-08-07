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
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnProcessSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeSmClass;
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

@objid ("1319bcee-ac9f-40ae-9ffb-8b062f330cac")
public class BpmnResourceRoleSmClass extends BpmnBaseElementSmClass {
    @objid ("3f3b003f-e38f-4b11-9712-97aca7e7c67f")
    private SmDependency resourceRefDep;

    @objid ("27b82bc6-2e15-4c3a-92c3-b11e68c2ab05")
    private SmDependency annotatedDep;

    @objid ("63935f4b-2174-427b-a7bf-bc51d8d28bb6")
    private SmDependency resourceParameterBindingDep;

    @objid ("e8589d23-3be5-4688-90bf-0989a67ca48c")
    private SmDependency processDep;

    @objid ("34a48381-e54d-4f03-bcf4-b4710a1bfded")
    public BpmnResourceRoleSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4c4b6642-4265-4537-8d78-2fac0ecc9230")
    @Override
    public String getName() {
        return "BpmnResourceRole";

    }

    @objid ("f69747b2-9f20-4624-8b55-b0e305b1abb1")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("7847f292-18b0-418d-99e9-1d7199f38a3a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnResourceRole.class;

    }

    @objid ("a67f65d2-1213-4db4-8638-35e0ca20eb64")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("21f7cc52-538d-4292-b64b-efad031aa358")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5d9f962a-f33e-4495-878b-770e4e54bafd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnResourceRoleObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.resourceRefDep = new ResourceRefSmDependency();
        this.resourceRefDep.init("ResourceRef", this, metamodel.getMClass(BpmnResource.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.resourceRefDep);

        this.annotatedDep = new AnnotatedSmDependency();
        this.annotatedDep.init("Annotated", this, metamodel.getMClass(BpmnFlowNode.MQNAME), 0, 1 );
        registerDependency(this.annotatedDep);

        this.resourceParameterBindingDep = new ResourceParameterBindingSmDependency();
        this.resourceParameterBindingDep.init("ResourceParameterBinding", this, metamodel.getMClass(BpmnResourceParameterBinding.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.resourceParameterBindingDep);

        this.processDep = new ProcessSmDependency();
        this.processDep.init("Process", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 );
        registerDependency(this.processDep);

    }

    @objid ("dad872c3-8a8a-4e5f-b94b-b5c941a789be")
    public SmDependency getResourceRefDep() {
        if (this.resourceRefDep == null) {
        	this.resourceRefDep = this.getDependencyDef("ResourceRef");
        }
        return this.resourceRefDep;
    }

    @objid ("c30136b2-2d0b-4a91-9216-86ba55701df6")
    public SmDependency getAnnotatedDep() {
        if (this.annotatedDep == null) {
        	this.annotatedDep = this.getDependencyDef("Annotated");
        }
        return this.annotatedDep;
    }

    @objid ("e9a0cd4c-44be-4208-b83f-07f9679ae534")
    public SmDependency getResourceParameterBindingDep() {
        if (this.resourceParameterBindingDep == null) {
        	this.resourceParameterBindingDep = this.getDependencyDef("ResourceParameterBinding");
        }
        return this.resourceParameterBindingDep;
    }

    @objid ("5a46051a-1e32-4390-a4d9-b6e490102fc7")
    public SmDependency getProcessDep() {
        if (this.processDep == null) {
        	this.processDep = this.getDependencyDef("Process");
        }
        return this.processDep;
    }

    @objid ("55a52e72-5bcf-4697-8f77-077abedf14e3")
    private static class BpmnResourceRoleObjectFactory implements ISmObjectFactory {
        @objid ("e2d33fe1-5f02-4fb7-a94a-e4441ece33cb")
        private BpmnResourceRoleSmClass smClass;

        @objid ("928b7f5e-1138-4f11-9b75-7e185447614a")
        public BpmnResourceRoleObjectFactory(BpmnResourceRoleSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3175d238-65a3-4de4-84bb-5906ffe8c707")
        @Override
        public ISmObjectData createData() {
            return new BpmnResourceRoleData(this.smClass);
        }

        @objid ("2cb94fbd-f40b-4ac1-9b39-549b1d9ca709")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnResourceRoleImpl();
        }

    }

    @objid ("15108910-7ea5-418c-9a09-a24de2323533")
    public static class ResourceRefSmDependency extends SmSingleDependency {
        @objid ("e8af4535-c6ee-44cf-9507-fc016b4c9160")
        private SmDependency symetricDep;

        @objid ("dc18a845-8849-49f1-b310-f1c1b0220c86")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceRoleData) data).mResourceRef;
        }

        @objid ("54d38339-4119-4db8-91be-2dc54d4f00cb")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceRoleData) data).mResourceRef = value;
        }

        @objid ("1126189a-e6bc-401f-bcce-d3c0a7fdf779")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceSmClass)this.getTarget()).getResourceroleRefsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a1806a1c-7887-4067-af79-539ef6b0a584")
    public static class AnnotatedSmDependency extends SmSingleDependency {
        @objid ("a628d0d8-c90a-45eb-8ba7-74ce27786728")
        private SmDependency symetricDep;

        @objid ("aaaf274c-d0f7-4a90-9993-6565a273e4d8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceRoleData) data).mAnnotated;
        }

        @objid ("70aa22f7-942e-4f1f-8fe3-1908e65b54a9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceRoleData) data).mAnnotated = value;
        }

        @objid ("ac991250-214a-47b7-9117-52dfd7efb926")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowNodeSmClass)this.getTarget()).getResourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("aa2156df-a527-46f4-a8e7-954b0db91d5f")
    public static class ResourceParameterBindingSmDependency extends SmMultipleDependency {
        @objid ("6a6a8377-3af8-4214-9b3d-d2f122a1dc14")
        private SmDependency symetricDep;

        @objid ("443fe3c1-3a83-4eac-80a9-77e30d46e03b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnResourceRoleData)data).mResourceParameterBinding != null)? ((BpmnResourceRoleData)data).mResourceParameterBinding:SmMultipleDependency.EMPTY;
        }

        @objid ("df6db0d6-aa96-4e27-8031-680d24768a35")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnResourceRoleData) data).mResourceParameterBinding = values;

        }

        @objid ("ef46e98b-93c6-41c8-ae61-9c2babdac349")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceParameterBindingSmClass)this.getTarget()).getResourceRoleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("54fe645b-14c9-49e3-a0ac-99c881f9051d")
    public static class ProcessSmDependency extends SmSingleDependency {
        @objid ("8ced769d-90e9-454a-97e0-d1a04bc62995")
        private SmDependency symetricDep;

        @objid ("8fd4a076-9325-467d-8e9d-850aa34c3357")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceRoleData) data).mProcess;
        }

        @objid ("dcf53552-abc1-4b41-aa21-45cefc5624dd")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceRoleData) data).mProcess = value;
        }

        @objid ("8607ef61-a928-451f-b86a-6cfd7d64ce36")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getResourceDep();
            }
            return this.symetricDep;

        }

    }

}
