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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.result.IQueryResponse;

@objid ("bc6593e3-3f3e-43b7-8362-df29525f7108")
public interface IQueryEngine {
    /**
     * Execute a query synchronously and return its finalized response.
     * <p>
     * This method blocks until query execution reaches a terminal state ({@code ENDED}, {@code CANCELLED}, or {@code FAILED}).
     * Query and runtime issues are reported through response diagnostics and state.
     *
     * @param query the query to execute.
     * @return the query result.
     */
    @objid ("a27ca0f5-9288-49a5-b916-0965aed20116")
    IQueryResponse syncExec(Query query);

    /**
     * Prepare an asynchronous execution for a query.
     * <p>
     * The returned handle is not started yet. Register handlers first, then explicitly start execution by calling
     * {@link IASyncExecution#run()}.
     *
     * @param query the query to execute asynchronously.
     * @return a prepared asynchronous execution handle.
     */
    @objid ("f6050d49-00da-40ac-9e0c-7a10ce3e3347")
    IASyncExecution prepareAsync(Query query);

    /**
     *
     * @return Get the query resolver used by this engine to resolve queries, edges, kinds and steps.
     */
    @objid ("f283e88f-8749-46b0-819d-b1ff18bbaab9")
    IQueryResolver getResolver();

}
