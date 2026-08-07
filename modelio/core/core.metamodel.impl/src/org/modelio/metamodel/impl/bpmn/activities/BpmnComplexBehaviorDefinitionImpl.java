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
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007fa21a-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnComplexBehaviorDefinitionImpl extends BpmnBaseElementImpl implements BpmnComplexBehaviorDefinition {
    @objid ("5db8d99b-c268-4583-8a28-9a54275b33ab")
    @Override
    public String getCondition() {
        return (String) getAttVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getConditionAtt());
    }

    @objid ("ac3dfebc-f23c-4e06-8c3e-f2c012acad37")
    @Override
    public void setCondition(String value) {
        setAttVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getConditionAtt(), value);
    }

    @objid ("276a7bca-d5ad-477a-9c5b-54bf02b2802a")
    @Override
    public BpmnMultiInstanceLoopCharacteristics getOwner() {
        Object obj = getDepVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof BpmnMultiInstanceLoopCharacteristics)? (BpmnMultiInstanceLoopCharacteristics)obj : null;
    }

    @objid ("4727a005-8ef5-408a-b24e-4dcd228b4262")
    @Override
    public void setOwner(BpmnMultiInstanceLoopCharacteristics value) {
        appendDepVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("cbaedc79-8313-4807-a8ae-da137ebfd63f")
    @Override
    public BpmnImplicitThrowEvent getEvent() {
        Object obj = getDepVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getEventDep());
        return (obj instanceof BpmnImplicitThrowEvent)? (BpmnImplicitThrowEvent)obj : null;
    }

    @objid ("7af10555-c94c-452d-894a-76f8c73d036c")
    @Override
    public void setEvent(BpmnImplicitThrowEvent value) {
        appendDepVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getEventDep(), (SmObjectImpl)value);
    }

    @objid ("741c5691-9d28-419c-b389-bca30e875c4d")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("974eb585-5acb-4445-b755-cceca989691e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((BpmnComplexBehaviorDefinitionSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("860493e6-d50c-4e90-8726-978b2e030e31")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnComplexBehaviorDefinition(this);
    }

}
