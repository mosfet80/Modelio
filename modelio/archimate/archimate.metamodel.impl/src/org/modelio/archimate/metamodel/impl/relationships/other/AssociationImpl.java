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
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.impl.relationships.dependency.DependencyRelationshipImpl;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("3390c829-0630-4bd2-b98f-e8bbe9f96827")
public class AssociationImpl extends DependencyRelationshipImpl implements Association {
    @objid ("c433d191-d3a8-4836-8734-cb7b0642beba")
    @Override
    public boolean isDirected() {
        return (Boolean) getAttVal(((AssociationSmClass)getClassOf()).getDirectedAtt());
    }

    @objid ("d40f4478-5655-4186-9714-69e4d8741036")
    @Override
    public void setDirected(boolean value) {
        setAttVal(((AssociationSmClass)getClassOf()).getDirectedAtt(), value);
    }

    @objid ("fcfeafe2-e5a7-4bbe-9027-56db6d23fd35")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("8036b97b-9acf-4ff8-ad65-949ea4954e39")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("1f21585a-d010-4641-baeb-47719dd0fddd")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitAssociation(this);
    }

}
