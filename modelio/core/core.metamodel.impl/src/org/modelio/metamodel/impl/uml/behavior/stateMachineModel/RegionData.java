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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("005749aa-c4bf-1fd8-97fe-001ec947cd2a")
public class RegionData extends UmlModelElementData {
    @objid ("5be6095b-e7f4-471c-8fc9-92604633cefc")
    SmObjectImpl mParent;

    @objid ("a9374c0c-07e7-40c6-a9e7-e3c0c4b8d6cb")
    SmObjectImpl mRepresented;

    @objid ("fd8e06cf-5f97-4226-807f-f8ad029b5fbc")
    List<SmObjectImpl> mSub = null;

    @objid ("1cad94fa-2e17-455b-9340-199b7b6b587e")
    public RegionData(RegionSmClass smClass) {
        super(smClass);
    }

}
