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
package org.modelio.archimate.metamodel.layers.business.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;

/**
 * BusinessInteraction vnull
 *
 *
 * <p>A business interaction is similar to a business process/function, but while a process/function may&nbsp;be performed by a single role, an interaction is performed by a collaboration of multiple roles.</p><p>The roles in the collaboration share the responsibility for performing the interaction.</p><p>A business interaction may be triggered by, or trigger, any other business behavior element&nbsp;(business event, business process, business function, or business interaction). A business&nbsp;interaction may access business objects. A business interaction may realize one or more business&nbsp;services and may use (internal) business services or application services. A business&nbsp;collaboration or an application collaboration may be assigned to a business interaction.</p><p>The&nbsp;name of a business interaction should preferably be a verb in the simple present tense.</p>
 *
 *
 */
@objid ("20b408a3-a7b8-44d1-97bd-6b142a97bb25")
public interface BusinessInteraction extends BusinessInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("10a283d5-94dc-4210-b25a-2a31cd4249ba")
    public static final String MNAME = "BusinessInteraction";

    /**
     * The metaclass qualified name.
     */
    @objid ("3f7b8862-736c-4046-b446-6ffaf9004cb5")
    public static final String MQNAME = "Archimate.BusinessInteraction";

}
