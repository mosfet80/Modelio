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
package org.modelio.archimate.metamodel.layers.technology.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;

/**
 * TechnologyInterface vnull
 *
 *
 * <p>A technology interface specifies how the technology services of a node can be accessed by other&nbsp;nodes (provided interface), or which functionality the node requires from its environment&nbsp;(required interface). A technology interface exposes a technology service to the environment.</p><p>The same service may be exposed through different interfaces.</p><p>In a sense, a technology interface specifies a kind of contract that a component realizing this&nbsp;interface must fulfill. This may include, for example, parameters, protocols used, pre- and post-conditions, and data formats.</p><p>A technology interface may be part of a node through composition (not shown in the standard&nbsp;notation), which means that these interfaces are provided by that node, and can serve other&nbsp;nodes. A technology service can be assigned to a technology interface, which exposes the&nbsp;service to the environment.</p><p>The name of a technology interface should preferably be a noun.</p>
 *
 *
 */
@objid ("d9914379-df96-402d-be73-52645420493e")
public interface TechnologyInterface extends ExternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("d903d308-b68e-4cc6-83ab-78f44d984920")
    public static final String MNAME = "TechnologyInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("9d90810d-3cb7-4c97-a2b8-81b37c8e00d0")
    public static final String MQNAME = "Archimate.TechnologyInterface";

}
