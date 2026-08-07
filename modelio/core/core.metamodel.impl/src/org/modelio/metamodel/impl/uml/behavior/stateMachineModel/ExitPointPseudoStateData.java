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

@objid ("00501928-c4bf-1fd8-97fe-001ec947cd2a")
public class ExitPointPseudoStateData extends AbstractPseudoStateData {
    @objid ("6d69886a-2c25-47ec-8812-1a373a4ce92e")
    SmObjectImpl mExitOf;

    @objid ("420b6ae0-496d-4108-b7ec-cc15490b033c")
    List<SmObjectImpl> mConnection = null;

    @objid ("d741861c-8ae8-4a31-b57a-a20990b32531")
    SmObjectImpl mExitOfMachine;

    @objid ("383f0878-fda6-4f97-8943-0ead8388efa7")
    public ExitPointPseudoStateData(ExitPointPseudoStateSmClass smClass) {
        super(smClass);
    }

}
