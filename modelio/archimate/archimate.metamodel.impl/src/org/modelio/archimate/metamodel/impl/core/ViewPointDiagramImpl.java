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
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
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

@objid ("c8223ccc-b888-4c8b-85d5-ce6e6491acaa")
public class ViewPointDiagramImpl extends AbstractDiagramImpl implements ViewPointDiagram {
    @objid ("dd8b1cbb-18de-4682-885a-837bcbef6863")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("1317387e-6e39-4b01-a256-4046aa6547a5")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("334ee6a1-4207-49b2-a676-7ce37e51c901")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IArchimateVisitor)
          return accept((IArchimateVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("35b795e3-fec6-4d6c-8124-6dedd0bd5f72")
    public Object accept(IArchimateVisitor v) {
        return v.visitViewPointDiagram(this);
    }

}
