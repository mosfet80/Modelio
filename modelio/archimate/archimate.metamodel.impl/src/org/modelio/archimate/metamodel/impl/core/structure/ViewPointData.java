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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("5fb2a23f-cc74-47a1-8dad-3e4eb30a812d")
public class ViewPointData extends ArchimateAbstractElementData {
    @objid ("297dd580-7a40-4234-a2dd-ac8e7832242b")
    List<SmObjectImpl> mChild = null;

    @objid ("195bfcbb-1c1d-4644-90bf-cc8bd47a7349")
    SmObjectImpl mProject;

    @objid ("fa7c2a9d-8cea-4d1e-af26-a42b75d87bdc")
    SmObjectImpl mParent;

    @objid ("867821b1-7326-4249-bb9d-45aa36c49a2b")
    SmObjectImpl mContext;

    @objid ("ce0dffd3-4d25-4033-92ef-1615f32927ff")
    public ViewPointData(ViewPointSmClass smClass) {
        super(smClass);
    }

}
