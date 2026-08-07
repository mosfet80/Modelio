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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.objects.BpmnDataState;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
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

@objid ("1d15032f-577b-4daa-8a38-531f0d847d64")
public class BpmnDataStateSmClass extends BpmnBaseElementSmClass {
    @objid ("54dcfbbc-5177-4448-9417-2ed0c28fb48d")
    private SmDependency itemDep;

    @objid ("affa3531-2292-4733-a12d-8eb653764214")
    public BpmnDataStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2b8ca5c7-337c-4af1-8750-b859345967c5")
    @Override
    public String getName() {
        return "BpmnDataState";

    }

    @objid ("f11b3985-42cc-45b8-9cb1-544636cfef53")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1f3eaa23-d1f7-4dde-8acf-c10cea245100")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataState.class;

    }

    @objid ("cff54b62-a8b7-4ddd-8408-4999eb5f331f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b7eff95b-1362-4775-ae6e-a4697efa0df3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f94b2797-5b24-4c8d-836f-cd186fb0eb7f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnDataStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.itemDep = new ItemSmDependency();
        this.itemDep.init("Item", this, metamodel.getMClass(BpmnItemAwareElement.MQNAME), 1, 1 );
        registerDependency(this.itemDep);

    }

    @objid ("c12f909a-6a21-4986-9675-7121d12afac6")
    public SmDependency getItemDep() {
        if (this.itemDep == null) {
        	this.itemDep = this.getDependencyDef("Item");
        }
        return this.itemDep;
    }

    @objid ("95b6f06b-271e-4c66-9bfc-4fba2f432008")
    private static class BpmnDataStateObjectFactory implements ISmObjectFactory {
        @objid ("d2697db2-dc77-4eb4-9ef7-cbfa4130b9bf")
        private BpmnDataStateSmClass smClass;

        @objid ("980737cb-4c24-4839-b1c9-5a752ae64bc0")
        public BpmnDataStateObjectFactory(BpmnDataStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7f62e3dd-c963-4433-9c80-cb8b842fd262")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataStateData(this.smClass);
        }

        @objid ("9ac038ee-5128-4266-9103-eadb16386503")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataStateImpl();
        }

    }

    @objid ("08576930-f569-4f92-b576-681ab3f5547c")
    public static class ItemSmDependency extends SmSingleDependency {
        @objid ("95ad85bc-0c6f-4786-8315-a73e9df85e24")
        private SmDependency symetricDep;

        @objid ("0fd9a786-c371-43d6-b809-cd2a92dfde58")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataStateData) data).mItem;
        }

        @objid ("534896d6-e09e-44af-8250-4f8748c48329")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataStateData) data).mItem = value;
        }

        @objid ("c0543cf4-a0e2-4421-b3e0-0256c7bfcced")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemAwareElementSmClass)this.getTarget()).getDataStateDep();
            }
            return this.symetricDep;

        }

    }

}
