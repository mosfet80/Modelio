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
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Node type to allow a Label in a Artifact. the "label" element holds the info for the Note.
 *
 *
 * <p>Classe Java pour Label complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="Label">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewNodeType">
 * &lt;attribute name="conceptRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;attribute name="xpathPart" type="{http://www.opengroup.org/xsd/archimate/3.0/}XPATH_2.0_Expression" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("49c7c0d0-0729-4bd2-b335-4c3d4fdd7d32")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label")
public class Label extends ViewNodeType {
    @objid ("2b80750c-699d-4d81-9fd7-21f6e3ecb08b")
    @XmlAttribute(name = "xpathPart")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xpathPart;

    @objid ("5ca3ff4a-1e71-4d5d-87b7-8a20c4f5d842")
    @XmlAttribute(name = "conceptRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object conceptRef;

    /**
     * Obtient la valeur de la propriété conceptRef.
     *
     * @return possible object is
     * {@link Object }
     */
    @objid ("207739e0-9c31-4ea3-9594-0ea4f2596f0a")
    public Object getConceptRef() {
        return conceptRef;
    }

    /**
     * Définit la valeur de la propriété conceptRef.
     *
     * @param value allowed object is
     * {@link Object }
     */
    @objid ("d1c07650-e339-4b45-b4f1-f43b5b15af30")
    public void setConceptRef(Object value) {
        this.conceptRef = value;
    }

    /**
     * Obtient la valeur de la propriété xpathPart.
     *
     * @return possible object is
     * {@link String }
     */
    @objid ("52eab51a-6032-486f-8530-52852fe1f744")
    public String getXpathPart() {
        return xpathPart;
    }

    /**
     * Définit la valeur de la propriété xpathPart.
     *
     * @param value allowed object is
     * {@link String }
     */
    @objid ("26c6c0cb-3fb3-4c8f-b139-fa7d80f9cfa8")
    public void setXpathPart(String value) {
        this.xpathPart = value;
    }

}
