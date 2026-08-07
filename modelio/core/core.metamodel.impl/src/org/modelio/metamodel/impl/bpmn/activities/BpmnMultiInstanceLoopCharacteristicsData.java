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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.MultiInstanceBehavior;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00814890-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMultiInstanceLoopCharacteristicsData extends BpmnLoopCharacteristicsData {
    @objid ("b926bd99-c3c7-4c0b-99ff-632f22bfac9b")
    Object mIsSequencial = false;

    @objid ("c97c3355-59ef-4507-9333-65d5eb952b31")
    Object mBehavior = MultiInstanceBehavior.ALLBEHAVIOR;

    @objid ("f55ce37c-3229-4dc0-8eb5-5fd89359bcd9")
    Object mLoopCardinality = "";

    @objid ("c604a3ee-a6ea-468d-8482-21e80eb1ad32")
    Object mCompletionCondition = "";

    @objid ("8de3963e-fd5a-498a-b891-014e8638666c")
    SmObjectImpl mLoopDataInput;

    @objid ("985dab6c-ecdd-4eb6-8293-013fa95aaf3a")
    SmObjectImpl mLoopDataOutputRef;

    @objid ("fd23a50b-25af-4059-ab75-a3ce8384a25b")
    SmObjectImpl mCompletionEventRef;

    @objid ("17afb520-3397-443a-b121-ef6a79a05650")
    List<SmObjectImpl> mComplexBehaviorDefinition = null;

    @objid ("f37c5e1a-98bb-497a-a1ca-765eaa9cc6d4")
    public BpmnMultiInstanceLoopCharacteristicsData(BpmnMultiInstanceLoopCharacteristicsSmClass smClass) {
        super(smClass);
    }

}
