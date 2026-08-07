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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionKind;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00322346-c4bf-1fd8-97fe-001ec947cd2a")
public class ExpansionRegionData extends StructuredActivityNodeData {
    @objid ("17f9fa51-f965-4960-8dd9-f9e89e0189d6")
    Object mMode = ExpansionKind.ITERATIVE;

    @objid ("ad08e9f4-3e2a-49cb-a705-098ca90e72a2")
    List<SmObjectImpl> mOutputElement = null;

    @objid ("09b63bcb-a96b-45f5-b9b5-9c3d271f8a4b")
    List<SmObjectImpl> mInputElement = null;

    @objid ("5e415de3-876e-4d01-b301-c0c4db784a3b")
    public ExpansionRegionData(ExpansionRegionSmClass smClass) {
        super(smClass);
    }

}
