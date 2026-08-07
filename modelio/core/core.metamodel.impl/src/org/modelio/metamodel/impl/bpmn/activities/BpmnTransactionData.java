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
import org.modelio.metamodel.bpmn.activities.TransactionMethod;

@objid ("0085d32e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTransactionData extends BpmnSubProcessData {
    @objid ("f3bddfa9-4d74-44f8-8475-34d401b5768d")
    Object mMethod = TransactionMethod.COMPENSATETRANSACTION;

    @objid ("7d56a56b-42ff-4b68-a6d8-b521fd896758")
    public BpmnTransactionData(BpmnTransactionSmClass smClass) {
        super(smClass);
    }

}
