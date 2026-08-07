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
import org.modelio.metamodel.impl.uml.statik.GeneralClassData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0042606c-c4bf-1fd8-97fe-001ec947cd2a")
public class SignalData extends GeneralClassData {
    @objid ("1b954941-40a3-4e1c-92df-3c698639f69b")
    Object mIsEvent = false;

    @objid ("18eca889-52fd-4e8a-905d-8dd9bdd9a32d")
    Object mIsException = false;

    @objid ("18b65c3c-efd2-4276-9c03-328188a4cd15")
    List<SmObjectImpl> mSender = null;

    @objid ("4bd2ad97-ff9b-4830-817e-bdc59bf9997d")
    List<SmObjectImpl> mUsage = null;

    @objid ("ed4a2e54-e5c9-44cb-a10b-333a393a1389")
    List<SmObjectImpl> mSends = null;

    @objid ("b798b8c4-edb9-4469-a015-10731c481958")
    SmObjectImpl mPBase;

    @objid ("da95f3c0-e49e-4b57-a164-af151007e548")
    SmObjectImpl mOBase;

    @objid ("168f12e7-d21c-4e82-a9dc-66f0d6d60ee7")
    List<SmObjectImpl> mCommunicationUsage = null;

    @objid ("585fb1f1-9619-4243-8878-0e6a6bff4dc1")
    List<SmObjectImpl> mDOccurence = null;

    @objid ("7e4b50ae-a192-48e3-bdd2-6f068e7b5157")
    List<SmObjectImpl> mEOccurence = null;

    @objid ("eb547144-d34a-41e4-a39c-8c3e2d455238")
    SmObjectImpl mBase;

    @objid ("d210444e-eb3c-4cb2-9e77-7462a2d73e5e")
    List<SmObjectImpl> mReceiver = null;

    @objid ("df32ec92-0be5-4365-840d-3496f38c4fbd")
    public SignalData(SignalSmClass smClass) {
        super(smClass);
    }

}
