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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007c895e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageFlowImpl extends BpmnBaseElementImpl implements BpmnMessageFlow {
    @objid ("689d325d-39b4-47e1-9f0e-82b7e3fb002f")
    @Override
    public BpmnMessage getMessageRef() {
        Object obj = getDepVal(((BpmnMessageFlowSmClass)getClassOf()).getMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("d75be64f-6462-4cb3-80e8-38173382ac37")
    @Override
    public void setMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnMessageFlowSmClass)getClassOf()).getMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("a523880c-8402-4375-90c5-7d7980520df5")
    @Override
    public BpmnBaseElement getSourceRef() {
        Object obj = getDepVal(((BpmnMessageFlowSmClass)getClassOf()).getSourceRefDep());
        return (obj instanceof BpmnBaseElement)? (BpmnBaseElement)obj : null;
    }

    @objid ("30f1fbe8-d262-4eab-a31a-2a578c2a624b")
    @Override
    public void setSourceRef(BpmnBaseElement value) {
        appendDepVal(((BpmnMessageFlowSmClass)getClassOf()).getSourceRefDep(), (SmObjectImpl)value);
    }

    @objid ("c914d6e7-70ef-4c74-a948-d8112a4a68c0")
    @Override
    public BpmnBaseElement getTargetRef() {
        Object obj = getDepVal(((BpmnMessageFlowSmClass)getClassOf()).getTargetRefDep());
        return (obj instanceof BpmnBaseElement)? (BpmnBaseElement)obj : null;
    }

    @objid ("684b9ad4-cef6-4d49-b781-f08110827701")
    @Override
    public void setTargetRef(BpmnBaseElement value) {
        appendDepVal(((BpmnMessageFlowSmClass)getClassOf()).getTargetRefDep(), (SmObjectImpl)value);
    }

    @objid ("c0b7dac7-e503-448c-b21d-cbc87231f4d3")
    @Override
    public BpmnCollaboration getCollaboration() {
        Object obj = getDepVal(((BpmnMessageFlowSmClass)getClassOf()).getCollaborationDep());
        return (obj instanceof BpmnCollaboration)? (BpmnCollaboration)obj : null;
    }

    @objid ("fed64471-fb32-4ac9-987a-9e912ec41931")
    @Override
    public void setCollaboration(BpmnCollaboration value) {
        appendDepVal(((BpmnMessageFlowSmClass)getClassOf()).getCollaborationDep(), (SmObjectImpl)value);
    }

    @objid ("1f13de8d-e6bb-41a8-873d-e7cdaff96042")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Collaboration
        obj = (SmObjectImpl)this.getDepVal(((BpmnMessageFlowSmClass)getClassOf()).getCollaborationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("55796ced-d37d-4fc8-845d-de9e6c738ed3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Collaboration
        dep = ((BpmnMessageFlowSmClass)getClassOf()).getCollaborationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("893d8f3e-ad5c-4f32-bec9-03961a761726")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnMessageFlow(this);
    }

}
