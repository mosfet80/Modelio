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

/**
 * OutputPin v0.0.9054
 *
 *
 * An output pin is a pin that holds output values produced by an action.
 *
 * An action cannot terminate itself if an output pin has fewer values than the lower multiplicity. An action may not put more values in an output pin in a single execution than the upper multiplicity of the pin.
 *
 */
@objid ("003aad54-c4bf-1fd8-97fe-001ec947cd2a")
public interface OutputPin extends Pin {
    /**
     * The metaclass simple name.
     */
    @objid ("9dabd1eb-d1dd-45d0-860b-244c2e3575f6")
    public static final String MNAME = "OutputPin";

    /**
     * The metaclass qualified name.
     */
    @objid ("d254b0f8-94c6-4621-a73d-6cfa93b67f47")
    public static final String MQNAME = "Standard.OutputPin";

    /**
     * Getter for relation 'OutputPin->Outputing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0daf22a4-f109-4097-a140-cf0d86a62e15")
    ActivityAction getOutputing();

    /**
     * Setter for relation 'OutputPin->Outputing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d10d0beb-b3d8-42b3-9bc3-644fae54dd14")
    void setOutputing(ActivityAction value);

}
