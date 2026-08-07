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
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour RelationshipConnectorEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationshipConnectorEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="AndJunction"/>
 * &lt;enumeration value="OrJunction"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("7c25b232-3d38-4383-b47c-c82629fc9492")
@XmlType(name = "RelationshipConnectorEnum")
@XmlEnum
public enum RelationshipConnectorEnum {
    @objid ("55e410aa-ede0-4f2a-8405-011c9e1d9f29")
    @XmlEnumValue("AndJunction")
    AND_JUNCTION("AndJunction"),
    @objid ("94662bf5-2476-42f8-93cb-397b29e9f87c")
    @XmlEnumValue("OrJunction")
    OR_JUNCTION("OrJunction");

    @objid ("e0d9be4d-8698-4c55-bd18-fbb36bb49ba2")
    private final String value;

    @objid ("d6c587d5-3823-4114-8ae0-e04784541ada")
    RelationshipConnectorEnum(String v) {
        value = v;
    }

    @objid ("d1cb44eb-6e85-409d-a9df-88545f9833b6")
    public String value() {
        return value;
    }

    @objid ("30ac20f6-3b86-4222-ac41-d7fcbf760d38")
    public static RelationshipConnectorEnum fromValue(String v) {
        for (RelationshipConnectorEnum c: RelationshipConnectorEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
