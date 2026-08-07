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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This is a container for the Organizations of the model.
 *
 *
 * <p>Classe Java pour OrganizationsType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="OrganizationsType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="item" type="{http://www.opengroup.org/xsd/archimate/3.0/}OrganizationType" maxOccurs="unbounded"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("33c665c1-60f5-421d-979a-a3847b2a4e8a")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationsType", propOrder = {
    "item"
})
public class OrganizationsType {
    @objid ("393e86a9-e2e9-4aae-8994-f7d9b86ee20e")
    @XmlElement(required = true)
    protected List<OrganizationType> item;

    /**
     * Gets the value of the item property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationType }
     */
    @objid ("03011a84-54b3-4caf-b296-b96937bd5cd5")
    public List<OrganizationType> getItem() {
        if (item == null) {
            item = new ArrayList<OrganizationType>();
        }
        return this.item;
    }

}
