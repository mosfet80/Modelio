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
 * ExpansionNode v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00311a8c-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExpansionNode extends ObjectNode {
    /**
     * The metaclass simple name.
     */
    @objid ("e0941fd6-ff66-4ce8-b273-893a03a4c48e")
    public static final String MNAME = "ExpansionNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("5b63d3d5-46ff-4f00-9af6-c4056eba104b")
    public static final String MQNAME = "Standard.ExpansionNode";

    /**
     * Getter for relation 'ExpansionNode->RegionAsOutput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d9edb4b8-c3e6-4e8e-b9b3-21452a3cff88")
    ExpansionRegion getRegionAsOutput();

    /**
     * Setter for relation 'ExpansionNode->RegionAsOutput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("14d06d0e-b223-4131-970b-13ab67932121")
    void setRegionAsOutput(ExpansionRegion value);

    /**
     * Getter for relation 'ExpansionNode->RegionAsInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d21394f5-cbcb-4eee-b9d7-fc8735084eac")
    ExpansionRegion getRegionAsInput();

    /**
     * Setter for relation 'ExpansionNode->RegionAsInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f7acffa1-6db5-4a83-bfa0-b43a7e791f80")
    void setRegionAsInput(ExpansionRegion value);

}
