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
 * <p>Classe Java pour FontStyleEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="FontStyleEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="plain"/>
 * &lt;enumeration value="bold"/>
 * &lt;enumeration value="italic"/>
 * &lt;enumeration value="underline"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("38524fbb-6963-469f-968c-56269502488d")
@XmlType(name = "FontStyleEnum")
@XmlEnum
public enum FontStyleEnum {
    @objid ("ec3d7d6b-5fd8-4342-b735-7e85a9d8116f")
    @XmlEnumValue("plain")
    PLAIN("plain"),
    @objid ("82a747b3-2d07-4cd5-94bb-3b79afd28da4")
    @XmlEnumValue("bold")
    BOLD("bold"),
    @objid ("0007f08b-3847-4d7f-92ed-2c4c3d2c8d56")
    @XmlEnumValue("italic")
    ITALIC("italic"),
    @objid ("80e0acd3-597b-4c3e-8441-789b44fd01d8")
    @XmlEnumValue("underline")
    UNDERLINE("underline");

    @objid ("7d2b09cc-6a48-48df-beb0-e347fb8de3cd")
    private final String value;

    @objid ("0c21338c-7019-438e-90f7-37f646cba596")
    FontStyleEnum(String v) {
        value = v;
    }

    @objid ("c5c00e1d-3f44-45d4-8a5b-46d01913f853")
    public String value() {
        return value;
    }

    @objid ("ba617940-2ec6-44dc-8f88-629dcafc8a95")
    public static FontStyleEnum fromValue(String v) {
        for (FontStyleEnum c: FontStyleEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
