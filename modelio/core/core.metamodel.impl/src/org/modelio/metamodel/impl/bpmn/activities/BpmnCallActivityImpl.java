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
import org.modelio.metamodel.bpmn.activities.BpmnCallActivity;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007f281c-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnCallActivityImpl extends BpmnActivityImpl implements BpmnCallActivity {
    @objid ("de1b202f-c76c-4295-a521-712f7a0a5e47")
    @Override
    public BpmnTask getCalledGlobalTask() {
        Object obj = getDepVal(((BpmnCallActivitySmClass)getClassOf()).getCalledGlobalTaskDep());
        return (obj instanceof BpmnTask)? (BpmnTask)obj : null;
    }

    @objid ("af42ce88-e419-43e9-adfe-c8e2de066581")
    @Override
    public void setCalledGlobalTask(BpmnTask value) {
        appendDepVal(((BpmnCallActivitySmClass)getClassOf()).getCalledGlobalTaskDep(), (SmObjectImpl)value);
    }

    @objid ("50a5e610-60d0-41a3-86d9-8c0edd585657")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("25a41fc8-cf08-4f00-b375-7c07547cd117")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("b6fc7713-b496-4336-b295-42d419fa8127")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnCallActivity(this);
    }

}
