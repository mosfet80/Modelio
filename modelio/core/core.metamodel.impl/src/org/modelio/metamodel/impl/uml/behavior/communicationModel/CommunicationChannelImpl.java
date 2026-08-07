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
package org.modelio.metamodel.impl.uml.behavior.communicationModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("3d66beff-bc9e-42aa-84dd-28f34e3a9a10")
public class CommunicationChannelImpl extends UmlModelElementImpl implements CommunicationChannel {
    @objid ("490d5fe3-7e26-4590-ada5-ffb5dc2c742b")
    @Override
    public EList<CommunicationMessage> getStartToEndMessage() {
        return new SmList<>(this, ((CommunicationChannelSmClass)getClassOf()).getStartToEndMessageDep());
    }

    @objid ("17fe9a99-733b-4145-88df-4a5d5b3b759d")
    @Override
    public <T extends CommunicationMessage> List<T> getStartToEndMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationMessage element : getStartToEndMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bf148499-5f50-4471-9712-d55908e71201")
    @Override
    public Link getChannel() {
        Object obj = getDepVal(((CommunicationChannelSmClass)getClassOf()).getChannelDep());
        return (obj instanceof Link)? (Link)obj : null;
    }

    @objid ("d8a5e622-e742-4d17-9cdc-fa93d6352233")
    @Override
    public void setChannel(Link value) {
        appendDepVal(((CommunicationChannelSmClass)getClassOf()).getChannelDep(), (SmObjectImpl)value);
    }

    @objid ("a82e9449-1f00-404c-a79a-74ea9d205adb")
    @Override
    public CommunicationNode getStart() {
        Object obj = getDepVal(((CommunicationChannelSmClass)getClassOf()).getStartDep());
        return (obj instanceof CommunicationNode)? (CommunicationNode)obj : null;
    }

    @objid ("29edadc7-9210-4fe4-bc27-87e5bd7bbfda")
    @Override
    public void setStart(CommunicationNode value) {
        appendDepVal(((CommunicationChannelSmClass)getClassOf()).getStartDep(), (SmObjectImpl)value);
    }

    @objid ("9ed0c95a-d628-4c86-ad0e-474f6d6248eb")
    @Override
    public NaryLink getNaryChannel() {
        Object obj = getDepVal(((CommunicationChannelSmClass)getClassOf()).getNaryChannelDep());
        return (obj instanceof NaryLink)? (NaryLink)obj : null;
    }

    @objid ("58f1464f-ee87-46c2-847b-76bbb3c6a2bb")
    @Override
    public void setNaryChannel(NaryLink value) {
        appendDepVal(((CommunicationChannelSmClass)getClassOf()).getNaryChannelDep(), (SmObjectImpl)value);
    }

    @objid ("454b47f4-7c4c-4e4f-91fe-28c563b2bb79")
    @Override
    public EList<CommunicationMessage> getEndToStartMessage() {
        return new SmList<>(this, ((CommunicationChannelSmClass)getClassOf()).getEndToStartMessageDep());
    }

    @objid ("9f566469-00e9-4566-a871-aa0f2e8e2625")
    @Override
    public <T extends CommunicationMessage> List<T> getEndToStartMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationMessage element : getEndToStartMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("52acd7a5-7375-44ab-94ba-9342e37252ca")
    @Override
    public CommunicationNode getEnd() {
        Object obj = getDepVal(((CommunicationChannelSmClass)getClassOf()).getEndDep());
        return (obj instanceof CommunicationNode)? (CommunicationNode)obj : null;
    }

    @objid ("8150f1cc-11cb-4ae5-9fea-4eb4f6f1461f")
    @Override
    public void setEnd(CommunicationNode value) {
        appendDepVal(((CommunicationChannelSmClass)getClassOf()).getEndDep(), (SmObjectImpl)value);
    }

    @objid ("f68301fb-feb8-4c76-85d0-5c0aac0782df")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Start
        obj = (SmObjectImpl)this.getDepVal(((CommunicationChannelSmClass)getClassOf()).getStartDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("5be41f28-bf76-4f89-a1bb-385c54c7b77a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Start
        dep = ((CommunicationChannelSmClass)getClassOf()).getStartDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("2238b847-004d-4b4f-bd03-81a2c862589e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCommunicationChannel(this);
    }

}
