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
 * A base relationship type that can be extended by concrete ArchiMate types.
 *
 * Note that RelationshipType is abstract, so one must have derived types of this type. this is indicated in xml
 * by having a tag name of "relationship" and an attribute of xsi:type="AccessRelationship" where AccessRelationship is
 * a derived type from RelationshipType.
 *
 *
 * <p>Classe Java pour RelationshipType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="RelationshipType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptType">
 * &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("d848a9a1-5d3e-436e-a01f-3ddddfed6143")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelationshipType")
@XmlSeeAlso({
    Access.class,
    Assignment.class,
    Influence.class,
    Aggregation.class,
    Specialization.class,
    Association.class,
    Triggering.class,
    Flow.class,
    Serving.class,
    Realization.class,
    Composition.class
})
public abstract class RelationshipType extends ConceptType {
    @objid ("040cb3bd-19c1-4dc7-8e47-3ef7a7681794")
    @XmlAttribute(name = "source", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object source;

    @objid ("b57e0165-0807-48cf-b403-58e8870c8284")
    @XmlAttribute(name = "target", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object target;

    /**
     * Obtient la valeur de la propriété source.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("0a1fca30-df02-41d6-bf8c-4b6f661c48db")
    public Object getSource() {
        return source;
    }

    /**
     * Définit la valeur de la propriété source.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("1b14dfb6-4c50-4d78-a49e-748efca8df54")
    public void setSource(Object value) {
        this.source = value;
    }

    /**
     * Obtient la valeur de la propriété target.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("42704104-50d3-406f-9e5f-c50f65b560dd")
    public Object getTarget() {
        return target;
    }

    /**
     * Définit la valeur de la propriété target.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("7fa6e0c3-f5a7-4fa4-b850-33bdfcf40b3e")
    public void setTarget(Object value) {
        this.target = value;
    }

}
