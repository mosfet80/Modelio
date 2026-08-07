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

import java.math.BigInteger;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour LocationType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="LocationType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}LocationGroup"/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("0472d951-dac2-4c55-b987-eb7865cfa76f")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType")
public class LocationType {
    @objid ("5a24dfab-38fe-4c77-bfbb-320ec672b6fe")
    @XmlAttribute(name = "x", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger x;

    @objid ("3be0e5f6-e10a-4c36-9501-3ee3db60b9e4")
    @XmlAttribute(name = "y", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger y;

    /**
     * Obtient la valeur de la propriété x.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("5468bcc9-0421-47a1-a400-99b478ce640c")
    public BigInteger getX() {
        return x;
    }

    /**
     * Définit la valeur de la propriété x.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("e1b7be18-6b58-4a8e-a938-b1c75eb90032")
    public void setX(BigInteger value) {
        this.x = value;
    }

    /**
     * Obtient la valeur de la propriété y.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("4b68f19e-85b9-4e41-a49e-48715e34c87a")
    public BigInteger getY() {
        return y;
    }

    /**
     * Définit la valeur de la propriété y.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("23d0973f-2986-41cc-b3d3-add494b1bbb5")
    public void setY(BigInteger value) {
        this.y = value;
    }

}
