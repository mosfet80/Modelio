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
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnEvent;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnMultiInstanceLoopCharacteristicsSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("38d2f50c-e36d-499e-9001-50707f981eb7")
public class BpmnEventDefinitionSmClass extends BpmnBaseElementSmClass {
    @objid ("be68abc4-3e3c-4168-a7f7-4efcd593948e")
    private SmDependency definedDep;

    @objid ("cd949680-d628-4380-9e8c-97ff50c7de9b")
    private SmDependency loopRefDep;

    @objid ("282e7574-60d1-424b-9805-e16634965083")
    public BpmnEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0cd03786-3fec-4747-b4ff-41edde579448")
    @Override
    public String getName() {
        return "BpmnEventDefinition";

    }

    @objid ("58656527-87da-4ce8-b586-da866c465e5f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("17723a12-c669-4c60-a540-27b1e1ce16fe")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEventDefinition.class;

    }

    @objid ("9f139049-d7d4-4581-baa9-8716bdffe39e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e1e8e185-714f-47be-ae8c-13a86d382a5b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("ca292703-8397-4409-bd77-253291bc5bc6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.definedDep = new DefinedSmDependency();
        this.definedDep.init("Defined", this, metamodel.getMClass(BpmnEvent.MQNAME), 0, 1 );
        registerDependency(this.definedDep);

        this.loopRefDep = new LoopRefSmDependency();
        this.loopRefDep.init("LoopRef", this, metamodel.getMClass(BpmnMultiInstanceLoopCharacteristics.MQNAME), 0, -1 );
        registerDependency(this.loopRefDep);

    }

    @objid ("85b55098-7096-4411-8033-e5bb606def61")
    public SmDependency getDefinedDep() {
        if (this.definedDep == null) {
        	this.definedDep = this.getDependencyDef("Defined");
        }
        return this.definedDep;
    }

    @objid ("abead6d7-67d5-4d0d-a4b2-c40626b23828")
    public SmDependency getLoopRefDep() {
        if (this.loopRefDep == null) {
        	this.loopRefDep = this.getDependencyDef("LoopRef");
        }
        return this.loopRefDep;
    }

    @objid ("37a1899a-1102-4a93-9c62-eb6241e7cdd5")
    private static class BpmnEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("67e00c22-05a8-4e24-8032-8cebe1f586db")
        private BpmnEventDefinitionSmClass smClass;

        @objid ("3e708e08-b874-4d53-9799-95e46e7cb28d")
        public BpmnEventDefinitionObjectFactory(BpmnEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("adadf300-cc36-45fb-939c-bb38961902ff")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("945b1844-888d-4b07-a944-13cf5d1b2f24")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("266dbfb8-57ed-49c6-b659-a25c34bd1237")
    public static class DefinedSmDependency extends SmSingleDependency {
        @objid ("f117ab1e-3e75-44a3-918c-89b47f40d7d6")
        private SmDependency symetricDep;

        @objid ("2c42a509-a553-409a-86b3-906721e17d9c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnEventDefinitionData) data).mDefined;
        }

        @objid ("edccc5f0-e24b-4dac-b604-f41db5493279")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnEventDefinitionData) data).mDefined = value;
        }

        @objid ("e9238547-1b3a-47bc-ab89-03f19e80870d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnEventSmClass)this.getTarget()).getEventDefinitionsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("103eab20-3fa1-4d52-a76a-294832bc74a8")
    public static class LoopRefSmDependency extends SmMultipleDependency {
        @objid ("9513e1ba-5571-4c0f-b154-3283b46db472")
        private SmDependency symetricDep;

        @objid ("82a26a41-715f-4605-9326-e2a086de54b3")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnEventDefinitionData)data).mLoopRef != null)? ((BpmnEventDefinitionData)data).mLoopRef:SmMultipleDependency.EMPTY;
        }

        @objid ("84ca71da-5ca9-4ca2-b04a-1e3374ae85e3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnEventDefinitionData) data).mLoopRef = values;

        }

        @objid ("f9c6a368-1f48-4b82-8b58-5103dbb67935")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMultiInstanceLoopCharacteristicsSmClass)this.getTarget()).getCompletionEventRefDep();
            }
            return this.symetricDep;

        }

    }

}
