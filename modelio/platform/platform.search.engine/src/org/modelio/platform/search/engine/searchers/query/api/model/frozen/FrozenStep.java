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
package org.modelio.platform.search.engine.searchers.query.api.model.frozen;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Immutable pipeline step.
 */
@objid ("778ac4d9-7107-4ac9-933a-c8cde20f9720")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "op")
@JsonSubTypes({ @JsonSubTypes.Type(value = FrozenFilterStep.class, name = "filter"), @JsonSubTypes.Type(value = FrozenTraverseStep.class, name = "traverse"), @JsonSubTypes.Type(value = FrozenUnionStep.class, name = "union"), @JsonSubTypes.Type(value = FrozenRepeatStep.class, name = "repeat") })
public sealed interface FrozenStep permits FrozenFilterStep, FrozenTraverseStep, FrozenUnionStep, FrozenRepeatStep {
}
