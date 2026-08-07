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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Container for View type.
 *
 * Note that View itself is abstract so one must have a derived type. the xml example must look like
 * a tag name "view" with an attribute of xsi:type="Diagram", if Diagram is a derived type from ViewType.
 *
 *
 * <p>Classe Java pour ViewType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 * &lt;/sequence>
 * &lt;attribute name="viewpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointTypeType" />
 * &lt;attribute name="viewpointRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("09757fa6-8741-4352-8e72-902ab8e18e74")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewType", propOrder = {
    "properties"
})
@XmlSeeAlso({
    Diagram.class
})
public abstract class ViewType extends NamedReferenceableType {
    @objid ("7b794353-7563-4171-aaf7-178ed88541aa")
    @XmlAttribute(name = "viewpoint")
    protected String viewpoint;

    @objid ("c31aad52-55ae-4f32-9736-9b47966ae4e7")
    protected PropertiesType properties;

    @objid ("e38b3533-f350-4de8-9ca6-1113a295d478")
    @XmlAttribute(name = "viewpointRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object viewpointRef;

    /**
     * Obtient la valeur de la propriété properties.
     *
     * @return possible object is
     * {@link PropertiesType }
     */
    @objid ("19b0c2ac-27ef-4ab2-97c8-07c8dabe6700")
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Définit la valeur de la propriété properties.
     *
     * @param value allowed object is
     * {@link PropertiesType }
     */
    @objid ("56e6783a-75b9-4b32-aadb-0362c5a5cff4")
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Obtient la valeur de la propriété viewpoint.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("8292253b-f097-4730-ae8b-9aa000f41334")
    public String getViewpoint() {
        return viewpoint;
    }

    /**
     * Définit la valeur de la propriété viewpoint.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("a69ad979-addf-4bae-b092-5f4c23cc3e61")
    public void setViewpoint(String value) {
        this.viewpoint = value;
    }

    /**
     * Obtient la valeur de la propriété viewpointRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("3c01cf1c-58a3-405a-8997-36277384e8f1")
    public Object getViewpointRef() {
        return viewpointRef;
    }

    /**
     * Définit la valeur de la propriété viewpointRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("3ba6286c-b65b-4695-9f34-cfec1cd4b046")
    public void setViewpointRef(Object value) {
        this.viewpointRef = value;
    }

}
