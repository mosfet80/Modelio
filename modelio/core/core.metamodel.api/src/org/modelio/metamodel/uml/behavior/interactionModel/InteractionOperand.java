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
 * InteractionOperand v0.0.9054
 *
 *
 * An InteractionOperand is contained in a CombinedFragment and contains an ordered set of InteractionFragments. It represents one operand of the expression given by the enclosing CombinedFragment.
 *
 * An InteractionOperand has an optional guard expression. Only InteractionOperands with a guard that evaluates to true at this point in the interaction will be considered for the production of the traces for the enclosing CombinedFragment.
 *
 */
@objid ("00479758-c4bf-1fd8-97fe-001ec947cd2a")
public interface InteractionOperand extends InteractionFragment {
    /**
     * The metaclass simple name.
     */
    @objid ("d075392c-7166-4d4d-af86-5f9e270fc3b5")
    public static final String MNAME = "InteractionOperand";

    /**
     * The metaclass qualified name.
     */
    @objid ("8f749f9c-ab11-4aaf-a60c-965ca22f8db8")
    public static final String MQNAME = "Standard.InteractionOperand";

    /**
     * Getter for attribute 'InteractionOperand.Guard'
     *
     * Metamodel description:
     * <i>Constraint of the operand.</i>
     */
    @objid ("72c54088-a2ed-438f-818d-2c61d4aac238")
    String getGuard();

    /**
     * Setter for attribute 'InteractionOperand.Guard'
     *
     * Metamodel description:
     * <i>Constraint of the operand.</i>
     */
    @objid ("a52b5d44-afa6-406d-a667-ec397d874fba")
    void setGuard(String value);

    /**
     * Getter for attribute 'InteractionOperand.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ddf7bb2b-6ec3-4bfd-b15c-4192d5fd867c")
    int getEndLineNumber();

    /**
     * Setter for attribute 'InteractionOperand.EndLineNumber'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f45776de-890c-4d69-ab09-afa5333bcc73")
    void setEndLineNumber(int value);

    /**
     * Getter for relation 'InteractionOperand->Fragment'
     *
     * Metamodel description:
     * <i>The fragments of the operand.</i>
     */
    @objid ("b25dcd8a-4e8e-4489-92a7-f921f92f9bbf")
    EList<InteractionFragment> getFragment();

    /**
     * Filtered Getter for relation 'InteractionOperand->Fragment'
     *
     * Metamodel description:
     * <i>The fragments of the operand.</i>
     */
    @objid ("4ad14244-7c1f-4867-af35-14ea1ad7a563")
    <T extends InteractionFragment> List<T> getFragment(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InteractionOperand->OwnerFragment'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cb56852f-bf75-46ee-8961-306acd3b7111")
    CombinedFragment getOwnerFragment();

    /**
     * Setter for relation 'InteractionOperand->OwnerFragment'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("03393a3a-333e-4641-854b-01bbb5785e1a")
    void setOwnerFragment(CombinedFragment value);

}
