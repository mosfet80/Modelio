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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenExistsExpr;

/**
 * Exist expression: tests whether a path exists matching inner steps.
 * <p>
 * This expression allows checking for the existence of reachable nodes
 * via a sequence of traversal steps, optionally filtered by a where clause.
 * <p>
 * The expression evaluates to true if at least one path through the steps
 * starting from the current node exists and satisfies the optional where predicate.
 * <p>
 * Note: This is an optional feature in v1; full support is planned for v2.
 */
@objid ("45ca066c-c895-429c-ab92-37c5da2de866")
public final class ExistsExpr implements Expr {
    @objid ("81a22ad2-58c3-4bb4-827a-1075d2948d75")
    private List<Step> in;

    @objid ("72f4ca2f-b407-472d-9446-3dbf03abd784")
    private Expr where;

    /**
     * Exist expression constructor with steps only.
     *
     * @param in the sequence of traversal steps
     * @throws IllegalArgumentException if in is null
     */
    @objid ("9748bb9e-3b65-4b63-865b-f2797e1b0977")
    public ExistsExpr(List<Step> in) {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        this.in = new ArrayList<>(in);
        this.where = null;
    }

    /**
     * Exist expression constructor with steps and optional where clause.
     *
     * @param in the sequence of traversal steps
     * @param where optional predicate to apply to reached elements, may be null
     * @throws IllegalArgumentException if in is null
     */
    @objid ("43366d7f-c82f-4fab-9b35-8ab92d281b4a")
    public ExistsExpr(List<Step> in, Expr where) {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        this.in = new ArrayList<>(in);
        this.where = where;
    }

    /**
     * Exist expression copy constructor.
     *
     * @param other the ExistsExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("867867c7-b367-4238-97f5-717df1b4b770")
    public ExistsExpr(ExistsExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.in = other.in.stream()
            .map(Step::deepCopy)
            .collect(ArrayList::new, List::add, List::addAll);
        this.where = other.where != null ? other.where.deepCopy() : null;
    }

    /**
     * Exist expression constructor from frozen (immutable) version.
     *
     * @param frozen the frozen ExistsExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("b69d7474-1ef0-48ad-a11e-0bb09592258b")
    public ExistsExpr(FrozenExistsExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.in = Conversions.thawStepList(frozen.in());
        this.where = frozen.where() != null ? Conversions.toMutable(frozen.where()) : null;
    }

    /**
     * Gets the traversal steps to check for existence.
     *
     * @return the sequence of steps
     */
    @objid ("422e1fa9-ea09-442f-a057-1bab66726327")
    public List<Step> getIn() {
        return this.in;
    }

    /**
     * Sets the traversal steps.
     *
     * @param in the sequence of steps
     * @throws IllegalArgumentException if in is null
     */
    @objid ("0070eff0-d751-48d9-af54-bfe7dc684bce")
    public void setIn(List<Step> in) {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        this.in = new ArrayList<>(in);
    }

    /**
     * Gets the optional where clause predicate.
     *
     * @return the where expression, or null if not specified
     */
    @objid ("c0ba667d-571e-4e62-a5d1-c9962c5b7eba")
    public Expr getWhere() {
        return this.where;
    }

    /**
     * Sets the where clause predicate.
     *
     * @param where the where expression, or null to clear
     */
    @objid ("4a7efaa6-f5c2-43a1-8bd4-00b5a733b88d")
    public void setWhere(Expr where) {
        this.where = where;
    }

    /**
     * Adds a step to the exists expression.
     *
     * @param step the step to add
     */
    @objid ("49347942-e73e-4976-9e28-198685a4e32b")
    public void addStep(Step step) {
        this.in.add(step);
    }

    /**
     * Removes a step from the exists expression.
     *
     * @param index the index of the step to remove
     */
    @objid ("04b909ff-2579-4304-adaa-2a4284972251")
    public void removeStep(int index) {
        this.in.remove(index);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this exists expression
     */
    @objid ("2a3097cb-b575-4b55-b221-6c8a80c7460f")
    @Override
    public FrozenExistsExpr freeze() {
        return new FrozenExistsExpr(
            Conversions.freezeStepList(this.in),
            this.where != null ? this.where.freeze() : null);
    }

    @objid ("1e7f2dbb-b572-43fd-81f2-bbdac8a0dbdf")
    @Override
    public ExistsExpr deepCopy() {
        return new ExistsExpr(this);
    }

}
