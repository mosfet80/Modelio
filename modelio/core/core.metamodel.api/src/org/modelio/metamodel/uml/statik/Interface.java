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

/**
 * Interface v0.0.9054
 *
 *
 * An Interface specifies a contract. Any Instance of a Classifier that realizes the Interface must fulfill this contract. The obligations that may be associated with an Interface take the form of various kinds of Constraints (such as pre-conditions and post-conditions) or protocol specifications, which may impose ordering restrictions on Interactions through the Interface.
 *
 * Since Interfaces are declarations, they are not instanciable. Instead, an Interface specification is implemented by an Instance of an instanciable Classifier, which means that the instanciable Classifier presents a public facade that conforms to the Interface specification.
 *
 * Note that a given Classifier may implement more than one Interface and that an Interface may be implemented by a number of different Classifiers.
 *
 * Constraints: The visibility of all Features owned by an Interface must be public.
 *
 */
@objid ("000e151e-c4bf-1fd8-97fe-001ec947cd2a")
public interface Interface extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("38631286-0e2c-4cff-9410-682cd2275a10")
    public static final String MNAME = "Interface";

    /**
     * The metaclass qualified name.
     */
    @objid ("68c2bbfa-a199-4e54-a986-94f8f2110757")
    public static final String MQNAME = "Standard.Interface";

    /**
     * Getter for relation 'Interface->Requiring'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("251dd38e-d5b8-4159-9f6a-1b8ed0ac8f7a")
    EList<RequiredInterface> getRequiring();

    /**
     * Filtered Getter for relation 'Interface->Requiring'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7cdaff32-5ba9-45e1-99eb-678f5ed969d3")
    <T extends RequiredInterface> List<T> getRequiring(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Interface->ImplementedLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8b09df86-af82-455d-ab1a-7e223e2f8aa5")
    EList<InterfaceRealization> getImplementedLink();

    /**
     * Filtered Getter for relation 'Interface->ImplementedLink'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("660ad948-6484-4837-a675-12730ba4b0e3")
    <T extends InterfaceRealization> List<T> getImplementedLink(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Interface->Providing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1cee483c-520c-4b42-b263-7e2a6154c6c1")
    EList<ProvidedInterface> getProviding();

    /**
     * Filtered Getter for relation 'Interface->Providing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4ef9b5b8-d7f0-4571-b01e-7d758a4b10f6")
    <T extends ProvidedInterface> List<T> getProviding(java.lang.Class<T> filterClass);

}
