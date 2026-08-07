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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00459ffc-c4bf-1fd8-97fe-001ec947cd2a")
public class GateData extends MessageEndData {
    @objid ("c02562c3-fb2d-48c4-b3e2-089aa9c699e4")
    SmObjectImpl mOwnerUse;

    @objid ("1d888676-7b36-4e5d-b491-a244f846f42f")
    List<SmObjectImpl> mActual = null;

    @objid ("65f55d07-9178-4d41-bcc6-72e5e799266d")
    SmObjectImpl mOwnerInteraction;

    @objid ("eac735e1-f3a9-433e-a044-5a2a41228704")
    SmObjectImpl mOwnerFragment;

    @objid ("5727c5a9-b1fa-4d82-9933-c6cfa9da1ad4")
    SmObjectImpl mFormal;

    @objid ("fd385839-aa15-4fd2-9ce1-60b37dc9e3be")
    public GateData(GateSmClass smClass) {
        super(smClass);
    }

}
