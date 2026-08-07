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
package org.modelio.archimate.metamodel.layers.application.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;

/**
 * ApplicationService vnull
 *
 *
 * <p>An application service exposes the functionality of components to their environment. This&nbsp;functionality is accessed through one or more application interfaces. An application service is&nbsp;realized by one or more application functions that are performed by the component. It may&nbsp;require, use, and produce data objects.</p><p>An application service should be meaningful from the point of view of the environment; it&nbsp;should provide a unit of behavior that is, in itself, useful to its users. It has a purpose, which&nbsp;states this utility to the environment. This means, for example, that if this environment includes&nbsp;business processes, application services should have business &nbsp;relevance.</p><p>A purpose may be associated with an application service. An application service may serve&nbsp;business processes, business functions, business interactions, or application functions. An&nbsp;application function may realize an application service. An application interface may be&nbsp;assigned to an application service. An application service may access data objects. The name of&nbsp;an application service should preferably be a verb ending with &quot;ing&quot;; e.g., &quot;transaction&nbsp;processing&quot;. Also, a name explicitly containing the word &quot;service&quot; may be used.</p>
 *
 *
 */
@objid ("10ed7497-0211-46a3-a245-21313fe325ed")
public interface ApplicationService extends ExternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("1f8d20bd-17ed-440a-bdd5-3ec69a399d25")
    public static final String MNAME = "ApplicationService";

    /**
     * The metaclass qualified name.
     */
    @objid ("235ad8d7-1fd2-4c2e-b066-36399bd27b1a")
    public static final String MQNAME = "Archimate.ApplicationService";

}
