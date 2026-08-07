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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenStep;

/**
 * Pipeline step: transforms the element stream in an MQL query.
 * <p>
 * Steps are the main building blocks of the query pipeline. They process
 * the current stream of model elements and produce a new stream for the next step.
 * <p>
 * Available step types:
 * <ul>
 * <li>{@link FilterStep}: Filters elements based on a predicate expression</li>
 * <li>{@link TraverseStep}: Traverses edges (links or relations) to reach neighbor elements</li>
 * <li>{@link UnionStep}: Combines results from multiple alternative branches</li>
 * <li>{@link RepeatStep}: Recursively applies a sequence of steps until no new elements are found</li>
 * </ul>
 * <p>
 * Steps are mutable during query construction and can be converted to immutable
 * frozen representations for execution and serialization with {@link #freeze()}.
 *
 * @see FilterStep
 * @see TraverseStep
 * @see UnionStep
 * @see RepeatStep
 */
@objid ("21dd68d7-79d3-4843-985a-c3ef3a768786")
public sealed interface Step permits FilterStep, TraverseStep, UnionStep, RepeatStep {
    /**
     * Create a deep copy of this step.
     * <p>
     * The copy is independent and can be modified without affecting the original.
     *
     * @return a new independent copy of this step
     */
    @objid ("61164562-d1d9-4a32-98f7-77f6bd28cd41")
    Step deepCopy();

    /**
     * Convert to frozen (immutable) version.
     * <p>
     * The frozen version is suitable for execution and JSON serialization.
     * This is typically called before passing the query to the execution engine.
     *
     * @return the immutable frozen step
     */
    @objid ("b9805461-0f3a-4bdf-80db-7b7dd81f3567")
    FrozenStep freeze();

}
