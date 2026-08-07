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

/**
 * Resolved binary comparison expression.
 */
@objid ("8df756a4-ec39-4455-b149-0c14586aafd7")
public record ResolvedCompareExpr ( String op,
ResolvedValueExpr left,
ResolvedValueExpr right )  implements ResolvedExpr {
    @objid ("7e0681d1-8793-478d-96ed-d9839986f23b")
    public ResolvedCompareExpr {
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
