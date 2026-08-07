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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("4a17fb5e-dfe3-49f5-ae87-692f7d2d72d2")
public class RelationshipImpl extends ConceptImpl implements Relationship {
    @objid ("869dbb52-9265-4edd-bb2c-3a8f074982f3")
    @Override
    public Concept getTo() {
        Object obj = getDepVal(((RelationshipSmClass)getClassOf()).getToDep());
        return (obj instanceof Concept)? (Concept)obj : null;
    }

    @objid ("7e0654d1-94a2-4ea3-b400-547b78eebcd5")
    @Override
    public void setTo(Concept value) {
        appendDepVal(((RelationshipSmClass)getClassOf()).getToDep(), (SmObjectImpl)value);
    }

    @objid ("da15ecce-a028-4ee2-b8df-7c40dedcb76d")
    @Override
    public Concept getFrom() {
        Object obj = getDepVal(((RelationshipSmClass)getClassOf()).getFromDep());
        return (obj instanceof Concept)? (Concept)obj : null;
    }

    @objid ("7318dfaf-69a3-4ade-aa2c-26a1a5ffdda9")
    @Override
    public void setFrom(Concept value) {
        appendDepVal(((RelationshipSmClass)getClassOf()).getFromDep(), (SmObjectImpl)value);
    }

    @objid ("1ff0be6c-435a-4e50-8292-4df44de5bbec")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // from
        obj = (SmObjectImpl)this.getDepVal(((RelationshipSmClass)getClassOf()).getFromDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("66387db1-dd22-4dba-8e76-7242c0f48df7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // from
        dep = ((RelationshipSmClass)getClassOf()).getFromDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("4466ff76-8936-49ce-8b3d-d4aaaaf60713")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitRelationship(this);
    }

}
