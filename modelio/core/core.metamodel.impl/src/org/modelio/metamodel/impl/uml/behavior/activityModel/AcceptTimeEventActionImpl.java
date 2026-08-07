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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptTimeEventAction;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0025b188-c4bf-1fd8-97fe-001ec947cd2a")
public class AcceptTimeEventActionImpl extends ActivityActionImpl implements AcceptTimeEventAction {
    @objid ("d0c1dc01-fa90-4e1e-b745-c9f5c138175f")
    @Override
    public String getTimeExpresion() {
        return (String) getAttVal(((AcceptTimeEventActionSmClass)getClassOf()).getTimeExpresionAtt());
    }

    @objid ("728f294d-8179-4109-b129-1df6d23d51a0")
    @Override
    public void setTimeExpresion(String value) {
        setAttVal(((AcceptTimeEventActionSmClass)getClassOf()).getTimeExpresionAtt(), value);
    }

    @objid ("081c1d73-413b-4631-831a-322cf79da99d")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("17f0f6e7-70f1-4509-bc79-e722a128df4d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("0ee0842e-ec65-4134-9b6c-0ece1d776d42")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAcceptTimeEventAction(this);
    }

}
