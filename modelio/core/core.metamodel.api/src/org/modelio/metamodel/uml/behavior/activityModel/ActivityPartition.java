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
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * ActivityPartition v0.0.9054
 *
 *
 * Partitions divide the nodes and edges to constrain and show a view of the contained nodes. Partitions can share contents. They often correspond to organizational units in a business model. They may be used to allocate characteristics or resources among the nodes of an activity.
 *
 * Partitions do not affect the token flow of the model. They constrain and provide a view on the behaviors invoked in activities. Constraints vary according to the type of element that the partition represents. The following constraints are normative:
 *
 * 1) Classifier
 * Behaviors of invocations contained by the partition are the responsibility of instances of the classifier represented by the partition. This means the context of invoked behaviors is the classifier. Invoked procedures containing a call to an operation or sending a signal must target objects at runtime that are instances of the classifier.
 *
 * 2) Instance
 * This imposes the same constraints as classifier, but restricted to a particular instance of the classifier.
 *
 * 3) Part
 * Behaviors of invocations contained by the partition are the responsibility of instances playing the part represented by the partition. This imposes the constraints for classifiers above according to the type of the part. In addition, invoked procedures containing a call to an operation or sending a signal must target objects at runtime that play the part at the time the message is sent. Just as partitions in the same dimension and nesting must be represented by parts of the same classifier's internal structure, all the runtime target objects of operation and signal passing invoked by the same execution of the activity must play parts of the same instance of the structured classifier. In particular, if an activity is executed in the context of a particular object at runtime, the parts of that object will be used as targets. If a part has more than one object playing it at runtime, the invocations are treated as if they were multiple, that is, the calls are sent in parallel, and the invocation does not complete until all the operations return.
 *
 * 4) Attribute and Value
 * A partition may be represented by an attribute and its subpartitions by values of that attribute. Behaviors of invocations contained by the subpartition have this attribute and the value represented by the subpartition. For example, a partition may represent the location at which a behavior is carried out, and the subpartitions would represent specific values for that attribute, such as Chicago. The location attribute could be on the process class associated with an activity, or added in a profile to extend behaviors with these attributes.
 *
 */
@objid ("0029d8f8-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityPartition extends ActivityGroup {
    /**
     * The metaclass simple name.
     */
    @objid ("e3f49755-795b-49dc-8900-d1bbc1cba187")
    public static final String MNAME = "ActivityPartition";

    /**
     * The metaclass qualified name.
     */
    @objid ("505499db-b6af-4c78-ade9-074458b7f7ee")
    public static final String MQNAME = "Standard.ActivityPartition";

    /**
     * Getter for attribute 'ActivityPartition.IsDimension'
     *
     * Metamodel description:
     * <i>Indicates whether the partition groups other partitions along a dimension.</i>
     */
    @objid ("55e6dcc8-1bec-45da-a362-3620ccd2204c")
    boolean isIsDimension();

    /**
     * Setter for attribute 'ActivityPartition.IsDimension'
     *
     * Metamodel description:
     * <i>Indicates whether the partition groups other partitions along a dimension.</i>
     */
    @objid ("10135e77-44d6-4fec-912d-66f23aa2a9be")
    void setIsDimension(boolean value);

    /**
     * Getter for attribute 'ActivityPartition.IsExternal'
     *
     * Metamodel description:
     * <i>Indicates whether the partition represents an entity to which the partitioning structure does not apply.</i>
     */
    @objid ("d5a9fa98-8aeb-4982-b3bb-5feeb1bc9e64")
    boolean isIsExternal();

    /**
     * Setter for attribute 'ActivityPartition.IsExternal'
     *
     * Metamodel description:
     * <i>Indicates whether the partition represents an entity to which the partitioning structure does not apply.</i>
     */
    @objid ("fac049f6-b549-4f8d-9753-567adf738287")
    void setIsExternal(boolean value);

    /**
     * Getter for relation 'ActivityPartition->Represented'
     *
     * Metamodel description:
     * <i>An element constraining behaviors invoked by nodes in the partition. A partition should represent a classifier, an attribute, its value a parameter or an instance.</i>
     */
    @objid ("9038c383-e94b-48c8-b986-605449616091")
    UmlModelElement getRepresented();

    /**
     * Setter for relation 'ActivityPartition->Represented'
     *
     * Metamodel description:
     * <i>An element constraining behaviors invoked by nodes in the partition. A partition should represent a classifier, an attribute, its value a parameter or an instance.</i>
     */
    @objid ("52043fbc-a988-4595-8ec0-318008fe10d4")
    void setRepresented(UmlModelElement value);

    /**
     * Getter for relation 'ActivityPartition->ContainedNode'
     *
     * Metamodel description:
     * <i>Nodes immediately contained in the partition.</i>
     */
    @objid ("de37c3b8-39f3-4ddf-a42f-7ad0f4d18354")
    EList<ActivityNode> getContainedNode();

    /**
     * Filtered Getter for relation 'ActivityPartition->ContainedNode'
     *
     * Metamodel description:
     * <i>Nodes immediately contained in the partition.</i>
     */
    @objid ("f7f3176f-17d0-4d0f-b6eb-ed879e9f9055")
    <T extends ActivityNode> List<T> getContainedNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityPartition->Outgoing'
     *
     * Metamodel description:
     * <i>Outgoing BPMN messages.</i>
     */
    @objid ("d30ab086-f28f-4e27-b6b2-9589300d6038")
    EList<MessageFlow> getOutgoing();

    /**
     * Filtered Getter for relation 'ActivityPartition->Outgoing'
     *
     * Metamodel description:
     * <i>Outgoing BPMN messages.</i>
     */
    @objid ("ba23189e-e69f-4678-b8e5-5432958daaa4")
    <T extends MessageFlow> List<T> getOutgoing(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityPartition->SuperPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a9eb4e0d-79f7-4129-ad1e-91daee130bcc")
    ActivityPartition getSuperPartition();

    /**
     * Setter for relation 'ActivityPartition->SuperPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bba54b97-ce2d-4702-9afd-9f734e56b10b")
    void setSuperPartition(ActivityPartition value);

    /**
     * Getter for relation 'ActivityPartition->SubPartition'
     *
     * Metamodel description:
     * <i>Partitions immediately contained in the partition.</i>
     */
    @objid ("47973a78-785b-4ec6-ba30-c5d9c8352dbd")
    EList<ActivityPartition> getSubPartition();

    /**
     * Filtered Getter for relation 'ActivityPartition->SubPartition'
     *
     * Metamodel description:
     * <i>Partitions immediately contained in the partition.</i>
     */
    @objid ("d3f9bb38-09ff-42c9-af8c-db7a8f35e840")
    <T extends ActivityPartition> List<T> getSubPartition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityPartition->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c6440144-ee4e-44a9-b303-346a973a4668")
    EList<MessageFlow> getIncoming();

    /**
     * Filtered Getter for relation 'ActivityPartition->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("665d8dcc-bf63-43bf-afb6-69cbe41edca3")
    <T extends MessageFlow> List<T> getIncoming(java.lang.Class<T> filterClass);

}
