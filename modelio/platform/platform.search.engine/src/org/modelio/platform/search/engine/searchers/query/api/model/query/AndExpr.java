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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenAndExpr;

/**
 * Mutable expression: logical AND of multiple sub-expressions.
 * <p>
 * All sub-expressions must evaluate to true for the entire AND to be true.
 */
@objid ("9a16c759-019e-4468-968a-d19e90c3a37c")
public final class AndExpr implements Expr {
    @objid ("32c2e289-5406-4618-9e80-5472a8ef4cf5")
    private List<Expr> exprs;

    /**
     * Constructor.
     *
     * @param exprs the list of expressions to AND together
     * @throws IllegalArgumentException if exprs is null
     */
    @objid ("66b5882f-336a-4ded-b106-8607efd19f8c")
    public AndExpr(List<Expr> exprs) {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs cannot be null");
        }
        this.exprs = new ArrayList<>(exprs);
    }

    /**
     * Copy constructor.
     *
     * @param other the AndExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("d285ed25-94dc-40bb-9dbc-13dc206c9249")
    public AndExpr(AndExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other cannot be null");
        }
        this.exprs = other.exprs.stream()
            .map(Expr::deepCopy)
            .collect(ArrayList::new, List::add, List::addAll);
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen AndExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("a9c24681-a168-4333-98dc-846a6ffc8915")
    public AndExpr(FrozenAndExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen cannot be null");
        }
        this.exprs = Conversions.thawExprList(frozen.exprs());
    }

    /**
     * Gets the sub-expressions.
     *
     * @return the list of expressions
     */
    @objid ("90bfdba1-92fb-4224-9fe2-b421f4ac7892")
    public List<Expr> getExprs() {
        return this.exprs;
    }

    /**
     * Sets the sub-expressions.
     *
     * @param exprs the list of expressions
     * @throws IllegalArgumentException if exprs is null
     */
    @objid ("ed394b6b-4325-4b2c-9bc4-f12b63ff8c19")
    public void setExprs(List<Expr> exprs) {
        if (exprs == null) {
            throw new IllegalArgumentException("exprs cannot be null");
        }
        this.exprs = new ArrayList<>(exprs);
    }

    /**
     * Adds a sub-expression.
     *
     * @param expr the expression to add
     * @throws IllegalArgumentException if expr is null
     */
    @objid ("29c0617f-6191-4177-9557-fbcd03e7ae45")
    public void addExpr(Expr expr) {
        if (expr == null) {
            throw new IllegalArgumentException("expr cannot be null");
        }
        this.exprs.add(expr);
    }

    /**
     * Removes a sub-expression.
     *
     * @param index the index of the expression to remove
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @objid ("198c278b-e80b-4938-8784-938941342af7")
    public void removeExpr(int index) {
        if (index < 0 || index >= this.exprs.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        this.exprs.remove(index);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this AND expression
     */
    @objid ("84a41187-ecf3-4992-b263-ef622d93de54")
    @Override
    public FrozenAndExpr freeze() {
        return new FrozenAndExpr(Conversions.freezeExprList(this.exprs));
    }

    @objid ("2f198144-8e9c-44fb-b0d2-7c3cd517de45")
    @Override
    public AndExpr deepCopy() {
        return new AndExpr(this);
    }

}
