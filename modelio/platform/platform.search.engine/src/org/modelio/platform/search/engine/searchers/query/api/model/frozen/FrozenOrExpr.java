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
 * Immutable boolean disjunction.
 *
 * @param exprs expressions to combine
 */
@objid ("c8cba73b-9d56-4577-a02c-47d239b5656c")
public record FrozenOrExpr ( @JsonProperty(required = true)
        List<FrozenExpr> exprs )  implements FrozenExpr {
    @objid ("12e2a919-a886-4967-9b17-978dd2458b86")
    public FrozenOrExpr {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs must not be null");
        }
    }

}
