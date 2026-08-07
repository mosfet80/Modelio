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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * This is an abstract super-type of Node and Connection.
 *
 *
 * <p>Classe Java pour ViewConceptType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewConceptType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="style" type="{http://www.opengroup.org/xsd/archimate/3.0/}StyleType" minOccurs="0"/>
 * &lt;element name="viewRef" type="{http://www.opengroup.org/xsd/archimate/3.0/}ReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}IdentifierGroup"/>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("c79ce4f5-4929-4d72-baff-b9c5bd5ff194")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewConceptType", propOrder = {
    "labelGroup",
    "documentationGroup",
    "style",
    "viewRef"
})
@XmlSeeAlso({
    ViewNodeType.class,
    ConnectionType.class
})
public abstract class ViewConceptType {
    @objid ("0611ded9-0ffa-4a30-b1b4-040842895ace")
    @XmlAttribute(name = "identifier", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String identifier;

    @objid ("222c1d1b-992a-42c0-bda5-4f495844d1c2")
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @objid ("1eaeee91-2043-4ded-b52d-8880637e9035")
    @XmlElement(name = "label")
    protected List<LangStringType> labelGroup;

    @objid ("bfd4fcd3-6609-4804-9b99-1853fcc32262")
    @XmlElement(name = "documentation")
    protected List<PreservedLangStringType> documentationGroup;

    @objid ("25ecc104-7a4f-45e4-9807-2e465434c9c5")
    protected StyleType style;

    @objid ("2b659aa7-5ed3-4913-89f8-4978a3cb3692")
    protected List<ReferenceType> viewRef;

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
    @objid ("8701d57d-a760-4834-b1aa-b05e888378a0")
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
    @objid ("d6195bda-5efe-4e54-a1fd-bd199e3cf274")
    public List<PreservedLangStringType> getDocumentationGroup() {
        if (documentationGroup == null) {
            documentationGroup = new ArrayList<PreservedLangStringType>();
        }
        return this.documentationGroup;
    }

    /**
     * Obtient la valeur de la propriété style.
     *
     * @return possible object is
     * {@link StyleType }
     */
    @objid ("64251c34-c208-4788-856b-8b2840444b55")
    public StyleType getStyle() {
        return style;
    }

    /**
     * Définit la valeur de la propriété style.
     *
     * @param value allowed object is
     * {@link StyleType }
     */
    @objid ("ce39798d-a3e1-419e-85a6-fcdb884113fd")
    public void setStyle(StyleType value) {
        this.style = value;
    }

    /**
     * Gets the value of the viewRef property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewRef property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getViewRef().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     */
    @objid ("353e6e9b-0478-4f43-b83d-b56a3b8f1d10")
    public List<ReferenceType> getViewRef() {
        if (viewRef == null) {
            viewRef = new ArrayList<ReferenceType>();
        }
        return this.viewRef;
    }

    /**
     * Obtient la valeur de la propriété identifier.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("28f4d300-1cbc-4406-a301-de9382ee2a09")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Définit la valeur de la propriété identifier.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("8695e1a8-a3c4-4473-ac53-2ab24c7efefc")
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
    @objid ("67222fdd-9767-4a5b-8fe0-651f1bbd3730")
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
