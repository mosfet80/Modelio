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
 * <p>Classe Java pour CompositeTypeEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="CompositeTypeEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="Grouping"/>
 * &lt;enumeration value="Location"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("46e3d36f-66be-4bc6-9a1c-2ee6c721c7ab")
@XmlType(name = "CompositeTypeEnum")
@XmlEnum
public enum CompositeTypeEnum {
    @objid ("880ab96a-cb6a-464d-bec5-37fe0327f7b7")
    @XmlEnumValue("Grouping")
    GROUPING("Grouping"),
    @objid ("ece999b5-5e60-46ec-875a-a4cdc6eacadc")
    @XmlEnumValue("Location")
    LOCATION("Location");

    @objid ("3b156c7d-d430-42af-ad90-9a37ce06a372")
    private final String value;

    @objid ("c97e2209-353f-4c1f-ba85-a909577a17e5")
    CompositeTypeEnum(String v) {
        value = v;
    }

    @objid ("2e5b0b01-1297-4468-a1e0-efa7b4b09ee8")
    public String value() {
        return value;
    }

    @objid ("f3b52f57-3f69-4f9c-bc35-48225fdd271e")
    public static CompositeTypeEnum fromValue(String v) {
        for (CompositeTypeEnum c: CompositeTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
