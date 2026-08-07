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

@objid ("0047edde-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionOperandData extends InteractionFragmentData {
    @objid ("f26261cf-fdf5-415e-8574-fae53fcfb167")
    Object mGuard = "";

    @objid ("152721b5-4655-4aec-a3c4-729ccaee2f3b")
    Object mEndLineNumber = 0;

    @objid ("32a73dca-aecc-4b17-8421-31496d343501")
    List<SmObjectImpl> mFragment = null;

    @objid ("ccae1281-efcd-47f4-a8a3-79ce49d97362")
    SmObjectImpl mOwnerFragment;

    @objid ("7227f73a-a131-4342-a76d-a62d7a8bca45")
    public InteractionOperandData(InteractionOperandSmClass smClass) {
        super(smClass);
    }

}
