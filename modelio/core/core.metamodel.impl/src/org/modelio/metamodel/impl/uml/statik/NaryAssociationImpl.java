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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0021a61a-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryAssociationImpl extends UmlModelElementImpl implements NaryAssociation {
    @objid ("28d8131c-4eda-4e63-8e86-f2ed6bb86858")
    @Override
    public SmObjectImpl getCompositionOwner() {
        for (SmObjectImpl obj : this.getDepValList(((NaryAssociationSmClass) getClassOf()).getNaryEndDep())) {
            // Avoid infinite composition loops
            SmObjectImpl objOwner = obj.getCompositionOwner();
            if (objOwner != this && objOwner != null) {
                return obj;
            }
        }
        return super.getCompositionOwner();
    }

    @objid ("82e19039-824a-4fb9-95f0-47b803583c97")
    @Override
    public SmDepVal getCompositionRelation() {
        for (SmObjectImpl obj : this.getDepValList(((NaryAssociationSmClass) getClassOf()).getNaryEndDep())) {
            // Avoid infinite composition loops
            SmObjectImpl objOwner = obj.getCompositionOwner();
            if (objOwner != this && objOwner != null) {
                return new SmDepVal(((NaryAssociationSmClass) getClassOf()).getNaryEndDep(), obj);
            }
        }
        return super.getCompositionRelation();
    }

    @objid ("9fa0432b-1708-470d-9074-f9fc3d97fa0c")
    @Override
    public void afterEraseDepVal(SmDependency dep, SmObjectImpl value) {
        if (dep == ((NaryAssociationSmClass) getClassOf()).getNaryEndDep()) {
            // Workaround bug where the storage handle is not updated
            EList<NaryAssociationEnd> remainingOwners = getNaryEnd();
            if (!remainingOwners.isEmpty()) {
                // Remove and add again the first remaining owner.
                // Note : this will trigger recursively the removal & addition of all other owners.
                NaryAssociationEnd r = remainingOwners.get(0);
                r.setNaryAssociation(null);
                r.setNaryAssociation(this);
            }
        }

        super.afterEraseDepVal(dep, value);

    }

    @objid ("7a81efaa-c778-46d5-ae62-e2fabb4ad2f4")
    @Override
    public EList<NaryLink> getOccurence() {
        return new SmList<>(this, ((NaryAssociationSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("6efb80de-9b44-44f7-95bd-a8dae64543e6")
    @Override
    public <T extends NaryLink> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLink element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c7e1583e-967b-420f-bdc1-75d6a45ef417")
    @Override
    public EList<NaryAssociationEnd> getNaryEnd() {
        return new SmList<>(this, ((NaryAssociationSmClass)getClassOf()).getNaryEndDep());
    }

    @objid ("d08fd983-5881-4769-bd06-039d1eb2274d")
    @Override
    public <T extends NaryAssociationEnd> List<T> getNaryEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryAssociationEnd element : getNaryEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("29238b49-732e-4260-a41c-9a8f28b1ba7c")
    @Override
    public ClassAssociation getLinkToClass() {
        Object obj = getDepVal(((NaryAssociationSmClass)getClassOf()).getLinkToClassDep());
        return (obj instanceof ClassAssociation)? (ClassAssociation)obj : null;
    }

    @objid ("ea4b734d-84ab-42b7-b40d-6d1bde6e3739")
    @Override
    public void setLinkToClass(ClassAssociation value) {
        appendDepVal(((NaryAssociationSmClass)getClassOf()).getLinkToClassDep(), (SmObjectImpl)value);
    }

    @objid ("70f55b8b-d31f-4c65-bc9c-a104d50dceac")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNaryAssociation(this);
    }

}
