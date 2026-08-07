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
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnGatewayDirection;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b7157dbd-377c-40c8-8473-97ad79ef088f")
public class BpmnGatewaySmClass extends BpmnFlowNodeSmClass {
    @objid ("e51d17f1-e4d7-4bed-8f65-cebdb3d5df01")
    private SmAttribute gatewayDirectionAtt;

    @objid ("2a20e33e-8646-45ae-88ae-22543fb69051")
    public BpmnGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1aaafae4-01f4-4447-afc0-58175bd91879")
    @Override
    public String getName() {
        return "BpmnGateway";

    }

    @objid ("c22590ce-9716-419c-95d1-f187526dbe52")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("cf3b5972-2d3d-4e27-96d1-e060a28dc7a4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnGateway.class;

    }

    @objid ("375414f0-2371-4f65-aa76-bf244baa2970")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("129e981c-c527-478f-a8e4-1ed7e7cdf3c5")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("726d4e1f-326b-44ea-9f13-b83f64473d11")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowNode.MQNAME);
        this.registerFactory(new BpmnGatewayObjectFactory(this));


        // Initialize and register the SmAttribute
        this.gatewayDirectionAtt = new GatewayDirectionSmAttribute();
        this.gatewayDirectionAtt.init("GatewayDirection", this, BpmnGatewayDirection.class );
        registerAttribute(this.gatewayDirectionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("a3980a76-a7e9-4b13-a136-18adbda84b35")
    public SmAttribute getGatewayDirectionAtt() {
        if (this.gatewayDirectionAtt == null) {
        	this.gatewayDirectionAtt = this.getAttributeDef("GatewayDirection");
        }
        return this.gatewayDirectionAtt;
    }

    @objid ("eedd07aa-057b-4272-9bb8-e011f7d04534")
    private static class BpmnGatewayObjectFactory implements ISmObjectFactory {
        @objid ("7032d8d4-e6cc-4f6a-a874-ffcdd7fb44c6")
        private BpmnGatewaySmClass smClass;

        @objid ("6e180818-c669-462c-8252-e02e77f5128f")
        public BpmnGatewayObjectFactory(BpmnGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("41501040-9c5f-4b90-95a4-833051db13d4")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("0eda4a61-a154-4219-b787-b948e2e192fb")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("bd15ebda-c1ed-4eb1-8bc6-a6c4a9f20043")
    public static class GatewayDirectionSmAttribute extends SmAttribute {
        @objid ("2d8cf591-4d20-45db-8f6f-93e168a24473")
        public Object getValue(ISmObjectData data) {
            return ((BpmnGatewayData) data).mGatewayDirection;
        }

        @objid ("6d1aa830-1f30-472e-a8b8-a370965e0b89")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnGatewayData) data).mGatewayDirection = value;
        }

    }

}
