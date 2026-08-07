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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004e6c5e-c4bf-1fd8-97fe-001ec947cd2a")
public class ConnectionPointReferenceImpl extends StateVertexImpl implements ConnectionPointReference {
    @objid ("b0fbe6cc-5e14-44f2-a36c-12fb294699d9")
    @Override
    public ExitPointPseudoState getExit() {
        Object obj = getDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getExitDep());
        return (obj instanceof ExitPointPseudoState)? (ExitPointPseudoState)obj : null;
    }

    @objid ("f9cbdaee-3073-45e7-acdf-c0616da6a6dd")
    @Override
    public void setExit(ExitPointPseudoState value) {
        appendDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getExitDep(), (SmObjectImpl)value);
    }

    @objid ("7af23c35-fe52-4ed4-89ae-a69bc16e50c6")
    @Override
    public EntryPointPseudoState getEntry() {
        Object obj = getDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getEntryDep());
        return (obj instanceof EntryPointPseudoState)? (EntryPointPseudoState)obj : null;
    }

    @objid ("d0cd7d8e-8e1b-4829-a8d5-ebda80591464")
    @Override
    public void setEntry(EntryPointPseudoState value) {
        appendDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getEntryDep(), (SmObjectImpl)value);
    }

    @objid ("373381e9-bbbc-4cda-89ab-45a5c4ca2f04")
    @Override
    public State getOwnerState() {
        Object obj = getDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getOwnerStateDep());
        return (obj instanceof State)? (State)obj : null;
    }

    @objid ("5901a5b7-2c80-4feb-9d04-95211876e008")
    @Override
    public void setOwnerState(State value) {
        appendDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getOwnerStateDep(), (SmObjectImpl)value);
    }

    @objid ("84ee0803-cbd6-4358-a0de-a6a6fc2124bd")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerState
        obj = (SmObjectImpl)this.getDepVal(((ConnectionPointReferenceSmClass)getClassOf()).getOwnerStateDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c986b4ae-1ad3-43b8-bd76-9a8ed9e80d09")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerState
        dep = ((ConnectionPointReferenceSmClass)getClassOf()).getOwnerStateDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("6c07fa41-ee9d-4d55-b6b0-d052da3d0a54")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitConnectionPointReference(this);
    }

}
