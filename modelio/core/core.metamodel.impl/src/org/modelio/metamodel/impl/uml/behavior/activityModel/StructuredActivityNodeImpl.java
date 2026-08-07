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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("003e347e-c4bf-1fd8-97fe-001ec947cd2a")
public class StructuredActivityNodeImpl extends ActivityActionImpl implements StructuredActivityNode {
    @objid ("9ed4b452-d41d-472e-8257-d8a4da1aca80")
    @Override
    public boolean isMustIsolate() {
        return (Boolean) getAttVal(((StructuredActivityNodeSmClass)getClassOf()).getMustIsolateAtt());
    }

    @objid ("3f214404-0461-41e5-ab86-f3953ac45af7")
    @Override
    public void setMustIsolate(boolean value) {
        setAttVal(((StructuredActivityNodeSmClass)getClassOf()).getMustIsolateAtt(), value);
    }

    @objid ("ca4bd5be-6d97-4ac1-8cce-829e51990821")
    @Override
    public EList<ActivityNode> getBody() {
        return new SmList<>(this, ((StructuredActivityNodeSmClass)getClassOf()).getBodyDep());
    }

    @objid ("5496b61e-4609-4440-a729-d7348a65e4b5")
    @Override
    public <T extends ActivityNode> List<T> getBody(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityNode element : getBody()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("64fa1087-8821-4eb4-9525-2abd3b20c052")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("85e23da7-8bb0-4c9e-9df7-6d32c8fcac7f")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("81d6a95c-c716-433e-a56b-55c10d13cd4b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitStructuredActivityNode(this);
    }

}
