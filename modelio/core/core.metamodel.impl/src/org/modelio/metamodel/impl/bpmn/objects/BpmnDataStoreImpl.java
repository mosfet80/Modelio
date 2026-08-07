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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.objects.BpmnDataStore;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00041136-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataStoreImpl extends BpmnItemAwareElementImpl implements BpmnDataStore {
    @objid ("02679fb4-0c2e-44b2-b0b1-2c2b6ac3a8ab")
    @Override
    public int getCapacity() {
        return (Integer) getAttVal(((BpmnDataStoreSmClass)getClassOf()).getCapacityAtt());
    }

    @objid ("db33250d-c9b8-4d5d-8626-cb295d2ad393")
    @Override
    public void setCapacity(int value) {
        setAttVal(((BpmnDataStoreSmClass)getClassOf()).getCapacityAtt(), value);
    }

    @objid ("f81ee789-0c5e-41da-a7ca-a68aecb2b01f")
    @Override
    public boolean isIsUnlimited() {
        return (Boolean) getAttVal(((BpmnDataStoreSmClass)getClassOf()).getIsUnlimitedAtt());
    }

    @objid ("c3170be5-a0e6-4f2c-8999-6ccc3ff69d97")
    @Override
    public void setIsUnlimited(boolean value) {
        setAttVal(((BpmnDataStoreSmClass)getClassOf()).getIsUnlimitedAtt(), value);
    }

    @objid ("44f3fcb2-d928-4ee3-8690-3b22a2544df6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("f8c1c731-75d5-438c-8c90-8eda11db8246")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("b38fc150-0137-456c-bfc9-2f3f89b605d5")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataStore(this);
    }

}
