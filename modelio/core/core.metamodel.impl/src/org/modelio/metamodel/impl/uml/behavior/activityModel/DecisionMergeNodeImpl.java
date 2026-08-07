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
import org.modelio.metamodel.uml.behavior.activityModel.DecisionMergeNode;
import org.modelio.metamodel.uml.behavior.activityModel.DecisionNodeKind;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002ff30a-c4bf-1fd8-97fe-001ec947cd2a")
public class DecisionMergeNodeImpl extends ControlNodeImpl implements DecisionMergeNode {
    @objid ("745801b9-6a60-44a8-9ef2-a041335d90ad")
    @Override
    public DecisionNodeKind getDecisionKind() {
        return (DecisionNodeKind) getAttVal(((DecisionMergeNodeSmClass)getClassOf()).getDecisionKindAtt());
    }

    @objid ("a099a00c-21a7-4380-99df-8cf8d2870587")
    @Override
    public void setDecisionKind(DecisionNodeKind value) {
        setAttVal(((DecisionMergeNodeSmClass)getClassOf()).getDecisionKindAtt(), value);
    }

    @objid ("d0296389-01db-46ff-8545-5f16a110404f")
    @Override
    public String getDecisionInputBehavior() {
        return (String) getAttVal(((DecisionMergeNodeSmClass)getClassOf()).getDecisionInputBehaviorAtt());
    }

    @objid ("c97919cc-5bef-4d57-82b9-478171572851")
    @Override
    public void setDecisionInputBehavior(String value) {
        setAttVal(((DecisionMergeNodeSmClass)getClassOf()).getDecisionInputBehaviorAtt(), value);
    }

    @objid ("335ad8b5-6ad0-43be-9a20-d58a591c3f18")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("ac44dfd1-eda2-4385-a887-50ac42066659")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("cf6eb9bf-b841-47f9-a113-bf6bec238f4b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitDecisionMergeNode(this);
    }

}
