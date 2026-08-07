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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;

/**
 * Resolved, ambiguity-aware edge reference.
 * <p>
 * Edges can resolve to dependencies or link-object traversals, potentially with direction.
 */
@objid ("cc8bac45-84ab-4da3-bc63-3128524baa27")
public record ResolvedEdge ( List<org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge.EdgeAlternative> alternatives )  {
    @objid ("3a236ac3-e0b4-412f-b17e-13ebbf6ddaed")
    public static ResolvedEdge empty() {
        return new ResolvedEdge(List.of());
    }

    @objid ("dfd456d9-8178-49ac-950f-4b5e95c1c145")
    public boolean isUnknown() {
        return this.alternatives.isEmpty();
    }

    @objid ("aebcdb1d-131f-46a7-9e41-28bc33f50215")
    public ResolvedEdge {
        if (alternatives == null) {
            throw new IllegalArgumentException("alternatives must not be null");
        }
    }

    @objid ("4270296d-8235-4918-98f6-8ffc4ddf663c")
    public sealed interface EdgeAlternative permits MDependencyEdge, LinkObjectEdge {
        @objid ("b2eef50a-de03-4591-a1f6-e5cd1ab3d830")
        Direction direction();

    }

    /**
     * Represents a metamodel dependency edge, with direction.
     *
     * @param dependency the metamodel dependency
     */
    @objid ("4a8cbb71-dca5-4d72-8917-dbd507539e4a")
    public record MDependencyEdge ( MDependency dependency )  implements EdgeAlternative {
        @objid ("b81d177f-2145-4e60-bf6f-1edab52d237e")
        public MDependencyEdge {
            if (dependency == null) {
                throw new IllegalArgumentException("dependency must not be null");
            }
        }

        @objid ("b73bb52d-d406-4472-acff-0fe89506e517")
        @Override
        public Direction direction() {
            return Direction.FORWARD;
        }

    }

    /**
     * Represents a link-object edge traversal, with metaclass, applied stereotype and direction.
     *
     * @param linkMetaclass the metaclass of the link object being traversed (e.g., {@code Generalization}, {@code Dependency}, etc.)
     * @param stereotype the applied stereotype on the link, if any (null if no stereotype)
     * @param direction the traversal direction: {@code FORWARD} follows natural link semantics,
     * {@code BACKWARD} follows opposite direction, {@code BOTH} if direction is ambiguous or not specified
     */
    @objid ("98834bf7-ddfa-4f87-96af-ac9c8942be1b")
    public record LinkObjectEdge ( MClass linkMetaclass,
            Stereotype stereotype,
            Direction direction )  implements EdgeAlternative {
        @objid ("a8e15437-00f3-4276-932d-bce875d91fb5")
        public LinkObjectEdge {
            if (linkMetaclass == null) {
                throw new IllegalArgumentException("linkMetaclass must not be null");
            }
            if (direction == null) {
                throw new IllegalArgumentException("direction must not be null");
            }
        }

    }

}
