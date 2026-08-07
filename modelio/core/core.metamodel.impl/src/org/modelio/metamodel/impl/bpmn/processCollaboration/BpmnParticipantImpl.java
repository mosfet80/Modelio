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
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.bpmnService.BpmnEndPoint;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0075ac2e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnParticipantImpl extends BpmnBaseElementImpl implements BpmnParticipant {
    @objid ("6c4ec23f-a37b-4cac-a9b9-3d93d4ed03a6")
    @Override
    public boolean isLocal() {
        BpmnProcess process = getProcess();
        BpmnCollaboration collab = getContainer();
        return process != null && collab != null && Objects.equals(collab.getDefinedProcess(), process);
    }

    @objid ("e245097b-8b0b-44b8-8d98-4c33e302d941")
    @Override
    public int getMultiplicityMin() {
        return (Integer) getAttVal(((BpmnParticipantSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("490b63e6-ed82-41e4-bee8-a8dcf94bc2de")
    @Override
    public void setMultiplicityMin(int value) {
        setAttVal(((BpmnParticipantSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("074cbd63-3117-4d4b-9555-b4a97437c019")
    @Override
    public int getMultiplicityMax() {
        return (Integer) getAttVal(((BpmnParticipantSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("d648d19b-729b-4e02-bbab-9eaf51affd21")
    @Override
    public void setMultiplicityMax(int value) {
        setAttVal(((BpmnParticipantSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("5ddd00fa-b43b-40ae-9742-ae4e99e4b39d")
    @Override
    public BpmnProcess getProcess() {
        Object obj = getDepVal(((BpmnParticipantSmClass)getClassOf()).getProcessDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("bb61767e-c680-408e-9475-ac42c26e2b38")
    @Override
    public void setProcess(BpmnProcess value) {
        appendDepVal(((BpmnParticipantSmClass)getClassOf()).getProcessDep(), (SmObjectImpl)value);
    }

    @objid ("140ae647-94e2-421a-abfe-162f16e3fb21")
    @Override
    public BpmnCollaboration getContainer() {
        Object obj = getDepVal(((BpmnParticipantSmClass)getClassOf()).getContainerDep());
        return (obj instanceof BpmnCollaboration)? (BpmnCollaboration)obj : null;
    }

    @objid ("e46126a7-829d-4613-8399-46f496932549")
    @Override
    public void setContainer(BpmnCollaboration value) {
        appendDepVal(((BpmnParticipantSmClass)getClassOf()).getContainerDep(), (SmObjectImpl)value);
    }

    @objid ("8a332025-952d-40ef-a644-9028f5b13957")
    @Override
    public EList<BpmnEndPoint> getEndPointRefs() {
        return new SmList<>(this, ((BpmnParticipantSmClass)getClassOf()).getEndPointRefsDep());
    }

    @objid ("cc9ad9e6-4eb6-4e2e-9979-bde3349be920")
    @Override
    public <T extends BpmnEndPoint> List<T> getEndPointRefs(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnEndPoint element : getEndPointRefs()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("fedad0e4-cf43-4778-83d2-f62a1aca3e49")
    @Override
    public EList<BpmnInterface> getInterfaceRefs() {
        return new SmList<>(this, ((BpmnParticipantSmClass)getClassOf()).getInterfaceRefsDep());
    }

    @objid ("6a713a07-0d84-4811-ac2b-72cb91dcd82e")
    @Override
    public <T extends BpmnInterface> List<T> getInterfaceRefs(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnInterface element : getInterfaceRefs()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cb5240e0-225b-4828-835f-f55cb1d28e5b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Container
        obj = (SmObjectImpl)this.getDepVal(((BpmnParticipantSmClass)getClassOf()).getContainerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("2d52f810-aad7-4a61-bb14-948852b788ec")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Container
        dep = ((BpmnParticipantSmClass)getClassOf()).getContainerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3cc3586c-75b0-450f-8fba-1c52f0dea37a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnParticipant(this);
    }

}
