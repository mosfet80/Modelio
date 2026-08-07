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
 * BpmnDataStore v0.0.9054
 *
 *
 * A DataStore provides a mechanism for Activities to retrieve or update stored information that will persist beyond the scope of the Process.
 *
 * Ownership :
 *
 * A datastore belongs to a FlowElement container (Process) or a SubProcess
 *
 */
@objid ("0003e1c0-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataStore extends BpmnItemAwareElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7602e4eb-aa8a-44a5-888b-7f6f4700a27d")
    public static final String MNAME = "BpmnDataStore";

    /**
     * The metaclass qualified name.
     */
    @objid ("f37542fb-6c22-49e6-93b0-1cfc0a6a1137")
    public static final String MQNAME = "Standard.BpmnDataStore";

    /**
     * Getter for attribute 'BpmnDataStore.Capacity'
     *
     * Metamodel description:
     * <i>Defines the capacity of the Data Store. This is not needed if the isUnlimited attribute is set to true.</i>
     */
    @objid ("1114f67b-2eb4-45dc-9af4-68420cbe207c")
    int getCapacity();

    /**
     * Setter for attribute 'BpmnDataStore.Capacity'
     *
     * Metamodel description:
     * <i>Defines the capacity of the Data Store. This is not needed if the isUnlimited attribute is set to true.</i>
     */
    @objid ("870c7f25-bae5-48fc-91f6-36acbbe1f6c6")
    void setCapacity(int value);

    /**
     * Getter for attribute 'BpmnDataStore.IsUnlimited'
     *
     * Metamodel description:
     * <i>If isUnlimited is set to true, then the capacity of a Data Store is set as unlimited and will override any value of the capacity attribute.</i>
     */
    @objid ("219b741a-9f19-4657-a6cf-6fbd0ae691bc")
    boolean isIsUnlimited();

    /**
     * Setter for attribute 'BpmnDataStore.IsUnlimited'
     *
     * Metamodel description:
     * <i>If isUnlimited is set to true, then the capacity of a Data Store is set as unlimited and will override any value of the capacity attribute.</i>
     */
    @objid ("e3168664-0062-4c84-9003-80812605c44c")
    void setIsUnlimited(boolean value);

}
