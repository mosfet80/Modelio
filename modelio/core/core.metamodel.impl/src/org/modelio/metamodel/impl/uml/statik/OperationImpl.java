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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptCallEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallOperationAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.MethodPassingMode;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0014913c-c4bf-1fd8-97fe-001ec947cd2a")
public class OperationImpl extends BehavioralFeatureImpl implements Operation {
    @objid ("c7ec1978-5a64-4984-8f42-d927b789a4e0")
    @Override
    public boolean isConcurrency() {
        return (Boolean) getAttVal(((OperationSmClass)getClassOf()).getConcurrencyAtt());
    }

    @objid ("d10371db-656f-4280-8dae-33a9115589bb")
    @Override
    public void setConcurrency(boolean value) {
        setAttVal(((OperationSmClass)getClassOf()).getConcurrencyAtt(), value);
    }

    @objid ("e91d849b-4d6c-4bd5-8f6a-81d9c2f58c5d")
    @Override
    public boolean isFinal() {
        return (Boolean) getAttVal(((OperationSmClass)getClassOf()).getFinalAtt());
    }

    @objid ("c55141ad-9e5d-467d-8dfc-7ded2e2dfd96")
    @Override
    public void setFinal(boolean value) {
        setAttVal(((OperationSmClass)getClassOf()).getFinalAtt(), value);
    }

    @objid ("7c781125-0dfc-4323-bb02-a5c9c69d94f3")
    @Override
    public MethodPassingMode getPassing() {
        return (MethodPassingMode) getAttVal(((OperationSmClass)getClassOf()).getPassingAtt());
    }

    @objid ("c92df186-de9d-49dd-bbe9-5e5c6b91ac66")
    @Override
    public void setPassing(MethodPassingMode value) {
        setAttVal(((OperationSmClass)getClassOf()).getPassingAtt(), value);
    }

    @objid ("a3f66e68-f059-49f2-a9b7-bcfbdbf547d3")
    @Override
    public EList<ElementImport> getOwnedImport() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getOwnedImportDep());
    }

    @objid ("fdbd97ff-f148-4230-8152-bc0520c64ebb")
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

    @objid ("13d7d8dc-1536-45c9-94bd-031bb933ef22")
    @Override
    public EList<RaisedException> getThrown() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getThrownDep());
    }

    @objid ("a70aea31-fdea-434e-86fd-51f72ecde384")
    @Override
    public <T extends RaisedException> List<T> getThrown(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final RaisedException element : getThrown()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("8927f617-0faa-4fea-b10c-5bd9452d7f57")
    @Override
    public EList<Operation> getRedefinition() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getRedefinitionDep());
    }

    @objid ("0f16028a-a5d7-4fc7-ab91-5ab3a171349c")
    @Override
    public <T extends Operation> List<T> getRedefinition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Operation element : getRedefinition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ea077242-ff0a-45bd-bbd0-6243bc04d982")
    @Override
    public EList<Collaboration> getExample() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getExampleDep());
    }

    @objid ("81611e77-01bd-4f9b-9b5e-4677e9d2d0e2")
    @Override
    public <T extends Collaboration> List<T> getExample(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Collaboration element : getExample()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("98ce7d44-85df-46ab-b909-5469b9eefde5")
    @Override
    public EList<Signal> getSRepresentation() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getSRepresentationDep());
    }

    @objid ("0fd79318-5d74-4ed9-89e0-118da9f9e464")
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

    @objid ("87eed53b-8071-4d84-82f7-4f3ef32c508a")
    @Override
    public EList<Behavior> getOwnedBehavior() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getOwnedBehaviorDep());
    }

    @objid ("623e47c4-0712-43be-8845-d01868f35c51")
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

    @objid ("f408cee4-0d4a-4b58-9c31-81dd69b53d1e")
    @Override
    public EList<Parameter> getIO() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getIODep());
    }

    @objid ("929c529c-730d-48f6-af6a-c90ffcd26def")
    @Override
    public <T extends Parameter> List<T> getIO(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Parameter element : getIO()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("be702256-45f1-409d-9cd3-e9c8305651ca")
    @Override
    public EList<TemplateBinding> getTemplateInstanciation() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getTemplateInstanciationDep());
    }

    @objid ("354dfc55-bb31-4611-8bfd-7d6a220ba089")
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

    @objid ("bb33459a-83fa-4550-b660-495fef35e8c4")
    @Override
    public Classifier getOwner() {
        Object obj = getDepVal(((OperationSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Classifier)? (Classifier)obj : null;
    }

    @objid ("a7e01727-a501-455a-a59a-2a684143650c")
    @Override
    public void setOwner(Classifier value) {
        appendDepVal(((OperationSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("a9c51968-0746-4d1c-adcc-bc51104ba13c")
    @Override
    public EList<PackageImport> getOwnedPackageImport() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getOwnedPackageImportDep());
    }

    @objid ("557b9a96-7de7-49f2-aa6c-968361e94e37")
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

    @objid ("9bd426d7-d438-4715-a88c-79ef09cee83e")
    @Override
    public Parameter getReturn() {
        Object obj = getDepVal(((OperationSmClass)getClassOf()).getReturnDep());
        return (obj instanceof Parameter)? (Parameter)obj : null;
    }

    @objid ("bb0f0cc7-958e-46fa-a091-89c24c77de4a")
    @Override
    public void setReturn(Parameter value) {
        appendDepVal(((OperationSmClass)getClassOf()).getReturnDep(), (SmObjectImpl)value);
    }

    @objid ("33425431-0578-430a-9cb3-3fc57c217ffb")
    @Override
    public EList<TemplateBinding> getInstanciatingBinding() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getInstanciatingBindingDep());
    }

    @objid ("2580d2e1-346a-418f-bceb-247bfdfea87b")
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

    @objid ("6a890ee2-c3da-49e5-903f-57aaf4397093")
    @Override
    public EList<Message> getUsage() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getUsageDep());
    }

    @objid ("de50bc18-40ba-43a2-94a1-84882e6e54c9")
    @Override
    public <T extends Message> List<T> getUsage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Message element : getUsage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bde1a39c-d575-47da-84ad-3f76111927f0")
    @Override
    public EList<TemplateParameter> getTemplate() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getTemplateDep());
    }

    @objid ("8e5217a9-4b03-49c9-a7c9-d58e653e71f8")
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

    @objid ("e717084a-ba8b-494f-b3e4-e639982bdf77")
    @Override
    public EList<Event> getOccurence() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("dac88d39-3b4f-4cd8-a34c-0d84c7416cbb")
    @Override
    public <T extends Event> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Event element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7e5d90e2-4841-42dd-8cd5-08d80e6d2a18")
    @Override
    public EList<Transition> getInvoker() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getInvokerDep());
    }

    @objid ("1195e6d7-5a5a-4660-b8e5-9d9db1e0e664")
    @Override
    public <T extends Transition> List<T> getInvoker(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getInvoker()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e1cc4a81-640f-4ae1-9d34-15d85f0c3ab2")
    @Override
    public EList<CommunicationMessage> getCommunicationUsage() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getCommunicationUsageDep());
    }

    @objid ("e990e4c8-5659-4af7-851f-2478deda83bd")
    @Override
    public <T extends CommunicationMessage> List<T> getCommunicationUsage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationMessage element : getCommunicationUsage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9ea43b83-b610-4ee6-bc39-9fbc6c1298b7")
    @Override
    public EList<CollaborationUse> getOwnedCollaborationUse() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getOwnedCollaborationUseDep());
    }

    @objid ("4cc1545a-39bb-486e-94e2-ce4d0bfe0447")
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

    @objid ("67e82aea-c0e8-470a-a343-f0cbb96e0422")
    @Override
    public Operation getRedefines() {
        Object obj = getDepVal(((OperationSmClass)getClassOf()).getRedefinesDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("575a0fa7-a615-467e-9e12-8d17c5ba198e")
    @Override
    public void setRedefines(Operation value) {
        appendDepVal(((OperationSmClass)getClassOf()).getRedefinesDep(), (SmObjectImpl)value);
    }

    @objid ("23715086-1b7b-4189-9617-5142098f3c65")
    @Override
    public EList<CallOperationAction> getCallingAction() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getCallingActionDep());
    }

    @objid ("24dad228-093d-4e15-934a-42f39cacd2e4")
    @Override
    public <T extends CallOperationAction> List<T> getCallingAction(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CallOperationAction element : getCallingAction()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("059db523-b623-48a5-aae6-c3c65c5ce8d4")
    @Override
    public EList<AcceptCallEventAction> getEntryPointAction() {
        return new SmList<>(this, ((OperationSmClass)getClassOf()).getEntryPointActionDep());
    }

    @objid ("7c56c343-70f4-4331-9586-e553d4115025")
    @Override
    public <T extends AcceptCallEventAction> List<T> getEntryPointAction(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AcceptCallEventAction element : getEntryPointAction()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0e93c8be-217e-484b-9dfe-7313b2a3a41a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((OperationSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("17438844-b01f-4534-9805-cc67bd3e3f6d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((OperationSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("173003c6-83ec-4237-b74e-9d0f41330458")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitOperation(this);
    }

}
