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
 * Resolved logical NOT expression.
 */
@objid ("8f87b6f1-47a9-4848-99bb-60d966cadd6b")
public record ResolvedNotExpr ( ResolvedExpr expr )  implements ResolvedExpr {
    @objid ("d35bf70b-5b3a-4f09-ac80-163229236d22")
    public ResolvedNotExpr {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
        }
    }

}
