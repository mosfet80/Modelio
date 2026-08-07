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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0028d9f8-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityNodeImpl extends UmlModelElementImpl implements ActivityNode {
    @objid ("ec6ceae6-d3ab-46fd-ac3b-f1f17f89b28f")
    @Override
    public Activity getOwner() {
        Object obj = getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Activity)? (Activity)obj : null;
    }

    @objid ("b2eb6e18-0f76-4b60-9f8c-b2673b1b86c8")
    @Override
    public void setOwner(Activity value) {
        appendDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("534a187b-0e22-40a5-a51e-781572089d9a")
    @Override
    public ActivityPartition getOwnerPartition() {
        Object obj = getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerPartitionDep());
        return (obj instanceof ActivityPartition)? (ActivityPartition)obj : null;
    }

    @objid ("e2e3f225-031f-4576-9bfa-f84ac679fb91")
    @Override
    public void setOwnerPartition(ActivityPartition value) {
        appendDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerPartitionDep(), (SmObjectImpl)value);
    }

    @objid ("48342af6-fb81-4d52-8f08-47eb8fbedd94")
    @Override
    public EList<ActivityEdge> getIncoming() {
        return new SmList<>(this, ((ActivityNodeSmClass)getClassOf()).getIncomingDep());
    }

    @objid ("35981c87-62b6-4854-ba46-bbdab2ce944f")
    @Override
    public <T extends ActivityEdge> List<T> getIncoming(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityEdge element : getIncoming()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5d541b1b-e9aa-4558-9359-64c273c7c54f")
    @Override
    public Clause getOwnerClause() {
        Object obj = getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerClauseDep());
        return (obj instanceof Clause)? (Clause)obj : null;
    }

    @objid ("86b97170-02f2-484a-8c0b-8f26b8f6d930")
    @Override
    public void setOwnerClause(Clause value) {
        appendDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerClauseDep(), (SmObjectImpl)value);
    }

    @objid ("600e0f17-14e6-4384-975f-ff190cfbbae6")
    @Override
    public StructuredActivityNode getOwnerNode() {
        Object obj = getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerNodeDep());
        return (obj instanceof StructuredActivityNode)? (StructuredActivityNode)obj : null;
    }

    @objid ("ca2d697c-1fbb-4ffe-8bb1-23a342d1cd6d")
    @Override
    public void setOwnerNode(StructuredActivityNode value) {
        appendDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerNodeDep(), (SmObjectImpl)value);
    }

    @objid ("450b5137-1160-4883-aa49-6ca646eef67d")
    @Override
    public EList<ActivityEdge> getOutgoing() {
        return new SmList<>(this, ((ActivityNodeSmClass)getClassOf()).getOutgoingDep());
    }

    @objid ("b5491d4c-d71f-4dbc-86c8-caf8e15cbcb7")
    @Override
    public <T extends ActivityEdge> List<T> getOutgoing(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityEdge element : getOutgoing()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("900e52c8-fc75-4511-8c81-1f1f4c1d8e9b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        // OwnerPartition
        obj = (SmObjectImpl)this.getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerPartitionDep());
        if (obj != null)
          return obj;
        // OwnerClause
        obj = (SmObjectImpl)this.getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerClauseDep());
        if (obj != null)
          return obj;
        // OwnerNode
        obj = (SmObjectImpl)this.getDepVal(((ActivityNodeSmClass)getClassOf()).getOwnerNodeDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("947b8552-c6cd-468a-8e26-26ef5f9ea745")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((ActivityNodeSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerPartition
        dep = ((ActivityNodeSmClass)getClassOf()).getOwnerPartitionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerClause
        dep = ((ActivityNodeSmClass)getClassOf()).getOwnerClauseDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerNode
        dep = ((ActivityNodeSmClass)getClassOf()).getOwnerNodeDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("51cf34c8-9e24-45d9-82b3-027d4b5e3046")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityNode(this);
    }

}
