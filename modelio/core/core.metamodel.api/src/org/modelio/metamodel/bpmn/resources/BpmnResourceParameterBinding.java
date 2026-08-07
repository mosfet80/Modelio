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
package org.modelio.metamodel.bpmn.resources;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnResourceParameterBinding v0.0.9054
 *
 *
 * Valuates the value of a resource parameter for a value occurence.
 *
 */
@objid ("000b28b8-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnResourceParameterBinding extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("4420708c-504d-421e-9396-596375bde0b0")
    public static final String MNAME = "BpmnResourceParameterBinding";

    /**
     * The metaclass qualified name.
     */
    @objid ("96b650b1-0fdf-416f-8498-b5490f7ddb16")
    public static final String MQNAME = "Standard.BpmnResourceParameterBinding";

    /**
     * Getter for attribute 'BpmnResourceParameterBinding.Expression'
     *
     * Metamodel description:
     * <i>expression of the value of the parameter</i>
     */
    @objid ("2c38580d-45b0-41ed-9007-ffac0d27949d")
    String getExpression();

    /**
     * Setter for attribute 'BpmnResourceParameterBinding.Expression'
     *
     * Metamodel description:
     * <i>expression of the value of the parameter</i>
     */
    @objid ("464a9e55-db0d-4e45-a64f-46b66fdf0630")
    void setExpression(String value);

    /**
     * Getter for relation 'BpmnResourceParameterBinding->ResourceRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3e81b607-b577-4273-9d30-232068ebb542")
    BpmnResourceRole getResourceRole();

    /**
     * Setter for relation 'BpmnResourceParameterBinding->ResourceRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("072d2645-f710-43fb-accb-8e2f591c63a0")
    void setResourceRole(BpmnResourceRole value);

    /**
     * Getter for relation 'BpmnResourceParameterBinding->ParameterRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("86c27433-8d3b-4582-969d-abb4eca4ddf7")
    BpmnResourceParameter getParameterRef();

    /**
     * Setter for relation 'BpmnResourceParameterBinding->ParameterRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0cc27510-b955-4140-b63e-b186c3456769")
    void setParameterRef(BpmnResourceParameter value);

}
