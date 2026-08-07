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
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnEvent;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008d76e2-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnEventDefinitionImpl extends BpmnBaseElementImpl implements BpmnEventDefinition {
    @objid ("a4ccb12f-f6c0-493d-9df4-6afd3ea6b02b")
    @Override
    public BpmnEvent getDefined() {
        Object obj = getDepVal(((BpmnEventDefinitionSmClass)getClassOf()).getDefinedDep());
        return (obj instanceof BpmnEvent)? (BpmnEvent)obj : null;
    }

    @objid ("59bc0dd9-e6af-4f76-9fe2-2c95ee0ead76")
    @Override
    public void setDefined(BpmnEvent value) {
        appendDepVal(((BpmnEventDefinitionSmClass)getClassOf()).getDefinedDep(), (SmObjectImpl)value);
    }

    @objid ("e718d555-8c7b-44c3-863a-709bb287a000")
    @Override
    public EList<BpmnMultiInstanceLoopCharacteristics> getLoopRef() {
        return new SmList<>(this, ((BpmnEventDefinitionSmClass)getClassOf()).getLoopRefDep());
    }

    @objid ("6e058fdd-1244-4a3f-8e13-e94c61140c08")
    @Override
    public <T extends BpmnMultiInstanceLoopCharacteristics> List<T> getLoopRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMultiInstanceLoopCharacteristics element : getLoopRef()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b52b29a5-fb7d-46f6-80bf-1ca0153af1b5")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Defined
        obj = (SmObjectImpl)this.getDepVal(((BpmnEventDefinitionSmClass)getClassOf()).getDefinedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("8e523493-d193-464f-986d-7855610c7344")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Defined
        dep = ((BpmnEventDefinitionSmClass)getClassOf()).getDefinedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("198d28ac-eb10-443d-aba8-3ea8895d07cc")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnEventDefinition(this);
    }

}
