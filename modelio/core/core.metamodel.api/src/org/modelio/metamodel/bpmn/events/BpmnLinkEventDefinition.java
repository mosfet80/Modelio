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
package org.modelio.metamodel.bpmn.events;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * BpmnLinkEventDefinition v0.0.9054
 *
 *
 * <p>A Link Event is a mechanism for connecting two sections of a Process. Link Events can be used to create looping situations or to avoid long Sequence Flow lines. The use of Link Events is limited to a single Process level (i.e., they cannot link a parent Process with a Sub-Process).</p><p>Paired Link Events can also be used as &quot;Off-Page Connectors&quot; for printing a Process across multiple pages. They can also be used as generic &quot;Go To&quot; objects within the Process level. There can be multiple source Link Events, but there can only be one target Link Event. When used to &quot;catch&quot; from the source Link, the Event marker will be unfilled. When used to &quot;throw&quot; to the target Link, the Event marker will be filled.</p><p>&nbsp;</p>
 *
 *
 */
@objid ("0090129e-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnLinkEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("044b6589-c686-48f8-b6e4-605027c5281a")
    public static final String MNAME = "BpmnLinkEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("f272a6c9-9d70-4694-ae11-345d15d9c560")
    public static final String MQNAME = "Standard.BpmnLinkEventDefinition";

    /**
     * Getter for relation 'BpmnLinkEventDefinition->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("466c31b7-6901-46b9-96ef-fbce417f5558")
    EList<BpmnLinkEventDefinition> getSource();

    /**
     * Filtered Getter for relation 'BpmnLinkEventDefinition->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3a9a6994-5691-473b-a847-e32a456d09b2")
    <T extends BpmnLinkEventDefinition> List<T> getSource(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnLinkEventDefinition->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("59553147-d1a2-4b9a-bcdc-7a6e80ff11c4")
    BpmnLinkEventDefinition getTarget();

    /**
     * Setter for relation 'BpmnLinkEventDefinition->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("934dc627-7654-497b-a022-2abb7fc6e2a7")
    void setTarget(BpmnLinkEventDefinition value);

}
