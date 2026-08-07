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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("003580cc-c4bf-1fd8-97fe-001ec947cd2a")
public class InputPinData extends PinData {
    @objid ("d464e5cc-7a35-4db5-8aba-eeff63b867f4")
    Object mIsSelf = false;

    @objid ("69f0ae58-59f8-48a1-89bc-146d3b6909c8")
    List<SmObjectImpl> mHandler = null;

    @objid ("d394f99a-a640-4947-b072-223f385a1720")
    SmObjectImpl mInputing;

    @objid ("297c40c2-1f4c-4604-846a-095e986a4f4f")
    public InputPinData(InputPinSmClass smClass) {
        super(smClass);
    }

}
