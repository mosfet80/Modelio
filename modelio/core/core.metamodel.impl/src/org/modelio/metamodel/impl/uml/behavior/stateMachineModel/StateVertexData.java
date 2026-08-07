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

@objid ("0054f060-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class StateVertexData extends UmlModelElementData {
    @objid ("1c9b1768-a417-4181-ba27-b39e1c63efe3")
    List<SmObjectImpl> mOutGoing = null;

    @objid ("030cb83f-e317-461c-881f-f17cb719f252")
    List<SmObjectImpl> mIncoming = null;

    @objid ("488ce2d7-6ae9-4e53-9c34-b997c898af79")
    SmObjectImpl mParent;

    @objid ("93f87a99-333c-4e39-bc08-d5e58c4e0c81")
    public StateVertexData(StateVertexSmClass smClass) {
        super(smClass);
    }

}
