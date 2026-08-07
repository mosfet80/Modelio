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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00899130-c4be-1fd8-97fe-001ec947cd2a")
public abstract class ModelTreeData extends UmlModelElementData {
    @objid ("b7751f00-e24e-4d1d-8521-39f61e6d7a36")
    SmObjectImpl mOwner;

    @objid ("63286410-d0ee-4828-afe9-588ff4fa2a46")
    List<SmObjectImpl> mOwnedElement = null;

    @objid ("c66e2cf5-5f47-48ac-9d42-60b045c93b53")
    public ModelTreeData(ModelTreeSmClass smClass) {
        super(smClass);
    }

}
