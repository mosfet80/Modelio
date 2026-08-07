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
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperator;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0043a60c-c4bf-1fd8-97fe-001ec947cd2a")
public class CombinedFragmentData extends InteractionFragmentData {
    @objid ("10d7b6ad-4874-4b51-bc43-25c794300eb1")
    Object mOperator = InteractionOperator.SEQOP;

    @objid ("e684c83f-30ed-463c-8a9a-77c0bab3f288")
    List<SmObjectImpl> mOperand = null;

    @objid ("4a57359d-d8fc-4022-b16d-a4f8850320e0")
    List<SmObjectImpl> mFragmentGate = null;

    @objid ("c833b767-ff63-4df6-acc7-cd0526e52a45")
    public CombinedFragmentData(CombinedFragmentSmClass smClass) {
        super(smClass);
    }

}
