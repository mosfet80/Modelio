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
 * ApplicationCollaboration vnull
 *
 *
 * <p>An application collaboration specifies which components cooperate to perform some task. The&nbsp;collaborative behavior, including, for example, the communication pattern of these components,&nbsp;is modeled by an application interaction. An application collaboration typically models a logical&nbsp;or temporary collaboration of application components, and does not exist as a separate entity in&nbsp;the enterprise.</p><p>An application collaboration is a specialization of a component, and aggregates two or more&nbsp;(cooperating) application components. An application collaboration is an active structure&nbsp;element that may be assigned to one or more application interactions, business interactions, or&nbsp;other application or business internal behavior elements, which model the associated behavior.</p><p>An application interface may serve an application collaboration, and an application collaboration&nbsp;may be composed of application interfaces. The name of an application collaboration should&nbsp;preferably be a noun.</p>
 *
 *
 */
@objid ("248d6410-3113-49c1-91d3-183836e880a2")
public interface ApplicationCollaboration extends ApplicationInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("49fe2849-981f-472c-984e-2b8dcbd902e7")
    public static final String MNAME = "ApplicationCollaboration";

    /**
     * The metaclass qualified name.
     */
    @objid ("9a68ea1a-8a04-4111-adf9-5f9c59104c24")
    public static final String MQNAME = "Archimate.ApplicationCollaboration";

}
