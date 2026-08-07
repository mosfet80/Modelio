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

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Explanation path showing the traversal route from source to a reached node.
 * <p>
 * Defined in MQL Technical Specification, Section 4.3 "Path output".
 * <p>
 * A path represents an alternation of nodes and edges:
 * <ul>
 * <li><b>nodes</b>: the sequence of k model elements visited, starting from the query source</li>
 * <li><b>steps</b>: the sequence of k-1 traversal edges connecting consecutive nodes</li>
 * <li>Step i describes the edge from {@code nodes[i]} to {@code nodes[i+1]}</li>
 * </ul>
 * <p>
 * <b>Example path:</b> A query finding subclasses via generalization might produce:
 * <pre>
 * nodes: [Customer, BusinessCustomer]
 * steps: [LinkPathStepOutput(Generalization, backward)]
 * </pre>
 * This indicates: starting from Customer, following a Generalization link backward reaches BusinessCustomer.
 * <p>
 * For a path with a single node (the source itself), {@code steps} will be empty.
 * <p>
 * <b>Cycle handling:</b> When a cycle is detected during traversal, only the <b>first discovered</b> path
 * to the node is retained. Subsequent paths reaching the same node are discarded (see spec section 5.1, 5.2).
 * <p>
 * <b>Serialization:</b> All {@code MObject} instances in {@code nodes} are transient and serialize to
 * {@code {mc, uuid, name}} in JSON.
 *
 * @param nodes sequence of nodes in the path (length k, never null, may be empty for no results)
 * @param steps sequence of steps taken to traverse from one node to the next (length k-1, never null)
 */
@objid ("625e4e8e-7250-4387-9823-64e0c959173e")
public record PathOutput ( List<MObject> nodes,
List<PathStepOutput> steps )  {
    // TODO: migrate to MObject.equals() when test mocks are fixed
    /**
     * Compares path outputs by node UUID sequence and step equality.
     * <p>
     * Node comparison uses {@code MObject.getUuid()} rather than {@code MObject.equals()}.
     * This is a deliberate deviation for deduplication stability: {@code MObject.equals()}
     * in production uses UUID + liveId, but test mocks use identity-based equality.
     * UUID-only comparison ensures consistent dedup across both environments.
     * <p>
     * Step comparison delegates to the auto-generated record equals of {@link PathStepOutput}
     * implementations ({@code MDependencyPathStepOutput}, {@code LinkPathStepOutput}), which
     * use metamodel singletons and live objects with correct equals semantics.
     * <p>
     * Cross-session same-UUID behavior is undefined (analogous to same-name Class from
     * two ClassLoaders).
     */
    @objid ("21b00bdb-a749-4b31-a9d4-6948f0d538c2")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathOutput other)) return false;
        if (this.nodes.size() != other.nodes.size()) return false;
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!Objects.equals(this.nodes.get(i).getUuid(), other.nodes.get(i).getUuid())) {
                return false;
            }
        }
        return Objects.equals(this.steps, other.steps);
    }

    @objid ("4c535826-0c27-45d0-aa75-45a65765ac63")
    @Override
    public int hashCode() {
        int result = 1;
        for (MObject node : this.nodes) {
            result = 31 * result + (node == null ? 0 : node.getUuid().hashCode());
        }
        result = 31 * result + Objects.hashCode(this.steps);
        return result;
    }

}
