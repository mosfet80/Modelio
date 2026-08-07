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
package org.modelio.metamodel.bpmn.activities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * BpmnTask v0.0.9054
 *
 *
 * A Task is an atomic Activity within a Process flow. A Task is used when the work in the Process cannot be broken down to a finer level of detail. Generally, an end-user and/or applications are used to perform the Task when it is executed.
 *
 */
@objid ("0084bb4c-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnTask extends BpmnActivity {
    /**
     * The metaclass simple name.
     */
    @objid ("588bfef9-574d-4bbf-924a-df1d481c9c83")
    public static final String MNAME = "BpmnTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("5f288807-5b9e-423b-bf42-391b4e7bafca")
    public static final String MQNAME = "Standard.BpmnTask";

    /**
     * Getter for attribute 'BpmnTask.IsGlobal'
     *
     * Metamodel description:
     * <i>A Global Task is a reusable, atomic Task definition that can be called from within any Process by a Call Activity.</i>
     */
    @objid ("47262bc6-e535-4bca-bd70-45a85932988d")
    boolean isIsGlobal();

    /**
     * Setter for attribute 'BpmnTask.IsGlobal'
     *
     * Metamodel description:
     * <i>A Global Task is a reusable, atomic Task definition that can be called from within any Process by a Call Activity.</i>
     */
    @objid ("913d4a2b-1981-457a-a7a7-19f2c2b69219")
    void setIsGlobal(boolean value);

    /**
     * Getter for relation 'BpmnTask->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a9e84ab3-e524-4554-b69e-21b63f997730")
    EList<BpmnCallActivity> getCaller();

    /**
     * Filtered Getter for relation 'BpmnTask->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0bd79d0c-f23a-4532-9861-49ef06160d2e")
    <T extends BpmnCallActivity> List<T> getCaller(java.lang.Class<T> filterClass);

}
