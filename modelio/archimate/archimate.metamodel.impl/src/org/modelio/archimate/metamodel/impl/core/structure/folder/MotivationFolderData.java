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

@objid ("e8a23804-e41d-4d5e-a01d-3d15d3dd78fd")
public class MotivationFolderData extends FolderData {
    @objid ("d0027a4d-8e23-4e78-b3fd-a66ad6e0e407")
    SmObjectImpl mOwnerFolder;

    @objid ("0bac7e9c-54cf-4b2a-85db-0bd9ab87fb09")
    List<SmObjectImpl> mFolder = null;

    @objid ("5a0d7736-4c27-4450-a51e-6a57e5b51d08")
    public MotivationFolderData(MotivationFolderSmClass smClass) {
        super(smClass);
    }

}
