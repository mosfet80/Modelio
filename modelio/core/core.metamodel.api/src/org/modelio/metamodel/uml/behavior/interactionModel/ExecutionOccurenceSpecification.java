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
 * ExecutionOccurenceSpecification v0.0.9054
 *
 *
 * An execution occurence specification is a kind of message end. It specifies the occurrence of message events, such as sending and receiving signals or invoking or receiving operation calls.
 *
 * Messages are generated either by synchronous operation calls or asynchronous signal sends. They are received by the execution of corresponding accept event actions.
 *
 * It can also represent an execution occurrence specification : in other words, it can represent a moment in time at which actions or behaviors start or finish.
 *
 */
@objid ("00444a76-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExecutionOccurenceSpecification extends MessageEnd {
    /**
     * The metaclass simple name.
     */
    @objid ("154cbb9d-b270-4aff-89fa-4ff023661bf3")
    public static final String MNAME = "ExecutionOccurenceSpecification";

    /**
     * The metaclass qualified name.
     */
    @objid ("893d81ae-eea4-48ae-b0a3-dda9f6c8e974")
    public static final String MQNAME = "Standard.ExecutionOccurenceSpecification";

    /**
     * Getter for relation 'ExecutionOccurenceSpecification->Finished'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8e5ebbcf-de09-4cc4-a50e-b0dcb20bd0b4")
    ExecutionSpecification getFinished();

    /**
     * Setter for relation 'ExecutionOccurenceSpecification->Finished'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("297d4349-d35d-4ed7-aec7-78c5c62417e9")
    void setFinished(ExecutionSpecification value);

    /**
     * Getter for relation 'ExecutionOccurenceSpecification->Started'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("eca5344a-9c93-4936-b17f-e2aecd08bd1c")
    ExecutionSpecification getStarted();

    /**
     * Setter for relation 'ExecutionOccurenceSpecification->Started'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("44087fda-d82e-4952-81d9-84b4ad009251")
    void setStarted(ExecutionSpecification value);

}
