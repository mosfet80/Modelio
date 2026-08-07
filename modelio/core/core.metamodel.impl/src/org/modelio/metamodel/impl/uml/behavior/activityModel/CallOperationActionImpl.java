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
import org.modelio.metamodel.uml.behavior.activityModel.CallOperationAction;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002bb01a-c4bf-1fd8-97fe-001ec947cd2a")
public class CallOperationActionImpl extends CallActionImpl implements CallOperationAction {
    @objid ("72d035f3-8863-4087-94c1-62fae6203a0f")
    @Override
    public Operation getCalled() {
        Object obj = getDepVal(((CallOperationActionSmClass)getClassOf()).getCalledDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("7e430098-84f8-4af9-9d74-f0d1a9df20b5")
    @Override
    public void setCalled(Operation value) {
        appendDepVal(((CallOperationActionSmClass)getClassOf()).getCalledDep(), (SmObjectImpl)value);
    }

    @objid ("24aaf250-6176-48f2-bc77-885840136684")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("b29aae2d-69f1-4ea1-9f97-0aa7144ff9c3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("47c734ca-0f01-4fff-ba32-b501e5fe025e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCallOperationAction(this);
    }

}
