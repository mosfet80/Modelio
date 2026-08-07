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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("433e47df-dc16-440a-be26-aecc715e5788")
public class BpmnBoundaryEventSmClass extends BpmnCatchEventSmClass {
    @objid ("5d5743fc-28f3-43de-bb5b-4131fef60e10")
    private SmAttribute cancelActivityAtt;

    @objid ("88a13015-7c9e-4306-a67d-817a07a96a96")
    private SmDependency attachedToRefDep;

    @objid ("da4924d9-2378-4f07-a894-68f60e4d10ca")
    public BpmnBoundaryEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("290871eb-8e1c-4491-9e95-44a1c3e1a3d8")
    @Override
    public String getName() {
        return "BpmnBoundaryEvent";

    }

    @objid ("16a0ed1f-bbd3-4f83-9559-bdcba32c5d0e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("26d0d4b2-6213-4fff-a160-3932de1a3c90")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnBoundaryEvent.class;

    }

    @objid ("f7ba7446-8975-4c02-9f15-b0ab12181299")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9d14586f-2ffa-43dd-ad6b-37410490bc5a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f52a72a4-0cb4-4164-b711-915f7ccbe6ba")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnCatchEvent.MQNAME);
        this.registerFactory(new BpmnBoundaryEventObjectFactory(this));


        // Initialize and register the SmAttribute
        this.cancelActivityAtt = new CancelActivitySmAttribute();
        this.cancelActivityAtt.init("CancelActivity", this, Boolean.class );
        registerAttribute(this.cancelActivityAtt);


        // Initialize and register the SmDependency
        this.attachedToRefDep = new AttachedToRefSmDependency();
        this.attachedToRefDep.init("AttachedToRef", this, metamodel.getMClass(BpmnActivity.MQNAME), 1, 1 );
        registerDependency(this.attachedToRefDep);

    }

    @objid ("4a8acc91-1560-461d-99cf-d74c25d97d5c")
    public SmAttribute getCancelActivityAtt() {
        if (this.cancelActivityAtt == null) {
        	this.cancelActivityAtt = this.getAttributeDef("CancelActivity");
        }
        return this.cancelActivityAtt;
    }

    @objid ("e115823d-6253-4442-b735-2248478dad1b")
    public SmDependency getAttachedToRefDep() {
        if (this.attachedToRefDep == null) {
        	this.attachedToRefDep = this.getDependencyDef("AttachedToRef");
        }
        return this.attachedToRefDep;
    }

    @objid ("11514c9c-a3a1-4ef9-9f45-f4b358449a9e")
    private static class BpmnBoundaryEventObjectFactory implements ISmObjectFactory {
        @objid ("95aadf01-1deb-42d4-ac7a-bc0270fca043")
        private BpmnBoundaryEventSmClass smClass;

        @objid ("e78e5809-06f0-4bf1-8fdf-5d7364ab89c3")
        public BpmnBoundaryEventObjectFactory(BpmnBoundaryEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b5393c20-1b33-4a5b-b642-d2c355a75028")
        @Override
        public ISmObjectData createData() {
            return new BpmnBoundaryEventData(this.smClass);
        }

        @objid ("61675203-40aa-4f62-8620-f62d0fb25076")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnBoundaryEventImpl();
        }

    }

    @objid ("6f83f4a3-ef48-46f3-8660-041f6d6d6722")
    public static class CancelActivitySmAttribute extends SmAttribute {
        @objid ("12597d8b-7867-4b22-9b94-df0ea42c4c15")
        public Object getValue(ISmObjectData data) {
            return ((BpmnBoundaryEventData) data).mCancelActivity;
        }

        @objid ("45b3490e-fc46-47ac-a6c6-8be6339a9d3d")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnBoundaryEventData) data).mCancelActivity = value;
        }

    }

    @objid ("b2ef7dca-6bd0-4249-87eb-495b5d5aad08")
    public static class AttachedToRefSmDependency extends SmSingleDependency {
        @objid ("21534a16-2cb2-46b8-8f25-c5b2fe23eba0")
        private SmDependency symetricDep;

        @objid ("b0e8a1ba-e644-48dd-90a8-e4646849c45d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnBoundaryEventData) data).mAttachedToRef;
        }

        @objid ("26ce9826-2ee3-4654-acf0-c15153686187")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnBoundaryEventData) data).mAttachedToRef = value;
        }

        @objid ("bdce0122-1134-447f-8b20-71fd663c0628")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getBoundaryEventRefDep();
            }
            return this.symetricDep;

        }

    }

}
