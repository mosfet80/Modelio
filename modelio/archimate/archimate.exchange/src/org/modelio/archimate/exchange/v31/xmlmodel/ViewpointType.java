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
import jakarta.xml.bind.annotation.XmlList;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour ViewpointType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewpointType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 * &lt;element name="concern" type="{http://www.opengroup.org/xsd/archimate/3.0/}ConcernType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="viewpointPurpose" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointPurposeType" minOccurs="0"/>
 * &lt;element name="viewpointContent" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointContentType" minOccurs="0"/>
 * &lt;element name="allowedElementType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AllowedElementTypeType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="allowedRelationshipType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AllowedRelationshipTypeType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="modelingNote" type="{http://www.opengroup.org/xsd/archimate/3.0/}ModelingNoteType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("1d40d30f-72d4-4074-9b98-3b03c3e80f52")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewpointType", propOrder = {
    "properties",
    "concern",
    "viewpointPurpose",
    "viewpointContent",
    "allowedElementType",
    "allowedRelationshipType",
    "modelingNote"
})
public class ViewpointType extends NamedReferenceableType {
    @objid ("2bfa7322-ee77-4628-98b8-cc443dfdf048")
    @XmlList
    protected List<ViewpointPurposeEnum> viewpointPurpose;

    @objid ("011d4a8e-0e68-457f-98a5-24caf0974913")
    @XmlList
    protected List<ViewpointContentEnum> viewpointContent;

    @objid ("57e6a676-7408-407c-aef3-8661f66f8718")
    protected PropertiesType properties;

    @objid ("725af764-d237-486b-ad17-a1ae6e9d8b27")
    protected List<ConcernType> concern;

    @objid ("ec17a3b3-80a7-432d-8a7f-dc335fe0bfee")
    protected List<AllowedElementTypeType> allowedElementType;

    @objid ("3800376c-3d5d-45ff-b03e-bc58765ca0ba")
    protected List<AllowedRelationshipTypeType> allowedRelationshipType;

    @objid ("5bd691f1-143a-42ad-8add-1e805332d649")
    protected List<ModelingNoteType> modelingNote;

    /**
     * Obtient la valeur de la propriété properties.
     *
     * @return possible object is
     * {@link PropertiesType }
     */
    @objid ("fbe2fd36-0e66-40d6-8652-e411d07f392a")
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Définit la valeur de la propriété properties.
     *
     * @param value allowed object is
     * {@link PropertiesType }
     */
    @objid ("e3197d9f-6ee8-41a1-9b86-336f581e92f4")
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Gets the value of the concern property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concern property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getConcern().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcernType }
     */
    @objid ("c2030b24-bae2-4e2a-b884-5fa81a72ed0c")
    public List<ConcernType> getConcern() {
        if (concern == null) {
            concern = new ArrayList<ConcernType>();
        }
        return this.concern;
    }

    /**
     * Gets the value of the viewpointPurpose property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewpointPurpose property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getViewpointPurpose().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViewpointPurposeEnum }
     */
    @objid ("efab27b6-6963-4bea-a014-a4565420af4d")
    public List<ViewpointPurposeEnum> getViewpointPurpose() {
        if (viewpointPurpose == null) {
            viewpointPurpose = new ArrayList<ViewpointPurposeEnum>();
        }
        return this.viewpointPurpose;
    }

    /**
     * Gets the value of the viewpointContent property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewpointContent property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getViewpointContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViewpointContentEnum }
     */
    @objid ("67d5fec1-8713-4666-96d1-577afa42c198")
    public List<ViewpointContentEnum> getViewpointContent() {
        if (viewpointContent == null) {
            viewpointContent = new ArrayList<ViewpointContentEnum>();
        }
        return this.viewpointContent;
    }

    /**
     * Gets the value of the allowedElementType property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedElementType property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getAllowedElementType().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedElementTypeType }
     */
    @objid ("e47a38ed-6e44-4096-aca0-a8a0f877aba2")
    public List<AllowedElementTypeType> getAllowedElementType() {
        if (allowedElementType == null) {
            allowedElementType = new ArrayList<AllowedElementTypeType>();
        }
        return this.allowedElementType;
    }

    /**
     * Gets the value of the allowedRelationshipType property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedRelationshipType property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getAllowedRelationshipType().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedRelationshipTypeType }
     */
    @objid ("33c26b8a-9ab4-4a48-962d-135579e25575")
    public List<AllowedRelationshipTypeType> getAllowedRelationshipType() {
        if (allowedRelationshipType == null) {
            allowedRelationshipType = new ArrayList<AllowedRelationshipTypeType>();
        }
        return this.allowedRelationshipType;
    }

    /**
     * Gets the value of the modelingNote property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelingNote property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getModelingNote().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModelingNoteType }
     */
    @objid ("bf403bf4-0eb9-42db-a8d4-7bb10111afda")
    public List<ModelingNoteType> getModelingNote() {
        if (modelingNote == null) {
            modelingNote = new ArrayList<ModelingNoteType>();
        }
        return this.modelingNote;
    }

}
