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
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00595600-c4bf-1fd8-97fe-001ec947cd2a")
public class UseCaseDependencyData extends UmlModelElementData {
    @objid ("eddd77fb-5940-4880-89aa-b33856a0faa4")
    SmObjectImpl mOrigin;

    @objid ("14c0be41-dcc1-419b-9515-5f3b5c579380")
    List<SmObjectImpl> mExtensionLocation = null;

    @objid ("9f6e7ec4-4759-4cd6-9d0b-1c9468c1caf5")
    SmObjectImpl mTarget;

    @objid ("07b4b372-aa19-4816-8a23-e65c541e3f76")
    public UseCaseDependencyData(UseCaseDependencySmClass smClass) {
        super(smClass);
    }

}
