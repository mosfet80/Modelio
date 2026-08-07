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
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * ActivityAction v0.0.9054
 *
 *
 * The execution of an action represents some transformation or processing in the modeled system, be it a computer system or otherwise.
 *
 * An action may have sets of incoming and outgoing activity edges that specify control flow and data flow to and from other nodes. An action will not begin execution until all of its input conditions are satisfied. The completion of the execution of an action may enable the execution of a set of successor nodes and actions that take their inputs from the outputs of the action.
 *
 * Action can have pre- and post-conditions (using constraints).
 *
 */
@objid ("002688d8-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityAction extends ActivityNode {
    /**
     * The metaclass simple name.
     */
    @objid ("a1806506-0183-4bea-95d8-5f42ef651e8d")
    public static final String MNAME = "ActivityAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("4d82cce8-40a8-498e-9448-a8fe70dc7cd7")
    public static final String MQNAME = "Standard.ActivityAction";

    /**
     * Getter for attribute 'ActivityAction.IsMultipleInstance'
     *
     * Metamodel description:
     * <i>BPMN: Expresses if several action instances can be run in parallel.</i>
     */
    @objid ("8de20338-b034-414b-8b11-3353d040a50a")
    boolean isIsMultipleInstance();

    /**
     * Setter for attribute 'ActivityAction.IsMultipleInstance'
     *
     * Metamodel description:
     * <i>BPMN: Expresses if several action instances can be run in parallel.</i>
     */
    @objid ("697a982c-f2f5-42b5-96db-20477cd8b241")
    void setIsMultipleInstance(boolean value);

    /**
     * Getter for attribute 'ActivityAction.IsCompensation'
     *
     * Metamodel description:
     * <i>BPMN : Some activities produce complex effects or specific outputs. If the outcome is determined to be undesirable by some specified criteria (such as an order being cancelled), then it will be necessary to "undo" the activities. Compensation activities are activities that "undo" the effect of other activities, in reaction to a compensation event.
     * The Compensation Activity is special in that it does not follow the normal Sequence Flow rules--as mentioned, it is outside the Normal Flow of the Process. This activity cannot have any incoming or outgoing Sequence Flows. The Compensation marker (as is in the Compensation Intermediate Event) will be displayed in the bottom center of the Activity to show this status of the activity.</i>
     */
    @objid ("e6293d66-8e81-4fff-a56c-28244fca1966")
    boolean isIsCompensation();

    /**
     * Setter for attribute 'ActivityAction.IsCompensation'
     *
     * Metamodel description:
     * <i>BPMN : Some activities produce complex effects or specific outputs. If the outcome is determined to be undesirable by some specified criteria (such as an order being cancelled), then it will be necessary to "undo" the activities. Compensation activities are activities that "undo" the effect of other activities, in reaction to a compensation event.
     * The Compensation Activity is special in that it does not follow the normal Sequence Flow rules--as mentioned, it is outside the Normal Flow of the Process. This activity cannot have any incoming or outgoing Sequence Flows. The Compensation marker (as is in the Compensation Intermediate Event) will be displayed in the bottom center of the Activity to show this status of the activity.</i>
     */
    @objid ("7dc26389-297a-4db8-9979-273b2adce02b")
    void setIsCompensation(boolean value);

    /**
     * Getter for relation 'ActivityAction->Output'
     *
     * Metamodel description:
     * <i>Output pins connected to the Action. The action places its results onto pins in this set.</i>
     */
    @objid ("2ac355fa-8787-493b-8139-440de3f2a5f9")
    EList<OutputPin> getOutput();

    /**
     * Filtered Getter for relation 'ActivityAction->Output'
     *
     * Metamodel description:
     * <i>Output pins connected to the Action. The action places its results onto pins in this set.</i>
     */
    @objid ("5b61ad87-2b94-45e1-b5df-14456e1dcec8")
    <T extends OutputPin> List<T> getOutput(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityAction->Input'
     *
     * Metamodel description:
     * <i>Input pins connected to the Action. These are among the total set of inputs. </i>
     */
    @objid ("586df1bb-cdf3-4fbf-8a63-aea15415205e")
    EList<InputPin> getInput();

    /**
     * Filtered Getter for relation 'ActivityAction->Input'
     *
     * Metamodel description:
     * <i>Input pins connected to the Action. These are among the total set of inputs. </i>
     */
    @objid ("c2d92286-74d3-4bff-af84-73d1e8d52798")
    <T extends InputPin> List<T> getInput(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityAction->Handler'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f61b9234-ce9f-47ea-b0e8-8a2c9bdda63f")
    EList<ExceptionHandler> getHandler();

    /**
     * Filtered Getter for relation 'ActivityAction->Handler'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("58d5508a-e0ec-4b5c-a82f-8bc157b853ab")
    <T extends ExceptionHandler> List<T> getHandler(java.lang.Class<T> filterClass);

}
