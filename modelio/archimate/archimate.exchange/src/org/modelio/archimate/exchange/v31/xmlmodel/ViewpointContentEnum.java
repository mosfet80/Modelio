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
 * <p>Classe Java pour ViewpointContentEnum.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewpointContentEnum">
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 * &lt;enumeration value="Details"/>
 * &lt;enumeration value="Coherence"/>
 * &lt;enumeration value="Overview"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@objid ("27a812ee-4ee6-4f2f-be86-1ac06404f8a4")
@XmlType(name = "ViewpointContentEnum")
@XmlEnum
public enum ViewpointContentEnum {
    @objid ("3a41e4f2-c299-4730-998e-3118e7181356")
    @XmlEnumValue("Details")
    DETAILS("Details"),
    @objid ("11bf184e-dae6-4b1d-9e89-669a695c8857")
    @XmlEnumValue("Coherence")
    COHERENCE("Coherence"),
    @objid ("6a23ff2f-0ada-42dd-a9ef-d9af0ac81210")
    @XmlEnumValue("Overview")
    OVERVIEW("Overview");

    @objid ("85f37c06-70e2-4fcf-990d-ef464d00527b")
    private final String value;

    @objid ("2fbfb9fd-8042-4d57-8d8a-e69c94f06821")
    ViewpointContentEnum(String v) {
        value = v;
    }

    @objid ("b93d5e0e-8e27-4752-ab99-ba6386238932")
    public String value() {
        return value;
    }

    @objid ("412d9450-9222-49a7-95ed-9f97f6559205")
    public static ViewpointContentEnum fromValue(String v) {
        for (ViewpointContentEnum c: ViewpointContentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);

    }

}
