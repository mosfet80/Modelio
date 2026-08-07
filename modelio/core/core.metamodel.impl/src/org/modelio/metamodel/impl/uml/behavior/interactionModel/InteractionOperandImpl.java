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
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0047c124-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionOperandImpl extends InteractionFragmentImpl implements InteractionOperand {
    @objid ("33c26222-eb8e-4db7-a66b-20a345a125a3")
    @Override
    public String getGuard() {
        return (String) getAttVal(((InteractionOperandSmClass)getClassOf()).getGuardAtt());
    }

    @objid ("a57bdaf5-0b7e-491d-982e-a60ec86e24d5")
    @Override
    public void setGuard(String value) {
        setAttVal(((InteractionOperandSmClass)getClassOf()).getGuardAtt(), value);
    }

    @objid ("60ed6bdb-efa0-473a-8b41-d4c684ec079e")
    @Override
    public int getEndLineNumber() {
        return (Integer) getAttVal(((InteractionOperandSmClass)getClassOf()).getEndLineNumberAtt());
    }

    @objid ("938bbcd5-2610-4a47-9bf0-c70bd793b8ce")
    @Override
    public void setEndLineNumber(int value) {
        setAttVal(((InteractionOperandSmClass)getClassOf()).getEndLineNumberAtt(), value);
    }

    @objid ("b908896e-8d56-4918-8c5b-8bbc38108569")
    @Override
    public EList<InteractionFragment> getFragment() {
        return new SmList<>(this, ((InteractionOperandSmClass)getClassOf()).getFragmentDep());
    }

    @objid ("243eb0d3-e092-4197-bc54-5d3dd65b91bd")
    @Override
    public <T extends InteractionFragment> List<T> getFragment(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InteractionFragment element : getFragment()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("8e60a4e9-eb35-4155-a6a0-e971f1566421")
    @Override
    public CombinedFragment getOwnerFragment() {
        Object obj = getDepVal(((InteractionOperandSmClass)getClassOf()).getOwnerFragmentDep());
        return (obj instanceof CombinedFragment)? (CombinedFragment)obj : null;
    }

    @objid ("c2cf1b5d-eb26-42e4-aa24-95154514103c")
    @Override
    public void setOwnerFragment(CombinedFragment value) {
        appendDepVal(((InteractionOperandSmClass)getClassOf()).getOwnerFragmentDep(), (SmObjectImpl)value);
    }

    @objid ("16ac8ab9-98d1-42b4-ac3d-83caa93b2370")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerFragment
        obj = (SmObjectImpl)this.getDepVal(((InteractionOperandSmClass)getClassOf()).getOwnerFragmentDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("abf9284a-ded7-4117-9e3a-0d3d08dedf99")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerFragment
        dep = ((InteractionOperandSmClass)getClassOf()).getOwnerFragmentDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b10748da-cdab-40af-bddf-79c3f4675602")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInteractionOperand(this);
    }

}
