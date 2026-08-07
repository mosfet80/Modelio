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
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.activities.BpmnTransaction;
import org.modelio.metamodel.bpmn.activities.TransactionMethod;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f4b44df4-bd16-4021-a24a-6da3ceb2e68d")
public class BpmnTransactionSmClass extends BpmnSubProcessSmClass {
    @objid ("40c22f37-b6da-4974-86d2-b4f65cb94413")
    private SmAttribute methodAtt;

    @objid ("4d849e9e-b806-4e26-bbcd-5169e14b600b")
    public BpmnTransactionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("08d7a63c-d903-4dee-8e01-752fec917bc0")
    @Override
    public String getName() {
        return "BpmnTransaction";

    }

    @objid ("22822518-fba7-48ee-a96d-e9bb767d72e6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("79f5992b-93d8-40dd-b800-4f467c61715e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnTransaction.class;

    }

    @objid ("4d2555df-15aa-447b-a06d-685c210a9915")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fae70bc9-1d94-404f-84ce-875bec118c5e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e342512a-50d2-4e30-9166-8ec21afcafce")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSubProcess.MQNAME);
        this.registerFactory(new BpmnTransactionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.methodAtt = new MethodSmAttribute();
        this.methodAtt.init("Method", this, TransactionMethod.class );
        registerAttribute(this.methodAtt);


        // Initialize and register the SmDependency

    }

    @objid ("48c0118e-b48b-4431-9b5d-a30774dd8c4e")
    public SmAttribute getMethodAtt() {
        if (this.methodAtt == null) {
        	this.methodAtt = this.getAttributeDef("Method");
        }
        return this.methodAtt;
    }

    @objid ("f5f7a9ed-f8f6-408a-a373-6a4913fd572c")
    private static class BpmnTransactionObjectFactory implements ISmObjectFactory {
        @objid ("81d592c5-df45-4cfd-9bab-480d109b387e")
        private BpmnTransactionSmClass smClass;

        @objid ("2ac44065-edba-40d0-858d-a2184ff96cec")
        public BpmnTransactionObjectFactory(BpmnTransactionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c023eab0-71ae-41c5-bd52-4d51812d34ab")
        @Override
        public ISmObjectData createData() {
            return new BpmnTransactionData(this.smClass);
        }

        @objid ("edc54da8-fae7-45ef-8e2b-c09551d50a9b")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnTransactionImpl();
        }

    }

    @objid ("b7dafd94-c8ee-46dc-8525-a978af0fa68c")
    public static class MethodSmAttribute extends SmAttribute {
        @objid ("2fd9493f-202d-4a9f-8d23-0e858a8990c6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnTransactionData) data).mMethod;
        }

        @objid ("50a793c9-3c24-4cb5-adce-fe3a0c9ddf47")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnTransactionData) data).mMethod = value;
        }

    }

}
