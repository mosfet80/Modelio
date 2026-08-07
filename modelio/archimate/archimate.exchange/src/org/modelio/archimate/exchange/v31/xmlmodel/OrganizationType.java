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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * An organization element represents a structural node in a particular organization of the model concepts.
 * An organization element may be a parent or sibling of other organization elements,
 * each one representing a unique structural node.
 *
 * An organization element may reference an ArchiMate element, ArchiMate relationship,
 * or nothing (in which case it is a structural container)
 *
 * An organization has no meaning unless it has at least child organization element.
 *
 * Note that Organization must fit into a tree structure (so strictly nested).
 *
 *
 * <p>Classe Java pour OrganizationType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="OrganizationType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="item" type="{http://www.opengroup.org/xsd/archimate/3.0/}OrganizationType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}grp.any"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}OptionalIdentifierGroup"/>
 * &lt;attribute name="identifierRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("14cef583-c05d-4ba8-bf0b-2c1308dfcbb1")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType", propOrder = {
    "labelGroup",
    "documentationGroup",
    "item",
    "any"
})
public class OrganizationType {
    @objid ("b29226a1-38e9-405d-bde0-2559d23f1f55")
    @XmlAttribute(name = "identifier")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String identifier;

    @objid ("a248ee97-a6ae-4df2-b960-94b3beccc913")
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @objid ("3144c2c8-0371-40f8-a3f2-29ed22685d42")
    @XmlElement(name = "label")
    protected List<LangStringType> labelGroup;

    @objid ("f57f5344-0a5a-4387-9c6f-f4af7ab8bac8")
    @XmlElement(name = "documentation")
    protected List<PreservedLangStringType> documentationGroup;

    @objid ("b71cc303-c536-4a1b-9e22-a3270f6b26c9")
    protected List<OrganizationType> item;

    @objid ("c9963a1b-e21d-4f5f-8441-61b86d7df259")
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    @objid ("97c3f095-ce14-45c6-827a-b4b8461437f9")
    @XmlAttribute(name = "identifierRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object identifierRef;

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
    @objid ("cd96d4ef-c153-41db-85be-20f5609fd082")
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
    @objid ("ae44ad93-f476-478a-8c70-cc6c80fff6b7")
    public List<PreservedLangStringType> getDocumentationGroup() {
        if (documentationGroup == null) {
            documentationGroup = new ArrayList<PreservedLangStringType>();
        }
        return this.documentationGroup;
    }

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
    @objid ("37733b23-a285-46e4-96c2-aaef3ddecb98")
    public List<OrganizationType> getItem() {
        if (item == null) {
            item = new ArrayList<OrganizationType>();
        }
        return this.item;
    }

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    @objid ("9bcc2dfa-7e56-4cfa-bcab-7869e411f366")
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Obtient la valeur de la propriété identifierRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("ab7f3e6b-542b-4c1f-b7b1-c836d27a0159")
    public Object getIdentifierRef() {
        return identifierRef;
    }

    /**
     * Définit la valeur de la propriété identifierRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("cc1aba7d-0251-4097-a43b-2e8e7e7fa1c0")
    public void setIdentifierRef(Object value) {
        this.identifierRef = value;
    }

    /**
     * Obtient la valeur de la propriété identifier.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("22cf587f-671a-46ea-b339-834b17e33840")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Définit la valeur de la propriété identifier.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("dcc8de4e-7b3f-4113-aeb5-66651d460873")
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     *
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     *
     * @return always non-null
     */
    @objid ("e99eb4d0-aa95-4a89-8ab5-685e7c9853a4")
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
