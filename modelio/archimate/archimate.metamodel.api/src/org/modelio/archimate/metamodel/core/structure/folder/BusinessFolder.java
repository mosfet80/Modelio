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
 * BusinessFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("49a91d35-903e-4075-b446-defe4760622a")
public interface BusinessFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("f47708f7-ec72-43cd-b273-644f2fa89caa")
    public static final String MNAME = "BusinessFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("c74404da-610b-4b93-82fb-ed8d14b6c049")
    public static final String MQNAME = "Archimate.BusinessFolder";

    /**
     * Getter for relation 'BusinessFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("52464094-dd2c-4936-a835-3556257b3b34")
    BusinessFolder getOwnerFolder();

    /**
     * Setter for relation 'BusinessFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("5c6c8525-2d9a-4d0f-befb-c5510ffd690b")
    void setOwnerFolder(BusinessFolder value);

    /**
     * Getter for relation 'BusinessFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("36215367-b1ff-4e78-a47a-917bb6856b9f")
    EList<BusinessFolder> getFolder();

    /**
     * Filtered Getter for relation 'BusinessFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("2388e54d-0179-4f98-9e51-61162dfbb490")
    <T extends BusinessFolder> List<T> getFolder(java.lang.Class<T> filterClass);

}
