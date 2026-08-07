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
package org.modelio.archimate.metamodel.impl.core;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("20c089f2-1ac9-48de-86b1-67477fc2c0f6")
public class ConceptData extends ArchimateAbstractElementData {
    @objid ("dd0a9ade-b9d3-438a-a2f9-7d1f5cad3062")
    List<SmObjectImpl> mRelatedFrom = null;

    @objid ("99b2b0ed-bacd-4bab-911f-0236052975d5")
    List<SmObjectImpl> mRelatedTo = null;

    @objid ("8609fa26-5f4c-4cbe-948e-22656437110a")
    SmObjectImpl mOwnerFolder;

    @objid ("1d98684c-6840-4d59-af61-0f8887d32dea")
    public ConceptData(ConceptSmClass smClass) {
        super(smClass);
    }

}
