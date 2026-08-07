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
package org.modelio.metamodel.bpmn.rootElements;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnSharedElement v2.2.0
 *
 *
 * null
 *
 */
@objid ("03349104-b866-40e2-8265-dfd9e1482a0a")
public interface BpmnSharedElement extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("564ad63c-bc17-4ed7-9d92-d9245be2295c")
    public static final String MNAME = "BpmnSharedElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("7622d2e2-113a-479e-9f1d-2a36d477c41c")
    public static final String MQNAME = "Standard.BpmnSharedElement";

    /**
     * Getter for relation 'BpmnSharedElement->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e478acbe-2655-4557-bc9f-a1036e3893ec")
    BpmnSharedDefinitions getOwner();

    /**
     * Setter for relation 'BpmnSharedElement->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("061d99b8-e7e3-4d58-b9fb-f43884ec6359")
    void setOwner(BpmnSharedDefinitions value);

}
