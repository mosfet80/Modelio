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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00290914-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityNodeData extends UmlModelElementData {
    @objid ("1ef523aa-9717-4582-8147-dd0f3d9268e0")
    SmObjectImpl mOwner;

    @objid ("40ffe100-8bfd-4067-ba66-287783e4e308")
    SmObjectImpl mOwnerPartition;

    @objid ("3269b5f0-9a2f-4d94-bc23-98090245678d")
    List<SmObjectImpl> mIncoming = null;

    @objid ("4b2ff304-1d58-4dca-9b0a-57f47ca3c424")
    SmObjectImpl mOwnerClause;

    @objid ("b2c2536b-5647-4194-900d-81b017d37c60")
    SmObjectImpl mOwnerNode;

    @objid ("f34bce55-10d0-4fe6-bb61-15590ad334f3")
    List<SmObjectImpl> mOutgoing = null;

    @objid ("dfd3da4a-1aad-40c4-8882-6047cb229796")
    public ActivityNodeData(ActivityNodeSmClass smClass) {
        super(smClass);
    }

}
