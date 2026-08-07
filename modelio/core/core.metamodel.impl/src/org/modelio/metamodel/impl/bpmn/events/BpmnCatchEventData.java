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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("008909ea-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnCatchEventData extends BpmnEventData {
    @objid ("ee3d325b-2687-414e-9a14-4ae42c15a82c")
    Object mParallelMultiple = false;

    @objid ("cff3e5d8-7a68-4ca0-8a85-81d7f85104b2")
    List<SmObjectImpl> mDataOutputAssociation = null;

    @objid ("b37c91ea-8802-4977-8a0f-73b3a69a26ff")
    SmObjectImpl mDataOutput;

    @objid ("68dbead9-1686-4c65-b174-8059f4e79d0b")
    public BpmnCatchEventData(BpmnCatchEventSmClass smClass) {
        super(smClass);
    }

}
