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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * A Property instance type declaring the reference to a Property definition and containing the Property value.
 *
 *
 * <p>Classe Java pour PropertyType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="PropertyType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="value" type="{http://www.opengroup.org/xsd/archimate/3.0/}LangStringType" maxOccurs="unbounded"/>
 * &lt;/sequence>
 * &lt;attribute name="propertyDefinitionRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("3559b3c6-54a6-42a8-9687-1d7e82e89353")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyType", propOrder = {
    "value"
})
public class PropertyType {
    @objid ("ab411a0b-e7a5-4bce-8cbf-89f3c6f0f45b")
    @XmlElement(required = true)
    protected List<LangStringType> value;

    @objid ("423ab4fd-7a2d-497f-9496-7312d378f401")
    @XmlAttribute(name = "propertyDefinitionRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object propertyDefinitionRef;

    /**
     * Gets the value of the value property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getValue().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     */
    @objid ("ef6496a9-742a-4439-8893-1239346b0ffa")
    public List<LangStringType> getValue() {
        if (value == null) {
            value = new ArrayList<LangStringType>();
        }
        return this.value;
    }

    /**
     * Obtient la valeur de la propriété propertyDefinitionRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("3ff0d6ca-44a7-412b-babf-e1d69e58c6fc")
    public Object getPropertyDefinitionRef() {
        return propertyDefinitionRef;
    }

    /**
     * Définit la valeur de la propriété propertyDefinitionRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("77fa3c94-6bf3-4bcc-b7ef-3e426f416112")
    public void setPropertyDefinitionRef(Object value) {
        this.propertyDefinitionRef = value;
    }

}
