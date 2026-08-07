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
 * ApplicationFolder v1.0.00
 *
 *
 * null
 *
 */
@objid ("f3137d13-98e5-4d2c-a7fc-ce04f39a1d4f")
public interface ApplicationFolder extends Folder {
    /**
     * The metaclass simple name.
     */
    @objid ("b025498f-9d2e-4e0e-917c-d2201c768162")
    public static final String MNAME = "ApplicationFolder";

    /**
     * The metaclass qualified name.
     */
    @objid ("c96a8cf3-d3f0-4d57-a77a-39d29035dbfd")
    public static final String MQNAME = "Archimate.ApplicationFolder";

    /**
     * Getter for relation 'ApplicationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("36c906b0-bdd6-41b2-80ba-8937d675fa1b")
    EList<ApplicationFolder> getFolder();

    /**
     * Filtered Getter for relation 'ApplicationFolder->folder'
     *
     * Metamodel description:
     * <i><p>Contained sub folders.</p>
     * </i>
     */
    @objid ("0a5d9442-e381-47a6-bab8-ccd7f8a1e6cc")
    <T extends ApplicationFolder> List<T> getFolder(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ApplicationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("591097f4-06b2-4f63-9381-f04f6609fa47")
    ApplicationFolder getOwnerFolder();

    /**
     * Setter for relation 'ApplicationFolder->ownerFolder'
     *
     * Metamodel description:
     * <i><p>The parent folder owning this folder, if it is a sub folder.</p>
     * </i>
     */
    @objid ("70c7c3e3-89c8-4d3b-97b7-2f3ea5e48b37")
    void setOwnerFolder(ApplicationFolder value);

}
