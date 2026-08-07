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
package org.modelio.platform.search.engine.searchers.query.api.model.query;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenValueExpr;

/**
 * Value expression: produces values used in comparison and computation.
 * <p>
 * Value expressions represent the operands in comparison expressions and can be:
 * <ul>
 * <li>{@link PropertyValueExpr}: Access element properties (attributes, tags, notes, properties)</li>
 * <li>{@link LiteralValueExpr}: Literal constant values (string, number, boolean)</li>
 * </ul>
 * <p>
 * Value expressions are used as the left and right operands in {@link CompareExpr}.
 *
 * @see PropertyValueExpr
 * @see LiteralValueExpr
 * @see CompareExpr
 */
@objid ("77d17864-0607-4801-9e5a-cdfe1a0cdac2")
public sealed interface ValueExpr permits PropertyValueExpr, LiteralValueExpr {
    /**
     * Create a deep copy of this value expression.
     * <p>
     * The copy is independent and can be modified without affecting the original.
     *
     * @return a new independent copy of this value expression
     */
    @objid ("769bf02c-dd67-426e-b24c-3aaa81ef72c8")
    ValueExpr deepCopy();

    /**
     * Freeze this value expression into an immutable form.
     *
     * @return the immutable version of this value expression.
     */
    @objid ("55fde81d-2617-4a4e-a799-a6a02d56b0dd")
    FrozenValueExpr freeze();

}
