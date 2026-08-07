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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("002659ee-c4bf-1fd8-97fe-001ec947cd2a")
public class ActivityData extends BehaviorData {
    @objid ("df83f643-dfbb-49c4-9529-d0e66f26273c")
    Object mIsSingleExecution = false;

    @objid ("6cd78af8-0440-4851-8e2c-a1c0eb3a1f75")
    Object mIsReadOnly = false;

    @objid ("8655a4d6-2269-477d-a210-920e629c491c")
    List<SmObjectImpl> mOwnedGroup = null;

    @objid ("f932f332-f647-4624-959b-772074d97062")
    List<SmObjectImpl> mOwnedNode = null;

    @objid ("796a47bb-195a-4bc0-af93-a135f22bf010")
    public ActivityData(ActivitySmClass smClass) {
        super(smClass);
    }

}
