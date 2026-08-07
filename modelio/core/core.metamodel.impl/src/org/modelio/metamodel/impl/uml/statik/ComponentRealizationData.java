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

@objid ("085ab992-591c-4bfe-a9dd-e52568b31bc1")
public class ComponentRealizationData extends UmlModelElementData {
    @objid ("454d7cd9-b717-4407-82d5-42148c236e34")
    SmObjectImpl mRealizingClassifier;

    @objid ("7d3f2f52-f9a0-4c9b-83c3-297741e378db")
    SmObjectImpl mAbstraction;

    @objid ("3a70aa0d-1749-44e7-862c-1c46b6acb216")
    public ComponentRealizationData(ComponentRealizationSmClass smClass) {
        super(smClass);
    }

}
