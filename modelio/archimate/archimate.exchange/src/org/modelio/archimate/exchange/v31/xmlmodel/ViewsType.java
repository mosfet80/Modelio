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
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Classe Java pour ViewsType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ViewsType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewsType">
 * &lt;redefine>
 * &lt;complexType name="ViewsType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence>
 * &lt;element name="viewpoints" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointsType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * &lt;/redefine>
 * &lt;sequence>
 * &lt;element name="diagrams" type="{http://www.opengroup.org/xsd/archimate/3.0/}DiagramsType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("210d8e6f-1a05-4508-b9a9-18215c342498")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewsType", propOrder = {
    "diagrams"
})
public class ViewsType extends OriginalViewsType {
    @objid ("388526a4-9f95-4473-8e42-06f86da878c2")
    protected DiagramsType diagrams;

    /**
     * Obtient la valeur de la propriété diagrams.
     *
     * @return possible object is
     * {@link DiagramsType }
     */
    @objid ("d82c5875-e5f3-4f1d-be05-41350a7ea8ad")
    public DiagramsType getDiagrams() {
        return diagrams;
    }

    /**
     * Définit la valeur de la propriété diagrams.
     *
     * @param value allowed object is
     * {@link DiagramsType }
     */
    @objid ("33e4f009-4141-401a-a1d0-5c1558fb0d29")
    public void setDiagrams(DiagramsType value) {
        this.diagrams = value;
    }

}
