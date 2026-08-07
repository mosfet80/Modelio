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
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;

/**
 * BpmnItemAwareElement v0.0.9054
 *
 *
 * <p>Several elements in BPMN are subject to store or convey items during process execution. These elements are referenced generally as &quot;item-aware elements&quot;.&nbsp;This is similar to the variable construct common to many languages. As with variables, these elements have a ItemDefinition.</p><p>The data structure these elements hold is specified using an associated ItemDefinition. An item-aware element may be underspecified, meaning that the structure attribute of its ItemDefinition is optional if the modeler does not wish to define the structure of the associated data.</p><p>Ownership<br />
 * An ItemAwareElement belongs to a Flow Element COntainer or a SubProcess.</p>
 *
 *
 */
@objid ("0006fc34-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnItemAwareElement extends BpmnFlowElement {
    /**
     * The metaclass simple name.
     */
    @objid ("765b57ca-2768-42b4-82cd-36b1f7eb0592")
    public static final String MNAME = "BpmnItemAwareElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("c8f0eef3-58de-405a-8a3b-2de04a812398")
    public static final String MQNAME = "Standard.BpmnItemAwareElement";

    /**
     * Getter for relation 'BpmnItemAwareElement->TargetOfDataAssociation'
     *
     * Metamodel description:
     * <i>Data associations that computes the value of this element.</i>
     */
    @objid ("c8c36630-b5a2-45ba-a079-f7e8825f21b8")
    EList<BpmnDataAssociation> getTargetOfDataAssociation();

    /**
     * Filtered Getter for relation 'BpmnItemAwareElement->TargetOfDataAssociation'
     *
     * Metamodel description:
     * <i>Data associations that computes the value of this element.</i>
     */
    @objid ("312aa12f-19ba-4fe4-b459-82a759e74ebd")
    <T extends BpmnDataAssociation> List<T> getTargetOfDataAssociation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnItemAwareElement->ItemSubjectRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("552dc995-db95-4aa2-90ea-92ae9d8a5a1e")
    BpmnItemDefinition getItemSubjectRef();

    /**
     * Setter for relation 'BpmnItemAwareElement->ItemSubjectRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ae0ab1c5-e496-4bea-8cb2-f85b9c7c40e1")
    void setItemSubjectRef(BpmnItemDefinition value);

    /**
     * Getter for relation 'BpmnItemAwareElement->DataState'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f4c54f7e-9a50-4a94-ba94-39e72c9eca53")
    BpmnDataState getDataState();

    /**
     * Setter for relation 'BpmnItemAwareElement->DataState'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9e54443a-9a54-4804-af7a-dcbe16714d3e")
    void setDataState(BpmnDataState value);

    /**
     * Getter for relation 'BpmnItemAwareElement->SourceOfDataAssociation'
     *
     * Metamodel description:
     * <i>Data associations that use this element to compute a value.</i>
     */
    @objid ("f9c3cd4a-d518-4e60-a8d5-88b00ba932bb")
    EList<BpmnDataAssociation> getSourceOfDataAssociation();

    /**
     * Filtered Getter for relation 'BpmnItemAwareElement->SourceOfDataAssociation'
     *
     * Metamodel description:
     * <i>Data associations that use this element to compute a value.</i>
     */
    @objid ("c1588be3-5d49-420e-b97e-19f1eb19482d")
    <T extends BpmnDataAssociation> List<T> getSourceOfDataAssociation(java.lang.Class<T> filterClass);

}
