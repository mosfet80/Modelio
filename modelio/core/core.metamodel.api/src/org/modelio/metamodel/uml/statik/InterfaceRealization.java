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
 * InterfaceRealization v0.0.9054
 *
 *
 *  In Modelio, a Realization belongs to its Classifier.
 *
 */
@objid ("000ee2e6-c4bf-1fd8-97fe-001ec947cd2a")
public interface InterfaceRealization extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("6da4f05f-a78b-4981-b5a2-f367b6a51e48")
    public static final String MNAME = "InterfaceRealization";

    /**
     * The metaclass qualified name.
     */
    @objid ("ad28d31f-a603-40af-8892-f2abcc282daf")
    public static final String MQNAME = "Standard.InterfaceRealization";

    /**
     * Getter for relation 'InterfaceRealization->Implemented'
     *
     * Metamodel description:
     * <i>End of the implementation link toward an Interface.</i>
     */
    @objid ("ff808cff-4dbd-4c4a-b038-b2985d21daaf")
    Interface getImplemented();

    /**
     * Setter for relation 'InterfaceRealization->Implemented'
     *
     * Metamodel description:
     * <i>End of the implementation link toward an Interface.</i>
     */
    @objid ("3268a35d-8fc1-4b38-9aee-9f7d9a0b5594")
    void setImplemented(Interface value);

    /**
     * Getter for relation 'InterfaceRealization->Implementer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fb735f6c-3110-4b88-86a2-4a83eb2f7326")
    NameSpace getImplementer();

    /**
     * Setter for relation 'InterfaceRealization->Implementer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1439423d-5f91-4f4b-83a4-b169c7b34557")
    void setImplementer(NameSpace value);

}
