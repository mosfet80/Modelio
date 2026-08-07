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
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.MultiInstanceBehavior;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00811ea6-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMultiInstanceLoopCharacteristicsImpl extends BpmnLoopCharacteristicsImpl implements BpmnMultiInstanceLoopCharacteristics {
    @objid ("aabd75b4-6b38-4734-92c3-b0277d1e9c3c")
    @Override
    public boolean isIsSequencial() {
        return (Boolean) getAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getIsSequencialAtt());
    }

    @objid ("3013f30b-b511-4b9f-b7c5-712cb76b120c")
    @Override
    public void setIsSequencial(boolean value) {
        setAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getIsSequencialAtt(), value);
    }

    @objid ("57a165cf-d09d-4f41-ae6a-674c9c7e99da")
    @Override
    public MultiInstanceBehavior getBehavior() {
        return (MultiInstanceBehavior) getAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getBehaviorAtt());
    }

    @objid ("68db4a5c-5ac7-41a1-affc-6795dabd9b88")
    @Override
    public void setBehavior(MultiInstanceBehavior value) {
        setAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getBehaviorAtt(), value);
    }

    @objid ("3d369531-5783-4f79-8d65-7d034f895fc2")
    @Override
    public String getLoopCardinality() {
        return (String) getAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopCardinalityAtt());
    }

    @objid ("1bb56f9c-8b05-4654-b7b1-1f08e1d5c284")
    @Override
    public void setLoopCardinality(String value) {
        setAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopCardinalityAtt(), value);
    }

    @objid ("1825eeca-82c2-4173-9f08-7baf6e8916f7")
    @Override
    public String getCompletionCondition() {
        return (String) getAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getCompletionConditionAtt());
    }

    @objid ("4107e841-dab6-4c01-800f-e16a8bf5191b")
    @Override
    public void setCompletionCondition(String value) {
        setAttVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getCompletionConditionAtt(), value);
    }

    @objid ("05f55909-ab37-4321-947c-e2f736852fed")
    @Override
    public BpmnDataInput getLoopDataInput() {
        Object obj = getDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopDataInputDep());
        return (obj instanceof BpmnDataInput)? (BpmnDataInput)obj : null;
    }

    @objid ("c34829ad-4ed0-43c2-9cc9-3ec5ab1cd1ca")
    @Override
    public void setLoopDataInput(BpmnDataInput value) {
        appendDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopDataInputDep(), (SmObjectImpl)value);
    }

    @objid ("03fb4cde-7589-4e04-8071-13ef88a402e5")
    @Override
    public BpmnDataOutput getLoopDataOutputRef() {
        Object obj = getDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopDataOutputRefDep());
        return (obj instanceof BpmnDataOutput)? (BpmnDataOutput)obj : null;
    }

    @objid ("a12618d1-40d6-465b-a38e-6e0be8a9ec12")
    @Override
    public void setLoopDataOutputRef(BpmnDataOutput value) {
        appendDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getLoopDataOutputRefDep(), (SmObjectImpl)value);
    }

    @objid ("c29ddac3-19df-4880-a7d2-1e886b37f9a0")
    @Override
    public BpmnEventDefinition getCompletionEventRef() {
        Object obj = getDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getCompletionEventRefDep());
        return (obj instanceof BpmnEventDefinition)? (BpmnEventDefinition)obj : null;
    }

    @objid ("3f1de9b4-7e27-4313-9491-aa61ce6a562f")
    @Override
    public void setCompletionEventRef(BpmnEventDefinition value) {
        appendDepVal(((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getCompletionEventRefDep(), (SmObjectImpl)value);
    }

    @objid ("90a07f34-1d9c-4978-a1c0-b8dbcc2b4e02")
    @Override
    public EList<BpmnComplexBehaviorDefinition> getComplexBehaviorDefinition() {
        return new SmList<>(this, ((BpmnMultiInstanceLoopCharacteristicsSmClass)getClassOf()).getComplexBehaviorDefinitionDep());
    }

    @objid ("d89816c3-875e-4fb1-b705-55ce2642f092")
    @Override
    public <T extends BpmnComplexBehaviorDefinition> List<T> getComplexBehaviorDefinition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnComplexBehaviorDefinition element : getComplexBehaviorDefinition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c6f62bde-a803-400e-8907-3259b9c69e69")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("681a2aae-2cee-4d7b-a922-0dceeb84fe54")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("6af2fbd5-eaa6-4f06-a02e-915e47be6222")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnMultiInstanceLoopCharacteristics(this);
    }

}
