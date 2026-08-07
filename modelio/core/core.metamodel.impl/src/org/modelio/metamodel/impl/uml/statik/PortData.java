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
import org.modelio.metamodel.uml.statik.PortOrientation;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00193926-c4bf-1fd8-97fe-001ec947cd2a")
public class PortData extends BindableInstanceData {
    @objid ("3c87eefe-9bb0-4e08-bf9c-c42e20b8a51d")
    Object mIsBehavior = false;

    @objid ("a8173e1d-6e7f-4f2b-b397-0a5a416e6b15")
    Object mIsService = false;

    @objid ("5760003e-99b4-4307-9d30-a16af1854505")
    Object mIsConjugated = false;

    @objid ("a7169e88-e4e7-4965-a31b-bc0bf303fd08")
    Object mDirection = PortOrientation.NONE;

    @objid ("15869d4b-94ac-40ff-ac0f-771ce3c04501")
    List<SmObjectImpl> mProvided = null;

    @objid ("998d5ff7-f03d-4310-87bb-3e7b0d2a068a")
    List<SmObjectImpl> mRequired = null;

    @objid ("b3f202dd-66c6-45f7-96d7-f4483ff39f59")
    public PortData(PortSmClass smClass) {
        super(smClass);
    }

}
