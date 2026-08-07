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
package org.modelio.metamodel.impl.uml.informationFlow;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0064a956-c4bf-1fd8-97fe-001ec947cd2a")
public class DataFlowData extends UmlModelElementData {
    @objid ("576094c5-faa6-47ee-a0c6-fba2ba4d0a2d")
    SmObjectImpl mDestination;

    @objid ("a35c6c4a-1aeb-4c3a-a9f5-eca42d022973")
    SmObjectImpl mOrigin;

    @objid ("f66e57a9-b6d2-4261-94c9-e61ed935e511")
    SmObjectImpl mOwner;

    @objid ("02766e9b-4a0c-4314-b17d-00688ea24d50")
    SmObjectImpl mSModel;

    @objid ("e0a9fa27-83de-4d13-ac9d-b02fbda0fba5")
    public DataFlowData(DataFlowSmClass smClass) {
        super(smClass);
    }

}
