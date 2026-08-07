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
package org.modelio.metamodel.bpmn.events;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;

/**
 * BpmnImplicitThrowEvent v0.0.9054
 *
 *
 * This is a non-graphical Event that this used for Multi-Instance Activities
 *
 */
@objid ("008df234-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnImplicitThrowEvent extends BpmnThrowEvent {
    /**
     * The metaclass simple name.
     */
    @objid ("f12ea982-30b0-49a4-b4d2-c3ec1464d3e9")
    public static final String MNAME = "BpmnImplicitThrowEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("b47899c0-b832-4370-b2be-7ac309c8f983")
    public static final String MQNAME = "Standard.BpmnImplicitThrowEvent";

    /**
     * Getter for relation 'BpmnImplicitThrowEvent->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("130b4bcd-1dc6-48b8-9176-c208368c42e7")
    BpmnComplexBehaviorDefinition getOwner();

    /**
     * Setter for relation 'BpmnImplicitThrowEvent->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("434e1639-a8ba-4eea-92f9-3bdf6f47270f")
    void setOwner(BpmnComplexBehaviorDefinition value);

}
