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
 * TemplateBinding v0.0.9054
 *
 *
 * A TemplateBinding specifies the Substitution of actual Parameters by the formal Parameters of the template.
 *
 * A TemplateBinding is a directed relationship from a bound templateable element to the template signature of the target template.
 *
 * A TemplateBinding owns a set of TemplateParameterSubstitutions.
 *
 */
@objid ("001c3784-c4bf-1fd8-97fe-001ec947cd2a")
public interface TemplateBinding extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("39fb9c84-df02-47a1-8b3c-1ab02d7684a9")
    public static final String MNAME = "TemplateBinding";

    /**
     * The metaclass qualified name.
     */
    @objid ("048d8b4a-136b-4d8c-b92c-e91cc584cbc7")
    public static final String MQNAME = "Standard.TemplateBinding";

    /**
     * Getter for relation 'TemplateBinding->ParameterSubstitution'
     *
     * Metamodel description:
     * <i>The ParameterSubstitutions owned by this TemplateBinding.</i>
     */
    @objid ("6c305b67-d96d-43bf-9df0-bd82a288f3d8")
    EList<TemplateParameterSubstitution> getParameterSubstitution();

    /**
     * Filtered Getter for relation 'TemplateBinding->ParameterSubstitution'
     *
     * Metamodel description:
     * <i>The ParameterSubstitutions owned by this TemplateBinding.</i>
     */
    @objid ("70dcd2bb-b2e9-41a2-985b-75708d7e981e")
    <T extends TemplateParameterSubstitution> List<T> getParameterSubstitution(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'TemplateBinding->BoundOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fd45d646-7cfc-4bc4-ad57-ecad0132afa2")
    Operation getBoundOperation();

    /**
     * Setter for relation 'TemplateBinding->BoundOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7058694c-e12d-4a56-9573-61a1c5434439")
    void setBoundOperation(Operation value);

    /**
     * Getter for relation 'TemplateBinding->InstanciatedTemplateOperation'
     *
     * Metamodel description:
     * <i>The element that is bound by this Binding.</i>
     */
    @objid ("ecb41dd4-b59a-45c5-b57d-1749b5ae0920")
    Operation getInstanciatedTemplateOperation();

    /**
     * Setter for relation 'TemplateBinding->InstanciatedTemplateOperation'
     *
     * Metamodel description:
     * <i>The element that is bound by this Binding.</i>
     */
    @objid ("621c11de-7f15-4304-ac62-9654b315bc95")
    void setInstanciatedTemplateOperation(Operation value);

    /**
     * Getter for relation 'TemplateBinding->InstanciatedTemplate'
     *
     * Metamodel description:
     * <i>The template element that is the target of the Binding.</i>
     */
    @objid ("8e373816-2326-4db8-9e5e-912614385d4b")
    NameSpace getInstanciatedTemplate();

    /**
     * Setter for relation 'TemplateBinding->InstanciatedTemplate'
     *
     * Metamodel description:
     * <i>The template element that is the target of the Binding.</i>
     */
    @objid ("cac06e52-8515-4511-ab36-b9ecf19351c7")
    void setInstanciatedTemplate(NameSpace value);

    /**
     * Getter for relation 'TemplateBinding->BoundElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("05c0940d-87ae-4852-aafb-e6bf6b298be8")
    NameSpace getBoundElement();

    /**
     * Setter for relation 'TemplateBinding->BoundElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("350e3bf0-cc9a-45ef-adbb-04027b96c849")
    void setBoundElement(NameSpace value);

}
