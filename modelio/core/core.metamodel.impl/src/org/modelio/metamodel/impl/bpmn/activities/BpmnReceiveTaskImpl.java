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
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
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

@objid ("0081a92a-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnReceiveTaskImpl extends BpmnTaskImpl implements BpmnReceiveTask {
    @objid ("1eacae61-8426-41f5-9f1d-31473fb6c02f")
    @Override
    public String getImplementation() {
        return (String) getAttVal(((BpmnReceiveTaskSmClass)getClassOf()).getImplementationAtt());
    }

    @objid ("b44c1556-3d9f-40df-8d46-416959b64bf8")
    @Override
    public void setImplementation(String value) {
        setAttVal(((BpmnReceiveTaskSmClass)getClassOf()).getImplementationAtt(), value);
    }

    @objid ("a86f8347-652e-41a1-a51e-a776cb43e204")
    @Override
    public boolean isInstanciate() {
        return (Boolean) getAttVal(((BpmnReceiveTaskSmClass)getClassOf()).getInstanciateAtt());
    }

    @objid ("b7aaa84d-689b-45ca-8f25-bf81d48634a4")
    @Override
    public void setInstanciate(boolean value) {
        setAttVal(((BpmnReceiveTaskSmClass)getClassOf()).getInstanciateAtt(), value);
    }

    @objid ("2e452ad3-f1e2-418f-af67-933062ca224b")
    @Override
    public BpmnMessage getMessageRef() {
        Object obj = getDepVal(((BpmnReceiveTaskSmClass)getClassOf()).getMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("3c3ac760-63d2-435d-a852-4b1289a880e8")
    @Override
    public void setMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnReceiveTaskSmClass)getClassOf()).getMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("40b1730f-fda7-4813-a9d3-3d6dc2504079")
    @Override
    public BpmnOperation getOperationRef() {
        Object obj = getDepVal(((BpmnReceiveTaskSmClass)getClassOf()).getOperationRefDep());
        return (obj instanceof BpmnOperation)? (BpmnOperation)obj : null;
    }

    @objid ("ceec3fb8-c9c6-423c-a1c4-00e669b86e4c")
    @Override
    public void setOperationRef(BpmnOperation value) {
        appendDepVal(((BpmnReceiveTaskSmClass)getClassOf()).getOperationRefDep(), (SmObjectImpl)value);
    }

    @objid ("a4f66163-5034-4e1c-ab8e-f16de6e9e95a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("ef7a5320-be5f-4212-be70-9271517d91f4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c2a44c3c-cf4c-4b06-824e-3b7dd080e4b5")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnReceiveTask(this);
    }

}
