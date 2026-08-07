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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorImpl;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00263040-c4bf-1fd8-97fe-001ec947cd2a")
public class ActivityImpl extends BehaviorImpl implements Activity {
    @objid ("6e7190bd-41be-4a45-8dee-8de834801607")
    @Override
    public boolean isIsSingleExecution() {
        return (Boolean) getAttVal(((ActivitySmClass)getClassOf()).getIsSingleExecutionAtt());
    }

    @objid ("cfcda3a9-8c2a-4e90-8f20-c88cbbd4b200")
    @Override
    public void setIsSingleExecution(boolean value) {
        setAttVal(((ActivitySmClass)getClassOf()).getIsSingleExecutionAtt(), value);
    }

    @objid ("171c831c-d620-447c-843a-9788224c5b91")
    @Override
    public boolean isIsReadOnly() {
        return (Boolean) getAttVal(((ActivitySmClass)getClassOf()).getIsReadOnlyAtt());
    }

    @objid ("3e375dee-779c-477b-a82c-92d88aed29d5")
    @Override
    public void setIsReadOnly(boolean value) {
        setAttVal(((ActivitySmClass)getClassOf()).getIsReadOnlyAtt(), value);
    }

    @objid ("893366e9-7b93-4477-93d1-027187c76dff")
    @Override
    public EList<ActivityGroup> getOwnedGroup() {
        return new SmList<>(this, ((ActivitySmClass)getClassOf()).getOwnedGroupDep());
    }

    @objid ("31f70ee8-ece4-4880-bc22-bcf9079ae221")
    @Override
    public <T extends ActivityGroup> List<T> getOwnedGroup(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityGroup element : getOwnedGroup()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("093feef8-bb6e-4f5c-9c24-f00d1e51f716")
    @Override
    public EList<ActivityNode> getOwnedNode() {
        return new SmList<>(this, ((ActivitySmClass)getClassOf()).getOwnedNodeDep());
    }

    @objid ("bc28d30d-4b28-45d3-91e4-6b4cb7a13313")
    @Override
    public <T extends ActivityNode> List<T> getOwnedNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityNode element : getOwnedNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("dfc2c62f-c538-4fe6-a13b-48c3e1069f9f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2335c6a9-1aa5-45f7-a99c-c6f7a293305c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("24711926-11b4-451a-83e9-4f4425f5bcae")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivity(this);
    }

}
