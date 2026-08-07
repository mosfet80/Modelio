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
 * Internal, resolved predicate expression.
 * <p>
 * This is intentionally minimal and will be expanded in later phases.
 */
@objid ("4d50f1f3-6ff4-4d3c-b471-80f78f61bfcf")
public sealed interface ResolvedExpr permits ResolvedAndExpr, ResolvedOrExpr, ResolvedNotExpr, ResolvedExistsExpr, ResolvedIsExpr, ResolvedCompareExpr, org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExpr.UnsupportedExpr {
    /**
     * Placeholder for expressions not yet represented in the resolved model.
     */
    @objid ("7c3187d0-683d-4424-ac82-83aaa9cb99c1")
    record UnsupportedExpr ( String description )  implements ResolvedExpr {
        @objid ("923aac2c-0180-4d22-8d7f-5438bc04f5e4")
        public UnsupportedExpr {
            if (description == null || description.isBlank()) {
                throw new IllegalArgumentException("description must not be null/blank");
            }
        }

    }

}
