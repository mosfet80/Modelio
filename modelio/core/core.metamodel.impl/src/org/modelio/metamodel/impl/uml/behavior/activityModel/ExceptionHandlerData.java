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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0030e0d0-c4bf-1fd8-97fe-001ec947cd2a")
public class ExceptionHandlerData extends UmlModelElementData {
    @objid ("694ea563-b2e8-49d1-a74c-0f6aa591051c")
    Object mGuard = "";

    @objid ("06931ed4-b83c-4640-a389-435c5cd4dda9")
    Object mWeight = "1";

    @objid ("64ff4deb-b335-411e-9b43-feb8cc86922b")
    SmObjectImpl mProtectedNode;

    @objid ("4b61fd1d-132b-4205-aff0-633f302e7db7")
    SmObjectImpl mExceptionInput;

    @objid ("a979901d-6dba-43c4-bf4b-2674d4ec65a6")
    List<SmObjectImpl> mExceptionType = null;

    @objid ("cfe9a5cc-b893-4183-8592-c3eb6c7c0fc3")
    public ExceptionHandlerData(ExceptionHandlerSmClass smClass) {
        super(smClass);
    }

}
