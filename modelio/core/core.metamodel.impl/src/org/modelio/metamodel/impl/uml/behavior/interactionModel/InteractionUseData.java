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

@objid ("0048846a-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionUseData extends InteractionFragmentData {
    @objid ("a286098f-bf0b-4bd6-a955-22b1585c9c77")
    Object mEndLineNumber = 0;

    @objid ("99dd3622-6a9b-4651-be73-a9406bc83cba")
    List<SmObjectImpl> mActualGate = null;

    @objid ("3eeab86a-af36-4761-9b43-5eb87e7a15e4")
    SmObjectImpl mRefersTo;

    @objid ("a3558502-96f9-4342-9ba4-3a34e19807d3")
    public InteractionUseData(InteractionUseSmClass smClass) {
        super(smClass);
    }

}
