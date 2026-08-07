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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("c01a25a7-c8ef-43cf-8c06-9c051c23ea77")
public class RelationshipData extends ConceptData {
    @objid ("b6cc382f-4bdc-4b8a-8d25-e7ea63451806")
    SmObjectImpl mTo;

    @objid ("95ceeac9-e3a1-4308-86ae-d6b287234088")
    SmObjectImpl mFrom;

    @objid ("8b97478a-67cf-4dc4-9e1a-9a5b661bdb51")
    public RelationshipData(RelationshipSmClass smClass) {
        super(smClass);
    }

}
