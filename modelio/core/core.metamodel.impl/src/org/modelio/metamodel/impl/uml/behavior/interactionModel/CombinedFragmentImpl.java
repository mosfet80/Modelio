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
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperator;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00437f1a-c4bf-1fd8-97fe-001ec947cd2a")
public class CombinedFragmentImpl extends InteractionFragmentImpl implements CombinedFragment {
    @objid ("e45b1ca0-c2b7-42ad-a045-39f94564fa3b")
    @Override
    public InteractionOperator getOperator() {
        return (InteractionOperator) getAttVal(((CombinedFragmentSmClass)getClassOf()).getOperatorAtt());
    }

    @objid ("eeff89b6-ac58-40df-ae43-4af5d69157fb")
    @Override
    public void setOperator(InteractionOperator value) {
        setAttVal(((CombinedFragmentSmClass)getClassOf()).getOperatorAtt(), value);
    }

    @objid ("00986feb-d0d9-4842-a974-75ded5159567")
    @Override
    public EList<InteractionOperand> getOperand() {
        return new SmList<>(this, ((CombinedFragmentSmClass)getClassOf()).getOperandDep());
    }

    @objid ("ecb47a03-1f93-4e9e-ae09-0538931a3532")
    @Override
    public <T extends InteractionOperand> List<T> getOperand(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InteractionOperand element : getOperand()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0e2a57c8-31e1-4100-8594-0049e92686e7")
    @Override
    public EList<Gate> getFragmentGate() {
        return new SmList<>(this, ((CombinedFragmentSmClass)getClassOf()).getFragmentGateDep());
    }

    @objid ("09eb9f4e-3187-4c19-88c9-9a525f5a479f")
    @Override
    public <T extends Gate> List<T> getFragmentGate(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Gate element : getFragmentGate()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("41efd6a8-56b1-4209-9eed-6e5aa3b4c5aa")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("b1cae9fa-3083-423d-9698-1fb253ae2a69")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c0d9e5dc-acac-46e6-bece-a7ebe88b5089")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCombinedFragment(this);
    }

}
