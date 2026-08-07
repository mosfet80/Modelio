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
import org.modelio.metamodel.impl.uml.infrastructure.ModelTreeImpl;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0011931a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class NameSpaceImpl extends ModelTreeImpl implements NameSpace {
    @objid ("48709a24-24f3-4d53-8559-1a8a9ef7d58d")
    @Override
    public boolean isIsAbstract() {
        return (Boolean) getAttVal(((NameSpaceSmClass)getClassOf()).getIsAbstractAtt());
    }

    @objid ("cd48929a-14bc-48d0-a6b3-618a6fb4eea3")
    @Override
    public void setIsAbstract(boolean value) {
        setAttVal(((NameSpaceSmClass)getClassOf()).getIsAbstractAtt(), value);
    }

    @objid ("14acac48-9176-43e5-a532-1c943cf77443")
    @Override
    public boolean isIsLeaf() {
        return (Boolean) getAttVal(((NameSpaceSmClass)getClassOf()).getIsLeafAtt());
    }

    @objid ("e1342d4d-5d9c-4cf7-8727-c41fc75ade00")
    @Override
    public void setIsLeaf(boolean value) {
        setAttVal(((NameSpaceSmClass)getClassOf()).getIsLeafAtt(), value);
    }

    @objid ("b993bdb0-eca2-450b-843d-04af4b99296f")
    @Override
    public boolean isIsRoot() {
        return (Boolean) getAttVal(((NameSpaceSmClass)getClassOf()).getIsRootAtt());
    }

    @objid ("05a7407e-184d-43f5-826b-619c24a5607b")
    @Override
    public void setIsRoot(boolean value) {
        setAttVal(((NameSpaceSmClass)getClassOf()).getIsRootAtt(), value);
    }

    @objid ("abd52eba-1b24-4693-bb89-2180bcccd3e1")
    @Override
    public VisibilityMode getVisibility() {
        return (VisibilityMode) getAttVal(((NameSpaceSmClass)getClassOf()).getVisibilityAtt());
    }

    @objid ("b897bdce-eccb-4359-8cba-9a134931760d")
    @Override
    public void setVisibility(VisibilityMode value) {
        setAttVal(((NameSpaceSmClass)getClassOf()).getVisibilityAtt(), value);
    }

    @objid ("2042013d-be4d-487a-a89f-58add3df3152")
    @Override
    public EList<Generalization> getParent() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getParentDep());
    }

    @objid ("51fde509-7144-4799-8864-464048ab45a9")
    @Override
    public <T extends Generalization> List<T> getParent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Generalization element : getParent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ea8c5674-754b-47d9-bddf-bee8695a84bf")
    @Override
    public EList<TemplateBinding> getTemplateInstanciation() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getTemplateInstanciationDep());
    }

    @objid ("b8aed9d4-1bba-4055-8170-99882647d5a2")
    @Override
    public <T extends TemplateBinding> List<T> getTemplateInstanciation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateBinding element : getTemplateInstanciation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("33b74f24-8b91-4931-9886-0c3cd038b508")
    @Override
    public EList<Instance> getRepresenting() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getRepresentingDep());
    }

    @objid ("e9a47603-2195-4473-be47-67c7a316b149")
    @Override
    public <T extends Instance> List<T> getRepresenting(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Instance element : getRepresenting()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bcbeddcc-80e6-4d0e-b2d7-f0936d2e763b")
    @Override
    public EList<Behavior> getOwnedBehavior() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedBehaviorDep());
    }

    @objid ("e4e5dfe2-fad5-4f94-a24b-a77579267355")
    @Override
    public <T extends Behavior> List<T> getOwnedBehavior(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Behavior element : getOwnedBehavior()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("337de5dd-7bca-4b8b-bf90-52f749b2f271")
    @Override
    public EList<DataFlow> getReceived() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getReceivedDep());
    }

    @objid ("f4c70a69-8f9c-47fc-9f5f-6f8e5605bb24")
    @Override
    public <T extends DataFlow> List<T> getReceived(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final DataFlow element : getReceived()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6b0e195d-73ba-400e-973e-40b09df28afc")
    @Override
    public EList<InformationFlow> getOwnedInformationFlow() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedInformationFlowDep());
    }

    @objid ("b9d27ca2-193d-4f3c-852f-dc3de9219b27")
    @Override
    public <T extends InformationFlow> List<T> getOwnedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getOwnedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bc9c804f-c32d-4b37-ae8e-d7c738e90893")
    @Override
    public EList<ElementImport> getImporting() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getImportingDep());
    }

    @objid ("33180952-a3c9-4ec8-90cd-0b8662aa39e5")
    @Override
    public <T extends ElementImport> List<T> getImporting(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ElementImport element : getImporting()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1cf5c0f6-1d6d-4019-a26f-3c6445a28ceb")
    @Override
    public EList<DataFlow> getSent() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getSentDep());
    }

    @objid ("c2727f55-95fb-47df-86cf-aa6a442d697d")
    @Override
    public <T extends DataFlow> List<T> getSent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final DataFlow element : getSent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a76e76e8-1618-4bb5-89b8-9366d25c1063")
    @Override
    public EList<DataFlow> getOwnedDataFlow() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedDataFlowDep());
    }

    @objid ("d9341667-3edf-4760-ac4d-7260bec3f4a8")
    @Override
    public <T extends DataFlow> List<T> getOwnedDataFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final DataFlow element : getOwnedDataFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("58e90fda-49f4-4b5e-babe-1ea0fc662fda")
    @Override
    public EList<CollaborationUse> getOwnedCollaborationUse() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedCollaborationUseDep());
    }

    @objid ("5b81f82e-3bc7-4d82-a051-649452ec0a03")
    @Override
    public <T extends CollaborationUse> List<T> getOwnedCollaborationUse(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CollaborationUse element : getOwnedCollaborationUse()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a61461a8-a805-44db-b85a-19a31b352cf5")
    @Override
    public EList<PackageImport> getOwnedPackageImport() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedPackageImportDep());
    }

    @objid ("92458b62-7f43-4475-9d91-c1c74f62dc42")
    @Override
    public <T extends PackageImport> List<T> getOwnedPackageImport(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final PackageImport element : getOwnedPackageImport()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("894b9dbf-5ad2-4b24-8fa9-b66412c6b82c")
    @Override
    public EList<TemplateParameter> getTemplate() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getTemplateDep());
    }

    @objid ("13087403-8509-4c70-8e91-c7c6f7e6e228")
    @Override
    public <T extends TemplateParameter> List<T> getTemplate(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateParameter element : getTemplate()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9d6e5cfd-0837-4d4d-b3ea-b1c15687c7aa")
    @Override
    public EList<Generalization> getSpecialization() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getSpecializationDep());
    }

    @objid ("0dacf9e0-e0b9-4bfb-877a-a90279bf26b0")
    @Override
    public <T extends Generalization> List<T> getSpecialization(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Generalization element : getSpecialization()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("24309938-9d1d-4a78-b663-35d2b190419e")
    @Override
    public EList<InterfaceRealization> getRealized() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getRealizedDep());
    }

    @objid ("1cd2119d-a35c-4130-97d7-15eb8e3e1379")
    @Override
    public <T extends InterfaceRealization> List<T> getRealized(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InterfaceRealization element : getRealized()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cfc892bd-12a8-4133-9eb4-536ddbf12633")
    @Override
    public EList<Instance> getDeclared() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getDeclaredDep());
    }

    @objid ("d6090bc0-32a1-4602-918a-dc874822f863")
    @Override
    public <T extends Instance> List<T> getDeclared(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Instance element : getDeclared()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("aef0a6fb-8044-4c9e-8d6a-7a64de12cde4")
    @Override
    public EList<TemplateBinding> getInstanciatingBinding() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getInstanciatingBindingDep());
    }

    @objid ("819a0cf3-88b6-4e9b-81ff-a2ab50b314d6")
    @Override
    public <T extends TemplateBinding> List<T> getInstanciatingBinding(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateBinding element : getInstanciatingBinding()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c17de57f-a1a5-4c51-910d-993725044764")
    @Override
    public EList<ElementImport> getOwnedImport() {
        return new SmList<>(this, ((NameSpaceSmClass)getClassOf()).getOwnedImportDep());
    }

    @objid ("72669987-8b9b-487e-897d-87d0f40b7a5e")
    @Override
    public <T extends ElementImport> List<T> getOwnedImport(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ElementImport element : getOwnedImport()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5e758cae-24f6-460f-be53-35760c6a875a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("8658afe6-68cb-400a-af08-4931d733838d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("d9390b09-d913-4ef8-bf3d-4952c55cf60c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNameSpace(this);
    }

}
