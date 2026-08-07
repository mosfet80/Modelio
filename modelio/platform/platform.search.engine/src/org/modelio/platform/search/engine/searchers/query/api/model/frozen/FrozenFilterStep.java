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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Filter step: filters the current node stream based on a predicate.
 *
 * @param where predicate to apply
 */
@objid ("a10cc648-5fb0-43a2-a1e5-519d81015eac")
public record FrozenFilterStep ( @JsonProperty(required = true)
        FrozenExpr where )  implements FrozenStep {
    @objid ("85b1ab27-b482-4897-a9cd-bb5e4179870f")
    public FrozenFilterStep {
        if (where == null) {
            throw new IllegalArgumentException("where must not be null");
        }
    }

}
