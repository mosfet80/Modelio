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
package org.modelio.platform.search.engine.searchers.query.api.model.result;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Result item that associates a reached node with all explanation paths showing how it was discovered.
 * <p>
 * Defined in MQL Technical Specification, Section 4.2 "Node with explanation".
 * <p>
 * This represents one result item from query execution that includes provenance information.
 * Each path in {@code whyPaths} provides traceability showing:
 * <ul>
 * <li>The sequence of nodes traversed from the source to reach this node</li>
 * <li>The graph edges (links or structural relations) followed at each step</li>
 * </ul>
 * <p>
 * Multiple paths arise when the same node is reachable via different routes through the graph.
 * The set preserves insertion order (first-discovered path first).
 *
 * @param node the reached node in the model. Never null.
 * @param whyPaths all explanation paths showing how this node was reached from the query source.
 * Never null, never empty. Stored as an unmodifiable insertion-ordered set.
 */
@objid ("aa0732e3-1429-4689-bbe8-ad44d3826230")
public record NodeWithExplainOut ( MObject node,
Collection<PathOutput> whyPaths )  {
    @objid ("741bd61c-9c34-4b4c-a25a-e74e32218ca1")
    public NodeWithExplainOut {
        Objects.requireNonNull(node, "node must not be null");
        Objects.requireNonNull(whyPaths, "whyPaths must not be null");
        if (whyPaths.isEmpty()) {
            throw new IllegalArgumentException("whyPaths must not be empty");
        }
        whyPaths = Collections.unmodifiableSet(new LinkedHashSet<>(whyPaths));
    }

}
