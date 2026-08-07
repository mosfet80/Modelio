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
import jakarta.xml.bind.annotation.XmlType;

/**
 * This is a set of notes to the modeler on how to use and model with this viewpoint. Could contain rules
 * or constraints. The part hold the information for this element.
 *
 *
 * <p>Classe Java pour ModelingNoteType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ModelingNoteType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded"/>
 * &lt;/sequence>
 * &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("a8d15744-7aad-4409-86db-0692a715b902")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelingNoteType", propOrder = {
    "documentationGroup"
})
public class ModelingNoteType {
    @objid ("c7400455-67d4-43fa-8861-dc97057cdb02")
    @XmlAttribute(name = "type")
    protected String type;

    @objid ("1ab274f3-3467-4fbf-8d64-34574c676250")
    @XmlElement(name = "documentation")
    protected List<PreservedLangStringType> documentationGroup;

    /**
     * Gets the value of the documentationGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentationGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getDocumentationGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreservedLangStringType }
     */
    @objid ("36d29734-9c90-4af0-9f09-8b27f23bf8d7")
    public List<PreservedLangStringType> getDocumentationGroup() {
        if (documentationGroup == null) {
            documentationGroup = new ArrayList<PreservedLangStringType>();
        }
        return this.documentationGroup;
    }

    /**
     * Obtient la valeur de la propriété type.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("d0032ce7-36f8-4ebf-994e-f8c91ee6c2a6")
    public String getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("1c468bae-6168-496b-851f-e23e3538df45")
    public void setType(String value) {
        this.type = value;
    }

}
