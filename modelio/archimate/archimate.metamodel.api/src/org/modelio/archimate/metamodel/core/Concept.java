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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.structure.Folder;

/**
 * Concept vnull
 *
 *
 * <p>All Archimate metamodel&nbsp;elements represented in an Archimate view are <em>Concepts</em>.</p>
 *
 *
 */
@objid ("4df0291b-cd03-452c-8bd9-5ddf8dd61542")
public interface Concept extends ArchimateAbstractElement {
    /**
     * The metaclass simple name.
     */
    @objid ("8635076b-ad55-4573-9433-bc3fb46b0e77")
    public static final String MNAME = "Concept";

    /**
     * The metaclass qualified name.
     */
    @objid ("de1b2b8d-f7f4-43c9-b04b-9e559d66719b")
    public static final String MQNAME = "Archimate.Concept";

    /**
     * Getter for relation 'Concept->relatedFrom'
     *
     * Metamodel description:
     * <i>relations targeting this element</i>
     */
    @objid ("d9481784-c119-4a66-8992-f77a6e54a65a")
    EList<Relationship> getRelatedFrom();

    /**
     * Filtered Getter for relation 'Concept->relatedFrom'
     *
     * Metamodel description:
     * <i>relations targeting this element</i>
     */
    @objid ("b1c74ef4-565b-4ca4-9ff0-ad70bd3f2349")
    <T extends Relationship> List<T> getRelatedFrom(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Concept->relatedTo'
     *
     * Metamodel description:
     * <i>relations starting from this element</i>
     */
    @objid ("d77a5561-9b1a-4a3e-8ee3-84f4d27b92f0")
    EList<Relationship> getRelatedTo();

    /**
     * Filtered Getter for relation 'Concept->relatedTo'
     *
     * Metamodel description:
     * <i>relations starting from this element</i>
     */
    @objid ("6e310823-ebab-422b-b774-8a7a02faa650")
    <T extends Relationship> List<T> getRelatedTo(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Concept->ownerFolder'
     *
     * Metamodel description:
     * <i>The container storing this element</i>
     */
    @objid ("8840aa11-0183-48b4-b86b-2b98cc4a63da")
    Folder getOwnerFolder();

    /**
     * Setter for relation 'Concept->ownerFolder'
     *
     * Metamodel description:
     * <i>The container storing this element</i>
     */
    @objid ("3678360b-d4d7-40f7-b000-ac6ad6fa5cde")
    void setOwnerFolder(Folder value);

}
