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
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueType;

/**
 * Internal, resolved value expression.
 */
@objid ("4a68c574-c4f8-48f9-8701-352822ba47ee")
public sealed interface ResolvedValueExpr permits ResolvedPropertyValueExpr, org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr.LiteralValueExpr, org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr.UnsupportedValueExpr {
    /**
     * Resolved literal value.
     */
    @objid ("237d0428-738c-42af-8e7e-74350ea91d70")
    record LiteralValueExpr ( ValueType valueType,
            Object value )  implements ResolvedValueExpr {
        @objid ("7b3c3d69-2cb5-40dd-9765-4baa59510705")
        public LiteralValueExpr {
            if (valueType == null) {
                throw new IllegalArgumentException("valueType must not be null");
            }
        }

    }

    /**
     * Placeholder for value expressions not yet represented in the resolved model.
     */
    @objid ("89138d87-438c-49af-9653-707111331745")
    record UnsupportedValueExpr ( String description )  implements ResolvedValueExpr {
        @objid ("6922f3a5-8085-4c9d-bbab-b364796c6fcd")
        public UnsupportedValueExpr {
            if (description == null || description.isBlank()) {
                throw new IllegalArgumentException("description must not be null/blank");
            }
        }

    }

}
