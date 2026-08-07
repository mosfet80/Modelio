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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenTraverseStep;

/**
 * Step: traverses one edge in the model graph.
 * <p>
 * An edge can be:
 * <ul>
 * <li>A Link metaclass (e.g., "Generalization", "Dependency")</li>
 * <li>A Stereotype that applies to a link metaclass</li>
 * <li>A structural relation (MDependency) by its dependency name</li>
 * <li>A composition relation by target metaclass</li>
 * </ul>
 * <p>
 * If multiple interpretations are valid, execution is the UNION of all alternatives
 * and a warning is emitted in diagnostics.
 * <p>
 * Traversal direction can be controlled:
 * <ul>
 * <li>"forward": traverses in the natural direction defined by the link type</li>
 * <li>"backward": traverses the opposite direction</li>
 * <li>null: equivalent to forward</li>
 * </ul>
 * <p>
 * For link model objects, the engine determines source and target endpoints using
 * metamodel queries, then traverses to neighbor nodes accordingly.
 * <p>
 * The optional edgeFilter applies to the link object itself (because link is an MObject).
 */
@objid ("4e50ab4f-031f-4601-a3ae-733629a88f01")
public final class TraverseStep implements Step {
    @objid ("62f47417-0fb2-4d45-889c-858d9f65ad76")
    private String edge;

    @objid ("b4e493c5-086a-4c09-a180-cd06cebcfe50")
    private Direction direction;

    @objid ("19d65516-f1d2-4e8f-b497-0aedacfca1aa")
    private Expr edgeFilter;

    /**
     * Constructor with edge reference only.
     *
     * @param edge the edge reference (metaclass, stereotype, or relation name)
     * @throws IllegalArgumentException if edge is null or blank
     */
    @objid ("626e0e7e-f3b8-4906-bf3e-6acf6c8ec5c0")
    public TraverseStep(String edge) {
        this.edge = edge != null ? edge : "";
        this.edgeFilter = null;
        this.direction = null;
    }

    /**
     * Constructor with edge, optional filter and direction.
     *
     * @param edge the edge reference (metaclass, stereotype, or relation name)
     * @param edgeFilter optional predicate to apply to the link object itself, may be null
     * @param direction optional traversal direction (forward/backward), may be null
     * @throws IllegalArgumentException if edge is null or blank
     */
    @objid ("3d21c4f0-4427-47d3-bab8-3e2f28e34a05")
    public TraverseStep(String edge, Expr edgeFilter, Direction direction) {
        this.edge = edge != null ? edge : "";
        this.edgeFilter = edgeFilter;
        this.direction = direction ;
    }

    /**
     * Copy constructor.
     *
     * @param other the TraverseStep to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("102a74c8-da5d-454e-9512-f58364ced3e7")
    public TraverseStep(TraverseStep other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.edge = other.edge;
        this.edgeFilter = other.edgeFilter != null ? other.edgeFilter.deepCopy() : null;
        this.direction = other.direction;
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen TraverseStep
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("855fd4c4-ce03-4262-891d-9dfcdb222ce9")
    public TraverseStep(FrozenTraverseStep frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.edge = frozen.edge();
        this.edgeFilter = frozen.edgeFilter() != null ? Conversions.toMutable(frozen.edgeFilter()) : null;

        this.direction = frozen.direction();
    }

    /**
     * Gets the edge reference (metaclass, stereotype, or relation name).
     *
     * @return the edge reference
     */
    @objid ("abc0db96-219d-41c1-932e-81209b58f5e4")
    public String getEdge() {
        return this.edge;
    }

    /**
     * Sets the edge reference.
     *
     * @param edge the edge reference
     * @throws IllegalArgumentException if edge is null or blank
     */
    @objid ("4e982b9d-d4f2-4700-952b-27bba207db8c")
    public void setEdge(String edge) {
        this.edge = edge != null ? edge : "";
    }

    /**
     * Gets the optional edge filter predicate.
     *
     * @return the edge filter expression, or null if not specified
     */
    @objid ("56cb3d66-f21e-48bd-a4fc-f47c314c9a96")
    public Expr getEdgeFilter() {
        return this.edgeFilter;
    }

    /**
     * Sets the edge filter predicate.
     *
     * @param edgeFilter the filter expression, or null to clear
     */
    @objid ("9bf5462b-0e3e-4e40-a2d6-6fea93e37a1f")
    public void setEdgeFilter(Expr edgeFilter) {
        this.edgeFilter = edgeFilter;
    }

    /**
     * Gets the traversal direction.
     *
     * @return the direction (FORWARD, BACKWARD), or FORWARD for default
     */
    @objid ("7e0f1c94-3c27-499e-9231-8b0e9befc46f")
    public Direction getDirection() {
        return this.direction != null ? this.direction : Direction.FORWARD;
    }

    /**
     * Sets the traversal direction.
     *
     * @param direction the direction (FORWARD, BACKWARD), or null for default
     */
    @objid ("3a308ea0-e614-4e84-adf6-2175532a9728")
    public void setDirection(Direction direction) {
        this.direction = direction ;
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this traverse step
     */
    @objid ("5621e6b8-d7cd-4d76-847b-558caa07de1d")
    @Override
    public FrozenTraverseStep freeze() {
        return new FrozenTraverseStep(
                    this.edge,
                    this.direction,
                    this.edgeFilter != null ? this.edgeFilter.freeze() : null);
    }

    @objid ("49cf5a93-a03d-4005-8d06-d8b2483d111e")
    @Override
    public TraverseStep deepCopy() {
        return new TraverseStep(this);
    }

}
