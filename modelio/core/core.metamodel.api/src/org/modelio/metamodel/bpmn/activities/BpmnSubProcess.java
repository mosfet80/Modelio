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
package org.modelio.metamodel.bpmn.activities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;

/**
 * BpmnSubProcess v0.0.9054
 *
 *
 * A Sub-Process is an Activity whose internal details have been modeled using Activities, Gateways, Events, and Sequence Flow. A Sub-Process is a graphical object within a Process, but it also can be ?opened up? to show a lower-level Process. Sub-Processes define a contextual scope that can be used for attribute visibility, transactional scope, for the handling of exceptions, of Events, or for compensation.
 *
 * An Event Sub-Process may or may not occur while the parent Process is active, but it is possible that it will occur many times. Unlike a standard  Sub-Process, which uses the flow of the parent Process as a trigger, an Event Sub- Process has a Start Event with a trigger. Each time the Start Event is triggered while the parent Process is active, then the Event Sub-Process will start.
 *
 */
@objid ("00843028-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnSubProcess extends BpmnActivity {
    /**
     * The metaclass simple name.
     */
    @objid ("7b194d95-735d-4ffc-822d-8307ccee651c")
    public static final String MNAME = "BpmnSubProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("cc5697cf-d29b-4f57-a87c-b47bd23440d3")
    public static final String MQNAME = "Standard.BpmnSubProcess";

    /**
     * Getter for relation 'BpmnSubProcess->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0e6e4d34-b32a-4ae7-abe0-0926a70a260c")
    EList<BpmnArtifact> getArtifact();

    /**
     * Filtered Getter for relation 'BpmnSubProcess->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a1bd178c-1246-4a4a-95de-b3551579f3d1")
    <T extends BpmnArtifact> List<T> getArtifact(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnSubProcess->FlowElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0fe5588d-b816-4cf3-a0de-bcf1ddf553ec")
    EList<BpmnFlowElement> getFlowElement();

    /**
     * Filtered Getter for relation 'BpmnSubProcess->FlowElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e963943b-c98a-4b07-9b94-42b6247dcaf0")
    <T extends BpmnFlowElement> List<T> getFlowElement(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnSubProcess->LaneSet'
     *
     * Metamodel description:
     * <i>laneset of the process. The process is represented in this cas by a pool which is decomposed by lansets and lanes.</i>
     */
    @objid ("aca4f40e-8199-4946-b22f-29189bcbd2e2")
    BpmnLaneSet getLaneSet();

    /**
     * Setter for relation 'BpmnSubProcess->LaneSet'
     *
     * Metamodel description:
     * <i>laneset of the process. The process is represented in this cas by a pool which is decomposed by lansets and lanes.</i>
     */
    @objid ("4feb26a0-c4fd-4340-a40f-79ad398a1f5c")
    void setLaneSet(BpmnLaneSet value);

}
