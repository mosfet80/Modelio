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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.PartDecomposition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004b1612-c4bf-1fd8-97fe-001ec947cd2a")
public class PartDecompositionImpl extends InteractionUseImpl implements PartDecomposition {
    @objid ("0430fe66-efda-4978-bc78-530eeaa8c68b")
    @Override
    public Lifeline getDecomposed() {
        Object obj = getDepVal(((PartDecompositionSmClass)getClassOf()).getDecomposedDep());
        return (obj instanceof Lifeline)? (Lifeline)obj : null;
    }

    @objid ("b35bb432-1740-4fb4-8cf1-385dd0d22679")
    @Override
    public void setDecomposed(Lifeline value) {
        appendDepVal(((PartDecompositionSmClass)getClassOf()).getDecomposedDep(), (SmObjectImpl)value);
    }

    @objid ("5f2e6ca0-f838-43b9-ac61-7483c05cb48a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Decomposed
        obj = (SmObjectImpl)this.getDepVal(((PartDecompositionSmClass)getClassOf()).getDecomposedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("12c14ba9-12ee-45cf-860f-65e632c2b402")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Decomposed
        dep = ((PartDecompositionSmClass)getClassOf()).getDecomposedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("cb1407f4-2a0e-4baa-9d4a-f092da4dc12c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPartDecomposition(this);
    }

}
