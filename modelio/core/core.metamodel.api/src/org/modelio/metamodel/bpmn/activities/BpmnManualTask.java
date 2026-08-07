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
package org.modelio.metamodel.bpmn.activities;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnManualTask v0.0.9054
 *
 *
 * A Manual Task is a Task that is expected to be performed without the aid of any business process execution engine or any application. An example of this could be a telephone technician installing a telephone at a customer location.
 * A Manual Task is neither executed by nor managed by a business process runtime.
 * A Manual Task is a Task that is not managed by any business process engine. It can be considered as an unmanaged
 * Task, unmanaged in the sense of that the business process engine doesn?t track the start and completion of such a Task. An example of this could be a paper based instruction for a telephone technician to install a telephone at a customerlocation.
 *
 */
@objid ("008078fc-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnManualTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("36db1ff8-5633-4c2d-a84d-caeecf74095f")
    public static final String MNAME = "BpmnManualTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("11f087dc-cea1-42fd-b504-22cfcf1aa356")
    public static final String MQNAME = "Standard.BpmnManualTask";

}
