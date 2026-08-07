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
package org.modelio.metamodel.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.Parameter;

/**
 * Pin v0.0.9054
 *
 *
 * A pin represents an input to an action or an output from an action.
 *
 */
@objid ("003b6582-c4bf-1fd8-97fe-001ec947cd2a")
public interface Pin extends ObjectNode {
    /**
     * The metaclass simple name.
     */
    @objid ("d5f79064-653b-4e6b-a441-b6e07ebeacca")
    public static final String MNAME = "Pin";

    /**
     * The metaclass qualified name.
     */
    @objid ("023b1f32-fc64-4442-b56f-3a1d2756abcc")
    public static final String MQNAME = "Standard.Pin";

    /**
     * Getter for attribute 'Pin.IsControl'
     *
     * Metamodel description:
     * <i>Indicates whether the pins provide data to the actions, or just controls when it executes it.</i>
     */
    @objid ("8aab8de7-b140-4d40-9ad9-ec719c364b92")
    boolean isIsControl();

    /**
     * Setter for attribute 'Pin.IsControl'
     *
     * Metamodel description:
     * <i>Indicates whether the pins provide data to the actions, or just controls when it executes it.</i>
     */
    @objid ("1f401a0e-cd51-4438-ab5d-d88ec89f3c96")
    void setIsControl(boolean value);

    /**
     * Getter for attribute 'Pin.IsExpansion'
     *
     * Metamodel description:
     * <i>Indicates whether the pin is used for expansion: enables an iteration of the action on the tokens attached to the pin.</i>
     */
    @objid ("40416b40-d4fc-4970-ac04-f02de45393f8")
    boolean isIsExpansion();

    /**
     * Setter for attribute 'Pin.IsExpansion'
     *
     * Metamodel description:
     * <i>Indicates whether the pin is used for expansion: enables an iteration of the action on the tokens attached to the pin.</i>
     */
    @objid ("cfb219cc-fc3d-4e4d-a2a6-3d2e73013374")
    void setIsExpansion(boolean value);

    /**
     * Getter for relation 'Pin->Matched'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("04732ddc-b28b-4924-9f9f-0cd243c5590f")
    Parameter getMatched();

    /**
     * Setter for relation 'Pin->Matched'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("2440c2bb-a9fb-4510-a83c-204369e0d375")
    void setMatched(Parameter value);

}
