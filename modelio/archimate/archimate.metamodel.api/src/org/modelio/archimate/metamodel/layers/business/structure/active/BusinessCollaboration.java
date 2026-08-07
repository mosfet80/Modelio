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
package org.modelio.archimate.metamodel.layers.business.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;

/**
 * BusinessCollaboration vnull
 *
 *
 * <p>A business process or function may be interpreted as the internal behavior assigned to a single&nbsp;business role.</p><p>In some cases behavior is the collective effort of more than one business role; in&nbsp;fact a collaboration of two or more business roles results in collective behavior which may be&nbsp;more than simply the sum of the behavior of the separate roles.</p><p>Business collaborations represent&nbsp;this collective effort. Business interactions are used to describe the internal behavior that takes&nbsp;place within business collaboration.</p><p>A collaboration is a (possibly temporary) collection of&nbsp;business roles or actors within an organization, which perform collaborative behavior&nbsp;(interactions).</p><p>Unlike a department, which may also group roles, a business collaboration need&nbsp;not have an official (permanent) status within the organization; it is specifically aimed at a&nbsp;specific interaction or set of interactions between roles. It is especially useful in modeling B2B&nbsp;interactions between different organizations such as provider networks, and also for describing&nbsp;social networks.</p><p>A business collaboration may aggregate a number of business roles or actors, and may be&nbsp;assigned to one or more business interactions or other business internal behavior elements.</p><p>A&nbsp;business interface or an application interface may serve a business collaboration, while a&nbsp;business collaboration may have business interfaces (through &nbsp;composition, and also through&nbsp;aggregation via derived relationships).</p><p>The name of a business collaboration should preferably&nbsp;be a noun. It is also rather common to leave a business collaboration unnamed.</p>
 *
 *
 */
@objid ("73d2af44-6294-4336-8034-3bc2cac27593")
public interface BusinessCollaboration extends BusinessInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("538fbfab-ca6d-4294-b59c-c79d0d15ccae")
    public static final String MNAME = "BusinessCollaboration";

    /**
     * The metaclass qualified name.
     */
    @objid ("1025c18c-05ce-4912-b990-fa0c6131f8a2")
    public static final String MQNAME = "Archimate.BusinessCollaboration";

}
