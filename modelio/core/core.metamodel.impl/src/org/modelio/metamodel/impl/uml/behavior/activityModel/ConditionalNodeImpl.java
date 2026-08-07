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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.ConditionalNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002d81b0-c4bf-1fd8-97fe-001ec947cd2a")
public class ConditionalNodeImpl extends StructuredActivityNodeImpl implements ConditionalNode {
    @objid ("cb24e55e-d53e-4f3a-94db-f77d5282e2fb")
    @Override
    public boolean isIsDeterminate() {
        return (Boolean) getAttVal(((ConditionalNodeSmClass)getClassOf()).getIsDeterminateAtt());
    }

    @objid ("bd7a6fda-a5c4-4a67-bc64-2ab5d865e852")
    @Override
    public void setIsDeterminate(boolean value) {
        setAttVal(((ConditionalNodeSmClass)getClassOf()).getIsDeterminateAtt(), value);
    }

    @objid ("4be797bd-142d-455e-a481-1c2589e571e0")
    @Override
    public boolean isIsAssured() {
        return (Boolean) getAttVal(((ConditionalNodeSmClass)getClassOf()).getIsAssuredAtt());
    }

    @objid ("6106d981-d23c-44f7-8cda-0183cdf698a8")
    @Override
    public void setIsAssured(boolean value) {
        setAttVal(((ConditionalNodeSmClass)getClassOf()).getIsAssuredAtt(), value);
    }

    @objid ("8318dd76-9354-4a2a-8914-5f4a10dcd9fe")
    @Override
    public EList<Clause> getOwnedClause() {
        return new SmList<>(this, ((ConditionalNodeSmClass)getClassOf()).getOwnedClauseDep());
    }

    @objid ("84e815a6-1a9e-48e0-95a7-32fa26346bfe")
    @Override
    public <T extends Clause> List<T> getOwnedClause(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Clause element : getOwnedClause()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5dd354be-f45d-4e38-8303-802d8abeb035")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("d57b0fc3-741d-467f-9416-bc81fcaed29b")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("5249fc68-567c-47f9-81f6-d83c08e98f40")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitConditionalNode(this);
    }

}
