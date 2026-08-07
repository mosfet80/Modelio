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

@objid ("39d3fe2d-3b6e-4d28-9664-b1f694719946")
public class TechnologyFolderData extends FolderData {
    @objid ("3e552bc1-7ecd-4dc8-bd3a-0515ac2af82e")
    SmObjectImpl mOwnerFolder;

    @objid ("ce054f26-c8be-4dc1-8eb8-08fbebbb2e50")
    List<SmObjectImpl> mFolder = null;

    @objid ("bc7ff3ed-4a3e-45ac-93b4-a12e9376e50b")
    public TechnologyFolderData(TechnologyFolderSmClass smClass) {
        super(smClass);
    }

}
