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
package org.modelio.metamodel.uml.behavior.interactionModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * MessageEnd v0.0.9054
 *
 *
 * A MessageEnd is an abstract NamedElement that represents what can occur at the end of a Message.
 * Subclasses of MessageEnd define the specific semantics appropriate to the concept they represent.
 *
 */
@objid ("0049cc1c-c4bf-1fd8-97fe-001ec947cd2a")
public interface MessageEnd extends OccurrenceSpecification {
    /**
     * The metaclass simple name.
     */
    @objid ("f929110e-62a4-4ced-9f34-17689ef062db")
    public static final String MNAME = "MessageEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("7e237c60-2b2e-4428-8693-fdade33dcf13")
    public static final String MQNAME = "Standard.MessageEnd";

    /**
     * Getter for relation 'MessageEnd->ReceivedMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9cb31ebe-3fcc-4fa9-8168-c18bfe34abde")
    Message getReceivedMessage();

    /**
     * Setter for relation 'MessageEnd->ReceivedMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9587a5a5-dc61-4698-8c03-8fb22517aaae")
    void setReceivedMessage(Message value);

    /**
     * Getter for relation 'MessageEnd->SentMessage'
     *
     * Metamodel description:
     * <i>Message sent.</i>
     */
    @objid ("b766d02e-e6ab-4783-b77f-12c71468c0f9")
    Message getSentMessage();

    /**
     * Setter for relation 'MessageEnd->SentMessage'
     *
     * Metamodel description:
     * <i>Message sent.</i>
     */
    @objid ("71d0b860-80eb-456e-8903-21c542ec905f")
    void setSentMessage(Message value);

}
