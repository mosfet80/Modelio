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

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnScriptTask v0.0.9054
 *
 *
 * A Script Task is executed by a business process engine. The modeler or implementer defines a script in a language that the engine can interpret. When the Task is ready to start, the engine will execute the script. When the script is completed, the Task will also be completed.
 *
 */
@objid ("0082028a-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnScriptTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("fc3d08b9-dd2c-478a-8c38-023f9653bf1a")
    public static final String MNAME = "BpmnScriptTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("3adce082-c7b6-4f89-a211-254cbccc3bec")
    public static final String MQNAME = "Standard.BpmnScriptTask";

    /**
     * Getter for attribute 'BpmnScriptTask.ScriptLanguage'
     *
     * Metamodel description:
     * <i>Defines the script language. The script language MUST be provided if a
     * script is provided.</i>
     */
    @objid ("ba22957a-b8af-491f-a594-b13f09577653")
    String getScriptLanguage();

    /**
     * Setter for attribute 'BpmnScriptTask.ScriptLanguage'
     *
     * Metamodel description:
     * <i>Defines the script language. The script language MUST be provided if a
     * script is provided.</i>
     */
    @objid ("35d43389-052f-4075-b50a-f8a18f92dc0d")
    void setScriptLanguage(String value);

    /**
     * Getter for attribute 'BpmnScriptTask.Script'
     *
     * Metamodel description:
     * <i>The modeler MAY include a script that can be run when the Task is performed.
     * If a script is not included, then the Task will act as the equivalent of an Abstract Task</i>
     */
    @objid ("fc2c46a0-0709-4db9-b3e6-1b4edc44d5e6")
    String getScript();

    /**
     * Setter for attribute 'BpmnScriptTask.Script'
     *
     * Metamodel description:
     * <i>The modeler MAY include a script that can be run when the Task is performed.
     * If a script is not included, then the Task will act as the equivalent of an Abstract Task</i>
     */
    @objid ("60a6af72-e6ed-421f-8c54-531df26725c0")
    void setScript(String value);

}
