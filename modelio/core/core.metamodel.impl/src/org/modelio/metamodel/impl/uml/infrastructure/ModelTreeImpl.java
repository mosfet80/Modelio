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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0089574c-c4be-1fd8-97fe-001ec947cd2a")
public abstract class ModelTreeImpl extends UmlModelElementImpl implements ModelTree {
    @objid ("059d4273-93ae-4d09-96b9-1d6a4cd3ae33")
    @Override
    public ModelTree getOwner() {
        Object obj = getDepVal(((ModelTreeSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof ModelTree)? (ModelTree)obj : null;
    }

    @objid ("1a6f7e28-55fb-4a3b-932d-e4b8bd653b1b")
    @Override
    public void setOwner(ModelTree value) {
        appendDepVal(((ModelTreeSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("de3b266d-3256-4e3a-85fb-20fca4306f56")
    @Override
    public EList<ModelTree> getOwnedElement() {
        return new SmList<>(this, ((ModelTreeSmClass)getClassOf()).getOwnedElementDep());
    }

    @objid ("155419d7-09c6-4071-89fc-b086816ede94")
    @Override
    public <T extends ModelTree> List<T> getOwnedElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ModelTree element : getOwnedElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2586b968-5f68-4ab5-8262-bcab3f454838")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((ModelTreeSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("70c7742e-c60b-4eed-98b1-bc705e41b426")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((ModelTreeSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("7390aae9-8107-4b21-9016-eadca004a184")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitModelTree(this);
    }

}
