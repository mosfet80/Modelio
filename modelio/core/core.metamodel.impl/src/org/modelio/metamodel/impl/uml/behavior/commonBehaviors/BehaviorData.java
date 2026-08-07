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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0040ed22-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BehaviorData extends UmlModelElementData {
    @objid ("b9be0c49-fc91-44c6-8c55-a1d939594ef6")
    Object mIsReentrant = false;

    @objid ("26a6904f-2ac3-42e6-9f0e-40bdbbc064d9")
    SmObjectImpl mOwner;

    @objid ("da8e37de-18ee-4a4b-a0e9-7d202b255e56")
    List<SmObjectImpl> mParameter = null;

    @objid ("254e8e8f-23a3-470d-a528-58f5518d741b")
    SmObjectImpl mOwnerOperation;

    @objid ("e133c7b0-a8e3-475e-8ec2-84b290a48191")
    List<SmObjectImpl> mOwnedCollaboration = null;

    @objid ("a31098a7-0e35-4822-b96b-4e25d4e2a623")
    List<SmObjectImpl> mCaller = null;

    @objid ("f9b43f0d-61ba-4082-9ace-be23bedd5271")
    List<SmObjectImpl> mEComponent = null;

    @objid ("2a5482f8-0a77-45b6-b183-e9f6fe723748")
    List<SmObjectImpl> mEffectOf = null;

    @objid ("59d1be4f-e9ff-46e9-98d6-1209c8930f5a")
    public BehaviorData(BehaviorSmClass smClass) {
        super(smClass);
    }

}
