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
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * An instance of the meta-data element contains data structures that declare descriptive information
 * about a meta-data element's parent only.
 *
 * One or more different meta-data models may be declared as child extensions of a meta-data element.
 *
 *
 * <p>Classe Java pour MetadataType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="MetadataType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;choice>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}SchemaInfoGroup"/>
 * &lt;element name="schemaInfo" type="{http://www.opengroup.org/xsd/archimate/3.0/}SchemaInfoType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;/choice>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("29b814d4-8fa9-4757-821f-d0d2cda03bca")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataType", propOrder = {
    "schema",
    "schemaversion",
    "any",
    "schemaInfo"
})
public class MetadataType {
    @objid ("ebb3bcc5-6e39-45a1-a58c-a4dc644f7510")
    protected String schema;

    @objid ("8ad55c0a-8709-4eb7-898f-1d805cad6ead")
    protected String schemaversion;

    @objid ("9b032659-7248-4cf2-89a5-61885115ec53")
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    @objid ("1a15d756-80b8-482b-9043-9a30417ba321")
    protected List<SchemaInfoType> schemaInfo;

    /**
     * Obtient la valeur de la propriété schema.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("4bf1de8a-d98e-4176-b2f5-b4a7046decc5")
    public String getSchema() {
        return schema;
    }

    /**
     * Définit la valeur de la propriété schema.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("4ff3918c-d66f-45f5-b82d-693c3bed5351")
    public void setSchema(String value) {
        this.schema = value;
    }

    /**
     * Obtient la valeur de la propriété schemaversion.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("401f548a-f7dc-4449-ae5f-9bd65f37bd6d")
    public String getSchemaversion() {
        return schemaversion;
    }

    /**
     * Définit la valeur de la propriété schemaversion.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("3a46990a-e1a0-481e-b80e-f1fa4aa4df20")
    public void setSchemaversion(String value) {
        this.schemaversion = value;
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
    @objid ("5d4c2e3a-eac6-437b-99a5-cd79d54c225a")
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the schemaInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schemaInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getSchemaInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemaInfoType }
     */
    @objid ("7dea2e91-78d6-45df-94e1-6f632fe64b2a")
    public List<SchemaInfoType> getSchemaInfo() {
        if (schemaInfo == null) {
            schemaInfo = new ArrayList<SchemaInfoType>();
        }
        return this.schemaInfo;
    }

}
