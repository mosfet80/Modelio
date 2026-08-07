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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0095d2e2-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnThrowEventImpl extends BpmnEventImpl implements BpmnThrowEvent {
    @objid ("4ea3d1a9-80ad-458a-91b8-844f67eb0809")
    @Override
    public EList<BpmnDataAssociation> getDataInputAssociation() {
        return new SmList<>(this, ((BpmnThrowEventSmClass)getClassOf()).getDataInputAssociationDep());
    }

    @objid ("a8f34443-9984-458b-ae9e-63c3777be1bb")
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

    @objid ("6963b0be-8cda-465b-9dfc-052475e09a01")
    @Override
    public BpmnDataInput getDataInput() {
        Object obj = getDepVal(((BpmnThrowEventSmClass)getClassOf()).getDataInputDep());
        return (obj instanceof BpmnDataInput)? (BpmnDataInput)obj : null;
    }

    @objid ("df0b138d-25a9-4e4b-bd2b-34fb3a7b3c4f")
    @Override
    public void setDataInput(BpmnDataInput value) {
        appendDepVal(((BpmnThrowEventSmClass)getClassOf()).getDataInputDep(), (SmObjectImpl)value);
    }

    @objid ("38893217-23dd-42fb-8109-7c0c792c593a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("821ee5b1-c3fd-409f-821a-a05016dc5ff4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("1f2c5a80-63b8-4a13-b760-b8254a445bcc")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnThrowEvent(this);
    }

}
