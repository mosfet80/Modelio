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
import org.modelio.metamodel.bpmn.events.BpmnSignalEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b0b2b22d-8502-406a-abb3-042ce2c07a78")
public class BpmnSignalEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("d92ab254-e8ac-4256-875b-c80f903223f7")
    public BpmnSignalEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8bdb4f02-9c7b-4808-8ef7-5f5eee5c515b")
    @Override
    public String getName() {
        return "BpmnSignalEventDefinition";

    }

    @objid ("2c20f1eb-55a5-45d7-87ac-8c7d75140841")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("7a8c758a-4f90-44f0-a343-86bdcfcae40f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSignalEventDefinition.class;

    }

    @objid ("aa0341f9-3144-44e9-acad-87f01e858533")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5377e598-1893-43ab-846b-a6e767a8d9a7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b11171af-abed-45df-9f64-5af5295fc3f7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnSignalEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("b760a66e-0264-4a69-a21b-d5788f72cd16")
    private static class BpmnSignalEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("b0dbd450-8a9c-4479-bf0f-5a586c33d8a0")
        private BpmnSignalEventDefinitionSmClass smClass;

        @objid ("efa18af0-11ee-42e4-8d22-e65687c5552f")
        public BpmnSignalEventDefinitionObjectFactory(BpmnSignalEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b4e0bc41-4b26-4baf-abf7-cce4f56eae01")
        @Override
        public ISmObjectData createData() {
            return new BpmnSignalEventDefinitionData(this.smClass);
        }

        @objid ("2f72603b-2c88-4b7c-b33d-a9a97fe9e455")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSignalEventDefinitionImpl();
        }

    }

}
