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
 * RGB Color type.
 * The r, g, b attributes range from 0 - 255.
 * The a (alpha) transparency attribute is optional. 0 = full transparency, 100 = opaque.
 *
 *
 * <p>Classe Java pour RGBColorType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="RGBColorType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;attribute name="r" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 * &lt;attribute name="g" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 * &lt;attribute name="b" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 * &lt;attribute name="a">
 * &lt;simpleType>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 * &lt;minInclusive value="0"/>
 * &lt;maxInclusive value="100"/>
 * &lt;/restriction>
 * &lt;/simpleType>
 * &lt;/attribute>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("7893bfc1-4712-481d-90b3-0cbd43df081d")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RGBColorType")
public class RGBColorType {
    @objid ("1dd7bc01-696d-47b4-8335-3c3979b400f9")
    @XmlAttribute(name = "r", required = true)
    protected short r;

    @objid ("e9b5325b-e91d-4ca4-aab9-69a947fa6c58")
    @XmlAttribute(name = "g", required = true)
    protected short g;

    @objid ("1ed8f670-7625-4dfd-aaaa-9b68856b8b51")
    @XmlAttribute(name = "b", required = true)
    protected short b;

    @objid ("675af3c6-b9b7-4f2a-bdc3-1efa547fabce")
    @XmlAttribute(name = "a")
    protected Short a;

    /**
     * Obtient la valeur de la propriété r.
     */
    @objid ("3d9ae174-247a-4b77-8805-7c3e31727764")
    public short getR() {
        return r;
    }

    /**
     * Définit la valeur de la propriété r.
     */
    @objid ("7603c179-c536-4150-b79e-538125d87ecf")
    public void setR(short value) {
        this.r = value;
    }

    /**
     * Obtient la valeur de la propriété g.
     */
    @objid ("2b9e0915-f7e2-4ab8-a300-d8d5c0a3c60f")
    public short getG() {
        return g;
    }

    /**
     * Définit la valeur de la propriété g.
     */
    @objid ("d16acd49-e083-4305-8070-ceffefbfe0ad")
    public void setG(short value) {
        this.g = value;
    }

    /**
     * Obtient la valeur de la propriété b.
     */
    @objid ("84894902-442c-48f2-b668-016525a3f584")
    public short getB() {
        return b;
    }

    /**
     * Définit la valeur de la propriété b.
     */
    @objid ("02a73a13-456d-499a-8dab-f6873377bbce")
    public void setB(short value) {
        this.b = value;
    }

    /**
     * Obtient la valeur de la propriété a.
     *
     * @return possible object is
     * {@link Short }
     */
    @objid ("813c5daf-5efa-499e-9882-df834e78d1a8")
    public Short getA() {
        return a;
    }

    /**
     * Définit la valeur de la propriété a.
     *
     * @param value allowed object is
     * {@link Short }
     */
    @objid ("4c07b10c-2f1a-44e1-a258-7e147d6cd760")
    public void setA(Short value) {
        this.a = value;
    }

}
