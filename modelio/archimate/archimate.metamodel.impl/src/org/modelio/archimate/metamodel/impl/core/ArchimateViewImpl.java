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
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.metamodel.impl.diagrams.AbstractDiagramImpl;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("f28fa0be-17d0-4064-9852-a3fec66caba5")
public class ArchimateViewImpl extends AbstractDiagramImpl implements ArchimateView {
    @objid ("a7610970-6fb1-4dab-9ce3-a19a887c1522")
    @Override
    public Model getContext() {
        Object obj = getDepVal(((ArchimateViewSmClass)getClassOf()).getContextDep());
        return (obj instanceof Model)? (Model)obj : null;
    }

    @objid ("38d8afc1-869e-49c9-8553-287f9f2b97c8")
    @Override
    public void setContext(Model value) {
        appendDepVal(((ArchimateViewSmClass)getClassOf()).getContextDep(), (SmObjectImpl)value);
    }

    @objid ("93a81274-0be7-4cb0-8c2b-bbfb6b59e68b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("11b4e3bd-3859-4f1d-82b1-1c7dd7db5df5")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("0f85efa9-5783-4233-9445-db951bc62975")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IArchimateVisitor)
          return accept((IArchimateVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("4b0b6dd2-bb79-413b-805a-c0b364806cbf")
    public Object accept(IArchimateVisitor v) {
        return v.visitArchimateView(this);
    }

}
