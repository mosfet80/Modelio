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
 * TechnologyFunction vnull
 *
 *
 * <p>A technology function describes the internal behavior of a node; for the user of a node that&nbsp;performs a technology function, this function is invisible. If its behavior is exposed externally,&nbsp;this is done through one or more technology services. A technology function abstracts from the&nbsp;way it is implemented. Only the necessary behavior is specified.</p><p>A technology function may realize technology services. Technology services of other technology&nbsp;functions may serve technology functions. A technology function may access artifacts. A node&nbsp;may be assigned to a technology function (which means that the node performs the technology&nbsp;function). The name of a technology function should preferably be a verb ending with &quot;ing&quot;.</p>
 *
 *
 */
@objid ("a4a06a99-2f42-415b-9819-a87d9209d9c5")
public interface TechnologyFunction extends TechnologyInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("751e5503-63c4-4b19-ad40-21233793b4c7")
    public static final String MNAME = "TechnologyFunction";

    /**
     * The metaclass qualified name.
     */
    @objid ("3b98c8fa-52b3-41b0-833d-9461dc7d9762")
    public static final String MQNAME = "Archimate.TechnologyFunction";

}
