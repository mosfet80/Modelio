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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenNotExpr;

/**
 * Mutable expression: logical NOT (negation) of a sub-expression.
 * <p>
 * Inverts the truth value of the inner expression.
 */
@objid ("9a6d9a72-767d-4f96-b840-4a12c9eaa064")
public final class NotExpr implements Expr {
    @objid ("274c4501-0587-4d51-9909-5471eaa6d8dd")
    @JsonProperty(required = true)
    private Expr expr;

    /**
     * Constructor.
     *
     * @param expr the expression to negate
     * @throws IllegalArgumentException if expr is null
     */
    @objid ("a52379f3-4c72-481d-b425-f5ceba7046ed")
    public NotExpr(Expr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
        }
        this.expr = expr;
    }

    /**
     * Copy constructor.
     *
     * @param other the NotExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("0fe92aa3-5ac0-424f-8893-26fbd9231643")
    public NotExpr(NotExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.expr = other.expr.deepCopy();
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen NotExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("22d3c4a6-f5c2-4eb6-aee5-2d4b1d41dfeb")
    public NotExpr(FrozenNotExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.expr = Conversions.toMutable(frozen.expr());
    }

    /**
     * Gets the inner expression.
     *
     * @return the expression to negate
     */
    @objid ("b52fb9f8-8d02-4287-be29-d9324259c0c2")
    public Expr getExpr() {
        return this.expr;
    }

    /**
     * Sets the inner expression.
     *
     * @param expr the expression to negate
     * @throws IllegalArgumentException if expr is null
     */
    @objid ("33e1cdf7-2d29-4c3e-9050-b92c2b085235")
    public void setExpr(Expr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
        }
        this.expr = expr;
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this NOT expression
     */
    @objid ("58ac61d6-23fa-4c38-b9af-dfc540f0c066")
    @Override
    public FrozenNotExpr freeze() {
        return new FrozenNotExpr(this.expr.freeze());
    }

    @objid ("42396fdf-1ec0-4391-8ebc-e13c3654112d")
    @Override
    public NotExpr deepCopy() {
        return new NotExpr(this);
    }

}
