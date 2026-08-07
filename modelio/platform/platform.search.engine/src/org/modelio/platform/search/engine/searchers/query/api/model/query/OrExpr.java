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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenOrExpr;

/**
 * Mutable expression: logical OR of multiple sub-expressions.
 * <p>
 * At least one sub-expression must evaluate to true for the entire OR to be true.
 */
@objid ("fbc02597-7340-45af-98e4-f2583c0d5bee")
public final class OrExpr implements Expr {
    @objid ("64934a0b-a209-43ce-8e15-086de0baea60")
    private List<Expr> exprs;

    /**
     * Constructor.
     *
     * @param exprs the list of expressions to OR together
     * @throws IllegalArgumentException if exprs is null
     */
    @objid ("70c06c21-f6b5-4a32-8898-6491c44ff213")
    public OrExpr(List<Expr> exprs) {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs must not be null");
        }
        this.exprs = new ArrayList<>(exprs);
    }

    /**
     * Copy constructor.
     *
     * @param other the OrExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("26b634e9-c9ed-4d41-8d1c-c4fc9ad683b6")
    public OrExpr(OrExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.exprs = other.exprs.stream()
            .map(Expr::deepCopy)
            .collect(ArrayList::new, List::add, List::addAll);
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen OrExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("ce69dc64-1d5e-4a00-bd90-3b93481f3b7b")
    public OrExpr(FrozenOrExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.exprs = Conversions.thawExprList(frozen.exprs());
    }

    /**
     * Gets the sub-expressions.
     *
     * @return the list of expressions
     */
    @objid ("64350e6b-302a-461c-9f48-05cb64382495")
    public List<Expr> getExprs() {
        return this.exprs;
    }

    /**
     * Sets the sub-expressions.
     *
     * @param exprs the list of expressions
     * @throws IllegalArgumentException if exprs is null
     */
    @objid ("c8ca35a5-96e9-4d18-a3a9-e9c2c032fa2b")
    public void setExprs(List<Expr> exprs) {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs must not be null");
        }
        this.exprs = new ArrayList<>(exprs);
    }

    /**
     * Adds a sub-expression.
     *
     * @param expr the expression to add
     */
    @objid ("825115b4-b922-4cac-bde0-ddf1da33a4f8")
    public void addExpr(Expr expr) {
        this.exprs.add(expr);
    }

    /**
     * Removes a sub-expression.
     *
     * @param index the index of the expression to remove
     */
    @objid ("b8612b11-9305-497c-ac48-25b740aa639e")
    public void removeExpr(int index) {
        this.exprs.remove(index);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this OR expression
     */
    @objid ("72902106-4698-41cf-99c9-11058ffec0aa")
    @Override
    public FrozenOrExpr freeze() {
        return new FrozenOrExpr(Conversions.freezeExprList(this.exprs));
    }

    @objid ("002d6399-cf31-43d3-8d2a-2fe75aff52a0")
    @Override
    public OrExpr deepCopy() {
        return new OrExpr(this);
    }

}
