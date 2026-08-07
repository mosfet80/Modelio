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
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;

/**
 * BpmnThrowEvent v0.0.9054
 *
 *
 * <p>Events that throw a Result. All End Events and some Intermediate Events are throwing Events that may eventually be caught by another Event.</p>
 *
 *
 */
@objid ("00956d84-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnThrowEvent extends BpmnEvent {
    /**
     * The metaclass simple name.
     */
    @objid ("cfad072c-5891-4342-a995-0d67a6a75e2c")
    public static final String MNAME = "BpmnThrowEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("8c1800d0-ee90-4e81-ba99-688fe6ed38da")
    public static final String MQNAME = "Standard.BpmnThrowEvent";

    /**
     * Getter for relation 'BpmnThrowEvent->DataInputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("607efd50-c15c-454e-994a-3a79a74821bb")
    EList<BpmnDataAssociation> getDataInputAssociation();

    /**
     * Filtered Getter for relation 'BpmnThrowEvent->DataInputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cf530b73-ad9e-44d2-9fdf-53684dc4612f")
    <T extends BpmnDataAssociation> List<T> getDataInputAssociation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnThrowEvent->DataInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3e190a6d-da3b-4a49-90ce-c89197b7da4f")
    BpmnDataInput getDataInput();

    /**
     * Setter for relation 'BpmnThrowEvent->DataInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("21f046f4-c83d-40a0-982b-631e3bed47a3")
    void setDataInput(BpmnDataInput value);

}
