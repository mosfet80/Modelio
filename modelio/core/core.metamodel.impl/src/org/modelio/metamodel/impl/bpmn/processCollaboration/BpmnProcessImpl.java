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
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcessType;
import org.modelio.metamodel.bpmn.processCollaboration.OptionalBoolean;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0076549e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnProcessImpl extends BehaviorImpl implements BpmnProcess {
    @objid ("5df24a0f-4396-40b4-bf11-7f393b9b4bcd")
    @Override
    public BpmnProcessType getProcessType() {
        return (BpmnProcessType) getAttVal(((BpmnProcessSmClass)getClassOf()).getProcessTypeAtt());
    }

    @objid ("d9ddd479-570c-4c60-9dd6-bb5d7b855b25")
    @Override
    public void setProcessType(BpmnProcessType value) {
        setAttVal(((BpmnProcessSmClass)getClassOf()).getProcessTypeAtt(), value);
    }

    @objid ("3ae406a5-cab5-46f3-99c4-65f6066d9ce6")
    @Override
    public boolean isIsClosed() {
        return (Boolean) getAttVal(((BpmnProcessSmClass)getClassOf()).getIsClosedAtt());
    }

    @objid ("c1e8e4a2-e0af-41e6-b251-7c5621bff73d")
    @Override
    public void setIsClosed(boolean value) {
        setAttVal(((BpmnProcessSmClass)getClassOf()).getIsClosedAtt(), value);
    }

    @objid ("920baaee-6951-4375-b448-26f96b77d942")
    @Override
    public OptionalBoolean getIsExecutable() {
        return (OptionalBoolean) getAttVal(((BpmnProcessSmClass)getClassOf()).getIsExecutableAtt());
    }

    @objid ("3d7ed53a-e3e7-4f0f-a977-a1e3347fbd28")
    @Override
    public void setIsExecutable(OptionalBoolean value) {
        setAttVal(((BpmnProcessSmClass)getClassOf()).getIsExecutableAtt(), value);
    }

    @objid ("86ecf171-2e77-4751-ac16-dd201926a39b")
    @Override
    public EList<BpmnProcess> getSupports() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getSupportsDep());
    }

    @objid ("f1e280e8-d2cd-4fd4-a42c-c1b1819719df")
    @Override
    public <T extends BpmnProcess> List<T> getSupports(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnProcess element : getSupports()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4946cbaf-6052-4116-9341-0027665c88db")
    @Override
    public EList<BpmnArtifact> getArtifact() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getArtifactDep());
    }

    @objid ("77de6a98-1e68-43b0-b1e8-12030bef2f6b")
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

    @objid ("f2e0aae2-ab31-455c-ac8d-bbfeb0e84424")
    @Override
    public BpmnLaneSet getLaneSet() {
        Object obj = getDepVal(((BpmnProcessSmClass)getClassOf()).getLaneSetDep());
        return (obj instanceof BpmnLaneSet)? (BpmnLaneSet)obj : null;
    }

    @objid ("aef60799-8ee3-41ff-9168-029e51f9aecc")
    @Override
    public void setLaneSet(BpmnLaneSet value) {
        appendDepVal(((BpmnProcessSmClass)getClassOf()).getLaneSetDep(), (SmObjectImpl)value);
    }

    @objid ("05d8afd8-152b-4b2f-8ee0-05d3d3d9ed47")
    @Override
    public EList<BpmnProcess> getSupported() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getSupportedDep());
    }

    @objid ("52a92f30-d526-4803-a364-8edd72b6b6d3")
    @Override
    public <T extends BpmnProcess> List<T> getSupported(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnProcess element : getSupported()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1f2066c3-5c3e-4d18-9db7-1a143da29bca")
    @Override
    public EList<BpmnParticipant> getParticipant() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getParticipantDep());
    }

    @objid ("795c32cf-d217-4976-933a-0e36b075a889")
    @Override
    public <T extends BpmnParticipant> List<T> getParticipant(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnParticipant element : getParticipant()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("84a54f26-d64b-4bd2-8f55-a577e40645ff")
    @Override
    public EList<BpmnFlowElement> getFlowElement() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getFlowElementDep());
    }

    @objid ("fb017ba0-3f6f-4f72-b4aa-07c8f9130702")
    @Override
    public <T extends BpmnFlowElement> List<T> getFlowElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnFlowElement element : getFlowElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("000f5bbc-96f5-4d17-804c-9834c7ea14d7")
    @Override
    public EList<BpmnResourceRole> getResource() {
        return new SmList<>(this, ((BpmnProcessSmClass)getClassOf()).getResourceDep());
    }

    @objid ("5418ee5a-595b-46d7-bd15-a8c2a2087767")
    @Override
    public <T extends BpmnResourceRole> List<T> getResource(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceRole element : getResource()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("d93c24e0-5387-4338-bd19-5ce6a7fca38c")
    @Override
    public BpmnCollaboration getDefinitionalCollaboration() {
        Object obj = getDepVal(((BpmnProcessSmClass)getClassOf()).getDefinitionalCollaborationDep());
        return (obj instanceof BpmnCollaboration)? (BpmnCollaboration)obj : null;
    }

    @objid ("3c96ecd5-50df-46d6-9cc1-af2d2a2435cf")
    @Override
    public void setDefinitionalCollaboration(BpmnCollaboration value) {
        appendDepVal(((BpmnProcessSmClass)getClassOf()).getDefinitionalCollaborationDep(), (SmObjectImpl)value);
    }

    @objid ("91028dd3-dbcf-4cd5-aee8-db78d91f89b1")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("bc8d33d9-cab1-4ac3-bcf8-dc6c93139eea")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c38c29a1-aa7d-4f3a-9afe-0d58b7952bb9")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnProcess(this);
    }

}
