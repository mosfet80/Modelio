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

@objid ("00384dac-c4bf-1fd8-97fe-001ec947cd2a")
public class MessageFlowData extends ActivityEdgeData {
    @objid ("fdc2eca6-d6e1-409e-ba04-81da15c54cd9")
    SmObjectImpl mTargetPartition;

    @objid ("90e16281-1e6e-405e-84a5-881961432d3c")
    SmObjectImpl mSourcePartition;

    @objid ("76ae35bf-9a6e-4e59-a202-220cd8ef66d0")
    public MessageFlowData(MessageFlowSmClass smClass) {
        super(smClass);
    }

}
