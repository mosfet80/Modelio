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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * This is the root model type.
 * It is a container for the elements, relationships, diagrams and organizations of the model.
 *
 *
 * <p>Classe Java pour ModelType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
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
 * </pre>
 */
@objid ("bbc05a96-4d67-413d-bb50-fe3128cc1403")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "properties",
    "metadata",
    "elements",
    "relationships",
    "organizations",
    "propertyDefinitions"
})
@XmlSeeAlso({
    ModelType.class
})
public class OriginalModelType extends NamedReferenceableType {
    @objid ("2fc8268f-e147-4ccb-ae16-e5ccb2b9d103")
    @XmlAttribute(name = "version")
    protected String version;

    @objid ("1558c046-5c36-45e8-98c0-828d2127d2bc")
    protected PropertiesType properties;

    @objid ("c08f67f0-01ce-4e3f-bb91-219d5439c923")
    protected MetadataType metadata;

    @objid ("6ac3d5a6-d74d-45f7-a216-1e2bd85f6371")
    protected ElementsType elements;

    @objid ("197d0233-c891-4103-9912-00f2bde0e3e7")
    protected RelationshipsType relationships;

    @objid ("e5645636-1e62-4c3d-af50-f453502eb2bd")
    protected List<OrganizationsType> organizations;

    @objid ("c4d8708b-cd5c-4cdd-b89a-b8fe48560d9b")
    protected PropertyDefinitionsType propertyDefinitions;

    /**
     * Obtient la valeur de la propriété properties.
     *
     * @return possible object is
     * {@link PropertiesType }
     */
    @objid ("e1d443df-6a7c-4bc4-b0f4-1f598217ba7f")
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Définit la valeur de la propriété properties.
     *
     * @param value allowed object is
     * {@link PropertiesType }
     */
    @objid ("6c6080a2-53e9-40d1-833e-967658859260")
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Obtient la valeur de la propriété metadata.
     *
     * @return possible object is
     * {@link MetadataType }
     */
    @objid ("e0a92307-aec9-4270-aee2-a3fef7eaf899")
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Définit la valeur de la propriété metadata.
     *
     * @param value allowed object is
     * {@link MetadataType }
     */
    @objid ("88030c99-3aa1-4f31-bbca-5d4aabc839d6")
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Obtient la valeur de la propriété elements.
     *
     * @return possible object is
     * {@link ElementsType }
     */
    @objid ("c832c413-6720-401b-837d-230e8ed7b46b")
    public ElementsType getElements() {
        return elements;
    }

    /**
     * Définit la valeur de la propriété elements.
     *
     * @param value allowed object is
     * {@link ElementsType }
     */
    @objid ("d83102eb-d493-4161-b679-4c0b2860d3c0")
    public void setElements(ElementsType value) {
        this.elements = value;
    }

    /**
     * Obtient la valeur de la propriété relationships.
     *
     * @return possible object is
     * {@link RelationshipsType }
     */
    @objid ("83e71534-ecd7-44ae-9411-c309b4312829")
    public RelationshipsType getRelationships() {
        return relationships;
    }

    /**
     * Définit la valeur de la propriété relationships.
     *
     * @param value allowed object is
     * {@link RelationshipsType }
     */
    @objid ("d20d3779-30ab-4b6c-b60b-9c7fc0150fdf")
    public void setRelationships(RelationshipsType value) {
        this.relationships = value;
    }

    /**
     * Gets the value of the organizations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getOrganizations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationsType }
     */
    @objid ("a711944c-d96d-4c91-b225-2e72a436f4f8")
    public List<OrganizationsType> getOrganizations() {
        if (organizations == null) {
            organizations = new ArrayList<OrganizationsType>();
        }
        return this.organizations;
    }

    /**
     * Obtient la valeur de la propriété propertyDefinitions.
     *
     * @return possible object is
     * {@link PropertyDefinitionsType }
     */
    @objid ("5ea65911-c593-4e11-8828-f7bfa94378ac")
    public PropertyDefinitionsType getPropertyDefinitions() {
        return propertyDefinitions;
    }

    /**
     * Définit la valeur de la propriété propertyDefinitions.
     *
     * @param value allowed object is
     * {@link PropertyDefinitionsType }
     */
    @objid ("d56f8453-3348-4bb6-8da4-cfd6ad24fc5c")
    public void setPropertyDefinitions(PropertyDefinitionsType value) {
        this.propertyDefinitions = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("cf049a1a-7387-4827-adc0-c5c6c48085aa")
    public String getVersion() {
        return version;
    }

    /**
     * Définit la valeur de la propriété version.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("6cedeb74-e5ff-4435-aff1-c9d43cec4a2c")
    public void setVersion(String value) {
        this.version = value;
    }

}
