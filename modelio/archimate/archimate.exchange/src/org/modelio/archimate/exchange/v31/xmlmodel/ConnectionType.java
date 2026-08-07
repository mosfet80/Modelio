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
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Graphical connection type.
 *
 * If the 'relationshipRef' attribute is present, the connection should reference an existing ArchiMate relationship.
 *
 * If the connection is an ArchiMate relationship type, the connection's label, documentation and properties may be determined
 * (i.e inherited) from those in the referenced ArchiMate relationship. Otherwise the connection's label, documentation and properties
 * can be provided and will be additional to (or over-ride) those contained in the referenced ArchiMate relationship.
 *
 *
 * <p>Classe Java pour ConnectionType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ConnectionType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewConceptType">
 * &lt;sequence>
 * &lt;element name="sourceAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 * &lt;element name="bendpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="targetAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attribute name="source" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("8bb4a2e4-06de-4e54-8043-1cd36770f8eb")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectionType", propOrder = {
    "sourceAttachment",
    "bendpoint",
    "targetAttachment"
})
@XmlSeeAlso({
    Line.class,
    SourcedConnectionType.class
})
public abstract class ConnectionType extends ViewConceptType {
    @objid ("6abce2c2-5144-4604-bc7f-a628613c8bec")
    protected LocationType sourceAttachment;

    @objid ("3de9ca0f-4e5e-4a4c-aa96-3b31769ee60e")
    protected List<LocationType> bendpoint;

    @objid ("6c5a03fb-f7e0-40a0-a682-ac718a37964c")
    protected LocationType targetAttachment;

    @objid ("05263cab-982c-488c-9f73-441b6be10ef9")
    @XmlAttribute(name = "source")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object source;

    @objid ("3fbac5a0-2bda-44cf-9b2d-1e8adbe518d0")
    @XmlAttribute(name = "target")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object target;

    /**
     * Obtient la valeur de la propriété sourceAttachment.
     *
     * @return possible object is
     * {@link LocationType }
     */
    @objid ("6c74a321-c82a-44fa-b85d-23edf6256126")
    public LocationType getSourceAttachment() {
        return sourceAttachment;
    }

    /**
     * Définit la valeur de la propriété sourceAttachment.
     *
     * @param value allowed object is
     * {@link LocationType }
     */
    @objid ("d99bc3b7-15e6-4013-8d40-b88c0964a85f")
    public void setSourceAttachment(LocationType value) {
        this.sourceAttachment = value;
    }

    /**
     * Gets the value of the bendpoint property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bendpoint property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getBendpoint().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     */
    @objid ("ca53d7d4-fe3a-4b97-bfa0-b17cb1df9d8a")
    public List<LocationType> getBendpoint() {
        if (bendpoint == null) {
            bendpoint = new ArrayList<LocationType>();
        }
        return this.bendpoint;
    }

    /**
     * Obtient la valeur de la propriété targetAttachment.
     *
     * @return possible object is
     * {@link LocationType }
     */
    @objid ("34cd15ad-290d-4bdd-ad46-a2dcacfd26b7")
    public LocationType getTargetAttachment() {
        return targetAttachment;
    }

    /**
     * Définit la valeur de la propriété targetAttachment.
     *
     * @param value allowed object is
     * {@link LocationType }
     */
    @objid ("38640ed1-b216-4c80-83b9-0f4e09642b36")
    public void setTargetAttachment(LocationType value) {
        this.targetAttachment = value;
    }

    /**
     * Obtient la valeur de la propriété source.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("293bb9c7-3774-4aea-a67c-492897dc4ae4")
    public Object getSource() {
        return source;
    }

    /**
     * Définit la valeur de la propriété source.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("b9413593-968d-4b9d-ba02-e1ac81169722")
    public void setSource(Object value) {
        this.source = value;
    }

    /**
     * Obtient la valeur de la propriété target.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("0ad14632-7943-4b85-a242-9d4bd95a022b")
    public Object getTarget() {
        return target;
    }

    /**
     * Définit la valeur de la propriété target.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("41ca16b4-ec13-438d-9922-69d9c70f0a4c")
    public void setTarget(Object value) {
        this.target = value;
    }

}
