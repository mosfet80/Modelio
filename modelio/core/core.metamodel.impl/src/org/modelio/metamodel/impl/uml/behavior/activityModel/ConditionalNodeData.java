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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("002db2e8-c4bf-1fd8-97fe-001ec947cd2a")
public class ConditionalNodeData extends StructuredActivityNodeData {
    @objid ("d2ab2e8a-93f5-4008-97a1-e37b3dca9e3f")
    Object mIsDeterminate = false;

    @objid ("60bf9944-4352-4e59-a356-8f204f37c344")
    Object mIsAssured = false;

    @objid ("a8155edd-cd44-4115-a0d9-6911c93046fe")
    List<SmObjectImpl> mOwnedClause = null;

    @objid ("2fb5a4af-1cb6-4353-984d-9525b721d7b4")
    public ConditionalNodeData(ConditionalNodeSmClass smClass) {
        super(smClass);
    }

}
