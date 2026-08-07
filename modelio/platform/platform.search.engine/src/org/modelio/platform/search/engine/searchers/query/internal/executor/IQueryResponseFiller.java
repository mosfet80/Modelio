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

import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;

/**
 * Execution context passed to the producer task.
 */
@objid ("a85a98f5-a043-4292-b52f-9709a3f62828")
public interface IQueryResponseFiller {
    @objid ("de3d19bc-f6fc-4284-b4bf-3e27ebfa517a")
    void pushItem(TraversalItem item);

    @objid ("46ac2a75-6359-4b61-b3cf-b14ad4d0edd8")
    void pushDiagnostic(Diagnostic diagnostic);

    @objid ("51eb21cd-5be6-4561-bc98-1297556b614c")
    void setTruncated();

    /**
     * Get access to the execution state future, which will be completed either: <ul>
     * <li> once the producer task signals completion by setting a terminal state.
     * <li> exceptionally, if the producer task fails with an exception.
     * <li> externally, if the execution is cancelled.
     * </ul>
     * <p>
     * The implementation must return the same future instance across multiple calls.
     *
     * @return a future resolving to the terminal execution state, or exceptionally if the execution fails or is cancelled.
     */
    @objid ("fd1a4254-0e62-471e-a0f6-129240787f68")
    CompletableFuture<QueryCompletionStatus> getState();

    @objid ("92f66b44-203f-43fd-8ad0-c45f4b335605")
    default boolean isComplete() {
        return getState().isDone();
    }

    /**
     * Signals that all source items have been pushed. Implementors that accumulate
     * state (e.g., path deduplication) may flush their results here.
     * <p>
     * Called defensively at every pipeline exit point.
     * <p>
     * Default implementation does nothing.
     */
    @objid ("b00a9e0d-67cb-45bf-aff1-34266cf5aa50")
    default void complete() {

    }

}
