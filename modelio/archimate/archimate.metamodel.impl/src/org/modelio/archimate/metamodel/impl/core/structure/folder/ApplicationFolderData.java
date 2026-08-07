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

@objid ("5ca8a200-9602-474e-b1fd-a6e44018ca8a")
public class ApplicationFolderData extends FolderData {
    @objid ("10a27b21-56a0-444f-bf83-61f48b417bae")
    List<SmObjectImpl> mFolder = null;

    @objid ("2d2f313f-107f-4ae4-92fb-526f3d73d91b")
    SmObjectImpl mOwnerFolder;

    @objid ("01847365-1146-4051-a201-e484e464b34d")
    public ApplicationFolderData(ApplicationFolderSmClass smClass) {
        super(smClass);
    }

}
