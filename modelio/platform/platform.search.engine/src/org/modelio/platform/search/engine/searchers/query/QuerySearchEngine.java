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
package org.modelio.platform.search.engine.searchers.query;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.api.ISearchEngine;
import org.modelio.platform.search.engine.api.ModelSearchResult;
import org.modelio.platform.search.engine.searchers.query.api.IQueryEngine;
import org.modelio.platform.search.engine.searchers.query.api.Queries;
import org.modelio.platform.search.engine.searchers.query.api.model.result.IQueryResponse;
import org.modelio.platform.search.engine.searchers.query.api.model.result.NodeWithExplainOut;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("c0cbba74-7347-4d6c-9cca-cf7a9a3a091d")
public class QuerySearchEngine implements ISearchEngine {
    @objid ("2f9181d0-97ff-4643-80d0-2b18811b870c")
    @Override
    public ModelSearchResult search(ICoreSession session, ISearchCriteria criteria) {
        assert (criteria instanceof QuerySearchCriteria);

        QuerySearchCriteria queryCriteria = (QuerySearchCriteria) criteria;
        IQueryEngine queryEngine = Queries.createEngine(session);
        IQueryResponse response = queryEngine.syncExec(queryCriteria.getQuery());

        List<Element> results = new ArrayList<>();
        for (NodeWithExplainOut item : response.items()) {
            MObject node = item.node();
            if (node instanceof Element) {
                results.add((Element) node);
            }
        }

        // Filter out library elements if the criteria does not include them
        if(!queryCriteria.isIncludeLibraryElements()) {
            results.removeIf(e -> e.getStatus().isRamc());
        }

        return new ModelSearchResult(results, queryCriteria.getCriterion());
    }

}
