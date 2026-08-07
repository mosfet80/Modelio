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
import org.modelio.metamodel.impl.uml.infrastructure.ElementImpl;
import org.modelio.metamodel.uml.behavior.interactionModel.GeneralOrdering;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004610d6-c4bf-1fd8-97fe-001ec947cd2a")
public class GeneralOrderingImpl extends ElementImpl implements GeneralOrdering {
    @objid ("3d9a2cd9-4da4-4159-9507-ca14f62d49a6")
    @Override
    public OccurrenceSpecification getBefore() {
        Object obj = getDepVal(((GeneralOrderingSmClass)getClassOf()).getBeforeDep());
        return (obj instanceof OccurrenceSpecification)? (OccurrenceSpecification)obj : null;
    }

    @objid ("0ebe41ba-cd26-439c-b93f-03cf79db7def")
    @Override
    public void setBefore(OccurrenceSpecification value) {
        appendDepVal(((GeneralOrderingSmClass)getClassOf()).getBeforeDep(), (SmObjectImpl)value);
    }

    @objid ("e0719aac-31fa-4bac-b1d7-5ba4f82f03ed")
    @Override
    public OccurrenceSpecification getAfter() {
        Object obj = getDepVal(((GeneralOrderingSmClass)getClassOf()).getAfterDep());
        return (obj instanceof OccurrenceSpecification)? (OccurrenceSpecification)obj : null;
    }

    @objid ("d1c2f0af-c663-4dde-aed9-7ab8ac42b093")
    @Override
    public void setAfter(OccurrenceSpecification value) {
        appendDepVal(((GeneralOrderingSmClass)getClassOf()).getAfterDep(), (SmObjectImpl)value);
    }

    @objid ("62b2063d-5d30-4492-af7a-a64f1a644a4b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Before
        obj = (SmObjectImpl)this.getDepVal(((GeneralOrderingSmClass)getClassOf()).getBeforeDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("aa52eb25-de92-41fc-86ac-a90cb44f207e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Before
        dep = ((GeneralOrderingSmClass)getClassOf()).getBeforeDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("75436812-b562-41c1-97e3-7c459c47f700")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IModelVisitor)
          return accept((IModelVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("735bb61c-9f26-49fb-9fd0-33e2c64078a9")
    public Object accept(IModelVisitor v) {
        return v.visitGeneralOrdering(this);
    }

}
