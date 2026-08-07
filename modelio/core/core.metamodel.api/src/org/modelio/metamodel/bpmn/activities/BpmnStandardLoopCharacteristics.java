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
 * BpmnStandardLoopCharacteristics v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00839f78-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnStandardLoopCharacteristics extends BpmnLoopCharacteristics {
    /**
     * The metaclass simple name.
     */
    @objid ("b66a635b-4123-4263-b9f3-8dad7b42fd8d")
    public static final String MNAME = "BpmnStandardLoopCharacteristics";

    /**
     * The metaclass qualified name.
     */
    @objid ("f9474a6a-dd94-4a67-8dfd-6c7cc6b5028b")
    public static final String MQNAME = "Standard.BpmnStandardLoopCharacteristics";

    /**
     * Getter for attribute 'BpmnStandardLoopCharacteristics.TestBefore'
     *
     * Metamodel description:
     * <i>Flag that controls whether the loop condition is evaluated at the beginning (testBefore = true) or at the end (testBefore = false) of the
     * loop iteration.</i>
     */
    @objid ("af971fa1-1e0c-4ced-8c28-33a4ee16ed4b")
    boolean isTestBefore();

    /**
     * Setter for attribute 'BpmnStandardLoopCharacteristics.TestBefore'
     *
     * Metamodel description:
     * <i>Flag that controls whether the loop condition is evaluated at the beginning (testBefore = true) or at the end (testBefore = false) of the
     * loop iteration.</i>
     */
    @objid ("4c6d4fce-3559-4a08-b1f6-5f1c7b843a79")
    void setTestBefore(boolean value);

    /**
     * Getter for attribute 'BpmnStandardLoopCharacteristics.LoopCondition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0a6fe380-5855-4e0f-afe3-afedcea00cb4")
    String getLoopCondition();

    /**
     * Setter for attribute 'BpmnStandardLoopCharacteristics.LoopCondition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("94028975-ec8e-485a-acb9-1f0979ae7c60")
    void setLoopCondition(String value);

    /**
     * Getter for attribute 'BpmnStandardLoopCharacteristics.LoopMaximum'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ac4a65e2-998b-4d86-b173-00fcee02e8a4")
    String getLoopMaximum();

    /**
     * Setter for attribute 'BpmnStandardLoopCharacteristics.LoopMaximum'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6e1a42cb-59f0-4eff-a6cf-4fb6b2ae1bc9")
    void setLoopMaximum(String value);

}
