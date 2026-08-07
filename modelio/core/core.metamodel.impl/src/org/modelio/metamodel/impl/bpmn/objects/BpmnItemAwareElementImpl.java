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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataState;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00072ee8-c4c0-1fd8-97fe-001ec947cd2a")
public abstract class BpmnItemAwareElementImpl extends BpmnFlowElementImpl implements BpmnItemAwareElement {
    @objid ("77fb47e8-86fc-446b-8b21-ba62498137db")
    @Override
    public EList<BpmnDataAssociation> getTargetOfDataAssociation() {
        return new SmList<>(this, ((BpmnItemAwareElementSmClass)getClassOf()).getTargetOfDataAssociationDep());
    }

    @objid ("bf39f7b3-ac06-4462-ade4-aa1c9bf7fa2e")
    @Override
    public <T extends BpmnDataAssociation> List<T> getTargetOfDataAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getTargetOfDataAssociation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("738a608c-f855-414d-b3fd-c5350fd38467")
    @Override
    public BpmnItemDefinition getItemSubjectRef() {
        Object obj = getDepVal(((BpmnItemAwareElementSmClass)getClassOf()).getItemSubjectRefDep());
        return (obj instanceof BpmnItemDefinition)? (BpmnItemDefinition)obj : null;
    }

    @objid ("983a3377-6df8-4a7f-a92a-43c16a13f32f")
    @Override
    public void setItemSubjectRef(BpmnItemDefinition value) {
        appendDepVal(((BpmnItemAwareElementSmClass)getClassOf()).getItemSubjectRefDep(), (SmObjectImpl)value);
    }

    @objid ("0b1cb1fa-a309-466f-a270-215c5521ff80")
    @Override
    public BpmnDataState getDataState() {
        Object obj = getDepVal(((BpmnItemAwareElementSmClass)getClassOf()).getDataStateDep());
        return (obj instanceof BpmnDataState)? (BpmnDataState)obj : null;
    }

    @objid ("b0df8049-10a6-4048-82c4-a4a9f161720e")
    @Override
    public void setDataState(BpmnDataState value) {
        appendDepVal(((BpmnItemAwareElementSmClass)getClassOf()).getDataStateDep(), (SmObjectImpl)value);
    }

    @objid ("a7443f4a-6747-45f2-86ae-207145ee6795")
    @Override
    public EList<BpmnDataAssociation> getSourceOfDataAssociation() {
        return new SmList<>(this, ((BpmnItemAwareElementSmClass)getClassOf()).getSourceOfDataAssociationDep());
    }

    @objid ("e0d975c5-b32d-4896-a336-af6d5bb06917")
    @Override
    public <T extends BpmnDataAssociation> List<T> getSourceOfDataAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getSourceOfDataAssociation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("20edbab6-88bb-4009-9dad-746ecfb47d7b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("64ad6e33-1325-4238-8868-5dbfcfee1c31")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("d929d23b-8269-4891-ba96-de5a45453caa")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnItemAwareElement(this);
    }

}
