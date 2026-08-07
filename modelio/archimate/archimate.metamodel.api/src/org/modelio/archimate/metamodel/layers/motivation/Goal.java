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
 * Goal vnull
 *
 *
 * <p>In principle, a goal can represent anything a stakeholder may desire, such as a state of affairs, or&nbsp;a produced value. Examples of goals are: to increase profit, to reduce waiting times at the&nbsp;helpdesk, or to introduce online portfolio management. Goals are typically used to measure&nbsp;success of an organization.</p><p>Goals are generally expressed using qualitative words; e.g., &quot;increase&quot;, &quot;improve&quot;, or &quot;easier&quot;.&nbsp;</p><p>Goals can also be decomposed; e.g., Increase profit can be decomposed into the goals Reduce&nbsp;cost and Increase sales. However, it is also very common to associate concrete outcomes with&nbsp;goals, which can be used to describe both the quantitative and time-related results that are&nbsp;essential to describe the desired state, and when it should be achieved.</p>
 *
 * <h3>Refinment and equivalence link</h3>
 *
 * <p>An Archimate goal may be refined in an Analyst goal. The Archimate goal may then be set as equivalent as the Analyst one. Then, the&nbsp;<span style="line-height:1.6">Archimate goal will be synchonized to the Analyt one,&nbsp;</span><span style="line-height:1.6">calling getName() or setName() on the Archimate goal will call the same method of the Analyst one.</span></p>
 *
 *
 */
@objid ("8a99bc61-3b15-4de3-a356-6e934f63bf07")
public interface Goal extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("9b1d7788-eebc-480f-a66f-4048b73f95cc")
    public static final String MNAME = "Goal";

    /**
     * The metaclass qualified name.
     */
    @objid ("70628f81-6fce-460e-827a-b6a904d76582")
    public static final String MQNAME = "Archimate.Goal";

    /**
     * Getter for attribute 'Goal.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this goal as equivalent to an analyst Goal, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("839c1f4b-ae21-474b-9c9d-0d1f812a2051")
    String getEquivalentRef();

    /**
     * Setter for attribute 'Goal.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this goal as equivalent to an analyst Goal, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("1116be74-b9e2-42a5-807e-1a6832179ba6")
    void setEquivalentRef(String value);

}
