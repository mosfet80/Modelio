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
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Enriched whole-query resolution result: resolved query plus per-step and per-source breakdowns.
 * <p>
 * {@code resolvedQuery} must not be {@code null}.
 * {@code sourceResult} may be {@code null} if the caller does not provide per-source attribution.
 * {@code stepResults} maps each original {@link Step} identity to its {@link StepResolutionResult},
 * including steps at all nesting levels (union branches, repeat bodies).
 */
@objid ("03f366c7-7f07-40d6-bff4-81354ddf7c46")
public record QueryResolutionResult ( ResolvedQuery resolvedQuery,
List<Diagnostic> diagnostics,
SourceResolutionResult sourceResult,
Map<Step, StepResolutionResult> stepResults )  {
    /**
     * Compact constructor: resolvedQuery must not be null; diagnostics and stepResults are defensively copied.
     */
    @objid ("45f1e9b9-daa4-4bfd-880c-16e724e030c6")
    public QueryResolutionResult {
        if (resolvedQuery == null) {
            throw new IllegalArgumentException("resolvedQuery must not be null");
        }
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
        stepResults = (stepResults == null) ? Map.of() : Map.copyOf(stepResults);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#ERROR}.
     *
     * @return whether this query resolution has at least one error diagnostic
     */
    @objid ("26d7b16b-6acd-4c5e-8cc1-16883fde3cd6")
    public boolean hasErrors() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#WARNING}.
     *
     * @return whether this query resolution has at least one warning diagnostic
     */
    @objid ("67759cd5-a0dd-4714-bb8b-d2cbe41ad147")
    public boolean hasWarnings() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.WARNING);
    }

}
