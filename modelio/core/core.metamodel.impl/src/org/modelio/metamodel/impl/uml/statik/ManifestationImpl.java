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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Artifact;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0010c444-c4bf-1fd8-97fe-001ec947cd2a")
public class ManifestationImpl extends UmlModelElementImpl implements Manifestation {
    @objid ("4e8186f5-72c1-4ac8-94e8-b0d66dbfd421")
    @Override
    public UmlModelElement getUtilizedElement() {
        Object obj = getDepVal(((ManifestationSmClass)getClassOf()).getUtilizedElementDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("c0dcc15a-cd63-49ad-8cfa-c4d2f00c0148")
    @Override
    public void setUtilizedElement(UmlModelElement value) {
        appendDepVal(((ManifestationSmClass)getClassOf()).getUtilizedElementDep(), (SmObjectImpl)value);
    }

    @objid ("f5442bfe-bc89-4ed3-b998-28987583e225")
    @Override
    public Artifact getOwner() {
        Object obj = getDepVal(((ManifestationSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Artifact)? (Artifact)obj : null;
    }

    @objid ("e9ef0372-6bbc-4263-bfec-a276f031e656")
    @Override
    public void setOwner(Artifact value) {
        appendDepVal(((ManifestationSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("34ce4cb5-7142-4cf3-a0a2-db87bf603a6a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((ManifestationSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("af350e53-e5a1-4be4-a51a-31a8e889570e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((ManifestationSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("0508d5e6-9c5c-4c21-ac75-c30fef205541")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitManifestation(this);
    }

}
