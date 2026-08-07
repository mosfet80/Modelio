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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.statik.Parameter;

/**
 * BehaviorParameter v0.0.9054
 *
 *
 * BehaviorParameter is a Parameter extended to add support for streaming, exceptions and parameter sets.
 *
 * A BehaviorParameter is owned only by a Behavior : Activities, Interactions, State machines or OpaqueBehaviors.
 *
 * Behaviors that are owned by Operations have their BehaviorParameter linked to the corresponding operation Parameter.
 *
 * isException applies to output parameters. An output posted to an exception excludes outputs from being posted to other data and control outputs of the behavior. A token arriving at an exception output parameter of an activity aborts all flows in the activity. Any objects previously posted to non-stream outputs never leave the activity. Streaming outputs posted before any exception are not affected. Use exception parameters on activities only if it is desired to abort all flows in the activity.
 *
 * Streaming parameters give action access to tokens passed from its invoker while the action is executing. Values for streaming parameters may arrive anytime during the execution of the action, not just at the beginning.
 *
 * The effect of a parameter is a declaration of the modeler's intent, and does not have execution semantics. The modeler must ensure that the owner of the parameter has the stated effect.
 *
 */
@objid ("004119be-c4bf-1fd8-97fe-001ec947cd2a")
public interface BehaviorParameter extends Parameter {
    /**
     * The metaclass simple name.
     */
    @objid ("191aa948-6d54-42a4-a7b5-4ed7d7aeaf34")
    public static final String MNAME = "BehaviorParameter";

    /**
     * The metaclass qualified name.
     */
    @objid ("15ff5189-9941-41bb-8c9c-3f849ec5bf94")
    public static final String MQNAME = "Standard.BehaviorParameter";

    /**
     * Getter for relation 'BehaviorParameter->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b63ead57-56ce-46bc-9dd6-4cba7fe21a87")
    EList<ObjectNode> getRepresentingObjectNode();

    /**
     * Filtered Getter for relation 'BehaviorParameter->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("848348f0-38b4-496e-bec1-4c29e0c0b514")
    <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BehaviorParameter->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b848cb4b-3899-4bba-ac98-9940ea3795db")
    Behavior getOwner();

    /**
     * Setter for relation 'BehaviorParameter->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0fbed289-d502-4d72-b6ae-40d86adc4d65")
    void setOwner(Behavior value);

    /**
     * Getter for relation 'BehaviorParameter->Mapped'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6b26d70d-7cf1-4c9e-960f-978e74e3d7a0")
    Parameter getMapped();

    /**
     * Setter for relation 'BehaviorParameter->Mapped'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("acc83e68-48b4-4749-a04d-e0f236dd2f0e")
    void setMapped(Parameter value);

}
