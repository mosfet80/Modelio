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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00485742-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionUseImpl extends InteractionFragmentImpl implements InteractionUse {
    @objid ("ebf20aa5-35f6-4fd9-8871-526de83f16e7")
    @Override
    public int getEndLineNumber() {
        return (Integer) getAttVal(((InteractionUseSmClass)getClassOf()).getEndLineNumberAtt());
    }

    @objid ("654d55c4-6a13-4d3c-85bf-12664897817a")
    @Override
    public void setEndLineNumber(int value) {
        setAttVal(((InteractionUseSmClass)getClassOf()).getEndLineNumberAtt(), value);
    }

    @objid ("271130ce-576c-4f7a-82f9-c6070dc63d76")
    @Override
    public EList<Gate> getActualGate() {
        return new SmList<>(this, ((InteractionUseSmClass)getClassOf()).getActualGateDep());
    }

    @objid ("069bc342-53e9-4be5-bf0e-27e5c8d64f53")
    @Override
    public <T extends Gate> List<T> getActualGate(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Gate element : getActualGate()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0c042231-7f67-47e9-b438-972034c450c8")
    @Override
    public Interaction getRefersTo() {
        Object obj = getDepVal(((InteractionUseSmClass)getClassOf()).getRefersToDep());
        return (obj instanceof Interaction)? (Interaction)obj : null;
    }

    @objid ("9fb9d2ff-5122-4f5f-b6f7-8f97d86fb83a")
    @Override
    public void setRefersTo(Interaction value) {
        appendDepVal(((InteractionUseSmClass)getClassOf()).getRefersToDep(), (SmObjectImpl)value);
    }

    @objid ("fd96d0c5-4412-4648-ba2d-cc4df1db5b7c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("54ccd3d3-8ffd-416f-8002-e5b89bc29d37")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("615e7aed-d984-4598-a3d9-9e8d59067d0e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInteractionUse(this);
    }

}
