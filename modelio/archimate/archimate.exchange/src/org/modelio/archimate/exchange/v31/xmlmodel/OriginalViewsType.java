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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This is a container for all of the Views in the model.
 *
 *
 * <p>Classe Java pour ViewsType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewsType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="viewpoints" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointsType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("e201bc21-36e2-4f32-8e4e-d2466c4275b6")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "viewpoints"
})
@XmlSeeAlso({
    ViewsType.class
})
public class OriginalViewsType {
    @objid ("467ce4f0-8a98-4aca-a18c-032a170ca0cc")
    protected ViewpointsType viewpoints;

    /**
     * Obtient la valeur de la propriété viewpoints.
     *
     * @return possible object is
     * {@link ViewpointsType }
     */
    @objid ("15e28418-cf49-4a6d-8fba-8c315860f606")
    public ViewpointsType getViewpoints() {
        return viewpoints;
    }

    /**
     * Définit la valeur de la propriété viewpoints.
     *
     * @param value allowed object is
     * {@link ViewpointsType }
     */
    @objid ("28b1eefc-2b71-4791-8134-58a1906167a3")
    public void setViewpoints(ViewpointsType value) {
        this.viewpoints = value;
    }

}
