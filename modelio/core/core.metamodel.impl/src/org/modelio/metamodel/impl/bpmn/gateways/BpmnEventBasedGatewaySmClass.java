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
package org.modelio.metamodel.impl.bpmn.gateways;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGatewayType;
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("e3c20f17-aba5-4406-9d83-4e9524117765")
public class BpmnEventBasedGatewaySmClass extends BpmnGatewaySmClass {
    @objid ("75f7c41f-1c82-46e9-a06c-dbd2e4a8c8cf")
    private SmAttribute instanciateAtt;

    @objid ("87fde1e5-1de6-4a94-9469-46d9245706e1")
    private SmAttribute eventGatewayTypeAtt;

    @objid ("a2739c19-0b69-44df-abb6-07b26f827ae5")
    public BpmnEventBasedGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5dba6ff6-513e-40b4-b1e9-d5954ccd5a3b")
    @Override
    public String getName() {
        return "BpmnEventBasedGateway";

    }

    @objid ("7f24dae9-dbe0-495a-96cf-16dbc00346b0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e143150a-6c31-4f00-8b76-5af1ba16749a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEventBasedGateway.class;

    }

    @objid ("395d9775-7a13-4290-b2f8-6a1f2b51b000")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("bbfcd7e1-f73a-4f18-b8b6-c707df45b1f6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("82fbd2a5-ac60-438c-9ff7-a9b452c48a05")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnGateway.MQNAME);
        this.registerFactory(new BpmnEventBasedGatewayObjectFactory(this));


        // Initialize and register the SmAttribute
        this.instanciateAtt = new InstanciateSmAttribute();
        this.instanciateAtt.init("Instanciate", this, Boolean.class );
        registerAttribute(this.instanciateAtt);

        this.eventGatewayTypeAtt = new EventGatewayTypeSmAttribute();
        this.eventGatewayTypeAtt.init("EventGatewayType", this, BpmnEventBasedGatewayType.class );
        registerAttribute(this.eventGatewayTypeAtt);


        // Initialize and register the SmDependency

    }

    @objid ("bdbedfeb-0029-4a5f-b9f8-50bac4e2efad")
    public SmAttribute getInstanciateAtt() {
        if (this.instanciateAtt == null) {
        	this.instanciateAtt = this.getAttributeDef("Instanciate");
        }
        return this.instanciateAtt;
    }

    @objid ("cd893f92-c321-4ecb-ad4f-3fbc823bf08a")
    public SmAttribute getEventGatewayTypeAtt() {
        if (this.eventGatewayTypeAtt == null) {
        	this.eventGatewayTypeAtt = this.getAttributeDef("EventGatewayType");
        }
        return this.eventGatewayTypeAtt;
    }

    @objid ("c85973b3-96cf-4ee3-b78a-30263399787a")
    private static class BpmnEventBasedGatewayObjectFactory implements ISmObjectFactory {
        @objid ("5fc2f3b0-c2e9-486b-a081-05bce4dbc774")
        private BpmnEventBasedGatewaySmClass smClass;

        @objid ("0c98ae54-c6e5-4f3d-b91a-0f8f46ba4e3d")
        public BpmnEventBasedGatewayObjectFactory(BpmnEventBasedGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e3ee55d4-bb35-48fa-96cc-e856d447c255")
        @Override
        public ISmObjectData createData() {
            return new BpmnEventBasedGatewayData(this.smClass);
        }

        @objid ("77c97625-e5f1-4048-8f3e-a0b5d0b11261")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnEventBasedGatewayImpl();
        }

    }

    @objid ("8ce6ef65-fe16-4086-a9a5-6c0cd407ca19")
    public static class InstanciateSmAttribute extends SmAttribute {
        @objid ("ea00d5f8-dfae-4e56-9ffd-d771cad26791")
        public Object getValue(ISmObjectData data) {
            return ((BpmnEventBasedGatewayData) data).mInstanciate;
        }

        @objid ("93a17248-4371-46f1-8553-2172c31d6c37")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnEventBasedGatewayData) data).mInstanciate = value;
        }

    }

    @objid ("d0334ec8-0ca4-4545-8451-d1d8efec5012")
    public static class EventGatewayTypeSmAttribute extends SmAttribute {
        @objid ("b446451b-3d3f-4a78-be70-a35b4ab04e0f")
        public Object getValue(ISmObjectData data) {
            return ((BpmnEventBasedGatewayData) data).mEventGatewayType;
        }

        @objid ("20585704-0d6a-48c9-946c-1661f92a3e86")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnEventBasedGatewayData) data).mEventGatewayType = value;
        }

    }

}
