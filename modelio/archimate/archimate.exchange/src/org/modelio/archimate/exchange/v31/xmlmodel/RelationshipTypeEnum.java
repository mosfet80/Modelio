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
 * <p>Classe Java pour RelationshipTypeEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationshipTypeEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="Composition"/>
 * &lt;enumeration value="Aggregation"/>
 * &lt;enumeration value="Assignment"/>
 * &lt;enumeration value="Realization"/>
 * &lt;enumeration value="Serving"/>
 * &lt;enumeration value="Access"/>
 * &lt;enumeration value="Influence"/>
 * &lt;enumeration value="Triggering"/>
 * &lt;enumeration value="Flow"/>
 * &lt;enumeration value="Specialization"/>
 * &lt;enumeration value="Association"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("7291465e-d367-41ab-9b59-372e10240cdb")
@XmlType(name = "RelationshipTypeEnum")
@XmlEnum
public enum RelationshipTypeEnum {
    @objid ("0d17d76a-d404-41b1-8537-bcb62f3ad6a3")
    @XmlEnumValue("Composition")
    COMPOSITION("Composition"),
    @objid ("21ef22c4-2636-4752-bdaf-774deea54e0a")
    @XmlEnumValue("Aggregation")
    AGGREGATION("Aggregation"),
    @objid ("8c1e62b5-9fb3-4a02-a14f-a733df7a4be3")
    @XmlEnumValue("Assignment")
    ASSIGNMENT("Assignment"),
    @objid ("dc827e23-8a4b-428c-81bb-3864f2622667")
    @XmlEnumValue("Realization")
    REALIZATION("Realization"),
    @objid ("7b53e3df-fd0f-465b-ad8d-2d87b2359dae")
    @XmlEnumValue("Serving")
    SERVING("Serving"),
    @objid ("8366f2d9-13ed-4aa0-ae55-af34bc412eeb")
    @XmlEnumValue("Access")
    ACCESS("Access"),
    @objid ("fd93c212-f118-4995-b779-75db76cdc2a1")
    @XmlEnumValue("Influence")
    INFLUENCE("Influence"),
    @objid ("ac27c1c7-6eb4-4597-a76c-ab3f77b21b42")
    @XmlEnumValue("Triggering")
    TRIGGERING("Triggering"),
    @objid ("22370e64-0a3e-45ce-89cd-88a69b85f300")
    @XmlEnumValue("Flow")
    FLOW("Flow"),
    @objid ("b9ceb98e-0c3e-441e-a134-a9b71e5dd410")
    @XmlEnumValue("Specialization")
    SPECIALIZATION("Specialization"),
    @objid ("b5b5a32b-44fa-457f-bd83-583c13aa051e")
    @XmlEnumValue("Association")
    ASSOCIATION("Association");

    @objid ("8fe0edf0-5a1c-4eb1-a17a-c992b68bbc2d")
    private final String value;

    @objid ("0f542426-fd9b-4c6b-8caf-7664feef94a3")
    RelationshipTypeEnum(String v) {
        value = v;
    }

    @objid ("4e19c138-6d8c-4a9c-8136-c6d4819601cb")
    public String value() {
        return value;
    }

    @objid ("fc20fcc3-88f7-4914-b86f-99d136852206")
    public static RelationshipTypeEnum fromValue(String v) {
        for (RelationshipTypeEnum c: RelationshipTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
