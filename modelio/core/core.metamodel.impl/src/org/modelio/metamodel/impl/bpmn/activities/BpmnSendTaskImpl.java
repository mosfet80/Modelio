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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0082b734-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSendTaskImpl extends BpmnTaskImpl implements BpmnSendTask {
    @objid ("8fdf71cf-572f-4b21-93f7-3969f3b058a9")
    @Override
    public String getImplementation() {
        return (String) getAttVal(((BpmnSendTaskSmClass)getClassOf()).getImplementationAtt());
    }

    @objid ("24cb69b0-c668-4705-a0da-58609e2ff74c")
    @Override
    public void setImplementation(String value) {
        setAttVal(((BpmnSendTaskSmClass)getClassOf()).getImplementationAtt(), value);
    }

    @objid ("b67ea75a-b003-4c7a-b4b1-df66ecd7ff2b")
    @Override
    public BpmnMessage getMessageRef() {
        Object obj = getDepVal(((BpmnSendTaskSmClass)getClassOf()).getMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("6c947db4-f66e-4196-b71d-2c70627be031")
    @Override
    public void setMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnSendTaskSmClass)getClassOf()).getMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("34c7e85a-9b5e-4f08-a5e4-8f7adff40d7e")
    @Override
    public BpmnOperation getOperationRef() {
        Object obj = getDepVal(((BpmnSendTaskSmClass)getClassOf()).getOperationRefDep());
        return (obj instanceof BpmnOperation)? (BpmnOperation)obj : null;
    }

    @objid ("2aa477be-0a7e-48c2-87ae-e3a97d1b3d04")
    @Override
    public void setOperationRef(BpmnOperation value) {
        appendDepVal(((BpmnSendTaskSmClass)getClassOf()).getOperationRefDep(), (SmObjectImpl)value);
    }

    @objid ("8dbad436-a437-472b-81c3-e9830bafe0aa")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("562d070d-a87c-4697-a00a-9ed4a5d4e9f4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("d292e1ca-f165-40f5-98db-de322a85f699")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnSendTask(this);
    }

}
