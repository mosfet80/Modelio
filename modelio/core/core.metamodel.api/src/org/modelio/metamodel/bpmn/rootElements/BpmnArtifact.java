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
package org.modelio.metamodel.bpmn.rootElements;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;

/**
 * BpmnArtifact v0.0.9054
 *
 *
 * BPMN provides modelers with the capability of showing additional information about a Process that is not directly related to the Sequence Flow or Message Flow of the Process.
 * At this point, BPMN provides three (3) standard Artifacts: Associations, Groups, and Text Annotations
 *
 */
@objid ("00787d78-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnArtifact extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("60a7ac3d-931d-417e-b792-4adeb0ea3e40")
    public static final String MNAME = "BpmnArtifact";

    /**
     * The metaclass qualified name.
     */
    @objid ("18d0a171-fe19-45af-a305-e4a66b8b93a0")
    public static final String MQNAME = "Standard.BpmnArtifact";

    /**
     * Getter for relation 'BpmnArtifact->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9c3280f5-27bd-4114-b51e-e8cd3ab7f95a")
    BpmnSubProcess getSubProcess();

    /**
     * Setter for relation 'BpmnArtifact->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("65890f3e-8319-48c3-8340-72945e30ec0d")
    void setSubProcess(BpmnSubProcess value);

    /**
     * Getter for relation 'BpmnArtifact->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cff3283a-a421-4ecf-9e96-47fd0a38e857")
    BpmnCollaboration getCollaboration();

    /**
     * Setter for relation 'BpmnArtifact->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0696b18f-1a45-454f-89c7-7c996a3398b1")
    void setCollaboration(BpmnCollaboration value);

    /**
     * Getter for relation 'BpmnArtifact->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5b0acbbd-d96a-4a08-8997-846775265d7e")
    BpmnProcess getProcess();

    /**
     * Setter for relation 'BpmnArtifact->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("868140cc-c8fa-435b-9ee2-de4a2df42f8b")
    void setProcess(BpmnProcess value);

}
