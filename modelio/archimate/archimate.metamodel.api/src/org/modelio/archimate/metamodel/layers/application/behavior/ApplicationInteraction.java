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
 * ApplicationInteraction vnull
 *
 *
 * <p>An application interaction describes the collective behavior that is performed by the components&nbsp;that participate in an application collaboration. This may, for example, include the&nbsp;communication pattern between these components. An application interaction can also specify&nbsp;the externally visible behavior needed to realize an application service. The details of the&nbsp;interaction between the application components involved in an application interaction can be&nbsp;expressed during the detailed application design using, for example, a UML interaction diagram.</p><p>An application collaboration may be assigned to an application interaction. An application&nbsp;interaction may realize an application service. Application services and technology services may&nbsp;serve an application interaction. An application interaction may access data objects. The name of&nbsp;an application interaction should clearly identify a series of application behaviors; e.g., &#8220;Client&nbsp;profile creation&#8221; or &#8220;Update customer records&#8221;.</p>
 *
 *
 */
@objid ("2ee9f5e5-9bf0-4208-b308-cc20a7f37672")
public interface ApplicationInteraction extends ApplicationInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("1dbd8191-d707-4dd0-ad0b-e2d0c6fae5ad")
    public static final String MNAME = "ApplicationInteraction";

    /**
     * The metaclass qualified name.
     */
    @objid ("2330efd0-3c6a-445a-b1b0-52bc4e8a9ce5")
    public static final String MQNAME = "Archimate.ApplicationInteraction";

}
