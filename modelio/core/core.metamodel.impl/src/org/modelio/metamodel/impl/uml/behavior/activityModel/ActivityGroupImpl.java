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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00283d2c-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityGroupImpl extends UmlModelElementImpl implements ActivityGroup {
    @objid ("0e42ee0f-138f-45b9-964f-4571c40ceafd")
    @Override
    public Activity getInActivity() {
        Object obj = getDepVal(((ActivityGroupSmClass)getClassOf()).getInActivityDep());
        return (obj instanceof Activity)? (Activity)obj : null;
    }

    @objid ("312a22df-1659-455e-a774-9fbfae18dca0")
    @Override
    public void setInActivity(Activity value) {
        appendDepVal(((ActivityGroupSmClass)getClassOf()).getInActivityDep(), (SmObjectImpl)value);
    }

    @objid ("6516d739-622d-4d69-bbfd-31e0516bfc13")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // InActivity
        obj = (SmObjectImpl)this.getDepVal(((ActivityGroupSmClass)getClassOf()).getInActivityDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("74b8f08f-f775-4503-a12a-f768158e0c3f")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // InActivity
        dep = ((ActivityGroupSmClass)getClassOf()).getInActivityDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("9c7ee4a0-adfb-422c-9b78-e5ffae148c2f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityGroup(this);
    }

}
