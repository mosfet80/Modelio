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
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnDataState v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00084846-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataState extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("ba1204e0-c989-410c-b6d3-a2c15383f0e4")
    public static final String MNAME = "BpmnDataState";

    /**
     * The metaclass qualified name.
     */
    @objid ("87383ffc-ec25-4cfc-a3de-69368e30f2c3")
    public static final String MQNAME = "Standard.BpmnDataState";

    /**
     * Getter for relation 'BpmnDataState->Item'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b974b0c3-a65d-4220-9f82-3bfeebb899eb")
    BpmnItemAwareElement getItem();

    /**
     * Setter for relation 'BpmnDataState->Item'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dda1433a-9967-4738-b220-f9ee1c853d4c")
    void setItem(BpmnItemAwareElement value);

}
