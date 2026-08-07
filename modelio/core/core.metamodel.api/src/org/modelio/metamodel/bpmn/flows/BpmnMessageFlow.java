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
package org.modelio.metamodel.bpmn.flows;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnMessageFlow v0.0.9054
 *
 *
 * A Message Flow is used to show the flow of Messages between two Participants that are prepared to send and receive them.
 *
 * ownership
 * a MessageFlow belongs to a collaboration
 *
 */
@objid ("007c58ee-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnMessageFlow extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("eb8095d8-6cf7-4183-b178-c11d7669b03f")
    public static final String MNAME = "BpmnMessageFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("8023113a-3bac-498d-b128-813009aeaded")
    public static final String MQNAME = "Standard.BpmnMessageFlow";

    /**
     * Getter for relation 'BpmnMessageFlow->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d5920e21-1e8f-4f1a-820d-1117c57e746d")
    BpmnMessage getMessageRef();

    /**
     * Setter for relation 'BpmnMessageFlow->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2fa983d1-b4e3-4f23-b8c9-d3c95fcff9e8")
    void setMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnMessageFlow->SourceRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting from.
     *
     * The source can only be:
     * - a Participant,
     * - an Event,
     * - or a Task
     * </i>
     */
    @objid ("e3547e0b-4c07-42d7-96e1-04896e44e53c")
    BpmnBaseElement getSourceRef();

    /**
     * Setter for relation 'BpmnMessageFlow->SourceRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting from.
     *
     * The source can only be:
     * - a Participant,
     * - an Event,
     * - or a Task
     * </i>
     */
    @objid ("6026f8f9-5927-482d-881d-5fd658409cc9")
    void setSourceRef(BpmnBaseElement value);

    /**
     * Getter for relation 'BpmnMessageFlow->TargetRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting to.
     *
     * The target can only be:
     * - a Participant,
     * - an Event,
     * - or a Task.
     * </i>
     */
    @objid ("d31010e1-92de-44db-905b-36d2e68834ad")
    BpmnBaseElement getTargetRef();

    /**
     * Setter for relation 'BpmnMessageFlow->TargetRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting to.
     *
     * The target can only be:
     * - a Participant,
     * - an Event,
     * - or a Task.
     * </i>
     */
    @objid ("9b6393e8-9ef0-43ac-b812-e9964aae49e7")
    void setTargetRef(BpmnBaseElement value);

    /**
     * Getter for relation 'BpmnMessageFlow->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1ee83696-a3a2-4078-ae3f-a1c332f4f699")
    BpmnCollaboration getCollaboration();

    /**
     * Setter for relation 'BpmnMessageFlow->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("30a70983-3aa5-45a3-8987-24a7469ba524")
    void setCollaboration(BpmnCollaboration value);

}
