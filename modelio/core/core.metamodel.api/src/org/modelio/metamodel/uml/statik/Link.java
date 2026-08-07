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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Link v0.0.9054
 *
 *
 * A Link is an Instance of an Association. It has a set of LinkEnds that matches the set of AssociationEnds of the Association.
 *
 * Links can be used as Connectors between Parts or Ports in UML 2.0, or they can be Links between Instances.
 *
 * In Modelio, a Link belongs to no element.  When a Link acts as a Connector between Parts and/or Ports, these Parts or Ports should belong to the same context (be inside the same Collaboration, Classifier, and so on).
 *
 */
@objid ("815acdf3-5af8-48c5-894b-85d62dbe2e9b")
public interface Link extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7114ade6-0d2c-425d-9e0a-ebaef772e501")
    public static final String MNAME = "Link";

    /**
     * The metaclass qualified name.
     */
    @objid ("91b1e812-9741-401c-8008-06f582f6294f")
    public static final String MQNAME = "Standard.Link";

    /**
     * Getter for relation 'Link->Model'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("638b9c41-f13c-4ea0-9b39-47482834c9e0")
    Association getModel();

    /**
     * Setter for relation 'Link->Model'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("82803527-0dea-4956-b51b-1026e266e07f")
    void setModel(Association value);

    /**
     * Getter for relation 'Link->LinkEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ff1a4b64-4bc6-4d2d-82d2-a1011e3bfa9f")
    EList<LinkEnd> getLinkEnd();

    /**
     * Filtered Getter for relation 'Link->LinkEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bf81ae6c-c5a4-4bcc-b77c-aaf028b0e194")
    <T extends LinkEnd> List<T> getLinkEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Link->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dcf05661-eb87-4c38-835f-e93c4d8fba7a")
    CommunicationChannel getSent();

    /**
     * Setter for relation 'Link->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a814de0f-5bd8-4aaf-86e0-e687fc272d5a")
    void setSent(CommunicationChannel value);

}
