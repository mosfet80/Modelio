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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Graphical node type. It can contain child node types.
 *
 *
 * <p>Classe Java pour ViewNodeType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewNodeType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewConceptType">
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}LocationGroup"/>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}SizeGroup"/>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("56755efc-7137-44a8-bb49-35a3be835707")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewNodeType")
@XmlSeeAlso({
    Label.class,
    Container.class
})
public abstract class ViewNodeType extends ViewConceptType {
    @objid ("bdea36a8-e114-49e0-899b-adec33a469fd")
    @XmlAttribute(name = "x", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger x;

    @objid ("b368fc28-8209-4519-b276-43987188018c")
    @XmlAttribute(name = "y", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger y;

    @objid ("19489de9-50b1-4153-95b1-b86734d5100e")
    @XmlAttribute(name = "w", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger w;

    @objid ("5146d7c0-a935-4b59-86c1-fef6ad16b13a")
    @XmlAttribute(name = "h", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger h;

    /**
     * Obtient la valeur de la propriété x.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("b1acf38d-c8ca-4c60-81ea-a64884fd5c2e")
    public BigInteger getX() {
        return x;
    }

    /**
     * Définit la valeur de la propriété x.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("65926ece-5abc-486a-b7a8-af8a0ad5176d")
    public void setX(BigInteger value) {
        this.x = value;
    }

    /**
     * Obtient la valeur de la propriété y.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("035208a6-3c4a-4c93-bbd3-67702c8f4052")
    public BigInteger getY() {
        return y;
    }

    /**
     * Définit la valeur de la propriété y.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("ea61bce1-cb98-4c40-b83f-e0c170b8ed6e")
    public void setY(BigInteger value) {
        this.y = value;
    }

    /**
     * Obtient la valeur de la propriété w.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("a4c6666e-f417-471d-9633-fffde939f5e6")
    public BigInteger getW() {
        return w;
    }

    /**
     * Définit la valeur de la propriété w.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("0b463aed-6870-4b8c-baf8-904317a6d0d0")
    public void setW(BigInteger value) {
        this.w = value;
    }

    /**
     * Obtient la valeur de la propriété h.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("9d37bf25-bf83-44f9-bc6b-c5cdd92e6968")
    public BigInteger getH() {
        return h;
    }

    /**
     * Définit la valeur de la propriété h.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("c873db5f-f4de-4c23-8786-a83ed4e67e5d")
    public void setH(BigInteger value) {
        this.h = value;
    }

}
