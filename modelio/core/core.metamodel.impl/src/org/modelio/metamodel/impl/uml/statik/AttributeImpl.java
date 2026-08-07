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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00981c78-c4be-1fd8-97fe-001ec947cd2a")
public class AttributeImpl extends StructuralFeatureImpl implements Attribute {
    @objid ("92fb3fb4-839e-45d7-8b5d-e040615f5830")
    @Override
    public String getTypeConstraint() {
        return (String) getAttVal(((AttributeSmClass)getClassOf()).getTypeConstraintAtt());
    }

    @objid ("05961097-a720-4e2d-a185-da303b1c6f84")
    @Override
    public void setTypeConstraint(String value) {
        setAttVal(((AttributeSmClass)getClassOf()).getTypeConstraintAtt(), value);
    }

    @objid ("087ebfa4-3594-44b9-8e36-d152550d1a1e")
    @Override
    public String getValue() {
        return (String) getAttVal(((AttributeSmClass)getClassOf()).getValueAtt());
    }

    @objid ("8f79ada9-f0c7-485a-83f7-02b256b1b244")
    @Override
    public void setValue(String value) {
        setAttVal(((AttributeSmClass)getClassOf()).getValueAtt(), value);
    }

    @objid ("32979a7b-819a-4361-82bd-f515a38253c4")
    @Override
    public boolean isTargetIsClass() {
        return (Boolean) getAttVal(((AttributeSmClass)getClassOf()).getTargetIsClassAtt());
    }

    @objid ("b7f6f2c4-8880-4677-960d-953222db2dfd")
    @Override
    public void setTargetIsClass(boolean value) {
        setAttVal(((AttributeSmClass)getClassOf()).getTargetIsClassAtt(), value);
    }

    @objid ("02707ac0-7531-4808-aa92-46515a639e17")
    @Override
    public GeneralClass getType() {
        Object obj = getDepVal(((AttributeSmClass)getClassOf()).getTypeDep());
        return (obj instanceof GeneralClass)? (GeneralClass)obj : null;
    }

    @objid ("06227003-b783-4a27-9687-317e9210c555")
    @Override
    public void setType(GeneralClass value) {
        appendDepVal(((AttributeSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("993fd249-1021-4284-af97-19b961a37016")
    @Override
    public Classifier getOwner() {
        Object obj = getDepVal(((AttributeSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("8f3c0f6c-fbad-4d2f-950c-6c472a8d1a44")
    @Override
    public void setOwner(Classifier value) {
        appendDepVal(((AttributeSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("7b40ebbd-d7e1-4a6a-be9d-21e0bb08324b")
    @Override
    public EList<AttributeLink> getOccurence() {
        return new SmList<>(this, ((AttributeSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("ac5d4d65-3b0c-48ec-8148-0330ca61d3c7")
    @Override
    public <T extends AttributeLink> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AttributeLink element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("87fc4976-d249-4ae1-a57a-fb6d0a1fd4fb")
    @Override
    public EList<ObjectNode> getRepresentingObjectNode() {
        return new SmList<>(this, ((AttributeSmClass)getClassOf()).getRepresentingObjectNodeDep());
    }

    @objid ("5de2696e-60b2-4960-977b-071eb34f7d7e")
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

    @objid ("cd6fe227-2d3c-4d42-b706-9e18f3c404ca")
    @Override
    public AssociationEnd getQualified() {
        Object obj = getDepVal(((AttributeSmClass)getClassOf()).getQualifiedDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("2a2922a1-b4e7-402b-8e26-d5ddfe64b7c0")
    @Override
    public void setQualified(AssociationEnd value) {
        appendDepVal(((AttributeSmClass)getClassOf()).getQualifiedDep(), (SmObjectImpl)value);
    }

    @objid ("ae40a300-bc2b-428c-9f63-20b46a8e2986")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((AttributeSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        // Qualified
        obj = (SmObjectImpl)this.getDepVal(((AttributeSmClass)getClassOf()).getQualifiedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("24dc036a-a4c1-4397-ad31-9f627fbe83d7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((AttributeSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Qualified
        dep = ((AttributeSmClass)getClassOf()).getQualifiedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("09b2fbd5-8880-43bb-8a8e-bda58b74b67c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAttribute(this);
    }

}
