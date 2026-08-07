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
 * <p>Classe Java pour ViewpointPurposeEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewpointPurposeEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="Designing"/>
 * &lt;enumeration value="Deciding"/>
 * &lt;enumeration value="Informing"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("747002ee-4c2a-4a29-8b7c-42bc53038228")
@XmlType(name = "ViewpointPurposeEnum")
@XmlEnum
public enum ViewpointPurposeEnum {
    @objid ("4583b19f-1222-4d6f-bca4-e02f7d9919a0")
    @XmlEnumValue("Designing")
    DESIGNING("Designing"),
    @objid ("5d044c05-1747-4e4c-8d64-3a74049e1840")
    @XmlEnumValue("Deciding")
    DECIDING("Deciding"),
    @objid ("b86af3d8-ac3d-417e-8f23-525b3df53e07")
    @XmlEnumValue("Informing")
    INFORMING("Informing");

    @objid ("a42cac7a-4982-4448-9633-7b3529a6a421")
    private final String value;

    @objid ("37027e2d-647a-4dc5-9866-e7e89f5bcb1a")
    ViewpointPurposeEnum(String v) {
        value = v;
    }

    @objid ("47ffff5d-5d03-4c8e-be10-474b49eaa6a0")
    public String value() {
        return value;
    }

    @objid ("4c8a68d4-0e5c-418a-ab6e-0fc24e60d985")
    public static ViewpointPurposeEnum fromValue(String v) {
        for (ViewpointPurposeEnum c: ViewpointPurposeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
