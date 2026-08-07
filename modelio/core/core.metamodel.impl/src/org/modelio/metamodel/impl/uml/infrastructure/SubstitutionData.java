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
package org.modelio.metamodel.impl.uml.infrastructure;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("008e4b26-c4be-1fd8-97fe-001ec947cd2a")
public class SubstitutionData extends UmlModelElementData {
    @objid ("3b438dc8-0569-4ff0-83eb-730db7ccddc9")
    SmObjectImpl mContract;

    @objid ("123460ce-1f79-47c1-af7c-0b5fdfe4e5e0")
    SmObjectImpl mSubstitutingClassifier;

    @objid ("d8b7fb8f-2bb7-4003-bc2f-1cffadaf0cd5")
    public SubstitutionData(SubstitutionSmClass smClass) {
        super(smClass);
    }

}
