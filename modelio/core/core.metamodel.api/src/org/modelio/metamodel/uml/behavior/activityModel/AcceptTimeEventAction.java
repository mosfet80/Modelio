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
 * AcceptTimeEventAction v0.0.9054
 *
 *
 * An AcceptTimeEventAction waits for the occurrence of a time event meeting a specified condition.
 * The time expression specifies a point in time. It can be absolute or can be relative to some other point in time.
 *
 */
@objid ("00258b22-c4bf-1fd8-97fe-001ec947cd2a")
public interface AcceptTimeEventAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("64bc256a-18e4-4f20-9160-d38ec9cd0d0e")
    public static final String MNAME = "AcceptTimeEventAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("c83964e1-c9fd-4596-8e62-ec1ae3151ae0")
    public static final String MQNAME = "Standard.AcceptTimeEventAction";

    /**
     * Getter for attribute 'AcceptTimeEventAction.TimeExpresion'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3413f9e2-b3ff-4da5-9907-9522de6ff590")
    String getTimeExpresion();

    /**
     * Setter for attribute 'AcceptTimeEventAction.TimeExpresion'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7bb58454-6ffc-48d7-937d-40defeaa1217")
    void setTimeExpresion(String value);

}
