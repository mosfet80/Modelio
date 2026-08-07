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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.GeneralOrdering;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004a871a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class OccurrenceSpecificationImpl extends InteractionFragmentImpl implements OccurrenceSpecification {
    @objid ("62e97d8f-f0ea-4574-847a-b873934f0140")
    @Override
    public EList<GeneralOrdering> getToAfter() {
        return new SmList<>(this, ((OccurrenceSpecificationSmClass)getClassOf()).getToAfterDep());
    }

    @objid ("a96766fb-7000-486b-a0c0-7bcd3772fc29")
    @Override
    public <T extends GeneralOrdering> List<T> getToAfter(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final GeneralOrdering element : getToAfter()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("eaa1777e-a484-4809-854a-66fe91482ee4")
    @Override
    public EList<GeneralOrdering> getToBefore() {
        return new SmList<>(this, ((OccurrenceSpecificationSmClass)getClassOf()).getToBeforeDep());
    }

    @objid ("2e583cf9-a281-49b3-9d1e-3df9683cdfd6")
    @Override
    public <T extends GeneralOrdering> List<T> getToBefore(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final GeneralOrdering element : getToBefore()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4aab25f9-622d-4768-a51c-d71f398d9f56")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("d0c80870-c18d-4e26-b8ac-d5da9e5f2e7e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4dceb97b-4d92-4180-b236-3aa4ae186c8e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitOccurrenceSpecification(this);
    }

}
