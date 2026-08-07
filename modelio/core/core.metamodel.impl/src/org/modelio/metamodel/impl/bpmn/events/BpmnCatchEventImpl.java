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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0088d56a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnCatchEventImpl extends BpmnEventImpl implements BpmnCatchEvent {
    @objid ("b260416f-4ae5-46b4-b8ae-51920678d0eb")
    @Override
    public boolean isParallelMultiple() {
        return (Boolean) getAttVal(((BpmnCatchEventSmClass)getClassOf()).getParallelMultipleAtt());
    }

    @objid ("27599ec8-9365-4b78-b8ad-16356c30c754")
    @Override
    public void setParallelMultiple(boolean value) {
        setAttVal(((BpmnCatchEventSmClass)getClassOf()).getParallelMultipleAtt(), value);
    }

    @objid ("3f9f079e-0fae-4f41-9382-eaf6a3208d5c")
    @Override
    public EList<BpmnDataAssociation> getDataOutputAssociation() {
        return new SmList<>(this, ((BpmnCatchEventSmClass)getClassOf()).getDataOutputAssociationDep());
    }

    @objid ("aa22b846-ffb5-409d-936f-1b59553afbb2")
    @Override
    public <T extends BpmnDataAssociation> List<T> getDataOutputAssociation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnDataAssociation element : getDataOutputAssociation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("362b2dd3-252a-4c4f-9c33-53387b6e2134")
    @Override
    public BpmnDataOutput getDataOutput() {
        Object obj = getDepVal(((BpmnCatchEventSmClass)getClassOf()).getDataOutputDep());
        return (obj instanceof BpmnDataOutput)? (BpmnDataOutput)obj : null;
    }

    @objid ("2981215f-6200-4724-880c-680cce72707a")
    @Override
    public void setDataOutput(BpmnDataOutput value) {
        appendDepVal(((BpmnCatchEventSmClass)getClassOf()).getDataOutputDep(), (SmObjectImpl)value);
    }

    @objid ("c7a3018c-7186-4e59-9c6e-5f68ebf1f256")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("59b3ea76-bee8-4ef8-ae23-d66b0485d224")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("bd764455-2299-470e-93be-d57bb24f2797")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnCatchEvent(this);
    }

}
