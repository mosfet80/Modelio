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
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000879a6-c4bf-1fd8-97fe-001ec947cd2a")
public class ElementImportData extends UmlModelElementData {
    @objid ("2ddd5d5a-8afe-42e4-9576-2ca41f96cf42")
    Object mVisibility = VisibilityMode.PRIVATE;

    @objid ("00170ba6-e2a7-4a9d-98b9-5aa218d59d6f")
    SmObjectImpl mImportingNameSpace;

    @objid ("6115dd19-385d-4136-a805-8f2fe65e1336")
    SmObjectImpl mImportedElement;

    @objid ("0fc995a9-81f3-4f14-8493-3ebd98117fad")
    SmObjectImpl mImportingOperation;

    @objid ("6e759c3e-4163-4619-b13c-4f47537bc7c3")
    public ElementImportData(ElementImportSmClass smClass) {
        super(smClass);
    }

}
