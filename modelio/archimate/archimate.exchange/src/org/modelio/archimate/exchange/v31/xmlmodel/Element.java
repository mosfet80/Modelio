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
import jakarta.xml.bind.annotation.XmlType;

/**
 * Node type to allow an Element in a Artifact.
 *
 * The node's label, documentation and properties may be determined
 * (i.e inherited) from those in the referenced ArchiMate element. Otherwise the node's label, documentation and properties
 * can be provided and will be additional to (or over-ride) those contained in the referenced ArchiMate element.
 *
 *
 * <p>Classe Java pour Element complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Element">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}Container">
 * &lt;attribute name="elementRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("7a920d05-6558-4664-9e68-f9b086bade16")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Element")
public class Element extends Container {
    @objid ("39b2a2e1-8fa3-4d25-b0e9-8ecdc06da92c")
    @XmlAttribute(name = "elementRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object elementRef;

    /**
     * Obtient la valeur de la propriété elementRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("879a164b-ec3a-413f-b20d-cd90c3655570")
    public Object getElementRef() {
        return elementRef;
    }

    /**
     * Définit la valeur de la propriété elementRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("f5ba214f-3312-4288-9036-d8d44d6f81d9")
    public void setElementRef(Object value) {
        this.elementRef = value;
    }

}
