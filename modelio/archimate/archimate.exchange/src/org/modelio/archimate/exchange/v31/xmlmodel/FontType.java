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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Font type.
 *
 *
 * <p>Classe Java pour FontType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="FontType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="color" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBColorType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 * &lt;attribute name="size" type="{http://www.opengroup.org/xsd/archimate/3.0/}nonNegativeHalfGranularityDecimal" />
 * &lt;attribute name="style" type="{http://www.opengroup.org/xsd/archimate/3.0/}FontStyleType" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("611fa666-72b1-4a6a-be5b-e4c8cbaa74b8")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FontType", propOrder = {
    "color"
})
public class FontType {
    @objid ("297fdac2-22af-4517-97f2-2fa443f91d12")
    @XmlAttribute(name = "name")
    protected String name;

    @objid ("4ac8ee0e-41d1-4757-9110-956ac91e3492")
    @XmlAttribute(name = "style")
    protected List<FontStyleEnum> style;

    @objid ("db2cbe70-d83d-4c80-b2db-3d76529c72a0")
    protected RGBColorType color;

    @objid ("fb097c20-b60f-4ed2-b700-fa8b0fe4d8c5")
    @XmlAttribute(name = "size")
    protected BigDecimal size;

    /**
     * Obtient la valeur de la propriété color.
     *
     * @return possible object is
     * {@link RGBColorType }
     */
    @objid ("45a2bc2a-daea-4494-887a-45d63b55ee95")
    public RGBColorType getColor() {
        return color;
    }

    /**
     * Définit la valeur de la propriété color.
     *
     * @param value allowed object is
     * {@link RGBColorType }
     */
    @objid ("7a0bdd32-fc39-4d8d-bf90-0bdf30910abd")
    public void setColor(RGBColorType value) {
        this.color = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("03b95e8f-0ae9-4f14-8dfd-13e043061334")
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("abcb726c-7f5a-4638-b54a-8d791037f82e")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété size.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    @objid ("23dae917-e1a4-429c-ac09-d6d3fc6fdc7c")
    public BigDecimal getSize() {
        return size;
    }

    /**
     * Définit la valeur de la propriété size.
     *
     * @param value allowed object is
     * {@link BigDecimal }
     */
    @objid ("80dca928-9539-4ece-a396-182de273bf7c")
    public void setSize(BigDecimal value) {
        this.size = value;
    }

    /**
     * Gets the value of the style property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the style property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getStyle().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FontStyleEnum }
     */
    @objid ("1a81f12e-03ef-4b3e-9aff-6cd4d2e28e3d")
    public List<FontStyleEnum> getStyle() {
        if (style == null) {
            style = new ArrayList<FontStyleEnum>();
        }
        return this.style;
    }

}
