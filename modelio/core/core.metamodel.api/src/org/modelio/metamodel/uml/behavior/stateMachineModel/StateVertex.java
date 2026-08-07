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
 * StateVertex v0.0.9054
 *
 *
 * A StateVertex can be either a State, or a PseudoState that is only a graphical convention. A StateVertex belongs to a State, or to a StateMachine if it is a root State.
 *
 */
@objid ("0054944e-c4bf-1fd8-97fe-001ec947cd2a")
public interface StateVertex extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("08c1f7ac-9f8f-4601-8eb4-5cdbd03e341d")
    public static final String MNAME = "StateVertex";

    /**
     * The metaclass qualified name.
     */
    @objid ("cefc7d8f-5a0a-4b58-ba2a-feb36ee798d6")
    public static final String MQNAME = "Standard.StateVertex";

    /**
     * Getter for relation 'StateVertex->OutGoing'
     *
     * Metamodel description:
     * <i>Specifies the Transitions departing from the StateVertex.</i>
     */
    @objid ("5a5e1b1d-8bcd-4e82-862b-90cfead39693")
    EList<Transition> getOutGoing();

    /**
     * Filtered Getter for relation 'StateVertex->OutGoing'
     *
     * Metamodel description:
     * <i>Specifies the Transitions departing from the StateVertex.</i>
     */
    @objid ("5587c52a-1204-4dfa-ba43-73c2c0cd3eed")
    <T extends Transition> List<T> getOutGoing(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'StateVertex->Incoming'
     *
     * Metamodel description:
     * <i>Specifies the Transitions entering the StateVertex.</i>
     */
    @objid ("24960836-b234-4190-874c-2949dae1cc3b")
    EList<Transition> getIncoming();

    /**
     * Filtered Getter for relation 'StateVertex->Incoming'
     *
     * Metamodel description:
     * <i>Specifies the Transitions entering the StateVertex.</i>
     */
    @objid ("dbdec87f-b562-4d6c-8db9-31ca223a4472")
    <T extends Transition> List<T> getIncoming(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'StateVertex->Parent'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("ee8848a5-ea15-4330-8cfc-24594eb98a1d")
    Region getParent();

    /**
     * Setter for relation 'StateVertex->Parent'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("d0f65687-1fea-4337-ba4d-0d0c31c75b31")
    void setParent(Region value);

}
