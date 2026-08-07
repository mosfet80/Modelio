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
package org.modelio.archimate.metamodel.layers.technology.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * TechnologyProcess vnull
 *
 *
 * <p>A technology process describes internal behavior of a node; for the user of that node, this&nbsp;process is invisible. If its behavior is exposed externally, this is done through one or more&nbsp;technology services. A technology process abstracts from the way it is implemented. Only the&nbsp;necessary behavior is specified. It can use technology objects as input and use or transform these&nbsp;to produce other technology objects as output.</p><p>A technology process may realize technology services. Other technology services may serve (be&nbsp;used by) a technology process. A technology process may access technology objects. A node&nbsp;may be assigned to a technology process (which means that this node performs the process). The&nbsp;name of a technology process should clearly identify a series of technology behaviors, e.g.&nbsp;&quot;System boot sequence&quot; or &quot;Replicate database&quot;.</p>
 *
 *
 */
@objid ("ad16bb3e-5e14-4f29-8b10-91da9b5cd395")
public interface TechnologyProcess extends TechnologyInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("e96beb6b-1048-401a-b49c-ba6e3a4d1d9b")
    public static final String MNAME = "TechnologyProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("83262905-9a88-4ab5-bcd8-6760b1647bc6")
    public static final String MQNAME = "Archimate.TechnologyProcess";

}
