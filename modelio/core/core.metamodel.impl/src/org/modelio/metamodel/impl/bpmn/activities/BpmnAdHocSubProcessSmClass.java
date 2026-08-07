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
import org.modelio.metamodel.bpmn.activities.AdHocOrdering;
import org.modelio.metamodel.bpmn.activities.BpmnAdHocSubProcess;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f678f6ce-8a18-4ddc-b925-3df960bae1f4")
public class BpmnAdHocSubProcessSmClass extends BpmnSubProcessSmClass {
    @objid ("2409acb9-5463-47c9-ba46-45a1afd16cd6")
    private SmAttribute orderingAtt;

    @objid ("7f0ae0e8-4351-4244-9fb8-c4a089e931b2")
    private SmAttribute cancelRemainingInstancesAtt;

    @objid ("1e17277e-2a64-4481-9a93-f24d05ee8cdd")
    private SmAttribute completionConditionAtt;

    @objid ("aaa8f3c8-3e59-4b9f-a1ee-ba282694f58a")
    public BpmnAdHocSubProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("85d5d81f-a0f4-450e-9639-2ed7019264ba")
    @Override
    public String getName() {
        return "BpmnAdHocSubProcess";

    }

    @objid ("92b2ab3a-f672-40c1-b951-00a0a8dcb826")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("387710fe-8e0b-4ea7-90b6-38ad0787b8b2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnAdHocSubProcess.class;

    }

    @objid ("08fb7396-08ae-41fa-8332-58c64b7171b9")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("58b11d2c-e988-4a01-b464-6d6896dea348")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("918da0a9-cc3d-45a4-9d65-7db7c16cc03b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSubProcess.MQNAME);
        this.registerFactory(new BpmnAdHocSubProcessObjectFactory(this));


        // Initialize and register the SmAttribute
        this.orderingAtt = new OrderingSmAttribute();
        this.orderingAtt.init("Ordering", this, AdHocOrdering.class );
        registerAttribute(this.orderingAtt);

        this.cancelRemainingInstancesAtt = new CancelRemainingInstancesSmAttribute();
        this.cancelRemainingInstancesAtt.init("CancelRemainingInstances", this, Boolean.class );
        registerAttribute(this.cancelRemainingInstancesAtt);

        this.completionConditionAtt = new CompletionConditionSmAttribute();
        this.completionConditionAtt.init("CompletionCondition", this, String.class );
        registerAttribute(this.completionConditionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("1f4551e2-89a3-447b-a231-709ceb3c1ba0")
    public SmAttribute getOrderingAtt() {
        if (this.orderingAtt == null) {
        	this.orderingAtt = this.getAttributeDef("Ordering");
        }
        return this.orderingAtt;
    }

    @objid ("abd6b262-abc4-435d-bc72-de3548ef7fbd")
    public SmAttribute getCancelRemainingInstancesAtt() {
        if (this.cancelRemainingInstancesAtt == null) {
        	this.cancelRemainingInstancesAtt = this.getAttributeDef("CancelRemainingInstances");
        }
        return this.cancelRemainingInstancesAtt;
    }

    @objid ("ab11635f-8eb8-4c51-b52a-6d4cc1c50896")
    public SmAttribute getCompletionConditionAtt() {
        if (this.completionConditionAtt == null) {
        	this.completionConditionAtt = this.getAttributeDef("CompletionCondition");
        }
        return this.completionConditionAtt;
    }

    @objid ("ebdf7ff8-006a-4f8e-9b37-f4a44feac304")
    private static class BpmnAdHocSubProcessObjectFactory implements ISmObjectFactory {
        @objid ("b884ca60-e0cb-4a2f-a983-3a7ad04bbaf9")
        private BpmnAdHocSubProcessSmClass smClass;

        @objid ("9b770b55-883b-45d4-b836-69101ff0e854")
        public BpmnAdHocSubProcessObjectFactory(BpmnAdHocSubProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9b2be25f-91fc-450b-b267-37504b5a805c")
        @Override
        public ISmObjectData createData() {
            return new BpmnAdHocSubProcessData(this.smClass);
        }

        @objid ("3e081130-3cf7-416d-bcf5-c47eb5008fe9")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnAdHocSubProcessImpl();
        }

    }

    @objid ("1c8c8192-be96-4aa5-b064-4172542c889f")
    public static class OrderingSmAttribute extends SmAttribute {
        @objid ("22d6a162-cfb8-4bf9-9872-8298f5de965b")
        public Object getValue(ISmObjectData data) {
            return ((BpmnAdHocSubProcessData) data).mOrdering;
        }

        @objid ("066b6911-0f2b-46d7-9ee4-19afee789635")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnAdHocSubProcessData) data).mOrdering = value;
        }

    }

    @objid ("302fa632-3657-4fb2-8387-ad512c727d6e")
    public static class CancelRemainingInstancesSmAttribute extends SmAttribute {
        @objid ("105cf5ec-98d7-4053-b393-2bcedd292212")
        public Object getValue(ISmObjectData data) {
            return ((BpmnAdHocSubProcessData) data).mCancelRemainingInstances;
        }

        @objid ("ab503c0d-56ac-4168-9473-7f12ee5b3bfd")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnAdHocSubProcessData) data).mCancelRemainingInstances = value;
        }

    }

    @objid ("dadc0fc7-8977-4999-b8ae-b4c201bda585")
    public static class CompletionConditionSmAttribute extends SmAttribute {
        @objid ("e5981547-892b-45e6-9f9d-472950d97ae6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnAdHocSubProcessData) data).mCompletionCondition;
        }

        @objid ("1e4676d4-614e-4b40-8810-f955915bf8f2")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnAdHocSubProcessData) data).mCompletionCondition = value;
        }

    }

}
