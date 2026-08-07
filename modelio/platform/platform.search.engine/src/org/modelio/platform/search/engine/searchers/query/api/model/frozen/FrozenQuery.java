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
 * Immutable top-level query AST.
 * <p>
 * A Query represents a complete MQL (Modelio Query Language) query to be executed
 * against a model graph. It consists of:
 * <ul>
 * <li>A {@link FrozenSource source} : the initial collection of elements to process</li>
 * <li>A {@link #steps() steps} : a sequence of steps transforming the element stream</li>
 * <li>{@link #limits() Execution limits} : bounds for performance (timeout, depth, result count)</li>
 * </ul>
 * <p>
 * The query can be serialized to/from JSON for persistence and sharing.
 *
 * @param version query AST version (currently {@code 1})
 * @param source initial element collection
 * @param steps pipeline steps transforming the element stream
 * @param limits execution limits (timeout, max depth, max results)
 */
@objid ("42b6737d-408f-4e6b-b2b8-4d10939a6a24")
public record FrozenQuery ( @JsonProperty(required = true)
        int version,
@JsonProperty(required = true)
        FrozenSource source,
@JsonProperty(required = true)
        List<FrozenStep> steps,
@JsonProperty(required = true)
        FrozenLimitsSpec limits )  {
    @objid ("296f2ae5-98c4-4268-a9a3-5e3bdbca7dd7")
    public static final int V1 = 1;

    @objid ("26e8ed47-5a06-45e5-b945-e01308f75e29")
    public FrozenQuery {
        if (version != V1) {
            throw new IllegalArgumentException("Unsupported query version: " + version);
        }
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        if (steps == null) {
            throw new IllegalArgumentException("steps must not be null");
        }
        if (limits == null) {
            throw new IllegalArgumentException("limits must not be null");
        }
    }

    /**
     * Convenience constructor for last version.
     *
     * @param source initial element collection
     * @param steps pipeline steps transforming the element stream
     * @param limits execution limits
     */
    @objid ("ce615457-5aed-4a82-97a0-0ddf857a04f2")
    public FrozenQuery(final FrozenSource source, final List<FrozenStep> steps, final FrozenLimitsSpec limits) {
        this(V1, source, steps, limits);
    }

}
