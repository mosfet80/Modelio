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

@objid ("00447406-c4bf-1fd8-97fe-001ec947cd2a")
public class ExecutionOccurenceSpecificationImpl extends MessageEndImpl implements ExecutionOccurenceSpecification {
    @objid ("77de003f-8e5e-4025-a30a-82210dd8a7f7")
    @Override
    public ExecutionSpecification getFinished() {
        Object obj = getDepVal(((ExecutionOccurenceSpecificationSmClass)getClassOf()).getFinishedDep());
        return (obj instanceof ExecutionSpecification)? (ExecutionSpecification)obj : null;
    }

    @objid ("9318e366-8b91-4af0-a01a-30ea6dc6b787")
    @Override
    public void setFinished(ExecutionSpecification value) {
        appendDepVal(((ExecutionOccurenceSpecificationSmClass)getClassOf()).getFinishedDep(), (SmObjectImpl)value);
    }

    @objid ("9e7b07d8-91f2-4ce3-bf9a-e0e36e60e78a")
    @Override
    public ExecutionSpecification getStarted() {
        Object obj = getDepVal(((ExecutionOccurenceSpecificationSmClass)getClassOf()).getStartedDep());
        return (obj instanceof ExecutionSpecification)? (ExecutionSpecification)obj : null;
    }

    @objid ("ee49ca74-9322-47d6-a0bd-de660d310c8c")
    @Override
    public void setStarted(ExecutionSpecification value) {
        appendDepVal(((ExecutionOccurenceSpecificationSmClass)getClassOf()).getStartedDep(), (SmObjectImpl)value);
    }

    @objid ("7ae140a4-5ce1-4e4a-a705-1aa526023edc")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("be32d960-a422-41a8-bff7-aa3303b8fffe")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("356be49a-bf8b-4a1b-8a04-44cce497ffda")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExecutionOccurenceSpecification(this);
    }

}
