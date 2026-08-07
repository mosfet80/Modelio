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
 * A Property definition type containing its unique identifier, name, and data type.
 *
 *
 * <p>Classe Java pour PropertyDefinitionType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="PropertyDefinitionType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 * &lt;attribute name="type" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}DataType" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("41b6c05c-85da-4301-947b-6488fca72820")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyDefinitionType")
public class PropertyDefinitionType extends NamedReferenceableType {
    @objid ("fcdea0c8-b823-4eaf-9ba4-50a6e242115b")
    @XmlAttribute(name = "type", required = true)
    protected DataType type;

    /**
     * Obtient la valeur de la propriété type.
     *
     * @return possible object is
     * {@link DataType }
     */
    @objid ("1a2962a0-37a6-4042-adfe-8de7fe9a18b5")
    public DataType getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     *
     * @param value allowed object is
     * {@link DataType }
     */
    @objid ("9c7c1c2f-bc11-4729-b2ba-669c0916977d")
    public void setType(DataType value) {
        this.type = value;
    }

}
