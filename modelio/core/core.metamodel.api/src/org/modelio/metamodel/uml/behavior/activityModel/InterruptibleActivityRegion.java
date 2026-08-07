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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * InterruptibleActivityRegion v0.0.9054
 *
 *
 * An interruptible region contains activity nodes. When a token leaves an interruptible region via edges designated by the region as interrupting edges, all tokens and behaviors in the region are terminated.
 *
 */
@objid ("00366bf4-c4bf-1fd8-97fe-001ec947cd2a")
public interface InterruptibleActivityRegion extends ActivityGroup {
    /**
     * The metaclass simple name.
     */
    @objid ("e2745e1d-75c7-4705-9d02-b9c90830e7af")
    public static final String MNAME = "InterruptibleActivityRegion";

    /**
     * The metaclass qualified name.
     */
    @objid ("920614c2-529f-4060-868a-9c0e246b7c2c")
    public static final String MQNAME = "Standard.InterruptibleActivityRegion";

    /**
     * Getter for relation 'InterruptibleActivityRegion->InterruptingEdge'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("55d3c811-6baf-4076-a61d-4a09d76ad75e")
    EList<ActivityEdge> getInterruptingEdge();

    /**
     * Filtered Getter for relation 'InterruptibleActivityRegion->InterruptingEdge'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b44a7c62-2257-459b-baac-31c76379b26a")
    <T extends ActivityEdge> List<T> getInterruptingEdge(java.lang.Class<T> filterClass);

}
