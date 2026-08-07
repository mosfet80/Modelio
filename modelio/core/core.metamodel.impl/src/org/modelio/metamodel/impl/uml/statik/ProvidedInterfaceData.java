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
package org.modelio.metamodel.impl.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("001a1ddc-c4bf-1fd8-97fe-001ec947cd2a")
public class ProvidedInterfaceData extends UmlModelElementData {
    @objid ("83280071-0cbc-4db1-b553-461d78c54081")
    List<SmObjectImpl> mProvidedElement = null;

    @objid ("b94468c4-59ac-4e45-a858-cdf0b79d77a0")
    SmObjectImpl mProviding;

    @objid ("8e2b34b2-492e-4248-a84d-224c8bf3efa6")
    List<SmObjectImpl> mConsumer = null;

    @objid ("1184629b-b624-486a-8538-8d2f3b1d16a5")
    List<SmObjectImpl> mNaryConsumer = null;

    @objid ("c990d7cc-7c8b-4524-a70f-74ff48c03ef4")
    public ProvidedInterfaceData(ProvidedInterfaceSmClass smClass) {
        super(smClass);
    }

}
