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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.informationFlow;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.StructuralFeature;

/**
 * InformationFlow v0.0.9054
 *
 *
 * <p>An InformationFlow specifies that one or more information items circulates from its sources to its targets. Information flows require some kind of &quot;information channel&quot;&nbsp;for transmitting information items from the source to the destination.</p><p>An information channel is represented in various ways depending on the nature of its sources and targets. It may be represented by connectors, links, associations, or even dependencies. For example, if the source and destination are parts in some composite structure such as a collaboration, then the information channel is likely to be represented by a connector between them. Or, if the source and target are objects (which are a kind of InstanceSpecification), they may be represented by a link that joins the two, and so on.</p><p>The sources and targets of the information flow can only be one of the following kind: Actor, Node, UseCase, Artifact, Class, Component, Port, Attribute, AssociationEnd, Interface, Package, ActivityNode, ActivityPartition and Instance.</p>
 *
 *
 */
@objid ("0063764e-c4bf-1fd8-97fe-001ec947cd2a")
public interface InformationFlow extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b4bc6dd1-4d3c-4b55-87ab-cceb8c8fff8c")
    public static final String MNAME = "InformationFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("26cba688-dd05-4db1-b019-ba8355287203")
    public static final String MQNAME = "Standard.InformationFlow";

    /**
     * Getter for relation 'InformationFlow->Owner'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("67021cc0-80ac-4ba6-ad7e-005461edb19b")
    NameSpace getOwner();

    /**
     * Setter for relation 'InformationFlow->Owner'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("27e351fc-3045-4a7a-8dac-740442353a17")
    void setOwner(NameSpace value);

    /**
     * Getter for relation 'InformationFlow->InformationSource'
     *
     * Metamodel description:
     * <i>Defines from which source the conveyed information items are initiated.</i>
     */
    @objid ("1fabd51f-16d2-4e2d-abbd-966dd8eb1182")
    EList<UmlModelElement> getInformationSource();

    /**
     * Filtered Getter for relation 'InformationFlow->InformationSource'
     *
     * Metamodel description:
     * <i>Defines from which source the conveyed information items are initiated.</i>
     */
    @objid ("80c1db82-baee-4467-bb53-2bc4425ab0ae")
    <T extends UmlModelElement> List<T> getInformationSource(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->InformationTarget'
     *
     * Metamodel description:
     * <i>Defines to which target the conveyed information items are directed.</i>
     */
    @objid ("8d8283ce-29e4-4737-a985-8f92dfa396f2")
    EList<UmlModelElement> getInformationTarget();

    /**
     * Filtered Getter for relation 'InformationFlow->InformationTarget'
     *
     * Metamodel description:
     * <i>Defines to which target the conveyed information items are directed.</i>
     */
    @objid ("a14299ae-497a-4cc8-8857-b8c4e80f86b2")
    <T extends UmlModelElement> List<T> getInformationTarget(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingActivityEdge'
     *
     * Metamodel description:
     * <i>Determines which ActivityEdges will realize the specified flow.</i>
     */
    @objid ("189c5e14-7709-44f6-a809-4d9fb4337fd0")
    EList<ActivityEdge> getRealizingActivityEdge();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingActivityEdge'
     *
     * Metamodel description:
     * <i>Determines which ActivityEdges will realize the specified flow.</i>
     */
    @objid ("89784e07-2b71-44f2-9221-ac65d1ec2ae2")
    <T extends ActivityEdge> List<T> getRealizingActivityEdge(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingCommunicationMessage'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("d338da84-0253-4ede-81ec-094832a9aa2b")
    EList<CommunicationMessage> getRealizingCommunicationMessage();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingCommunicationMessage'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("0bca968a-a3a4-411e-baf3-ca9a229bf144")
    <T extends CommunicationMessage> List<T> getRealizingCommunicationMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b6aebf31-086a-46e2-a710-43fbce033440")
    EList<StructuralFeature> getRealizingFeature();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b06459d0-5352-4e83-97f7-64699c0821dd")
    <T extends StructuralFeature> List<T> getRealizingFeature(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("908f0f50-f88c-4b0b-8d4a-6c556f690583")
    EList<LinkEnd> getRealizingLink();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fb2756d5-2ea5-498a-abfe-6659ab0d82f6")
    <T extends LinkEnd> List<T> getRealizingLink(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cec7844b-2749-4c6b-8c22-0f9950f0f421")
    EList<Message> getRealizingMessage();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("93f2d21a-d64a-4749-a0af-e977678e39e3")
    <T extends Message> List<T> getRealizingMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->RealizingNaryLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f92d2f9c-a274-4b05-a2b0-7b013a7fe478")
    EList<NaryLink> getRealizingNaryLink();

    /**
     * Filtered Getter for relation 'InformationFlow->RealizingNaryLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9a787c55-0dbb-4916-95ad-ba6d1ceb18d5")
    <T extends NaryLink> List<T> getRealizingNaryLink(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->Conveyed'
     *
     * Metamodel description:
     * <i>Specifies the information items that may circulate on this information flow.</i>
     */
    @objid ("b2c9e251-2353-4cd2-9f10-22f30b894832")
    EList<Classifier> getConveyed();

    /**
     * Filtered Getter for relation 'InformationFlow->Conveyed'
     *
     * Metamodel description:
     * <i>Specifies the information items that may circulate on this information flow.</i>
     */
    @objid ("38525bf4-5f5c-4d94-a60a-734f348beb58")
    <T extends Classifier> List<T> getConveyed(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'InformationFlow->Channel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a75e1ff7-84e3-4abd-871a-1c7006638fe8")
    AssociationEnd getChannel();

    /**
     * Setter for relation 'InformationFlow->Channel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("024eedda-cf0f-469b-b327-089044ca9149")
    void setChannel(AssociationEnd value);

}
