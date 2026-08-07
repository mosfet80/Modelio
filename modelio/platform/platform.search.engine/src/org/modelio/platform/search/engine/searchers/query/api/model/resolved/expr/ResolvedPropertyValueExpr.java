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
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty;

/**
 * Resolved property value expression.
 */
@objid ("3e92d8b7-6607-4a41-b146-3a71e0bfe45e")
public record ResolvedPropertyValueExpr ( ResolvedProperty key )  implements ResolvedValueExpr {
    @objid ("5d3391a4-3fba-4064-b17e-8078a2352588")
    public ResolvedPropertyValueExpr {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
    }

}
