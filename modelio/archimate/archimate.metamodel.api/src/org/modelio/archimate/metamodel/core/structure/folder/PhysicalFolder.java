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
 * PhysicalFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("9c8a6ad7-33d3-4a3f-b2c4-d85a54e3d06f")
public interface PhysicalFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("0b8e42d6-7c79-4f5b-98dd-5320b1fc8312")
    public static final String MNAME = "PhysicalFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("b2a8eeb5-9e2d-487c-8082-602e6a1d39d2")
    public static final String MQNAME = "Archimate.PhysicalFolder";

    /**
     * Getter for relation 'PhysicalFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("4f974d81-f961-4c5c-bb82-e06578f14f69")
    EList<PhysicalFolder> getFolder();

    /**
     * Filtered Getter for relation 'PhysicalFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("1e27d2b7-e963-4d42-91ce-e2423fc69c7e")
    <T extends PhysicalFolder> List<T> getFolder(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'PhysicalFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("42853f6b-52e3-46cf-bad1-9e42423354fc")
    PhysicalFolder getOwnerFolder();

    /**
     * Setter for relation 'PhysicalFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("2131ecf5-a75a-47a8-9d28-bc9ef0c01a48")
    void setOwnerFolder(PhysicalFolder value);

}
