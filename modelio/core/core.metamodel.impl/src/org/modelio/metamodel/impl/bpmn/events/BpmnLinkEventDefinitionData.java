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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("009084b8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLinkEventDefinitionData extends BpmnEventDefinitionData {
    @objid ("cd8c6f17-2eb2-4583-ac0b-eabd4c704606")
    List<SmObjectImpl> mSource = null;

    @objid ("f98a8611-6985-4b54-a54c-05a4305f34cd")
    SmObjectImpl mTarget;

    @objid ("dfbc9af4-b144-40cf-8e14-7c5de22873c3")
    public BpmnLinkEventDefinitionData(BpmnLinkEventDefinitionSmClass smClass) {
        super(smClass);
    }

}
