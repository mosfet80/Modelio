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
package org.modelio.metamodel.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * BpmnCollaboration v2.2.00
 *
 *
 * The Collaboration package contains classes which are used for modeling Collaborations, which is a collection of Participants shown as Pools, their interactions as shown by Message Flow, and may include Processes within the Pools and/or Choreographies between the Pools.
 *
 * Ownership:
 * Collaborations/Processes are structured under UML Packages or Classifiers or operations.
 *
 */
@objid ("0073c9fe-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnCollaboration extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("aa753119-9a42-4d59-819a-186afa66b4b0")
    public static final String MNAME = "BpmnCollaboration";

    /**
     * The metaclass qualified name.
     */
    @objid ("ae1d450a-4666-41d6-98e2-1619cf3c2f9e")
    public static final String MQNAME = "Standard.BpmnCollaboration";

    /**
     * Getter for attribute 'BpmnCollaboration.IsClosed'
     *
     * Metamodel description:
     * <i>A boolean value specifying whether Message Flow not modeled in the Collaboration can occur when the Collaboration is carried out.
     * ? If the value is true, they MAY NOT occur.
     * ? If the value is false, they MAY occur.</i>
     */
    @objid ("c496c029-c8fe-43f3-a80d-40a6658b6217")
    boolean isIsClosed();

    /**
     * Setter for attribute 'BpmnCollaboration.IsClosed'
     *
     * Metamodel description:
     * <i>A boolean value specifying whether Message Flow not modeled in the Collaboration can occur when the Collaboration is carried out.
     * ? If the value is true, they MAY NOT occur.
     * ? If the value is false, they MAY occur.</i>
     */
    @objid ("094855be-1c4f-4365-91fe-5a915c83e6ff")
    void setIsClosed(boolean value);

    /**
     * Getter for relation 'BpmnCollaboration->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6aa98fec-c510-43a3-9718-0312847e4077")
    EList<BpmnArtifact> getArtifact();

    /**
     * Filtered Getter for relation 'BpmnCollaboration->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e9725720-fad3-452e-a0dc-769e68660d72")
    <T extends BpmnArtifact> List<T> getArtifact(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnCollaboration->MessageFlow'
     *
     * Metamodel description:
     * <i>This provides the list of Message Flow that are used in the
     * Collaboration.</i>
     */
    @objid ("27a2f45c-86ab-4bbf-a1c4-48e2e0fd8244")
    EList<BpmnMessageFlow> getMessageFlow();

    /**
     * Filtered Getter for relation 'BpmnCollaboration->MessageFlow'
     *
     * Metamodel description:
     * <i>This provides the list of Message Flow that are used in the
     * Collaboration.</i>
     */
    @objid ("9953b85a-38ff-413d-8dee-07cf98ac426d")
    <T extends BpmnMessageFlow> List<T> getMessageFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnCollaboration->Participants'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1b87c989-14bf-4e3e-9b2b-deed6a477b61")
    EList<BpmnParticipant> getParticipants();

    /**
     * Filtered Getter for relation 'BpmnCollaboration->Participants'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("46da960a-505b-4237-8b67-8bf8e2be4d99")
    <T extends BpmnParticipant> List<T> getParticipants(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnCollaboration->Messages'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("364c724d-9cf7-4ce9-8cb1-94499b13fcb9")
    EList<BpmnMessage> getMessages();

    /**
     * Filtered Getter for relation 'BpmnCollaboration->Messages'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("978f5ea1-767e-4e70-98c1-95f180085c3e")
    <T extends BpmnMessage> List<T> getMessages(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnCollaboration->DefinedProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("74ab9905-9250-43fd-a98d-5dd496c37546")
    BpmnProcess getDefinedProcess();

    /**
     * Setter for relation 'BpmnCollaboration->DefinedProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3447c6c1-2b2a-4363-ade3-04de13b593a6")
    void setDefinedProcess(BpmnProcess value);

}
