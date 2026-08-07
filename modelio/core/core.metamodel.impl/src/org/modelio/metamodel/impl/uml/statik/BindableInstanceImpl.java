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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0000df02-c4bf-1fd8-97fe-001ec947cd2a")
public class BindableInstanceImpl extends InstanceImpl implements BindableInstance {
    @objid ("f38ecc93-1eb9-4d9f-858c-240a8992ba70")
    @Override
    public Instance getCluster() {
        Object obj = getDepVal(((BindableInstanceSmClass)getClassOf()).getClusterDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("270f2db1-8a63-4d65-8f5c-6096fa0ce961")
    @Override
    public void setCluster(Instance value) {
        appendDepVal(((BindableInstanceSmClass)getClassOf()).getClusterDep(), (SmObjectImpl)value);
    }

    @objid ("3aa7662d-bb2f-494e-b787-724ed0f812c8")
    @Override
    public Classifier getInternalOwner() {
        Object obj = getDepVal(((BindableInstanceSmClass)getClassOf()).getInternalOwnerDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("86ee8002-687f-4e02-a478-b8101750fa4e")
    @Override
    public void setInternalOwner(Classifier value) {
        appendDepVal(((BindableInstanceSmClass)getClassOf()).getInternalOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("a5f2cf23-14b3-4678-93fb-037ecd7e6bc1")
    @Override
    public EList<Binding> getRepresentation() {
        return new SmList<>(this, ((BindableInstanceSmClass)getClassOf()).getRepresentationDep());
    }

    @objid ("6d4904d1-c442-4ee7-a860-a9578e5f1d7c")
    @Override
    public <T extends Binding> List<T> getRepresentation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Binding element : getRepresentation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c5f499e5-aa0d-4a33-8ee2-4b40746a7fc1")
    @Override
    public UmlModelElement getRepresentedFeature() {
        Object obj = getDepVal(((BindableInstanceSmClass)getClassOf()).getRepresentedFeatureDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("16a147a2-92f5-467a-8c8b-0dcfa99bc431")
    @Override
    public void setRepresentedFeature(UmlModelElement value) {
        appendDepVal(((BindableInstanceSmClass)getClassOf()).getRepresentedFeatureDep(), (SmObjectImpl)value);
    }

    @objid ("9b922717-79da-411e-b0ed-b00de505930b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Cluster
        obj = (SmObjectImpl)this.getDepVal(((BindableInstanceSmClass)getClassOf()).getClusterDep());
        if (obj != null)
          return obj;
        // InternalOwner
        obj = (SmObjectImpl)this.getDepVal(((BindableInstanceSmClass)getClassOf()).getInternalOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("088d61a9-0ed8-40e2-869d-ec78286f6bfc")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Cluster
        dep = ((BindableInstanceSmClass)getClassOf()).getClusterDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // InternalOwner
        dep = ((BindableInstanceSmClass)getClassOf()).getInternalOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("c5f799b7-5dcc-432a-b938-93dc8204ee55")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBindableInstance(this);
    }

}
