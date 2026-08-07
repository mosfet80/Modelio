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
 * Resolved logical OR expression.
 */
@objid ("07dab6ba-44a2-411f-9c79-7de210997fc2")
public record ResolvedOrExpr ( List<ResolvedExpr> exprs )  implements ResolvedExpr {
    @objid ("10e82ffa-1305-4066-86bf-6ddd2e7d97a1")
    public ResolvedOrExpr {
        if (exprs == null) {
            exprs = List.of();
        }
        exprs = List.copyOf(exprs);
    }

}
