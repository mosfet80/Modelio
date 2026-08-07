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
 * CombinedFragment v0.0.9054
 *
 *
 * A combined fragment is defined by an interaction operator and corresponding interaction operands. Through the use of CombinedFragments the user will be able to describe a number of traces in a compact and concise manner. The semantics of a CombinedFragment depend on the interaction operator.
 *
 * Modelio specific:
 * Gates on CombinedFragments are not supported. In order to model the call and return from a CombinedFragment, create messages just before or just after the CombinedFragment.
 *
 *
 */
@objid ("00435a1c-c4bf-1fd8-97fe-001ec947cd2a")
public interface CombinedFragment extends InteractionFragment {
    /**
     * The metaclass simple name.
     */
    @objid ("5aa8ccfc-b319-4ff8-b616-7969a6ea4145")
    public static final String MNAME = "CombinedFragment";

    /**
     * The metaclass qualified name.
     */
    @objid ("e66e7b52-00ba-4a3c-adfe-43c29000ae64")
    public static final String MQNAME = "Standard.CombinedFragment";

    /**
     * Getter for attribute 'CombinedFragment.Operator'
     *
     * Metamodel description:
     * <i>Specifies the operation that defines the semantics of this combination of InteractionFragments. The default value is seq.</i>
     */
    @objid ("365d33f4-c9a7-480e-9541-da8bf0d7c2f4")
    InteractionOperator getOperator();

    /**
     * Setter for attribute 'CombinedFragment.Operator'
     *
     * Metamodel description:
     * <i>Specifies the operation that defines the semantics of this combination of InteractionFragments. The default value is seq.</i>
     */
    @objid ("ecb37444-abaf-4a65-9fed-1a9a2f0ef003")
    void setOperator(InteractionOperator value);

    /**
     * Getter for relation 'CombinedFragment->Operand'
     *
     * Metamodel description:
     * <i>The set of operands of the combined fragment. </i>
     */
    @objid ("3d409610-2648-48f8-ab06-2982482e6cc7")
    EList<InteractionOperand> getOperand();

    /**
     * Filtered Getter for relation 'CombinedFragment->Operand'
     *
     * Metamodel description:
     * <i>The set of operands of the combined fragment. </i>
     */
    @objid ("86f1878c-2f2c-4363-89b8-96508851c7e9")
    <T extends InteractionOperand> List<T> getOperand(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'CombinedFragment->FragmentGate'
     *
     * Metamodel description:
     * <i>Not supported in sequence diagrams:
     * Specifies the gates that form the interface between this CombinedFragment and its surroundings.</i>
     */
    @objid ("2e8fa3a9-1900-45eb-be98-6214afd8d725")
    EList<Gate> getFragmentGate();

    /**
     * Filtered Getter for relation 'CombinedFragment->FragmentGate'
     *
     * Metamodel description:
     * <i>Not supported in sequence diagrams:
     * Specifies the gates that form the interface between this CombinedFragment and its surroundings.</i>
     */
    @objid ("d7f0a3a0-bfba-4ed0-8111-23299a489428")
    <T extends Gate> List<T> getFragmentGate(java.lang.Class<T> filterClass);

}
