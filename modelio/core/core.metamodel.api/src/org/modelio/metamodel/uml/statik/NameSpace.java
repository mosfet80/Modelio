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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.ModelTree;

/**
 * NameSpace v0.0.9054
 *
 *
 * A NameSpace is a named element that can own other named elements. Each named element may be owned by at most one NameSpace.
 *
 * A NameSpace provides a means of identifying named elements by name. Named elements can be identified by name in a NameSpace either by being directly owned by the NameSpace or by being introduced into the NameSpace by other means, for example, import or inheritance.
 *
 * Namespace is an abstract metaclass.
 *
 * A NameSpace can own Constraints. The Constraint does not necessarily apply to the NameSpace itself, but may also apply to elements in the NameSpace.  In Modelio, NameSpaces are generalizable. They can contain Interactions and are the definition context for Instances.
 *
 * In Modelio, a NameSpace belongs to another NameSpace, with the single exception of the Root NameSpace, which is associated to the Project.
 *
 */
@objid ("00115274-c4bf-1fd8-97fe-001ec947cd2a")
public interface NameSpace extends ModelTree {
    /**
     * The metaclass simple name.
     */
    @objid ("bbe9ec8f-de61-46be-bd7d-73f69a0c62a7")
    public static final String MNAME = "NameSpace";

    /**
     * The metaclass qualified name.
     */
    @objid ("6cb53f43-03bd-401a-8965-27ee9eb1582e")
    public static final String MQNAME = "Standard.NameSpace";

    /**
     * Getter for attribute 'NameSpace.IsAbstract'
     *
     * Metamodel description:
     * <i>An abstract NameSpace is defined on a very general level and does not have direct instances.</i>
     */
    @objid ("1e65c9d4-ac78-4cb8-b749-45b63e3ac550")
    boolean isIsAbstract();

    /**
     * Setter for attribute 'NameSpace.IsAbstract'
     *
     * Metamodel description:
     * <i>An abstract NameSpace is defined on a very general level and does not have direct instances.</i>
     */
    @objid ("dfdc2025-2cac-4eaf-b412-bc29acfa5b5a")
    void setIsAbstract(boolean value);

    /**
     * Getter for attribute 'NameSpace.IsLeaf'
     *
     * Metamodel description:
     * <i>Determines if the NameSpace is an inheritance tree leaf. This prohibits future inheritance.</i>
     */
    @objid ("0baee8a6-6b9b-45ec-9bee-d80103d61b55")
    boolean isIsLeaf();

    /**
     * Setter for attribute 'NameSpace.IsLeaf'
     *
     * Metamodel description:
     * <i>Determines if the NameSpace is an inheritance tree leaf. This prohibits future inheritance.</i>
     */
    @objid ("2b20df8d-0bf2-461d-a1a2-eda073a41c8a")
    void setIsLeaf(boolean value);

    /**
     * Getter for attribute 'NameSpace.IsRoot'
     *
     * Metamodel description:
     * <i>Determines that the current NameSpace is the root of a Generalization tree.</i>
     */
    @objid ("7dab5969-0a86-45e9-aacb-40582277330b")
    boolean isIsRoot();

    /**
     * Setter for attribute 'NameSpace.IsRoot'
     *
     * Metamodel description:
     * <i>Determines that the current NameSpace is the root of a Generalization tree.</i>
     */
    @objid ("003bb799-4526-4cd6-bec3-3cfe6155d87b")
    void setIsRoot(boolean value);

    /**
     * Getter for attribute 'NameSpace.Visibility'
     *
     * Metamodel description:
     * <i>Defines the visibility of the NameSpace, inside its owning NameSpace (visibility of a Class in a Package, for example).</i>
     */
    @objid ("0fb855dd-65d4-48f6-ba82-18ced94fff71")
    VisibilityMode getVisibility();

    /**
     * Setter for attribute 'NameSpace.Visibility'
     *
     * Metamodel description:
     * <i>Defines the visibility of the NameSpace, inside its owning NameSpace (visibility of a Class in a Package, for example).</i>
     */
    @objid ("d5d7eaef-a1ef-4c58-a3fe-f5f9f885e23a")
    void setVisibility(VisibilityMode value);

    /**
     * Getter for relation 'NameSpace->Parent'
     *
     * Metamodel description:
     * <i>Association to the Parent NameSpace through the intermediate Generalization class.</i>
     */
    @objid ("8a297694-ae38-41a9-aed3-b8ec9709e22d")
    EList<Generalization> getParent();

    /**
     * Filtered Getter for relation 'NameSpace->Parent'
     *
     * Metamodel description:
     * <i>Association to the Parent NameSpace through the intermediate Generalization class.</i>
     */
    @objid ("bf73a8a6-cfc0-4362-9bfe-a83de6d1b2d6")
    <T extends Generalization> List<T> getParent(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->TemplateInstanciation'
     *
     * Metamodel description:
     * <i>Relates to the template that is instanciated by the current NameSpace.</i>
     */
    @objid ("60f3f234-78c2-465e-87b7-aa6b12b6d1cf")
    EList<TemplateBinding> getTemplateInstanciation();

    /**
     * Filtered Getter for relation 'NameSpace->TemplateInstanciation'
     *
     * Metamodel description:
     * <i>Relates to the template that is instanciated by the current NameSpace.</i>
     */
    @objid ("498ee6d8-5502-46b9-acba-451e37f78166")
    <T extends TemplateBinding> List<T> getTemplateInstanciation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Representing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7b69f165-1723-4562-b38e-2726c35af676")
    EList<Instance> getRepresenting();

    /**
     * Filtered Getter for relation 'NameSpace->Representing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8c747080-89d7-45d5-9086-b829b8221594")
    <T extends Instance> List<T> getRepresenting(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedBehavior'
     *
     * Metamodel description:
     * <i>Behavior specification that specifies the behavior of the namespace itself.</i>
     */
    @objid ("64ad766f-0aae-4c2a-be89-793e270fb86d")
    EList<Behavior> getOwnedBehavior();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedBehavior'
     *
     * Metamodel description:
     * <i>Behavior specification that specifies the behavior of the namespace itself.</i>
     */
    @objid ("a67c8854-0ba5-4a66-97a6-b2ceb099fdc5")
    <T extends Behavior> List<T> getOwnedBehavior(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Received'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3ee8b3c0-a10d-4b67-b6fa-e3f779bb0d1e")
    EList<DataFlow> getReceived();

    /**
     * Filtered Getter for relation 'NameSpace->Received'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("224a96cc-7c19-4b5e-a91e-278617fa55a7")
    <T extends DataFlow> List<T> getReceived(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedInformationFlow'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("d6f7bf71-70cf-4de4-9099-1d3f1eeacc6d")
    EList<InformationFlow> getOwnedInformationFlow();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedInformationFlow'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("3fd9d69e-eba6-4ab9-aab5-f88782b1f118")
    <T extends InformationFlow> List<T> getOwnedInformationFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Importing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("625840e7-6a98-437c-84e0-a79a6faa83a4")
    EList<ElementImport> getImporting();

    /**
     * Filtered Getter for relation 'NameSpace->Importing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4cd1ce4c-9235-4a68-a2c0-eb87979abcbd")
    <T extends ElementImport> List<T> getImporting(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Sent'
     *
     * Metamodel description:
     * <i>DataFlows sent by the NameSpace.</i>
     */
    @objid ("04902506-84dd-4363-bb96-ad70268b8251")
    EList<DataFlow> getSent();

    /**
     * Filtered Getter for relation 'NameSpace->Sent'
     *
     * Metamodel description:
     * <i>DataFlows sent by the NameSpace.</i>
     */
    @objid ("827626bf-ed56-4762-9719-619afd56660e")
    <T extends DataFlow> List<T> getSent(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedDataFlow'
     *
     * Metamodel description:
     * <i>DataFlows belong to a NameSpace. If they have an origin NameSpace, then this is the owner. Otherwise, the NameSpace constituting the definition context of the DataFlow (this typically designates the Package in which the diagram has been defined) will be the owner.</i>
     */
    @objid ("f5beaec3-954d-4bed-9337-62a9ab0e1866")
    EList<DataFlow> getOwnedDataFlow();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedDataFlow'
     *
     * Metamodel description:
     * <i>DataFlows belong to a NameSpace. If they have an origin NameSpace, then this is the owner. Otherwise, the NameSpace constituting the definition context of the DataFlow (this typically designates the Package in which the diagram has been defined) will be the owner.</i>
     */
    @objid ("83d5c309-c026-41b9-82df-6e784965304d")
    <T extends DataFlow> List<T> getOwnedDataFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedCollaborationUse'
     *
     * Metamodel description:
     * <i>Collaboration occurences can be owned by NameSpaces such as Packages, Classes and Collaborations.</i>
     */
    @objid ("2616c2ac-e684-478c-9b50-4bc652706fdf")
    EList<CollaborationUse> getOwnedCollaborationUse();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedCollaborationUse'
     *
     * Metamodel description:
     * <i>Collaboration occurences can be owned by NameSpaces such as Packages, Classes and Collaborations.</i>
     */
    @objid ("32ace3f4-5c0b-4fb7-8abf-78f13f8283b0")
    <T extends CollaborationUse> List<T> getOwnedCollaborationUse(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedPackageImport'
     *
     * Metamodel description:
     * <i>Packages imported by the NameSpace.</i>
     */
    @objid ("4d1af3c9-4b80-4362-a10a-437e8760ce5b")
    EList<PackageImport> getOwnedPackageImport();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedPackageImport'
     *
     * Metamodel description:
     * <i>Packages imported by the NameSpace.</i>
     */
    @objid ("5fcd407e-57f1-4a0e-8c45-f73f6b86daef")
    <T extends PackageImport> List<T> getOwnedPackageImport(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Template'
     *
     * Metamodel description:
     * <i>In the case of template classes, this association defines its template parameters.</i>
     */
    @objid ("fb63f93b-d260-47a0-a11b-007a33f1171f")
    EList<TemplateParameter> getTemplate();

    /**
     * Filtered Getter for relation 'NameSpace->Template'
     *
     * Metamodel description:
     * <i>In the case of template classes, this association defines its template parameters.</i>
     */
    @objid ("392b72e8-024e-45b8-b917-074647bf41e4")
    <T extends TemplateParameter> List<T> getTemplate(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Specialization'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cfd6041c-642b-4190-adbc-2102a137cb51")
    EList<Generalization> getSpecialization();

    /**
     * Filtered Getter for relation 'NameSpace->Specialization'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c662896a-6e9b-4d3f-bf46-97b61b596730")
    <T extends Generalization> List<T> getSpecialization(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Realized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c359f2cf-29e3-468c-94cb-188f18e1204f")
    EList<InterfaceRealization> getRealized();

    /**
     * Filtered Getter for relation 'NameSpace->Realized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("827f6973-e913-44bf-85bd-9960e9b111fe")
    <T extends InterfaceRealization> List<T> getRealized(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->Declared'
     *
     * Metamodel description:
     * <i>Instances declared in the context of the current NameSpace.  </i>
     */
    @objid ("3b614625-d697-4582-908a-a7a4a9e41880")
    EList<Instance> getDeclared();

    /**
     * Filtered Getter for relation 'NameSpace->Declared'
     *
     * Metamodel description:
     * <i>Instances declared in the context of the current NameSpace.  </i>
     */
    @objid ("93740d52-db21-49af-8e28-0b6fa009431c")
    <T extends Instance> List<T> getDeclared(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->InstanciatingBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5350f9d6-8d3b-44cf-a2d2-3d4716aa8dbf")
    EList<TemplateBinding> getInstanciatingBinding();

    /**
     * Filtered Getter for relation 'NameSpace->InstanciatingBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3cadb964-533f-4a13-9150-eb7cccc56ca2")
    <T extends TemplateBinding> List<T> getInstanciatingBinding(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NameSpace->OwnedImport'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a5e20843-3052-4c57-a138-13fcd6d18d34")
    EList<ElementImport> getOwnedImport();

    /**
     * Filtered Getter for relation 'NameSpace->OwnedImport'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e913f51f-3a29-4b7d-9d38-6f0b4edad683")
    <T extends ElementImport> List<T> getOwnedImport(java.lang.Class<T> filterClass);

}
