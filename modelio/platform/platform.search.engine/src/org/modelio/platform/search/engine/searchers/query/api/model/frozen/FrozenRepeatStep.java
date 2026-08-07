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

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Recursive step: recursive traversal.
 * <p>
 * The body is executed starting from the current node stream, then the output nodes are fed back
 * as input to the next iteration, until no new nodes are reached or limits are hit.
 *
 * @param emitAllDepths whether to emit nodes at every depth (true) or only the deepest/frontier nodes (false).
 * Defaults to {@code true} for backwards-compatible deserialization.
 * @param body repeated pipeline body
 */
@objid ("5769187e-3b83-4417-8395-c5225d90a1c9")
public record FrozenRepeatStep ( @JsonProperty
        Boolean emitAllDepths,
@JsonProperty(required = true)
        List<FrozenStep> body )  implements FrozenStep {
    @objid ("568270d1-243b-442e-aeb2-b02c5010392c")
    public FrozenRepeatStep {
        if (body == null) {
            throw new IllegalArgumentException("body must not be null");
        }
        if (emitAllDepths == null) {
            emitAllDepths = Boolean.TRUE;
        }
    }

}
