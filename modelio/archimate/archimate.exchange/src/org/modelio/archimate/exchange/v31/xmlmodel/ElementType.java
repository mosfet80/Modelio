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
 * A base element type that can be extended by concrete ArchiMate types.
 *
 * Note that ElementType is abstract, so one must have derived types of this type. this is indicated in xml
 * by having a tag name of "element" and an attribute of xsi:type="BusinessRole" where BusinessRole is
 * a derived type from ElementType.
 *
 *
 * <p>Classe Java pour ElementType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="ElementType">
 * &lt;complexContent>
 * &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptType">
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("c88685bf-21bd-43ff-99ec-1aa873f4f6a3")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementType")
@XmlSeeAlso({
    RelationshipConnectorType.class,
    RealElementType.class,
    CompositeType.class
})
public abstract class ElementType extends ConceptType {
}
