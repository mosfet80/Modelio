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
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("5a3c95db-d730-4d47-a110-1b0672d36020")
public class FolderData extends ArchimateAbstractElementData {
    @objid ("be122003-5a51-40bf-af6d-f2637d255b7b")
    List<SmObjectImpl> mContent = null;

    @objid ("c2d1ecf7-5d29-40ae-9ebe-e758783c5013")
    SmObjectImpl mOwner;

    @objid ("2689d86b-1c0b-418d-87fe-ed7324d57f85")
    public FolderData(FolderSmClass smClass) {
        super(smClass);
    }

}
