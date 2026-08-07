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
import org.modelio.metamodel.bpmn.events.BpmnLinkEventDefinition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00904a52-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLinkEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnLinkEventDefinition {
    @objid ("f859b347-d141-4897-a72f-225782af4069")
    @Override
    public EList<BpmnLinkEventDefinition> getSource() {
        return new SmList<>(this, ((BpmnLinkEventDefinitionSmClass)getClassOf()).getSourceDep());
    }

    @objid ("16c44fc2-d7db-4a44-b93a-543d774cd4de")
    @Override
    public <T extends BpmnLinkEventDefinition> List<T> getSource(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnLinkEventDefinition element : getSource()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9a351efc-a712-4283-b0fc-6f2ff943072a")
    @Override
    public BpmnLinkEventDefinition getTarget() {
        Object obj = getDepVal(((BpmnLinkEventDefinitionSmClass)getClassOf()).getTargetDep());
        return (obj instanceof BpmnLinkEventDefinition)? (BpmnLinkEventDefinition)obj : null;
    }

    @objid ("92824907-d57d-40ec-849b-24eb0048430e")
    @Override
    public void setTarget(BpmnLinkEventDefinition value) {
        appendDepVal(((BpmnLinkEventDefinitionSmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("9ac73efd-a150-43b7-bbbf-4ae58abd9934")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("a69b49e2-1f82-4132-b958-74df02c78581")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("ad4b450a-49af-4f05-8109-94dd08a9669b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnLinkEventDefinition(this);
    }

}
