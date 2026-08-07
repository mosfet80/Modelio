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
 * Binary comparison expression.
 *
 * @param op operator: {@code =, !=, <, >, <=, >=, contains, startsWith}
 * @param left left operand
 * @param right right operand
 */
@objid ("b0d1f2ab-1bb4-467b-9682-a126dc03d3df")
public record FrozenCompareExpr ( @JsonProperty(required = true)
        String op,
@JsonProperty(required = true)
        FrozenValueExpr left,
@JsonProperty(required = true)
        FrozenValueExpr right )  implements FrozenExpr {
    @objid ("c9e1ff53-44d7-4e01-9b6b-5726d4f007b2")
    public FrozenCompareExpr {
        if (op == null || op.isBlank()) {
            throw new IllegalArgumentException("op must not be null/blank");
        }
        if (left == null) {
            throw new IllegalArgumentException("left must not be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("right must not be null");
        }
    }

}
