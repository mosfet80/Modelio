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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000f6478-c4bf-1fd8-97fe-001ec947cd2a")
public class InterfaceRealizationData extends UmlModelElementData {
    @objid ("7ae83440-0058-465d-af57-66425236a972")
    SmObjectImpl mImplemented;

    @objid ("355c6d7e-8fd7-4105-9770-c0be484260d5")
    SmObjectImpl mImplementer;

    @objid ("45cb8c69-9b5d-4c18-bee5-82da2f99fb80")
    public InterfaceRealizationData(InterfaceRealizationSmClass smClass) {
        super(smClass);
    }

}
