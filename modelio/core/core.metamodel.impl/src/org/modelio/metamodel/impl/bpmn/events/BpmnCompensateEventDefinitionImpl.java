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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00897772-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnCompensateEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnCompensateEventDefinition {
    @objid ("d9cf9bb6-5f61-4d61-a88c-b29240d6ff85")
    @Override
    public String getWaitForCompletion() {
        return (String) getAttVal(((BpmnCompensateEventDefinitionSmClass)getClassOf()).getWaitForCompletionAtt());
    }

    @objid ("62084bcb-191e-42cb-9aa8-6accafee90bf")
    @Override
    public void setWaitForCompletion(String value) {
        setAttVal(((BpmnCompensateEventDefinitionSmClass)getClassOf()).getWaitForCompletionAtt(), value);
    }

    @objid ("c61175e9-2b77-407e-8e66-13890a56e374")
    @Override
    public BpmnActivity getActivityRef() {
        Object obj = getDepVal(((BpmnCompensateEventDefinitionSmClass)getClassOf()).getActivityRefDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("a7b280ee-38b4-4ca0-a252-c620c42e8bf6")
    @Override
    public void setActivityRef(BpmnActivity value) {
        appendDepVal(((BpmnCompensateEventDefinitionSmClass)getClassOf()).getActivityRefDep(), (SmObjectImpl)value);
    }

    @objid ("6f7c7452-54c6-4b4c-b161-2544a6ae1b99")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("65d26322-bdcb-4eed-8444-f9187ac842c3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("5837f693-b447-43e6-bf47-2e1118430cd2")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnCompensateEventDefinition(this);
    }

}
