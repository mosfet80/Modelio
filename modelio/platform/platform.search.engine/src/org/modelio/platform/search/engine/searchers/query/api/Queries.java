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

import java.util.ArrayList;
import java.util.function.Supplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.internal.QueryEngine;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Modelio Query Language main entry point for query creation and execution.
 * <p>
 * Engines created through this class expose two explicit execution modes:
 * <ul>
 * <li>blocking synchronous execution with {@link IQueryEngine#syncExec(Query)};</li>
 * <li>prepared asynchronous execution with {@link IQueryEngine#prepareAsync(Query)} followed by
 * {@link IASyncExecution#run()}.</li>
 * </ul>
 */
@objid ("6719528c-5fee-4d37-9179-a6c9b4cde031")
public class Queries {
    /**
     * Create an empty query.
     *
     * @return a new empty query.
     */
    @objid ("f478dca4-d79c-4197-ac75-700e9944c92b")
    public static Query createEmptyQuery() {
        return new Query(
                new ProvidedSource(new ArrayList<>()),
                new ArrayList<>(),
                new LimitsSpec());
    }

    /**
     * Create a query engine for the given session and selection provider.
     * <p>
     * The selection provider is used to retrieve the current selection when executing queries with a {@link ProvidedSource}.
     * The returned engine supports both blocking synchronous execution ({@link IQueryEngine#syncExec(Query)}) and prepared
     * asynchronous execution ({@link IQueryEngine#prepareAsync(Query)}).
     *
     * @param session the session in which queries will be executed.
     * @return a new query engine instance.
     */
    @objid ("a8695e12-af93-4162-9644-79a8c9bb1cfb")
    public static IQueryEngine createEngine(ICoreSession session) {
        return new QueryEngine(session);
    }

}
