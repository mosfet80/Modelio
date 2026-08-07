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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Component;
import org.modelio.metamodel.uml.statik.ComponentRealization;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("ea0e67c5-5b02-447c-aae3-d3ef908c1f2a")
public class ComponentRealizationImpl extends UmlModelElementImpl implements ComponentRealization {
    @objid ("5b6d5fcf-18c2-4940-913f-bc27a860e1c1")
    @Override
    public Classifier getRealizingClassifier() {
        Object obj = getDepVal(((ComponentRealizationSmClass)getClassOf()).getRealizingClassifierDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("01bbfae6-6307-4b08-85b9-67d9cd428858")
    @Override
    public void setRealizingClassifier(Classifier value) {
        appendDepVal(((ComponentRealizationSmClass)getClassOf()).getRealizingClassifierDep(), (SmObjectImpl)value);
    }

    @objid ("bd31142a-67cd-4282-9a59-4412e788bd7b")
    @Override
    public Component getAbstraction() {
        Object obj = getDepVal(((ComponentRealizationSmClass)getClassOf()).getAbstractionDep());
        return (obj instanceof Component)? (Component)obj : null;
    }

    @objid ("f0c7eb31-9e5f-46e0-bdb8-b4425731e101")
    @Override
    public void setAbstraction(Component value) {
        appendDepVal(((ComponentRealizationSmClass)getClassOf()).getAbstractionDep(), (SmObjectImpl)value);
    }

    @objid ("51dfe746-d1d4-4287-9de6-2c366b7343be")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Abstraction
        obj = (SmObjectImpl)this.getDepVal(((ComponentRealizationSmClass)getClassOf()).getAbstractionDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("b2d3eca4-dc17-494e-a413-a146bd8702d3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Abstraction
        dep = ((ComponentRealizationSmClass)getClassOf()).getAbstractionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("a27f9bbb-90b5-4dc7-b965-6f606d3730f0")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitComponentRealization(this);
    }

}
