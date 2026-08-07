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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataAssociationSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataInputSmClass;
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

@objid ("bb9f5409-3f70-4767-a919-f7d44f27a835")
public class BpmnThrowEventSmClass extends BpmnEventSmClass {
    @objid ("da5bd5d1-7aaf-42b4-bfc9-dffe9e029538")
    private SmDependency dataInputAssociationDep;

    @objid ("2260dfae-a931-4a0b-8200-a223aa180d32")
    private SmDependency dataInputDep;

    @objid ("d4b1ec17-a49b-40ab-a3be-b23417b9afa2")
    public BpmnThrowEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d94a2ca5-81d4-4d27-98e8-475db5ea1886")
    @Override
    public String getName() {
        return "BpmnThrowEvent";

    }

    @objid ("cad5ff63-5ded-4d83-bb7e-1527edb45ae9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("8b0b56cc-4eab-4edf-ab0b-3e0bd13af928")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnThrowEvent.class;

    }

    @objid ("28ee1364-62bc-4861-80e0-39f038584d47")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b486d50d-ee41-4007-bf28-725770c5e235")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("e4e43e76-61f2-4105-a733-45875bea384a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEvent.MQNAME);
        this.registerFactory(new BpmnThrowEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.dataInputAssociationDep = new DataInputAssociationSmDependency();
        this.dataInputAssociationDep.init("DataInputAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataInputAssociationDep);

        this.dataInputDep = new DataInputSmDependency();
        this.dataInputDep.init("DataInput", this, metamodel.getMClass(BpmnDataInput.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataInputDep);

    }

    @objid ("895947c8-6c1e-4ecb-be77-6fd68503856e")
    public SmDependency getDataInputAssociationDep() {
        if (this.dataInputAssociationDep == null) {
        	this.dataInputAssociationDep = this.getDependencyDef("DataInputAssociation");
        }
        return this.dataInputAssociationDep;
    }

    @objid ("70b13750-c656-419c-ab1a-e3eec83016b3")
    public SmDependency getDataInputDep() {
        if (this.dataInputDep == null) {
        	this.dataInputDep = this.getDependencyDef("DataInput");
        }
        return this.dataInputDep;
    }

    @objid ("f5e5ce5a-63e6-482e-92ab-49d81c680f5a")
    private static class BpmnThrowEventObjectFactory implements ISmObjectFactory {
        @objid ("07a79cef-a389-41a3-ab9f-22b731ab51c7")
        private BpmnThrowEventSmClass smClass;

        @objid ("aa25661e-0918-45e6-bb34-03c7b83418f5")
        public BpmnThrowEventObjectFactory(BpmnThrowEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("62dde971-32b0-4efe-9d31-ba662200a01d")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("0a3b7e31-2af4-4a83-a9b5-9492ba50b750")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("319cee27-f52a-4f6f-afa1-e03f54f65639")
    public static class DataInputAssociationSmDependency extends SmMultipleDependency {
        @objid ("381e6f57-c483-4633-ad4f-ce09a781ec3c")
        private SmDependency symetricDep;

        @objid ("ab19b43f-8d2a-411f-817e-7488a4a66b73")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnThrowEventData)data).mDataInputAssociation != null)? ((BpmnThrowEventData)data).mDataInputAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("671698cc-ce15-47dc-b0ae-94820dded7bc")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnThrowEventData) data).mDataInputAssociation = values;

        }

        @objid ("b39a737b-221b-43a5-ab9a-75a31834940f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getStartingEventDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8a15fd92-ebd5-4d71-b909-142e614213c3")
    public static class DataInputSmDependency extends SmSingleDependency {
        @objid ("dc50d30a-7637-4562-b50f-65eec42a7ddc")
        private SmDependency symetricDep;

        @objid ("23840a82-de25-4975-957c-0bb888ba29eb")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnThrowEventData) data).mDataInput;
        }

        @objid ("e25d2f27-0629-49bd-8bcd-6753f4a1d3d9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnThrowEventData) data).mDataInput = value;
        }

        @objid ("4b01b8d1-9325-4f7d-9709-242af3e9df8d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataInputSmClass)this.getTarget()).getOwnerThrowEventDep();
            }
            return this.symetricDep;

        }

    }

}
