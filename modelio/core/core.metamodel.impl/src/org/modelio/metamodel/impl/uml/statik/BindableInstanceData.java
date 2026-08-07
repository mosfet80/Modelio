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

@objid ("00011508-c4bf-1fd8-97fe-001ec947cd2a")
public class BindableInstanceData extends InstanceData {
    @objid ("93e814c8-9464-4cd5-abd1-95b8b40d69f6")
    SmObjectImpl mCluster;

    @objid ("ce3b923e-5506-48c4-99fe-f6a95edacd44")
    SmObjectImpl mInternalOwner;

    @objid ("4a89db8c-5cd4-4b7b-8b26-26f1a87ac92f")
    List<SmObjectImpl> mRepresentation = null;

    @objid ("f70ca981-7a59-4b23-99e0-b9a8bc0feaf2")
    SmObjectImpl mRepresentedFeature;

    @objid ("50b6111b-25f7-4bff-a6a4-59d733a6722d")
    public BindableInstanceData(BindableInstanceSmClass smClass) {
        super(smClass);
    }

}
