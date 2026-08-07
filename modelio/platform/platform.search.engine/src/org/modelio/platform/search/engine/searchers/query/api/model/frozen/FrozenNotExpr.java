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
 * Immutable boolean negation.
 *
 * @param expr expression to negate
 */
@objid ("5d3ddf27-4af2-4e90-8b43-a454ad968161")
public record FrozenNotExpr ( @JsonProperty(required = true)
        FrozenExpr expr )  implements FrozenExpr {
    @objid ("20b6348a-b038-43fc-a4c5-239a59989c48")
    public FrozenNotExpr {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
        }
    }

}
