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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("004f999e-c4bf-1fd8-97fe-001ec947cd2a")
public class EntryPointPseudoStateData extends AbstractPseudoStateData {
    @objid ("b9c63fd3-ecbd-45fa-9d12-b1ed358459f7")
    SmObjectImpl mEntryOf;

    @objid ("092e9999-1c51-4253-b2fc-bc0735b906f6")
    List<SmObjectImpl> mConnection = null;

    @objid ("5ca12b8a-558c-4938-b38d-5bcfc7bce0e6")
    SmObjectImpl mEntryOfMachine;

    @objid ("09a7a74a-2051-4a60-b1a3-50633724b722")
    public EntryPointPseudoStateData(EntryPointPseudoStateSmClass smClass) {
        super(smClass);
    }

}
