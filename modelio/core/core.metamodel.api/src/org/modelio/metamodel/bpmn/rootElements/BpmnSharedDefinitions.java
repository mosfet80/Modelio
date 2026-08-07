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
package org.modelio.metamodel.bpmn.rootElements;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * BpmnSharedDefinitions v2.2.0
 *
 *
 * Definitions BPMN metaclass.
 *
 */
@objid ("b3eec24c-5799-4134-abbe-1afb8df80c12")
public interface BpmnSharedDefinitions extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("2d8acd2c-91af-49f0-a1e1-c0c0016d64e5")
    public static final String MNAME = "BpmnSharedDefinitions";

    /**
     * The metaclass qualified name.
     */
    @objid ("f781ea11-7d2a-48e7-b346-500d83a1d7bd")
    public static final String MQNAME = "Standard.BpmnSharedDefinitions";

    /**
     * Getter for relation 'BpmnSharedDefinitions->RootElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e233ef7b-8730-4394-b66c-e23b5b0b24c0")
    EList<BpmnSharedElement> getRootElement();

    /**
     * Filtered Getter for relation 'BpmnSharedDefinitions->RootElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7506905b-f1b4-4462-81fb-a0c578964366")
    <T extends BpmnSharedElement> List<T> getRootElement(java.lang.Class<T> filterClass);

}
