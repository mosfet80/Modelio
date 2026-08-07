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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.layers.application.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ApplicationComponent vnull
 *
 *
 * <p>An application component is a self-contained unit. As such, it is independently deployable, re-usable, and replaceable. An application component performs one or more application functions.</p><p>It encapsulates its contents: its functionality is only accessible through a set of application&nbsp;interfaces. Cooperating application components are connected via application collaborations.</p><p>An application component may be assigned to one or more application functions, business&nbsp;processes, or business functions. An application component has one or more application&nbsp;interfaces, which expose its functionality. Application interfaces of other application&nbsp;components may serve an application component. The name of an application component should&nbsp;preferably be a noun.</p><p>The application component element is used to model entire applications (i.e., deployed and&nbsp;operational IT systems, as defined by the TOGAF framework) and individual parts of such&nbsp;applications, at all relevant levels of detail.</p>
 *
 *
 */
@objid ("16a2f86b-0d5a-4804-929f-dfaa20da3f6b")
public interface ApplicationComponent extends ApplicationInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("dbef4baa-004a-4d12-acb8-5adda5789129")
    public static final String MNAME = "ApplicationComponent";

    /**
     * The metaclass qualified name.
     */
    @objid ("57de72bb-de29-4716-b77a-1e15b2d646d1")
    public static final String MQNAME = "Archimate.ApplicationComponent";

}
