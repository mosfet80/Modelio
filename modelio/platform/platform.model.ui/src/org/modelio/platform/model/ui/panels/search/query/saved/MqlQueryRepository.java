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
package org.modelio.platform.model.ui.panels.search.query.saved;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * In-memory repository for saved MQL queries.
 * Singleton. TODO: add JSON persistence.
 */
@objid ("7e12cbfa-2aa6-4f26-892b-0b5ef29cec10")
public class MqlQueryRepository {
    @objid ("95f0f2ef-0920-4e94-9fe4-8c41a8a2bc49")
    private static MqlQueryRepository instance;

    @objid ("a7f866ca-3f6f-4c65-acaa-c7241acb80f6")
    private final List<SavedMqlQuery> queries = new ArrayList<>();

    @objid ("b3bd310a-2dbb-47ff-9daa-7751c6974b20")
    private MqlQueryRepository() {
        // no pre-loaded data – only user-created queries are kept
    }

    @objid ("8802c7f8-ff25-4e65-a043-37a1eb7dc745")
    public static MqlQueryRepository getInstance() {
        if (instance == null) {
            instance = new MqlQueryRepository();
        }
        return instance;
    }

    @objid ("f853a387-878f-46af-a9b6-ef27b196a8d2")
    public List<SavedMqlQuery> getQueries() {
        return new ArrayList<>(this.queries);
    }

    @objid ("f51b8fbc-e4fc-4f8c-afdc-1e54de9cee4e")
    public void save(SavedMqlQuery query) {
        this.queries.removeIf(q -> q.getId().equals(query.getId()));
        query.setModified(LocalDateTime.now());
        this.queries.add(query);
    }

    @objid ("63526237-8a68-401c-818e-0bc2b9155419")
    public void delete(SavedMqlQuery query) {
        this.queries.removeIf(q -> q.getId().equals(query.getId()));
    }

}
