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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnEventDefinition v0.0.9054
 *
 *
 * Defines the type of contained triggers expected for an Event
 *
 */
@objid ("008d3f9c-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnEventDefinition extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("bc79648b-15b0-484e-ae36-edca333a37e2")
    public static final String MNAME = "BpmnEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("0ddb1a79-4bc7-4743-a0c2-11bbfd69665e")
    public static final String MQNAME = "Standard.BpmnEventDefinition";

    /**
     * Getter for relation 'BpmnEventDefinition->Defined'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("269e8993-ec8e-4764-9833-60322d7c1d79")
    BpmnEvent getDefined();

    /**
     * Setter for relation 'BpmnEventDefinition->Defined'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9f3899e4-a549-4a3d-af5f-eb1104d38152")
    void setDefined(BpmnEvent value);

    /**
     * Getter for relation 'BpmnEventDefinition->LoopRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("197c2605-0e00-46c2-8767-53b8b606040b")
    EList<BpmnMultiInstanceLoopCharacteristics> getLoopRef();

    /**
     * Filtered Getter for relation 'BpmnEventDefinition->LoopRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6d933f8d-e597-467d-9879-9284acfcd7ce")
    <T extends BpmnMultiInstanceLoopCharacteristics> List<T> getLoopRef(java.lang.Class<T> filterClass);

}
