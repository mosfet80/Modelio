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
package org.modelio.platform.search.engine.api;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Element;

@objid ("df508e52-d2cf-4a52-b2d2-a425c9875644")
public class ModelSearchResult {
    @objid ("c81f756e-7086-4ce2-8ec9-ca6b28d33dec")
    private List<Element> results;

    @objid ("b92898d7-87a4-4b5d-b224-c3a9e643a3e5")
    private List<SearchCriterion> criterions;

    @objid ("6ced5e64-e3eb-4931-afb2-391c14bf3cd4")
    public ModelSearchResult(List<Element> results, List<SearchCriterion> criterions) {
        this.results = results;
        this.criterions = criterions;
    }

    @objid ("bfb42593-daa0-4abf-9488-09b8a1dafaad")
    public List<Element> getResults() {
        return results;
    }

    @objid ("5f0ffad9-7696-4720-88ca-aa917c1f9b19")
    public List<SearchCriterion> getCriterions() {
        return criterions;
    }

    @objid ("f4482316-fe2b-4c5f-a2c0-89b8921d8ef0")
    public record SearchCriterion ( String propertyName,
            Object type )  {
    }

}
