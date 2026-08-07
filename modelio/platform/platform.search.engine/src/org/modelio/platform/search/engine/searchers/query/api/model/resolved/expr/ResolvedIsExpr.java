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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;

/**
 * Resolved "is" predicate.
 */
@objid ("2e6c3954-3d9e-4723-8c30-b28b72974054")
public record ResolvedIsExpr ( ResolvedKind kind )  implements ResolvedExpr {
    @objid ("dd34d7fc-0db6-4f21-94cb-643ea36dd5cf")
    public ResolvedIsExpr {
        if (kind == null) {
            throw new IllegalArgumentException("kind must not be null");
        }
    }

}
