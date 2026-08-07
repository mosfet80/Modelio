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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Per-source resolution outcome: pairs the original {@link Source} AST node with its
 * {@link ResolvedSource} and the diagnostics attributed specifically to that source.
 * <p>
 * {@code resolved} may be {@code null} when the source could not be resolved at all.
 * {@code original} must not be {@code null}.
 */
@objid ("09e1a83b-6288-44af-aa89-dac5c14270d0")
public record SourceResolutionResult ( Source original,
ResolvedSource resolved,
List<Diagnostic> diagnostics )  {
    /**
     * Compact constructor: defensively copies diagnostics; original may be null when the source itself is null.
     */
    @objid ("eeec0821-4fe4-4f8d-970b-515b33222e8f")
    public SourceResolutionResult {
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#WARNING}.
     *
     * @return whether this source has at least one warning diagnostic
     */
    @objid ("83899928-dcda-4f1a-b8f9-9e40b4c98bbf")
    public boolean hasWarnings() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.WARNING);
    }

    /**
     * Returns the worst severity among all diagnostics, or {@code null} if there are none.
     *
     * @return the highest severity level, or {@code null} if diagnostics is empty
     */
    @objid ("a4e2e501-8170-4410-b860-c94485f0dca8")
    public org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic.Level worstSeverity() {
        Diagnostic.Level worst = null;
        for (Diagnostic d : this.diagnostics) {
            if (worst == null || d.level().compareTo(worst) > 0) {
                worst = d.level();
            }
        }
        return worst;
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#ERROR}.
     *
     * @return whether this source has at least one error diagnostic
     */
    @objid ("69b75d6f-93e4-497b-9802-779304bb4a63")
    public boolean hasErrors() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

}
