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
 * Generic Reference Type.
 *
 *
 * <p>Classe Java pour ReferenceType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ReferenceType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;attribute name="ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("4c35052f-9e2b-4654-9ab2-018671bd3972")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceType")
public class ReferenceType {
    @objid ("458db8d7-cebe-4184-a98b-bff330754f97")
    @XmlAttribute(name = "ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;

    /**
     * Obtient la valeur de la propriété ref.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("86402361-e201-4900-86dc-35606f35197e")
    public Object getRef() {
        return ref;
    }

    /**
     * Définit la valeur de la propriété ref.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("692ca524-3f81-4c39-be36-b0a954baa933")
    public void setRef(Object value) {
        this.ref = value;
    }

}
