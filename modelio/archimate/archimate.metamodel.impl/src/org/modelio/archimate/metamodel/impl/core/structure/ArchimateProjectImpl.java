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
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectImpl;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("01ed9036-92e2-435b-8cb5-e4f970aa03d9")
public class ArchimateProjectImpl extends AbstractProjectImpl implements ArchimateProject {
    @objid ("773d7a22-5991-4119-bbee-7b93f7a1397a")
    @Override
    public EList<Model> getModel() {
        return new SmList<>(this, ((ArchimateProjectSmClass)getClassOf()).getModelDep());
    }

    @objid ("c2b7cb75-93b8-4bcd-9685-36ab09bdea18")
    @Override
    public <T extends Model> List<T> getModel(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Model element : getModel()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c4c3ef58-9523-4c46-bfec-a253e0a962f8")
    @Override
    public EList<ViewPoint> getViewPoints() {
        return new SmList<>(this, ((ArchimateProjectSmClass)getClassOf()).getViewPointsDep());
    }

    @objid ("3e1d57f7-6ba9-4d77-bdf2-242daac416da")
    @Override
    public <T extends ViewPoint> List<T> getViewPoints(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ViewPoint element : getViewPoints()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ba7748b7-f0e7-40b7-8907-a10c73f04d5f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("e0cc639e-b058-419d-a2f9-42ef7bca5235")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("98008140-b121-4881-a261-916f78edd0f3")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IArchimateVisitor)
          return accept((IArchimateVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("9ed4f6d5-7f24-4d92-86ff-8b76223502ea")
    public Object accept(IArchimateVisitor v) {
        return v.visitArchimateProject(this);
    }

}
