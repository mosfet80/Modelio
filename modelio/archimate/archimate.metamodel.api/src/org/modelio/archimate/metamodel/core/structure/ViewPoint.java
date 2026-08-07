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

/**
 * ViewPoint vnull
 *
 *
 * <p>Viewpoints are a means to focus on particular aspects and layers of the architecture.</p><p>These&nbsp;aspects and layers are determined by the concerns of a stakeholder with whom communication&nbsp;takes place. What should and should not be visible from a specific viewpoint is therefore entirely&nbsp;dependent on the argumentation with respect to a stakeholder&#39;s concerns.</p><p>The contained&nbsp;views are&nbsp;governed by its viewpoint: the view point establish which elements may be displayed in a view.</p><p>A view point is related by the <em>model</em> it filters.</p><p>A view point may contain child&nbsp;view points.</p><p>A view point contains <em>archimate views</em> and <em>ViewPointDiagrams</em>.</p><p>A view point is owned by the archimate project or a parent view point.</p>
 *
 *
 */
@objid ("bab240d2-9d7a-4d83-984f-2613c8a8ef24")
public interface ViewPoint extends ArchimateAbstractElement {
    /**
     * The metaclass simple name.
     */
    @objid ("e25105ed-a25f-439f-87d1-f7fa58a3c87d")
    public static final String MNAME = "ViewPoint";

    /**
     * The metaclass qualified name.
     */
    @objid ("f0a0f76e-41fd-47ca-8eb6-93c84044c665")
    public static final String MQNAME = "Archimate.ViewPoint";

    /**
     * Getter for relation 'ViewPoint->child'
     *
     * Metamodel description:
     * <i><p>Child&nbsp;view points.</p>
     * </i>
     */
    @objid ("0be4fc40-867a-41c5-a3c6-cacf764450f7")
    EList<ViewPoint> getChild();

    /**
     * Filtered Getter for relation 'ViewPoint->child'
     *
     * Metamodel description:
     * <i><p>Child&nbsp;view points.</p>
     * </i>
     */
    @objid ("557c97a6-98e2-473d-b132-91dbc2d53521")
    <T extends ViewPoint> List<T> getChild(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ViewPoint->project'
     *
     * Metamodel description:
     * <i><p>The project owning this view point, for root view points.</p>
     * </i>
     */
    @objid ("7ca6ae6a-ae7b-4764-aac8-c8dffce81d1d")
    ArchimateProject getProject();

    /**
     * Setter for relation 'ViewPoint->project'
     *
     * Metamodel description:
     * <i><p>The project owning this view point, for root view points.</p>
     * </i>
     */
    @objid ("603ba87a-d8ca-4121-b12d-208cba2b93ce")
    void setProject(ArchimateProject value);

    /**
     * Getter for relation 'ViewPoint->parent'
     *
     * Metamodel description:
     * <i><p>The owner view point for sub view points.</p>
     * </i>
     */
    @objid ("c414290c-5490-49a1-980b-089e6d3adafa")
    ViewPoint getParent();

    /**
     * Setter for relation 'ViewPoint->parent'
     *
     * Metamodel description:
     * <i><p>The owner view point for sub view points.</p>
     * </i>
     */
    @objid ("832c4cdb-8cf1-470b-a254-834fc88e3d13")
    void setParent(ViewPoint value);

    /**
     * Getter for relation 'ViewPoint->context'
     *
     * Metamodel description:
     * <i><p>The model this view point focuses.</p>
     * </i>
     */
    @objid ("b3bafb3e-d6b2-4c88-be80-d799cedc1648")
    Model getContext();

    /**
     * Setter for relation 'ViewPoint->context'
     *
     * Metamodel description:
     * <i><p>The model this view point focuses.</p>
     * </i>
     */
    @objid ("61d4eb3c-2edb-4f78-aaad-5ef5a6f7d5ee")
    void setContext(Model value);

}
