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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.ElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0046463c-c4bf-1fd8-97fe-001ec947cd2a")
public class GeneralOrderingData extends ElementData {
    @objid ("1ca3a70f-3151-4f21-9450-8cb8460cf5d7")
    SmObjectImpl mBefore;

    @objid ("34a6b9ea-c2ca-4d44-9701-c052dc6480a7")
    SmObjectImpl mAfter;

    @objid ("296a9cfb-8968-4985-a834-40153fec3f85")
    public GeneralOrderingData(GeneralOrderingSmClass smClass) {
        super(smClass);
    }

}
