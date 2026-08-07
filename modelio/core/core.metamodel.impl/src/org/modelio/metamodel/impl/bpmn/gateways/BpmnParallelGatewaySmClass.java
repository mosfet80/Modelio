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
import org.modelio.metamodel.bpmn.gateways.BpmnParallelGateway;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("231f222a-7f41-42fd-bde0-c4ecba43f073")
public class BpmnParallelGatewaySmClass extends BpmnGatewaySmClass {
    @objid ("a5e7a95d-ba4d-47e7-8103-c6e72b95ff73")
    public BpmnParallelGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("080c3ca2-ea8e-496c-aef5-1ff0f24d0a9f")
    @Override
    public String getName() {
        return "BpmnParallelGateway";

    }

    @objid ("411aa9db-332d-4616-a168-fdbcd0b4464c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d98ac5e6-438c-4027-81cd-346731a57fdc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnParallelGateway.class;

    }

    @objid ("3d45753d-ea1d-457f-8309-9a9139989cd7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("72b90bde-b65f-48c4-a913-338d77da37e5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d670fe12-1793-4440-b070-a84c7568c259")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnGateway.MQNAME);
        this.registerFactory(new BpmnParallelGatewayObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f8a4ef36-b9a1-4885-9e29-58a6d04439e8")
    private static class BpmnParallelGatewayObjectFactory implements ISmObjectFactory {
        @objid ("2be79b4d-af9c-4f9f-9d77-752047c06977")
        private BpmnParallelGatewaySmClass smClass;

        @objid ("68c5b2b5-6e16-4629-95ee-9a9953610294")
        public BpmnParallelGatewayObjectFactory(BpmnParallelGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2706257f-5d26-4e1a-98cb-89d7802ac758")
        @Override
        public ISmObjectData createData() {
            return new BpmnParallelGatewayData(this.smClass);
        }

        @objid ("cc995bde-2e06-4728-ba97-c03fe74ed471")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnParallelGatewayImpl();
        }

    }

}
