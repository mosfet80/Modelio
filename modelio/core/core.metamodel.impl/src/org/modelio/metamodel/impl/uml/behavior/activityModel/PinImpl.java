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
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("003cae42-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class PinImpl extends ObjectNodeImpl implements Pin {
    @objid ("2c731910-976f-4a52-a31a-091ad7de1d0d")
    @Override
    public boolean isIsControl() {
        return (Boolean) getAttVal(((PinSmClass)getClassOf()).getIsControlAtt());
    }

    @objid ("6508bcf1-9a17-4308-9a2f-78b25fcf2075")
    @Override
    public void setIsControl(boolean value) {
        setAttVal(((PinSmClass)getClassOf()).getIsControlAtt(), value);
    }

    @objid ("40511262-b86f-42ad-a98e-c53180a78731")
    @Override
    public boolean isIsExpansion() {
        return (Boolean) getAttVal(((PinSmClass)getClassOf()).getIsExpansionAtt());
    }

    @objid ("29529dc4-6cdb-47ff-af2a-24f25e22a946")
    @Override
    public void setIsExpansion(boolean value) {
        setAttVal(((PinSmClass)getClassOf()).getIsExpansionAtt(), value);
    }

    @objid ("4171979c-31d0-434f-9286-b01aba16a09f")
    @Override
    public Parameter getMatched() {
        Object obj = getDepVal(((PinSmClass)getClassOf()).getMatchedDep());
        return (obj instanceof Parameter)? (Parameter)obj : null;
    }

    @objid ("8d6bfbee-b649-4c49-a106-68024f17bf4e")
    @Override
    public void setMatched(Parameter value) {
        appendDepVal(((PinSmClass)getClassOf()).getMatchedDep(), (SmObjectImpl)value);
    }

    @objid ("6b4be72c-da5b-4bfc-bd60-4894521fe7a6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("9da4074e-5c8d-4cfe-9b25-a62963cab5f3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("ca560ac5-b8d1-4f90-a52e-0631369090e8")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPin(this);
    }

}
