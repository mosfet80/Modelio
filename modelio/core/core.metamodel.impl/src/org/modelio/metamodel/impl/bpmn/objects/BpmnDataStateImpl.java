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
import org.modelio.metamodel.bpmn.objects.BpmnDataState;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00087bf4-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataStateImpl extends BpmnBaseElementImpl implements BpmnDataState {
    @objid ("8f6d8180-8966-449a-9184-046b9faa93ac")
    @Override
    public BpmnItemAwareElement getItem() {
        Object obj = getDepVal(((BpmnDataStateSmClass)getClassOf()).getItemDep());
        return (obj instanceof BpmnItemAwareElement)? (BpmnItemAwareElement)obj : null;
    }

    @objid ("717d51fc-f1b5-4a4e-9467-7413f7b7a494")
    @Override
    public void setItem(BpmnItemAwareElement value) {
        appendDepVal(((BpmnDataStateSmClass)getClassOf()).getItemDep(), (SmObjectImpl)value);
    }

    @objid ("be324712-abde-4943-88c0-a8123d4f413c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Item
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataStateSmClass)getClassOf()).getItemDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("44bd5209-4a49-485c-ba97-e1163291dc07")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Item
        dep = ((BpmnDataStateSmClass)getClassOf()).getItemDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("8a4c7699-c00d-4001-91fe-ab2d101e1cc3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataState(this);
    }

}
