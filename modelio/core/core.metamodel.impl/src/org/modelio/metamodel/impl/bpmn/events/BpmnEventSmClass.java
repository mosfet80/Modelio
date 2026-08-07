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
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b176ad0b-b65b-4dd5-9dad-1af827c191b1")
public class BpmnEventSmClass extends BpmnFlowNodeSmClass {
    @objid ("eae9bc12-84c9-4b97-b3f1-36f5e5387039")
    private SmDependency eventDefinitionsDep;

    @objid ("b46f950f-5d82-4b98-b622-14abc670297c")
    public BpmnEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d0d41910-4ff9-465d-84bf-db3888f7f116")
    @Override
    public String getName() {
        return "BpmnEvent";

    }

    @objid ("37586ffb-b8f6-419b-9fff-7c9d855a4939")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("38064e92-2977-403e-97e4-834a73401f61")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEvent.class;

    }

    @objid ("5b049838-244d-4584-9fd5-5f0491e104fd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c4ea5e91-9bb4-4760-a5cb-9b99ee22d3c3")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("c5ffe10b-13c4-4fe6-b3ed-02bfcdf0602c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowNode.MQNAME);
        this.registerFactory(new BpmnEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.eventDefinitionsDep = new EventDefinitionsSmDependency();
        this.eventDefinitionsDep.init("EventDefinitions", this, metamodel.getMClass(BpmnEventDefinition.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.eventDefinitionsDep);

    }

    @objid ("140d83f1-aee3-4a1b-9940-a8690cd6ad5f")
    public SmDependency getEventDefinitionsDep() {
        if (this.eventDefinitionsDep == null) {
        	this.eventDefinitionsDep = this.getDependencyDef("EventDefinitions");
        }
        return this.eventDefinitionsDep;
    }

    @objid ("0f092c62-798b-483b-b633-71830ca058cb")
    private static class BpmnEventObjectFactory implements ISmObjectFactory {
        @objid ("eae9712c-b18c-4868-9a6a-4813be3074be")
        private BpmnEventSmClass smClass;

        @objid ("8c64009c-4a02-4bbe-b69f-a17b135d66b6")
        public BpmnEventObjectFactory(BpmnEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3764948f-f724-41ad-a505-bfad093411c6")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("1c4ecafb-d5a9-4171-a979-d57470dbd2a6")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("e88e2a7d-7395-4308-ad8f-ddbf7a513642")
    public static class EventDefinitionsSmDependency extends SmMultipleDependency {
        @objid ("e95d14a0-ef78-41b7-b454-5fea03eac731")
        private SmDependency symetricDep;

        @objid ("72506e75-4882-4b92-99ea-570b0e55d2d9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnEventData)data).mEventDefinitions != null)? ((BpmnEventData)data).mEventDefinitions:SmMultipleDependency.EMPTY;
        }

        @objid ("b74ef37a-d051-438a-aa73-710939d28ed8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnEventData) data).mEventDefinitions = values;

        }

        @objid ("e475e1dd-ff67-4042-912c-b55cef3b5162")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnEventDefinitionSmClass)this.getTarget()).getDefinedDep();
            }
            return this.symetricDep;

        }

    }

}
