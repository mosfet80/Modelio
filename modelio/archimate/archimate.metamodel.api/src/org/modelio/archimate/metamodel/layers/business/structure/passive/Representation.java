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
package org.modelio.archimate.metamodel.layers.business.structure.passive;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;

/**
 * Representation vnull
 *
 *
 * <p>Representations (for example, messages or documents) are the perceptible carriers of&nbsp;information that are related to business objects.</p><p>If relevant, representations can be classified in&nbsp;various ways; for example, in terms of medium (electronic, paper, audio, etc.) or format (HTML, ASCII, PDF, RTF, etc.).</p><p>A single business object can have a number of different representations.</p><p>Also, a single representation can realize one or more specific business objects.</p><p>A meaning can be associated with a representation that carries this meaning.</p><p>The name of a&nbsp;representation is preferably a noun.</p>
 *
 *
 */
@objid ("74d30435-b21e-4b01-b62c-9d2ed094d58f")
public interface Representation extends BusinessPassiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b08a656c-3956-4e19-820f-5c6cdd16f1c8")
    public static final String MNAME = "Representation";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd3ab6d6-ae13-4d0b-9b84-b9851f3e3044")
    public static final String MQNAME = "Archimate.Representation";

}
