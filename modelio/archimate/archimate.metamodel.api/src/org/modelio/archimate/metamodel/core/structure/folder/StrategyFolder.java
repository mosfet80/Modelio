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
 * StrategyFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("4b40ff53-c8b6-4184-a96b-f15fbe21140e")
public interface StrategyFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("dc548e8e-8180-496e-a170-4891d133c482")
    public static final String MNAME = "StrategyFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("769442df-fd1d-4044-936d-aba13225fecc")
    public static final String MQNAME = "Archimate.StrategyFolder";

    /**
     * Getter for relation 'StrategyFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("1f5bd761-8720-4614-9a28-155e48059f29")
    StrategyFolder getOwnerFolder();

    /**
     * Setter for relation 'StrategyFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("54fcefe3-196b-4e34-9fd0-8a4fc5f33e57")
    void setOwnerFolder(StrategyFolder value);

    /**
     * Getter for relation 'StrategyFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("296f403b-289b-4bf8-a993-e58352cb62fb")
    EList<StrategyFolder> getFolder();

    /**
     * Filtered Getter for relation 'StrategyFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("0f53734b-6559-4d37-a0b4-d5dd1be357f0")
    <T extends StrategyFolder> List<T> getFolder(java.lang.Class<T> filterClass);

}
