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
package org.modelio.archimate.metamodel.relationships.other;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.RelationshipConnector;

/**
 * Junction vnull
 *
 *
 * <p>A junction is not an actual relationship in the same sense as the other relationships described in&nbsp;this chapter, but rather a relationship connector.</p><p>A junction is used to connect relationships of the same type.</p><p>A junction is used in a number of situations to connect relationships of the same type. A junction&nbsp;may have multiple incoming relationships and one outgoing relationship, one incoming&nbsp;relationship and multiple outgoing relationships, or multiple incoming and outgoing&nbsp;relationships (the latter is can be considered a shorthand of two subsequent junctions).</p><p>The relationships that can be used in combination with a junction are all the dynamic&nbsp;relationships, as well as assignment, realization, and association. A junction is used to explicitly&nbsp;express that:</p>
 *
 * <ul>
 * 	<li>several elements <em>together</em> participate in the relationship (<em>and</em> junction)</li>
 * 	<li>or that <em>one of&nbsp;the elements</em> participates in the relationship (<em>or</em> junction).</li>
 * </ul>
 *
 * <p>A junction should either have:</p>
 *
 * <ul>
 * 	<li>one&nbsp;incoming and more than one outgoing relationships,</li>
 * 	<li>or more than one incoming and one&nbsp;outgoing.</li>
 * </ul>
 *
 * <p>Junctions used on triggering relationships are similar to gateways in BPMN and forks and joins&nbsp;in UML activity diagrams. They can be used to model high-level process flow.</p><p>&nbsp;</p>
 *
 *
 */
@objid ("cf594814-0b19-4a6c-b453-e5b72cbaa6a7")
public interface Junction extends RelationshipConnector {
    /**
     * The metaclass simple name.
     */
    @objid ("6a8e112f-af34-4ab6-9671-301270238878")
    public static final String MNAME = "Junction";

    /**
     * The metaclass qualified name.
     */
    @objid ("56f29ea0-6cea-4a19-b22c-fe7f35b5b37c")
    public static final String MQNAME = "Archimate.Junction";

}
