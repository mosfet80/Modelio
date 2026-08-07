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
package org.modelio.metamodel.impl.mda;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0066673c-c4bf-1fd8-97fe-001ec947cd2a")
public class ProjectData extends AbstractProjectData {
    @objid ("8197a9cd-40d7-482e-9e7b-ad6d024cd9d7")
    Object mProjectContext = "";

    @objid ("bb2e5267-0a5d-488f-b429-33851ccdf265")
    Object mProjectDescr = "";

    @objid ("f71983bb-2293-4640-b88f-cc49b12c30ca")
    List<SmObjectImpl> mModel = null;

    @objid ("2f56cdc1-1ef7-4c0a-bff5-f530c923d90c")
    public ProjectData(ProjectSmClass smClass) {
        super(smClass);
    }

}
