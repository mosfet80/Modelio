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
package org.modelio.archimate.metamodel.core;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Relationship vnull
 *
 *
 * <p>In addition to the generic elements, the ArchiMate language defines a core&nbsp;set of generic relationships, each of which can connect a predefined set of source and target&nbsp;concepts (in most cases elements, but in a few cases also other relationships).</p><p>Many of these&nbsp;relationships are &#8216;overloaded&#8217;; i.e., their exact meaning differs depending on the source and&nbsp;destination concepts that they connect.</p><p>The relationships are classified as follows :</p>
 *
 * <ul>
 * 	<li><em>Structural</em> relationships, which model the static construction or composition of concepts&nbsp;of the same or different types</li>
 * 	<li><em>Dependency</em> relationships, which model how elements are used to support other elements</li>
 * 	<li><em>Dynamic</em> relationships, which are used to model behavioral dependencies between&nbsp;elements</li>
 * 	<li><em>Other</em> relationships, which do not fall into one of the above categories</li>
 * </ul>
 *
 *
 */
@objid ("fc52f7ac-4426-4b16-91e0-878e7b5cc34c")
public interface Relationship extends Concept {
    /**
     * The metaclass simple name.
     */
    @objid ("858f1502-c43e-4ab9-ab98-a0ec28ed6f17")
    public static final String MNAME = "Relationship";

    /**
     * The metaclass qualified name.
     */
    @objid ("4fb4cbd3-91dd-4eab-b14a-ba9f3ef5e039")
    public static final String MQNAME = "Archimate.Relationship";

    /**
     * Getter for relation 'Relationship->to'
     *
     * Metamodel description:
     * <i>relationship destination</i>
     */
    @objid ("2aaef75a-f880-4691-a684-e5cef8cc3790")
    Concept getTo();

    /**
     * Setter for relation 'Relationship->to'
     *
     * Metamodel description:
     * <i>relationship destination</i>
     */
    @objid ("be7859e5-9e2a-4cba-838e-b489e8b3b7f3")
    void setTo(Concept value);

    /**
     * Getter for relation 'Relationship->from'
     *
     * Metamodel description:
     * <i>relationship source</i>
     */
    @objid ("145d088c-1575-481f-bbd7-4cb9536d968c")
    Concept getFrom();

    /**
     * Setter for relation 'Relationship->from'
     *
     * Metamodel description:
     * <i>relationship source</i>
     */
    @objid ("001537bd-3763-4167-8063-f817b7e54ae9")
    void setFrom(Concept value);

}
