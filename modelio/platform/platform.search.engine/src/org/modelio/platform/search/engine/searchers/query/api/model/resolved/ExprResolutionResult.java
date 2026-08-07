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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Per-expression resolution outcome: pairs the original {@link Expr} AST node with its
 * {@link ResolvedExpr} and the diagnostics attributed specifically to that expression.
 * <p>
 * {@code resolved} may be {@code null} when the expression could not be resolved at all.
 */
@objid ("1d4ea3c6-baac-4025-bd33-b0962e8fff94")
public record ExprResolutionResult ( Expr original,
ResolvedExpr resolved,
List<Diagnostic> diagnostics )  {
    /**
     * Compact constructor: defensively copies diagnostics.
     */
    @objid ("84c249a6-13b1-4a1a-ae32-527d19fc95a9")
    public ExprResolutionResult {
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }

    /**
     * Returns {@code true} if any diagnostic has level {@link Diagnostic.Level#WARNING}.
     *
     * @return whether this expression has at least one warning diagnostic
     */
    @objid ("45f681cc-7d32-4d60-9729-e28302f05873")
    public boolean hasWarnings() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.WARNING);
    }

    /**
     * Returns the worst severity among all diagnostics, or {@code null} if there are none.
     *
     * @return the highest severity level, or {@code null} if diagnostics is empty
     */
    @objid ("7476331a-5925-434c-b5b7-ffe61e067427")
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
     * @return whether this expression has at least one error diagnostic
     */
    @objid ("0d22d754-5599-4ae8-8b4c-2cc1f232e91d")
    public boolean hasErrors() {
        return this.diagnostics.stream().anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }

}
