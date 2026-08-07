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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("002d1d10-c4bf-1fd8-97fe-001ec947cd2a")
public class ClauseData extends UmlModelElementData {
    @objid ("2121a118-63f0-41a1-99f9-2a4788701b91")
    Object mTest = "";

    @objid ("f0d8dae4-6d26-4b5c-b64e-b52ceb6fb41c")
    List<SmObjectImpl> mBody = null;

    @objid ("6ae72d4d-e4f8-4526-af6f-15c59f6cec2a")
    SmObjectImpl mOwner;

    @objid ("b1ee9ab0-6558-40d2-baad-4ca298355013")
    public ClauseData(ClauseSmClass smClass) {
        super(smClass);
    }

}
