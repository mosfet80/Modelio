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
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionKind;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionRegion;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0031ed18-c4bf-1fd8-97fe-001ec947cd2a")
public class ExpansionRegionImpl extends StructuredActivityNodeImpl implements ExpansionRegion {
    @objid ("fa9cbfab-27a7-47f0-81fc-17ced9c960d8")
    @Override
    public ExpansionKind getMode() {
        return (ExpansionKind) getAttVal(((ExpansionRegionSmClass)getClassOf()).getModeAtt());
    }

    @objid ("ebc15609-e99e-40b5-aa99-70236c76d867")
    @Override
    public void setMode(ExpansionKind value) {
        setAttVal(((ExpansionRegionSmClass)getClassOf()).getModeAtt(), value);
    }

    @objid ("f7a7cac6-f3c5-4eeb-b45b-40a40489aacb")
    @Override
    public EList<ExpansionNode> getOutputElement() {
        return new SmList<>(this, ((ExpansionRegionSmClass)getClassOf()).getOutputElementDep());
    }

    @objid ("760f9cef-1ba2-48f8-9214-52aa48993706")
    @Override
    public <T extends ExpansionNode> List<T> getOutputElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExpansionNode element : getOutputElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e98e8d7c-45bf-4b5b-86e6-49d14afe49ce")
    @Override
    public EList<ExpansionNode> getInputElement() {
        return new SmList<>(this, ((ExpansionRegionSmClass)getClassOf()).getInputElementDep());
    }

    @objid ("468bdc98-3092-47e9-aedb-967c3d5810c3")
    @Override
    public <T extends ExpansionNode> List<T> getInputElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExpansionNode element : getInputElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bf395e3d-b0fb-466b-9c05-2dc2d76aa2aa")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("7f12dc27-c6cb-4ea5-9f1b-2573431cb3dc")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4d8aa9e0-658a-4baf-a431-5fa3cb260272")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExpansionRegion(this);
    }

}
