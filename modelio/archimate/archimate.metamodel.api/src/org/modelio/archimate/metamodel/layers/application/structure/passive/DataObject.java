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
package org.modelio.archimate.metamodel.layers.application.structure.passive;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;

/**
 * DataObject vnull
 *
 *
 * <p>A data object represents an encapsulation of information that is recognized by a business expert as a thing and is suitable for automated processing.</p><p>A data object should be a self-contained piece of information with a clear meaning to the&nbsp;business, not just to the application level. Typical examples of data objects are a customer&nbsp;record, a client database, or an insurance claim.</p><p>The ArchiMate language in general focuses on the modeling of&nbsp;types, not instances, since this is the most relevant at the Enterprise Architecture level of&nbsp;description. Hence a data object typically models an object type (cf. a UML class) of which&nbsp;multiple instances may exist in operational applications. An important exception is when a data&nbsp;object is used to model a data collection such as a database, of which only one instance exists.</p><p>An application function or process can operate on data objects.</p><p>A data object may be&nbsp;communicated via interactions and used or produced by application services.</p><p>A data object can&nbsp;be accessed by an application function, application interaction, or application service.</p><p>A data&nbsp;object may realize a business object, and may be realized by an artifact.</p><p>A data object may have&nbsp;association, specialization, aggregation, or composition relationships with other data objects.</p><p>The name of a data object should preferably be a noun.</p>
 *
 *
 */
@objid ("0f9c030e-40a2-4ae6-a61d-f93600722070")
public interface DataObject extends PassiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("44c28bed-8110-4cbf-a2c8-daf3208fd146")
    public static final String MNAME = "DataObject";

    /**
     * The metaclass qualified name.
     */
    @objid ("3a0b3c24-d42d-400b-a9a9-ea51b65c37e0")
    public static final String MQNAME = "Archimate.DataObject";

}
