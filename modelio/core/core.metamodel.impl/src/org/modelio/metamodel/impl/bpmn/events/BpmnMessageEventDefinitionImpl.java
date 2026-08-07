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
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("009101a4-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnMessageEventDefinition {
    @objid ("4f99ba05-faf5-4969-b298-cc2460eeb34b")
    @Override
    public BpmnMessage getMessageRef() {
        Object obj = getDepVal(((BpmnMessageEventDefinitionSmClass)getClassOf()).getMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("5c91fba5-adbe-47e5-9314-f1cf3d9cb14c")
    @Override
    public void setMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnMessageEventDefinitionSmClass)getClassOf()).getMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("354324b2-7e07-4120-a297-900a0fa138f3")
    @Override
    public EList<BpmnOperation> getOperationRef() {
        return new SmList<>(this, ((BpmnMessageEventDefinitionSmClass)getClassOf()).getOperationRefDep());
    }

    @objid ("12eec58a-821e-48d7-864a-0695451c1bbc")
    @Override
    public <T extends BpmnOperation> List<T> getOperationRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnOperation element : getOperationRef()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("05aaf0d4-0c6f-40d1-b228-47134a9ebba8")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("98310232-3115-4315-b52d-916a221d8283")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("6b5dbbda-1cce-4ce4-b9f2-73a22184cad1")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnMessageEventDefinition(this);
    }

}
