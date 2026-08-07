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
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000a7e90-c4bf-1fd8-97fe-001ec947cd2a")
public class EnumerationLiteralImpl extends UmlModelElementImpl implements EnumerationLiteral {
    @objid ("6d2d733a-b748-457c-9ff6-649361a94cb2")
    @Override
    public Enumeration getValuated() {
        Object obj = getDepVal(((EnumerationLiteralSmClass)getClassOf()).getValuatedDep());
        return (obj instanceof Enumeration)? (Enumeration)obj : null;
    }

    @objid ("96e8703f-e762-4e40-8d11-262c7e181ddd")
    @Override
    public void setValuated(Enumeration value) {
        appendDepVal(((EnumerationLiteralSmClass)getClassOf()).getValuatedDep(), (SmObjectImpl)value);
    }

    @objid ("cdd2003e-4802-42b6-9c6a-81b8a6f4e06e")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Valuated
        obj = (SmObjectImpl)this.getDepVal(((EnumerationLiteralSmClass)getClassOf()).getValuatedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c455f088-cb40-4e75-b2c9-8ff43423c3fa")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Valuated
        dep = ((EnumerationLiteralSmClass)getClassOf()).getValuatedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("ebdb1a18-e3cf-45c3-b8db-be97450c0e9a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitEnumerationLiteral(this);
    }

}
