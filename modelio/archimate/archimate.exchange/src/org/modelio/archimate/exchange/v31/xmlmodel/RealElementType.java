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
 * Forces Real Elements to have Names.
 *
 *
 * <p>Classe Java pour RealElementType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="RealElementType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.opengroup.org/xsd/archimate/3.0/}ElementType">
 * &lt;sequence>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}NameGroup" maxOccurs="unbounded"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}grp.any"/>
 * &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptGroup"/>
 * &lt;/sequence>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}IdentifierGroup"/>
 * &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}ConceptAttributeGroup"/>
 * &lt;anyAttribute namespace='##other'/>
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("22d9c2b0-5c67-4726-bb70-06f368b76aca")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RealElementType")
@XmlSeeAlso({
    TechnologyProcess.class,
    Node.class,
    Product.class,
    BusinessObject.class,
    BusinessCollaboration.class,
    Goal.class,
    ImplementationEvent.class,
    Capability.class,
    BusinessEvent.class,
    DistributionNetwork.class,
    ApplicationFunction.class,
    TechnologyInterface.class,
    ApplicationEvent.class,
    Principle.class,
    Requirement.class,
    Contract.class,
    ApplicationService.class,
    Deliverable.class,
    CommunicationNetwork.class,
    TechnologyCollaboration.class,
    ApplicationCollaboration.class,
    ValueStream.class,
    Path.class,
    Plateau.class,
    ApplicationComponent.class,
    TechnologyInteraction.class,
    Artifact.class,
    BusinessFunction.class,
    Outcome.class,
    Facility.class,
    Constraint.class,
    BusinessActor.class,
    BusinessInteraction.class,
    WorkPackage.class,
    TechnologyFunction.class,
    Stakeholder.class,
    Device.class,
    Resource.class,
    Representation.class,
    DataObject.class,
    Gap.class,
    Value.class,
    BusinessInterface.class,
    ApplicationProcess.class,
    TechnologyService.class,
    BusinessRole.class,
    Assessment.class,
    SystemSoftware.class,
    Driver.class,
    ApplicationInterface.class,
    TechnologyEvent.class,
    CourseOfAction.class,
    Material.class,
    BusinessService.class,
    Equipment.class,
    ApplicationInteraction.class,
    Meaning.class,
    BusinessProcess.class
})
public abstract class RealElementType extends ElementType {
}
