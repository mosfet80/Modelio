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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0022bc4e-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryLinkData extends UmlModelElementData {
    @objid ("06cf6e3c-1691-40f2-8ddf-d7cc04a05a6e")
    List<SmObjectImpl> mNaryLinkEnd = null;

    @objid ("7e11a19a-dd6e-413f-82ee-7b2ba394b396")
    SmObjectImpl mModel;

    @objid ("1783cb47-61e6-4e4e-9299-8a6161bf37b1")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("9d26568b-a015-4699-91b5-ff290af7f2b6")
    List<SmObjectImpl> mSent = null;

    @objid ("174e3eef-7348-4e28-989a-8b0a1fa71f2a")
    public NaryLinkData(NaryLinkSmClass smClass) {
        super(smClass);
    }

}
