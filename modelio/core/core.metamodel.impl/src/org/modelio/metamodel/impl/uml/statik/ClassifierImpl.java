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
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.informationFlow.InformationItem;
import org.modelio.metamodel.uml.infrastructure.Substitution;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.ComponentRealization;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00039a6c-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ClassifierImpl extends NameSpaceImpl implements Classifier {
    @objid ("f97e8d4c-ae8a-45b4-ba92-3104813d1965")
    @Override
    public EList<Operation> getOwnedOperation() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getOwnedOperationDep());
    }

    @objid ("ab58396e-0470-473d-a0b3-6e05eab0ae5b")
    @Override
    public <T extends Operation> List<T> getOwnedOperation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Operation element : getOwnedOperation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e7238a61-a0a7-439d-bc2b-020a196138af")
    @Override
    public EList<InformationItem> getRepresentation() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getRepresentationDep());
    }

    @objid ("dee19d2f-ab41-4cce-a317-b8b32e86c933")
    @Override
    public <T extends InformationItem> List<T> getRepresentation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationItem element : getRepresentation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e280bbcd-33a9-4944-9b04-3029452a4160")
    @Override
    public EList<Substitution> getSubstitued() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getSubstituedDep());
    }

    @objid ("4b0e22c2-ba92-4558-95b7-bbe6e1521abf")
    @Override
    public <T extends Substitution> List<T> getSubstitued(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Substitution element : getSubstitued()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0b5fd464-0723-4108-8bcb-bb5296f3dac4")
    @Override
    public EList<Attribute> getOwnedAttribute() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getOwnedAttributeDep());
    }

    @objid ("c24ee146-3d85-446e-9d19-5e517c457e7c")
    @Override
    public <T extends Attribute> List<T> getOwnedAttribute(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Attribute element : getOwnedAttribute()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4e6f21e2-8cea-4815-86e5-babfa2b7b316")
    @Override
    public EList<NaryAssociationEnd> getOwnedNaryEnd() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getOwnedNaryEndDep());
    }

    @objid ("158805a7-7c55-4179-8a19-977db10cc94e")
    @Override
    public <T extends NaryAssociationEnd> List<T> getOwnedNaryEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryAssociationEnd element : getOwnedNaryEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f8a3a831-d7a4-420e-8e98-212ef093cf32")
    @Override
    public EList<InformationFlow> getConveyer() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getConveyerDep());
    }

    @objid ("e0f52184-ec0d-416e-97f3-8556f57f6272")
    @Override
    public <T extends InformationFlow> List<T> getConveyer(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getConveyer()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("90dcd773-453b-4b1f-b027-66c25ef252e8")
    @Override
    public EList<Substitution> getSubstitutingSubstitution() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getSubstitutingSubstitutionDep());
    }

    @objid ("1bd82383-558c-4e1d-845f-ec622654de5e")
    @Override
    public <T extends Substitution> List<T> getSubstitutingSubstitution(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Substitution element : getSubstitutingSubstitution()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("750105a5-a67a-43a9-bfc4-c9efe206083a")
    @Override
    public EList<AssociationEnd> getTargetingEnd() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getTargetingEndDep());
    }

    @objid ("00d3d91a-a714-43e0-9474-0c5c4c37d76a")
    @Override
    public <T extends AssociationEnd> List<T> getTargetingEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AssociationEnd element : getTargetingEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("700d6c75-bc49-4d32-b952-3399f45f1a05")
    @Override
    public EList<AssociationEnd> getOwnedEnd() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getOwnedEndDep());
    }

    @objid ("57e7e435-77d8-4062-b7db-01e23a46d635")
    @Override
    public <T extends AssociationEnd> List<T> getOwnedEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AssociationEnd element : getOwnedEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("8fc9533d-d1db-420d-98d7-58124e504cc4")
    @Override
    public EList<RaisedException> getThrowing() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getThrowingDep());
    }

    @objid ("7d9c2d13-febf-4cf3-8929-38dc4d27c8d2")
    @Override
    public <T extends RaisedException> List<T> getThrowing(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final RaisedException element : getThrowing()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("87f02eb2-17ec-41bf-ae5a-86924e0b164a")
    @Override
    public EList<BindableInstance> getInternalStructure() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getInternalStructureDep());
    }

    @objid ("b075d7ea-3648-490d-895e-968ebfae6186")
    @Override
    public <T extends BindableInstance> List<T> getInternalStructure(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BindableInstance element : getInternalStructure()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("eae2b4da-9361-4813-8df2-d1c464bf0c0f")
    @Override
    public EList<ComponentRealization> getRealizedComponent() {
        return new SmList<>(this, ((ClassifierSmClass)getClassOf()).getRealizedComponentDep());
    }

    @objid ("6a21701c-8c08-4b64-8660-d31b086a36c0")
    @Override
    public <T extends ComponentRealization> List<T> getRealizedComponent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ComponentRealization element : getRealizedComponent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1d7c1080-febe-4ee0-ab50-2670bae80951")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("f902ecb8-0f3d-4e58-9ade-71139c7c4a7f")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("894c54d9-b132-4512-9d45-2c393a321edf")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitClassifier(this);
    }

}
