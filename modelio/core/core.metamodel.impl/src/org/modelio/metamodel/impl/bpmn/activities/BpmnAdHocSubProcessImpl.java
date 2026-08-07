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
import org.modelio.metamodel.bpmn.activities.AdHocOrdering;
import org.modelio.metamodel.bpmn.activities.BpmnAdHocSubProcess;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007e160c-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnAdHocSubProcessImpl extends BpmnSubProcessImpl implements BpmnAdHocSubProcess {
    @objid ("c2f10b57-fc3f-4711-bf10-c02fae9edf2d")
    @Override
    public AdHocOrdering getOrdering() {
        return (AdHocOrdering) getAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getOrderingAtt());
    }

    @objid ("5373162f-3b2e-48e1-9005-9e961c49a839")
    @Override
    public void setOrdering(AdHocOrdering value) {
        setAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getOrderingAtt(), value);
    }

    @objid ("030df41c-67ca-4703-9253-33e9104f4c86")
    @Override
    public boolean isCancelRemainingInstances() {
        return (Boolean) getAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getCancelRemainingInstancesAtt());
    }

    @objid ("95d7dc1d-f343-4acd-9c49-74c6b8c3a2bc")
    @Override
    public void setCancelRemainingInstances(boolean value) {
        setAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getCancelRemainingInstancesAtt(), value);
    }

    @objid ("4cbd8e71-0c4f-4086-ac24-b52292d809db")
    @Override
    public String getCompletionCondition() {
        return (String) getAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getCompletionConditionAtt());
    }

    @objid ("232077e5-6815-4a2b-adeb-e7e8d6af0461")
    @Override
    public void setCompletionCondition(String value) {
        setAttVal(((BpmnAdHocSubProcessSmClass)getClassOf()).getCompletionConditionAtt(), value);
    }

    @objid ("a464d4fd-edc7-41d3-9f32-7e2e4c2aeeb6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("f264c74d-64aa-4c48-afb6-2c83adc5f1c3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("05301db5-cac9-41ef-8a7f-af25ef6a83f2")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnAdHocSubProcess(this);
    }

}
