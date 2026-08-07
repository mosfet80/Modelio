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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlow;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlowEffectKind;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0038c502-c4bf-1fd8-97fe-001ec947cd2a")
public class ObjectFlowImpl extends ActivityEdgeImpl implements ObjectFlow {
    @objid ("2bd48c16-51ac-4748-bfce-3dfd4e1f6de9")
    @Override
    public String getTransformationBehavior() {
        return (String) getAttVal(((ObjectFlowSmClass)getClassOf()).getTransformationBehaviorAtt());
    }

    @objid ("e38d4a0f-1751-4a6d-ac24-5ae87eee3bab")
    @Override
    public void setTransformationBehavior(String value) {
        setAttVal(((ObjectFlowSmClass)getClassOf()).getTransformationBehaviorAtt(), value);
    }

    @objid ("0ca8e684-a722-456c-931a-1133d71db714")
    @Override
    public String getSelectionBehavior() {
        return (String) getAttVal(((ObjectFlowSmClass)getClassOf()).getSelectionBehaviorAtt());
    }

    @objid ("1f82ab3e-0017-4885-b4d4-a9c18970a30d")
    @Override
    public void setSelectionBehavior(String value) {
        setAttVal(((ObjectFlowSmClass)getClassOf()).getSelectionBehaviorAtt(), value);
    }

    @objid ("1b66aaa7-5a1e-4ac5-bddd-e6085d10ca33")
    @Override
    public boolean isIsMultiCast() {
        return (Boolean) getAttVal(((ObjectFlowSmClass)getClassOf()).getIsMultiCastAtt());
    }

    @objid ("f951991e-cd9c-4777-a196-c90d41b50b21")
    @Override
    public void setIsMultiCast(boolean value) {
        setAttVal(((ObjectFlowSmClass)getClassOf()).getIsMultiCastAtt(), value);
    }

    @objid ("5adcbc2e-3141-4c0d-be28-887545329bed")
    @Override
    public boolean isIsMultiReceive() {
        return (Boolean) getAttVal(((ObjectFlowSmClass)getClassOf()).getIsMultiReceiveAtt());
    }

    @objid ("debcf42f-0abe-4cab-a22c-48fe74df5a9c")
    @Override
    public void setIsMultiReceive(boolean value) {
        setAttVal(((ObjectFlowSmClass)getClassOf()).getIsMultiReceiveAtt(), value);
    }

    @objid ("f61c0cbe-e89c-4797-9a33-407e2752dbc2")
    @Override
    public ObjectFlowEffectKind getEffect() {
        return (ObjectFlowEffectKind) getAttVal(((ObjectFlowSmClass)getClassOf()).getEffectAtt());
    }

    @objid ("e16e2388-52f8-466a-a9df-b08c07ea6d7d")
    @Override
    public void setEffect(ObjectFlowEffectKind value) {
        setAttVal(((ObjectFlowSmClass)getClassOf()).getEffectAtt(), value);
    }

    @objid ("98d76322-2c18-484a-98b6-61e1da9662fb")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("aa772bb2-f0a5-40da-b580-fa98c4dae8d2")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("6e84b44b-38fe-4b84-b28c-355b44d8a9c0")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitObjectFlow(this);
    }

}
