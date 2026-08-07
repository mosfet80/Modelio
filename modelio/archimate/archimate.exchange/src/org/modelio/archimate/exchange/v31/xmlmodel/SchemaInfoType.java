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
 * <p>Classe Java pour SchemaInfoType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="SchemaInfoType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}SchemaInfoGroup"/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("de631e34-5a04-4453-ad16-8b64497d2436")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaInfoType", propOrder = {
    "schema",
    "schemaversion",
    "any"
})
public class SchemaInfoType {
    @objid ("baeec1b6-8a84-4ed7-a222-d52c34e4d476")
    protected String schema;

    @objid ("4d761dc1-dc5d-463f-8dca-a6c4e18f29cf")
    protected String schemaversion;

    @objid ("d4e7c7b3-ba6c-43ed-8850-ba66f6d06bd1")
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Obtient la valeur de la propriété schema.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("11256249-3922-48a7-92ca-413d1320aa85")
    public String getSchema() {
        return schema;
    }

    /**
     * Définit la valeur de la propriété schema.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("49e52ade-4095-4b6a-a842-693f8b91f0e7")
    public void setSchema(String value) {
        this.schema = value;
    }

    /**
     * Obtient la valeur de la propriété schemaversion.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("05ba0b5f-cf8e-4a66-8941-bef3dea6a92c")
    public String getSchemaversion() {
        return schemaversion;
    }

    /**
     * Définit la valeur de la propriété schemaversion.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("95814eeb-5b2c-44c6-9647-ca8052b6b084")
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
    @objid ("f67b8b3a-c989-4473-ba90-90a376ca5962")
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
