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
package org.modelio.metamodel.uml.behavior.stateMachineModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Region v0.0.9054
 *
 *
 *
 *
 */
@objid ("0056e10e-c4bf-1fd8-97fe-001ec947cd2a")
public interface Region extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("62875bba-28ab-4102-bf36-3ba670ab71c2")
    public static final String MNAME = "Region";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd37dee1-3a13-4049-b10e-9e8914971465")
    public static final String MQNAME = "Standard.Region";

    /**
     * Getter for relation 'Region->Parent'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("5f118921-a08a-44e5-b1eb-ba7f7e591f4c")
    State getParent();

    /**
     * Setter for relation 'Region->Parent'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("5a6d956d-ec95-42ad-bac2-088b4b3ac071")
    void setParent(State value);

    /**
     * Getter for relation 'Region->Represented'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("954f213c-47fa-4877-a69f-b98dfd5674e7")
    StateMachine getRepresented();

    /**
     * Setter for relation 'Region->Represented'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("04966fa0-9816-4e43-a57a-33c32acd373e")
    void setRepresented(StateMachine value);

    /**
     * Getter for relation 'Region->Sub'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("6e9cd3c9-e9e7-4bd1-aba5-fb88cd466695")
    EList<StateVertex> getSub();

    /**
     * Filtered Getter for relation 'Region->Sub'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("892b1ed6-54f3-4711-aca1-97c16c131e9d")
    <T extends StateVertex> List<T> getSub(java.lang.Class<T> filterClass);

}
