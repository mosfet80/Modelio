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
 * MotivationFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("4eaf872b-cd4d-4460-b911-ad8d81c87f62")
public interface MotivationFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("bede3555-e1cd-4c50-bcb2-efb523b9b6a0")
    public static final String MNAME = "MotivationFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("07dc6f17-ec38-4a79-a5d0-9601dee85706")
    public static final String MQNAME = "Archimate.MotivationFolder";

    /**
     * Getter for relation 'MotivationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("342fef63-8931-49d5-88db-b68b29a5d947")
    MotivationFolder getOwnerFolder();

    /**
     * Setter for relation 'MotivationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("1de33b90-b942-48f1-bb25-65370ed6c82a")
    void setOwnerFolder(MotivationFolder value);

    /**
     * Getter for relation 'MotivationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("d40e3891-a8e8-4bde-b95f-823bbe3f239f")
    EList<MotivationFolder> getFolder();

    /**
     * Filtered Getter for relation 'MotivationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("60a6d5e5-329b-4bf8-82fb-0a1e47d80039")
    <T extends MotivationFolder> List<T> getFolder(java.lang.Class<T> filterClass);

}
