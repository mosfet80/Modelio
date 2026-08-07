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
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("47a2e0da-e146-4568-9ea0-eafa8cc8b0e8")
public class BpmnCallActivitySmClass extends BpmnActivitySmClass {
    @objid ("22ca07ce-49c8-4952-82a4-f4d8eeb99d21")
    private SmDependency calledGlobalTaskDep;

    @objid ("2a92fb8d-b30e-4628-abc0-1afc9fd59a02")
    public BpmnCallActivitySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5706079e-0792-4b4b-bb41-8b4afe4182e3")
    @Override
    public String getName() {
        return "BpmnCallActivity";

    }

    @objid ("487c83c8-1890-45a0-a52c-f4db46ac4c32")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3aef16a1-2fb3-4329-bd17-912d30b750d0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCallActivity.class;

    }

    @objid ("0a8213ec-0922-4206-83cf-d1e417b23ed6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f290a304-f950-4104-b1ef-856729b75582")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("62d0aba8-e118-4ca4-bd30-336e2324bbfa")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnActivity.MQNAME);
        this.registerFactory(new BpmnCallActivityObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.calledGlobalTaskDep = new CalledGlobalTaskSmDependency();
        this.calledGlobalTaskDep.init("CalledGlobalTask", this, metamodel.getMClass(BpmnTask.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.calledGlobalTaskDep);

    }

    @objid ("095f1aa0-9a18-4337-bd35-de1be3914d03")
    public SmDependency getCalledGlobalTaskDep() {
        if (this.calledGlobalTaskDep == null) {
        	this.calledGlobalTaskDep = this.getDependencyDef("CalledGlobalTask");
        }
        return this.calledGlobalTaskDep;
    }

    @objid ("fdaa7d04-a33f-4335-b5b2-f06df9179141")
    private static class BpmnCallActivityObjectFactory implements ISmObjectFactory {
        @objid ("f37c4b14-ea2f-440c-b42f-e4ff3d610a49")
        private BpmnCallActivitySmClass smClass;

        @objid ("c93070d6-398b-4266-966a-096714746435")
        public BpmnCallActivityObjectFactory(BpmnCallActivitySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d5b64528-7c2b-425d-ac21-5c3a32845dc3")
        @Override
        public ISmObjectData createData() {
            return new BpmnCallActivityData(this.smClass);
        }

        @objid ("cb4a11ba-76dc-4ad9-8393-533bce0b401e")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnCallActivityImpl();
        }

    }

    @objid ("56b1900d-8af1-4b43-8b81-f6f5ac940de3")
    public static class CalledGlobalTaskSmDependency extends SmSingleDependency {
        @objid ("3d5431f6-801a-4305-b870-1255bd0f4fb1")
        private SmDependency symetricDep;

        @objid ("8217fc8a-8af2-41a5-9d97-fc97b7cd71e1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnCallActivityData) data).mCalledGlobalTask;
        }

        @objid ("d34ea905-350b-49bd-b99a-2144754d7beb")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnCallActivityData) data).mCalledGlobalTask = value;
        }

        @objid ("94606474-c9e9-421d-8048-f4df85de2a9b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnTaskSmClass)this.getTarget()).getCallerDep();
            }
            return this.symetricDep;

        }

    }

}
