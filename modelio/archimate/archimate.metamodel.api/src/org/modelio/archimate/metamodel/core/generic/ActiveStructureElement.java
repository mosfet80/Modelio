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
package org.modelio.archimate.metamodel.core.generic;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ActiveStructureElement vnull
 *
 *
 * <p>These can be subdivided into :</p>
 *
 * <ul>
 * 	<li>internal active structure elements; i.e., the business actors, application components, nodes, etc., that realize this behavior,</li>
 * 	<li>and external active structure elements; i.e., the interfaces that expose this behavior to the environment.<br />
 * 	An interface provides an external view on the service provider and hides its internal structure.</li>
 * </ul>
 *
 *
 */
@objid ("a9c01081-b85d-4cdd-bbe0-9bd267824204")
public interface ActiveStructureElement extends StructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("c6372bf5-5dd8-447b-bd0d-86e28a8b3550")
    public static final String MNAME = "ActiveStructureElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("e7663938-02d8-4202-9acd-3ec9028f268f")
    public static final String MQNAME = "Archimate.ActiveStructureElement";

}
