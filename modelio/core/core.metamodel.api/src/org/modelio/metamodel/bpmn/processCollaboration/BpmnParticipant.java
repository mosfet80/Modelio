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
package org.modelio.metamodel.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.bpmnService.BpmnEndPoint;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnParticipant v0.0.9054
 *
 *
 * A Participant represents a specific PartnerEntity (e.g., a company) and/or a more general PartnerRole (e.g., a buyer, seller, or manufacturer) that are Participants in a Collaboration. A Participant is often responsible for the execution of the Process enclosed in a Pool; however, a Pool may be defined without a Process.
 *
 */
@objid ("007577d6-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnParticipant extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("9c4ebc78-327e-4bd4-a9c1-e17629096750")
    public static final String MNAME = "BpmnParticipant";

    /**
     * The metaclass qualified name.
     */
    @objid ("976b1284-cf6a-4bbd-a86d-c7897a8610cf")
    public static final String MQNAME = "Standard.BpmnParticipant";

    /**
     *
     * @return <code>true</code> if the workflow is local, i.e. it references a process belonging to the same {@link BpmnBehavior}
     * as the opened participant.
     * @since 3.7
     */
    @objid ("a464bad3-1d64-4181-83a1-2336e64cdde2")
    boolean isLocal();

    /**
     * Getter for attribute 'BpmnParticipant.MultiplicityMin'
     *
     * Metamodel description:
     * <i>When Participants represent more than 1 instance, min and max are specified (1 - 1 by default)</i>
     */
    @objid ("0743a399-f522-493b-95f7-cf697956a58e")
    int getMultiplicityMin();

    /**
     * Setter for attribute 'BpmnParticipant.MultiplicityMin'
     *
     * Metamodel description:
     * <i>When Participants represent more than 1 instance, min and max are specified (1 - 1 by default)</i>
     */
    @objid ("bae9d539-c8a3-4edd-889a-4edd8f1d2dce")
    void setMultiplicityMin(int value);

    /**
     * Getter for attribute 'BpmnParticipant.MultiplicityMax'
     *
     * Metamodel description:
     * <i>When Participants represent more than 1 instance, min and max are specified (1 - 1 by default)</i>
     */
    @objid ("7106268a-0e91-412f-82cb-3ae303072992")
    int getMultiplicityMax();

    /**
     * Setter for attribute 'BpmnParticipant.MultiplicityMax'
     *
     * Metamodel description:
     * <i>When Participants represent more than 1 instance, min and max are specified (1 - 1 by default)</i>
     */
    @objid ("8b0f7845-b222-4c44-bf67-6231bc793589")
    void setMultiplicityMax(int value);

    /**
     * Getter for relation 'BpmnParticipant->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("59ba31b2-d843-4abc-a5c3-a08badc7578d")
    BpmnProcess getProcess();

    /**
     * Setter for relation 'BpmnParticipant->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("980e364c-ea1c-4391-8430-38616d764482")
    void setProcess(BpmnProcess value);

    /**
     * Getter for relation 'BpmnParticipant->Container'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("61bb3159-3253-4d3b-af8c-ae5af8979b85")
    BpmnCollaboration getContainer();

    /**
     * Setter for relation 'BpmnParticipant->Container'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1fc7a43f-bbf2-4756-b44e-7edc92df96d9")
    void setContainer(BpmnCollaboration value);

    /**
     * Getter for relation 'BpmnParticipant->EndPointRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("24eaf2b8-af1a-465a-96dc-3e6b30531f5b")
    EList<BpmnEndPoint> getEndPointRefs();

    /**
     * Filtered Getter for relation 'BpmnParticipant->EndPointRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1e3b0189-a386-4b19-be88-c3e8491fda92")
    <T extends BpmnEndPoint> List<T> getEndPointRefs(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnParticipant->InterfaceRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4c3db054-b1c7-4ba0-8503-459285cb76ac")
    EList<BpmnInterface> getInterfaceRefs();

    /**
     * Filtered Getter for relation 'BpmnParticipant->InterfaceRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d5e41e1b-2e79-437e-a781-fd42af04ea9e")
    <T extends BpmnInterface> List<T> getInterfaceRefs(java.lang.Class<T> filterClass);

}
