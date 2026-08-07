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
import org.modelio.metamodel.uml.infrastructure.AbstractProject;

/**
 * ArchimateProject vnull
 *
 *
 * <p><em>ArchimateProject</em> is the top element in the composition tree and serves as the entry point.&nbsp;There is at most one&nbsp;ArchimateProject in a Modelio model repository.&nbsp;</p><p>An&nbsp;<em>ArchimateProject</em>&nbsp;contains one or more&nbsp;<em>Models</em>&nbsp;and&nbsp;<em>ViewPoints</em>.</p>
 *
 *
 */
@objid ("33551883-4c23-4384-a77c-133dfaa65408")
public interface ArchimateProject extends AbstractProject {
    /**
     * The metaclass simple name.
     */
    @objid ("90463c80-1b32-462e-906a-a2384a6729e0")
    public static final String MNAME = "ArchimateProject";

    /**
     * The metaclass qualified name.
     */
    @objid ("630ed2ad-be65-4806-92cb-34f133f27042")
    public static final String MQNAME = "Archimate.ArchimateProject";

    /**
     * Getter for relation 'ArchimateProject->model'
     *
     * Metamodel description:
     * <i><p>The contained Archimate models.</p>
     * </i>
     */
    @objid ("92105bf7-30e2-4d1f-9a63-75d793a08b65")
    EList<Model> getModel();

    /**
     * Filtered Getter for relation 'ArchimateProject->model'
     *
     * Metamodel description:
     * <i><p>The contained Archimate models.</p>
     * </i>
     */
    @objid ("235dd7e2-2e52-4214-b6f2-2896b1f74bb9")
    <T extends Model> List<T> getModel(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ArchimateProject->viewPoints'
     *
     * Metamodel description:
     * <i><p>The contained view points.</p>
     * </i>
     */
    @objid ("ab66434a-5436-4c0b-b733-68655b08a711")
    EList<ViewPoint> getViewPoints();

    /**
     * Filtered Getter for relation 'ArchimateProject->viewPoints'
     *
     * Metamodel description:
     * <i><p>The contained view points.</p>
     * </i>
     */
    @objid ("c279da5c-352a-44f0-9f02-fd7518e02e47")
    <T extends ViewPoint> List<T> getViewPoints(java.lang.Class<T> filterClass);

}
