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

@objid ("1b581eb9-6167-46a3-85ca-efe78f7d73a8")
public class PhysicalFolderData extends FolderData {
    @objid ("519c915f-dc88-461e-b252-242ccab6f2d2")
    List<SmObjectImpl> mFolder = null;

    @objid ("3db53232-3c53-4cb1-8124-a099f30853bf")
    SmObjectImpl mOwnerFolder;

    @objid ("dc5354eb-8f81-493e-86ab-a5d666a4e001")
    public PhysicalFolderData(PhysicalFolderSmClass smClass) {
        super(smClass);
    }

}
