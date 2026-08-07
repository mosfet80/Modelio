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
 * AttributeLink v0.0.9054
 *
 *
 * An AttributeLink defines an Attribute's value at instance level. AttributeLinks appear attached to Instances or Parts.
 *
 * In UML 2.0, attribute links are called slots.
 *
 * In Modelio, an AttributeLink belongs to an Instance.
 *
 *
 */
@objid ("009893c4-c4be-1fd8-97fe-001ec947cd2a")
public interface AttributeLink extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("ecdbe5fd-a3cd-46a3-ab08-ec05b0cf49fd")
    public static final String MNAME = "AttributeLink";

    /**
     * The metaclass qualified name.
     */
    @objid ("5b1d277e-6a2a-4b3a-bc5c-5fa0f40423a3")
    public static final String MQNAME = "Standard.AttributeLink";

    /**
     * Getter for attribute 'AttributeLink.Value'
     *
     * Metamodel description:
     * <i>Current value of the Attribute's Slot for the Instance.</i>
     */
    @objid ("e66fb344-f431-4c05-8121-35ba21ab9b60")
    String getValue();

    /**
     * Setter for attribute 'AttributeLink.Value'
     *
     * Metamodel description:
     * <i>Current value of the Attribute's Slot for the Instance.</i>
     */
    @objid ("28da1fa0-988d-4f25-bf2a-dcf93902ee57")
    void setValue(String value);

    /**
     * Getter for relation 'AttributeLink->Attributed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("859b6687-a30c-4f31-9f96-baceeb0c45ba")
    Instance getAttributed();

    /**
     * Setter for relation 'AttributeLink->Attributed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("84b3c4b8-e693-4045-8631-f9e85fd528a9")
    void setAttributed(Instance value);

    /**
     * Getter for relation 'AttributeLink->Base'
     *
     * Metamodel description:
     * <i>Defines the optional Attribute that specifies the AttributeLink.</i>
     */
    @objid ("6e17cc08-502e-4563-a715-526edfcfae42")
    Attribute getBase();

    /**
     * Setter for relation 'AttributeLink->Base'
     *
     * Metamodel description:
     * <i>Defines the optional Attribute that specifies the AttributeLink.</i>
     */
    @objid ("86e45687-9577-47ec-98a6-1770362bef0f")
    void setBase(Attribute value);

}
