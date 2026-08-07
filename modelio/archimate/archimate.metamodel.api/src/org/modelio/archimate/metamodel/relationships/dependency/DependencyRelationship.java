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
import org.modelio.archimate.metamodel.core.Relationship;

/**
 * DependencyRelationship vnull
 *
 *
 * <p>Dependency relationships describe how elements support or are used by other elements. Three&nbsp;types of dependency relationship are distinguished:</p>
 *
 * <ul>
 * 	<li>The <em>serving</em> relationship represents a <em>control</em> dependency, denoted by a solid line.</li>
 * 	<li>The <em>access</em> relationship represents a <em>data</em> dependency, denoted by a dashed line.</li>
 * 	<li>The <em>influence</em> relationship is the weakest type of dependency, used to model how&nbsp;motivation elements are influenced by other elements.</li>
 * </ul>
 *
 * <p>Note that, although the notation of these relationships resembles the notation of the dependency&nbsp;relationship in UML, these relationships have distinct meanings in ArchiMate notation and&nbsp;<strong>(usually) point in the opposite direction</strong>.</p><p>One advantage of this is that it yields models with&nbsp;directionality, where most <sup>2</sup> of the arrows that represent such supporting, <em>influencing</em>, <em>serving</em>, or&nbsp;<em>realizing</em> dependencies point &#39;upwards&#39; towards the client/user/business.</p><p>Another reason for this direction, in particular for&nbsp;the <em>serving</em> relationship, is that it abstracts from the &#39;caller&#39; or &#39;initiator&#39;, since a service may be&nbsp;delivered proactively or reactively.</p><p>The direction of delivery is always the same, but the starting&nbsp;point for the interaction can be on either end.</p><p>UML&#39;s <em>dependency</em> is often used to denote the&nbsp;latter, showing that the caller depends on some operation that is called.</p><p>However, for modeling&nbsp;this type of initiative, the ArchiMate language provides the <em>triggering</em> relationship , which can be interpreted as a dynamic (i.e., temporal) dependency. Similarly, the <em>flow</em>&nbsp;relationship is used to model how something (usually information) is transferred from one&nbsp;element to another, which is also a dynamic kind of dependency.</p><p>[2] :&nbsp;Note that the direction of <em>access</em> depends on the type of <em>access</em> (read versus write access) as described in its section.</p>
 *
 *
 */
@objid ("1b7230f6-08ec-4e7c-b945-a1c90659e42e")
public interface DependencyRelationship extends Relationship {
    /**
     * The metaclass simple name.
     */
    @objid ("b023aa31-d41b-489e-ad89-13a1cd6bc3a0")
    public static final String MNAME = "DependencyRelationship";

    /**
     * The metaclass qualified name.
     */
    @objid ("e14aa45e-ca38-4d92-8e1f-59f6f2657c98")
    public static final String MQNAME = "Archimate.DependencyRelationship";

}
