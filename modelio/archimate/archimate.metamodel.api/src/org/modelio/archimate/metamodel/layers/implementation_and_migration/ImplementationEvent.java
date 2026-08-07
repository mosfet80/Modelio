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
package org.modelio.archimate.metamodel.layers.implementation_and_migration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.Event;

/**
 * ImplementationEvent vnull
 *
 *
 * <p>Work packages may be triggered or interrupted by an implementation event. Also, work&nbsp;packages may raise events that trigger other behavior. Unlike a work package, an event is&nbsp;instantaneous: it does not have duration.</p><p>An implementation event may have a time attribute that denotes the moment or moments at&nbsp;which the event happens. For example, this can be used to model project schedules and&nbsp;milestones; e.g., an event that triggers a work package, an event that denotes its completion&nbsp;(with a triggering relationship from the work package to the event), or an event that denotes a&nbsp;lifecycle change of a deliverable (via an access relationship to that deliverable).</p><p>Implementation events access deliverables to fulfill project objectives. For example, in a project&nbsp;to deliver a completely new application along with the technology needed to host it, an&nbsp;implementation event &quot;Release to production&quot; could access the deliverables &quot;Final build&quot;,&nbsp;&quot;staging environment&quot;, and &quot;Production environment&quot;.</p><p>An implementation event may trigger or be triggered (raised) by a work package or a plateau.</p><p>An implementation event may access a deliverable and may be composed of other&nbsp;implementation events.</p><p>An implementation event may be associated with any core element; e.g., to indicate a lifecycle&nbsp;state change. The name of an implementation event should preferably be a verb in the perfect&nbsp;tense; e.g., &quot;project initiation phase completed&quot;.</p>
 *
 *
 */
@objid ("5c7b6a2f-ea95-463d-adee-8e8f0f5aba61")
public interface ImplementationEvent extends Event {
    /**
     * The metaclass simple name.
     */
    @objid ("c5ef4863-e1a4-4b77-94cc-33df59fc60b0")
    public static final String MNAME = "ImplementationEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("76e12fc1-70f8-4ff4-bea9-5ca1bbafc41c")
    public static final String MQNAME = "Archimate.ImplementationEvent";

}
