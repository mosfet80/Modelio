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
package org.modelio.archimate.metamodel.core.structure.folder;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.structure.Folder;

/**
 * TechnologyFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("df14789a-b3d1-49f1-bdcd-3517d4387713")
public interface TechnologyFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("d524bbd4-2524-4bf6-96b2-99e95a18e601")
    public static final String MNAME = "TechnologyFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("bf776f77-867c-4822-9a95-4ae6a2023178")
    public static final String MQNAME = "Archimate.TechnologyFolder";

    /**
     * Getter for relation 'TechnologyFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("41c4351a-13df-489d-b807-2147df8c85b5")
    TechnologyFolder getOwnerFolder();

    /**
     * Setter for relation 'TechnologyFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("051280c0-d6b3-4b78-a10e-c534e72511f9")
    void setOwnerFolder(TechnologyFolder value);

    /**
     * Getter for relation 'TechnologyFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("94d7981b-d8c3-4cdc-b655-09287d5b6b0e")
    EList<TechnologyFolder> getFolder();

    /**
     * Filtered Getter for relation 'TechnologyFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("9608d6a5-2d45-49f9-ba6d-51a3216629ca")
    <T extends TechnologyFolder> List<T> getFolder(java.lang.Class<T> filterClass);

}
