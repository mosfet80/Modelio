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

import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.NodeWithExplainOut;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;

/**
 * Prepared asynchronous query execution handle.
 * <p>
 * Register all handlers before calling {@link #run()}.
 * Any registration after execution start is invalid and will fail with an IllegalStateException.
 * The execution can only be started once; repeated {@link #run()} calls are invalid and will fail with an IllegalStateException.
 */
@objid ("fa87ba84-c57c-4326-8c53-603656f417ba")
public interface IASyncExecution {
    /**
     * Registers a handler invoked each time a result item is produced.
     * <p>
     * The handler may be called multiple times for the <b>same node</b> with different
     * explanation paths. Each invocation carries a {@link NodeWithExplainOut} with exactly
     * one path. Consumers that need grouped results should accumulate by node identity.
     *
     * @param handler the item handler, must not be null
     * @return this execution for fluent chaining
     * @throws IllegalStateException if execution has already started.
     */
    @objid ("1d1f0768-00f8-4cdd-bb09-0ad5bfc87e6a")
    IASyncExecution onItem(Consumer<NodeWithExplainOut> handler) throws IllegalStateException;

    /**
     * Register a diagnostic handler.
     *
     * @param handler callback invoked for each emitted diagnostic.
     * @return this execution handle.
     * @throws IllegalStateException if execution has already started.
     */
    @objid ("4f5ebc0b-af9a-4fd2-a28f-5231709edf14")
    IASyncExecution onDiagnostic(Consumer<Diagnostic> handler) throws IllegalStateException;

    /**
     * Register a completion handler.
     *
     * @param handler callback invoked once execution reaches a terminal state.
     * @return this execution handle.
     * @throws IllegalStateException if execution has already started.
     */
    @objid ("77ac5b37-eefa-4992-ae57-55428cd61ef1")
    IASyncExecution onComplete(Consumer<QueryCompletionStatus> handler) throws IllegalStateException;

    /**
     * Execution the query, synchronously.
     * <p>
     * This method is single-use and fail fast if called more than once.
     * <p>
     * The execution may be interrupted asynchronously by calling {@link #cancel()} .
     *
     * @return the terminal execution status.
     * @throws IllegalStateException if execution has already started.
     */
    @objid ("c0b0ced5-d15f-464f-8597-77101da645ef")
    QueryCompletionStatus run() throws IllegalStateException;

    /**
     * Cancel execution.
     */
    @objid ("8db71934-2ec2-4266-8298-2eac91bb17aa")
    void cancel();

}
