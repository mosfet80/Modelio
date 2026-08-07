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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("8721beb2-92eb-466d-9991-dc3c613f903d")
public class ModelData extends FolderData {
    @objid ("a4f7f065-c80f-4eb6-a304-21ad7f5dfcef")
    SmObjectImpl mProject;

    @objid ("c254a37f-ec6b-47e4-af64-095a72e983d0")
    List<SmObjectImpl> mReferencedBy = null;

    @objid ("cc5da26b-98e3-4824-9bd2-2fa358bd11fa")
    List<SmObjectImpl> mReferencedByView = null;

    @objid ("4d5fb871-bbfa-4b2c-b9e4-0b2143f90bc3")
    List<SmObjectImpl> mFolder = null;

    @objid ("c367310a-a3a6-4084-a494-0fb8436254f3")
    public ModelData(ModelSmClass smClass) {
        super(smClass);
    }

}
