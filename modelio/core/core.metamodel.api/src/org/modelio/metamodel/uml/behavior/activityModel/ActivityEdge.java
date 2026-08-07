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
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * ActivityEdge v0.0.9054
 *
 *
 * ActivityEdge is an abstract class for the connections along which tokens flow between activity nodes. It covers control and data flow edges.
 *
 * Activity edges can control token flow.
 *
 */
@objid ("00270a1a-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityEdge extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("98695de7-9cfa-49aa-9f1b-c72f4ab4c410")
    public static final String MNAME = "ActivityEdge";

    /**
     * The metaclass qualified name.
     */
    @objid ("8846ed68-31b7-407b-bf80-77092d1a8d7e")
    public static final String MQNAME = "Standard.ActivityEdge";

    /**
     * Getter for attribute 'ActivityEdge.Guard'
     *
     * Metamodel description:
     * <i>Specification evaluated at runtime to determine if the edge can be traversed. </i>
     */
    @objid ("7d43e66f-3598-462d-b4f0-b324a2d98944")
    String getGuard();

    /**
     * Setter for attribute 'ActivityEdge.Guard'
     *
     * Metamodel description:
     * <i>Specification evaluated at runtime to determine if the edge can be traversed. </i>
     */
    @objid ("0bf1716b-d047-4a41-9903-288bc02d87e6")
    void setGuard(String value);

    /**
     * Getter for attribute 'ActivityEdge.Weight'
     *
     * Metamodel description:
     * <i>Number of tokens consumed from the source node on each traversal.</i>
     */
    @objid ("3ef6e432-c882-4d9b-bd03-cade7b02465a")
    String getWeight();

    /**
     * Setter for attribute 'ActivityEdge.Weight'
     *
     * Metamodel description:
     * <i>Number of tokens consumed from the source node on each traversal.</i>
     */
    @objid ("3011b27b-a3a4-4461-adec-7819678ef99d")
    void setWeight(String value);

    /**
     * Getter for relation 'ActivityEdge->Target'
     *
     * Metamodel description:
     * <i>Node to which tokens are put when they traverse the edge.</i>
     */
    @objid ("4e68de40-1d99-49e0-b960-692356ed4347")
    ActivityNode getTarget();

    /**
     * Setter for relation 'ActivityEdge->Target'
     *
     * Metamodel description:
     * <i>Node to which tokens are put when they traverse the edge.</i>
     */
    @objid ("eae9de29-82ef-4327-8379-0906159205a1")
    void setTarget(ActivityNode value);

    /**
     * Getter for relation 'ActivityEdge->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8a9a2093-01a7-4292-8288-9fdeb2f5a1f4")
    ActivityNode getSource();

    /**
     * Setter for relation 'ActivityEdge->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("37ee9c9c-ca06-4d64-bcf0-2f75628f6fd3")
    void setSource(ActivityNode value);

    /**
     * Getter for relation 'ActivityEdge->Interrupts'
     *
     * Metamodel description:
     * <i>Region that the edge can interrupt.</i>
     */
    @objid ("335eb1f2-205f-463c-8383-967f893a0471")
    InterruptibleActivityRegion getInterrupts();

    /**
     * Setter for relation 'ActivityEdge->Interrupts'
     *
     * Metamodel description:
     * <i>Region that the edge can interrupt.</i>
     */
    @objid ("1df76136-8f79-409a-8110-4a1c65595a0c")
    void setInterrupts(InterruptibleActivityRegion value);

    /**
     * Getter for relation 'ActivityEdge->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("605bd484-9984-4e1b-a628-fddb1d962b37")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'ActivityEdge->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("62022e81-3b24-4071-b4c9-c70864ea1847")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

}
