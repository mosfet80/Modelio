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
 * <p>Classe Java pour Influence complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Influence">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipType">
 * &lt;attribute name="modifier" type="{http://www.opengroup.org/xsd/archimate/3.0/}InfluenceModifierType" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("0e4fc8d5-771a-415b-8517-3862d296a351")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Influence")
public class Influence extends RelationshipType {
    @objid ("145f477c-3e0b-4e55-a33d-57c2c60eec50")
    @XmlAttribute(name = "modifier")
    protected String modifier;

    /**
     * Obtient la valeur de la propriété modifier.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("3d4dbd11-0561-4b85-b605-8f96ec5be493")
    public String getModifier() {
        return modifier;
    }

    /**
     * Définit la valeur de la propriété modifier.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("eae0cd20-1542-4e8a-87dd-8890e411af01")
    public void setModifier(String value) {
        this.modifier = value;
    }

}
