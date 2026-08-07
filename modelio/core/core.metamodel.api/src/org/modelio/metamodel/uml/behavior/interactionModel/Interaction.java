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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * Interaction v0.0.9054
 *
 *
 * Interactions are units of behavior of an enclosing Classifier. Interactions focus on the passing of information with Messages between the Instances, Attributes, Parameters, ...  of the Classifier or the Operation.
 *
 * An Interaction belongs to a NameSpace or an Operation.
 *
 * The interaction is composed of Lifelines and InteractionFragments, some of them send or receive Messages.
 *
 * InteractionFragments are ordered by an internal feature that is not directly accessible.
 *
 * The Joni Java API provides methods to access the ordering of InteractionFragments.
 *
 */
@objid ("004683fe-c4bf-1fd8-97fe-001ec947cd2a")
public interface Interaction extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("850cff5f-f88b-4f6e-a45a-687551dda9bf")
    public static final String MNAME = "Interaction";

    /**
     * The metaclass qualified name.
     */
    @objid ("a1806ea5-a8ab-457a-ae36-f8b17ed323ff")
    public static final String MQNAME = "Standard.Interaction";

    /**
     * Getter for relation 'Interaction->FormalGate'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("e48d484d-2d45-4e99-b36c-76b09eec7909")
    EList<Gate> getFormalGate();

    /**
     * Filtered Getter for relation 'Interaction->FormalGate'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("dcf1898a-94f5-4eb4-82fa-828ac0a78d21")
    <T extends Gate> List<T> getFormalGate(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Interaction->Fragment'
     *
     * Metamodel description:
     * <i>The set of fragments in the Interaction.</i>
     */
    @objid ("8622695b-d57c-429b-85aa-33c6a65f0818")
    EList<InteractionFragment> getFragment();

    /**
     * Filtered Getter for relation 'Interaction->Fragment'
     *
     * Metamodel description:
     * <i>The set of fragments in the Interaction.</i>
     */
    @objid ("8ed9a4fb-7c17-4561-9f3e-11d78faee479")
    <T extends InteractionFragment> List<T> getFragment(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Interaction->OwnedLine'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("893c1648-a527-41c6-bf2d-3600890ea04b")
    EList<Lifeline> getOwnedLine();

    /**
     * Filtered Getter for relation 'Interaction->OwnedLine'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("8d511280-3cbf-441e-80de-2182c866aca7")
    <T extends Lifeline> List<T> getOwnedLine(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Interaction->ReferedUse'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e2b31284-221f-4df5-b2a4-2be2b8037c5e")
    EList<InteractionUse> getReferedUse();

    /**
     * Filtered Getter for relation 'Interaction->ReferedUse'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c8fc547a-39b2-431c-b9dd-2d1c5c9fe844")
    <T extends InteractionUse> List<T> getReferedUse(java.lang.Class<T> filterClass);

}
