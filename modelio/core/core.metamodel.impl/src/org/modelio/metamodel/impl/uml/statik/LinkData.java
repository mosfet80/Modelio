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

@objid ("2eae30e5-5566-403a-a2fc-fb71b87360b4")
public class LinkData extends UmlModelElementData {
    @objid ("9de18abc-8a67-4dd5-8a3e-3dd74327eb9a")
    SmObjectImpl mModel;

    @objid ("fb6876f2-35a2-48a7-8958-a66da22c5a45")
    List<SmObjectImpl> mLinkEnd = null;

    @objid ("f24406fd-1b2c-4678-a0ee-f47af3987059")
    SmObjectImpl mSent;

    @objid ("1fbaea3e-d7af-4416-bcfc-a8a5d9e88d43")
    public LinkData(LinkSmClass smClass) {
        super(smClass);
    }

}
