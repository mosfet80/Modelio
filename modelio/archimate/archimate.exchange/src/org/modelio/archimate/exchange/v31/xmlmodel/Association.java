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
 * <p>Classe Java pour Association complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Association">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipType">
 * &lt;attribute name="isDirected" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("0f053e59-f440-43a0-9886-9da3b75ef108")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Association")
public class Association extends RelationshipType {
    @objid ("454a56f2-7585-448d-bac0-5459e2be8be9")
    @XmlAttribute(name = "isDirected")
    protected Boolean isDirected;

    /**
     * Obtient la valeur de la propriété isDirected.
     *
     * @return possible object is
     * {@link Boolean }
     */
    @objid ("24cda351-c318-48ad-88c9-087fa9bbf035")
    public boolean isIsDirected() {
        if (isDirected == null) {
            return false;
        } else {
            return isDirected;
        }

    }

    /**
     * Définit la valeur de la propriété isDirected.
     *
     * @param value allowed object is
     * {@link Boolean }
     */
    @objid ("6e6d5951-d942-4c77-ac02-def592f39ea1")
    public void setIsDirected(Boolean value) {
        this.isDirected = value;
    }

}
