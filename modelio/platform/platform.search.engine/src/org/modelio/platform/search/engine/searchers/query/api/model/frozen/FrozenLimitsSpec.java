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

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Immutable execution limits.
 *
 * @param maxDepth maximum recursion depth for all repeat steps (null means infinite)
 * @param limit maximum items returned in the response (null means default engine value)
 * @param timeoutMs hard wall time (null means default engine value)
 */
@objid ("7cc05660-b05e-42a5-b581-783e5377e11d")
public record FrozenLimitsSpec ( Integer maxDepth,
        Integer limit,
        Long timeoutMs )  {
    /**
     * Alternative constructor with int timeout for convenience.
     *
     * @param maxDepth maximum recursion depth for all repeat steps (null means infinite)
     * @param limit maximum items returned in the response (null means default engine value)
     * @param timeoutMs hard wall time in milliseconds (no null)
     */
    @objid ("fa64c0ce-07c0-4318-aa8d-2445cff3b0e8")
    public FrozenLimitsSpec(Integer maxDepth, Integer limit, int timeoutMs) {
        this(maxDepth, limit, (long) timeoutMs);
    }

}
