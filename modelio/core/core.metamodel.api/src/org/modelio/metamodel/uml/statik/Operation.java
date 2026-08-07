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
package org.modelio.metamodel.uml.statik;

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

/**
 * Operation v0.0.9054
 *
 *
 * In Modelio, this metaclass defines both the Operation, and the method implementing it.
 *
 * An Operation belongs to its Classifier.
 *
 */
@objid ("001449ac-c4bf-1fd8-97fe-001ec947cd2a")
public interface Operation extends BehavioralFeature {
    /**
     * The metaclass simple name.
     */
    @objid ("ae498367-1507-4741-8021-afef5a89314f")
    public static final String MNAME = "Operation";

    /**
     * The metaclass qualified name.
     */
    @objid ("81737675-f027-4771-826a-0cc4b2e0a769")
    public static final String MQNAME = "Standard.Operation";

    /**
     * Getter for attribute 'Operation.Concurrency'
     *
     * Metamodel description:
     * <i>Distinguishes the different invocation modes of an Operation. This typically specifies concurrent modes.</i>
     */
    @objid ("26bade88-828c-4cfd-ad12-16c8d131b51e")
    boolean isConcurrency();

    /**
     * Setter for attribute 'Operation.Concurrency'
     *
     * Metamodel description:
     * <i>Distinguishes the different invocation modes of an Operation. This typically specifies concurrent modes.</i>
     */
    @objid ("e08deb10-484b-4d03-9c8e-6c83bf8807e1")
    void setConcurrency(boolean value);

    /**
     * Getter for attribute 'Operation.Final'
     *
     * Metamodel description:
     * <i>Final operations cannot be redefined. Some OO languages, such as Java, optimize final operations.</i>
     */
    @objid ("3dbbc1c3-1741-4e5e-b976-5f6dbb480022")
    boolean isFinal();

    /**
     * Setter for attribute 'Operation.Final'
     *
     * Metamodel description:
     * <i>Final operations cannot be redefined. Some OO languages, such as Java, optimize final operations.</i>
     */
    @objid ("cf238bfb-adf4-47e9-a3cc-a908600949a4")
    void setFinal(boolean value);

    /**
     * Getter for attribute 'Operation.Passing'
     *
     * Metamodel description:
     * <i>Method passing mode (in or inout). By default, this is inout. This mode determines whether the message receiver object is updated (inout) or not (in) when the method is invoked.</i>
     */
    @objid ("429ea430-004a-4f68-9085-a8d7d631d981")
    MethodPassingMode getPassing();

    /**
     * Setter for attribute 'Operation.Passing'
     *
     * Metamodel description:
     * <i>Method passing mode (in or inout). By default, this is inout. This mode determines whether the message receiver object is updated (inout) or not (in) when the method is invoked.</i>
     */
    @objid ("8ba8769f-4fa0-4550-99f3-1e8e69b30405")
    void setPassing(MethodPassingMode value);

    /**
     * Getter for relation 'Operation->OwnedImport'
     *
     * Metamodel description:
     * <i>Elements imported by the Operation.</i>
     */
    @objid ("881dcb73-8eac-4108-9162-31fc4f31f9bd")
    EList<ElementImport> getOwnedImport();

    /**
     * Filtered Getter for relation 'Operation->OwnedImport'
     *
     * Metamodel description:
     * <i>Elements imported by the Operation.</i>
     */
    @objid ("a3714daf-cb6f-4d29-97b9-b748260f95ac")
    <T extends ElementImport> List<T> getOwnedImport(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Thrown'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e5c02098-5c54-40d0-a940-81652c7dc098")
    EList<RaisedException> getThrown();

    /**
     * Filtered Getter for relation 'Operation->Thrown'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ec53f65c-9466-41a4-9de4-02147f3b7a0c")
    <T extends RaisedException> List<T> getThrown(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Redefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("03987ebb-9d62-4503-8ec6-7976fec92716")
    EList<Operation> getRedefinition();

    /**
     * Filtered Getter for relation 'Operation->Redefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8a3a64e4-a4a1-45ac-bfec-ff80394806f3")
    <T extends Operation> List<T> getRedefinition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Example'
     *
     * Metamodel description:
     * <i>Collaborations that illustrate the dynamic of the Operation. A Collaboration can be used to express the initial state of an Operation when it starts running.</i>
     */
    @objid ("e0ff85d7-c4b9-478f-a196-1e3b29c9a825")
    EList<Collaboration> getExample();

    /**
     * Filtered Getter for relation 'Operation->Example'
     *
     * Metamodel description:
     * <i>Collaborations that illustrate the dynamic of the Operation. A Collaboration can be used to express the initial state of an Operation when it starts running.</i>
     */
    @objid ("60951572-03e3-4ca5-8fcf-3af7abcc6acc")
    <T extends Collaboration> List<T> getExample(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0a370be8-cc59-421f-9e02-cc8982c25ea5")
    EList<Signal> getSRepresentation();

    /**
     * Filtered Getter for relation 'Operation->SRepresentation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5f00f58e-e9cd-4dae-a19c-fc03f2b7bdfe")
    <T extends Signal> List<T> getSRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->OwnedBehavior'
     *
     * Metamodel description:
     * <i>A behavioral description that implements the behavioral feature. </i>
     */
    @objid ("40ab0912-326f-4908-9598-76c756fedfc8")
    EList<Behavior> getOwnedBehavior();

    /**
     * Filtered Getter for relation 'Operation->OwnedBehavior'
     *
     * Metamodel description:
     * <i>A behavioral description that implements the behavioral feature. </i>
     */
    @objid ("6f6aecac-6be6-4fda-a113-2444043a7d0e")
    <T extends Behavior> List<T> getOwnedBehavior(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->IO'
     *
     * Metamodel description:
     * <i>Defines the parameters making up the Operation.</i>
     */
    @objid ("2ef8aee6-16dd-4c47-988b-819294c8a43e")
    EList<Parameter> getIO();

    /**
     * Filtered Getter for relation 'Operation->IO'
     *
     * Metamodel description:
     * <i>Defines the parameters making up the Operation.</i>
     */
    @objid ("55a002b5-6306-465f-9a1b-76ba7ea71e35")
    <T extends Parameter> List<T> getIO(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->TemplateInstanciation'
     *
     * Metamodel description:
     * <i>Binds the Operation to the template operation that it instanciates.</i>
     */
    @objid ("fd4a9614-bc00-474a-ad65-3f045d8d70c7")
    EList<TemplateBinding> getTemplateInstanciation();

    /**
     * Filtered Getter for relation 'Operation->TemplateInstanciation'
     *
     * Metamodel description:
     * <i>Binds the Operation to the template operation that it instanciates.</i>
     */
    @objid ("2a6107ea-41a0-416e-81f1-62325066c7b3")
    <T extends TemplateBinding> List<T> getTemplateInstanciation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f507ac50-19fc-4efd-81d5-ce1e6a47812c")
    Classifier getOwner();

    /**
     * Setter for relation 'Operation->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dad5a35e-04b9-44d3-8831-228d4024d9b0")
    void setOwner(Classifier value);

    /**
     * Getter for relation 'Operation->OwnedPackageImport'
     *
     * Metamodel description:
     * <i>Packages imported by the Operation.</i>
     */
    @objid ("bf1f576d-44ea-43ee-92f8-11931457537e")
    EList<PackageImport> getOwnedPackageImport();

    /**
     * Filtered Getter for relation 'Operation->OwnedPackageImport'
     *
     * Metamodel description:
     * <i>Packages imported by the Operation.</i>
     */
    @objid ("954a682d-cc87-4a11-88b9-24921d96e064")
    <T extends PackageImport> List<T> getOwnedPackageImport(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Return'
     *
     * Metamodel description:
     * <i>Link to the possible return parameter. The return parameter is only distinguished by this association, from the IOParameter.</i>
     */
    @objid ("627d96c6-17ec-4fcd-992e-d98b18e32e8e")
    Parameter getReturn();

    /**
     * Setter for relation 'Operation->Return'
     *
     * Metamodel description:
     * <i>Link to the possible return parameter. The return parameter is only distinguished by this association, from the IOParameter.</i>
     */
    @objid ("8d9c8a8e-0a08-489c-acef-6fa0f1fd9a54")
    void setReturn(Parameter value);

    /**
     * Getter for relation 'Operation->InstanciatingBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("85ae8829-853b-4efa-905e-c621fc635764")
    EList<TemplateBinding> getInstanciatingBinding();

    /**
     * Filtered Getter for relation 'Operation->InstanciatingBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("25fb43e8-dfc2-4efe-aaa8-38785dce1edf")
    <T extends TemplateBinding> List<T> getInstanciatingBinding(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Usage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("33fee362-f076-463a-bca2-e943a74c69b6")
    EList<Message> getUsage();

    /**
     * Filtered Getter for relation 'Operation->Usage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7c40b175-eae1-4c9f-9199-4e1f4ea69d62")
    <T extends Message> List<T> getUsage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Template'
     *
     * Metamodel description:
     * <i>In case of template operations, this association defines its template parameters.</i>
     */
    @objid ("e6718c02-ce6a-4d6c-871f-d2cd8ea23220")
    EList<TemplateParameter> getTemplate();

    /**
     * Filtered Getter for relation 'Operation->Template'
     *
     * Metamodel description:
     * <i>In case of template operations, this association defines its template parameters.</i>
     */
    @objid ("b3553927-bb62-4079-bec3-801a9d79156b")
    <T extends TemplateParameter> List<T> getTemplate(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7a65eed9-9051-4bd1-aeb5-73f2ba00ea13")
    EList<Event> getOccurence();

    /**
     * Filtered Getter for relation 'Operation->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1a5110f9-2af8-4ec3-aaa9-157c9def2001")
    <T extends Event> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Invoker'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("db1de74e-5ed3-407b-87ee-75cb6716a84d")
    EList<Transition> getInvoker();

    /**
     * Filtered Getter for relation 'Operation->Invoker'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b46ec36b-d854-431f-b4b9-89d812ba1ae5")
    <T extends Transition> List<T> getInvoker(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->CommunicationUsage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6fe5747f-bd9d-42bf-a7d5-620aedda8726")
    EList<CommunicationMessage> getCommunicationUsage();

    /**
     * Filtered Getter for relation 'Operation->CommunicationUsage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a2c3dbbd-0dc7-401e-abf7-1297bf5273cb")
    <T extends CommunicationMessage> List<T> getCommunicationUsage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->OwnedCollaborationUse'
     *
     * Metamodel description:
     * <i>Collaboration occurrences owned by the Operation.</i>
     */
    @objid ("c0577d64-1a26-4c7e-904b-974e97822c38")
    EList<CollaborationUse> getOwnedCollaborationUse();

    /**
     * Filtered Getter for relation 'Operation->OwnedCollaborationUse'
     *
     * Metamodel description:
     * <i>Collaboration occurrences owned by the Operation.</i>
     */
    @objid ("886db234-85e6-4169-aa16-617d07539995")
    <T extends CollaborationUse> List<T> getOwnedCollaborationUse(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->Redefines'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cb63a49f-9b0d-4e98-ae9b-e24f03162456")
    Operation getRedefines();

    /**
     * Setter for relation 'Operation->Redefines'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("99d263a9-00ba-401e-aef0-bc354fa871cf")
    void setRedefines(Operation value);

    /**
     * Getter for relation 'Operation->CallingAction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b9ac2026-744d-4625-876c-51cc703a3ac1")
    EList<CallOperationAction> getCallingAction();

    /**
     * Filtered Getter for relation 'Operation->CallingAction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ff9d758a-1829-4a83-862c-fbd774698ad8")
    <T extends CallOperationAction> List<T> getCallingAction(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Operation->EntryPointAction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0bbfa6c4-a3c5-4d69-824c-6a047e9a4403")
    EList<AcceptCallEventAction> getEntryPointAction();

    /**
     * Filtered Getter for relation 'Operation->EntryPointAction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d5be88bf-761a-4865-82ff-45cae55c5f99")
    <T extends AcceptCallEventAction> List<T> getEntryPointAction(java.lang.Class<T> filterClass);

}
