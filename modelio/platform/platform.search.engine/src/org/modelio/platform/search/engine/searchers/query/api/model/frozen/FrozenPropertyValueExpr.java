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
 * Immutable value expression: unified element property access.
 *
 * @param property element property reference (may resolve to MAttribute, TagType, NoteType, PropertyDefinition)
 */
@objid ("14fe299d-4cba-4629-af39-9bd8c9e7a4e8")
public record FrozenPropertyValueExpr ( @JsonProperty(required = true)
        String property )  implements FrozenValueExpr {
    @objid ("715d227f-5bbf-4a2c-942e-a65fd453d386")
    public FrozenPropertyValueExpr {
        if (property == null || property.isBlank()) {
            throw new IllegalArgumentException("property must not be null/blank");
        }
    }

}
