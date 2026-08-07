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

/**
 * ApplicationFunction vnull
 *
 *
 * <p>An application function describes the internal behavior of an application component. If this&nbsp;behavior is exposed externally, this is done through one or more services. An application&nbsp;function abstracts from the way it is implemented. Only the necessary behavior is specified.</p><p>An application function may realize one or more application services. Application services of&nbsp;other application functions and technology services may serve an application function. An&nbsp;application function may access data objects. An application component may be assigned to an&nbsp;application function (which means that the application component performs the application</p><p>function). The name of an application function should preferably be a verb ending with &#8220;ing&#8221;;&nbsp;e.g., &#8220;accounting&#8221;.</p>
 *
 *
 */
@objid ("971b1a4e-c858-4eab-bef1-f12b948e6795")
public interface ApplicationFunction extends ApplicationInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7314572d-d226-44fb-94b4-581043666b13")
    public static final String MNAME = "ApplicationFunction";

    /**
     * The metaclass qualified name.
     */
    @objid ("98fdc7f7-6055-458c-8968-a526bb84ec62")
    public static final String MQNAME = "Archimate.ApplicationFunction";

}
