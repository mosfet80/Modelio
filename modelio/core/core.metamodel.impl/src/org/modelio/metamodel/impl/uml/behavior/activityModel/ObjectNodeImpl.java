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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNodeOrderingKind;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00397a06-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ObjectNodeImpl extends ActivityNodeImpl implements ObjectNode {
    @objid ("331565b0-f213-4800-a752-4e6b9c57eaf5")
    @Override
    public boolean isIsControlType() {
        return (Boolean) getAttVal(((ObjectNodeSmClass)getClassOf()).getIsControlTypeAtt());
    }

    @objid ("152135b8-8019-4bf3-93eb-68cc91e5788f")
    @Override
    public void setIsControlType(boolean value) {
        setAttVal(((ObjectNodeSmClass)getClassOf()).getIsControlTypeAtt(), value);
    }

    @objid ("bf4ab828-bb2b-4402-ac45-ac1e97007315")
    @Override
    public ObjectNodeOrderingKind getOrdering() {
        return (ObjectNodeOrderingKind) getAttVal(((ObjectNodeSmClass)getClassOf()).getOrderingAtt());
    }

    @objid ("f6db9456-8e11-4330-8a36-de8617718a1a")
    @Override
    public void setOrdering(ObjectNodeOrderingKind value) {
        setAttVal(((ObjectNodeSmClass)getClassOf()).getOrderingAtt(), value);
    }

    @objid ("068769a2-3219-41bb-8cfe-bb011fe3d7c8")
    @Override
    public String getSelectionBehavior() {
        return (String) getAttVal(((ObjectNodeSmClass)getClassOf()).getSelectionBehaviorAtt());
    }

    @objid ("a654b552-abb9-4901-a5a4-46ee62c06a29")
    @Override
    public void setSelectionBehavior(String value) {
        setAttVal(((ObjectNodeSmClass)getClassOf()).getSelectionBehaviorAtt(), value);
    }

    @objid ("7c179893-682b-4488-8d41-d68b799dab17")
    @Override
    public String getUpperBound() {
        return (String) getAttVal(((ObjectNodeSmClass)getClassOf()).getUpperBoundAtt());
    }

    @objid ("c28d88f1-0737-4c1a-a6d3-61433e317aea")
    @Override
    public void setUpperBound(String value) {
        setAttVal(((ObjectNodeSmClass)getClassOf()).getUpperBoundAtt(), value);
    }

    @objid ("54f8cf59-a44a-4290-8c36-6b1543f9083b")
    @Override
    public Instance getRepresented() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("7942557b-ea05-4be5-9865-f80b8ea3f313")
    @Override
    public void setRepresented(Instance value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("a2e88f86-047e-4ed0-addc-4fe55c0950b1")
    @Override
    public BehaviorParameter getRepresentedRealParameter() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedRealParameterDep());
        return (obj instanceof BehaviorParameter)? (BehaviorParameter)obj : null;
    }

    @objid ("d9e65543-970b-4377-bec0-42a88b3bdf54")
    @Override
    public void setRepresentedRealParameter(BehaviorParameter value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedRealParameterDep(), (SmObjectImpl)value);
    }

    @objid ("013f2c50-19fc-49b6-9b47-586f19dd7196")
    @Override
    public GeneralClass getType() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getTypeDep());
        return (obj instanceof GeneralClass)? (GeneralClass)obj : null;
    }

    @objid ("88602f44-b5c7-4c70-8ddf-d5e7f06dd958")
    @Override
    public void setType(GeneralClass value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("4184318f-a118-4be9-b4e8-5e06f7de3d6c")
    @Override
    public AssociationEnd getRepresentedRole() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedRoleDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("d045cb9b-85b0-447c-90c0-b2bc22dd32e5")
    @Override
    public void setRepresentedRole(AssociationEnd value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedRoleDep(), (SmObjectImpl)value);
    }

    @objid ("99f7e2fc-e3d6-4df5-b5e8-4eb5e004d272")
    @Override
    public Attribute getRepresentedAttribute() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedAttributeDep());
        return (obj instanceof Attribute)? (Attribute)obj : null;
    }

    @objid ("8875f174-3e52-40fb-bea4-e6af2fc0e628")
    @Override
    public void setRepresentedAttribute(Attribute value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getRepresentedAttributeDep(), (SmObjectImpl)value);
    }

    @objid ("e96a9693-bf0b-4577-8b2b-5d52c71ed5cd")
    @Override
    public State getInState() {
        Object obj = getDepVal(((ObjectNodeSmClass)getClassOf()).getInStateDep());
        return (obj instanceof State)? (State)obj : null;
    }

    @objid ("a908601b-7a38-4be8-8bf1-80f3693256ff")
    @Override
    public void setInState(State value) {
        appendDepVal(((ObjectNodeSmClass)getClassOf()).getInStateDep(), (SmObjectImpl)value);
    }

    @objid ("967e277b-6ce9-4c15-b081-ff62218c19a5")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("f4ea998f-cc4c-4d5b-b606-b1e6a39b4c5c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("27ed43c4-c1fc-4162-8980-6001e65e598f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitObjectNode(this);
    }

}
