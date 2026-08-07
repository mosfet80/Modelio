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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Instance v0.0.9054
 *
 *
 * In Modelio, Instances represent both the UML 2.0 Instance specification, and the UML 2.0 Part within structured Classifiers. The distinction is made through the definition context.  If the context is a namespacing context (such as Package or Class), then it corresponds to the UML 2.0 instance specification. If the context of the instance is an instantiation context, such as typically in the case of Collaborations, then it corresponds to Parts. Parts and Ports are handled as instances in Modelio, whereas UML 2.0 handles them as properties.
 *
 * An Instance is connected to zero or several Classifiers, which declare its structure and behavior. It has a set of attribute values (Slot in UML, and AttributeLink in Modelio) and is connected to a set of Links, where both sets match the definitions of its Classifiers/NameSpaces (if there are any). The two sets implement the current state of the Instance.
 *
 * In Modelio, an Instance belongs to its NameSpace (Class, Package, Collaboration, and so on), or to another Instance (Cluster association).
 *
 * There exist three important cases of configuration for instances in Modelio:
 * 1 - The Instance belongs to a Package. This corresponds to the UML 2.0 notion of InstanceSpecification.
 * 2 - The Instance belongs to a Collaboration (it is a Part, and its links are Connectors).
 * 3 - The Instance belongs to a Classifier. In this case, it is a Part or a Port of the Classifier.
 *
 * (UML 2.0 semantics): When an Instance of the containing Classifier is created, a set of Instances corresponding to its properties may be created either immediately or at some later time, depending on the multiplicity. These Instances are Instances of the Classifier typing the property.
 *
 * A Part specifies that a set of Instances may exist.  This set of Instances is a subset of the total set of Instances specified by the Classifier typing the Part. A Part of a Classifier declares that an Instance of this Classifier may contain a set of Instances by composition. All such Instances are destroyed when the container Classifier Instance is destroyed.
 *
 * In Modelio, an Instance belongs to another Instance (embedded or clustered Instances) or belongs to a NameSpace (Package, Class, Collaboration).
 *
 *
 *
 */
@objid ("000d46d4-c4bf-1fd8-97fe-001ec947cd2a")
public interface Instance extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("bebb2860-d8ba-43a4-bb48-a4059d3526a9")
    public static final String MNAME = "Instance";

    /**
     * The metaclass qualified name.
     */
    @objid ("3a386cf9-c6be-40b1-83d3-08566f4ae4dd")
    public static final String MQNAME = "Standard.Instance";

    /**
     * Getter for attribute 'Instance.IsConstant'
     *
     * Metamodel description:
     * <i>Determines whether it is a constant.</i>
     */
    @objid ("58ba9c08-16d4-4132-bb8e-53c750852ade")
    boolean isIsConstant();

    /**
     * Setter for attribute 'Instance.IsConstant'
     *
     * Metamodel description:
     * <i>Determines whether it is a constant.</i>
     */
    @objid ("56677d19-b891-49e4-8feb-9ee7cdc42bbd")
    void setIsConstant(boolean value);

    /**
     * Getter for attribute 'Instance.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum number of Instances that can exist. In the case where the Instance belongs to a Collaboration (typically in the case of internalStructure) this represents the number of instances at the time of creation of the container NameSpace or Classifier.</i>
     */
    @objid ("3936faf9-d656-44bd-88c6-fdc4bd0a999c")
    String getMultiplicityMin();

    /**
     * Setter for attribute 'Instance.MultiplicityMin'
     *
     * Metamodel description:
     * <i>Minimum number of Instances that can exist. In the case where the Instance belongs to a Collaboration (typically in the case of internalStructure) this represents the number of instances at the time of creation of the container NameSpace or Classifier.</i>
     */
    @objid ("55ce2bd1-4439-4920-b482-e30093dd12b1")
    void setMultiplicityMin(String value);

    /**
     * Getter for attribute 'Instance.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum number of Instances that can exist in the context of the owner NameSpace.</i>
     */
    @objid ("3990f19d-1a3c-44e8-b7d3-afe2189c4c75")
    String getMultiplicityMax();

    /**
     * Setter for attribute 'Instance.MultiplicityMax'
     *
     * Metamodel description:
     * <i>Maximum number of Instances that can exist in the context of the owner NameSpace.</i>
     */
    @objid ("667d2928-39dd-4b97-9e88-410446d86ea5")
    void setMultiplicityMax(String value);

    /**
     * Getter for attribute 'Instance.Value'
     *
     * Metamodel description:
     * <i>Current value of the Instance. This can be an expression, used instead of the set of values of the AttributeLinks of the instance.</i>
     */
    @objid ("6ea6a3ac-6f60-4ff2-a3d6-300c6392c981")
    String getValue();

    /**
     * Setter for attribute 'Instance.Value'
     *
     * Metamodel description:
     * <i>Current value of the Instance. This can be an expression, used instead of the set of values of the AttributeLinks of the instance.</i>
     */
    @objid ("5fc4ea58-71f2-4172-8b3f-97e4e25db6b8")
    void setValue(String value);

    /**
     * Getter for relation 'Instance->RepresentedCommunicationNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0ea688ce-fcd8-41f9-834a-e82f572bcac5")
    EList<CommunicationNode> getRepresentedCommunicationNode();

    /**
     * Filtered Getter for relation 'Instance->RepresentedCommunicationNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("737af64b-b697-4db6-8f73-b0c0dcd66414")
    <T extends CommunicationNode> List<T> getRepresentedCommunicationNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->OwnedEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("15d55296-96d5-4b7c-90e8-0e0475a07dda")
    EList<LinkEnd> getOwnedEnd();

    /**
     * Filtered Getter for relation 'Instance->OwnedEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c408aaa7-bbe6-4434-b57c-fe4e68e8497b")
    <T extends LinkEnd> List<T> getOwnedEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->Base'
     *
     * Metamodel description:
     * <i>Defines the Classifier as the model of the Instance or Role.</i>
     */
    @objid ("acd39fbc-21ea-4800-85c9-8acef94b2ddb")
    NameSpace getBase();

    /**
     * Setter for relation 'Instance->Base'
     *
     * Metamodel description:
     * <i>Defines the Classifier as the model of the Instance or Role.</i>
     */
    @objid ("c2c35301-9448-43d8-b7a4-84cfe00231d7")
    void setBase(NameSpace value);

    /**
     * Getter for relation 'Instance->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("06268b74-0d1b-444e-b8d4-0a9e41282687")
    EList<ObjectNode> getRepresentingObjectNode();

    /**
     * Filtered Getter for relation 'Instance->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6688335c-a440-4916-a8ca-427db044f31d")
    <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2b2d36e0-f335-42a3-abe7-b92a04f1ff97")
    NameSpace getOwner();

    /**
     * Setter for relation 'Instance->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f6c1f3e7-6535-415b-8594-d1d401ec46d4")
    void setOwner(NameSpace value);

    /**
     * Getter for relation 'Instance->OwnedNaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b41124dd-8ae7-45b1-a583-3f8ce6e6d748")
    EList<NaryLinkEnd> getOwnedNaryEnd();

    /**
     * Filtered Getter for relation 'Instance->OwnedNaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e5dbe4a7-a111-446c-a249-2564c2856078")
    <T extends NaryLinkEnd> List<T> getOwnedNaryEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->RepresentedLifeLine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b4752107-05b5-46c9-b740-49f1ac235e75")
    EList<Lifeline> getRepresentedLifeLine();

    /**
     * Filtered Getter for relation 'Instance->RepresentedLifeLine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5dca70fa-5ea3-4ac1-9242-6e09b0bf5688")
    <T extends Lifeline> List<T> getRepresentedLifeLine(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->Slot'
     *
     * Metamodel description:
     * <i>Occurrences of attributes for the current object (Instance or Role).</i>
     */
    @objid ("7684663c-4bc4-443e-ab8a-cc255f4f3054")
    EList<AttributeLink> getSlot();

    /**
     * Filtered Getter for relation 'Instance->Slot'
     *
     * Metamodel description:
     * <i>Occurrences of attributes for the current object (Instance or Role).</i>
     */
    @objid ("e1280f2c-5a4b-43ae-b8e7-790ccd4b48b5")
    <T extends AttributeLink> List<T> getSlot(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->Part'
     *
     * Metamodel description:
     * <i>Instances can be embedded. This can represent cluster. In Modelio, this is used to represent ComponentInstance supported by NodeInstances, or Objects in ComponentInstances or NodeInstances.</i>
     */
    @objid ("73e3b424-d296-4aed-8647-0ba8af763d61")
    EList<BindableInstance> getPart();

    /**
     * Filtered Getter for relation 'Instance->Part'
     *
     * Metamodel description:
     * <i>Instances can be embedded. This can represent cluster. In Modelio, this is used to represent ComponentInstance supported by NodeInstances, or Objects in ComponentInstances or NodeInstances.</i>
     */
    @objid ("169ac2be-c2a7-47e6-a778-84d190980a16")
    <T extends BindableInstance> List<T> getPart(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Instance->TargetingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3fe2cdec-ee25-40c0-884d-234a32042e74")
    EList<LinkEnd> getTargetingEnd();

    /**
     * Filtered Getter for relation 'Instance->TargetingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("016b0bd3-096c-4194-b739-0acf0641ac0e")
    <T extends LinkEnd> List<T> getTargetingEnd(java.lang.Class<T> filterClass);

}
