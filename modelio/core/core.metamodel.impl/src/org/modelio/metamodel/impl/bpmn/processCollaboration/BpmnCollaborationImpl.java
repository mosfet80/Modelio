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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0073fd98-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnCollaborationImpl extends BehaviorImpl implements BpmnCollaboration {
    @objid ("6f346535-ecaa-4ff2-86f6-9ad9a785b471")
    @Override
    public boolean isIsClosed() {
        return (Boolean) getAttVal(((BpmnCollaborationSmClass)getClassOf()).getIsClosedAtt());
    }

    @objid ("539cca49-8da2-4137-bb22-3a4f235c8c0e")
    @Override
    public void setIsClosed(boolean value) {
        setAttVal(((BpmnCollaborationSmClass)getClassOf()).getIsClosedAtt(), value);
    }

    @objid ("14dd50cd-9867-4ae5-952a-4b7ab7d96be6")
    @Override
    public EList<BpmnArtifact> getArtifact() {
        return new SmList<>(this, ((BpmnCollaborationSmClass)getClassOf()).getArtifactDep());
    }

    @objid ("416a2a6c-e37f-4845-afeb-2ad1bf4c6ac1")
    @Override
    public <T extends BpmnArtifact> List<T> getArtifact(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnArtifact element : getArtifact()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f2e610bf-5b95-4d3d-8681-64c96f26b106")
    @Override
    public EList<BpmnMessageFlow> getMessageFlow() {
        return new SmList<>(this, ((BpmnCollaborationSmClass)getClassOf()).getMessageFlowDep());
    }

    @objid ("37f7b50c-4aa3-4a34-a16e-c0e82a7ab553")
    @Override
    public <T extends BpmnMessageFlow> List<T> getMessageFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessageFlow element : getMessageFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9fe87641-06ac-4f44-8da8-004935a86f35")
    @Override
    public EList<BpmnParticipant> getParticipants() {
        return new SmList<>(this, ((BpmnCollaborationSmClass)getClassOf()).getParticipantsDep());
    }

    @objid ("95b6e8df-995a-479a-aaa4-aeee445ee6a6")
    @Override
    public <T extends BpmnParticipant> List<T> getParticipants(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnParticipant element : getParticipants()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0cbfc5cc-6cc3-48da-b851-ac70bae1e4c5")
    @Override
    public EList<BpmnMessage> getMessages() {
        return new SmList<>(this, ((BpmnCollaborationSmClass)getClassOf()).getMessagesDep());
    }

    @objid ("5f469bbd-e18b-48da-be91-2b5efb5fbe93")
    @Override
    public <T extends BpmnMessage> List<T> getMessages(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessage element : getMessages()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2b1b116a-8e6a-4574-ae8f-065031ba7f90")
    @Override
    public BpmnProcess getDefinedProcess() {
        Object obj = getDepVal(((BpmnCollaborationSmClass)getClassOf()).getDefinedProcessDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("15f02133-280f-4990-b1b6-1ec8cd9824c4")
    @Override
    public void setDefinedProcess(BpmnProcess value) {
        appendDepVal(((BpmnCollaborationSmClass)getClassOf()).getDefinedProcessDep(), (SmObjectImpl)value);
    }

    @objid ("f9684111-3a79-4a01-ae4e-f15ad65001f2")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // DefinedProcess
        obj = (SmObjectImpl)this.getDepVal(((BpmnCollaborationSmClass)getClassOf()).getDefinedProcessDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("69073f88-7b6a-4488-a093-c797d777f3b7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // DefinedProcess
        dep = ((BpmnCollaborationSmClass)getClassOf()).getDefinedProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b3ea3ff8-9adf-4f8b-82b1-0bde18340915")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnCollaboration(this);
    }

}
