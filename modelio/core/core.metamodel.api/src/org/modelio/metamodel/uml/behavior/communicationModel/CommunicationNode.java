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
package org.modelio.metamodel.uml.behavior.communicationModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Instance;

/**
 * CommunicationNode v0.0.9054
 *
 *
 * <p>A Communication node represents an individual participant in the Communication Interaction. While Parts and StructuralFeatures may have multiplicity greater than 1, Communication nodes represent only one interacting entity.</p><p>If the referenced Instance is multivalued (i.e, has a multiplicity &gt; 1), then the Communication node may have an expression (the &quot;selector&quot;) that specifies which particular part is represented by this Communication node. If the selector is omitted, this means that an arbitrary representative of the multivalued Connectable element is chosen.</p>
 *
 *
 */
@objid ("005a9290-c4bf-1fd8-97fe-001ec947cd2a")
public interface CommunicationNode extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("479ec180-49d3-4c3c-b0ec-2351d7d6238a")
    public static final String MNAME = "CommunicationNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("e4199408-2a38-44de-9b94-a123843be19e")
    public static final String MQNAME = "Standard.CommunicationNode";

    /**
     * Getter for attribute 'CommunicationNode.Selector'
     *
     * Metamodel description:
     * <i>If the represented element is multivalued, then this specifies the specific individual part within that set.</i>
     */
    @objid ("dad6e5d4-8798-4cbc-a876-ff421dce2233")
    String getSelector();

    /**
     * Setter for attribute 'CommunicationNode.Selector'
     *
     * Metamodel description:
     * <i>If the represented element is multivalued, then this specifies the specific individual part within that set.</i>
     */
    @objid ("2323d28e-2c5c-4444-bc12-9f1341a5a1e8")
    void setSelector(String value);

    /**
     * Getter for relation 'CommunicationNode->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c51fe032-7377-4c94-a521-5faae774f926")
    CommunicationInteraction getOwner();

    /**
     * Setter for relation 'CommunicationNode->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9698a727-c2a9-45c8-8db8-132a55aeba4b")
    void setOwner(CommunicationInteraction value);

    /**
     * Getter for relation 'CommunicationNode->Represented'
     *
     * Metamodel description:
     * <i>References the Instance the communication node represents.</i>
     */
    @objid ("25f35689-d156-4b56-b676-9b53553f0123")
    Instance getRepresented();

    /**
     * Setter for relation 'CommunicationNode->Represented'
     *
     * Metamodel description:
     * <i>References the Instance the communication node represents.</i>
     */
    @objid ("4240dd1c-b2d7-4218-9269-6017056abd5b")
    void setRepresented(Instance value);

    /**
     * Getter for relation 'CommunicationNode->Started'
     *
     * Metamodel description:
     * <i>References communication channels starting from the node.</i>
     */
    @objid ("3ed9eaf4-9d27-4ca0-a5fb-a6994eae864e")
    EList<CommunicationChannel> getStarted();

    /**
     * Filtered Getter for relation 'CommunicationNode->Started'
     *
     * Metamodel description:
     * <i>References communication channels starting from the node.</i>
     */
    @objid ("752d3a2a-b6e6-4f6a-8a45-d7b5976dc2e6")
    <T extends CommunicationChannel> List<T> getStarted(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'CommunicationNode->Ended'
     *
     * Metamodel description:
     * <i>References communication channels ending on the node.</i>
     */
    @objid ("752c1324-21db-4a51-ba7b-92350d4b2e29")
    EList<CommunicationChannel> getEnded();

    /**
     * Filtered Getter for relation 'CommunicationNode->Ended'
     *
     * Metamodel description:
     * <i>References communication channels ending on the node.</i>
     */
    @objid ("9596c91a-eb07-4e45-a7e5-b23cec11645e")
    <T extends CommunicationChannel> List<T> getEnded(java.lang.Class<T> filterClass);

}
