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
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * NaryLink v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00223b3e-c4bf-1fd8-97fe-001ec947cd2a")
public interface NaryLink extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("472dd9d6-d85e-4840-9495-86cc4d63de3e")
    public static final String MNAME = "NaryLink";

    /**
     * The metaclass qualified name.
     */
    @objid ("a09c2f96-a80f-41a9-91bc-c0e6d440a807")
    public static final String MQNAME = "Standard.NaryLink";

    /**
     * Getter for relation 'NaryLink->NaryLinkEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1b1e38f6-ec28-4a49-8db6-26997bc0808c")
    EList<NaryLinkEnd> getNaryLinkEnd();

    /**
     * Filtered Getter for relation 'NaryLink->NaryLinkEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9c1e07d8-bf75-466a-94a4-50093a6f3746")
    <T extends NaryLinkEnd> List<T> getNaryLinkEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NaryLink->Model'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1d24329a-6062-4b4c-a860-a540c261b997")
    NaryAssociation getModel();

    /**
     * Setter for relation 'NaryLink->Model'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e5cafcc5-e68c-4d85-bad1-197f5019b745")
    void setModel(NaryAssociation value);

    /**
     * Getter for relation 'NaryLink->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f436c9ca-4469-4389-a7a6-1ed6084410b0")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'NaryLink->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("01de4376-af80-4d90-9430-222ddc124eb0")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NaryLink->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b107df67-12e0-4d7b-ac70-96fcc76d8af7")
    EList<CommunicationChannel> getSent();

    /**
     * Filtered Getter for relation 'NaryLink->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("04be9581-ee6a-4158-8c0b-df7eadd6fcb9")
    <T extends CommunicationChannel> List<T> getSent(java.lang.Class<T> filterClass);

}
