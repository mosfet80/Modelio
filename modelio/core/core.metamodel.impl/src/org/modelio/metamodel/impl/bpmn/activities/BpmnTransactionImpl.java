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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnTransaction;
import org.modelio.metamodel.bpmn.activities.TransactionMethod;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0085963e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTransactionImpl extends BpmnSubProcessImpl implements BpmnTransaction {
    @objid ("bec385ab-21fe-4d1c-8a5b-9b6b3d30330f")
    @Override
    public TransactionMethod getMethod() {
        return (TransactionMethod) getAttVal(((BpmnTransactionSmClass)getClassOf()).getMethodAtt());
    }

    @objid ("c4d3393e-81ea-48c4-b246-b2c3d98befac")
    @Override
    public void setMethod(TransactionMethod value) {
        setAttVal(((BpmnTransactionSmClass)getClassOf()).getMethodAtt(), value);
    }

    @objid ("96536882-a2c8-4838-9d90-e12a23dfc538")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("14688cd1-4eaf-46e0-9c50-f5bf1a1ce0ee")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("a4c03065-4951-43af-89df-6ca2fa381085")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnTransaction(this);
    }

}
