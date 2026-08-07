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
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0005e9a2-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataOutputImpl extends BpmnItemAwareElementImpl implements BpmnDataOutput {
    @objid ("b8a6c9aa-673d-42db-91c5-a51ada7ece1b")
    @Override
    public boolean isIsCollection() {
        return (Boolean) getAttVal(((BpmnDataOutputSmClass)getClassOf()).getIsCollectionAtt());
    }

    @objid ("e54e2b05-cb07-4e71-82be-bd6b4705c14f")
    @Override
    public void setIsCollection(boolean value) {
        setAttVal(((BpmnDataOutputSmClass)getClassOf()).getIsCollectionAtt(), value);
    }

    @objid ("fb71898c-fdd6-47c8-8125-98835a020715")
    @Override
    public BpmnActivity getOwnerActivity() {
        Object obj = getDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerActivityDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("1c28b6e3-8ed3-413d-b6a4-451346182639")
    @Override
    public void setOwnerActivity(BpmnActivity value) {
        appendDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerActivityDep(), (SmObjectImpl)value);
    }

    @objid ("e01b1f89-7ba6-4b55-a16c-bab0ce43c80d")
    @Override
    public BpmnCatchEvent getCatched() {
        Object obj = getDepVal(((BpmnDataOutputSmClass)getClassOf()).getCatchedDep());
        return (obj instanceof BpmnCatchEvent)? (BpmnCatchEvent)obj : null;
    }

    @objid ("7f9bcbd9-40ef-4701-8224-07aa5d693abb")
    @Override
    public void setCatched(BpmnCatchEvent value) {
        appendDepVal(((BpmnDataOutputSmClass)getClassOf()).getCatchedDep(), (SmObjectImpl)value);
    }

    @objid ("7442f3f0-983a-46eb-94c5-61934fcdb319")
    @Override
    public BpmnMultiInstanceLoopCharacteristics getOwnerLoopCharacteristics() {
        Object obj = getDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep());
        return (obj instanceof BpmnMultiInstanceLoopCharacteristics)? (BpmnMultiInstanceLoopCharacteristics)obj : null;
    }

    @objid ("999cb4a1-c063-4895-b78c-d1e7345630f3")
    @Override
    public void setOwnerLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics value) {
        appendDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep(), (SmObjectImpl)value);
    }

    @objid ("e20ec80d-5ed2-4eec-9a22-b2bbb6e075f7")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerActivity
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerActivityDep());
        if (obj != null)
          return obj;
        // Catched
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataOutputSmClass)getClassOf()).getCatchedDep());
        if (obj != null)
          return obj;
        // OwnerLoopCharacteristics
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataOutputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("8335be20-227a-4e5c-8199-38de3e00c4e9")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerActivity
        dep = ((BpmnDataOutputSmClass)getClassOf()).getOwnerActivityDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Catched
        dep = ((BpmnDataOutputSmClass)getClassOf()).getCatchedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerLoopCharacteristics
        dep = ((BpmnDataOutputSmClass)getClassOf()).getOwnerLoopCharacteristicsDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("cf796595-bbd0-4457-96d4-09e97322b3d5")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataOutput(this);
    }

}
