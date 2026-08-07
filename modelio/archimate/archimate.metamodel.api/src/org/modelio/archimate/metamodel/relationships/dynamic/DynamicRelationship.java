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
package org.modelio.archimate.metamodel.relationships.dynamic;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;

/**
 * DynamicRelationship vnull
 *
 *
 * <p>The dynamic relationships describe (temporal) dependencies between elements within the&nbsp;architecture. Two types of dynamic relationships are distinguished:</p>
 *
 * <ul>
 * 	<li>The triggering relationship represents a control flow between elements, denoted by a solid&nbsp;line.</li>
 * 	<li>The flow relationship represents a data (or value) flow between elements, denoted by a&nbsp;dashed line.</li>
 * </ul>
 *
 *
 */
@objid ("abdb112d-388c-4cfc-9cb2-d737f86ae428")
public interface DynamicRelationship extends Relationship {
    /**
     * The metaclass simple name.
     */
    @objid ("f9716777-7496-444c-886d-ce99cc1b6ae0")
    public static final String MNAME = "DynamicRelationship";

    /**
     * The metaclass qualified name.
     */
    @objid ("3ed0b499-fe59-4317-86b5-5a74dca52070")
    public static final String MQNAME = "Archimate.DynamicRelationship";

}
