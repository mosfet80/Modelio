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
import org.modelio.archimate.metamodel.core.ArchimateView;

/**
 * Model vnull
 *
 *
 * <p>A model is a collection of <em>concepts</em>. A concept is either an <em>element</em> or a <em>relationship</em>.</p><p>Concepts are not directly owned by the model, it is&nbsp;<span style="line-height:1.6">organized on</span><span style="line-height:1.6">&nbsp;one Folder for each Archimate layer that contain concepts related to that layer.</span></p>
 *
 *
 */
@objid ("fc92eb5a-aa93-4b46-a681-21520455948a")
public interface Model extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("3fb96496-ec47-4b6d-a18b-259c9828d486")
    public static final String MNAME = "Model";

    /**
     * The metaclass qualified name.
     */
    @objid ("9e3a05e6-912c-469c-80c5-a374ee4822f9")
    public static final String MQNAME = "Archimate.Model";

    /**
     * Getter for relation 'Model->project'
     *
     * Metamodel description:
     * <i>The Archimate project containing this model.</i>
     */
    @objid ("f82585dd-7837-416c-b147-5d485bf90be5")
    ArchimateProject getProject();

    /**
     * Setter for relation 'Model->project'
     *
     * Metamodel description:
     * <i>The Archimate project containing this model.</i>
     */
    @objid ("fa0f4ccb-50d6-43bb-8651-87e93f8d81c2")
    void setProject(ArchimateProject value);

    /**
     * Getter for relation 'Model->referencedBy'
     *
     * Metamodel description:
     * <i>The view points viewing this model.</i>
     */
    @objid ("22953f82-56af-4323-80b6-60e498ce671a")
    EList<ViewPoint> getReferencedBy();

    /**
     * Filtered Getter for relation 'Model->referencedBy'
     *
     * Metamodel description:
     * <i>The view points viewing this model.</i>
     */
    @objid ("969d7990-4200-4e32-aa61-9b79205c1226")
    <T extends ViewPoint> List<T> getReferencedBy(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Model->referencedByView'
     *
     * Metamodel description:
     * <i>The Archimate views of this model</i>
     */
    @objid ("2565e693-1617-40d4-b2e6-57dd0683558b")
    EList<ArchimateView> getReferencedByView();

    /**
     * Filtered Getter for relation 'Model->referencedByView'
     *
     * Metamodel description:
     * <i>The Archimate views of this model</i>
     */
    @objid ("8df0b864-71d6-4f8d-87fb-b5ba7a813910")
    <T extends ArchimateView> List<T> getReferencedByView(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Model->folder'
     *
     * Metamodel description:
     * <i>The contained Archimate folders. There should be one folder for each Archimate layer.</i>
     */
    @objid ("a9209042-ce89-48f8-afd5-84c01a5e66c4")
    EList<Folder> getFolder();

    /**
     * Filtered Getter for relation 'Model->folder'
     *
     * Metamodel description:
     * <i>The contained Archimate folders. There should be one folder for each Archimate layer.</i>
     */
    @objid ("7c57fcb1-418e-4ccd-8553-1d52b44cfe97")
    <T extends Folder> List<T> getFolder(java.lang.Class<T> filterClass);

}
