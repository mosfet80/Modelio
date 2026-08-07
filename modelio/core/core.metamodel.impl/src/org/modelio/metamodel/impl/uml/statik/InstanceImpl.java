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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000d8770-c4bf-1fd8-97fe-001ec947cd2a")
public class InstanceImpl extends UmlModelElementImpl implements Instance {
    @objid ("bf4756f5-3bd3-4856-956b-3032fb596d6f")
    @Override
    public boolean isIsConstant() {
        return (Boolean) getAttVal(((InstanceSmClass)getClassOf()).getIsConstantAtt());
    }

    @objid ("d0c481ca-d02f-4e89-81f1-7881f133b472")
    @Override
    public void setIsConstant(boolean value) {
        setAttVal(((InstanceSmClass)getClassOf()).getIsConstantAtt(), value);
    }

    @objid ("73a2d2c6-0d73-4edf-9ebb-662e557ec100")
    @Override
    public String getMultiplicityMin() {
        return (String) getAttVal(((InstanceSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("40cccacd-49af-4d25-bbc8-60769840e3a8")
    @Override
    public void setMultiplicityMin(String value) {
        setAttVal(((InstanceSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("315f6697-115b-4888-9ac0-6d83a581b239")
    @Override
    public String getMultiplicityMax() {
        return (String) getAttVal(((InstanceSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("f75593d1-29ea-4faa-9d08-09da93e51858")
    @Override
    public void setMultiplicityMax(String value) {
        setAttVal(((InstanceSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("5e5a998f-f19b-4575-8873-68210a3182dc")
    @Override
    public String getValue() {
        return (String) getAttVal(((InstanceSmClass)getClassOf()).getValueAtt());
    }

    @objid ("bc94c023-4135-4fa3-b45a-36eb4a791060")
    @Override
    public void setValue(String value) {
        setAttVal(((InstanceSmClass)getClassOf()).getValueAtt(), value);
    }

    @objid ("0fc89a97-4261-40e3-b645-ba0474b70007")
    @Override
    public EList<CommunicationNode> getRepresentedCommunicationNode() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getRepresentedCommunicationNodeDep());
    }

    @objid ("fab6ba0f-5ca6-47fe-a351-346fa7ade193")
    @Override
    public <T extends CommunicationNode> List<T> getRepresentedCommunicationNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationNode element : getRepresentedCommunicationNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("d68d7e28-f8e3-4979-a56e-e35d2d62e44d")
    @Override
    public EList<LinkEnd> getOwnedEnd() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getOwnedEndDep());
    }

    @objid ("dd8a2d14-8dde-4177-8188-aa76fa2411bb")
    @Override
    public <T extends LinkEnd> List<T> getOwnedEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getOwnedEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4dfda246-e14e-4f46-8d7e-fd481e2ae904")
    @Override
    public NameSpace getBase() {
        Object obj = getDepVal(((InstanceSmClass)getClassOf()).getBaseDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("e79c86e2-fc38-4f7e-beb0-5151fe84d358")
    @Override
    public void setBase(NameSpace value) {
        appendDepVal(((InstanceSmClass)getClassOf()).getBaseDep(), (SmObjectImpl)value);
    }

    @objid ("32bfb6dd-a386-47e4-82f3-23d3bb5321e1")
    @Override
    public EList<ObjectNode> getRepresentingObjectNode() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getRepresentingObjectNodeDep());
    }

    @objid ("97abc090-0375-4bd2-94dd-3732f7555447")
    @Override
    public <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ObjectNode element : getRepresentingObjectNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b8e5c63e-16d3-443e-9572-8f52cd85218d")
    @Override
    public NameSpace getOwner() {
        Object obj = getDepVal(((InstanceSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("8382e145-c649-4061-a09d-190472f63f5b")
    @Override
    public void setOwner(NameSpace value) {
        appendDepVal(((InstanceSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("a286c189-ec28-4f1a-bde0-531e5e4d2b6d")
    @Override
    public EList<NaryLinkEnd> getOwnedNaryEnd() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getOwnedNaryEndDep());
    }

    @objid ("410d3f78-1dd6-4b5e-a053-03ba5eac43ce")
    @Override
    public <T extends NaryLinkEnd> List<T> getOwnedNaryEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLinkEnd element : getOwnedNaryEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e8ebef80-1bb7-4011-9b67-6e1b86c1829b")
    @Override
    public EList<Lifeline> getRepresentedLifeLine() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getRepresentedLifeLineDep());
    }

    @objid ("e026c660-8ed1-4b93-ae11-68a30788ab3c")
    @Override
    public <T extends Lifeline> List<T> getRepresentedLifeLine(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Lifeline element : getRepresentedLifeLine()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a0d2b414-ef9d-4484-9aa2-6e4519ca8785")
    @Override
    public EList<AttributeLink> getSlot() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getSlotDep());
    }

    @objid ("d6aba9a8-3952-4158-93ae-5ad8bd16e963")
    @Override
    public <T extends AttributeLink> List<T> getSlot(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AttributeLink element : getSlot()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bbd4d18e-3f94-410d-9274-7c2cdaf7dce2")
    @Override
    public EList<BindableInstance> getPart() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getPartDep());
    }

    @objid ("efc9a0ed-e09f-48e5-b3ad-95195f8201f9")
    @Override
    public <T extends BindableInstance> List<T> getPart(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BindableInstance element : getPart()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5877c55d-b50d-4840-81bd-af804eb495d5")
    @Override
    public EList<LinkEnd> getTargetingEnd() {
        return new SmList<>(this, ((InstanceSmClass)getClassOf()).getTargetingEndDep());
    }

    @objid ("20bd803f-ccb5-413d-a922-9a733d21338b")
    @Override
    public <T extends LinkEnd> List<T> getTargetingEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getTargetingEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("8faad696-6636-4fff-a86f-9dced2feee87")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((InstanceSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("384f4771-3377-4d06-bb1a-1c9e8a85e8bf")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((InstanceSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("dd8ad90a-cfa2-461b-ae01-fd55bb0ce986")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInstance(this);
    }

}
