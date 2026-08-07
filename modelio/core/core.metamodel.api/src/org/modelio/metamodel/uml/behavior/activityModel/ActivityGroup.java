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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * ActivityGroup v0.0.9054
 *
 *
 * Nodes and edges can belong to more than one group. They have no inherent semantics and can be used for various purposes. Subclasses of ActivityGroup may add semantics.
 *
 * ActivityGroups belong to an activity or (exclusively) to another ActivityGroup.
 *
 */
@objid ("002813ba-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityGroup extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3a0445a3-b867-41d7-afb3-0fc4f9a652c6")
    public static final String MNAME = "ActivityGroup";

    /**
     * The metaclass qualified name.
     */
    @objid ("fe2323f5-ee25-4ddd-9045-004f4c58ab20")
    public static final String MQNAME = "Standard.ActivityGroup";

    /**
     * Getter for relation 'ActivityGroup->InActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("84d36187-5b8b-4f1d-81a8-0ca5bd922072")
    Activity getInActivity();

    /**
     * Setter for relation 'ActivityGroup->InActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2ae35ee9-0975-4a94-b745-3cdd534dc3b4")
    void setInActivity(Activity value);

}
