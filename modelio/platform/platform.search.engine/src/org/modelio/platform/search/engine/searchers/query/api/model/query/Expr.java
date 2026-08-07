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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenExpr;

/**
 * Expression: used for predicates and boolean logic in MQL queries.
 * <p>
 * Expressions are the building blocks of filter predicates and conditions.
 * They evaluate to boolean values and are used in:
 * <ul>
 * <li>{@link FilterStep}: to filter elements in the stream</li>
 * <li>{@link TraverseStep}: as optional edge filters</li>
 * <li>{@link ExistsExpr}: as optional where clauses</li>
 * </ul>
 * <p>
 * Expression types:
 * <ul>
 * <li>{@link AndExpr}, {@link OrExpr}, {@link NotExpr}: Logical operators</li>
 * <li>{@link CompareExpr}: Binary comparisons (=, !=, <, >, <=, >=, contains, startsWith)</li>
 * <li>{@link IsExpr}: Type/kind checking (is Class, is Stereotype)</li>
 * <li>{@link ExistsExpr}: Path existence checking (optional in v1)</li>
 * </ul>
 * <p>
 * Expressions are mutable during query construction.
 *
 * @see AndExpr
 * @see OrExpr
 * @see NotExpr
 * @see CompareExpr
 * @see IsExpr
 * @see ExistsExpr
 */
@objid ("d640b6b8-6174-4ee1-b002-bff3d853f6d4")
public sealed interface Expr permits AndExpr, OrExpr, NotExpr, CompareExpr, IsExpr, ExistsExpr {
    /**
     * Create a deep copy of this expression.
     * <p>
     * The copy is independent and can be modified without affecting the original.
     *
     * @return a new independent copy of this expression
     */
    @objid ("0b0e58e5-0a8c-44c3-8005-9cdc392c380f")
    Expr deepCopy();

    @objid ("d58ed784-17e3-474c-a070-6ed338ee4146")
    FrozenExpr freeze();

}
