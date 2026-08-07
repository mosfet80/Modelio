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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Instance;

/**
 * Lifeline v0.0.9054
 *
 *
 * <p>A lifeline represents an individual participant in the Interaction. While Parts and StructuralFeatures may have multiplicity greater than 1, Lifelines represent only one interacting entity.</p><p>If the referenced Instance is multivalued (i.e, has a multiplicity &gt; 1), then the Lifeline may have an expression (the &quot;selector&quot;) that specifies which particular part is represented by this Lifeline. If the selector is omitted, this means that an arbitrary representative of the multivalued ConnectableElement is chosen.</p>
 *
 *
 */
@objid ("0048b5b6-c4bf-1fd8-97fe-001ec947cd2a")
public interface Lifeline extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("9a7c8da1-fdaf-481b-bda9-34d4f4e3a6cf")
    public static final String MNAME = "Lifeline";

    /**
     * The metaclass qualified name.
     */
    @objid ("2bbc3592-4679-43e6-9602-96168258a312")
    public static final String MQNAME = "Standard.Lifeline";

    /**
     * Getter for attribute 'Lifeline.Selector'
     *
     * Metamodel description:
     * <i>If the referenced ConnectableElement is multivalued, then this specifies the specific individual part within that set.</i>
     */
    @objid ("d14a9a7c-de20-4275-9d85-038830183f4d")
    String getSelector();

    /**
     * Setter for attribute 'Lifeline.Selector'
     *
     * Metamodel description:
     * <i>If the referenced ConnectableElement is multivalued, then this specifies the specific individual part within that set.</i>
     */
    @objid ("26a210c3-103a-4d25-94af-d4102cd58e39")
    void setSelector(String value);

    /**
     * Getter for relation 'Lifeline->CoveredBy'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aabfddba-18fb-49ef-b275-2a32d016e5d6")
    EList<InteractionFragment> getCoveredBy();

    /**
     * Filtered Getter for relation 'Lifeline->CoveredBy'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("03116a6d-463e-4458-b4b1-3bba6c0dc653")
    <T extends InteractionFragment> List<T> getCoveredBy(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Lifeline->DecomposedAs'
     *
     * Metamodel description:
     * <i>References the Interaction that represents the decomposition.</i>
     */
    @objid ("964e15b0-794c-45f2-a33a-9133ca6a191f")
    PartDecomposition getDecomposedAs();

    /**
     * Setter for relation 'Lifeline->DecomposedAs'
     *
     * Metamodel description:
     * <i>References the Interaction that represents the decomposition.</i>
     */
    @objid ("5e3477ec-ac09-4d39-ac04-452aaa0809db")
    void setDecomposedAs(PartDecomposition value);

    /**
     * Getter for relation 'Lifeline->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("75de0c8e-faf8-4b2f-bfb2-141a974d95ce")
    Interaction getOwner();

    /**
     * Setter for relation 'Lifeline->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("27f0526a-a9c1-47d1-87c6-c9b9a08cf9ad")
    void setOwner(Interaction value);

    /**
     * Getter for relation 'Lifeline->Represented'
     *
     * Metamodel description:
     * <i>References the Instance the Lifeline represents.</i>
     */
    @objid ("9fc98241-b0b0-4356-a52d-29c7bc95c61e")
    Instance getRepresented();

    /**
     * Setter for relation 'Lifeline->Represented'
     *
     * Metamodel description:
     * <i>References the Instance the Lifeline represents.</i>
     */
    @objid ("45f082cf-53b5-44ef-ae60-3f7a68462783")
    void setRepresented(Instance value);

}
