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
import org.modelio.metamodel.bpmn.events.BpmnTimerEventDefinition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00969aa6-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTimerEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnTimerEventDefinition {
    @objid ("612ad10a-48aa-46d1-9b11-a9ac68279f56")
    @Override
    public String getTimeCycle() {
        return (String) getAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeCycleAtt());
    }

    @objid ("920a95d3-c765-4661-8f6f-910be400348d")
    @Override
    public void setTimeCycle(String value) {
        setAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeCycleAtt(), value);
    }

    @objid ("94a0a3a5-4a73-44c1-8f5d-2d9e6ac99bfe")
    @Override
    public String getTimeDate() {
        return (String) getAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeDateAtt());
    }

    @objid ("b5d0288b-beea-479a-b017-d5d345277dab")
    @Override
    public void setTimeDate(String value) {
        setAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeDateAtt(), value);
    }

    @objid ("f5f11685-72da-4bea-a4bf-6abb08c99ef5")
    @Override
    public String getTimeDuration() {
        return (String) getAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeDurationAtt());
    }

    @objid ("dcff3985-933a-42ed-8214-7abfeeb67df5")
    @Override
    public void setTimeDuration(String value) {
        setAttVal(((BpmnTimerEventDefinitionSmClass)getClassOf()).getTimeDurationAtt(), value);
    }

    @objid ("d7fecc07-54f7-4924-96c0-1da82eedd113")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2b536e04-9f7a-4372-bf4f-1c6dcbffff0d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("d292b960-6b39-491d-a247-efebc9fae56d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnTimerEventDefinition(this);
    }

}
