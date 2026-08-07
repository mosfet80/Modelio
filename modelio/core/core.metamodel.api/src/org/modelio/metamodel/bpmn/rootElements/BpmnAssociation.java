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

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnAssociation v0.0.9054
 *
 *
 * An Association is used to associate information and Artifacts with Flow Objects. Text and graphical non-Flow Objects can be associated with the Flow Objects and Flow. An Association is also used to show the Activity used for
 * compensation.
 *
 * Within Modelio, Text Annotation is implemented by Notes: association is thus not used to connect Notes to Model elements.
 *
 */
@objid ("00772770-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnAssociation extends BpmnArtifact {
    /**
     * The metaclass simple name.
     */
    @objid ("0793157c-652b-4589-8c1c-f9c767212135")
    public static final String MNAME = "BpmnAssociation";

    /**
     * The metaclass qualified name.
     */
    @objid ("986b6ec0-9d5b-482a-a166-d257560fc816")
    public static final String MQNAME = "Standard.BpmnAssociation";

    /**
     * Getter for attribute 'BpmnAssociation.AssociationDirection'
     *
     * Metamodel description:
     * <i>associationDirection is an attribute that defines whether or not the Association shows any directionality with an arrowhead.
     * The default is None (no arrowhead).
     * A value of One means that the arrowhead SHALL be at the Target Object.
     * A value of Both means that there SHALL be an arrowhead at both ends of the Association line.</i>
     */
    @objid ("393291f0-75dd-4bfa-b6d1-4e0197d4dd9b")
    BpmnAssociationDirection getAssociationDirection();

    /**
     * Setter for attribute 'BpmnAssociation.AssociationDirection'
     *
     * Metamodel description:
     * <i>associationDirection is an attribute that defines whether or not the Association shows any directionality with an arrowhead.
     * The default is None (no arrowhead).
     * A value of One means that the arrowhead SHALL be at the Target Object.
     * A value of Both means that there SHALL be an arrowhead at both ends of the Association line.</i>
     */
    @objid ("522456ad-54bb-4f38-b0dd-14ff15ef3074")
    void setAssociationDirection(BpmnAssociationDirection value);

    /**
     * Getter for relation 'BpmnAssociation->TargetRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting to.</i>
     */
    @objid ("7d3f4ce1-f307-4ba4-b093-ac04d6fbcc74")
    BpmnBaseElement getTargetRef();

    /**
     * Setter for relation 'BpmnAssociation->TargetRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting to.</i>
     */
    @objid ("c4167559-3f89-46e3-a86e-1e35aacefcc8")
    void setTargetRef(BpmnBaseElement value);

    /**
     * Getter for relation 'BpmnAssociation->SourceRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting from.</i>
     */
    @objid ("4d925475-1cbf-4bc9-9bc7-0fd44bc7ee24")
    BpmnBaseElement getSourceRef();

    /**
     * Setter for relation 'BpmnAssociation->SourceRef'
     *
     * Metamodel description:
     * <i>The BaseElement that the Association is connecting from.</i>
     */
    @objid ("8d524129-3543-4a38-b087-02902a438d77")
    void setSourceRef(BpmnBaseElement value);

}
