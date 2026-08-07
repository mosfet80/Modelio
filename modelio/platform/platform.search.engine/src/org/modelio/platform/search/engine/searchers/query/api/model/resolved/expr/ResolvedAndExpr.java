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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Resolved logical AND expression.
 */
@objid ("3226c525-8895-45d8-bd7c-b6f4afd90ea0")
public record ResolvedAndExpr ( List<ResolvedExpr> exprs )  implements ResolvedExpr {
    @objid ("e7ae2d90-7141-4a42-83f9-992b599e9d92")
    public ResolvedAndExpr {
        if (exprs == null) {
            exprs = List.of();
        }
        exprs = List.copyOf(exprs);
    }

}
