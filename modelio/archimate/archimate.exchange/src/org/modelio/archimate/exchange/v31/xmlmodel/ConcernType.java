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
 * document attribute holds all the concern information.
 *
 *
 * <p>Classe Java pour ConcernType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ConcernType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="stakeholders" type="{http://www.opengroup.org/xsd/archimate/3.0/}StakeholdersType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("4fad7610-c49c-4dca-88c1-236bf836895e")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcernType", propOrder = {
    "labelGroup",
    "documentationGroup",
    "stakeholders"
})
public class ConcernType {
    @objid ("bf6a8cbc-cea2-4ad8-8feb-a99d005c5751")
    @XmlElement(name = "label", required = true)
    protected List<LangStringType> labelGroup;

    @objid ("065fd5e6-658e-4275-84bb-886102286ac7")
    @XmlElement(name = "documentation")
    protected List<PreservedLangStringType> documentationGroup;

    @objid ("5f12a6ed-0d91-45a6-9122-c0f9320d9dc3")
    protected StakeholdersType stakeholders;

    /**
     * Gets the value of the labelGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getLabelGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     */
    @objid ("589e2eeb-4549-4877-b71e-bfd4ef912d10")
    public List<LangStringType> getLabelGroup() {
        if (labelGroup == null) {
            labelGroup = new ArrayList<LangStringType>();
        }
        return this.labelGroup;
    }

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
    @objid ("b8b76e16-fd7d-4441-909c-1f5b7e0481dc")
    public List<PreservedLangStringType> getDocumentationGroup() {
        if (documentationGroup == null) {
            documentationGroup = new ArrayList<PreservedLangStringType>();
        }
        return this.documentationGroup;
    }

    /**
     * Obtient la valeur de la propriété stakeholders.
     *
     * @return possible object is
     * {@link StakeholdersType }
     */
    @objid ("74021c9d-14e1-4274-95b2-1b7854e215ac")
    public StakeholdersType getStakeholders() {
        return stakeholders;
    }

    /**
     * Définit la valeur de la propriété stakeholders.
     *
     * @param value allowed object is
     * {@link StakeholdersType }
     */
    @objid ("30b69a5c-64ba-4c3b-9178-853e4ec7fbb7")
    public void setStakeholders(StakeholdersType value) {
        this.stakeholders = value;
    }

}
