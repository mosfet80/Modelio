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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptChangeEventAction;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0024ba8a-c4bf-1fd8-97fe-001ec947cd2a")
public class AcceptChangeEventActionImpl extends ActivityActionImpl implements AcceptChangeEventAction {
    @objid ("52d1b603-1af5-4d59-9afa-bef5e003c223")
    @Override
    public String getChangeExpresion() {
        return (String) getAttVal(((AcceptChangeEventActionSmClass)getClassOf()).getChangeExpresionAtt());
    }

    @objid ("aff083ec-be4d-496b-865c-59e70f04fa7b")
    @Override
    public void setChangeExpresion(String value) {
        setAttVal(((AcceptChangeEventActionSmClass)getClassOf()).getChangeExpresionAtt(), value);
    }

    @objid ("ba7fcc49-482d-4015-bdaa-ea2637687d78")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("a9cb9a0c-0e2b-45b7-84c3-3a30d1108786")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("ea3287aa-c2c9-452c-bee5-4d3fd9a104d4")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAcceptChangeEventAction(this);
    }

}
