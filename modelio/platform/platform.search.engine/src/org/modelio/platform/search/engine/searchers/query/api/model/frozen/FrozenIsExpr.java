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
package org.modelio.platform.search.engine.searchers.query.api.model.frozen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Type predicate: checks whether the current node is of a kind.
 *
 * @param ofQualifiedName kind reference (metaclass name or stereotype name)
 */
@objid ("51d587b9-8aa6-49b5-8bbd-fd80db12f796")
public record FrozenIsExpr ( @JsonProperty(required = true)
        String ofQualifiedName )  implements FrozenExpr {
    @objid ("6bdd1b4b-0106-43fb-a012-e465c9c60701")
    public FrozenIsExpr {
        if (ofQualifiedName == null || ofQualifiedName.isBlank()) {
            throw new IllegalArgumentException("ofQualifiedName must not be null/blank");
        }
    }

}
