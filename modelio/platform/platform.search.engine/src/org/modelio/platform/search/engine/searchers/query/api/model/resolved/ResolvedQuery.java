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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLimitsSpec;

/**
 * Internal, resolved query model.
 * <p>
 * This record is the minimal "execution shape" for future query execution.
 * It must not depend on the public unresolved query AST types.
 *
 * @param source resolved query source
 * @param steps resolved pipeline steps
 * @param limits immutable execution limits handle
 */
@objid ("ad584526-73e5-402b-880a-34c76c498329")
public record ResolvedQuery ( ResolvedSource source,
List<ResolvedStep> steps,
FrozenLimitsSpec limits )  {
    @objid ("e0a00a26-fd87-4619-a58e-c27167e4bfc3")
    public ResolvedQuery {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        if (steps == null) {
            throw new IllegalArgumentException("steps must not be null");
        }
        if (limits == null) {
            throw new IllegalArgumentException("limits must not be null");
        }
        steps = List.copyOf(steps);
    }

}
