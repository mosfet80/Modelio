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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour ModelType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ModelType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ModelType">
 * &lt;redefine>
 * &lt;complexType name="ModelType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 * &lt;element name="metadata" type="{http://www.opengroup.org/xsd/archimate/3.0/}MetadataType" minOccurs="0"/>
 * &lt;element name="elements" type="{http://www.opengroup.org/xsd/archimate/3.0/}ElementsType" minOccurs="0"/>
 * &lt;element name="relationships" type="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipsType" minOccurs="0"/>
 * &lt;element name="organizations" type="{http://www.opengroup.org/xsd/archimate/3.0/}OrganizationsType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="propertyDefinitions" type="{http://www.opengroup.org/xsd/archimate/3.0/}PropertyDefinitionsType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * &lt;/redefine>
 * &lt;sequence>
 * &lt;element name="views" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewsType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("40fec2dc-16b0-4fe3-9e35-f16ec1028388")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelType", propOrder = {
    "views"
})
@XmlRootElement(name = "model", namespace = "http://www.opengroup.org/xsd/archimate/3.0/")
public class ModelType extends OriginalModelType {
    @objid ("db9b3238-4493-46c0-8064-1fec96c06e58")
    protected ViewsType views;

    /**
     * Obtient la valeur de la propriété views.
     *
     * @return possible object is
     * {@link ViewsType }
     */
    @objid ("5ff2fae5-f7f9-4207-979d-6253923e98e9")
    public ViewsType getViews() {
        return views;
    }

    /**
     * Définit la valeur de la propriété views.
     *
     * @param value allowed object is
     * {@link ViewsType }
     */
    @objid ("e6b919da-3019-4f5b-b0b9-83bd866ab3a9")
    public void setViews(ViewsType value) {
        this.views = value;
    }

}
