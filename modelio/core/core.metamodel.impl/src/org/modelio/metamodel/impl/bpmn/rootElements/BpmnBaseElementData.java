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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00783e94-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnBaseElementData extends ModelElementData {
    @objid ("57c15ef0-23f5-43c8-a5e3-b9716c29e479")
    List<SmObjectImpl> mOutgoingAssoc = null;

    @objid ("66730a68-5bae-49fa-a22f-b918f2791ee1")
    List<SmObjectImpl> mIncomingAssoc = null;

    @objid ("3399aecd-aec4-4542-8b4a-4c93f0a2ee78")
    List<SmObjectImpl> mIncomingFlow = null;

    @objid ("88d4ab97-55e6-4746-aaaf-a234077b76f4")
    List<SmObjectImpl> mOutgoingFlow = null;

    @objid ("23cb182f-6268-47c7-a22e-38028eb0bc1e")
    List<SmObjectImpl> mPartitionedLaneRefs = null;

    @objid ("6ba4eba0-053b-44eb-b273-57c6a371400e")
    public BpmnBaseElementData(BpmnBaseElementSmClass smClass) {
        super(smClass);
    }

}
