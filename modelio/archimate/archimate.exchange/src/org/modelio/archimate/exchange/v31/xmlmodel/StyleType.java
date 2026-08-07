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
 * A Style type for a node and a connection.
 * It is a container for style properties such as color, font.
 *
 *
 * <p>Classe Java pour StyleType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="StyleType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;all>
 * &lt;element name="lineColor" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBColorType" minOccurs="0"/>
 * &lt;element name="fillColor" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBColorType" minOccurs="0"/>
 * &lt;element name="font" type="{http://www.opengroup.org/xsd/archimate/3.0/}FontType" minOccurs="0"/>
 * &lt;/all>
 * &lt;attribute name="lineWidth" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("e0140f39-c0b4-40b6-98cf-d4d7f5613884")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {

})
public class StyleType {
    @objid ("b1c46ac1-6bba-4f20-a61b-de7db64c7fb3")
    protected RGBColorType lineColor;

    @objid ("728c1488-4f6b-4fa2-9f13-2f378e32daad")
    protected RGBColorType fillColor;

    @objid ("4bc51c15-d49d-430f-84e6-e61424af4af8")
    protected FontType font;

    @objid ("6a685937-660a-4fcb-af0f-f7891b811d7e")
    @XmlAttribute(name = "lineWidth")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger lineWidth;

    /**
     * Obtient la valeur de la propriété lineColor.
     *
     * @return possible object is
     * {@link RGBColorType }
     */
    @objid ("3267bc40-589a-446b-95cb-02dab3e15f5c")
    public RGBColorType getLineColor() {
        return lineColor;
    }

    /**
     * Définit la valeur de la propriété lineColor.
     *
     * @param value allowed object is
     * {@link RGBColorType }
     */
    @objid ("c59592d3-126b-47c5-ba03-ee9631b47071")
    public void setLineColor(RGBColorType value) {
        this.lineColor = value;
    }

    /**
     * Obtient la valeur de la propriété fillColor.
     *
     * @return possible object is
     * {@link RGBColorType }
     */
    @objid ("0ded6eb1-1129-435d-b161-0eb980732dd7")
    public RGBColorType getFillColor() {
        return fillColor;
    }

    /**
     * Définit la valeur de la propriété fillColor.
     *
     * @param value allowed object is
     * {@link RGBColorType }
     */
    @objid ("6bb6b311-c493-421d-955e-70c70b339d40")
    public void setFillColor(RGBColorType value) {
        this.fillColor = value;
    }

    /**
     * Obtient la valeur de la propriété font.
     *
     * @return possible object is
     * {@link FontType }
     */
    @objid ("fce67c4e-5ed4-4493-8806-989e158c9f58")
    public FontType getFont() {
        return font;
    }

    /**
     * Définit la valeur de la propriété font.
     *
     * @param value allowed object is
     * {@link FontType }
     */
    @objid ("6d4bb749-6cb5-4c7c-9ebb-8798baad2f3e")
    public void setFont(FontType value) {
        this.font = value;
    }

    /**
     * Obtient la valeur de la propriété lineWidth.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    @objid ("6e82bc32-3b05-437d-bfd9-da2e4b39b6aa")
    public BigInteger getLineWidth() {
        return lineWidth;
    }

    /**
     * Définit la valeur de la propriété lineWidth.
     *
     * @param value allowed object is
     * {@link BigInteger }
     */
    @objid ("d019ae8d-2af2-4026-af65-80203fa8c0cd")
    public void setLineWidth(BigInteger value) {
        this.lineWidth = value;
    }

}
