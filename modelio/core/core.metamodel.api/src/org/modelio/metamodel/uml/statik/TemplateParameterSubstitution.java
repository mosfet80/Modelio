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
package org.modelio.metamodel.uml.statik;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * TemplateParameterSubstitution v0.0.9054
 *
 *
 * A TemplateParameterSubstitution associates one or more actual Parameters with a formal template Parameter within the context of a TemplateBinding.
 *
 * In Modelio, a TemplateParameterSubstitution cannot own its actual value. The actual value can be referenced by the Actual dependency or defined by the StringValue attribute.
 *
 */
@objid ("001dff92-c4bf-1fd8-97fe-001ec947cd2a")
public interface TemplateParameterSubstitution extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7f0d6c72-04e0-415e-a11f-472a5cedac39")
    public static final String MNAME = "TemplateParameterSubstitution";

    /**
     * The metaclass qualified name.
     */
    @objid ("bafc13e9-8605-4f32-87d6-1ea3ac5794b2")
    public static final String MQNAME = "Standard.TemplateParameterSubstitution";

    /**
     * Getter for attribute 'TemplateParameterSubstitution.Value'
     *
     * Metamodel description:
     * <i>The value that is the actual parameter for this substitution. It is used for value template parameters.</i>
     */
    @objid ("f3eefa9a-db99-4f1a-bd7b-7f897760dce9")
    String getValue();

    /**
     * Setter for attribute 'TemplateParameterSubstitution.Value'
     *
     * Metamodel description:
     * <i>The value that is the actual parameter for this substitution. It is used for value template parameters.</i>
     */
    @objid ("5ec30f08-b00a-4327-b0e9-e2b6c9aad60d")
    void setValue(String value);

    /**
     * Getter for relation 'TemplateParameterSubstitution->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ef7f704e-8ec0-4867-939a-ffbb141b01b3")
    TemplateBinding getOwner();

    /**
     * Setter for relation 'TemplateParameterSubstitution->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2e96ba6c-c705-4f84-8d25-1209ed922a50")
    void setOwner(TemplateBinding value);

    /**
     * Getter for relation 'TemplateParameterSubstitution->Actual'
     *
     * Metamodel description:
     * <i>The elements that are the actual parameters for this substitution.</i>
     */
    @objid ("4ecd8092-4d47-4d8a-983f-8b5e4ecc6afa")
    UmlModelElement getActual();

    /**
     * Setter for relation 'TemplateParameterSubstitution->Actual'
     *
     * Metamodel description:
     * <i>The elements that are the actual parameters for this substitution.</i>
     */
    @objid ("88569e00-22bf-453f-aa5e-e1c8602a192f")
    void setActual(UmlModelElement value);

    /**
     * Getter for relation 'TemplateParameterSubstitution->FormalParameter'
     *
     * Metamodel description:
     * <i>The formal template parameter that is associated with this substitution.</i>
     */
    @objid ("d0adc866-ea64-4729-b0e7-8938b8f0c343")
    TemplateParameter getFormalParameter();

    /**
     * Setter for relation 'TemplateParameterSubstitution->FormalParameter'
     *
     * Metamodel description:
     * <i>The formal template parameter that is associated with this substitution.</i>
     */
    @objid ("b14355e6-0007-46b1-8fa1-3ef40f926c23")
    void setFormalParameter(TemplateParameter value);

}
