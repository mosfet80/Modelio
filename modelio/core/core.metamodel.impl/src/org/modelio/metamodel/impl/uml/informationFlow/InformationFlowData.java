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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0063bfb4-c4bf-1fd8-97fe-001ec947cd2a")
public class InformationFlowData extends UmlModelElementData {
    @objid ("10def7c4-e6dc-414f-aafe-ce2ad8c2b036")
    SmObjectImpl mOwner;

    @objid ("71f8779d-3941-44f4-b6d5-5d7ba74b435d")
    List<SmObjectImpl> mInformationSource = null;

    @objid ("6b9f3c16-5a0a-4af1-9794-91a5ef004665")
    List<SmObjectImpl> mInformationTarget = null;

    @objid ("6762b221-810e-42c5-8b74-3479a30a980b")
    List<SmObjectImpl> mRealizingActivityEdge = null;

    @objid ("cca812b0-b7be-42a3-a5cf-e01cdca40b18")
    List<SmObjectImpl> mRealizingCommunicationMessage = null;

    @objid ("dbc3ee82-8c01-4292-8748-d63d8e8891f8")
    List<SmObjectImpl> mRealizingFeature = null;

    @objid ("704e71fd-3e8e-4505-aa6e-23c0ef14f2e1")
    List<SmObjectImpl> mRealizingLink = null;

    @objid ("4fefde09-0428-41d3-ab51-f2f96d1607b8")
    List<SmObjectImpl> mRealizingMessage = null;

    @objid ("1cdc1bb2-c7ec-4c46-98a8-05e0d7d216eb")
    List<SmObjectImpl> mRealizingNaryLink = null;

    @objid ("3eaf40f2-70d0-499a-be72-4d4a2ae4fd47")
    List<SmObjectImpl> mConveyed = null;

    @objid ("3b65f0d0-f080-4eae-84ea-5467248a9853")
    SmObjectImpl mChannel;

    @objid ("f336ae80-2cc8-43ec-b8f3-7b2b323da101")
    public InformationFlowData(InformationFlowSmClass smClass) {
        super(smClass);
    }

}
