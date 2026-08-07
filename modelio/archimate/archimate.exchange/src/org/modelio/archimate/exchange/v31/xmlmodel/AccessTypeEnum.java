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
 * <p>Classe Java pour AccessTypeEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessTypeEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="Access"/>
 * &lt;enumeration value="Read"/>
 * &lt;enumeration value="Write"/>
 * &lt;enumeration value="ReadWrite"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("5be3380c-35b1-4676-b61a-401fbbc5bbca")
@XmlType(name = "AccessTypeEnum")
@XmlEnum
public enum AccessTypeEnum {
    @objid ("7b59bdda-a415-4cee-9064-54cd277f16a7")
    @XmlEnumValue("Access")
    ACCESS("Access"),
    @objid ("bf4d5ec7-0449-4ced-90a7-7faa456bf1cf")
    @XmlEnumValue("Read")
    READ("Read"),
    @objid ("1357011f-1bf1-4a68-b497-2bc8ab5e2389")
    @XmlEnumValue("Write")
    WRITE("Write"),
    @objid ("f30ca20b-14b7-45a1-b43e-c0b055b95f12")
    @XmlEnumValue("ReadWrite")
    READ_WRITE("ReadWrite");

    @objid ("2396a7cc-2480-4c7c-b1a3-b3e2e2cde2fe")
    private final String value;

    @objid ("81ce63bc-993d-4946-846e-39afb8870f86")
    AccessTypeEnum(String v) {
        value = v;
    }

    @objid ("512bbbf4-6127-4c46-8412-261a0cc2dcba")
    public String value() {
        return value;
    }

    @objid ("014e9b90-b654-4f31-abd5-8d33c94148a9")
    public static AccessTypeEnum fromValue(String v) {
        for (AccessTypeEnum c: AccessTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
