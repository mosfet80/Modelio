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

/**
 * BpmnGroup v0.0.9054
 *
 *
 * <p>The Group object is an Artifact that provides a visual mechanism to group elements of a diagram informally. The grouping is tied to the Category supporting element . That is, a Group is a visual depiction of a single Category. The graphical elements within the Group will be assigned the Category of the Group. (Note: Categories can be highlighted through other mechanisms, such as color, as defined by a modeler or a modeling tool). Categories, which have user-defined semantics, can be used for documentation or analysis purposes.</p><p>For example, FlowElements can be categorized has being customer oriented vs. support oriented.</p><p>Groups are one way in which Categories of objects can be visually displayed on the diagram. That is, a Group is a visual depiction of a single Category. The graphical elements within the Group will be assigned the Category of the Group. The Category name appears on the diagram as the Group label. (Note:&nbsp;Categories can be highlighted through other mechanisms, such as color, as defined by a modeler or a modeling tool). A single Category can be used for multiple Groups in a diagram.</p><p>&nbsp;</p>
 *
 *
 */
@objid ("007a3514-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnGroup extends BpmnArtifact {
    /**
     * The metaclass simple name.
     */
    @objid ("72ffed0b-bd22-492d-8767-641b419a54f1")
    public static final String MNAME = "BpmnGroup";

    /**
     * The metaclass qualified name.
     */
    @objid ("ec5967d4-c384-42fa-8c38-462d257e7139")
    public static final String MQNAME = "Standard.BpmnGroup";

    /**
     * Getter for attribute 'BpmnGroup.Category'
     *
     * Metamodel description:
     * <i>specifies the Category that the Group represents (Further details about the definition of a Category can be found on page 92). The name of the Category provides the label for the Group.
     * The graphical elements within the boundaries of the Group will be assigned the Category.</i>
     */
    @objid ("fbd46a51-7223-4648-ac62-65fc035c13e8")
    String getCategory();

    /**
     * Setter for attribute 'BpmnGroup.Category'
     *
     * Metamodel description:
     * <i>specifies the Category that the Group represents (Further details about the definition of a Category can be found on page 92). The name of the Category provides the label for the Group.
     * The graphical elements within the boundaries of the Group will be assigned the Category.</i>
     */
    @objid ("5324f91f-ebb4-49b8-bf56-aa325ddaf8d2")
    void setCategory(String value);

    /**
     * Getter for relation 'BpmnGroup->Categorized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a0e63321-983e-4a41-91a3-d2bf4298a96a")
    EList<BpmnFlowElement> getCategorized();

    /**
     * Filtered Getter for relation 'BpmnGroup->Categorized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("83bc30a1-85c8-4522-903f-6ece4871679a")
    <T extends BpmnFlowElement> List<T> getCategorized(java.lang.Class<T> filterClass);

}
