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
package org.modelio.metamodel.impl.bpmn.flows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007cfdf8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSequenceFlowImpl extends BpmnFlowElementImpl implements BpmnSequenceFlow {
    @objid ("c07e6e6f-c0f5-4028-9ba3-1480b42ae5f3")
    @Override
    public boolean isIsImmediate() {
        return (Boolean) getAttVal(((BpmnSequenceFlowSmClass)getClassOf()).getIsImmediateAtt());
    }

    @objid ("599b2145-c4c0-4908-829a-f61eb274ca97")
    @Override
    public void setIsImmediate(boolean value) {
        setAttVal(((BpmnSequenceFlowSmClass)getClassOf()).getIsImmediateAtt(), value);
    }

    @objid ("aa63b360-431e-4035-9081-627e3f724b24")
    @Override
    public String getConditionExpression() {
        return (String) getAttVal(((BpmnSequenceFlowSmClass)getClassOf()).getConditionExpressionAtt());
    }

    @objid ("76378670-7358-4f04-ab30-3ebfaa39453a")
    @Override
    public void setConditionExpression(String value) {
        setAttVal(((BpmnSequenceFlowSmClass)getClassOf()).getConditionExpressionAtt(), value);
    }

    @objid ("1d635356-b76e-4eef-af5b-e8ae7ec9d186")
    @Override
    public BpmnFlowNode getSourceRef() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getSourceRefDep());
        return (obj instanceof BpmnFlowNode)? (BpmnFlowNode)obj : null;
    }

    @objid ("ff554011-3e38-4968-adcb-38ea6e7e2a21")
    @Override
    public void setSourceRef(BpmnFlowNode value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getSourceRefDep(), (SmObjectImpl)value);
    }

    @objid ("435512f1-853e-4922-b46d-b5817bffe179")
    @Override
    public BpmnFlowNode getTargetRef() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getTargetRefDep());
        return (obj instanceof BpmnFlowNode)? (BpmnFlowNode)obj : null;
    }

    @objid ("0395d223-0f0b-4e82-9c9b-94e83a0febfd")
    @Override
    public void setTargetRef(BpmnFlowNode value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getTargetRefDep(), (SmObjectImpl)value);
    }

    @objid ("b25a4d72-16db-4c34-8e5c-511f098a0084")
    @Override
    public BpmnInclusiveGateway getDefaultOfInclusive() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfInclusiveDep());
        return (obj instanceof BpmnInclusiveGateway)? (BpmnInclusiveGateway)obj : null;
    }

    @objid ("e144882f-3d7d-498f-9d7d-d1c436e46697")
    @Override
    public void setDefaultOfInclusive(BpmnInclusiveGateway value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfInclusiveDep(), (SmObjectImpl)value);
    }

    @objid ("0e12cbf1-82a9-48fd-852c-af415a1861c1")
    @Override
    public BpmnActivity getDefaultFrom() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultFromDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("d6459b39-3b55-4513-b016-b958a13dcabf")
    @Override
    public void setDefaultFrom(BpmnActivity value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultFromDep(), (SmObjectImpl)value);
    }

    @objid ("74d540c6-8f48-4a8b-997b-82623da6b040")
    @Override
    public BpmnExclusiveGateway getDefaultOfExclusive() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfExclusiveDep());
        return (obj instanceof BpmnExclusiveGateway)? (BpmnExclusiveGateway)obj : null;
    }

    @objid ("5a79e059-432d-4b21-aedb-d5a2ccb74ad3")
    @Override
    public void setDefaultOfExclusive(BpmnExclusiveGateway value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfExclusiveDep(), (SmObjectImpl)value);
    }

    @objid ("7548287f-1439-421f-95e1-6c2cddd15771")
    @Override
    public EList<BpmnSequenceFlowDataAssociation> getConnector() {
        return new SmList<>(this, ((BpmnSequenceFlowSmClass)getClassOf()).getConnectorDep());
    }

    @objid ("2039c2b5-4147-4748-aa6a-a51a25d65644")
    @Override
    public <T extends BpmnSequenceFlowDataAssociation> List<T> getConnector(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnSequenceFlowDataAssociation element : getConnector()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("af697ee0-9518-4fdd-95bb-01c1b07b76be")
    @Override
    public BpmnComplexGateway getDefaultOfComplex() {
        Object obj = getDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfComplexDep());
        return (obj instanceof BpmnComplexGateway)? (BpmnComplexGateway)obj : null;
    }

    @objid ("354de1be-9539-468c-a2bf-6a7c0fe7281f")
    @Override
    public void setDefaultOfComplex(BpmnComplexGateway value) {
        appendDepVal(((BpmnSequenceFlowSmClass)getClassOf()).getDefaultOfComplexDep(), (SmObjectImpl)value);
    }

    @objid ("ee2ba20c-8a73-480d-90d4-10ea7f8c9700")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("56691718-9357-4aff-bc33-9efd7fd46cbc")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("b0a9f87f-5914-4d14-ac4d-86f0b12b9ffc")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnSequenceFlow(this);
    }

}
