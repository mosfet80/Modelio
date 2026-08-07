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
package org.modelio.metamodel.bpmn.objects;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnSequenceFlowDataAssociation v0.0.9054
 *
 *
 * <p>Data Objects may be directly associated with a Sequence Flow connector to represent two data associations. This is a visual short cut that normalizes two Data Associations: one from a item-aware element (e.g., an Activity) contained by the source of the Sequence Flow, connecting to the Data Object; and the other from the Data Object connecting to a item-aware element contained by the target of the Sequence Flow.</p><p>This is an extension of Modelio to the BPMN standard metamodel.</p><p>Note: See ownership, this could be a&nbsp;process/Subprocess</p>
 *
 *
 */
@objid ("00051888-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnSequenceFlowDataAssociation extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("ee69279d-f08b-4f28-8a28-2dcd124d2af3")
    public static final String MNAME = "BpmnSequenceFlowDataAssociation";

    /**
     * The metaclass qualified name.
     */
    @objid ("c858dd07-31bc-40a3-bfa5-9d42f245e636")
    public static final String MQNAME = "Standard.BpmnSequenceFlowDataAssociation";

    /**
     * Getter for relation 'BpmnSequenceFlowDataAssociation->Connected'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3d3270fa-6999-4dc1-a3b8-2efe9a782c80")
    BpmnSequenceFlow getConnected();

    /**
     * Setter for relation 'BpmnSequenceFlowDataAssociation->Connected'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a254a639-d89b-45b4-a5e9-bf92c50cc770")
    void setConnected(BpmnSequenceFlow value);

    /**
     * Getter for relation 'BpmnSequenceFlowDataAssociation->DataAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4293db75-708c-4fd0-ac3a-046c88122025")
    EList<BpmnDataAssociation> getDataAssociation();

    /**
     * Filtered Getter for relation 'BpmnSequenceFlowDataAssociation->DataAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aabc67cc-bf3b-4e6f-9bb4-c4201d5f21d8")
    <T extends BpmnDataAssociation> List<T> getDataAssociation(java.lang.Class<T> filterClass);

}
