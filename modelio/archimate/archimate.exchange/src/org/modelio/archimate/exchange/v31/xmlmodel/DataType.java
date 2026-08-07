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
 * <p>Classe Java pour DataType.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="DataType">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="string"/>
 * &lt;enumeration value="boolean"/>
 * &lt;enumeration value="currency"/>
 * &lt;enumeration value="date"/>
 * &lt;enumeration value="time"/>
 * &lt;enumeration value="number"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("d625be13-f63b-4e22-92c1-72d33b53e195")
@XmlType(name = "DataType")
@XmlEnum
public enum DataType {
    @objid ("91771441-faa1-4a08-b6e1-32947ecb6db7")
    @XmlEnumValue("string")
    STRING("string"),
    @objid ("54489da3-9c7f-42be-9796-9e6cbb997e9f")
    @XmlEnumValue("boolean")
    BOOLEAN("boolean"),
    @objid ("7473db7f-53fa-4ba2-9f3f-7a4d45bc31ae")
    @XmlEnumValue("currency")
    CURRENCY("currency"),
    @objid ("8f40d4df-b17e-43f3-97b4-9f83657a53fe")
    @XmlEnumValue("date")
    DATE("date"),
    @objid ("ca2096a5-7c4a-4e74-b3bb-37941128e65a")
    @XmlEnumValue("time")
    TIME("time"),
    @objid ("76837e2c-912c-4d77-81a8-bd60a9fe95b5")
    @XmlEnumValue("number")
    NUMBER("number");

    @objid ("c9e8cd51-a463-4397-b031-f520797b063e")
    private final String value;

    @objid ("230efe03-55ed-4248-854f-4c52235efb18")
    DataType(String v) {
        value = v;
    }

    @objid ("42bce781-c65e-42d0-809a-e82590af10d6")
    public String value() {
        return value;
    }

    @objid ("2eaabe90-fc51-472d-85ac-8dd33fa58caa")
    public static DataType fromValue(String v) {
        for (DataType c: DataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
