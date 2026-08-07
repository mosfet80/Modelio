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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00490d86-c4bf-1fd8-97fe-001ec947cd2a")
public class LifelineData extends UmlModelElementData {
    @objid ("e95749ae-db60-4bff-86da-0f22dc59b424")
    Object mSelector = "";

    @objid ("ecf36b0a-f950-48e3-987d-8e3bd1729912")
    List<SmObjectImpl> mCoveredBy = null;

    @objid ("90fd9426-34f6-43b4-a8f6-0f53fafef7a7")
    SmObjectImpl mDecomposedAs;

    @objid ("d1a09665-2632-40a7-b0e3-be0bc87a646a")
    SmObjectImpl mOwner;

    @objid ("fbdeff84-c3d8-44b7-97a7-8a73a365e6a6")
    SmObjectImpl mRepresented;

    @objid ("89662679-33ed-4241-8fcf-437c67e78ec4")
    public LifelineData(LifelineSmClass smClass) {
        super(smClass);
    }

}
