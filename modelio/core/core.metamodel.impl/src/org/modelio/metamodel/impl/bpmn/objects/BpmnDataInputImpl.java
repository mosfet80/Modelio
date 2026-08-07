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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00068a7e-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataInputImpl extends BpmnItemAwareElementImpl implements BpmnDataInput {
    @objid ("7eb69652-9c43-4846-96f1-fdb6f93d3a67")
    @Override
    public boolean isIsCollection() {
        return (Boolean) getAttVal(((BpmnDataInputSmClass)getClassOf()).getIsCollectionAtt());
    }

    @objid ("6d2e9e91-d304-4d52-9505-b1dab736b433")
    @Override
    public void setIsCollection(boolean value) {
        setAttVal(((BpmnDataInputSmClass)getClassOf()).getIsCollectionAtt(), value);
    }

    @objid ("d867d795-f262-435c-9215-c6895645b11a")
    @Override
    public BpmnMultiInstanceLoopCharacteristics getOwnerLoopCharacteristics() {
        Object obj = getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep());
        return (obj instanceof BpmnMultiInstanceLoopCharacteristics)? (BpmnMultiInstanceLoopCharacteristics)obj : null;
    }

    @objid ("acc50441-0a5e-4754-88e0-295ac9cca6fd")
    @Override
    public void setOwnerLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics value) {
        appendDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep(), (SmObjectImpl)value);
    }

    @objid ("3d2f9d8c-eeb4-458c-beb5-7f8b3556aade")
    @Override
    public BpmnActivity getOwnerActivity() {
        Object obj = getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerActivityDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("3388c101-cb86-4b09-a9a2-034a2f8076c7")
    @Override
    public void setOwnerActivity(BpmnActivity value) {
        appendDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerActivityDep(), (SmObjectImpl)value);
    }

    @objid ("312b5071-1962-47fa-b818-042cdc0f51c2")
    @Override
    public BpmnThrowEvent getOwnerThrowEvent() {
        Object obj = getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerThrowEventDep());
        return (obj instanceof BpmnThrowEvent)? (BpmnThrowEvent)obj : null;
    }

    @objid ("f43eedda-c953-49c6-b655-11f12c34d919")
    @Override
    public void setOwnerThrowEvent(BpmnThrowEvent value) {
        appendDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerThrowEventDep(), (SmObjectImpl)value);
    }

    @objid ("20c8e0e9-3807-4dde-b3fd-891e8dda07d7")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerLoopCharacteristics
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep());
        if (obj != null)
          return obj;
        // OwnerActivity
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerActivityDep());
        if (obj != null)
          return obj;
        // OwnerThrowEvent
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataInputSmClass)getClassOf()).getOwnerThrowEventDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("0480eeea-472d-4343-96cc-665dea9e3c9c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerLoopCharacteristics
        dep = ((BpmnDataInputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerActivity
        dep = ((BpmnDataInputSmClass)getClassOf()).getOwnerActivityDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerThrowEvent
        dep = ((BpmnDataInputSmClass)getClassOf()).getOwnerThrowEventDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("6bc7e9d8-8596-4023-a0f0-980006bd64f3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataInput(this);
    }

}
