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
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00054970-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnSequenceFlowDataAssociationImpl extends BpmnBaseElementImpl implements BpmnSequenceFlowDataAssociation {
    @objid ("e9ffe300-fc52-48e5-b83a-c14b87c71506")
    @Override
    public BpmnSequenceFlow getConnected() {
        Object obj = getDepVal(((BpmnSequenceFlowDataAssociationSmClass)getClassOf()).getConnectedDep());
        return (obj instanceof BpmnSequenceFlow)? (BpmnSequenceFlow)obj : null;
    }

    @objid ("ca884b9e-db6b-4a2e-9c22-6b011b6ccdd3")
    @Override
    public void setConnected(BpmnSequenceFlow value) {
        appendDepVal(((BpmnSequenceFlowDataAssociationSmClass)getClassOf()).getConnectedDep(), (SmObjectImpl)value);
    }

    @objid ("c29f0dfd-7a3d-4887-93e6-d5cb29ba8dee")
    @Override
    public EList<BpmnDataAssociation> getDataAssociation() {
        return new SmList<>(this, ((BpmnSequenceFlowDataAssociationSmClass)getClassOf()).getDataAssociationDep());
    }

    @objid ("63a8b25b-e102-4c52-a40e-66583e93037d")
    @Override
    public <T extends BpmnDataAssociation> List<T> getDataAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getDataAssociation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cac04de3-5dfb-4b66-bfed-0e87b516ed5b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Connected
        obj = (SmObjectImpl)this.getDepVal(((BpmnSequenceFlowDataAssociationSmClass)getClassOf()).getConnectedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("56d1abba-a219-4172-9209-dad92115d42c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Connected
        dep = ((BpmnSequenceFlowDataAssociationSmClass)getClassOf()).getConnectedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("0c0c7523-004a-4ed0-afb7-fc663b8f2c3a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnSequenceFlowDataAssociation(this);
    }

}
