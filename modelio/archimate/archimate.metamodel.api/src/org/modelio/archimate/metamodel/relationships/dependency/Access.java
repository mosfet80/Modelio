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
package org.modelio.archimate.metamodel.relationships.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Access vnull
 *
 *
 * <p>The access relationship indicates that a process, function, interaction, service, or event &quot;does&nbsp;something&quot; with a passive structure element; e.g., create a new object, read data from the object,&nbsp;write or modify the object data, or delete the object. The relationship can also be used to indicate&nbsp;that the object is just associated with the behavior; e.g., it models the information that comes&nbsp;with an event, or the information that is made available as part of a service.</p><p>The arrow head, if&nbsp;present, indicates the direction of the flow of information. (The access relationship should not be&nbsp;confused with the UML dependency relationship, which uses a similar notation.)</p><p>Note that, at the metamodel level, the direction of the relationship is always :</p>
 *
 * <ul>
 * 	<li>from an active&nbsp;structure element or a behavior element</li>
 * 	<li>to a passive structure element,</li>
 * </ul>
 *
 * <p>although the notation&nbsp;may point in the other direction to denote &#39;read&#39; access, and in both directions to denote read-write access.</p><p>Care must be taken when using access with derived relationships because the arrow&nbsp;on the relationship has no bearing to its directionality. Directionality on an access relationship is&nbsp;always from a behavior element to a passive element.</p><p>Alternatively, an access relationship can be expressed by nesting the passive structure element&nbsp;inside the behavior or active structure element that accesses it; for example, nesting a data object&nbsp;inside an application component.</p><p>The usual interpretation of an access relationship is that <em>the whole</em> of the source element is&nbsp;accessed by the target element. This means that if, for example, the same internal behavior&nbsp;element accesses two passive structure elements, both of these passive structure elements are&nbsp;needed. If two passive structure elements are, for example, alternative information sources and&nbsp;only one of them is needed by the internal behavior element, an or junction can be used.</p>
 *
 *
 */
@objid ("fcc486f4-6532-41fb-a788-5499681b5b77")
public interface Access extends DependencyRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("e3c78886-a0fc-4d3d-8688-6a2ed325d59a")
    public static final String MNAME = "Access";

    /**
     * The metaclass qualified name.
     */
    @objid ("e60c564e-034f-4b72-a16a-b94ed1324387")
    public static final String MQNAME = "Archimate.Access";

    /**
     * Getter for attribute 'Access.mode'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("0b02f76d-3bd5-4d4d-9925-1041d24c4ca8")
    AccessMode getMode();

    /**
     * Setter for attribute 'Access.mode'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("90b8ff10-5c62-4b98-86be-47bc0ab6ce7e")
    void setMode(AccessMode value);

}
