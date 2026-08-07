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
 * PartDecomposition v0.0.9054
 *
 *
 * A Lifeline has a class associated as the type of the Instance that the Lifeline represents. That class may have an internal structure and the PartDecomposition is an Interaction that describes the behavior of that internal structure relative to the Interaction where the decomposition is referenced.
 *
 * A PartDecomposition is a specialization of InteractionUse. It associates with the Instance that it decomposes.
 *
 *
 */
@objid ("004ae91c-c4bf-1fd8-97fe-001ec947cd2a")
public interface PartDecomposition extends InteractionUse {
    /**
     * The metaclass simple name.
     */
    @objid ("d7fc93d4-2e1b-4367-8923-0b28a16be7b3")
    public static final String MNAME = "PartDecomposition";

    /**
     * The metaclass qualified name.
     */
    @objid ("38bd7b42-207d-4772-9f7f-ea610967722e")
    public static final String MQNAME = "Standard.PartDecomposition";

    /**
     * Getter for relation 'PartDecomposition->Decomposed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("86c8ea44-cf3f-46ba-84a0-8b8702032990")
    Lifeline getDecomposed();

    /**
     * Setter for relation 'PartDecomposition->Decomposed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("31a06371-8734-4b0e-b56f-91b5cd953fcf")
    void setDecomposed(Lifeline value);

}
