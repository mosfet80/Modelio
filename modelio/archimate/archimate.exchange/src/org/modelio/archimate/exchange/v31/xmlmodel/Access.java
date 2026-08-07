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
//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source.
// Généré le : 2019.08.22 à 10:16:32 AM CEST
//
package org.modelio.archimate.exchange.v31.xmlmodel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour Access complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Access">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipType">
 * &lt;attribute name="accessType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AccessTypeEnum" default="Access" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("0d2a91ba-ecc5-4d18-b560-95beea81e315")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Access")
public class Access extends RelationshipType {
    @objid ("61012a9b-744b-408a-8a61-7c9278b75549")
    @XmlAttribute(name = "accessType")
    protected AccessTypeEnum accessType;

    /**
     * Obtient la valeur de la propriété accessType.
     *
     * @return possible object is
     * {@link AccessTypeEnum }
     */
    @objid ("b582c4f6-2c31-47a1-9594-8f9783a07bee")
    public AccessTypeEnum getAccessType() {
        if (accessType == null) {
            return AccessTypeEnum.ACCESS;
        } else {
            return accessType;
        }

    }

    /**
     * Définit la valeur de la propriété accessType.
     *
     * @param value allowed object is
     * {@link AccessTypeEnum }
     */
    @objid ("ae1f698e-6c70-408c-b8bd-8933ad683ace")
    public void setAccessType(AccessTypeEnum value) {
        this.accessType = value;
    }

}
