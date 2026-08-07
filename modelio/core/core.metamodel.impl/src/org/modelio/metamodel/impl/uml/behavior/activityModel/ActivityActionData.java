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

@objid ("0026da86-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityActionData extends ActivityNodeData {
    @objid ("f3c494f3-d9ee-4c38-8070-c745f62fed5e")
    Object mIsMultipleInstance = false;

    @objid ("2c3b5170-9768-4a69-bbc2-ffba3d5a760a")
    Object mIsCompensation = false;

    @objid ("5092b122-b173-41ae-9ed1-b687be72f74f")
    List<SmObjectImpl> mOutput = null;

    @objid ("8711fa86-a2b0-43ae-9800-58ed88a7dda4")
    List<SmObjectImpl> mInput = null;

    @objid ("8883239f-0d18-4fa1-85ca-d4b48548ac91")
    List<SmObjectImpl> mHandler = null;

    @objid ("583f78d6-7f27-4f4e-8cf7-475b71b524f0")
    public ActivityActionData(ActivityActionSmClass smClass) {
        super(smClass);
    }

}
