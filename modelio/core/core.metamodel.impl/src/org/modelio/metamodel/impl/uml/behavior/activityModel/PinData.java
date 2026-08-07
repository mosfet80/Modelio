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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("003cf4e2-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class PinData extends ObjectNodeData {
    @objid ("04303d74-623e-4448-b454-1fbb414d6c2c")
    Object mIsControl = false;

    @objid ("27d3cee3-63b2-4aa9-a10f-9143e4429208")
    Object mIsExpansion = false;

    @objid ("0d28ca74-8fe5-4d28-be14-7cd06b27bc84")
    SmObjectImpl mMatched;

    @objid ("0aa38197-4a25-4593-881e-7e275485bf4d")
    public PinData(PinSmClass smClass) {
        super(smClass);
    }

}
