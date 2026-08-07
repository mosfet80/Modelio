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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * NaryLinkEnd v0.0.9054
 *
 *
 * Nouvelle Class :
 * Extrémité de lien en contact avec une instance. Participe à la définition d'une occurence d'association.
 * Appartient à une Instance, est associé à un Link et représente une AssociationEnd.
 *
 * Une NaryLinkEnd est reliée à une Instance uniquement.
 *
 */
@objid ("00749ece-17e8-10a1-88a0-001ec947cd2a")
public interface NaryLinkEnd extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("0bdd86ba-2f6b-4b53-89ce-a2ce300edb94")
    public static final String MNAME = "NaryLinkEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("31c51857-221e-40e9-a562-b3f90bbb3ee8")
    public static final String MQNAME = "Standard.NaryLinkEnd";

    /**
     * Getter for attribute 'NaryLinkEnd.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("25f179de-2ac8-4f4f-825f-1fedc776abf8")
    boolean isIsOrdered();

    /**
     * Setter for attribute 'NaryLinkEnd.IsOrdered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("36a966a3-a9be-45d6-81fb-032c6d7cc132")
    void setIsOrdered(boolean value);

    /**
     * Getter for attribute 'NaryLinkEnd.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e84d2b22-8b67-4b54-a09f-ae00ed575016")
    boolean isIsUnique();

    /**
     * Setter for attribute 'NaryLinkEnd.IsUnique'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7aa7d32d-6350-4bed-85aa-8c38207872e3")
    void setIsUnique(boolean value);

    /**
     * Getter for attribute 'NaryLinkEnd.MultiplicityMax'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("36141876-605c-4a0b-9510-a95e7319dfab")
    String getMultiplicityMax();

    /**
     * Setter for attribute 'NaryLinkEnd.MultiplicityMax'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("45caaa0d-e42c-410f-a40b-9978d297ab91")
    void setMultiplicityMax(String value);

    /**
     * Getter for attribute 'NaryLinkEnd.MultiplicityMin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("52eaee0c-f5c4-4368-882d-98a62af1acb0")
    String getMultiplicityMin();

    /**
     * Setter for attribute 'NaryLinkEnd.MultiplicityMin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f10286ab-3c40-452b-9307-1b457a1027a4")
    void setMultiplicityMin(String value);

    /**
     * Getter for relation 'NaryLinkEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("937e24a5-f3c7-4840-9756-381b128f1b7f")
    Instance getSource();

    /**
     * Setter for relation 'NaryLinkEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("39acc920-c77a-407c-a6b9-697b603960ff")
    void setSource(Instance value);

    /**
     * Getter for relation 'NaryLinkEnd->NaryLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e398cd1a-957f-44f6-9ae8-2eee1bb68ee7")
    NaryLink getNaryLink();

    /**
     * Setter for relation 'NaryLinkEnd->NaryLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b9080ffc-24f8-4f38-bda3-c7be7994ac74")
    void setNaryLink(NaryLink value);

    /**
     * Getter for relation 'NaryLinkEnd->Consumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a2b9ce47-f3ee-4345-b6cc-8e703f749190")
    RequiredInterface getConsumer();

    /**
     * Setter for relation 'NaryLinkEnd->Consumer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dec7d829-b580-463b-af07-605e3d6a0c25")
    void setConsumer(RequiredInterface value);

    /**
     * Getter for relation 'NaryLinkEnd->Provider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e1b1fd26-8735-40a6-a4b8-207bdba328f7")
    ProvidedInterface getProvider();

    /**
     * Setter for relation 'NaryLinkEnd->Provider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0ab0ff14-8386-40d8-961d-49b5f90162fb")
    void setProvider(ProvidedInterface value);

}
