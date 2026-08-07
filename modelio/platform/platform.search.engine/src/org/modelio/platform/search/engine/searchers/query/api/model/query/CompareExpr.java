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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenCompareExpr;

/**
 * Mutable binary comparison expression.
 * <p>
 * Supported operators:
 * <ul>
 * <li>{@code =} : equality (string, number, bool)</li>
 * <li>{@code !=} : inequality</li>
 * <li>{@code <, >, <=, >=} : numeric comparison</li>
 * <li>{@code contains} : string containment (substring) or collection membership</li>
 * <li>{@code startsWith} : string prefix match</li>
 * </ul>
 * <p>
 * Numeric comparison semantics:
 * <ul>
 * <li>If types are not numeric, engine emits an error diagnostic and evaluates to false</li>
 * <li>If types are mixed (string and number) or undetermined, engine evaluates only
 * numeric comparisons and yields false for non-numeric values</li>
 * </ul>
 */
@objid ("92c548eb-1b9d-416b-bc94-6b782625e154")
public final class CompareExpr implements Expr {
    @objid ("6957db9f-5505-4bde-8b3e-8d4eb10dd113")
    private String op;

    @objid ("2137e1dc-eb99-496d-b11b-f46f6aa6650b")
    private ValueExpr left;

    @objid ("7698597b-983e-4c26-8d23-a39dbc11be7e")
    private ValueExpr right;

    /**
     * Constructor.
     *
     * @param op operator: {@code =, !=, <, >, <=, >=, contains, startsWith}
     * @param left left operand
     * @param right right operand
     * @throws IllegalArgumentException if op, left, or right is null
     */
    @objid ("edcc620d-a9e1-4324-979f-6fcd60b82668")
    public CompareExpr(String op, ValueExpr left, ValueExpr right) {
        if (op == null || op.isBlank()) {
            throw new IllegalArgumentException("op must not be null/blank");
        }
        if (left == null) {
            throw new IllegalArgumentException("left must not be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("right must not be null");
        }
        this.op = op;
        this.left = left;
        this.right = right;
    }

    /**
     * Copy constructor.
     *
     * @param other the CompareExpr to copy
     */
    @objid ("833d0144-d33c-4294-824b-143e52b9f252")
    public CompareExpr(CompareExpr other) {
        this.op = other.op;
        this.left = other.left.deepCopy();
        this.right = other.right.deepCopy();
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen CompareExpr
     */
    @objid ("304b34b8-805b-40ee-9d73-e1f6ed2b88b9")
    public CompareExpr(FrozenCompareExpr frozen) {
        this.op = frozen.op();
        this.left = Conversions.toMutable(frozen.left());
        this.right = Conversions.toMutable(frozen.right());
    }

    /**
     * Gets the comparison operator.
     *
     * @return the operator string
     */
    @objid ("ea89ac11-9c46-4448-b982-cb4b3f52b69b")
    public String getOp() {
        return this.op;
    }

    /**
     * Sets the comparison operator.
     *
     * @param op the operator: {@code =, !=, <, >, <=, >=, contains, startsWith}
     * @throws IllegalArgumentException if op is null or blank
     */
    @objid ("0d8321be-f070-40b9-8b38-0573f0406a6f")
    public void setOp(String op) {
        if (op == null || op.isBlank()) {
            throw new IllegalArgumentException("op must not be null/blank");
        }
        this.op = op;
    }

    /**
     * Gets the left operand.
     *
     * @return the left value expression
     */
    @objid ("5d2d4a19-a627-43be-9871-409b65c45c5f")
    public ValueExpr getLeft() {
        return this.left;
    }

    /**
     * Sets the left operand.
     *
     * @param left the left value expression
     * @throws IllegalArgumentException if left is null
     */
    @objid ("a02e17f3-0e78-44e9-807d-990fbd7f5e92")
    public void setLeft(ValueExpr left) {
        if (left == null) {
            throw new IllegalArgumentException("left must not be null");
        }
        this.left = left;
    }

    /**
     * Gets the right operand.
     *
     * @return the right value expression
     */
    @objid ("cee261bb-6012-42f4-9f94-c23c973360c2")
    public ValueExpr getRight() {
        return this.right;
    }

    /**
     * Sets the right operand.
     *
     * @param right the right value expression
     * @throws IllegalArgumentException if right is null
     */
    @objid ("bc8174ed-c2d9-48e6-a9b9-3e9c7c1413f1")
    public void setRight(ValueExpr right) {
        if (right == null) {
            throw new IllegalArgumentException("right must not be null");
        }
        this.right = right;
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this compare expression
     */
    @objid ("536d0faa-0edf-4bec-84fe-d2baff240f40")
    @Override
    public FrozenCompareExpr freeze() {
        return new FrozenCompareExpr(this.op, this.left.freeze(), this.right.freeze());
    }

    @objid ("72d3b26b-cf3c-4a19-bdaa-289a85cc22ba")
    @Override
    public CompareExpr deepCopy() {
        return new CompareExpr(this);
    }

}
