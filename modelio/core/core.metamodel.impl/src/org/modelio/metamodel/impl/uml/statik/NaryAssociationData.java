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

@objid ("0021f11a-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryAssociationData extends UmlModelElementData {
    @objid ("c1d2c908-5fcd-4e7c-9e18-ac25a542f54e")
    List<SmObjectImpl> mOccurence = null;

    @objid ("11a55013-1696-418b-88da-068771a12813")
    List<SmObjectImpl> mNaryEnd = null;

    @objid ("2776fb81-907c-43c5-b9b6-5c80614f7dee")
    SmObjectImpl mLinkToClass;

    @objid ("84855bfe-4a84-446a-8cb0-0b00eb5e6af0")
    public NaryAssociationData(NaryAssociationSmClass smClass) {
        super(smClass);
    }

}
