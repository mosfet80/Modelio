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
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008790d8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnBoundaryEventImpl extends BpmnCatchEventImpl implements BpmnBoundaryEvent {
    @objid ("cce5cc04-884d-4367-9f2e-4284294e80a9")
    @Override
    public boolean isCancelActivity() {
        return (Boolean) getAttVal(((BpmnBoundaryEventSmClass)getClassOf()).getCancelActivityAtt());
    }

    @objid ("8edfaf20-3681-4fe0-8f5d-4f2cb1a04de8")
    @Override
    public void setCancelActivity(boolean value) {
        setAttVal(((BpmnBoundaryEventSmClass)getClassOf()).getCancelActivityAtt(), value);
    }

    @objid ("b01c0f84-59db-44a0-9f52-14f189dae09b")
    @Override
    public BpmnActivity getAttachedToRef() {
        Object obj = getDepVal(((BpmnBoundaryEventSmClass)getClassOf()).getAttachedToRefDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("2618f8c5-baa6-4443-bfad-53ad2fe82f62")
    @Override
    public void setAttachedToRef(BpmnActivity value) {
        appendDepVal(((BpmnBoundaryEventSmClass)getClassOf()).getAttachedToRefDep(), (SmObjectImpl)value);
    }

    @objid ("5410770e-08eb-4dd0-b568-f3f1edf88ce8")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("cffc971f-98d2-4f6b-b153-589930a3d3ee")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("665cb33d-6fca-411d-94f4-fb15245a308a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnBoundaryEvent(this);
    }

}
