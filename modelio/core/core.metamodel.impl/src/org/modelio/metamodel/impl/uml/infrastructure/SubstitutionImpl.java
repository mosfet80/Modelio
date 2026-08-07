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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.Substitution;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008e0fa8-c4be-1fd8-97fe-001ec947cd2a")
public class SubstitutionImpl extends UmlModelElementImpl implements Substitution {
    @objid ("fd2a74c4-e8e4-4ae3-bf7b-41bc5377aa7f")
    @Override
    public Classifier getContract() {
        Object obj = getDepVal(((SubstitutionSmClass)getClassOf()).getContractDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("a0defe50-b062-4ee5-9413-67a57aa264bf")
    @Override
    public void setContract(Classifier value) {
        appendDepVal(((SubstitutionSmClass)getClassOf()).getContractDep(), (SmObjectImpl)value);
    }

    @objid ("8ba763cb-bdcc-4ecd-a384-1c998a094a8b")
    @Override
    public Classifier getSubstitutingClassifier() {
        Object obj = getDepVal(((SubstitutionSmClass)getClassOf()).getSubstitutingClassifierDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("d97e6727-9f30-44f7-a337-c100ac937e00")
    @Override
    public void setSubstitutingClassifier(Classifier value) {
        appendDepVal(((SubstitutionSmClass)getClassOf()).getSubstitutingClassifierDep(), (SmObjectImpl)value);
    }

    @objid ("f57f3318-8553-47d2-a6fc-31fe240d87af")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SubstitutingClassifier
        obj = (SmObjectImpl)this.getDepVal(((SubstitutionSmClass)getClassOf()).getSubstitutingClassifierDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("f3406265-5bfb-4149-8087-432ba092c473")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SubstitutingClassifier
        dep = ((SubstitutionSmClass)getClassOf()).getSubstitutingClassifierDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3917f576-00bc-4086-a38a-9b682042c6e4")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitSubstitution(this);
    }

}
