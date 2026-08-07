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
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;

/**
 * BpmnResource v0.0.9054
 *
 *
 * <p>The Resource class is used to specify resources that can be referenced by Activities or processes or other BPMN elements such as datastores. These Resources can be Human Resources as well as any other resource assigned to Activities during Process execution time.</p><p>The definition of a Resource is &quot;abstract&quot;,&nbsp;because it only defines the Resource, without detailing how e.g., actual user IDs are associated at runtime. Multiple Activities can utilize the same Resource.</p><p>Every Resource can define a set of ResourceParameters. These parameters can be used at runtime to define query e.g., into an Organizational Directory. Every Activity referencing a parameterized Resource can bind values available in the scope of the Activity to these parameters.</p><p>&nbsp;</p>
 *
 *
 */
@objid ("00093d64-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnResource extends BpmnSharedElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b618c58d-d3ef-4113-82a2-9bf52f88a4b7")
    public static final String MNAME = "BpmnResource";

    /**
     * The metaclass qualified name.
     */
    @objid ("3fbbb20d-1cea-452e-8e35-9177b957cbe7")
    public static final String MQNAME = "Standard.BpmnResource";

    /**
     * Getter for relation 'BpmnResource->ResourceroleRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7396d2d2-58f0-4d53-a741-0fdce3128375")
    EList<BpmnResourceRole> getResourceroleRefs();

    /**
     * Filtered Getter for relation 'BpmnResource->ResourceroleRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e484e681-70cd-449e-9622-9e8685c6b70b")
    <T extends BpmnResourceRole> List<T> getResourceroleRefs(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnResource->Parameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d8c27d29-30d8-44ee-a037-75f092bdb21f")
    EList<BpmnResourceParameter> getParameter();

    /**
     * Filtered Getter for relation 'BpmnResource->Parameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("636a600d-dde2-4de6-a873-b4476efa86c9")
    <T extends BpmnResourceParameter> List<T> getParameter(java.lang.Class<T> filterClass);

}
