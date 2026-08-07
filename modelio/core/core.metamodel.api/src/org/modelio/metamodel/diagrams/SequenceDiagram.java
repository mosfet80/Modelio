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
package org.modelio.metamodel.diagrams;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * SequenceDiagram v0.0.9054
 *
 *
 * <p>Sequence diagrams describe the sequence of the exchange of messages between several participants (instances, parts, ...).</p><p>They are used to illustrate a dynamic sequence, to model a protocol, to model tests, to trace an execution, to present a scenario of a use case.</p><p>Participants can be created by dragging and dropping classes, actors, ... The sending of messages can be connected to the operations of the participants.</p><p>Sequence diagrams are typically created in a use case, an operation or a collaboration.</p>
 *
 *
 */
@objid ("006f58ba-c4bf-1fd8-97fe-001ec947cd2a")
public interface SequenceDiagram extends BehaviorDiagram {
    /**
     * The metaclass simple name.
     */
    @objid ("7b2db02b-bcac-4ece-ab21-23aa6a3b6b07")
    public static final String MNAME = "SequenceDiagram";

    /**
     * The metaclass qualified name.
     */
    @objid ("10a7d17c-2e59-4123-8aab-dc88c87aeba4")
    public static final String MQNAME = "Standard.SequenceDiagram";

}
