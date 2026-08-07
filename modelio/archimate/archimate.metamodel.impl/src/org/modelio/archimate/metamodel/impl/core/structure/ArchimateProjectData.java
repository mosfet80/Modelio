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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("d1ca03e6-2036-4a0d-bd00-6e6370921d28")
public class ArchimateProjectData extends AbstractProjectData {
    @objid ("6017577e-7ab0-46d1-869b-fea90414778b")
    List<SmObjectImpl> mModel = null;

    @objid ("e8283d4f-be8a-4b88-bd6d-48e80df0bd7e")
    List<SmObjectImpl> mViewPoints = null;

    @objid ("89853feb-dc72-4467-9183-710c531aaeda")
    public ArchimateProjectData(ArchimateProjectSmClass smClass) {
        super(smClass);
    }

}
