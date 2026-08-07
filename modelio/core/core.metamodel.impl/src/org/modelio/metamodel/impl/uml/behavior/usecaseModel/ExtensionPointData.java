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
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0059d030-c4bf-1fd8-97fe-001ec947cd2a")
public class ExtensionPointData extends UmlModelElementData {
    @objid ("91842315-e632-44da-8b96-036a289ce763")
    Object mVisibility = VisibilityMode.PUBLIC;

    @objid ("8ff484b4-a1d9-4315-876d-4ad7d6afdd6c")
    List<SmObjectImpl> mExtended = null;

    @objid ("361dd475-1a0c-4b3f-ac99-cc4db8faedc3")
    SmObjectImpl mOwner;

    @objid ("0470a895-0310-4f1f-9453-82308532b0c8")
    public ExtensionPointData(ExtensionPointSmClass smClass) {
        super(smClass);
    }

}
