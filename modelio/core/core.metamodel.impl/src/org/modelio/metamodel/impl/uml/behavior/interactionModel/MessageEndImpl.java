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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0049f7c8-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class MessageEndImpl extends OccurrenceSpecificationImpl implements MessageEnd {
    @objid ("d517ed9d-6ad2-4be3-9aba-391e54bdb77d")
    @Override
    public Message getReceivedMessage() {
        Object obj = getDepVal(((MessageEndSmClass)getClassOf()).getReceivedMessageDep());
        return (obj instanceof Message)? (Message)obj : null;
    }

    @objid ("30a289c0-4f01-4f5d-977f-cbcf2ae1a516")
    @Override
    public void setReceivedMessage(Message value) {
        appendDepVal(((MessageEndSmClass)getClassOf()).getReceivedMessageDep(), (SmObjectImpl)value);
    }

    @objid ("8047a335-1975-4104-9649-efecd3e31091")
    @Override
    public Message getSentMessage() {
        Object obj = getDepVal(((MessageEndSmClass)getClassOf()).getSentMessageDep());
        return (obj instanceof Message)? (Message)obj : null;
    }

    @objid ("f97cfc17-ac06-47b9-83e4-54e38e139148")
    @Override
    public void setSentMessage(Message value) {
        appendDepVal(((MessageEndSmClass)getClassOf()).getSentMessageDep(), (SmObjectImpl)value);
    }

    @objid ("93ef8533-556a-45f3-b3dd-bf7e74b32d62")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("9ce0a61d-a1f4-4638-8b93-04fa660d3ba1")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4a4a8e25-909d-4c1f-9789-9baeb244a647")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitMessageEnd(this);
    }

}
