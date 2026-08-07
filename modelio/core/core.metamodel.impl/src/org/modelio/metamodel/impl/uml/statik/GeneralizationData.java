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

@objid ("000cfae4-c4bf-1fd8-97fe-001ec947cd2a")
public class GeneralizationData extends UmlModelElementData {
    @objid ("61f22632-bace-4275-9e49-c9be42fe76a5")
    Object mDiscriminator = "";

    @objid ("8c0ac8dd-2423-43f0-94b1-93058825f8c1")
    SmObjectImpl mSuperType;

    @objid ("b0ba5cbc-bc68-41e1-9b2e-9ae7d8be089f")
    SmObjectImpl mSubType;

    @objid ("0388c1d7-bdf2-4198-baee-1e221df569d8")
    public GeneralizationData(GeneralizationSmClass smClass) {
        super(smClass);
    }

}
