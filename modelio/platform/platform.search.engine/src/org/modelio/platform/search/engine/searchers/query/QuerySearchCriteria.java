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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.api.ModelSearchResult.SearchCriterion;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;

@objid ("a6d54e84-88fc-4032-bedf-c832f698a23c")
public class QuerySearchCriteria implements ISearchCriteria {
    @objid ("294ef476-1898-4799-a047-9168a493c36f")
    private boolean includeLibraryElements = true;

    @objid ("5b474273-4ee7-4cf3-a014-54c8fa2d00f5")
    private final Query query;

    @objid ("5bfb53f2-94ae-48e4-bac7-d1e0256b2460")
    private List<SearchCriterion> criterion;

    @objid ("0e87ad6e-0783-4b42-b055-0756164b9fe3")
    public QuerySearchCriteria(Query query, List<SearchCriterion> criterion) {
        this.query = query;
        this.criterion = criterion;
    }

    @objid ("8764d272-7393-41c7-bfd7-011b47a6aac2")
    public List<SearchCriterion> getCriterion() {
        return criterion;
    }

    @objid ("e7fc585c-6138-4f29-b64b-e43361f9c5fb")
    public Query getQuery() {
        return query;
    }

    @objid ("e0a9eef3-4cca-4ec4-915b-52d193988945")
    public boolean isIncludeLibraryElements() {
        return includeLibraryElements;
    }

    @objid ("ef1e79ed-2463-4dea-90f4-35e7e753df64")
    public void setIncludeLibraryElements(boolean includeLibraryElements) {
        this.includeLibraryElements = includeLibraryElements;
    }

}
