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
package org.modelio.metamodel.diagrams;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ActivityDiagram v0.0.9054
 *
 *
 * <p>Activity diagrams are used to represent business processes, or the dynamic part of a model (algorithm of an operation, for example).</p><p>They can be &quot;autonomous&quot; (inside a package) and represent a process, or the behavior of an operation (inside an operation).</p><p>Creation wizards, using the drag &amp; drop feature, allow to create object nodes (dragging classes), call operations (dragging operations), sub process calls (dragging activities).</p>
 *
 *
 */
@objid ("0067c92e-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityDiagram extends BehaviorDiagram {
    /**
     * The metaclass simple name.
     */
    @objid ("007e52d4-deaa-41ef-b37c-7227dbe752c3")
    public static final String MNAME = "ActivityDiagram";

    /**
     * The metaclass qualified name.
     */
    @objid ("3f128b0a-d28d-4c17-b435-fa7369cb512c")
    public static final String MQNAME = "Standard.ActivityDiagram";

    /**
     * Getter for attribute 'ActivityDiagram.IsVertical'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("3b9e5e1e-84cf-4589-8bda-2cdb07175dec")
    boolean isIsVertical();

    /**
     * Setter for attribute 'ActivityDiagram.IsVertical'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("92d670b4-38cd-4b14-b286-3f7855acb668")
    void setIsVertical(boolean value);

}
