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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("004ab5e6-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class OccurrenceSpecificationData extends InteractionFragmentData {
    @objid ("2e173e6e-1895-4113-9657-5b5138bf3e95")
    List<SmObjectImpl> mToAfter = null;

    @objid ("71f786bf-6ffe-40e5-8ab3-798c07d1cb37")
    List<SmObjectImpl> mToBefore = null;

    @objid ("92aacd8e-a842-4d83-a9f1-ce20d719a08c")
    public OccurrenceSpecificationData(OccurrenceSpecificationSmClass smClass) {
        super(smClass);
    }

}
