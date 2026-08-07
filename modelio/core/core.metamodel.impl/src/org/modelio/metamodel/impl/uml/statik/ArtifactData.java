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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("009712f6-c4be-1fd8-97fe-001ec947cd2a")
public class ArtifactData extends ClassifierData {
    @objid ("ec588d50-c5af-4724-9d32-168353c147ed")
    Object mFileName = "";

    @objid ("d28ab9df-8774-4827-85a4-19df05965fc6")
    List<SmObjectImpl> mUtilized = null;

    @objid ("240802a8-39a2-4a89-878d-dd4976362c22")
    List<SmObjectImpl> mDeploymentLocation = null;

    @objid ("f467db18-4ab8-4bcc-b1cf-ffbaea359ba4")
    public ArtifactData(ArtifactSmClass smClass) {
        super(smClass);
    }

}
