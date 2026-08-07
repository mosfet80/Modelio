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
package org.modelio.metamodel.uml.informationFlow;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.NameSpace;

/**
 * DataFlow v0.0.9054
 *
 *
 * DataFlows are the representation of all types of information that can be transmitted between elements. For example, DataFlows can be objects or requests.
 *
 * A DataFlow between elements expresses that the kind of information that it represents (defined through its ModelSignal) can circulate between the connected elements. This can provide high level (system level) information exchange diagrams.
 *
 */
@objid ("00645dc0-c4bf-1fd8-97fe-001ec947cd2a")
public interface DataFlow extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("dcd227b8-72bf-40bb-964d-38563edaafc3")
    public static final String MNAME = "DataFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("fa2c62f3-84e4-49a5-be8d-ebf5fac00a1e")
    public static final String MQNAME = "Standard.DataFlow";

    /**
     * Getter for relation 'DataFlow->Destination'
     *
     * Metamodel description:
     * <i>Designates the NameSpaces (Packages, Classes, and so on) that are targeted by the DataFlow.</i>
     */
    @objid ("e4a60a3c-85a9-463a-b73a-c15d0d9e4c7b")
    NameSpace getDestination();

    /**
     * Setter for relation 'DataFlow->Destination'
     *
     * Metamodel description:
     * <i>Designates the NameSpaces (Packages, Classes, and so on) that are targeted by the DataFlow.</i>
     */
    @objid ("cae65311-837d-4a66-b5a3-8fa0d81d9f5c")
    void setDestination(NameSpace value);

    /**
     * Getter for relation 'DataFlow->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6b86f2c8-4a58-45d7-803f-decf613910f6")
    NameSpace getOrigin();

    /**
     * Setter for relation 'DataFlow->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ea36a59a-b762-4b07-a520-026a99b651f6")
    void setOrigin(NameSpace value);

    /**
     * Getter for relation 'DataFlow->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("03cb6edf-505c-4e6a-b0b2-82a27fbc3447")
    NameSpace getOwner();

    /**
     * Setter for relation 'DataFlow->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e01651eb-bcbb-4321-8b49-56a8364fb89f")
    void setOwner(NameSpace value);

    /**
     * Getter for relation 'DataFlow->SModel'
     *
     * Metamodel description:
     * <i>Defines the DataFlow as being an instance of the associated Signal.</i>
     */
    @objid ("b6e30ed4-1efe-4238-adfa-68cb512f9e51")
    Signal getSModel();

    /**
     * Setter for relation 'DataFlow->SModel'
     *
     * Metamodel description:
     * <i>Defines the DataFlow as being an instance of the associated Signal.</i>
     */
    @objid ("1598de67-dc5a-4c4a-b415-ad055a7d90b5")
    void setSModel(Signal value);

}
