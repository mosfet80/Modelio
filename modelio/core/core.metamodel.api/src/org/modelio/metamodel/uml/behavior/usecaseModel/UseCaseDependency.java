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
package org.modelio.metamodel.uml.behavior.usecaseModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * UseCaseDependency v0.0.9054
 *
 *
 * In Modelio, this specific metaclass has been created for the definition of these links.
 *
 * Two predefined Stereotypes are defined for this link: <extends>> and <<includes>>.
 *
 * UseCaseDependencies belong to their origin UseCase.
 *
 */
@objid ("0058fd18-c4bf-1fd8-97fe-001ec947cd2a")
public interface UseCaseDependency extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("bf9a37bf-7196-4a35-acba-0bc66cd11897")
    public static final String MNAME = "UseCaseDependency";

    /**
     * The metaclass qualified name.
     */
    @objid ("cc7f0fd1-9984-4caf-8957-7bbe2272e8ec")
    public static final String MQNAME = "Standard.UseCaseDependency";

    /**
     * Getter for relation 'UseCaseDependency->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b81355e9-96fc-4f3a-9868-5aa3d3454167")
    UseCase getOrigin();

    /**
     * Setter for relation 'UseCaseDependency->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("49362434-a599-4eff-bd50-49ae1a4f1734")
    void setOrigin(UseCase value);

    /**
     * Getter for relation 'UseCaseDependency->ExtensionLocation'
     *
     * Metamodel description:
     * <i>An ordered list of extension points belonging to the extended use case, specifying where the respective behavioral fragments of the extending use case are to be inserted. The first fragment in the extending use case is associated with the first extension point in the list, the second fragment with the second point, and so on. (Note that, in most practical cases, the extending use case has just a single behavior fragment, so that the list of extension points is trivial.)</i>
     */
    @objid ("f0fbf53b-eea8-44be-ac0c-930367952409")
    EList<ExtensionPoint> getExtensionLocation();

    /**
     * Filtered Getter for relation 'UseCaseDependency->ExtensionLocation'
     *
     * Metamodel description:
     * <i>An ordered list of extension points belonging to the extended use case, specifying where the respective behavioral fragments of the extending use case are to be inserted. The first fragment in the extending use case is associated with the first extension point in the list, the second fragment with the second point, and so on. (Note that, in most practical cases, the extending use case has just a single behavior fragment, so that the list of extension points is trivial.)</i>
     */
    @objid ("ac3168f6-fc2c-4ea5-9931-fa8d7a339209")
    <T extends ExtensionPoint> List<T> getExtensionLocation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UseCaseDependency->Target'
     *
     * Metamodel description:
     * <i>In a dependency between UseCases, this defines the link to the target UseCase.</i>
     */
    @objid ("fd38b9b6-28a9-447d-b666-e191be39f130")
    UseCase getTarget();

    /**
     * Setter for relation 'UseCaseDependency->Target'
     *
     * Metamodel description:
     * <i>In a dependency between UseCases, this defines the link to the target UseCase.</i>
     */
    @objid ("cd4e2035-9ebe-42d6-a6e8-df5027097cdc")
    void setTarget(UseCase value);

}
