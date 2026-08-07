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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenFilterStep;

/**
 * Mutable step: filters the current node stream based on a predicate.
 * <p>
 * FilterStep reduces the element stream by applying a boolean predicate to each node.
 * Only nodes for which the predicate evaluates to true are passed to the next step.
 * <p>
 * The predicate (where clause) can be any expression including:
 * <ul>
 * <li>Comparison expressions: {@code name = "Customer"}, {@code count > 5}</li>
 * <li>Kind/type checks: {@code is Class}</li>
 * <li>Logical combinations: {@code AND, OR, NOT}</li>
 * <li>Existence checks: {@code exists in steps}</li>
 * </ul>
 * <p>
 * If multiple definitions exist for property keys or operators in the predicate,
 * the execution is the UNION of all alternatives, with warnings added to diagnostics.
 */
@objid ("8caef46e-ba6a-4702-af7f-5b916bbb5ae6")
public final class FilterStep implements Step {
    /**
     * The filter predicate expression.
     */
    @objid ("f7001eed-4e5e-4964-91cd-aaab9a83c06e")
    private Expr where;

    /**
     * Constructor.
     * <p>
     * Creates a filter step that applies the given predicate expression to each node
     * in the current stream.
     *
     * @param where the predicate expression to evaluate (must not be null)
     * @throws IllegalArgumentException if where is null
     */
    @objid ("29584b3f-5b0d-4f43-9917-cf0d5507c205")
    public FilterStep(Expr where) {
        if (where == null) {
            throw new IllegalArgumentException("where must not be null");
        }
        this.where = where;
    }

    /**
     * Copy constructor.
     * <p>
     * Creates a deep copy of the filter step, including the predicate expression.
     *
     * @param other the FilterStep to copy
     */
    @objid ("cb80fdf0-037b-4f69-9170-87374bc5782f")
    public FilterStep(FilterStep other) {
        this.where = other.where.deepCopy();
    }

    /**
     * Constructor from frozen (immutable) version.
     * <p>
     * Converts an immutable FrozenFilterStep back to its mutable form.
     * This is typically used during deserialization from JSON.
     *
     * @param frozen the frozen filter step to thaw
     */
    @objid ("cac03fcf-a26e-4036-a26e-5cb636ff69e0")
    public FilterStep(FrozenFilterStep frozen) {
        this.where = Conversions.toMutable(frozen.where());
    }

    /**
     * Gets the filter predicate expression.
     * <p>
     * The expression is evaluated against each node in the current stream.
     * Nodes that satisfy the expression are kept; others are discarded.
     *
     * @return the where clause expression
     */
    @objid ("5ec79a89-e3a9-4fe3-a292-8158fc304c3f")
    public Expr getWhere() {
        return this.where;
    }

    /**
     * Sets the filter predicate expression.
     *
     * @param where the where clause expression (must not be null)
     * @throws IllegalArgumentException if where is null
     */
    @objid ("898473fc-498b-4e65-8029-ad5e8568900f")
    public void setWhere(Expr where) {
        if (where == null) {
            throw new IllegalArgumentException("where must not be null");
        }
        this.where = where;
    }

    /**
     * Convert to frozen (immutable) version.
     * <p>
     * Returns an immutable representation suitable for serialization to JSON
     * or for passing to the execution engine.
     *
     * @return the frozen (immutable) filter step
     */
    @objid ("eaebd739-a49e-4a03-b80a-eec077534b03")
    @Override
    public FrozenFilterStep freeze() {
        return new FrozenFilterStep(this.where.freeze());
    }

    /**
     * Creates a deep copy of this filter step.
     * <p>
     * The predicate expression is recursively deep-copied.
     *
     * @return a new independent copy of this filter step
     */
    @objid ("3eb4fa7d-8a58-455d-a4e1-660f1d297f64")
    @Override
    public FilterStep deepCopy() {
        return new FilterStep(this);
    }

    @objid ("f891f61f-d10c-483a-9111-4e0ead65fcaf")
    public enum FilerStepKind {
        @objid ("b6899f40-6639-4a60-b37b-a45536314ab4")
        PROPERTY,
        @objid ("6f0c823d-4be8-4db7-865b-ef1d582b8a8c")
        KIND,
        @objid ("74f23db8-e53f-41b8-9edd-56be8baa30cc")
        COMPOSITE,
        @objid ("415b475f-dbba-4c00-b4df-ecd5954f5b85")
        UNDEFINED;

    }

}
