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
 * Immutable boolean conjunction.
 *
 * @param exprs expressions to combine
 */
@objid ("64c79709-3a47-477e-a141-bb9dfd97e8d2")
public record FrozenAndExpr ( @JsonProperty(required = true)
        List<FrozenExpr> exprs )  implements FrozenExpr {
    @objid ("175c42f4-4408-47d0-b71f-1438361bfcf5")
    public FrozenAndExpr {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs must not be null");
        }
    }

}
