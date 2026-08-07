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
 * Existence predicate.
 * <p>
 * Executes the {@code in} pipeline from the current node and checks whether
 * at least one result exists, optionally filtered by {@code where}.
 *
 * @param in pipeline to execute from the current node
 * @param where optional predicate applied to reached nodes
 */
@objid ("0d472d12-a570-4716-ae5a-ee3234116323")
public record FrozenExistsExpr ( @JsonProperty(required = true)
        List<FrozenStep> in,
FrozenExpr where )  implements FrozenExpr {
    @objid ("bc9a9833-137c-4386-8809-ba8bc7ba8427")
    public FrozenExistsExpr {
        if (in == null) {
            throw new IllegalArgumentException("in must not be null");
        }
    }

}
