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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000e1c26-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnInterfaceImpl extends BpmnSharedElementImpl implements BpmnInterface {
    @objid ("9c54f0d9-84d3-494e-a599-777e8438f48e")
    @Override
    public EList<BpmnOperation> getOperation() {
        return new SmList<>(this, ((BpmnInterfaceSmClass)getClassOf()).getOperationDep());
    }

    @objid ("181bac8b-fc04-4106-873b-45ac2be3efc1")
    @Override
    public <T extends BpmnOperation> List<T> getOperation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnOperation element : getOperation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0f6c63d7-c42c-49d4-af0f-9fb97e79d4f4")
    @Override
    public EList<BpmnParticipant> getParticipantRef() {
        return new SmList<>(this, ((BpmnInterfaceSmClass)getClassOf()).getParticipantRefDep());
    }

    @objid ("fd3dce43-a6b5-4239-b271-e5676fbd5ecc")
    @Override
    public <T extends BpmnParticipant> List<T> getParticipantRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnParticipant element : getParticipantRef()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("d6cd3a38-fff5-4644-9777-965f8c9c6bbb")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("33ea65b6-e225-408f-ad0d-b74597706714")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("bb71b737-37f3-45bf-9e33-716de5ce5002")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnInterface(this);
    }

}
