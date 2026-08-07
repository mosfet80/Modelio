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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00852208-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTaskData extends BpmnActivityData {
    @objid ("7c72517a-345d-4974-aa1b-9024384b1435")
    Object mIsGlobal = false;

    @objid ("29cfe90d-9a9d-403b-b28f-d133f343dc16")
    List<SmObjectImpl> mCaller = null;

    @objid ("2ae544d7-e69d-4cb3-af26-d706a4b98588")
    public BpmnTaskData(BpmnTaskSmClass smClass) {
        super(smClass);
    }

}
