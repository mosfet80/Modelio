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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000e976e-c4bf-1fd8-97fe-001ec947cd2a")
public class InterfaceData extends GeneralClassData {
    @objid ("dd5c85af-c531-4752-8124-30fa64aeeedb")
    List<SmObjectImpl> mRequiring = null;

    @objid ("c52d37a2-3c77-40bb-a1bf-b82d9436aa73")
    List<SmObjectImpl> mImplementedLink = null;

    @objid ("7d4fad59-83e1-4d1d-9f78-33b95536ffcb")
    List<SmObjectImpl> mProviding = null;

    @objid ("a1498057-7d28-40ff-82f9-b0f1f52c259e")
    public InterfaceData(InterfaceSmClass smClass) {
        super(smClass);
    }

}
