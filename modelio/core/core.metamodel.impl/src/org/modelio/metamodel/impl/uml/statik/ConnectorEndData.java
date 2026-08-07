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
package org.modelio.metamodel.impl.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000701ac-c4bf-1fd8-97fe-001ec947cd2a")
public class ConnectorEndData extends LinkEndData {
    @objid ("5c3b8f4f-cda2-4264-bf10-07aa2dd85765")
    List<SmObjectImpl> mRepresentation = null;

    @objid ("4c0cc1fa-073e-45e2-92ed-d4245427fd6d")
    SmObjectImpl mRepresentedFeature;

    @objid ("fcacb704-9a1e-4189-ac6a-b55ae9e36287")
    public ConnectorEndData(ConnectorEndSmClass smClass) {
        super(smClass);
    }

}
