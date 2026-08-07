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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0078aed8-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnArtifactImpl extends BpmnBaseElementImpl implements BpmnArtifact {
    @objid ("a52ab43c-9424-4ebd-9e9f-1b90a12df701")
    @Override
    public BpmnSubProcess getSubProcess() {
        Object obj = getDepVal(((BpmnArtifactSmClass)getClassOf()).getSubProcessDep());
        return (obj instanceof BpmnSubProcess)? (BpmnSubProcess)obj : null;
    }

    @objid ("2eaf8c41-604d-4e6a-aacd-05923769847c")
    @Override
    public void setSubProcess(BpmnSubProcess value) {
        appendDepVal(((BpmnArtifactSmClass)getClassOf()).getSubProcessDep(), (SmObjectImpl)value);
    }

    @objid ("440f2456-db8f-4414-bb17-8542eca987f3")
    @Override
    public BpmnCollaboration getCollaboration() {
        Object obj = getDepVal(((BpmnArtifactSmClass)getClassOf()).getCollaborationDep());
        return (obj instanceof BpmnCollaboration)? (BpmnCollaboration)obj : null;
    }

    @objid ("52a9508f-1245-4e13-9c07-7a607306676b")
    @Override
    public void setCollaboration(BpmnCollaboration value) {
        appendDepVal(((BpmnArtifactSmClass)getClassOf()).getCollaborationDep(), (SmObjectImpl)value);
    }

    @objid ("b3cb66d0-1e04-45b6-80d1-2490b77be048")
    @Override
    public BpmnProcess getProcess() {
        Object obj = getDepVal(((BpmnArtifactSmClass)getClassOf()).getProcessDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("da69079d-f9a4-41b6-819b-2a658f038049")
    @Override
    public void setProcess(BpmnProcess value) {
        appendDepVal(((BpmnArtifactSmClass)getClassOf()).getProcessDep(), (SmObjectImpl)value);
    }

    @objid ("21d27b72-6c06-4654-b880-db309d2801c6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SubProcess
        obj = (SmObjectImpl)this.getDepVal(((BpmnArtifactSmClass)getClassOf()).getSubProcessDep());
        if (obj != null)
          return obj;
        // Collaboration
        obj = (SmObjectImpl)this.getDepVal(((BpmnArtifactSmClass)getClassOf()).getCollaborationDep());
        if (obj != null)
          return obj;
        // Process
        obj = (SmObjectImpl)this.getDepVal(((BpmnArtifactSmClass)getClassOf()).getProcessDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("19af124b-b351-4ae1-adca-795d3613b858")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SubProcess
        dep = ((BpmnArtifactSmClass)getClassOf()).getSubProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Collaboration
        dep = ((BpmnArtifactSmClass)getClassOf()).getCollaborationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Process
        dep = ((BpmnArtifactSmClass)getClassOf()).getProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("1cc96b11-4512-4c67-8a3f-b12643d9960c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnArtifact(this);
    }

}
