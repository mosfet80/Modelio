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
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00060c52-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryConnectorImpl extends NaryLinkImpl implements NaryConnector {
    @objid ("1ca3e577-68e9-42b6-a563-ac4e1c19fbc1")
    @Override
    public EList<Binding> getRepresentation() {
        return new SmList<>(this, ((NaryConnectorSmClass)getClassOf()).getRepresentationDep());
    }

    @objid ("5f6cf81a-10af-4bd8-8be4-08c6009a1484")
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

    @objid ("4de79a94-e28e-400b-89ee-7a13a20405bd")
    @Override
    public UmlModelElement getRepresentedFeature() {
        Object obj = getDepVal(((NaryConnectorSmClass)getClassOf()).getRepresentedFeatureDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("a1e7b55c-e95a-4b12-b6a5-e134cff6f145")
    @Override
    public void setRepresentedFeature(UmlModelElement value) {
        appendDepVal(((NaryConnectorSmClass)getClassOf()).getRepresentedFeatureDep(), (SmObjectImpl)value);
    }

    @objid ("a0be50a4-c1f0-410a-bc84-a18573e7996c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("9019a63d-d1cc-4133-9323-328a0480c513")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4365ce93-ec9f-4935-8065-6b32bffeeb90")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNaryConnector(this);
    }

}
