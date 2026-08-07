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
 * Expression used for predicates and value computations.
 */
@objid ("95170f83-6551-41c8-b343-3ea315a1479c")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = FrozenAndExpr.class, name = "and"), @JsonSubTypes.Type(value = FrozenOrExpr.class, name = "or"), @JsonSubTypes.Type(value = FrozenNotExpr.class, name = "not"), @JsonSubTypes.Type(value = FrozenCompareExpr.class, name = "compare"), @JsonSubTypes.Type(value = FrozenIsExpr.class, name = "is"), @JsonSubTypes.Type(value = FrozenExistsExpr.class, name = "exists") })
public sealed interface FrozenExpr permits FrozenAndExpr, FrozenOrExpr, FrozenNotExpr, FrozenCompareExpr, FrozenIsExpr, FrozenExistsExpr {
}
