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
package org.modelio.platform.search.engine.searchers.query.api.model.result;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Query response representing the complete output of an MQL query execution.
 * <p>
 * Defined in MQL Technical Specification, Section 4.1 "Query response".
 * <p>
 * A query response contains:
 * <ul>
 * <li><b>items</b>: the collection of result nodes, optionally enriched with explanation paths showing
 * how each node was reached during graph traversal</li>
 * <li><b>truncated</b>: indicates whether execution was stopped due to hitting a limit
 * ({@code limit}, {@code maxDepth}, {@code timeoutMs}, or manual interruption)</li>
 * <li><b>diagnostics</b>: optional messages about query execution, including:
 * <ul>
 * <li>Ambiguity warnings when names resolve to multiple definitions</li>
 * <li>Cycle detection warnings</li>
 * <li>Errors during execution</li>
 * <li>Informational messages (limit reached, performance notes)</li>
 * </ul>
 * </li>
 * </ul>
 * <p>
 * When {@code truncated} is {@code true}, the engine stopped before exhausting all results. This can occur when:
 * <ul>
 * <li>The result count reaches {@code limits.limit}</li>
 * <li>Execution time exceeds {@code limits.timeoutMs}</li>
 * <li>Traversal depth exceeds {@code limits.maxDepth} in a {@code Repeat} step</li>
 * <li>The query is manually interrupted</li>
 * </ul>
 */
@objid ("c876b008-01f1-4f38-a037-6f1d8cdd34f7")
public interface IQueryResponse {
    /**
     * Get the state of this response.
     * <p>
     * Returned future completes when the response reaches a terminal state (ENDED, CANCELLED, or FAILED).
     * If the response is already in a terminal state, the future is already completed.
     *
     * @return current response state.
     */
    @objid ("67fe869d-4ec8-4cd2-b156-0dd98675a764")
    CompletableFuture<QueryCompletionStatus> state();

    /**
     *
     * @code true} if execution was truncated due to hitting a limit, {@code false} if query completed fully
     */
    @objid ("8cb0090e-0160-4c34-a2ec-77beb962817a")
    boolean isTruncated();

    /**
     * Get result items produced by query execution.
     * <p>
     * Each item is a pair of:
     * <ul>
     * <li>the result node (a model element matching the query)</li>
     * <li>the explanation path showing how the engine reached that node during graph traversal,
     * which can be used for debugging and understanding the query execution</li>
     * </ul>
     * <p>
     * Returned list ordering is deterministic and preserves production order.
     * Returned list is an immutable snapshot and can be iterated repeatedly.
     *
     * @return result items as an immutable snapshot. Never null.
     */
    @objid ("6773ad63-f6db-49f3-aff3-b83a71838b1c")
    List<NodeWithExplainOut> items();

    /**
     * Get diagnostics produced during resolution and execution.
     * <p>
     * Returned list ordering is deterministic and preserves emission order.
     * Returned list is an immutable snapshot and can be iterated repeatedly.
     *
     * @return diagnostic messages as an immutable snapshot (may be empty if no issues occurred)
     */
    @objid ("492c26bb-3305-4e7b-846c-25e8a771b750")
    List<Diagnostic> diagnostics();

}
