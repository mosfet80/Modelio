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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Per-step resolution outcome: pairs the original {@link Step} AST node with its
 * {@link ResolvedStep} and the diagnostics attributed specifically to that step.
 * <p>
 * {@code resolved} may be {@code null} when the step could not be resolved at all.
 * {@code original} must not be {@code null}.
 */
@objid ("71952d27-5ca0-4bfe-90a3-5ced00519e38")
public record StepResolutionResult ( Step original,
ResolvedStep resolved,
List<Diagnostic> diagnostics )  {
    /**
     * Compact constructor: defensively copies diagnostics; original must not be null.
     */
    @objid ("4050ca6e-08f4-4ca8-9a73-40b6e46d88f9")
    public StepResolutionResult {
        if (original == null) {
            throw new IllegalArgumentException("original must not be null");
        }
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#WARNING}.
     *
     * @return whether this step has at least one warning diagnostic
     */
    @objid ("8e1af92a-b014-4e38-bc1d-c98760709c31")
    public boolean hasWarnings() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.WARNING);
    }

    /**
     * Returns the worst severity among all diagnostics, or {@code null} if there are none.
     *
     * @return the highest severity level, or {@code null} if diagnostics is empty
     */
    @objid ("b2f34606-6892-4e21-ae55-7935f068aa9e")
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
     * @return whether this step has at least one error diagnostic
     */
    @objid ("55726b11-8683-460b-8e8d-b089f8e2b20d")
    public boolean hasErrors() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

}
