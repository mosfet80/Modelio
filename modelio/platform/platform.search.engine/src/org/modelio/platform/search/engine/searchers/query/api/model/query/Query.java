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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenQuery;

/**
 * Top-level Modelio Query Language AST (Abstract Syntax Tree).
 * <p>
 * A Query represents a complete MQL (Modelio Query Language) query to be executed
 * against a model graph. It consists of:
 * <ul>
 * <li>A source: the initial collection of elements to process</li>
 * <li>A pipeline: a sequence of steps transforming the element stream</li>
 * <li>Execution limits: bounds for performance (timeout, depth, result count)</li>
 * </ul>
 * <p>
 */
@objid ("008a33dd-43cb-4da4-b612-280255bbbf46")
public class Query {
    @objid ("d439028f-76be-4e2e-887b-2ef1ddf274d8")
    private int version;

    /**
     * Current MQL version.
     */
    @objid ("bbdd0510-bbd6-44c1-80ce-d9be44c34612")
    public static final int VERSION = 1;

    @objid ("6c8e6975-2a19-4d96-a3f0-547ccf42ce12")
    private Source source;

    @objid ("71403f27-0cb8-4841-a08c-fc8bb85a9aa8")
    private List<Step> steps;

    @objid ("145953d7-cee6-4a61-be08-f22e208f52b0")
    private LimitsSpec limits;

    /**
     * Constructor with default version.
     * <p>
     * Creates a query with the current MQL version.
     *
     * @param source initial element collection (e.g., all Class, or provided elements)
     * @param steps pipeline steps transforming the element stream (Filter, Traverse, Union, Repeat, etc.)
     * @param limits execution limits (maxDepth, limit, timeoutMs)
     * @throws IllegalArgumentException if any parameter is null
     */
    @objid ("7377edc0-f2d1-4908-898a-3dafe4f2bf59")
    public Query(Source source, List<Step> steps, LimitsSpec limits) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        if (steps == null) {
            throw new IllegalArgumentException("steps must not be null");
        }
        if (limits == null) {
            throw new IllegalArgumentException("limits must not be null");
        }
        this.version = VERSION;
        this.source = source;
        this.steps = new ArrayList<>(steps);
        this.limits = limits;
    }

    /**
     * Full constructor with explicit version.
     * <p>
     * Creates a query with a specific MQL version. Currently only VERSION = 1 is supported.
     *
     * @param version query AST version (must be VERSION = 1)
     * @param source initial element collection
     * @param steps pipeline steps transforming the element stream
     * @param limits execution limits
     * @throws IllegalArgumentException if version is not VERSION, or any other parameter is null
     */
    @objid ("afb1b0c4-d21c-4c2e-96cd-f0358504a45f")
    public Query(int version, Source source, List<Step> steps, LimitsSpec limits) {
        if (version != VERSION) {
            throw new IllegalArgumentException("Unsupported query version: " + version);
        }
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        if (steps == null) {
            throw new IllegalArgumentException("steps must not be null");
        }
        if (limits == null) {
            throw new IllegalArgumentException("limits must not be null");
        }
        this.version = version;
        this.source = source;
        this.steps = new ArrayList<>(steps);
        this.limits = limits;
    }

    /**
     * Copy constructor.
     * <p>
     * Creates a deep copy of the query, including all steps and nested expressions.
     *
     * @param other the query to copy
     */
    @objid ("3ece10dc-713d-42a0-a184-2f95b7e606b2")
    public Query(Query other) {
        this.version = other.version;
        this.source = other.source.deepCopy();
        this.steps = other.steps.stream()
            .map(Step::deepCopy)
            .collect(ArrayList::new, List::add, List::addAll);
        this.limits = other.limits.deepCopy();
    }

    /**
     * Constructor from frozen (immutable) version.
     * <p>
     * Converts an immutable {@link FrozenQuery} back to its mutable form.
     * This is typically used during deserialization from JSON.
     *
     * @param frozen the frozen query to thaw.
     * @throws NullPointerException if frozen is null
     */
    @objid ("d5bafd03-afd7-471f-a8cc-e14c3a65b0bb")
    public Query(FrozenQuery frozen) {
        this.version = frozen.version();
        this.source = Conversions.toMutable(frozen.source());
        this.steps = frozen.steps().stream()
            .map(Conversions::toMutable)
            .collect(ArrayList::new, List::add, List::addAll);
        this.limits = new LimitsSpec(frozen.limits());
    }

    /**
     * Gets the MQL version of this query.
     *
     * @return the version
     */
    @objid ("175e76b8-983d-4eee-8226-fa05be7c0b14")
    public int getVersion() {
        return this.version;
    }

    /**
     * Gets the source specification for initial elements.
     * <p>
     * The source defines how to populate the initial element stream:
     * <ul>
     * <li> {@link AllSource}: iterate all elements matching a kind (metaclass or stereotype)</li>
     * <li> {@link ProvidedSource}: start from a collection provided by API integration</li>
     * </ul>
     *
     * @return the source specification
     */
    @objid ("4e6e9eea-69ea-4747-a8f7-0556312ae65b")
    public Source getSource() {
        return this.source;
    }

    /**
     * Sets the source specification.
     *
     * @param source the source to set
     * @throws IllegalArgumentException if source is null
     */
    @objid ("9b5bd2d7-a9c8-43c3-bca6-4bb21b8998f5")
    public void setSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        this.source = source;
    }

    /**
     * Gets the pipeline steps.
     * <p>
     * The steps are applied sequentially to transform the element stream:
     * <ul>
     * <li>FilterStep: filter elements by predicate</li>
     * <li>TraverseStep: traverse graph edges</li>
     * <li>UnionStep: combine alternative branches</li>
     * <li>RepeatStep: recursive traversal with cycle safety</li>
     * </ul>
     *
     * @return the list of pipeline steps
     */
    @objid ("2bd54104-ca3d-4693-a3ea-daab6ef492f3")
    public List<Step> getSteps() {
        return this.steps;
    }

    /**
     * Adds a step to the pipeline.
     *
     * @param step the step to add
     * @throws IllegalArgumentException if step is null
     */
    @objid ("2433cf5e-d51e-48f8-a3e3-b385c6cdf4d8")
    public void addStep(Step step) {
        if (step == null) {
            throw new IllegalArgumentException("step must not be null");
        }
        this.steps.add(step);
    }

    /**
     * Removes a step from the pipeline by index.
     *
     * @param index the position of the step to remove
     */
    @objid ("2d58c81b-0b29-4e9d-abc0-c261fe4a594d")
    public void removeStep(int index) {
        this.steps.remove(index);
    }

    /**
     * Replaces all pipeline steps.
     *
     * @param steps the new sequence of steps
     * @throws IllegalArgumentException if steps is null
     */
    @objid ("004744c5-5da5-4f19-9f3e-209d50b24374")
    public void setSteps(List<Step> steps) {
        if (steps == null) {
            throw new IllegalArgumentException("steps must not be null");
        }
        this.steps = new ArrayList<>(steps);
    }

    /**
     * Gets the execution limits.
     * <p>
     * Limits control query execution boundaries:
     * <ul>
     * <li>maxDepth: maximum recursion depth for Repeat steps</li>
     * <li>limit: maximum number of results to return</li>
     * <li>timeoutMs: hard wall time in milliseconds</li>
     * </ul>
     *
     * @return the execution limits specification
     */
    @objid ("64a1afbd-ca73-4c9c-9bec-39d4affb2c8e")
    public LimitsSpec getLimits() {
        return this.limits;
    }

    /**
     * Sets the execution limits.
     *
     * @param limits the limits to set
     * @throws IllegalArgumentException if limits is null
     */
    @objid ("f559aa83-235a-478f-8c42-b626250de79c")
    public void setLimits(LimitsSpec limits) {
        if (limits == null) {
            throw new IllegalArgumentException("limits must not be null");
        }
        this.limits = limits;
    }

    /**
     * Convert to frozen (immutable) version.
     * <p>
     * Returns an immutable representation suitable for serialization to JSON
     * or for passing to the execution engine.
     *
     * @return the frozen (immutable) query
     */
    @objid ("4b89aa2e-ab9a-4e6e-92b4-c6cf194e8706")
    public FrozenQuery freeze() {
        return new FrozenQuery(
            this.version,
            Conversions.toFrozen(this.source),
            this.steps.stream()
                .map(Step::freeze)
                .collect(ArrayList::new, List::add, List::addAll),
            this.limits.freeze()
        );
    }

    /**
     * Creates a deep copy of this query.
     * <p>
     * All nested objects (source, steps, limits) are recursively deep-copied.
     *
     * @return a new independent copy of this query
     */
    @objid ("c00ba626-2d7f-41d9-9339-0b0edb788e2f")
    public Query deepCopy() {
        return new Query(this);
    }

}
