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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.InterruptibleActivityRegion;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002733be-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityEdgeImpl extends UmlModelElementImpl implements ActivityEdge {
    @objid ("86b99914-41ff-492c-abdc-2d4166109f51")
    @Override
    public String getGuard() {
        return (String) getAttVal(((ActivityEdgeSmClass)getClassOf()).getGuardAtt());
    }

    @objid ("6e466423-a84c-460e-b077-2f46ebb08e8d")
    @Override
    public void setGuard(String value) {
        setAttVal(((ActivityEdgeSmClass)getClassOf()).getGuardAtt(), value);
    }

    @objid ("5cef03d7-650b-4409-adbd-74c46562a643")
    @Override
    public String getWeight() {
        return (String) getAttVal(((ActivityEdgeSmClass)getClassOf()).getWeightAtt());
    }

    @objid ("b311799c-cb92-48cc-9018-23cec9e2a674")
    @Override
    public void setWeight(String value) {
        setAttVal(((ActivityEdgeSmClass)getClassOf()).getWeightAtt(), value);
    }

    @objid ("f0adb849-8881-40f6-9627-e93093a46853")
    @Override
    public ActivityNode getTarget() {
        Object obj = getDepVal(((ActivityEdgeSmClass)getClassOf()).getTargetDep());
        return (obj instanceof ActivityNode)? (ActivityNode)obj : null;
    }

    @objid ("e65e9773-e502-497e-b992-71e64a437229")
    @Override
    public void setTarget(ActivityNode value) {
        appendDepVal(((ActivityEdgeSmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("02105075-4405-43bd-b88c-c22550a2c3b5")
    @Override
    public ActivityNode getSource() {
        Object obj = getDepVal(((ActivityEdgeSmClass)getClassOf()).getSourceDep());
        return (obj instanceof ActivityNode)? (ActivityNode)obj : null;
    }

    @objid ("cc1e9320-1a8d-4974-b2cc-d3b9ca0281d7")
    @Override
    public void setSource(ActivityNode value) {
        appendDepVal(((ActivityEdgeSmClass)getClassOf()).getSourceDep(), (SmObjectImpl)value);
    }

    @objid ("e1a126e3-9363-4800-a709-a1ddacc45032")
    @Override
    public InterruptibleActivityRegion getInterrupts() {
        Object obj = getDepVal(((ActivityEdgeSmClass)getClassOf()).getInterruptsDep());
        return (obj instanceof InterruptibleActivityRegion)? (InterruptibleActivityRegion)obj : null;
    }

    @objid ("3b94864e-b7d1-4727-867a-b6a5b9b00b94")
    @Override
    public void setInterrupts(InterruptibleActivityRegion value) {
        appendDepVal(((ActivityEdgeSmClass)getClassOf()).getInterruptsDep(), (SmObjectImpl)value);
    }

    @objid ("9654926d-447e-4182-8651-798ba8088cad")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((ActivityEdgeSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("7bb4ae63-b156-4c5e-8b36-3e96a95ce3f2")
    @Override
    public <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getRealizedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9af50646-3c18-4ba5-9d07-c9a1f01dcc3d")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Source
        obj = (SmObjectImpl)this.getDepVal(((ActivityEdgeSmClass)getClassOf()).getSourceDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("b84e9e20-01da-4256-8e48-7aaef17f33d5")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Source
        dep = ((ActivityEdgeSmClass)getClassOf()).getSourceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("963e0692-823e-46ef-bd27-82aa69e96507")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityEdge(this);
    }

}
