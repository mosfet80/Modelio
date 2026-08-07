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
package org.modelio.metamodel.bpmn.objects;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnDataObject v0.0.9054
 *
 *
 * The primary construct for modeling data within the Process flow is the DataObject element. A DataObject has a well-defined lifecycle, with resulting visibility constraints.
 * Data Object elements must be contained within Process or Sub-Process elements. Data Object elements are visible in a Process diagram.
 *
 */
@objid ("000345d0-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataObject extends BpmnItemAwareElement {
    /**
     * The metaclass simple name.
     */
    @objid ("c02543b3-e8e3-4917-bb9b-5ddc8f9e9a70")
    public static final String MNAME = "BpmnDataObject";

    /**
     * The metaclass qualified name.
     */
    @objid ("71235284-31c1-4599-8a59-33406212c9df")
    public static final String MQNAME = "Standard.BpmnDataObject";

    /**
     * Getter for attribute 'BpmnDataObject.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("034cd472-64a7-4f5b-8459-560460c00c72")
    boolean isIsCollection();

    /**
     * Setter for attribute 'BpmnDataObject.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4c274658-d79a-40b1-96a4-a99be5f4223a")
    void setIsCollection(boolean value);

}
