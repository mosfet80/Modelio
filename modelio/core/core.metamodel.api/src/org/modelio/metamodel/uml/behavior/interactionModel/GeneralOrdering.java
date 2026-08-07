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
import org.modelio.metamodel.uml.infrastructure.Element;

/**
 * GeneralOrdering v0.0.9054
 *
 *
 * <p>This mechanism provides the ability to define partial orders of OccurrenceSpecifications that may otherwise not have a specified order.</p><p>A GeneralOrdering may appear anywhere in an Interaction, but only between OccurrenceSpecifications.</p>
 *
 *
 */
@objid ("0045de18-c4bf-1fd8-97fe-001ec947cd2a")
public interface GeneralOrdering extends Element {
    /**
     * The metaclass simple name.
     */
    @objid ("2174e801-1a0a-4c44-ae62-03d15780350b")
    public static final String MNAME = "GeneralOrdering";

    /**
     * The metaclass qualified name.
     */
    @objid ("5bf7d29d-531f-42fa-808a-88b5fcfc9c2d")
    public static final String MQNAME = "Standard.GeneralOrdering";

    /**
     * Getter for relation 'GeneralOrdering->Before'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("acb05b73-22b9-440e-87f1-66c469cba088")
    OccurrenceSpecification getBefore();

    /**
     * Setter for relation 'GeneralOrdering->Before'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("389c96f8-c6ef-4544-8ba7-cfae3e1e488d")
    void setBefore(OccurrenceSpecification value);

    /**
     * Getter for relation 'GeneralOrdering->After'
     *
     * Metamodel description:
     * <i>The OccurrenceSpecification referred comes after the OccurrenceSpecification referred by before.</i>
     */
    @objid ("5a154b12-6fb2-4d69-8b93-9d083838d879")
    OccurrenceSpecification getAfter();

    /**
     * Setter for relation 'GeneralOrdering->After'
     *
     * Metamodel description:
     * <i>The OccurrenceSpecification referred comes after the OccurrenceSpecification referred by before.</i>
     */
    @objid ("c269193c-980c-4d93-b409-77a7f5588be5")
    void setAfter(OccurrenceSpecification value);

}
