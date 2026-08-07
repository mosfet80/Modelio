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
package org.modelio.platform.search.engine.searchers.query.api;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ExprResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.KindResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.QueryResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedQuery;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.SourceResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.StepResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Service interface for resolving queries, sources, steps, and kind tokens into their fully resolved forms.
 * <p>
 * The query resolver is responsible for taking a raw query AST
 * and producing a resolved query that is ready for execution by the query engine.
 */
@objid ("f1aa975c-d041-49b4-8710-862ea9960b61")
public interface IQueryResolver {
    /**
     * Resolves the given query into a {@link ResolvedQuery}, collecting diagnostics along the way.
     *
     * @param query the query to resolve
     * @return the resolution result, containing the resolved query and any diagnostics generated during resolution
     */
    @objid ("489a01b4-6d6e-4d95-8dd9-6547af598c96")
    QueryResolutionResult resolveQuery(Query query);

    /**
     * Resolves the query source into a ResolvedSource, using the kind resolver to resolve any kind tokens and collecting diagnostics along the way.
     *
     * @param source the query source to resolve
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved source, with any kind tokens resolved into explicit alternatives and any resolution issues reported in diagnostics
     */
    @objid ("b2283ed2-e69d-4864-97e2-eeafc04d4bea")
    ResolvedSource resolveSource(Source source, List<Diagnostic> diagnostics);

    /**
     * Resolves a single step, using the current input kind to resolve any kind-dependent elements (e.g., edge tokens or property keys).
     *
     * @param step the step to resolve
     * @param currentKind the current input kind, used to resolve kind-dependent elements in the step (may be null or empty if no information is available)
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved step, with its output kind computed based on the input kind and the step semantics
     */
    @objid ("62412744-40de-4157-a11e-7bd87f68c0b9")
    ResolvedStep resolveStep(Step step, ResolvedKind currentKind, List<Diagnostic> diagnostics);

    /**
     * Resolves a kind token into a ResolvedKind, collecting diagnostics along the way.
     *
     * @param token the kind token to resolve (e.g., "Standard.Class")
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved kind, containing explicit alternatives for the given token and any resolution issues reported in diagnostics
     */
    @objid ("08ead620-7a53-44a3-8487-bebb6faa7361")
    ResolvedKind resolveKind(String token, List<Diagnostic> diagnostics);

    /**
     * Resolves a single step with per-step diagnostic attribution.
     *
     * @param step the step to resolve
     * @param currentKind the current input kind
     * @return the per-step resolution result containing the resolved step and attributed diagnostics
     */
    @objid ("fe1d7584-b084-45a2-b391-437ca6b75b93")
    StepResolutionResult resolveStep(Step step, ResolvedKind currentKind);

    /**
     * Resolves the query source with per-source diagnostic attribution.
     *
     * @param source the source to resolve
     * @return the per-source resolution result containing the resolved source and attributed diagnostics
     */
    @objid ("3b541df6-eb5a-4350-9270-c60c42d382a7")
    SourceResolutionResult resolveSource(Source source);

    /**
     * Resolves an expression with per-expression diagnostic attribution.
     *
     * @param expr the expression to resolve
     * @param currentKind the current input kind
     * @return the per-expression resolution result containing the resolved expression and attributed diagnostics
     */
    @objid ("f72400d9-e829-4810-8630-2c31236ed557")
    ExprResolutionResult resolveExpr(Expr expr, ResolvedKind currentKind);

    /**
     * Resolves a kind token with per-kind diagnostic attribution.
     *
     * @param token the kind token to resolve
     * @return the per-kind resolution result containing the resolved kind and attributed diagnostics
     */
    @objid ("af0ee980-adc0-4b6a-8b0a-62c16d3d9005")
    KindResolutionResult resolveKind(String token);

}
