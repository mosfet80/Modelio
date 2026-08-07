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
import org.modelio.metamodel.uml.infrastructure.Constraint;

/**
 * DurationConstraint v0.0.9054
 *
 *
 * NOTE : This class is not yet available in Modelio.
 *
 * A DurationConstraint is a Constraint that must reference 2 MessageEnds.
 * It expresses that the time between 2 MessagesEnds must be comprised between DurationMin and DurationMax.
 *
 * Modelio specific:
 * DurationConstraint has been greatly simplified to improve its useability : its bounds are expressed directly textually instead of using the IntervalConstraint and DurationIntervals OMG metaclasses.
 *
 */
@objid ("0043d1ea-c4bf-1fd8-97fe-001ec947cd2a")
public interface DurationConstraint extends Constraint {
    /**
     * The metaclass simple name.
     */
    @objid ("18d1d334-804d-446e-ae0b-75612ba81a6a")
    public static final String MNAME = "DurationConstraint";

    /**
     * The metaclass qualified name.
     */
    @objid ("d81d34ea-4067-4773-8c90-bf0785088ea3")
    public static final String MQNAME = "Standard.DurationConstraint";

    /**
     * Getter for attribute 'DurationConstraint.DurationMin'
     *
     * Metamodel description:
     * <i>The minimum duration between 2 MessageEnds.</i>
     */
    @objid ("bb8e7a71-78e2-43b6-85b6-ea47a7a5f7b4")
    String getDurationMin();

    /**
     * Setter for attribute 'DurationConstraint.DurationMin'
     *
     * Metamodel description:
     * <i>The minimum duration between 2 MessageEnds.</i>
     */
    @objid ("e6452988-8370-46fb-98da-935667463d7e")
    void setDurationMin(String value);

    /**
     * Getter for attribute 'DurationConstraint.DurationMax'
     *
     * Metamodel description:
     * <i>The maximum duration between 2 MessageEnds.</i>
     */
    @objid ("89d33264-aeff-463e-a48c-5bc02b6f4e82")
    String getDurationMax();

    /**
     * Setter for attribute 'DurationConstraint.DurationMax'
     *
     * Metamodel description:
     * <i>The maximum duration between 2 MessageEnds.</i>
     */
    @objid ("ca2c598a-1690-4efc-a97d-8b1f0153aafc")
    void setDurationMax(String value);

}
