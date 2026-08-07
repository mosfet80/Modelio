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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.MessageFlow;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00381364-c4bf-1fd8-97fe-001ec947cd2a")
public class MessageFlowImpl extends ActivityEdgeImpl implements MessageFlow {
    @objid ("e3770f3f-0fce-4086-8aba-4897316eb14d")
    @Override
    public ActivityPartition getTargetPartition() {
        Object obj = getDepVal(((MessageFlowSmClass)getClassOf()).getTargetPartitionDep());
        return (obj instanceof ActivityPartition)? (ActivityPartition)obj : null;
    }

    @objid ("900236df-93da-4125-aabd-9a4138fac2d2")
    @Override
    public void setTargetPartition(ActivityPartition value) {
        appendDepVal(((MessageFlowSmClass)getClassOf()).getTargetPartitionDep(), (SmObjectImpl)value);
    }

    @objid ("13314ca1-db8f-4598-a35a-c5ce2a76822b")
    @Override
    public ActivityPartition getSourcePartition() {
        Object obj = getDepVal(((MessageFlowSmClass)getClassOf()).getSourcePartitionDep());
        return (obj instanceof ActivityPartition)? (ActivityPartition)obj : null;
    }

    @objid ("81528c69-8ed4-4136-a8f9-f3dd88fc3d6c")
    @Override
    public void setSourcePartition(ActivityPartition value) {
        appendDepVal(((MessageFlowSmClass)getClassOf()).getSourcePartitionDep(), (SmObjectImpl)value);
    }

    @objid ("5c8858a6-9e9d-466d-b6c9-7128536f2327")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SourcePartition
        obj = (SmObjectImpl)this.getDepVal(((MessageFlowSmClass)getClassOf()).getSourcePartitionDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("0a986633-b98a-457f-a24f-5c6b039cc22b")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SourcePartition
        dep = ((MessageFlowSmClass)getClassOf()).getSourcePartitionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("e9b0a931-3990-4766-bdec-b359552a76bb")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitMessageFlow(this);
    }

}
