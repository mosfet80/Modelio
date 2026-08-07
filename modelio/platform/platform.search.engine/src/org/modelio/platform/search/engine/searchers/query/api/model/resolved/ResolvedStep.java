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
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExpr;

/**
 * Internal, resolved pipeline step.
 * <p>
 * This is a minimal execution shape that does not depend on public unresolved AST types.
 */
@objid ("6b9e2dbc-51cf-45d5-b320-31305dd8586a")
public sealed interface ResolvedStep permits org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.FilterStep, org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.RepeatStep, org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.UnionStep, org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.TraverseStep, org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.UnsupportedStep {
    /**
     * Output kind after applying this step.
     */
    @objid ("8bc9cc7d-799d-445b-ad91-30bab5be3b1d")
    ResolvedKind outputKind();

    @objid ("69613200-e26d-47ea-92b5-358615a9bb32")
    record FilterStep ( ResolvedExpr predicate,
ResolvedKind outputKind )  implements ResolvedStep {
        @objid ("6dd4016d-390e-4d6c-a5af-b4727e51bf4b")
        public FilterStep {
            // predicate may be null when the filter step has no predicate expression (e.g., REQUIRED_FIELD_MISSING)
            if (outputKind == null) {
                throw new IllegalArgumentException("outputKind must not be null");
            }
        }

    }

    @objid ("83917d12-e880-4680-babe-f50c2ea8b962")
    record RepeatStep ( boolean emitAllDepths,
List<ResolvedStep> body,
ResolvedKind outputKind )  implements ResolvedStep {
        @objid ("26caa533-8407-4f4b-b486-3ab52ff46ea7")
        public RepeatStep {
            body = (body == null) ? List.of() : List.copyOf(body);
            if (outputKind == null) {
                throw new IllegalArgumentException("outputKind must not be null");
            }
        }

    }

    @objid ("33964192-310c-4e3d-ab8d-8172e745d1e6")
    record UnionStep ( List<List<ResolvedStep>> branches,
ResolvedKind outputKind )  implements ResolvedStep {
        @objid ("34e189ae-f66e-45f5-a02c-3eefff863bb3")
        public UnionStep {
            if (branches == null) {
                branches = List.of();
            }
            branches = branches.stream()
                .map(b -> (b == null) ? List.<ResolvedStep>of() : List.copyOf(b))
                .toList();
            if (outputKind == null) {
                throw new IllegalArgumentException("outputKind must not be null");
            }
        }

    }

    /**
     * Step that traverses one edge.
     */
    @objid ("aa998d5d-dac8-403d-8e71-cec2e654fb30")
    record TraverseStep ( ResolvedEdge edge,
ResolvedExpr edgeFilter,
ResolvedKind outputKind )  implements ResolvedStep {
        @objid ("e5b7fff8-a207-49f7-ae12-05da6c36ed53")
        public TraverseStep {
            if (edge == null) {
                throw new IllegalArgumentException("edge must not be null");
            }
            if (outputKind == null) {
                throw new IllegalArgumentException("outputKind must not be null");
            }
        }

    }

    /**
     * Placeholder for step types not yet modeled in the resolved pipeline.
     */
    @objid ("a9789cd3-3035-48da-bfe0-d1f59e58d577")
    record UnsupportedStep ( String description,
ResolvedKind outputKind )  implements ResolvedStep {
        @objid ("a9cc15da-9259-4ac7-97bb-d9f55c249e0d")
        public UnsupportedStep {
            if (description == null || description.isBlank()) {
                throw new IllegalArgumentException("description must not be null/blank");
            }
            if (outputKind == null) {
                throw new IllegalArgumentException("outputKind must not be null");
            }
        }

    }

}
