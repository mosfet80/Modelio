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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnItemKind;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0007d5be-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnItemDefinitionImpl extends BpmnSharedElementImpl implements BpmnItemDefinition {
    @objid ("90d33f02-bc8b-4197-95fb-fd4580303531")
    @Override
    public BpmnItemKind getItemKind() {
        return (BpmnItemKind) getAttVal(((BpmnItemDefinitionSmClass)getClassOf()).getItemKindAtt());
    }

    @objid ("9e22093b-b9d3-4e7d-bea5-862ee51e41a1")
    @Override
    public void setItemKind(BpmnItemKind value) {
        setAttVal(((BpmnItemDefinitionSmClass)getClassOf()).getItemKindAtt(), value);
    }

    @objid ("5f0ab1b3-7028-4efe-853d-f0e92973cbaf")
    @Override
    public boolean isIsCollection() {
        return (Boolean) getAttVal(((BpmnItemDefinitionSmClass)getClassOf()).getIsCollectionAtt());
    }

    @objid ("8359a49f-2f5c-4d80-b2cd-6b06361af776")
    @Override
    public void setIsCollection(boolean value) {
        setAttVal(((BpmnItemDefinitionSmClass)getClassOf()).getIsCollectionAtt(), value);
    }

    @objid ("19e88646-da0e-4ee5-8ef2-02768f295885")
    @Override
    public EList<BpmnMessage> getTypedMessage() {
        return new SmList<>(this, ((BpmnItemDefinitionSmClass)getClassOf()).getTypedMessageDep());
    }

    @objid ("bcf525dd-7a61-4350-bb7a-df393d1b6871")
    @Override
    public <T extends BpmnMessage> List<T> getTypedMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessage element : getTypedMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e639e62e-a3c5-4bb8-9c87-c7453d429018")
    @Override
    public EList<BpmnItemAwareElement> getTypedItem() {
        return new SmList<>(this, ((BpmnItemDefinitionSmClass)getClassOf()).getTypedItemDep());
    }

    @objid ("8583b72a-b354-4471-97a6-a45e08373ae4")
    @Override
    public <T extends BpmnItemAwareElement> List<T> getTypedItem(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnItemAwareElement element : getTypedItem()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0cb6457c-3bf2-447f-8a4e-9a67e6677444")
    @Override
    public EList<BpmnResourceParameter> getTypedResourceParameter() {
        return new SmList<>(this, ((BpmnItemDefinitionSmClass)getClassOf()).getTypedResourceParameterDep());
    }

    @objid ("6570ea7d-bf8a-41bb-9ffe-75d4246b5e05")
    @Override
    public <T extends BpmnResourceParameter> List<T> getTypedResourceParameter(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceParameter element : getTypedResourceParameter()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b1fa4fd4-90f0-4486-b761-5c04a30ed70c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("812e01ca-186e-4097-80ec-2d9d307044cd")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("e81fcf0b-b48b-45d6-a305-f3ac53b32ae9")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnItemDefinition(this);
    }

}
