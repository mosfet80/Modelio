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
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;

/**
 * BpmnCatchEvent v0.0.9054
 *
 *
 * Events catching some sort of signal or condition (message, condition, timer, etc.).
 * Initial events are always catch events. Intermediate events may catch events.
 *
 */
@objid ("00889ec4-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnCatchEvent extends BpmnEvent {
    /**
     * The metaclass simple name.
     */
    @objid ("7a909c9f-f988-4c64-8583-c81bdfdc2bcf")
    public static final String MNAME = "BpmnCatchEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("cf191243-0428-4f19-8847-31ec80d8c612")
    public static final String MQNAME = "Standard.BpmnCatchEvent";

    /**
     * Getter for attribute 'BpmnCatchEvent.ParallelMultiple'
     *
     * Metamodel description:
     * <i>This means that there are multiple triggers required before the events triggers outcoming sequence flows. All of the types of triggers that are listed in the catcht Event MUST be triggered before the processing continues.  </i>
     */
    @objid ("c9ccfb60-573f-4207-ad7f-8bf430842b2c")
    boolean isParallelMultiple();

    /**
     * Setter for attribute 'BpmnCatchEvent.ParallelMultiple'
     *
     * Metamodel description:
     * <i>This means that there are multiple triggers required before the events triggers outcoming sequence flows. All of the types of triggers that are listed in the catcht Event MUST be triggered before the processing continues.  </i>
     */
    @objid ("ebf4b45b-ba8f-4890-8549-78cdebd0119b")
    void setParallelMultiple(boolean value);

    /**
     * Getter for relation 'BpmnCatchEvent->DataOutputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6b545394-8c21-4b06-9a13-fd7e31166bef")
    EList<BpmnDataAssociation> getDataOutputAssociation();

    /**
     * Filtered Getter for relation 'BpmnCatchEvent->DataOutputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bb15ee48-ee27-4c18-97e7-39c141cee0af")
    <T extends BpmnDataAssociation> List<T> getDataOutputAssociation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnCatchEvent->DataOutput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("48cfb73f-d7f4-4d95-9a29-55ada8b1c9d5")
    BpmnDataOutput getDataOutput();

    /**
     * Setter for relation 'BpmnCatchEvent->DataOutput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("46688393-673a-4d4c-9815-518990f3824e")
    void setDataOutput(BpmnDataOutput value);

}
