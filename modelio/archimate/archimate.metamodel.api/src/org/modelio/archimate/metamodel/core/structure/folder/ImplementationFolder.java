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
 * ImplementationFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("6fc85fbb-00a1-4f10-a54d-588bd13a8aa2")
public interface ImplementationFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("707bf9b9-11c9-4bae-909f-fee37e1bf234")
    public static final String MNAME = "ImplementationFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("5a892b03-9ffc-4cb4-84fe-a064424f6abc")
    public static final String MQNAME = "Archimate.ImplementationFolder";

    /**
     * Getter for relation 'ImplementationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("8f8409f6-2c11-4cbb-91e5-980a4a991577")
    EList<ImplementationFolder> getFolder();

    /**
     * Filtered Getter for relation 'ImplementationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("c77b8b77-f6f8-44b3-a795-973be7cd404e")
    <T extends ImplementationFolder> List<T> getFolder(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ImplementationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("e6552c47-0970-4cb3-a233-65ad53c00d3c")
    ImplementationFolder getOwnerFolder();

    /**
     * Setter for relation 'ImplementationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("7798244d-9da7-4230-9f3a-442077d8ed73")
    void setOwnerFolder(ImplementationFolder value);

}
