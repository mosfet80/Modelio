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
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour AllowedRelationshipTypeType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="AllowedRelationshipTypeType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;attribute name="type" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipTypeEnum" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("0eef7040-78da-4637-8656-11c430dcd445")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllowedRelationshipTypeType")
public class AllowedRelationshipTypeType {
    @objid ("d8238a45-806e-49ec-94b7-9c11337f488d")
    @XmlAttribute(name = "type", required = true)
    protected RelationshipTypeEnum type;

    /**
     * Obtient la valeur de la propriété type.
     *
     * @return possible object is
     * {@link RelationshipTypeEnum }
     */
    @objid ("48615e59-7461-4e0c-97ac-7ceaa9d51e17")
    public RelationshipTypeEnum getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     *
     * @param value allowed object is
     * {@link RelationshipTypeEnum }
     */
    @objid ("cbf8ad32-070d-4897-93a6-f2c1b0ff9be0")
    public void setType(RelationshipTypeEnum value) {
        this.type = value;
    }

}
