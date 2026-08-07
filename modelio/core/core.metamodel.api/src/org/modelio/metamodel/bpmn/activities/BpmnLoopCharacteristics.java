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
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnLoopCharacteristics v0.0.9054
 *
 *
 * null
 *
 */
@objid ("007ff738-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnLoopCharacteristics extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("28994f40-6878-4405-ba43-540c9c077c5a")
    public static final String MNAME = "BpmnLoopCharacteristics";

    /**
     * The metaclass qualified name.
     */
    @objid ("7e2d55e6-44a7-4da2-a141-5574f82be6fb")
    public static final String MQNAME = "Standard.BpmnLoopCharacteristics";

    /**
     * Getter for relation 'BpmnLoopCharacteristics->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a3249f53-135e-4ba2-b2de-cce8778db42f")
    BpmnActivity getOwnerActivity();

    /**
     * Setter for relation 'BpmnLoopCharacteristics->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6e969a29-444f-4ac3-99ce-64fc88717b88")
    void setOwnerActivity(BpmnActivity value);

}
