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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionOccurenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionSpecification;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0044efbc-c4bf-1fd8-97fe-001ec947cd2a")
public class ExecutionSpecificationImpl extends InteractionFragmentImpl implements ExecutionSpecification {
    @objid ("7f063d32-c7ad-4be8-b2f2-a0bd2e5103ef")
    @Override
    public ExecutionOccurenceSpecification getFinish() {
        Object obj = getDepVal(((ExecutionSpecificationSmClass)getClassOf()).getFinishDep());
        return (obj instanceof ExecutionOccurenceSpecification)? (ExecutionOccurenceSpecification)obj : null;
    }

    @objid ("0191cffb-a438-45d8-89a5-717f7843e93d")
    @Override
    public void setFinish(ExecutionOccurenceSpecification value) {
        appendDepVal(((ExecutionSpecificationSmClass)getClassOf()).getFinishDep(), (SmObjectImpl)value);
    }

    @objid ("78bb5910-cd7f-4741-bd69-03aca95143bb")
    @Override
    public ExecutionOccurenceSpecification getStart() {
        Object obj = getDepVal(((ExecutionSpecificationSmClass)getClassOf()).getStartDep());
        return (obj instanceof ExecutionOccurenceSpecification)? (ExecutionOccurenceSpecification)obj : null;
    }

    @objid ("d3273e36-436a-47cb-83dd-e4d3fc534608")
    @Override
    public void setStart(ExecutionOccurenceSpecification value) {
        appendDepVal(((ExecutionSpecificationSmClass)getClassOf()).getStartDep(), (SmObjectImpl)value);
    }

    @objid ("d1a23079-c3f5-4228-bc77-acd3f9f07b7f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("b6f04d23-f1d6-410a-bb98-cfb71ab0cc3c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("31645868-9a34-46f9-ae95-8f513fba250c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExecutionSpecification(this);
    }

}
