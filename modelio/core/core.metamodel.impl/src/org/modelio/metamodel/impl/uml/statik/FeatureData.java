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

@objid ("000b775a-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class FeatureData extends UmlModelElementData {
    @objid ("58fcfc3b-38cf-4265-aeaf-21f4584055b0")
    Object mVisibility = VisibilityMode.PUBLIC;

    @objid ("7b9a83f4-d014-4cc2-ac21-8a1cb187dd6d")
    Object mIsClass = false;

    @objid ("c009a7d3-41da-4987-9584-edb1dcb27ed0")
    Object mIsAbstract = false;

    @objid ("1771c0b9-0c46-4325-ae53-ed8150bebd75")
    public FeatureData(FeatureSmClass smClass) {
        super(smClass);
    }

}
