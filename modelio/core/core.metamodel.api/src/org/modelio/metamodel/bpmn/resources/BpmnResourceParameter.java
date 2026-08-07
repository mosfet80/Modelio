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
package org.modelio.metamodel.bpmn.resources;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnResourceParameter v0.0.9054
 *
 *
 * null
 *
 */
@objid ("0009e2dc-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnResourceParameter extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("112a9e2e-45f4-49fc-875a-e591aa47b983")
    public static final String MNAME = "BpmnResourceParameter";

    /**
     * The metaclass qualified name.
     */
    @objid ("c9ac160c-557c-4884-a96e-5d46e759b8c9")
    public static final String MQNAME = "Standard.BpmnResourceParameter";

    /**
     * Getter for attribute 'BpmnResourceParameter.IsRequired'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fd44ca2b-e466-407d-8b23-1eb871c76c16")
    boolean isIsRequired();

    /**
     * Setter for attribute 'BpmnResourceParameter.IsRequired'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("40fe83cc-70f3-435c-8b6c-132eaa950794")
    void setIsRequired(boolean value);

    /**
     * Getter for relation 'BpmnResourceParameter->Resource'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b0212215-bf93-44e1-965c-de7017aaf3c2")
    BpmnResource getResource();

    /**
     * Setter for relation 'BpmnResourceParameter->Resource'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b32c149d-1c43-44b8-9886-bf03a8a08d00")
    void setResource(BpmnResource value);

    /**
     * Getter for relation 'BpmnResourceParameter->Type'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aa5421ed-8d36-4f5e-97db-a0c8712fa618")
    BpmnItemDefinition getType();

    /**
     * Setter for relation 'BpmnResourceParameter->Type'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ee70113f-1392-4b06-8ef9-8db3051338d4")
    void setType(BpmnItemDefinition value);

    /**
     * Getter for relation 'BpmnResourceParameter->ParameterBindingRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("47c58afb-6535-4238-9566-1134efb082d5")
    EList<BpmnResourceParameterBinding> getParameterBindingRefs();

    /**
     * Filtered Getter for relation 'BpmnResourceParameter->ParameterBindingRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2489b80f-e0b9-464e-a17d-e326b322df49")
    <T extends BpmnResourceParameterBinding> List<T> getParameterBindingRefs(java.lang.Class<T> filterClass);

}
