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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;

/**
 * Traverse step: traverses one edge.
 *
 * @param edge edge reference (may resolve to a link metaclass, a link
 * stereotype, or a structural relation)
 * @param direction optional direction: {@code "forward"} or {@code "backward"}
 * @param edgeFilter optional predicate applied to the edge itself when
 * traversing link objects
 */
@objid ("7f76f1f2-f04c-4b70-b703-a24af31c556a")
public record FrozenTraverseStep ( @JsonProperty(required = true)
        String edge,
        @JsonProperty(defaultValue = "FORWARD")
        Direction direction,
FrozenExpr edgeFilter )  implements FrozenStep {
    /**
     * Convenience constructor.
     *
     * @param edge edge reference
     */
    @objid ("2e9f74b4-67fc-4525-bb58-a6dba0a3600b")
    public FrozenTraverseStep(final String edge) {
        this(edge, null, null);
    }

    @objid ("28848b76-5f6c-4332-ab5e-413345b16fce")
    public FrozenTraverseStep {
        if (edge == null || edge.isBlank()) {
            throw new IllegalArgumentException("edge must not be null/blank");
        }
    }

}
