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
import org.modelio.metamodel.bpmn.events.BpmnTerminateEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ead508d0-cc97-4e68-9a32-c338b88fa836")
public class BpmnTerminateEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("be1da706-22ed-4247-8ef7-1bdb48b59a76")
    public BpmnTerminateEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0717fc60-0333-4f00-ba68-6ce71d12b1e3")
    @Override
    public String getName() {
        return "BpmnTerminateEventDefinition";

    }

    @objid ("0dd5e0ac-b7f2-4aed-a79e-18405c9d4214")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("134263b2-89a3-4072-b121-ec5fb2115a3f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnTerminateEventDefinition.class;

    }

    @objid ("a6c4c471-ee3a-447c-be2d-e8f1f21716e1")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("969fe748-70dd-4103-b54f-ffa73188a44c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bc1bbf5f-96c5-424d-8292-59e80b2d1436")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnTerminateEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("1b558904-e88e-4390-9daf-870c22e350ee")
    private static class BpmnTerminateEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("fb513d53-f3b2-4eef-be84-8755defeb9fb")
        private BpmnTerminateEventDefinitionSmClass smClass;

        @objid ("ed048b16-b228-453d-b3e3-dad03860ff01")
        public BpmnTerminateEventDefinitionObjectFactory(BpmnTerminateEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5fe30390-87b9-400b-ac4a-41ac0bb29c3b")
        @Override
        public ISmObjectData createData() {
            return new BpmnTerminateEventDefinitionData(this.smClass);
        }

        @objid ("1239a686-e51f-4a61-b22b-ff00ec87534f")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnTerminateEventDefinitionImpl();
        }

    }

}
