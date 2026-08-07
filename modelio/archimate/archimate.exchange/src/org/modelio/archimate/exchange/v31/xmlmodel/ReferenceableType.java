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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * Something that can be referenced in the model.
 *
 *
 * <p>Classe Java pour ReferenceableType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ReferenceableType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}NameGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}grp.any"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}IdentifierGroup"/>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("ea0de1fd-86ef-4e26-9851-27abc6861914")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceableType", propOrder = {
    "nameGroup",
    "documentation",
    "any"
})
@XmlSeeAlso({
    NamedReferenceableType.class,
    ConceptType.class
})
public abstract class ReferenceableType {
    @objid ("3afeaef9-301e-4133-9b6d-dc9cd496293b")
    @XmlAttribute(name = "identifier", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String identifier;

    @objid ("99496d91-5d6a-4fff-a93a-174184838e87")
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    @objid ("eda05d97-9b10-4745-b9d1-e5cf2042911f")
    @XmlElement(name = "name")
    protected List<LangStringType> nameGroup;

    @objid ("9c01167d-d72f-4c0a-b195-678d433d6192")
    protected List<PreservedLangStringType> documentation;

    @objid ("2bad8af1-e246-495a-b392-e2a61eb6bc13")
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the nameGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getNameGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     */
    @objid ("155647a1-36a3-464c-a223-25437a22dd58")
    public List<LangStringType> getNameGroup() {
        if (nameGroup == null) {
            nameGroup = new ArrayList<LangStringType>();
        }
        return this.nameGroup;
    }

    /**
     * Gets the value of the documentation property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentation property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getDocumentation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreservedLangStringType }
     */
    @objid ("84cecd49-91d9-4acb-a01a-eaa0188aba69")
    public List<PreservedLangStringType> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<PreservedLangStringType>();
        }
        return this.documentation;
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
    @objid ("c953f023-5435-4653-8374-ab01712d61db")
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Obtient la valeur de la propriété identifier.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("3a1feb7d-0cda-431e-a3ee-269a9bd510b2")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Définit la valeur de la propriété identifier.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("f5269f47-6abb-40fb-9397-107f95ae3248")
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
    @objid ("a7e8cac4-599e-48e7-a2e8-2e65083124c5")
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
