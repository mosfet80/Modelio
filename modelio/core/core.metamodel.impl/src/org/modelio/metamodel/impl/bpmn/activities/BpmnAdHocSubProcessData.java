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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.AdHocOrdering;

@objid ("007e3c68-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnAdHocSubProcessData extends BpmnSubProcessData {
    @objid ("52701a4b-7b7a-46d0-85c1-5296937428f0")
    Object mOrdering = AdHocOrdering.PARALLELORDERING;

    @objid ("9228da11-34a2-48b8-8c07-31179b07e1ba")
    Object mCancelRemainingInstances = true;

    @objid ("7f1e1bef-34d3-4ed0-911a-a4ae5a76b072")
    Object mCompletionCondition = "";

    @objid ("07f9a61e-e8ea-419a-b3d4-21b4aadaa695")
    public BpmnAdHocSubProcessData(BpmnAdHocSubProcessSmClass smClass) {
        super(smClass);
    }

}
