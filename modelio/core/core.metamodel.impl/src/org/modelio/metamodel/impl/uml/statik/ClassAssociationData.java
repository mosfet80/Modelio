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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000325f0-c4bf-1fd8-97fe-001ec947cd2a")
public class ClassAssociationData extends UmlModelElementData {
    @objid ("997bf718-b4b1-4fa4-a9fa-a241460a86dd")
    SmObjectImpl mNaryAssociationPart;

    @objid ("0452575c-21fb-4659-8241-6ac7e7e5642b")
    SmObjectImpl mClassPart;

    @objid ("cf74c70c-20fa-4c9b-b508-6eccd0ef6dab")
    SmObjectImpl mAssociationPart;

    @objid ("c68cb237-f576-42e7-ba66-de9d464e98f1")
    public ClassAssociationData(ClassAssociationSmClass smClass) {
        super(smClass);
    }

}
