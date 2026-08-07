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
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
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

@objid ("40b17b88-05ab-4e0c-8b1f-d64f7c864a82")
public class BpmnLoopCharacteristicsSmClass extends BpmnBaseElementSmClass {
    @objid ("eefc316e-c9ba-4683-90e0-86c5c8d8f110")
    private SmDependency ownerActivityDep;

    @objid ("c8a25983-b878-4167-9d77-3302d83684b7")
    public BpmnLoopCharacteristicsSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0ac6eb61-3c11-4a48-9729-19934f87e24e")
    @Override
    public String getName() {
        return "BpmnLoopCharacteristics";

    }

    @objid ("87bbc268-8a49-43c2-8f65-2b118ef67982")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("8cd07740-96fe-4de7-b1bf-ddef152c7ae0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnLoopCharacteristics.class;

    }

    @objid ("48ab8b77-bdf6-4e68-8351-160f4583969c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fa3b7d48-b8e6-410e-9da7-85a8c9460990")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("159650b7-966c-4671-8965-c8576859c10b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnLoopCharacteristicsObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerActivityDep = new OwnerActivitySmDependency();
        this.ownerActivityDep.init("OwnerActivity", this, metamodel.getMClass(BpmnActivity.MQNAME), 1, 1 );
        registerDependency(this.ownerActivityDep);

    }

    @objid ("7828e9e4-61a4-4e9e-84fd-1bed9c97c760")
    public SmDependency getOwnerActivityDep() {
        if (this.ownerActivityDep == null) {
        	this.ownerActivityDep = this.getDependencyDef("OwnerActivity");
        }
        return this.ownerActivityDep;
    }

    @objid ("095270c5-f363-405c-9b8d-39cd01e6ee31")
    private static class BpmnLoopCharacteristicsObjectFactory implements ISmObjectFactory {
        @objid ("65fe23f3-6d3b-453a-b58f-5bf039707e01")
        private BpmnLoopCharacteristicsSmClass smClass;

        @objid ("a6af4726-f55e-43de-a9fa-c64f25fd8b69")
        public BpmnLoopCharacteristicsObjectFactory(BpmnLoopCharacteristicsSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("321aa3e1-bd00-45c0-994d-ded849979e8c")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("bfdc9121-f79b-4b3f-8b79-226cb37c2bed")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("14655c42-9616-4ff1-9803-46c14ea006ca")
    public static class OwnerActivitySmDependency extends SmSingleDependency {
        @objid ("f4239bc5-205c-4693-8de2-9780aed4a9e0")
        private SmDependency symetricDep;

        @objid ("f496cc0d-e33a-4a7b-a214-2a861d92ece5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLoopCharacteristicsData) data).mOwnerActivity;
        }

        @objid ("4e620b6c-9122-4343-a555-1c622cd15740")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLoopCharacteristicsData) data).mOwnerActivity = value;
        }

        @objid ("1115e81f-32b4-4ffc-b27c-c980edeff84f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getLoopCharacteristicsDep();
            }
            return this.symetricDep;

        }

    }

}
