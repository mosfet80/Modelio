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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00473c54-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class InteractionFragmentImpl extends UmlModelElementImpl implements InteractionFragment {
    @objid ("076dd329-3525-4d1e-8d59-278d7b5dfe49")
    @Override
    public int getLineNumber() {
        return (Integer) getAttVal(((InteractionFragmentSmClass)getClassOf()).getLineNumberAtt());
    }

    @objid ("0dcabd4b-4006-4fc4-bc36-4e2c54b57bf7")
    @Override
    public void setLineNumber(int value) {
        setAttVal(((InteractionFragmentSmClass)getClassOf()).getLineNumberAtt(), value);
    }

    @objid ("3689587c-d9f8-45a1-a3a9-8e74ead3ec56")
    @Override
    public InteractionOperand getEnclosingOperand() {
        Object obj = getDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingOperandDep());
        return (obj instanceof InteractionOperand)? (InteractionOperand)obj : null;
    }

    @objid ("75fd5c76-b0ee-4efa-8371-47f1a4a474c1")
    @Override
    public void setEnclosingOperand(InteractionOperand value) {
        appendDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingOperandDep(), (SmObjectImpl)value);
    }

    @objid ("4d758b78-ddb0-480b-9a2b-dd2626d81c28")
    @Override
    public Interaction getEnclosingInteraction() {
        Object obj = getDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingInteractionDep());
        return (obj instanceof Interaction)? (Interaction)obj : null;
    }

    @objid ("e3696fbd-5884-4151-9fb0-c050e4a7e499")
    @Override
    public void setEnclosingInteraction(Interaction value) {
        appendDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingInteractionDep(), (SmObjectImpl)value);
    }

    @objid ("98a6cacb-6be0-4bf1-a47f-933a4ec3b264")
    @Override
    public EList<Lifeline> getCovered() {
        return new SmList<>(this, ((InteractionFragmentSmClass)getClassOf()).getCoveredDep());
    }

    @objid ("62b5448e-1585-4ae1-b428-d285909d1d88")
    @Override
    public <T extends Lifeline> List<T> getCovered(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Lifeline element : getCovered()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7cfb490c-5e65-4392-872d-0806a9a6bcf5")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // EnclosingOperand
        obj = (SmObjectImpl)this.getDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingOperandDep());
        if (obj != null)
          return obj;
        // EnclosingInteraction
        obj = (SmObjectImpl)this.getDepVal(((InteractionFragmentSmClass)getClassOf()).getEnclosingInteractionDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("658008b0-57f4-4f08-9de2-c43e6b114c12")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // EnclosingOperand
        dep = ((InteractionFragmentSmClass)getClassOf()).getEnclosingOperandDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // EnclosingInteraction
        dep = ((InteractionFragmentSmClass)getClassOf()).getEnclosingInteractionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("cf52bacc-1de5-4322-9e92-9e2e2a945a12")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInteractionFragment(this);
    }

}
