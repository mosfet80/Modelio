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
package org.modelio.archimate.metamodel.impl.core.structure.folder;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.core.structure.FolderData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("48b4ac31-57dd-48a7-a18d-33b0286988c1")
public class BusinessFolderData extends FolderData {
    @objid ("c940cab9-edde-4b51-86c0-38975ab327dd")
    SmObjectImpl mOwnerFolder;

    @objid ("23b11fc9-b433-478b-80b8-2ac5aa5709a3")
    List<SmObjectImpl> mFolder = null;

    @objid ("e5b08646-752c-4006-8cce-87228342192f")
    public BusinessFolderData(BusinessFolderSmClass smClass) {
        super(smClass);
    }

}
