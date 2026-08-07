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
package org.modelio.archimate.metamodel.layers.motivation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;

/**
 * Requirement vnull
 *
 *
 * <p>In the end, a business goal must be realized by a plan or concrete change goal, which may or&nbsp;may not require a new system or changes to an existing system.</p><p>The term &quot;system&quot; is used in its general meaning; i.e., as a group of (functionally) related&nbsp;elements, where each element may be considered as a system again. Therefore, a system may&nbsp;refer to any active structural element, behavior element, or passive structural element of some&nbsp;organization, such as a business actor, application component, business process, application&nbsp;service, business object, or data object.</p><p>Requirements model the properties of these elements that are needed to achieve the &quot;ends&quot; that&nbsp;are modeled by the goals. In this respect, requirements represent the &quot;means&quot; to realize goals.</p><p>During the design process, goals may be decomposed until the resulting sub-goals are&nbsp;sufficiently detailed to enable their realization by properties that can be exhibited by systems. At&nbsp;this point, goals can be realized by requirements that assign these properties to the systems.</p><p>For example, one may identify two alternative requirements to realize the goal to improve&nbsp;portfolio management:</p>
 *
 * <ul>
 * 	<li>By assigning a personal assistant to each customer, or</li>
 * 	<li>By introducing online portfolio management</li>
 * </ul>
 *
 * <p>The former requirement can be realized by a human actor and the latter by a software&nbsp;application. These requirements can be decomposed further to define the requirements on the&nbsp;human actor and the software application in more detail.</p>
 *
 *
 */
@objid ("7109c01d-765e-437b-89fc-cd2a1fc604aa")
public interface Requirement extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("94b0a4ed-3446-4014-b37a-73afd3826aa0")
    public static final String MNAME = "Requirement";

    /**
     * The metaclass qualified name.
     */
    @objid ("121f7419-329c-4405-9212-a76d4d3c771a")
    public static final String MQNAME = "Archimate.Requirement";

    /**
     * Getter for attribute 'Requirement.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this Requirement as equivalent to an analyst Requirement, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("0bb4a2ed-9044-4e10-8a2d-2f94128d997a")
    String getEquivalentRef();

    /**
     * Setter for attribute 'Requirement.equivalentRef'
     *
     * Metamodel description:
     * <i>To set this Requirement as equivalent to an analyst Requirement, set this attribute with the result of new MRef(analystElement).toString().</i>
     */
    @objid ("acebbcc5-d572-4203-8f55-32bbe1ef6d5e")
    void setEquivalentRef(String value);

}
