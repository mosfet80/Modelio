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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("c740c401-3304-4a68-b664-2705cd525890")
public class UmlModelElementImpl extends ModelElementImpl implements UmlModelElement {
    @objid ("c106a5da-db21-463f-986f-2281459dbc04")
    @Override
    public EList<TemplateParameterSubstitution> getTemplateSubstitution() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getTemplateSubstitutionDep());
    }

    @objid ("4c55d421-af08-4d2a-b1ad-c7609ce76f55")
    @Override
    public <T extends TemplateParameterSubstitution> List<T> getTemplateSubstitution(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateParameterSubstitution element : getTemplateSubstitution()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4f1e0211-a0aa-45cc-a934-0867fab987ff")
    @Override
    public EList<TemplateParameter> getDefaultParametering() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getDefaultParameteringDep());
    }

    @objid ("5baffcf1-4b8e-4fa2-b76e-136691506a62")
    @Override
    public <T extends TemplateParameter> List<T> getDefaultParametering(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateParameter element : getDefaultParametering()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("658ea4f6-1a4b-4722-aaf3-9f3d54f5e6cd")
    @Override
    public EList<Binding> getRepresents() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getRepresentsDep());
    }

    @objid ("fa956f21-3405-4046-843e-c2c84c023d8a")
    @Override
    public <T extends Binding> List<T> getRepresents(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Binding element : getRepresents()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("15d039f8-931c-4498-967f-cfc8ab7c1b26")
    @Override
    public TemplateParameter getOwnerTemplateParameter() {
        Object obj = getDepVal(((UmlModelElementSmClass)getClassOf()).getOwnerTemplateParameterDep());
        return (obj instanceof TemplateParameter)? (TemplateParameter)obj : null;
    }

    @objid ("81644d32-6043-47b6-b9b2-0b20dba32506")
    @Override
    public void setOwnerTemplateParameter(TemplateParameter value) {
        appendDepVal(((UmlModelElementSmClass)getClassOf()).getOwnerTemplateParameterDep(), (SmObjectImpl)value);
    }

    @objid ("efc79775-63af-4215-96c0-612c0bda52a4")
    @Override
    public EList<ConnectorEnd> getRepresentingEnd() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getRepresentingEndDep());
    }

    @objid ("86f89af0-999d-42dc-9380-e2de773a8eb6")
    @Override
    public <T extends ConnectorEnd> List<T> getRepresentingEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ConnectorEnd element : getRepresentingEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9f262328-8459-45dc-9d68-955c6a18a5dc")
    @Override
    public EList<ActivityPartition> getRepresentingPartition() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getRepresentingPartitionDep());
    }

    @objid ("84f59ccf-c793-4bcd-8764-a45fcf844c0b")
    @Override
    public <T extends ActivityPartition> List<T> getRepresentingPartition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityPartition element : getRepresentingPartition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7a80688c-1b05-4ba6-81b9-9f625fce64a9")
    @Override
    public EList<Constraint> getConstraintDefinition() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getConstraintDefinitionDep());
    }

    @objid ("770b1fc4-d139-4a97-ac52-2df498089e46")
    @Override
    public <T extends Constraint> List<T> getConstraintDefinition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Constraint element : getConstraintDefinition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cb57f690-49b0-459a-aa4a-773e3215502b")
    @Override
    public EList<TemplateParameter> getTypingParameter() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getTypingParameterDep());
    }

    @objid ("607cb399-b91b-4510-ad0a-ff1087376e1a")
    @Override
    public <T extends TemplateParameter> List<T> getTypingParameter(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateParameter element : getTypingParameter()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("64fcbfc7-deb4-4372-8654-aed4d9fa5662")
    @Override
    public EList<Manifestation> getManifesting() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getManifestingDep());
    }

    @objid ("f2901085-981f-479b-b9f6-8620dd02cfcc")
    @Override
    public <T extends Manifestation> List<T> getManifesting(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Manifestation element : getManifesting()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("da2d53d1-a434-417e-a043-b9c950de797f")
    @Override
    public EList<BindableInstance> getRepresentingInstance() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getRepresentingInstanceDep());
    }

    @objid ("b8962aea-930f-45ad-8826-fc38651a72ab")
    @Override
    public <T extends BindableInstance> List<T> getRepresentingInstance(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BindableInstance element : getRepresentingInstance()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4c1f7853-bde7-47d3-b76b-0b501063952b")
    @Override
    public EList<InformationFlow> getReceivedInfo() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getReceivedInfoDep());
    }

    @objid ("31975d50-b75e-4b45-9e55-3f0953359d79")
    @Override
    public <T extends InformationFlow> List<T> getReceivedInfo(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getReceivedInfo()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("73f8b998-23c8-4b7e-940f-0e5318077987")
    @Override
    public EList<InformationFlow> getSentInfo() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getSentInfoDep());
    }

    @objid ("64223811-113e-4457-872c-2c46816aa95b")
    @Override
    public <T extends InformationFlow> List<T> getSentInfo(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getSentInfo()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bb96461b-3278-4d6e-bc9d-11debe4d7fdf")
    @Override
    public EList<NaryConnector> getRepresentingConnector() {
        return new SmList<>(this, ((UmlModelElementSmClass)getClassOf()).getRepresentingConnectorDep());
    }

    @objid ("b34b72d9-c62d-41a8-a1a8-7ff43b8415ad")
    @Override
    public <T extends NaryConnector> List<T> getRepresentingConnector(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryConnector element : getRepresentingConnector()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("85fe8614-bfb3-4074-98de-ff45a5f83522")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerTemplateParameter
        obj = (SmObjectImpl)this.getDepVal(((UmlModelElementSmClass)getClassOf()).getOwnerTemplateParameterDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("417d7158-76ca-4a34-be14-c0abdfcad851")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerTemplateParameter
        dep = ((UmlModelElementSmClass)getClassOf()).getOwnerTemplateParameterDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3f222662-f79c-4aa1-8c71-d321d61e034c")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IModelVisitor)
          return accept((IModelVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("0e6fbf27-fe31-4742-9535-9f9c792a6897")
    public Object accept(IModelVisitor v) {
        return v.visitUmlModelElement(this);
    }

}
