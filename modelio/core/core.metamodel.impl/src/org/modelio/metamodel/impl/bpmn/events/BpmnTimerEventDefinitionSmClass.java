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
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnTimerEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c3a0ab51-036c-4b61-a9f8-2990d9c1f220")
public class BpmnTimerEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("c4fdf6f4-73e4-4dbb-93bc-e4b62e3c0e99")
    private SmAttribute timeCycleAtt;

    @objid ("f7e65f7f-3bdc-4093-bee7-3e215e36d567")
    private SmAttribute timeDateAtt;

    @objid ("4d551f1a-9cb8-4086-9bae-722a78b266aa")
    private SmAttribute timeDurationAtt;

    @objid ("d8788887-f6a4-441a-85d7-84a9e0910d2e")
    public BpmnTimerEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3d67680a-4e4c-486c-9fdf-29ec836598c1")
    @Override
    public String getName() {
        return "BpmnTimerEventDefinition";

    }

    @objid ("846da5ee-abef-4cdb-bdf7-dddabe972013")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("782d1ffe-178b-4ed6-8b9b-5599ba52d575")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnTimerEventDefinition.class;

    }

    @objid ("7ee0e392-813e-4459-9011-65544656126e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("43e86796-67f7-42dc-ab3b-aa82a47699df")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("45323079-e354-4537-990b-13291f0d790d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnTimerEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.timeCycleAtt = new TimeCycleSmAttribute();
        this.timeCycleAtt.init("TimeCycle", this, String.class );
        registerAttribute(this.timeCycleAtt);

        this.timeDateAtt = new TimeDateSmAttribute();
        this.timeDateAtt.init("TimeDate", this, String.class );
        registerAttribute(this.timeDateAtt);

        this.timeDurationAtt = new TimeDurationSmAttribute();
        this.timeDurationAtt.init("TimeDuration", this, String.class );
        registerAttribute(this.timeDurationAtt);


        // Initialize and register the SmDependency

    }

    @objid ("d0ab0c03-ca4d-4c8f-84a7-9cffa6ff4b72")
    public SmAttribute getTimeCycleAtt() {
        if (this.timeCycleAtt == null) {
        	this.timeCycleAtt = this.getAttributeDef("TimeCycle");
        }
        return this.timeCycleAtt;
    }

    @objid ("5ce30e68-20bd-4abe-8c8e-fde84e392b33")
    public SmAttribute getTimeDateAtt() {
        if (this.timeDateAtt == null) {
        	this.timeDateAtt = this.getAttributeDef("TimeDate");
        }
        return this.timeDateAtt;
    }

    @objid ("d6675fba-7166-4c64-97b8-bfc684e70410")
    public SmAttribute getTimeDurationAtt() {
        if (this.timeDurationAtt == null) {
        	this.timeDurationAtt = this.getAttributeDef("TimeDuration");
        }
        return this.timeDurationAtt;
    }

    @objid ("a1fb3ac6-1319-4d5e-920b-abeb2a2f644f")
    private static class BpmnTimerEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("2b540a22-a2c4-45ff-aeab-e3ff154a2b4c")
        private BpmnTimerEventDefinitionSmClass smClass;

        @objid ("3c7a9e2e-a3d2-43b0-9e51-00bc0a9f5848")
        public BpmnTimerEventDefinitionObjectFactory(BpmnTimerEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a0c29b55-4bfa-40fd-91e6-23f3d69cbe64")
        @Override
        public ISmObjectData createData() {
            return new BpmnTimerEventDefinitionData(this.smClass);
        }

        @objid ("56c2ab49-05da-4b9c-98fb-bdf36f4f0325")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnTimerEventDefinitionImpl();
        }

    }

    @objid ("a7537914-9683-4247-9b3f-c5c07c9bbf67")
    public static class TimeCycleSmAttribute extends SmAttribute {
        @objid ("df7ca3a7-126b-4cfb-a4b8-a863cd5acca5")
        public Object getValue(ISmObjectData data) {
            return ((BpmnTimerEventDefinitionData) data).mTimeCycle;
        }

        @objid ("0fa3fee2-07c2-45ff-bd4e-365502e89745")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnTimerEventDefinitionData) data).mTimeCycle = value;
        }

    }

    @objid ("ba8c1482-7e0b-4f1e-8873-77b2ddcd3e60")
    public static class TimeDateSmAttribute extends SmAttribute {
        @objid ("08b64de0-4605-4357-8401-1fe86ebce741")
        public Object getValue(ISmObjectData data) {
            return ((BpmnTimerEventDefinitionData) data).mTimeDate;
        }

        @objid ("e9c199e8-cd87-4588-bcba-4d83019739fa")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnTimerEventDefinitionData) data).mTimeDate = value;
        }

    }

    @objid ("b7e1eb08-8c76-4806-a27b-f129b77ea194")
    public static class TimeDurationSmAttribute extends SmAttribute {
        @objid ("e3ae073c-da30-49da-9457-a19649e281de")
        public Object getValue(ISmObjectData data) {
            return ((BpmnTimerEventDefinitionData) data).mTimeDuration;
        }

        @objid ("25471710-bc3a-4b7b-b74c-3d9a1a42a3fa")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnTimerEventDefinitionData) data).mTimeDuration = value;
        }

    }

}
