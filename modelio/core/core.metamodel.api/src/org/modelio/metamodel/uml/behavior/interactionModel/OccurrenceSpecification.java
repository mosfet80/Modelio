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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * OccurrenceSpecification v0.0.9054
 *
 *
 * An OccurrenceSpecification is the basic semantic unit of Interactions. The sequences of occurrences specified by them are the meanings of Interactions.
 *
 * OccurrenceSpecifications are ordered along a Lifeline.
 *
 */
@objid ("004a586c-c4bf-1fd8-97fe-001ec947cd2a")
public interface OccurrenceSpecification extends InteractionFragment {
    /**
     * The metaclass simple name.
     */
    @objid ("4565f273-8ba4-40e8-8cf0-70bc6bde2b7b")
    public static final String MNAME = "OccurrenceSpecification";

    /**
     * The metaclass qualified name.
     */
    @objid ("de66d595-359e-4ba8-afd9-de07e52fbf49")
    public static final String MQNAME = "Standard.OccurrenceSpecification";

    /**
     * Getter for relation 'OccurrenceSpecification->ToAfter'
     *
     * Metamodel description:
     * <i>NOT TO DOCUMENT : References the GeneralOrderings that specify EventOcurrences that must occur after this OccurrenceSpecification.</i>
     */
    @objid ("977a6783-4d78-48cf-85e8-d908201a227b")
    EList<GeneralOrdering> getToAfter();

    /**
     * Filtered Getter for relation 'OccurrenceSpecification->ToAfter'
     *
     * Metamodel description:
     * <i>NOT TO DOCUMENT : References the GeneralOrderings that specify EventOcurrences that must occur after this OccurrenceSpecification.</i>
     */
    @objid ("80d2ad7f-db10-474b-b64f-bfb8f5820d4d")
    <T extends GeneralOrdering> List<T> getToAfter(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'OccurrenceSpecification->ToBefore'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("954a19b6-9be4-4132-a3b0-aaf9f8c893c1")
    EList<GeneralOrdering> getToBefore();

    /**
     * Filtered Getter for relation 'OccurrenceSpecification->ToBefore'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0119ce6b-f2cc-4bae-a797-a3dbc9c30d8b")
    <T extends GeneralOrdering> List<T> getToBefore(java.lang.Class<T> filterClass);

}
