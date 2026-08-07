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
package org.modelio.metamodel.impl.bpmn.flows;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007c30f8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageData extends BpmnSharedElementData {
    @objid ("89d8d498-c72a-4491-a6e4-4e1bef0cc587")
    List<SmObjectImpl> mOutputMessage = null;

    @objid ("208e141c-6e4b-4c53-808f-1f63d91d8515")
    SmObjectImpl mItemRef;

    @objid ("e9731155-0739-4ce4-94f5-8c404993b796")
    List<SmObjectImpl> mEventDefinition = null;

    @objid ("af37ac69-d74e-4d1d-82f1-e39947e45aff")
    List<SmObjectImpl> mSender = null;

    @objid ("4b134267-08c9-47d3-876d-8028f4786758")
    List<SmObjectImpl> mInputMessage = null;

    @objid ("8dc98a3d-a364-4b6e-a878-b4ba9a266183")
    List<SmObjectImpl> mReceiver = null;

    @objid ("64260c9f-c4ff-4db2-bb40-f8b3221f1dca")
    List<SmObjectImpl> mMessageFlow = null;

    @objid ("ff87b351-06a5-4f23-90cf-8151078354cb")
    SmObjectImpl mCollaboration;

    @objid ("f09b6a8c-1e58-4096-a347-f74099e1bf80")
    public BpmnMessageData(BpmnMessageSmClass smClass) {
        super(smClass);
    }

}
