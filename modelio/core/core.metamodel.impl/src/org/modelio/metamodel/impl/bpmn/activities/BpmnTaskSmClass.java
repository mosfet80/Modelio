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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnCallActivity;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
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

@objid ("de8fea2f-6f2e-4aed-8b9d-e955335a3d26")
public class BpmnTaskSmClass extends BpmnActivitySmClass {
    @objid ("8daa07b1-2f36-4996-b660-46e43ff2ce3e")
    private SmAttribute isGlobalAtt;

    @objid ("e8449627-9d38-47ed-8a81-ab3415cdfaeb")
    private SmDependency callerDep;

    @objid ("a728687e-e4ff-44fc-ab5c-e68457aeed09")
    public BpmnTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0187b89b-7e8a-4cc6-880f-43d530a8a339")
    @Override
    public String getName() {
        return "BpmnTask";

    }

    @objid ("bd6337e3-214d-40ef-969c-ce9eac3fe456")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("aebdf403-f187-4783-812f-91dd58ceb610")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnTask.class;

    }

    @objid ("b5daa0e5-88b7-46f0-ad27-8b2ec6a886be")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("988c3cb0-dee8-4ee7-8d6a-37253ed6e975")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5e6591c8-6fea-4100-baba-94588cdbe099")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnActivity.MQNAME);
        this.registerFactory(new BpmnTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isGlobalAtt = new IsGlobalSmAttribute();
        this.isGlobalAtt.init("IsGlobal", this, Boolean.class );
        registerAttribute(this.isGlobalAtt);


        // Initialize and register the SmDependency
        this.callerDep = new CallerSmDependency();
        this.callerDep.init("Caller", this, metamodel.getMClass(BpmnCallActivity.MQNAME), 0, -1 );
        registerDependency(this.callerDep);

    }

    @objid ("7772b791-091e-44d0-bcc3-0abdb57179ae")
    public SmAttribute getIsGlobalAtt() {
        if (this.isGlobalAtt == null) {
        	this.isGlobalAtt = this.getAttributeDef("IsGlobal");
        }
        return this.isGlobalAtt;
    }

    @objid ("8e9f0ae0-aa38-4807-9ee1-912aefaaf7ad")
    public SmDependency getCallerDep() {
        if (this.callerDep == null) {
        	this.callerDep = this.getDependencyDef("Caller");
        }
        return this.callerDep;
    }

    @objid ("3d9fe27c-845a-42d3-b889-8473d25e5e5f")
    private static class BpmnTaskObjectFactory implements ISmObjectFactory {
        @objid ("dc6a817c-3da0-4505-ad41-b19c799d267e")
        private BpmnTaskSmClass smClass;

        @objid ("01810542-de56-4b60-856e-3ef146eef672")
        public BpmnTaskObjectFactory(BpmnTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("25f92aa8-3c2d-4732-beb4-409a7676686c")
        @Override
        public ISmObjectData createData() {
            return new BpmnTaskData(this.smClass);
        }

        @objid ("fc4ebdd3-98ca-4244-ba89-3e19b81330c9")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnTaskImpl();
        }

    }

    @objid ("6bc714cc-9a44-453b-b892-97f641a9accd")
    public static class IsGlobalSmAttribute extends SmAttribute {
        @objid ("d37d1789-2eee-49c2-8b83-7257586d7166")
        public Object getValue(ISmObjectData data) {
            return ((BpmnTaskData) data).mIsGlobal;
        }

        @objid ("7739d277-d6f9-4077-a93e-cdc2c4a1cd35")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnTaskData) data).mIsGlobal = value;
        }

    }

    @objid ("b807db95-36cf-4b07-9843-84afb8b6d1c5")
    public static class CallerSmDependency extends SmMultipleDependency {
        @objid ("ae3e6313-e8e5-4fd8-bbfd-6e2099be6bbe")
        private SmDependency symetricDep;

        @objid ("0320b885-fc8e-4a3c-9187-ccb1d9ee4241")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnTaskData)data).mCaller != null)? ((BpmnTaskData)data).mCaller:SmMultipleDependency.EMPTY;
        }

        @objid ("7612aea2-2be7-4105-8065-a032338c60a3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnTaskData) data).mCaller = values;

        }

        @objid ("e54d12b2-4a4f-476f-a45e-e809f6ecd5f7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCallActivitySmClass)this.getTarget()).getCalledGlobalTaskDep();
            }
            return this.symetricDep;

        }

    }

}
