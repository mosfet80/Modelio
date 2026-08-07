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

@objid ("0006480c-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryConnectorData extends NaryLinkData {
    @objid ("b4c02536-461f-4373-969c-c816a782b0c3")
    List<SmObjectImpl> mRepresentation = null;

    @objid ("3f382a7d-2d8f-4036-94c6-bcd92fb68242")
    SmObjectImpl mRepresentedFeature;

    @objid ("d441f59d-6388-41d0-9133-ab2067201e43")
    public NaryConnectorData(NaryConnectorSmClass smClass) {
        super(smClass);
    }

}
