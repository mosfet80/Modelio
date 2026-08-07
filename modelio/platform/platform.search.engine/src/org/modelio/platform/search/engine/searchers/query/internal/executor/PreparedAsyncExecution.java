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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.IASyncExecution;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.NodeWithExplainOut;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;
import org.modelio.platform.utils.log.writers.PluginLogger;

/**
 * Prepared asynchronous query execution that fires registered handlers as results stream in.
 * <p>
 * Item handlers receive one {@link NodeWithExplainOut} per (node, path) pair as the pipeline
 * produces them. The same node may trigger multiple handler invocations with different paths.
 * Diagnostic and completion handlers fire at most once each.
 */
@objid ("954b85fc-8797-4515-899e-fafdcd3751df")
public final class PreparedAsyncExecution implements IASyncExecution {
    @objid ("32d96494-163a-46c8-ad3f-fd1faab4ef77")
    private boolean started;

    @objid ("bd4fedc9-ffae-4bee-8a1c-1524d206f24a")
    private boolean responseTruncated;

    @objid ("852fc456-c7a8-446e-a2cb-32baed2067f2")
    private static final PluginLogger LOG = SearchEngine.LOG;

    @objid ("fca83733-675b-4f66-a50e-a29e41f8c042")
    private final Object lock;

    @objid ("1b8c0b0c-9f53-40c7-b622-00f78d3580a3")
    private final List<Consumer<NodeWithExplainOut>> itemHandlers;

    @objid ("5f720c01-6a08-4aba-9685-ed6484445498")
    private final List<Consumer<Diagnostic>> diagnosticHandlers;

    @objid ("ddb09ad7-44c1-420d-9b16-6b3a05e964e0")
    private final List<Consumer<QueryCompletionStatus>> completionHandlers;

    @objid ("94f2c27f-b256-48fc-b639-515ffa15461b")
    private final CompletableFuture<QueryCompletionStatus> executionState;

    @objid ("0049cfb5-5301-47a8-8841-9cbea1a0d939")
    private final IQueryResponseFiller responseFiller;

    @objid ("197e12c1-9569-46eb-b262-50a5c5f8fc01")
    private final Consumer<IQueryResponseFiller> queryRunner;

    @objid ("87ac3588-c9b4-412a-a309-7c84394ce520")
    public PreparedAsyncExecution(Consumer<IQueryResponseFiller> queryRunner) {
        this.queryRunner = queryRunner;
        this.lock = new Object();
        this.itemHandlers = new ArrayList<>();
        this.diagnosticHandlers = new ArrayList<>();
        this.completionHandlers = new ArrayList<>();
        this.started = false;
        this.executionState = new CompletableFuture<>();
        this.executionState.thenAccept(this::notifyCompletionHandlers);

        this.responseFiller = new IQueryResponseFiller() {
            @Override
            public void pushItem(TraversalItem item) {
                notifyItemHandlers(item);
            }

            @Override
            public void pushDiagnostic(Diagnostic diagnostic) {
                notifyDiagnosticHandlers(diagnostic);
            }

            @Override
            public CompletableFuture<QueryCompletionStatus> getState() {
                return PreparedAsyncExecution.this.executionState;
            }


            @Override
            public void setTruncated() {
                PreparedAsyncExecution.this.responseTruncated = true;
            }

        };
    }

    @objid ("d5b0504d-1eae-4048-a115-04ee78cf3eac")
    @Override
    public IASyncExecution onItem(Consumer<NodeWithExplainOut> handler) {
        Objects.requireNonNull(handler, "handler");
        synchronized (this.lock) {
            ensureNotStarted();
            this.itemHandlers.add(handler);
        }
        return this;
    }

    @objid ("f12ac82c-3022-42f2-90f4-dfbfc2a562a8")
    @Override
    public IASyncExecution onDiagnostic(Consumer<Diagnostic> handler) {
        Objects.requireNonNull(handler, "handler");
        synchronized (this.lock) {
            ensureNotStarted();
            this.diagnosticHandlers.add(handler);
        }
        return this;
    }

    @objid ("a8fe0e26-61f1-4111-a3cf-49e13cfa58b2")
    @Override
    public IASyncExecution onComplete(Consumer<QueryCompletionStatus> handler) {
        Objects.requireNonNull(handler, "handler");
        synchronized (this.lock) {
            ensureNotStarted();
            this.completionHandlers.add(handler);
        }
        return this;
    }

    @objid ("d0d30127-3907-4049-9556-1e4dac3087d0")
    @Override
    public QueryCompletionStatus run() {
        synchronized (this.lock) {
            if (this.started) {
                throw new IllegalStateException("run() can only be called once");
            }
            this.started = true;
        }

        this.queryRunner.accept(this.responseFiller);

        CompletableFuture<QueryCompletionStatus> status = this.responseFiller.getState();
        if (status.isCancelled()) {
            return QueryCompletionStatus.CANCELLED;
        } else if (status.isCompletedExceptionally()) {
            LOG.error(status.exceptionNow());
            return QueryCompletionStatus.FAILED;
        } else if (!status.isDone()) {
            throw new IllegalStateException("Query runner did not complete the execution state future");
        } else {
            return status.join();
        }
    }

    @objid ("4effaeaf-7ae4-4e63-8eb9-e975dbc34102")
    @Override
    public void cancel() {
        synchronized (this.lock) {
            this.responseFiller.getState().complete(QueryCompletionStatus.CANCELLED);
        }
    }

    @objid ("1f19a147-4894-4d6a-9638-c5344b319d32")
    private void ensureNotStarted() {
        if (this.started) {
            throw new IllegalStateException("Cannot register handlers after run() has started");
        }
    }

    @objid ("93140d73-ffbc-437b-8b4a-5f03370b4766")
    private void notifyItemHandlers(TraversalItem item) {
        NodeWithExplainOut nodeWithExplain = new NodeWithExplainOut(item.node(), List.of(item.path()));
        for (Consumer<NodeWithExplainOut> handler : this.itemHandlers) {
            notifyItemHandler(handler, nodeWithExplain);
        }
    }

    @objid ("fecd36e2-c8fc-444c-b75b-4cdba4d7e24a")
    private void notifyDiagnosticHandlers(Diagnostic diagnostic) {
        for (Consumer<Diagnostic> handler : this.diagnosticHandlers) {
            notifyDiagnosticHandler(handler, diagnostic);
        }
    }

    @objid ("05ba9322-50fd-42fd-b349-2421f927e5a8")
    private void notifyItemHandler(Consumer<NodeWithExplainOut> handler, NodeWithExplainOut nodeWithExplain) {
        try {
            handler.accept(nodeWithExplain);
        } catch (RuntimeException exception) {
            LOG.warning(exception);
        }
    }

    @objid ("4751d6fc-17d2-4a4f-8428-7db44bdbf43d")
    private void notifyDiagnosticHandler(Consumer<Diagnostic> handler, Diagnostic diagnostic) {
        try {
            handler.accept(diagnostic);
        } catch (RuntimeException exception) {
            LOG.warning(exception);
        }
    }

    @objid ("c5e24792-4050-4291-a69b-10b77f56b7c4")
    private void notifyCompletionHandlers(QueryCompletionStatus terminalState) {
        for (Consumer<QueryCompletionStatus> handler : this.completionHandlers) {
            try {
                handler.accept(terminalState);
            } catch (RuntimeException exception) {
                LOG.warning(exception);
            }
        }
    }

}
