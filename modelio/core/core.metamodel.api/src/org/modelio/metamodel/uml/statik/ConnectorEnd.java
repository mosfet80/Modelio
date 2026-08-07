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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * ConnectorEnd v0.0.9054
 *
 *
 * A ConnectorEnd is an endpoint of a Connector, which attaches the Connector to a connectable element.
 *
 * In Modelio, a ConnectorEnd is a LinkEnd and can be bound to another element.
 *
 *
 */
@objid ("00068bc8-c4bf-1fd8-97fe-001ec947cd2a")
public interface ConnectorEnd extends LinkEnd {
    /**
     * The metaclass simple name.
     */
    @objid ("b1cc692f-396f-4c2d-af37-03ebba705849")
    public static final String MNAME = "ConnectorEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("353bdc0d-08df-4a53-b965-9620bdcb2820")
    public static final String MQNAME = "Standard.ConnectorEnd";

    /**
     * Getter for relation 'ConnectorEnd->Representation'
     *
     * Metamodel description:
     * <i>Binding between ConnectorsEnds, used in CollaborationUse.</i>
     */
    @objid ("9e0ea40c-dda7-4f50-9efc-4d3533cb2a59")
    EList<Binding> getRepresentation();

    /**
     * Filtered Getter for relation 'ConnectorEnd->Representation'
     *
     * Metamodel description:
     * <i>Binding between ConnectorsEnds, used in CollaborationUse.</i>
     */
    @objid ("a615afef-e9ab-43b0-8934-faa9ce9a8127")
    <T extends Binding> List<T> getRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ConnectorEnd->RepresentedFeature'
     *
     * Metamodel description:
     * <i>Expresses that the ConnectorEnd represents an element in a more accurate context (such as within an instance or a class internal structure). </i>
     */
    @objid ("a76c857c-aff3-465e-a1c1-da49360d68d2")
    UmlModelElement getRepresentedFeature();

    /**
     * Setter for relation 'ConnectorEnd->RepresentedFeature'
     *
     * Metamodel description:
     * <i>Expresses that the ConnectorEnd represents an element in a more accurate context (such as within an instance or a class internal structure). </i>
     */
    @objid ("6e7e4a5c-b6bc-4c0e-b053-29c768b9647f")
    void setRepresentedFeature(UmlModelElement value);

}
