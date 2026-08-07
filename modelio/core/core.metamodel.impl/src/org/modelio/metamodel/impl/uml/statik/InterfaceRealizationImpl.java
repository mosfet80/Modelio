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
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000f221a-c4bf-1fd8-97fe-001ec947cd2a")
public class InterfaceRealizationImpl extends UmlModelElementImpl implements InterfaceRealization {
    @objid ("5cf031ad-c090-4db6-9a7a-78ed7243419a")
    @Override
    public Interface getImplemented() {
        Object obj = getDepVal(((InterfaceRealizationSmClass)getClassOf()).getImplementedDep());
        return (obj instanceof Interface)? (Interface)obj : null;
    }

    @objid ("4bb5beca-64e2-4a64-a975-584dd021a59a")
    @Override
    public void setImplemented(Interface value) {
        appendDepVal(((InterfaceRealizationSmClass)getClassOf()).getImplementedDep(), (SmObjectImpl)value);
    }

    @objid ("f24a8db4-9f0b-4d1a-9d05-aa6bcdcde253")
    @Override
    public NameSpace getImplementer() {
        Object obj = getDepVal(((InterfaceRealizationSmClass)getClassOf()).getImplementerDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("e5c338f9-7387-49a6-beb2-edb6b457dc3f")
    @Override
    public void setImplementer(NameSpace value) {
        appendDepVal(((InterfaceRealizationSmClass)getClassOf()).getImplementerDep(), (SmObjectImpl)value);
    }

    @objid ("51b2ab82-919c-453c-9b6a-477deac15d62")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Implementer
        obj = (SmObjectImpl)this.getDepVal(((InterfaceRealizationSmClass)getClassOf()).getImplementerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("71e1a669-8444-41db-ad06-37597726f95c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Implementer
        dep = ((InterfaceRealizationSmClass)getClassOf()).getImplementerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("38c33fd5-7c9c-4790-8280-f142fb79e4f0")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInterfaceRealization(this);
    }

}
