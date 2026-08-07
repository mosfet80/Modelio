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
package org.modelio.metamodel.bpmn.events;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;

/**
 * BpmnEvent v0.0.9054
 *
 *
 * <p>An Event is something that &quot;happens&quot;&nbsp;during the course of a Process. These Events affect the flow of the Process and usually have a cause or an impact and in general require or allow for a reaction. The term &quot;event&quot;&nbsp;is general enough to cover many things in a Process. The start of an Activity, the end of an Activity, the change of state of a document, a Message that arrives, etc., all could be considered Events.</p><p>Events allow for the description of &quot;event-driven&quot;&nbsp;Processes. In these Processes, There are three main types of Events:</p>
 *
 * <ul>
 * 	<li>Start Events, which indicate where a Process will start.</li>
 * 	<li>End Events, which indicate where a path of a Process will end.</li>
 * 	<li>Intermediate Events, which indicate where something happens somewhere between the start and end of a Process.</li>
 * </ul>
 *
 * <p>Within these three types, Events come in two flavors:</p>
 *
 * <ul>
 * 	<li>Events that catch a Trigger. All Start Events and some Intermediate Events are catching Events.</li>
 * 	<li>Events that throw a Result. All End Events and some Intermediate Events are throwing Events that may eventually be caught by another Event. Typically the Trigger carries information out of the scope where the throw Event occurred into the scope of the catching Events. The throwing of a trigger may be either implicit as defined by this standard or an extension to it or explicit by a throw Event.</li>
 * </ul>
 *
 * <p>Ownership Events belong to Flow element containers or subprocesses</p>
 *
 *
 */
@objid ("008c8ed0-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnEvent extends BpmnFlowNode {
    /**
     * The metaclass simple name.
     */
    @objid ("aea86b5b-5b97-4110-b305-341bf4033032")
    public static final String MNAME = "BpmnEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("6ef4b218-0a6c-4532-bd4b-5af0c63fcb5c")
    public static final String MQNAME = "Standard.BpmnEvent";

    /**
     * Getter for relation 'BpmnEvent->EventDefinitions'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("32aed353-1564-4096-806f-acaa400f7398")
    EList<BpmnEventDefinition> getEventDefinitions();

    /**
     * Filtered Getter for relation 'BpmnEvent->EventDefinitions'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c7874c03-f108-4b7d-ac48-d69c317850f3")
    <T extends BpmnEventDefinition> List<T> getEventDefinitions(java.lang.Class<T> filterClass);

}
