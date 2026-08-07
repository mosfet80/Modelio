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
package org.modelio.platform.search.engine.searchers.query.internal;

import java.util.List;
import java.util.function.Supplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.IASyncExecution;
import org.modelio.platform.search.engine.searchers.query.api.IQueryEngine;
import org.modelio.platform.search.engine.searchers.query.api.IQueryResolver;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.QueryResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedQuery;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.api.model.result.IQueryResponse;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;
import org.modelio.platform.search.engine.searchers.query.internal.executor.IQueryResponseFiller;
import org.modelio.platform.search.engine.searchers.query.internal.executor.PreparedAsyncExecution;
import org.modelio.platform.search.engine.searchers.query.internal.executor.SourceEvaluator;
import org.modelio.platform.search.engine.searchers.query.internal.executor.StepPipelineExecutor;
import org.modelio.platform.search.engine.searchers.query.internal.executor.SyncQueryResponse;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.QueryResolver;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("ca59e772-f5c5-4899-a24b-a68b1ffba305")
public class QueryEngine implements IQueryEngine {
    @objid ("f63982ea-ed06-4913-bd69-dc35b8310d15")
    private static final PluginLogger LOG = SearchEngine.LOG;

    @objid ("37785f48-1516-42db-a778-cde70237b8eb")
    private final ICoreSession session;

    @objid ("9b2ba738-b0ba-4487-8a8e-53768414edcf")
    private final QueryResolver resolver;

    /**
     * Create a query engine for the given session and selection provider.
     * <p>
     * The selection provider is used to retrieve the current selection when executing queries with a {@link ProvidedSource}.
     *
     * @param selectionProvider a supplier of the current selection, used for queries with a {@link ProvidedSource}.
     * @param session the session in which queries will be executed.
     * @return a new query engine instance.
     */
    @objid ("073f2298-e84a-4afb-a875-68a66e4b3155")
    public QueryEngine(ICoreSession session) {
        this.session = session;
        this.resolver = new QueryResolver(session);
    }

    @objid ("4675660d-fca2-4e45-8f04-1154666a073c")
    @Override
    public IQueryResolver getResolver() {
        return this.resolver;
    }

    @objid ("50938b72-815c-4be1-af4e-b7e8f29762a6")
    @Override
    public IQueryResponse syncExec(Query query) {
        SyncQueryResponse response = new SyncQueryResponse();

        runQuery(query, response);

        return response;
    }

    @objid ("7f614cf7-f6a2-4f50-9206-3833692f35a2")
    @Override
    public IASyncExecution prepareAsync(Query query) {
        if (query == null) {
            throw new IllegalArgumentException("query must not be null");
        }

        return new PreparedAsyncExecution((IQueryResponseFiller responseFiller) -> runQuery(query, responseFiller));
    }

    @objid ("69f2e0d6-c9f8-4ee7-8e1e-ce90a14e565b")
    private void runQuery(Query query, IQueryResponseFiller responseFiller) {
        final QueryResolutionResult resolution = this.resolver.resolveQuery(query);
        final List<Diagnostic> resolutionDiagnostics = resolution.diagnostics();

        resolutionDiagnostics.forEach(responseFiller::pushDiagnostic);

        final boolean hasResolutionErrors = resolutionDiagnostics.stream()
                .anyMatch(diagnostic -> diagnostic.level() == Diagnostic.Level.ERROR);
        if (hasResolutionErrors) {
            responseFiller.pushDiagnostic(Diagnostics.error(
                    DiagnosticCode.RESOLUTION_ERROR,
                    "Execution refused: resolution produced error-level diagnostics"));
            responseFiller.getState().complete(QueryCompletionStatus.FAILED);
            return;
        }

        final ResolvedQuery resolvedQuery = resolution.resolvedQuery();
        LOG.debug(
                "Executing query: source=%s, steps=%d",
                resolvedQuery.source().getClass().getSimpleName(),
                Integer.valueOf(resolvedQuery.steps().size()));

        // Always build the pipeline — even with no steps, we need budget enforcement
        IQueryResponseFiller pipeline = StepPipelineExecutor.buildPipeline(
                resolvedQuery.steps(), this.session, responseFiller, resolvedQuery.limits());
        try {
            SourceEvaluator.evaluate(resolvedQuery.source(), this.session, pipeline);
            pipeline.complete(); // Flush accumulated paths to downstream
        } finally {
            responseFiller.getState().complete(QueryCompletionStatus.ENDED);
        }
    }

}
