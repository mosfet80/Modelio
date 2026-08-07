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
import org.modelio.metamodel.uml.statik.VisibilityMode;

/**
 * ExtensionPoint v0.0.9054
 *
 *
 * An extension point identifies a point in the behavior of a use case where that behavior can be extended by the behavior of some other (extending) use case, as specified by an extend relationship.
 *
 * An ExtensionPoint is a feature of a use case that identifies a point where the behavior of a use case can be augmented with elements of another (extending) use case.
 *
 */
@objid ("00598058-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExtensionPoint extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("0360553b-0387-4020-8a4a-967b86fa8488")
    public static final String MNAME = "ExtensionPoint";

    /**
     * The metaclass qualified name.
     */
    @objid ("80f3932d-42af-41b8-b807-8603cd44b1db")
    public static final String MQNAME = "Standard.ExtensionPoint";

    /**
     * Getter for attribute 'ExtensionPoint.Visibility'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("715c73eb-9bfe-4875-8621-2656abb4450a")
    VisibilityMode getVisibility();

    /**
     * Setter for attribute 'ExtensionPoint.Visibility'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("38599e98-0bb5-4003-a094-86eeb6a8c9fe")
    void setVisibility(VisibilityMode value);

    /**
     * Getter for relation 'ExtensionPoint->Extended'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("85960e54-bc22-412c-ab53-ab2c21584727")
    EList<UseCaseDependency> getExtended();

    /**
     * Filtered Getter for relation 'ExtensionPoint->Extended'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("efb33c42-47f6-47bc-990f-0ea567afd24a")
    <T extends UseCaseDependency> List<T> getExtended(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ExtensionPoint->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a67371d7-fb7f-46e1-abc2-fb4c39dd91ec")
    UseCase getOwner();

    /**
     * Setter for relation 'ExtensionPoint->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("754ae2d1-1a26-4f3e-9e9d-b5c7c17ee375")
    void setOwner(UseCase value);

}
