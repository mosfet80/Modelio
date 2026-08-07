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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Abstract Type requiring a source and target.
 *
 *
 * <p>Classe Java pour SourcedConnectionType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="SourcedConnectionType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.opengroup.org/xsd/archimate/3.0/}ConnectionType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="style" type="{http://www.opengroup.org/xsd/archimate/3.0/}StyleType" minOccurs="0"/>
 * &lt;element name="viewRef" type="{http://www.opengroup.org/xsd/archimate/3.0/}ReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="sourceAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 * &lt;element name="bendpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" maxOccurs="unbounded" minOccurs="0"/>
 * &lt;element name="targetAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}IdentifierGroup"/>
 * &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("4fccf010-cc73-4e71-99e0-93a9deb477c9")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourcedConnectionType")
@XmlSeeAlso({
    Relationship.class
})
public abstract class SourcedConnectionType extends ConnectionType {
}
