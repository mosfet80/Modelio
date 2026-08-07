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
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0020dab4-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryAssociationEndImpl extends StructuralFeatureImpl implements NaryAssociationEnd {
    @objid ("eb12636b-8819-472c-871f-d30a4a2702b2")
    @Override
    public NaryAssociation getNaryAssociation() {
        Object obj = getDepVal(((NaryAssociationEndSmClass)getClassOf()).getNaryAssociationDep());
        return (obj instanceof NaryAssociation)? (NaryAssociation)obj : null;
    }

    @objid ("d8364689-ad6c-46e9-98c9-cf0919f51cda")
    @Override
    public void setNaryAssociation(NaryAssociation value) {
        appendDepVal(((NaryAssociationEndSmClass)getClassOf()).getNaryAssociationDep(), (SmObjectImpl)value);
    }

    @objid ("265cd457-210f-4e27-94e7-196380810fee")
    @Override
    public Classifier getOwner() {
        Object obj = getDepVal(((NaryAssociationEndSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("ee844c90-60d2-42b0-afa5-b9f3e2082c55")
    @Override
    public void setOwner(Classifier value) {
        appendDepVal(((NaryAssociationEndSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("7576d3b3-037e-4c83-9541-6c3fb5e2baf7")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((NaryAssociationEndSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        // NaryAssociation
        obj = (SmObjectImpl)this.getDepVal(((NaryAssociationEndSmClass)getClassOf()).getNaryAssociationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("292cd521-ba5d-4588-abcf-fb8f17106717")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((NaryAssociationEndSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // NaryAssociation
        dep = ((NaryAssociationEndSmClass)getClassOf()).getNaryAssociationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5821c029-eab3-4658-8305-54701b41718f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNaryAssociationEnd(this);
    }

}
