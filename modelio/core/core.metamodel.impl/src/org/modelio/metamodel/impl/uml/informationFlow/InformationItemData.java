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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.ClassifierData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("006434d0-c4bf-1fd8-97fe-001ec947cd2a")
public class InformationItemData extends ClassifierData {
    @objid ("a6cbb102-8cbb-4fcb-80a2-f2c0d8d90255")
    List<SmObjectImpl> mRepresented = null;

    @objid ("e3f10885-b676-47c7-8014-2dbed7f48b5b")
    public InformationItemData(InformationItemSmClass smClass) {
        super(smClass);
    }

}
