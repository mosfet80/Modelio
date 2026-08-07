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

/**
 * InteractionFragment v0.0.9054
 *
 *
 * InteractionFragment is an abstract notion of the most general interaction unit. An interaction fragment is a piece of an interaction.
 *
 * InteractionFragments sequencing information is handled by an internal feature that is not directly accessible.
 *
 * The Joni Java API provides methods to access the ordering of InteractionFragments.
 *
 */
@objid ("004713c8-c4bf-1fd8-97fe-001ec947cd2a")
public interface InteractionFragment extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("2c142926-ac70-4550-beb6-cf9d786cd08d")
    public static final String MNAME = "InteractionFragment";

    /**
     * The metaclass qualified name.
     */
    @objid ("04fe66d1-185b-49c5-abe1-280580adb7c8")
    public static final String MQNAME = "Standard.InteractionFragment";

    /**
     * Getter for attribute 'InteractionFragment.LineNumber'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("8706114b-a6a6-4a36-85eb-fc01e1e2edb2")
    int getLineNumber();

    /**
     * Setter for attribute 'InteractionFragment.LineNumber'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("09e33d4e-42dc-4af9-8c4b-36ef2bf55436")
    void setLineNumber(int value);

    /**
     * Getter for relation 'InteractionFragment->EnclosingOperand'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("666ab6ca-77aa-4dc6-81d1-fcb82f5f2dd4")
    InteractionOperand getEnclosingOperand();

    /**
     * Setter for relation 'InteractionFragment->EnclosingOperand'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("251dc711-ba78-4e45-9a60-f5edb6184afc")
    void setEnclosingOperand(InteractionOperand value);

    /**
     * Getter for relation 'InteractionFragment->EnclosingInteraction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9da2a665-17ca-49c1-98dd-dbd2921579dd")
    Interaction getEnclosingInteraction();

    /**
     * Setter for relation 'InteractionFragment->EnclosingInteraction'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8807ad9e-29a9-4de3-b3df-7c017c06895d")
    void setEnclosingInteraction(Interaction value);

    /**
     * Getter for relation 'InteractionFragment->Covered'
     *
     * Metamodel description:
     * <i>References the Lifelines that the InteractionFragment involves.</i>
     */
    @objid ("87c5c8b2-6762-469d-ae22-baca7f2aef65")
    EList<Lifeline> getCovered();

    /**
     * Filtered Getter for relation 'InteractionFragment->Covered'
     *
     * Metamodel description:
     * <i>References the Lifelines that the InteractionFragment involves.</i>
     */
    @objid ("585fc81b-f904-46ad-baa0-02f5af95d92c")
    <T extends Lifeline> List<T> getCovered(java.lang.Class<T> filterClass);

}
