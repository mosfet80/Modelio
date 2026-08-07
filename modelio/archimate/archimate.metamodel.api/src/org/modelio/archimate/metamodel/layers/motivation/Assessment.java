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
 * Assessment vnull
 *
 *
 * <p>An assessment may reveal strengths, weaknesses, opportunities, or threats for some area of&nbsp;interest. These need to be addressed by adjusting existing goals or setting new ones, which may&nbsp;trigger changes to the Enterprise Architecture.</p><p>Strengths and weaknesses are internal to the organization. Opportunities and threats are external&nbsp;to the organization. Weaknesses and threats can be considered as problems that need to be&nbsp;addressed by goals that &quot;negate&quot; the weaknesses and threats. Strengths and opportunities may be&nbsp;translated directly into goals. For example, the weakness &quot;Customers complain about the&nbsp;helpdesk&quot; can be addressed by defining the goal &quot;Improve helpdesk&quot;. Or, the opportunity&nbsp;&quot;Customers favor insurances that can be managed online&quot; can be addressed by the goal&nbsp;&quot;Introduce online portfolio management&quot;.</p><p>The name of an assessment should preferably be a&nbsp;noun or a (very) short sentence.</p>
 *
 *
 */
@objid ("a121d65b-1e4f-4fec-97e4-1ccd7ff53f02")
public interface Assessment extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("67f0fa42-eb68-4f75-92d1-28f9a64c221b")
    public static final String MNAME = "Assessment";

    /**
     * The metaclass qualified name.
     */
    @objid ("0d23de43-f073-45a8-a97e-5f91af9c25bd")
    public static final String MQNAME = "Archimate.Assessment";

}
