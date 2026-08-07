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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00561594-c4bf-1fd8-97fe-001ec947cd2a")
public class TransitionData extends UmlModelElementData {
    @objid ("ba9aea84-bbbf-4269-9833-a09945a15a7b")
    Object mEffect = "";

    @objid ("2286201f-3100-4583-88dd-273937fa0746")
    Object mReceivedEvents = "";

    @objid ("8eca4e82-cc63-4868-8400-f527d98a5749")
    Object mSentEvents = "";

    @objid ("0ea2d168-f52b-4414-9d92-17857abbb9e9")
    Object mGuard = "";

    @objid ("eacb7151-1220-4f7c-b6ee-538cc8262c73")
    Object mPostCondition = "";

    @objid ("b190e862-36e8-4730-a441-a9a9637c1e12")
    SmObjectImpl mProcessed;

    @objid ("4209cc3e-f8a9-41d1-af2f-d08a6cc3a0ec")
    SmObjectImpl mTrigger;

    @objid ("4ba43af5-6a8e-4fa8-8112-5189f6562345")
    SmObjectImpl mBehaviorEffect;

    @objid ("a95f0dad-7ebd-4ae1-9cc7-27691f2f8384")
    SmObjectImpl mTarget;

    @objid ("b1e9a4b7-dcbd-4af0-be2d-fc0fb1a37657")
    SmObjectImpl mSource;

    @objid ("d1d822a0-1961-4577-afa1-1eb2009b8c50")
    SmObjectImpl mEffects;

    @objid ("fe3cc66a-32be-43e6-8876-293859da254d")
    public TransitionData(TransitionSmClass smClass) {
        super(smClass);
    }

}
