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
package org.modelio.archimate.metamodel.relationships.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Influence v1.0.3
 *
 *
 * <p>The influence relationship is used to describe that some architectural element influences&nbsp;achievement or implementation of a motivation element, such as a goal or a principle.</p><p>In general,&nbsp;a motivation element is realized to a certain degree. For example, consistently satisfying the&nbsp;principle &#39;serve customers wherever they are&#39; will help making the goal &#39;increase market share&#39;&nbsp;come true. In other words, the principle contributes to the goal. In turn, to implement the&nbsp;principle &#39;serve customers wherever they are&#39;, it may be useful to impose a requirement of &#39;24x7&nbsp;web availability&#39; on some customer-facing application component. This can be modeled as a&nbsp;requirement that has a positive influence on that principle, and as an application component that&nbsp;in turn influences the requirement. Consistently modeling these dependencies with an influence&nbsp;relationship yields a traceable motivational path that explains why (in this example) a certain&nbsp;application component contributes to the corporate goal to &#39;increase market share&#39;. This kind of&nbsp;traceability supports measuring the results of Enterprise Architecture, and provides valuable&nbsp;information to, for example, change impact assessments.</p><p>Additional to this &#39;vertical&#39; use of contribution, from core elements upwards to requirements and&nbsp;goals, the relationship can also be used to model &#39;horizontal&#39; contributions between motivation&nbsp;elements. The influence relationship in that case describes that some motivation element may&nbsp;influence (the achievement or implementation of) another motivation element. In general, a&nbsp;motivation element is achieved to a certain degree. An influence by some other element may&nbsp;affect this degree positively or negatively, depending on the degree in which this other element&nbsp;is satisfied itself. For example, the degree in which the goal to increase customer satisfaction is&nbsp;realized may be represented by the percentage of satisfied customers that participate in a market&nbsp;interview. This percentage may be influenced positively by, for example, the goal to improve the&nbsp;reputation of the company; i.e., a higher degree of improvement results in a higher increase in&nbsp;customer satisfaction. On the other hand, the goal to lay off employees may influence the&nbsp;company reputation negatively; i.e., more lay-offs could result in a lower increase (or even&nbsp;decrease) in the company reputation. And thus (indirectly), the goal to increase customer&nbsp;satisfaction may also be influenced negatively.</p><p>An important difference between the <em>realization</em> and <em>influence</em> relationships is that, whereas the&nbsp;<em>realization</em> relationship implies full realization of the relationship&#39;s target, the <em>influence</em>&nbsp;relationship does not have this implication. In other words, while a positive influence (on a goal,&nbsp;principle, requirement, etc.) is useful - and perhaps even necessary - it may very well not be&nbsp;sufficient for its achievement or implementation. Moreover, the influence relationship can be&nbsp;used to model either:</p>
 *
 * <ul>
 * 	<li>The fact that an element positively contributes to the achievement or implementation of&nbsp;some motivation element, or</li>
 * 	<li>The fact that an element negatively influences - i.e., prevents or counteracts - such&nbsp;achievement</li>
 * </ul>
 *
 * <p>Attributes can be used to indicate the sign and/or strength of the influence. The choice of&nbsp;possible attribute values is defined in the <em>InfluenceStength</em> enumeration. By default, the&nbsp;influence relationship models an undefined contribution with unquantified strength.</p>
 *
 *
 */
@objid ("5b72c48e-a3e8-41b1-8afb-fa9d54f1ba21")
public interface Influence extends DependencyRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("abc8a438-1255-4395-b760-58516d39d02d")
    public static final String MNAME = "Influence";

    /**
     * The metaclass qualified name.
     */
    @objid ("3995ff31-8000-4520-a721-698b6fd097d8")
    public static final String MQNAME = "Archimate.Influence";

    /**
     * Getter for attribute 'Influence.strength'
     *
     * Metamodel description:
     * <i><p>Indicates the sign and&nbsp;strength of the influence.</p><p>A choice of possible attribute values is defined in the InfluenceStrength enumeration. By default, the influence relationship models a contribution with unspecified sign and strength.</p>
     * </i>
     */
    @objid ("d4053c8b-81c3-45fa-a6e0-fca19867c901")
    String getStrength();

    /**
     * Setter for attribute 'Influence.strength'
     *
     * Metamodel description:
     * <i><p>Indicates the sign and&nbsp;strength of the influence.</p><p>A choice of possible attribute values is defined in the InfluenceStrength enumeration. By default, the influence relationship models a contribution with unspecified sign and strength.</p>
     * </i>
     */
    @objid ("7ec53cad-6dec-4981-8673-e74b275c7c61")
    void setStrength(String value);

}
