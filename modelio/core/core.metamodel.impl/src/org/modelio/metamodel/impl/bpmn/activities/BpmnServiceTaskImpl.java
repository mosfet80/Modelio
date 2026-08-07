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
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00833fec-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnServiceTaskImpl extends BpmnTaskImpl implements BpmnServiceTask {
    @objid ("191d229c-9f1a-4002-901a-a77de7c213b2")
    @Override
    public String getImplementation() {
        return (String) getAttVal(((BpmnServiceTaskSmClass)getClassOf()).getImplementationAtt());
    }

    @objid ("6a53bf24-6f3c-47af-a7c8-801befbf072c")
    @Override
    public void setImplementation(String value) {
        setAttVal(((BpmnServiceTaskSmClass)getClassOf()).getImplementationAtt(), value);
    }

    @objid ("22214b60-1149-4359-94f3-7d027e611876")
    @Override
    public BpmnOperation getOperationRef() {
        Object obj = getDepVal(((BpmnServiceTaskSmClass)getClassOf()).getOperationRefDep());
        return (obj instanceof BpmnOperation)? (BpmnOperation)obj : null;
    }

    @objid ("ec4f9c1a-94ad-4b33-95d2-08b2cdb9a28a")
    @Override
    public void setOperationRef(BpmnOperation value) {
        appendDepVal(((BpmnServiceTaskSmClass)getClassOf()).getOperationRefDep(), (SmObjectImpl)value);
    }

    @objid ("3e763828-788c-41ba-a5fa-009a55bc35a0")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2c95b728-4bfd-49f8-9dcb-87b0b045c523")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("1276c4d2-ac84-4053-9a5c-a805f9a21708")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnServiceTask(this);
    }

}
