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
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Per-kind-token resolution outcome: pairs the original kind token string with its
 * {@link ResolvedKind} and the diagnostics attributed specifically to that token.
 * <p>
 * {@code token} may be {@code null} or blank (for blank-token validation diagnostics).
 * {@code resolved} may be {@code null} when the token could not be resolved at all.
 */
@objid ("6f3c3778-359a-4c37-a205-74b694cf5e86")
public record KindResolutionResult ( String token,
ResolvedKind resolved,
List<Diagnostic> diagnostics )  {
    /**
     * Compact constructor: defensively copies diagnostics.
     */
    @objid ("4bb0d01e-30dd-4f40-8251-40e82501f223")
    public KindResolutionResult {
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#WARNING}.
     *
     * @return whether this kind token has at least one warning diagnostic
     */
    @objid ("6bae8cc6-a61d-409a-ad04-881cfd71e6d7")
    public boolean hasWarnings() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.WARNING);
    }

    /**
     * Returns the worst severity among all diagnostics, or {@code null} if there are none.
     *
     * @return the highest severity level, or {@code null} if diagnostics is empty
     */
    @objid ("290f31be-2cd5-4105-9f77-f187237b98ab")
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
     * @return whether this kind token has at least one error diagnostic
     */
    @objid ("56496588-de38-49ad-bb12-c8c265cacf68")
    public boolean hasErrors() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

}
