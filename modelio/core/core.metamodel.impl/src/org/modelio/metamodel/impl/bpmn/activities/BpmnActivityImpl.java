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
/*
 * Copyright 2013-2024 Docaposte
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
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007d9466-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnActivityImpl extends BpmnFlowNodeImpl implements BpmnActivity {
    @objid ("423bc2f7-b470-4641-9cb5-1774a387e465")
    @Override
    public boolean isIsForCompensation() {
        return (Boolean) getAttVal(((BpmnActivitySmClass)getClassOf()).getIsForCompensationAtt());
    }

    @objid ("076a198f-3131-44a0-a472-feac5982b6bf")
    @Override
    public void setIsForCompensation(boolean value) {
        setAttVal(((BpmnActivitySmClass)getClassOf()).getIsForCompensationAtt(), value);
    }

    @objid ("91255dd9-c75d-41b1-841d-15361761ef17")
    @Override
    public int getStartQuantity() {
        return (Integer) getAttVal(((BpmnActivitySmClass)getClassOf()).getStartQuantityAtt());
    }

    @objid ("c610eada-ae26-443a-8565-5ad5545bb5f9")
    @Override
    public void setStartQuantity(int value) {
        setAttVal(((BpmnActivitySmClass)getClassOf()).getStartQuantityAtt(), value);
    }

    @objid ("3bfc1dc2-7447-4da6-8018-561a88a7a022")
    @Override
    public int getCompletionQuantity() {
        return (Integer) getAttVal(((BpmnActivitySmClass)getClassOf()).getCompletionQuantityAtt());
    }

    @objid ("091ca6fb-7882-412a-b43c-d13d43c8e3c9")
    @Override
    public void setCompletionQuantity(int value) {
        setAttVal(((BpmnActivitySmClass)getClassOf()).getCompletionQuantityAtt(), value);
    }

    @objid ("101535b7-6711-49b2-b9ba-2fbc8fdab542")
    @Override
    public EList<BpmnCompensateEventDefinition> getCompensateEventDefinitions() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getCompensateEventDefinitionsDep());
    }

    @objid ("58efa94f-0eae-428c-b1e8-3980d7b8f2fa")
    @Override
    public <T extends BpmnCompensateEventDefinition> List<T> getCompensateEventDefinitions(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnCompensateEventDefinition element : getCompensateEventDefinitions()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("896252b0-facf-49d1-8c54-55ed209e6108")
    @Override
    public EList<BpmnDataInput> getInputSpecification() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getInputSpecificationDep());
    }

    @objid ("81a6dadf-d93a-46c5-9933-057594c58a17")
    @Override
    public <T extends BpmnDataInput> List<T> getInputSpecification(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataInput element : getInputSpecification()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("ad3281d4-6046-4860-92e1-0ed65b2f2f5c")
    @Override
    public EList<BpmnDataAssociation> getDataInputAssociation() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getDataInputAssociationDep());
    }

    @objid ("2b6f67e9-61ea-4658-83c1-515f53c6a000")
    @Override
    public <T extends BpmnDataAssociation> List<T> getDataInputAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getDataInputAssociation()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("a70f69c4-16fc-4fcb-959e-6d95a1fc4173")
    @Override
    public EList<BpmnDataOutput> getOutputSpecification() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getOutputSpecificationDep());
    }

    @objid ("04958e0c-c072-4566-9ce1-958436362d49")
    @Override
    public <T extends BpmnDataOutput> List<T> getOutputSpecification(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataOutput element : getOutputSpecification()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("cf89942e-b83b-4898-ae1c-1ecffc09dff3")
    @Override
    public BpmnLoopCharacteristics getLoopCharacteristics() {
        Object obj = getDepVal(((BpmnActivitySmClass)getClassOf()).getLoopCharacteristicsDep());
        return (obj instanceof BpmnLoopCharacteristics)? (BpmnLoopCharacteristics)obj : null;
    }

    @objid ("4e92790d-6524-40ab-a293-2a5ee084dfb6")
    @Override
    public void setLoopCharacteristics(BpmnLoopCharacteristics value) {
        appendDepVal(((BpmnActivitySmClass)getClassOf()).getLoopCharacteristicsDep(), (SmObjectImpl)value);
    }

    @objid ("55bc7146-e197-439c-807f-6abc3b419c64")
    @Override
    public EList<BpmnBoundaryEvent> getBoundaryEventRef() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getBoundaryEventRefDep());
    }

    @objid ("e7e968d3-48e6-4351-9f5d-c841898efe04")
    @Override
    public <T extends BpmnBoundaryEvent> List<T> getBoundaryEventRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnBoundaryEvent element : getBoundaryEventRef()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("0159fecb-3861-4b46-b2b9-e28f7c4adf12")
    @Override
    public EList<BpmnDataAssociation> getDataOutputAssociation() {
        return new SmList<>(this, ((BpmnActivitySmClass)getClassOf()).getDataOutputAssociationDep());
    }

    @objid ("391b125a-cbb8-442b-88d7-aecee208d826")
    @Override
    public <T extends BpmnDataAssociation> List<T> getDataOutputAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getDataOutputAssociation()) {
            if (filterClass.isInstance(element)) {
                results.add(filterClass.cast(element));
            }
        }
        return Collections.unmodifiableList(results);
    }

    @objid ("47ab11dd-1ae2-4de0-b678-bb51e32a297e")
    @Override
    public BpmnSequenceFlow getDefaultFlow() {
        Object obj = getDepVal(((BpmnActivitySmClass)getClassOf()).getDefaultFlowDep());
        return (obj instanceof BpmnSequenceFlow)? (BpmnSequenceFlow)obj : null;
    }

    @objid ("ae934e70-1d36-48af-8197-0189dbf360bd")
    @Override
    public void setDefaultFlow(BpmnSequenceFlow value) {
        appendDepVal(((BpmnActivitySmClass)getClassOf()).getDefaultFlowDep(), (SmObjectImpl)value);
    }

    @objid ("3fa852a7-92d9-417b-9d74-31b4555fc12b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("7df59ed9-27c8-454b-abba-37fb4abe2259")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("66f2abfc-8fe1-41a4-b80b-a4646820afe3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnActivity(this);
    }

}
