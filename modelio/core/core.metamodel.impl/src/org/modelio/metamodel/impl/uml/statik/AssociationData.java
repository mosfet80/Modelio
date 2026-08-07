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

@objid ("60b053d8-9a17-42c3-83bc-888ce3e68a7d")
public class AssociationData extends UmlModelElementData {
    @objid ("c11d2a81-36c5-48e3-b549-c5f71a8a59f8")
    List<SmObjectImpl> mOccurence = null;

    @objid ("78e80494-0ddb-4251-8ad1-bec9e61fd698")
    List<SmObjectImpl> mEnd = null;

    @objid ("681f7e78-b18e-4a61-86e8-2831a2a1c836")
    SmObjectImpl mLinkToClass;

    @objid ("2da559bb-159b-481b-a626-9816dcb1079f")
    public AssociationData(AssociationSmClass smClass) {
        super(smClass);
    }

}
