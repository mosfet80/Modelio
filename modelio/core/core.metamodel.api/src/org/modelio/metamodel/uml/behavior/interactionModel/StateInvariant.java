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
 * StateInvariant v0.0.9054
 *
 *
 * A StateInvariant is a runtime constraint on the participants of the interaction. It may be used to specify a variety of different kinds of constraints, such as values of attributes or variables, internal or external states, and so on.
 *
 * A StateInvariant is an InteractionFragment and is placed on a Lifeline.
 *
 */
@objid ("004b7b34-c4bf-1fd8-97fe-001ec947cd2a")
public interface StateInvariant extends OccurrenceSpecification {
    /**
     * The metaclass simple name.
     */
    @objid ("78b64c5e-747f-4d75-83f2-60569cd2f9ac")
    public static final String MNAME = "StateInvariant";

    /**
     * The metaclass qualified name.
     */
    @objid ("75d843e2-cb54-4543-b3f5-79143f261515")
    public static final String MQNAME = "Standard.StateInvariant";

    /**
     * Getter for attribute 'StateInvariant.Body'
     *
     * Metamodel description:
     * <i>A Constraint that should hold at runtime for this StateInvariant.</i>
     */
    @objid ("55ca28a2-27de-4d5a-bd91-46ad301e17ca")
    String getBody();

    /**
     * Setter for attribute 'StateInvariant.Body'
     *
     * Metamodel description:
     * <i>A Constraint that should hold at runtime for this StateInvariant.</i>
     */
    @objid ("0540a5ce-adf4-467b-a40c-bc5071a39972")
    void setBody(String value);

    /**
     * Getter for attribute 'StateInvariant.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ac5e1bdf-c6ee-4afb-9bf1-d63c8c058f3d")
    int getEndLineNumber();

    /**
     * Setter for attribute 'StateInvariant.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4bf7dc26-b5b8-42b5-8216-a2c77ad54328")
    void setEndLineNumber(int value);

}
