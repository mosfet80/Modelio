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
package org.modelio.metamodel.uml.behavior.commonBehaviors;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.CallBehaviorAction;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;

/**
 * Behavior v0.0.9054
 *
 *
 * Behavior is a specification of how its context classifier changes state over time. This specification may be either a definition of possible behavior execution or emergent behavior, or a selective illustration of an interesting subset of possible executions. The latter form is typically used for capturing examples, such as a trace of a particular execution.
 *
 */
@objid ("00409570-c4bf-1fd8-97fe-001ec947cd2a")
public interface Behavior extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("89205fba-2832-44a7-87ca-88c57c5b9f0b")
    public static final String MNAME = "Behavior";

    /**
     * The metaclass qualified name.
     */
    @objid ("a91b6eba-2e8c-4aaa-be83-e22cfc74437d")
    public static final String MQNAME = "Standard.Behavior";

    /**
     * Getter for attribute 'Behavior.IsReentrant'
     *
     * Metamodel description:
     * <i>Indicates whether the behavior can be invoked while it is still executing from a previous invocation. The default value is false.</i>
     */
    @objid ("c72ba91d-1388-4e0d-b126-51252ef4addc")
    boolean isIsReentrant();

    /**
     * Setter for attribute 'Behavior.IsReentrant'
     *
     * Metamodel description:
     * <i>Indicates whether the behavior can be invoked while it is still executing from a previous invocation. The default value is false.</i>
     */
    @objid ("cfd5836d-0ce3-43bb-abd5-ae1bd815fb6c")
    void setIsReentrant(boolean value);

    /**
     * Getter for relation 'Behavior->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1826ea59-7275-42a7-8554-4bc8b68fc669")
    NameSpace getOwner();

    /**
     * Setter for relation 'Behavior->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d2c21477-6b63-4966-bb9d-a95d9849ba2c")
    void setOwner(NameSpace value);

    /**
     * Getter for relation 'Behavior->Parameter'
     *
     * Metamodel description:
     * <i>References a list of parameters to the behavior that describes the order and type of arguments that can be given when the behavior is invoked and of the values that will be returned when the behavior completes its execution.</i>
     */
    @objid ("a4e6989d-1c2a-4935-9d90-eed70b1f075a")
    EList<BehaviorParameter> getParameter();

    /**
     * Filtered Getter for relation 'Behavior->Parameter'
     *
     * Metamodel description:
     * <i>References a list of parameters to the behavior that describes the order and type of arguments that can be given when the behavior is invoked and of the values that will be returned when the behavior completes its execution.</i>
     */
    @objid ("cafa790c-4e03-4d9f-abc0-553e22203b84")
    <T extends BehaviorParameter> List<T> getParameter(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Behavior->OwnerOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8f623ea7-23b0-48ec-967e-bda385bbd61c")
    Operation getOwnerOperation();

    /**
     * Setter for relation 'Behavior->OwnerOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0afc73cf-b558-4bae-906b-0d326ad50229")
    void setOwnerOperation(Operation value);

    /**
     * Getter for relation 'Behavior->OwnedCollaboration'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("ea618061-2f5f-4f4e-a22d-e446fbf9b6c5")
    EList<Collaboration> getOwnedCollaboration();

    /**
     * Filtered Getter for relation 'Behavior->OwnedCollaboration'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("e4e036bf-60ad-4c2f-930a-14e403edcfef")
    <T extends Collaboration> List<T> getOwnedCollaboration(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Behavior->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c4ef3502-b2cc-4ead-a58f-bb1ef9bef506")
    EList<CallBehaviorAction> getCaller();

    /**
     * Filtered Getter for relation 'Behavior->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d3c15d04-cb35-4236-831e-f4bf48cc3318")
    <T extends CallBehaviorAction> List<T> getCaller(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Behavior->EComponent'
     *
     * Metamodel description:
     * <i>Events are defined in the context of a Behavior.</i>
     */
    @objid ("ef8f949c-5039-4569-9365-dec5caf83fb9")
    EList<Event> getEComponent();

    /**
     * Filtered Getter for relation 'Behavior->EComponent'
     *
     * Metamodel description:
     * <i>Events are defined in the context of a Behavior.</i>
     */
    @objid ("9d480277-2723-4e4e-b646-9a4e49835c81")
    <T extends Event> List<T> getEComponent(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Behavior->EffectOf'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("24c5d3e8-fbfa-4ecf-80d8-5c3a9aae5fc0")
    EList<Transition> getEffectOf();

    /**
     * Filtered Getter for relation 'Behavior->EffectOf'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aa20aa11-34cb-4129-8127-1f857454054d")
    <T extends Transition> List<T> getEffectOf(java.lang.Class<T> filterClass);

}
