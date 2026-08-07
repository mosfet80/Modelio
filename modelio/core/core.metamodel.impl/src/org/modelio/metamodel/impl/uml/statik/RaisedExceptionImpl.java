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
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("001ab350-c4bf-1fd8-97fe-001ec947cd2a")
public class RaisedExceptionImpl extends UmlModelElementImpl implements RaisedException {
    @objid ("cda0e6de-5516-4bee-be99-cdd4784a24bf")
    @Override
    public Classifier getThrownType() {
        Object obj = getDepVal(((RaisedExceptionSmClass)getClassOf()).getThrownTypeDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("3ee74545-b00a-4863-b7bf-d08bd34dec33")
    @Override
    public void setThrownType(Classifier value) {
        appendDepVal(((RaisedExceptionSmClass)getClassOf()).getThrownTypeDep(), (SmObjectImpl)value);
    }

    @objid ("83dd28ea-df43-4506-91b3-2c1a669f89fc")
    @Override
    public Operation getThrower() {
        Object obj = getDepVal(((RaisedExceptionSmClass)getClassOf()).getThrowerDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("00295f52-b7ff-4a75-937b-66a6d73e8f3f")
    @Override
    public void setThrower(Operation value) {
        appendDepVal(((RaisedExceptionSmClass)getClassOf()).getThrowerDep(), (SmObjectImpl)value);
    }

    @objid ("6aa5a553-d984-4059-ac88-ddbff9267b75")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Thrower
        obj = (SmObjectImpl)this.getDepVal(((RaisedExceptionSmClass)getClassOf()).getThrowerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("344329ef-09c2-4603-a2ad-53c52f4d8d0a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Thrower
        dep = ((RaisedExceptionSmClass)getClassOf()).getThrowerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("2c71ebbd-482f-499b-a60c-078fcf2af8ba")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitRaisedException(this);
    }

}
