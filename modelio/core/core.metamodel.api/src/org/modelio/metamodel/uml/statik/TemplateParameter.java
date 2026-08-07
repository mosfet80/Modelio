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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * TemplateParameter v0.0.9054
 *
 *
 * NameSpaces and Operations can be templated by TemplateParameters.
 *
 * Concerning NameSpaces, this particularly applies for Classes, Packages and Collaborations.
 *
 * In Modelio, TemplateParameters belong to their parameterized NameSpace or Operation.
 *
 */
@objid ("001d18e8-c4bf-1fd8-97fe-001ec947cd2a")
public interface TemplateParameter extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("72540c0c-63c1-4ccd-9c5d-2a2e85d499cc")
    public static final String MNAME = "TemplateParameter";

    /**
     * The metaclass qualified name.
     */
    @objid ("6a60323c-98a2-4290-bd45-4ee02bb029ab")
    public static final String MQNAME = "Standard.TemplateParameter";

    /**
     * Getter for attribute 'TemplateParameter.DefaultValue'
     *
     * Metamodel description:
     * <i>Default parameter value, when the IsValueParameter is true.</i>
     */
    @objid ("e8270549-b94f-4309-b9d6-871376982df5")
    String getDefaultValue();

    /**
     * Setter for attribute 'TemplateParameter.DefaultValue'
     *
     * Metamodel description:
     * <i>Default parameter value, when the IsValueParameter is true.</i>
     */
    @objid ("1fe9f115-d49b-4c99-a1c8-6f162161b43f")
    void setDefaultValue(String value);

    /**
     * Getter for attribute 'TemplateParameter.IsValueParameter'
     *
     * Metamodel description:
     * <i>Expresses if the parameter is a value, which is in this case "DefaultValue".</i>
     */
    @objid ("dce7d882-ee54-43d5-adbc-ce62f94f2d69")
    boolean isIsValueParameter();

    /**
     * Setter for attribute 'TemplateParameter.IsValueParameter'
     *
     * Metamodel description:
     * <i>Expresses if the parameter is a value, which is in this case "DefaultValue".</i>
     */
    @objid ("82277398-123a-4754-bc86-ba0a828bc8f4")
    void setIsValueParameter(boolean value);

    /**
     * Getter for relation 'TemplateParameter->ParameterSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0ed00e1c-613f-49bb-9224-4a9d52f74657")
    EList<TemplateParameterSubstitution> getParameterSubstitution();

    /**
     * Filtered Getter for relation 'TemplateParameter->ParameterSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6c75ee79-1d3f-49ae-a38a-7cd8b058c137")
    <T extends TemplateParameterSubstitution> List<T> getParameterSubstitution(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'TemplateParameter->Type'
     *
     * Metamodel description:
     * <i>Default parameter type, when IsValueParameter is false.</i>
     */
    @objid ("df45389b-db20-4096-9b0b-9a1308da246d")
    UmlModelElement getType();

    /**
     * Setter for relation 'TemplateParameter->Type'
     *
     * Metamodel description:
     * <i>Default parameter type, when IsValueParameter is false.</i>
     */
    @objid ("74300d9a-30ce-41d5-a345-696b7a3c802b")
    void setType(UmlModelElement value);

    /**
     * Getter for relation 'TemplateParameter->Parameterized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d2408a79-87d2-4e6c-8205-14e1a37f5181")
    NameSpace getParameterized();

    /**
     * Setter for relation 'TemplateParameter->Parameterized'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ab85a7e8-9738-4482-bc5f-e4f198f21d42")
    void setParameterized(NameSpace value);

    /**
     * Getter for relation 'TemplateParameter->OwnedParameterElement'
     *
     * Metamodel description:
     * <i>A TemplateParameter references a ParameterableElement that is exposed as a formal template parameter in the container template. This parameterizable element is meaningful only within the template, or other templates that may have access to its content (for example, if the template supports specialization). The exposed parameterizable element may not be used in other parts of the model. A TemplateParameter may own the exposed ParameterableElement in situations where that element is only referenced from within the template.</i>
     */
    @objid ("e5e2fd6f-0af6-4ffd-a1f9-34e58674c4f7")
    UmlModelElement getOwnedParameterElement();

    /**
     * Setter for relation 'TemplateParameter->OwnedParameterElement'
     *
     * Metamodel description:
     * <i>A TemplateParameter references a ParameterableElement that is exposed as a formal template parameter in the container template. This parameterizable element is meaningful only within the template, or other templates that may have access to its content (for example, if the template supports specialization). The exposed parameterizable element may not be used in other parts of the model. A TemplateParameter may own the exposed ParameterableElement in situations where that element is only referenced from within the template.</i>
     */
    @objid ("aecddbc3-8094-4c4d-ae00-745425478e88")
    void setOwnedParameterElement(UmlModelElement value);

    /**
     * Getter for relation 'TemplateParameter->DefaultType'
     *
     * Metamodel description:
     * <i>Value that the parameter takes if no specific value is specified.</i>
     */
    @objid ("fcd6b7c0-0f6e-4733-9198-b17911a9bab5")
    UmlModelElement getDefaultType();

    /**
     * Setter for relation 'TemplateParameter->DefaultType'
     *
     * Metamodel description:
     * <i>Value that the parameter takes if no specific value is specified.</i>
     */
    @objid ("92a3e4ba-b5b8-4c09-ab3c-ee6675e8c397")
    void setDefaultType(UmlModelElement value);

    /**
     * Getter for relation 'TemplateParameter->ParameterizedOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("63739155-91b7-48fb-94fb-eba8d7b7ad0a")
    Operation getParameterizedOperation();

    /**
     * Setter for relation 'TemplateParameter->ParameterizedOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dd5f111b-efc7-4158-b8b8-8ca0c9f1ba18")
    void setParameterizedOperation(Operation value);

}
