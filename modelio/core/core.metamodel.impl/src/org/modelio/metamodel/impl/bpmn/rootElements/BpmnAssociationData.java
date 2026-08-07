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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociationDirection;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00779282-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnAssociationData extends BpmnArtifactData {
    @objid ("8247a4b2-0d5e-4818-97b6-9c06068dcb27")
    Object mAssociationDirection = BpmnAssociationDirection.NONEDIRECTION;

    @objid ("13195035-002b-40ef-b6cc-5b2af966e360")
    SmObjectImpl mTargetRef;

    @objid ("e15f0223-36f0-4049-9483-c9a669b13062")
    SmObjectImpl mSourceRef;

    @objid ("92f568e5-6cfe-4dff-ba41-ab21a1f5501e")
    public BpmnAssociationData(BpmnAssociationSmClass smClass) {
        super(smClass);
    }

}
