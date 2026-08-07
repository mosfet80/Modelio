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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00648264-c4bf-1fd8-97fe-001ec947cd2a")
public class DataFlowImpl extends UmlModelElementImpl implements DataFlow {
    @objid ("ee22aa28-710d-4d2d-a96b-1d4f796fc84a")
    @Override
    public NameSpace getDestination() {
        Object obj = getDepVal(((DataFlowSmClass)getClassOf()).getDestinationDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("f8b81cab-11ba-4cfd-89ab-0b3403a8422c")
    @Override
    public void setDestination(NameSpace value) {
        appendDepVal(((DataFlowSmClass)getClassOf()).getDestinationDep(), (SmObjectImpl)value);
    }

    @objid ("58cd06e7-54f3-482b-96d4-c6f6656a2ceb")
    @Override
    public NameSpace getOrigin() {
        Object obj = getDepVal(((DataFlowSmClass)getClassOf()).getOriginDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("bf5a85bb-d43e-4da9-acfc-722573cf9c9b")
    @Override
    public void setOrigin(NameSpace value) {
        appendDepVal(((DataFlowSmClass)getClassOf()).getOriginDep(), (SmObjectImpl)value);
    }

    @objid ("5fd02623-3ff5-476d-91a9-fe75f1b1eaba")
    @Override
    public NameSpace getOwner() {
        Object obj = getDepVal(((DataFlowSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("667dee05-0c88-40ba-b3b8-915a3f5c3268")
    @Override
    public void setOwner(NameSpace value) {
        appendDepVal(((DataFlowSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("386ec87e-5d74-4a93-ba70-b98ef71cad60")
    @Override
    public Signal getSModel() {
        Object obj = getDepVal(((DataFlowSmClass)getClassOf()).getSModelDep());
        return (obj instanceof Signal)? (Signal)obj : null;
    }

    @objid ("9f85f77f-e6bc-4bbd-85b7-5ca069b796c9")
    @Override
    public void setSModel(Signal value) {
        appendDepVal(((DataFlowSmClass)getClassOf()).getSModelDep(), (SmObjectImpl)value);
    }

    @objid ("ccb95434-b190-404b-b380-8429cbf77a79")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((DataFlowSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("d09aa1ee-a2a5-4e02-9f3c-efdaefd7b2a6")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((DataFlowSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("91db7373-e125-466e-9774-df42fbd9d92e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitDataFlow(this);
    }

}
