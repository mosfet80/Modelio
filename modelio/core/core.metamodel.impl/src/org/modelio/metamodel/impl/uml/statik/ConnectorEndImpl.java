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
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0006c57a-c4bf-1fd8-97fe-001ec947cd2a")
public class ConnectorEndImpl extends LinkEndImpl implements ConnectorEnd {
    @objid ("3d028e16-1ba4-45b9-a263-70e32c642679")
    @Override
    public EList<Binding> getRepresentation() {
        return new SmList<>(this, ((ConnectorEndSmClass)getClassOf()).getRepresentationDep());
    }

    @objid ("39494634-21c8-483a-affe-09e248f16bac")
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

    @objid ("6dfac6c3-0ebf-4836-9939-ef9cb26f17f5")
    @Override
    public UmlModelElement getRepresentedFeature() {
        Object obj = getDepVal(((ConnectorEndSmClass)getClassOf()).getRepresentedFeatureDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("c3778ac2-054e-4dd5-b86c-57df464c6cfd")
    @Override
    public void setRepresentedFeature(UmlModelElement value) {
        appendDepVal(((ConnectorEndSmClass)getClassOf()).getRepresentedFeatureDep(), (SmObjectImpl)value);
    }

    @objid ("4715cb8c-efe0-40e1-9736-404af2816d6a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("c47a422d-0627-4d8b-91af-c67d23b716e6")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("1d81c0bf-bb4e-4165-b35f-1a3943e2b89e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitConnectorEnd(this);
    }

}
