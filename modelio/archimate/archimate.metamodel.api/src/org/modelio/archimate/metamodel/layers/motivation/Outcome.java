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
package org.modelio.archimate.metamodel.layers.motivation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;

/**
 * Outcome vnull
 *
 *
 * <p>Outcomes are high-level, business-oriented results produced by capabilities of an organization,&nbsp;and by inference by the core elements of its architecture that realize these capabilities.</p><p>Outcomes&nbsp;are tangible, possibly quantitative, and time-related, and can be associated with assessments. An&nbsp;outcome may have a different value for different stakeholders.</p><p>The notion of outcome is important in business outcome-driven approaches to Enterprise&nbsp;Architecture and in capability-based planning. Outcomes are closely related to requirements,&nbsp;goals, and other intentions. Outcomes are the end results, and goals or requirements are often&nbsp;formulated in terms of outcomes that should be realized. Capabilities are designed to achieve&nbsp;such outcomes.</p><p>Outcome names should unambiguously identify end results that have been achieved in order to&nbsp;avoid confusion with actions or goals. At a minimum, outcome names should consist of a noun&nbsp;identifying the end result followed by a past-tense verb or adjective indicating that the result has&nbsp;been achieved. Examples include &quot;First-place ranking achieved&quot; and &quot;Key supplier partnerships&nbsp;in place&quot;. Outcome names can also be more specific, e.g. &quot;2015 quarterly profits rose 10% year&nbsp;over year beginning in Q3&quot;.</p>
 *
 *
 */
@objid ("0e861f8d-49ba-4c8b-8dc1-a9c97dac3e9c")
public interface Outcome extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("87c3a303-b28c-45c0-bd68-2a974410b3e9")
    public static final String MNAME = "Outcome";

    /**
     * The metaclass qualified name.
     */
    @objid ("16b82c7f-c75b-4927-a4ba-5ce988594231")
    public static final String MQNAME = "Archimate.Outcome";

}
