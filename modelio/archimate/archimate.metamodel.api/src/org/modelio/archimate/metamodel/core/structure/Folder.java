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
package org.modelio.archimate.metamodel.core.structure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.Concept;

/**
 * Folder vnull
 *
 *
 * <p>A <em>Folder</em> is the organization unit for&nbsp;Archimate <em>concept</em>.</p><p>There is one sub metaclass for each Archimate layer, that contains only concepts related to that layer.</p><p>Folders may contain sub folders of the same type. Folder sub metaclasses have a relationship toward the same metaclass to express it.</p>
 *
 *
 */
@objid ("8a19fd6f-eff4-4384-b976-2df08937cf86")
public interface Folder extends ArchimateAbstractElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f5857862-d780-4cb2-9084-e86d18182774")
    public static final String MNAME = "Folder";

    /**
     * The metaclass qualified name.
     */
    @objid ("4d614cd2-12cf-461e-81ae-8c8ee91bc970")
    public static final String MQNAME = "Archimate.Folder";

    /**
     *
     * @return all sub folders.
     */
    @objid ("7b45ada5-fd9f-488a-b133-892fa8a2845a")
    List<? extends Folder> getFolder();

    /**
     * Get the parent folder.
     * <p>
     * Returns null for a root folder.
     *
     * @return the parent folder.
     * @see #getOwner() getOwner() for root folders
     */
    @objid ("671f60e5-2ad6-42e4-bf9a-7a9d2bd37ca2")
    Folder getOwnerFolder();

    /**
     * Getter for relation 'Folder->content'
     *
     * Metamodel description:
     * <i><p>The contained concepts.</p><p>The type of concepts this folder may contain depends on the exact folder type.</p>
     * </i>
     */
    @objid ("e1bbe24e-76ad-44bc-b078-590ffcaf0eb9")
    EList<Concept> getContent();

    /**
     * Filtered Getter for relation 'Folder->content'
     *
     * Metamodel description:
     * <i><p>The contained concepts.</p><p>The type of concepts this folder may contain depends on the exact folder type.</p>
     * </i>
     */
    @objid ("ac9c6885-fbf4-48cc-95c6-cd3b5602b052")
    <T extends Concept> List<T> getContent(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Folder->owner'
     *
     * Metamodel description:
     * <i><p>The owner model, for root folders.</p>
     * </i>
     */
    @objid ("3593b163-464b-4d2f-a5c1-b6b5b2bba589")
    Model getOwner();

    /**
     * Setter for relation 'Folder->owner'
     *
     * Metamodel description:
     * <i><p>The owner model, for root folders.</p>
     * </i>
     */
    @objid ("5920b704-b0cd-4191-844e-375bb673c387")
    void setOwner(Model value);

}
