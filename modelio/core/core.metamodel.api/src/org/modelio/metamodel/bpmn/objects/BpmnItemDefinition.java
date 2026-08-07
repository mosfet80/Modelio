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
package org.modelio.metamodel.bpmn.objects;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;

/**
 * BpmnItemDefinition v0.0.9054
 *
 *
 * null
 *
 */
@objid ("0007a24c-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnItemDefinition extends BpmnSharedElement {
    /**
     * The metaclass simple name.
     */
    @objid ("9f4e4858-9154-4a04-be47-8c999efc630e")
    public static final String MNAME = "BpmnItemDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("56d44407-afee-41b4-a20a-e284a9907c67")
    public static final String MQNAME = "Standard.BpmnItemDefinition";

    /**
     * Getter for attribute 'BpmnItemDefinition.ItemKind'
     *
     * Metamodel description:
     * <i>This defines the nature of the Item. Possible values are physical or
     * information. The default value is information.</i>
     */
    @objid ("da77ca45-850a-4c92-80d7-bde18ee285c8")
    BpmnItemKind getItemKind();

    /**
     * Setter for attribute 'BpmnItemDefinition.ItemKind'
     *
     * Metamodel description:
     * <i>This defines the nature of the Item. Possible values are physical or
     * information. The default value is information.</i>
     */
    @objid ("b9a87b2d-42ff-4d4a-ac3f-724b7c2f63ec")
    void setItemKind(BpmnItemKind value);

    /**
     * Getter for attribute 'BpmnItemDefinition.IsCollection'
     *
     * Metamodel description:
     * <i>Setting this flag to true indicates that the actual data type is a
     * collection.</i>
     */
    @objid ("d92aa8e0-b09b-4e32-b4c9-84ba136684c6")
    boolean isIsCollection();

    /**
     * Setter for attribute 'BpmnItemDefinition.IsCollection'
     *
     * Metamodel description:
     * <i>Setting this flag to true indicates that the actual data type is a
     * collection.</i>
     */
    @objid ("5bddb732-93af-4572-a830-3e3bbe9a6461")
    void setIsCollection(boolean value);

    /**
     * Getter for relation 'BpmnItemDefinition->TypedMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ea09f2d8-8225-48b4-bc05-b2315eacba3e")
    EList<BpmnMessage> getTypedMessage();

    /**
     * Filtered Getter for relation 'BpmnItemDefinition->TypedMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4ba8b60b-9ea0-49db-8b7e-50314473edc4")
    <T extends BpmnMessage> List<T> getTypedMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnItemDefinition->TypedItem'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("14f358e3-2028-425a-a5b5-96be8c3c641a")
    EList<BpmnItemAwareElement> getTypedItem();

    /**
     * Filtered Getter for relation 'BpmnItemDefinition->TypedItem'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7ebbedc9-54e7-45e7-8219-ccfbee0f9598")
    <T extends BpmnItemAwareElement> List<T> getTypedItem(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnItemDefinition->TypedResourceParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a6b3f557-99e5-43ac-b245-c5d61ce1fa73")
    EList<BpmnResourceParameter> getTypedResourceParameter();

    /**
     * Filtered Getter for relation 'BpmnItemDefinition->TypedResourceParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8818abee-83ab-4932-92c4-2bbf494c4f36")
    <T extends BpmnResourceParameter> List<T> getTypedResourceParameter(java.lang.Class<T> filterClass);

}
