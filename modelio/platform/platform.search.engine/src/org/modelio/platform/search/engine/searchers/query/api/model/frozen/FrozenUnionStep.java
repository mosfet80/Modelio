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

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Union step: union of alternative step sequences.
 * <p>
 * This represents alternatives (A | B). Output is the concatenation of each branch.
 *
 * @param branches list of branches, each branch being a list of steps
 */
@objid ("5672322f-e28f-4389-aab9-c03befa6fb6a")
public record FrozenUnionStep ( @JsonProperty(required = true)
        List<List<FrozenStep>> branches )  implements FrozenStep {
    @objid ("58f90181-1046-4638-a324-2c69efadcc18")
    public FrozenUnionStep {
        if (branches == null) {
            throw new IllegalArgumentException("branches must not be null");
        }
    }

}
