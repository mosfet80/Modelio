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
package org.modelio.platform.model.ui.panels.search.query.validation;

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.IQueryResolver;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.QueryResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.StepResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Thin validation orchestrator that delegates all validation to {@link IQueryResolver#resolveQuery(Query)}.
 *
 * <p>Call {@link #resolve(Query)} on every model change to keep diagnostics up-to-date.
 * Then use {@link #getDiagnosticsFor(Step)}, {@link #getSourceDiagnostics()}, and {@link #hasErrors()}
 * for per-node diagnostic queries.</p>
 */
@objid ("c010b542-e8da-4c74-925e-cc0331239d12")
public class MqlValidationService {
    @objid ("36ea4369-5f32-417a-8cb9-2b504666c957")
    private final IQueryResolver resolver;

    @objid ("2e553bc1-7c66-47fa-bc4c-c8fffc3f60b0")
    private QueryResolutionResult lastResult;

    /**
     * Create a new validation service backed by the given resolver.
     *
     * @param resolver the resolver to delegate all validation to
     */
    @objid ("2ac91f8a-1f3c-4ac6-8310-b2e9eb6004c6")
    public MqlValidationService(IQueryResolver resolver) {
        this.resolver = Objects.requireNonNull(resolver, "resolver");
    }

    /**
     * Re-resolve the given query and cache the result.
     * Call this on every model change.
     *
     * @param query the query to resolve; {@code null} clears the last result
     */
    @objid ("5626846e-d8c8-4b0c-9de9-ac9278a752a5")
    public void resolve(Query query) {
        if (query == null) {
            this.lastResult = null;
            return;
        }
        this.lastResult = this.resolver.resolveQuery(query);
    }

    /**
     * Get the last resolution result. May be null if {@link #resolve(Query)} was never called or query was null.
     *
     * @return the last resolution result, or {@code null}
     */
    @objid ("45865b0f-f72a-4a5e-9a1f-4cbc929c4182")
    public QueryResolutionResult getLastResult() {
        return this.lastResult;
    }

    /**
     * Get per-step diagnostics for a given Step (identity-based lookup).
     * Returns empty list if step was not resolved or no result is available.
     *
     * @param step the AST step to look up diagnostics for
     * @return the list of diagnostics attributed to that step, never {@code null}
     */
    @objid ("1f62b48a-9eac-4482-8e6a-44d66751492d")
    public List<Diagnostic> getDiagnosticsFor(Step step) {
        if (this.lastResult == null || this.lastResult.stepResults() == null) {
            return List.of();
        }
        StepResolutionResult sr = this.lastResult.stepResults().get(step);
        return sr != null ? sr.diagnostics() : List.of();
    }

    /**
     * Get per-source diagnostics from the last resolution.
     * Returns empty list if no result or no source result is available.
     *
     * @return the list of diagnostics attributed to the source node, never {@code null}
     */
    @objid ("257d15dd-1540-430d-81c6-bda188d9a470")
    public List<Diagnostic> getSourceDiagnostics() {
        if (this.lastResult == null || this.lastResult.sourceResult() == null) {
            return List.of();
        }
        return this.lastResult.sourceResult().diagnostics();
    }

    /**
     * Check if any ERROR-level diagnostic exists in the last resolution.
     * Returns false if no resolution result is available.
     *
     * @code true} if the last resolution has at least one ERROR diagnostic
     */
    @objid ("bfd48baa-d2e7-4346-8f2d-1a975ec8c18e")
    public boolean hasErrors() {
        if (this.lastResult == null) {
            return false;
        }
        return this.lastResult.diagnostics().stream()
                .anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

    /**
     * Get the flat list of all diagnostics from the last resolution.
     * Returns empty list if no result is available.
     *
     * @return all diagnostics from the last resolution, never {@code null}
     */
    @objid ("e4234606-fb6b-4024-9a17-480a4ddab91c")
    public List<Diagnostic> getAllDiagnostics() {
        if (this.lastResult == null) {
            return List.of();
        }
        return this.lastResult.diagnostics();
    }

}
