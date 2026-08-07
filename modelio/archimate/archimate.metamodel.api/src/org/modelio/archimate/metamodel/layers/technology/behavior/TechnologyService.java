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
package org.modelio.archimate.metamodel.layers.technology.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;

/**
 * TechnologyService vnull
 *
 *
 * <p>A technology service exposes the functionality of a node to its environment. This functionality is&nbsp;accessed through one or more technology interfaces. It may require, use, and produce artifacts.</p><p>A technology service should be meaningful from the point of view of the environment; it should&nbsp;provide a unit of behavior that is, in itself, useful to its users, such as application components&nbsp;and nodes.</p><p>Typical technology services may, for example, include messaging, storage, naming, and&nbsp;directory services. It may access artifacts; e.g., a file containing a message.</p><p>A technology service may serve application components or nodes. A technology service is&nbsp;realized by a technology function or process. A technology service is exposed by a node by&nbsp;assigning it to its technology interfaces. A technology service may access artifacts.</p><p>The name of a technology service should preferably be a verb ending with &quot;ing&quot;; e.g.,&nbsp;&quot;messaging&quot;. Also, a name explicitly containing the word &quot;service&quot; may be used.</p><p>A technology service may consist of sub-services.</p>
 *
 *
 */
@objid ("1c2cc7bb-166b-48f9-83b1-28dbbc78e6b2")
public interface TechnologyService extends ExternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f60ffcb2-d752-4cbb-acac-c8ef4c0822dd")
    public static final String MNAME = "TechnologyService";

    /**
     * The metaclass qualified name.
     */
    @objid ("0966c115-acde-4f85-9668-2cffea114625")
    public static final String MQNAME = "Archimate.TechnologyService";

}
