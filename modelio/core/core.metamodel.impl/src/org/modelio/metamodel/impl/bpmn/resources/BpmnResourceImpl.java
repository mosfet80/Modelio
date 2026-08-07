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
package org.modelio.metamodel.impl.bpmn.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00097356-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceImpl extends BpmnSharedElementImpl implements BpmnResource {
    @objid ("5e78a4ee-97a9-4cd3-b1b9-15597826dfc1")
    @Override
    public EList<BpmnResourceRole> getResourceroleRefs() {
        return new SmList<>(this, ((BpmnResourceSmClass)getClassOf()).getResourceroleRefsDep());
    }

    @objid ("48801541-a0ee-45ad-9bd7-2352f8798b21")
    @Override
    public <T extends BpmnResourceRole> List<T> getResourceroleRefs(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceRole element : getResourceroleRefs()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("39f18cb9-4665-44cf-9332-123343556742")
    @Override
    public EList<BpmnResourceParameter> getParameter() {
        return new SmList<>(this, ((BpmnResourceSmClass)getClassOf()).getParameterDep());
    }

    @objid ("c2490912-3911-420a-b9a7-46e605749a8d")
    @Override
    public <T extends BpmnResourceParameter> List<T> getParameter(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceParameter element : getParameter()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0962be20-9930-4250-a5e8-ce18509b0309")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("c8802d12-2aa2-4b54-8d5b-074c7c96c5f4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("50b62fcd-a262-42c7-9586-6cea5c184058")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnResource(this);
    }

}
