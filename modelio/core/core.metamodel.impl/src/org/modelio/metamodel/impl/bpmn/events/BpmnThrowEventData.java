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

@objid ("009614d2-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnThrowEventData extends BpmnEventData {
    @objid ("3bd6c066-4db3-4b76-9ded-cd4d28f32ecd")
    List<SmObjectImpl> mDataInputAssociation = null;

    @objid ("509e3084-59f7-403e-ac18-ce6d0004f7e8")
    SmObjectImpl mDataInput;

    @objid ("1ef64b4a-419a-474b-b66b-2a284d7830e7")
    public BpmnThrowEventData(BpmnThrowEventSmClass smClass) {
        super(smClass);
    }

}
