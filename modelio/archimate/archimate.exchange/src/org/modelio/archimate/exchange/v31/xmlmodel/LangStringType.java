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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * A base string type for multi-language strings.
 *
 *
 * <p>Classe Java pour LangStringType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="LangStringType">
 * &lt;simpleContent>
 * &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 * &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 * &lt;/extension>
 * &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("bcf6232c-835c-418e-bdd9-373c84960338")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LangStringType", propOrder = {
    "value"
})
@XmlSeeAlso({
    PreservedLangStringType.class
})
public class LangStringType {
    @objid ("4216eaac-41fe-4372-9db1-d97c63e12cc3")
    @XmlValue
    protected String value;

    @objid ("62fe2d79-2dfd-4fdf-be2f-33e85d5a2c2d")
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    protected String lang;

    /**
     * Obtient la valeur de la propriété value.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("56d4bb55-dafb-4308-85f8-a709dd95f863")
    public String getValue() {
        return value;
    }

    /**
     * Définit la valeur de la propriété value.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("c090c0cb-78a3-4400-b6e5-17e0de92c6a2")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtient la valeur de la propriété lang.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("33935562-2a24-490d-b0b6-b206beaf74be")
    public String getLang() {
        return lang;
    }

    /**
     * Définit la valeur de la propriété lang.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("b55e6b5a-5a3d-48a8-abf9-09714adbb0e9")
    public void setLang(String value) {
        this.lang = value;
    }

}
