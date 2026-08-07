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
package org.modelio.archimate.metamodel.core.generic.composite;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Grouping vnull
 *
 *
 * <p>The grouping element is used to group an arbitrary group of concepts (elements and/or&nbsp;relationships), which can be of the same type or of different types. The aggregation relationship&nbsp;is used to link the grouping element to the grouped concepts.</p><p>Concepts may be aggregated by multiple (overlapping) groups.</p><p>All types of relationships (apart from aggregation or composition) may exist from or to a&nbsp;grouping:</p>
 *
 * <ul>
 * 	<li>Such a relationship <em>from</em> a grouping means that all the elements that are aggregated in&nbsp;the grouping <em>together</em> have that relationship with the target element (but only those elements for&nbsp;which this relationship is allowed). This is equivalent to an and-junction on that relationship, as&nbsp;explained in Section 5.4.3 and shown in Example 13.</li>
 * 	<li>Such a relationship <em>to</em> a group means that&nbsp;the source element has that relationship with every element in the group, provided this&nbsp;relationship is allowed.</li>
 * </ul>
 *
 * <p>One useful way of employing grouping is for modeling Architecture and Solution Building&nbsp;Blocks (ABBs and SBBs), as described in the TOGAF framework.</p><p>Another useful application of grouping is for modeling domains. For example, the TOGAF&nbsp;framework Glossary of Supplementary Definition (Section A.40) defines Information Domain&nbsp;as: <em>&quot;grouping of information (or data entities) by a set of criteria such as security classification,&nbsp;ownership, location, etc. In the context of security, Information Domains are defined as a set of&nbsp;users, their information objects, and a security policy&quot;</em>.</p>
 *
 *
 */
@objid ("21df4a7a-5942-4fcb-a3d5-31b06e8271b0")
public interface Grouping extends CompositeElement {
    /**
     * The metaclass simple name.
     */
    @objid ("99ad6218-0d69-4ec8-8e96-be72b9cce5b6")
    public static final String MNAME = "Grouping";

    /**
     * The metaclass qualified name.
     */
    @objid ("62f4070b-9080-4e6c-aa13-40d818db1edd")
    public static final String MQNAME = "Archimate.Grouping";

}
