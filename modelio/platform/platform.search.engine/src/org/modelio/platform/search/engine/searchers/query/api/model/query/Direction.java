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
package org.modelio.platform.search.engine.searchers.query.api.model.query;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Traversal direction for edges in {@link TraverseStep}.
 * <p>
 * Controls which direction to traverse a link or relation:
 * <ul>
 * <li><b>FORWARD</b>: Traverse in the natural direction defined by the link type's name and semantics.
 * For example, Generalization: sub → super (subclass to superclass)</li>
 * <li><b>BACKWARD</b>: Traverse in the opposite direction.
 * For example, Generalization: super → sub (superclass to subclasses)</li>
 * </ul>
 * <p>
 * The natural direction for each link type is determined by its UML semantics and naming conventions.
 * For structural relations (MDependency), forward uses the dependency as defined, backward uses its opposite.
 * <p>
 * If direction is not specified (null), it defaults to FORWARD.
 *
 * @see TraverseStep
 */
@objid ("a46a575c-90e9-4de4-9f4b-4b07d72815cf")
@JsonFormat(shape = JsonFormat.Shape.STRING, with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_VALUES)
public enum Direction {
    @objid ("a867d974-42fc-45aa-89b5-9356a95e983a")
    @JsonEnumDefaultValue()
    FORWARD,
    @objid ("2f1f9891-429f-4af9-9576-17500f1357f3")
    BACKWARD;

    @objid ("e371a4c1-4b86-4758-a353-988b03216c54")
    @JsonValue
    public String value() {
        return name().toLowerCase();
    }

}
