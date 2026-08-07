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

@objid ("11f4dd1f-f99e-4cd2-afe0-9bad4dff31e4")
public class ImplementationFolderData extends FolderData {
    @objid ("bc9c9e7c-eabd-48bf-8847-fb83b1f3c6be")
    List<SmObjectImpl> mFolder = null;

    @objid ("859ba744-682f-4d95-859c-440ae5822117")
    SmObjectImpl mOwnerFolder;

    @objid ("3542166f-eb98-49fe-983b-744dd0c77e0d")
    public ImplementationFolderData(ImplementationFolderSmClass smClass) {
        super(smClass);
    }

}
