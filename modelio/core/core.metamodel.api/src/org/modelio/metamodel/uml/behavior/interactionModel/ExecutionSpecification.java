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
package org.modelio.metamodel.uml.behavior.interactionModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ExecutionSpecification v0.0.9054
 *
 *
 * An ExecutionSpecification is a specification of the execution of a unit of behavior or action within the Lifeline. The duration of an ExecutionSpecification is represented by two ExecutionOccurrenceSpecifications, the start ExecutionOccurrenceSpecification and the finish ExecutionOccurrenceSpecification.
 *
 */
@objid ("0044c988-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExecutionSpecification extends InteractionFragment {
    /**
     * The metaclass simple name.
     */
    @objid ("7d751932-7de2-4209-b9a7-3780cd894b2f")
    public static final String MNAME = "ExecutionSpecification";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd1e417c-7648-4eec-9113-e3fc0c509273")
    public static final String MQNAME = "Standard.ExecutionSpecification";

    /**
     * Getter for relation 'ExecutionSpecification->Finish'
     *
     * Metamodel description:
     * <i>References the OccurrenceSpecification that designates the completion of the execution.</i>
     */
    @objid ("a8c9ddf5-3028-48d5-92ef-a8f3eb54f6e7")
    ExecutionOccurenceSpecification getFinish();

    /**
     * Setter for relation 'ExecutionSpecification->Finish'
     *
     * Metamodel description:
     * <i>References the OccurrenceSpecification that designates the completion of the execution.</i>
     */
    @objid ("bd4bed46-17f4-4021-8250-bb67ca28fbfe")
    void setFinish(ExecutionOccurenceSpecification value);

    /**
     * Getter for relation 'ExecutionSpecification->Start'
     *
     * Metamodel description:
     * <i>References the OccurrenceSpecification that designates the start of the execution.</i>
     */
    @objid ("7832b323-9ddc-4be0-808c-da30bf8f6735")
    ExecutionOccurenceSpecification getStart();

    /**
     * Setter for relation 'ExecutionSpecification->Start'
     *
     * Metamodel description:
     * <i>References the OccurrenceSpecification that designates the start of the execution.</i>
     */
    @objid ("49c1727b-be15-40e8-a9d5-e337a435b718")
    void setStart(ExecutionOccurenceSpecification value);

}
