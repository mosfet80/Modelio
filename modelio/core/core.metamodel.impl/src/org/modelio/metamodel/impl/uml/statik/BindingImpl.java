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
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000191ae-c4bf-1fd8-97fe-001ec947cd2a")
public class BindingImpl extends UmlModelElementImpl implements Binding {
    @objid ("5f51bcd2-ce92-46c9-bf37-42154d3a5e21")
    @Override
    public ConnectorEnd getConnectorEndRole() {
        Object obj = getDepVal(((BindingSmClass)getClassOf()).getConnectorEndRoleDep());
        return (obj instanceof ConnectorEnd)? (ConnectorEnd)obj : null;
    }

    @objid ("31c725a7-f372-42e2-93d5-4bbca7588637")
    @Override
    public void setConnectorEndRole(ConnectorEnd value) {
        appendDepVal(((BindingSmClass)getClassOf()).getConnectorEndRoleDep(), (SmObjectImpl)value);
    }

    @objid ("37851516-56ec-4b72-8e2d-2aa01c2ede90")
    @Override
    public NaryConnector getConnectorRole() {
        Object obj = getDepVal(((BindingSmClass)getClassOf()).getConnectorRoleDep());
        return (obj instanceof NaryConnector)? (NaryConnector)obj : null;
    }

    @objid ("133871e7-509f-4c3b-9011-25990708094e")
    @Override
    public void setConnectorRole(NaryConnector value) {
        appendDepVal(((BindingSmClass)getClassOf()).getConnectorRoleDep(), (SmObjectImpl)value);
    }

    @objid ("90151bcd-42c8-47e6-9623-ad968cb236ea")
    @Override
    public BindableInstance getRole() {
        Object obj = getDepVal(((BindingSmClass)getClassOf()).getRoleDep());
        return (obj instanceof BindableInstance)? (BindableInstance)obj : null;
    }

    @objid ("319c4a3e-a0bd-432c-9225-f9f22f0268ca")
    @Override
    public void setRole(BindableInstance value) {
        appendDepVal(((BindingSmClass)getClassOf()).getRoleDep(), (SmObjectImpl)value);
    }

    @objid ("b83f474d-77a1-4ae1-95df-b35eb5b4ab75")
    @Override
    public UmlModelElement getRepresentedFeature() {
        Object obj = getDepVal(((BindingSmClass)getClassOf()).getRepresentedFeatureDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("47efdf84-5c3e-4b26-a210-ce6605df7178")
    @Override
    public void setRepresentedFeature(UmlModelElement value) {
        appendDepVal(((BindingSmClass)getClassOf()).getRepresentedFeatureDep(), (SmObjectImpl)value);
    }

    @objid ("5f9395b6-ecc7-46d6-81db-982713276448")
    @Override
    public CollaborationUse getOwner() {
        Object obj = getDepVal(((BindingSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof CollaborationUse)? (CollaborationUse)obj : null;
    }

    @objid ("37dd2167-e57d-4214-9268-478ff526ab75")
    @Override
    public void setOwner(CollaborationUse value) {
        appendDepVal(((BindingSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("df9122f8-7ceb-47ef-bd6b-6f7b5808cd2b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((BindingSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("13f5abf5-4672-4bb6-840f-3d11193d974f")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((BindingSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("abe26e78-f44a-49ec-824e-740f5da081e3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBinding(this);
    }

}
