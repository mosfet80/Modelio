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

@objid ("003e80d2-c4bf-1fd8-97fe-001ec947cd2a")
public class StructuredActivityNodeData extends ActivityActionData {
    @objid ("5e598c4c-fb84-412e-a42f-293ef12e83ab")
    Object mMustIsolate = false;

    @objid ("37ba8ac7-a6c6-489b-b24b-3e61a2ac2980")
    List<SmObjectImpl> mBody = null;

    @objid ("24b07dfc-86ac-4a7d-a409-6ff2f1197299")
    public StructuredActivityNodeData(StructuredActivityNodeSmClass smClass) {
        super(smClass);
    }

}
