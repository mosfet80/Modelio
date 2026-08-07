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
 * Connector for a Relationship.
 *
 *
 * <p>Classe Java pour Relationship complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Relationship">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}SourcedConnectionType">
 * &lt;attribute name="relationshipRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("b49761eb-14cc-4027-a9ab-7b1ed17dfbbc")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Relationship")
@XmlSeeAlso({
    NestingRelationship.class
})
public class Relationship extends SourcedConnectionType {
    @objid ("08008c0a-fe9e-4020-8e11-16a9db162d62")
    @XmlAttribute(name = "relationshipRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object relationshipRef;

    /**
     * Obtient la valeur de la propriété relationshipRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("45665a2b-c2ad-4151-a4db-fa3e9f28b0fb")
    public Object getRelationshipRef() {
        return relationshipRef;
    }

    /**
     * Définit la valeur de la propriété relationshipRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("0ac65025-667e-4311-9409-80fb1ce1b177")
    public void setRelationshipRef(Object value) {
        this.relationshipRef = value;
    }

}
