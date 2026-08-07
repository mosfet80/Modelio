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
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000bf81a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class GeneralClassImpl extends ClassifierImpl implements GeneralClass {
    @objid ("7eabc4c5-b607-4efe-bf2b-174813194d2b")
    @Override
    public boolean isIsElementary() {
        return (Boolean) getAttVal(((GeneralClassSmClass)getClassOf()).getIsElementaryAtt());
    }

    @objid ("da71f2a1-8abd-4764-b0ff-c72c705d1b9c")
    @Override
    public void setIsElementary(boolean value) {
        setAttVal(((GeneralClassSmClass)getClassOf()).getIsElementaryAtt(), value);
    }

    @objid ("da951a54-b041-4161-bb56-e1ba78859bb8")
    @Override
    public EList<Parameter> getOccurence() {
        return new SmList<>(this, ((GeneralClassSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("bc338e39-3e2b-4601-a312-4fba8dc03b23")
    @Override
    public <T extends Parameter> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Parameter element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c50fd806-2073-4233-a954-0dac831316c1")
    @Override
    public ExceptionHandler getExceptionInput() {
        Object obj = getDepVal(((GeneralClassSmClass)getClassOf()).getExceptionInputDep());
        return (obj instanceof ExceptionHandler)? (ExceptionHandler)obj : null;
    }

    @objid ("16f27f49-cf7b-4df4-8bc4-870f4b5d9df2")
    @Override
    public void setExceptionInput(ExceptionHandler value) {
        appendDepVal(((GeneralClassSmClass)getClassOf()).getExceptionInputDep(), (SmObjectImpl)value);
    }

    @objid ("fa3c5d38-c273-4c0b-a572-19b93eda6e55")
    @Override
    public EList<Attribute> getObject() {
        return new SmList<>(this, ((GeneralClassSmClass)getClassOf()).getObjectDep());
    }

    @objid ("fad81ba9-a4de-4eea-b523-7333c2183712")
    @Override
    public <T extends Attribute> List<T> getObject(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Attribute element : getObject()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a2501da0-9ee9-481f-b2ba-e1ba646b46d9")
    @Override
    public EList<Signal> getSRepresentation() {
        return new SmList<>(this, ((GeneralClassSmClass)getClassOf()).getSRepresentationDep());
    }

    @objid ("4068c4de-ed9a-473a-aed6-cf825505b329")
    @Override
    public <T extends Signal> List<T> getSRepresentation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Signal element : getSRepresentation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6d752d8f-964b-4053-9b59-5bb2b3970410")
    @Override
    public EList<ObjectNode> getOccurenceObjectNode() {
        return new SmList<>(this, ((GeneralClassSmClass)getClassOf()).getOccurenceObjectNodeDep());
    }

    @objid ("f6b60e94-cdff-4fb1-8fcf-6d7b93b5b8fa")
    @Override
    public <T extends ObjectNode> List<T> getOccurenceObjectNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ObjectNode element : getOccurenceObjectNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("150fdcd9-d79c-4e43-a904-de392a47c219")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("22b34c9c-bc85-4fab-ab84-d872a7cd4a47")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("b4c1dfbf-27d5-4ce3-8a6a-1d40f1ba6a40")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitGeneralClass(this);
    }

}
