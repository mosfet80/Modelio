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
 * This is an abstract class for Concepts (Elements, Relationships, Composites, and RelationConnectors).
 *
 *
 * <p>Classe Java pour ConceptType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ConceptType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ReferenceableType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptGroup"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptAttributeGroup"/>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("a0ccaa06-fb47-42f4-9c06-2ccc45e9e651")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptType", propOrder = {
    "properties"
})
@XmlSeeAlso({
    RelationshipType.class,
    ElementType.class
})
public abstract class ConceptType extends ReferenceableType {
    @objid ("27981015-aa51-4bc7-81e1-73a09230494e")
    protected PropertiesType properties;

    /**
     * Obtient la valeur de la propriété properties.
     *
     * @return possible object is
     * {@link PropertiesType }
     */
    @objid ("0a5a1368-77c6-4510-afc5-3a45ca01dd27")
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Définit la valeur de la propriété properties.
     *
     * @param value allowed object is
     * {@link PropertiesType }
     */
    @objid ("aa8e6f52-68d0-4165-9437-71cd662d8ecc")
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

}
