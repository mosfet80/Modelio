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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Immutable source: start from a collection provided by the API integration.
 * <p>
 * The {@code elements} field is transient (not serialized/deserialized).
 * When deserializing from JSON, elements default to an empty list.
 *
 * @param elements starting elements (transient, not included in JSON)
 */
@objid ("5eac9948-7821-4a0c-bff2-4ac019badc33")
public record FrozenProvidedSource ( @JsonIgnore
        Iterable<MObject> elements )  implements FrozenSource {
    @objid ("0aeddf5c-0820-4635-a686-dce41fcb7b42")
    public FrozenProvidedSource {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }
    }

    /**
     * Jackson deserializer: constructs a FrozenProvidedSource with empty elements
     * (elements are transient and are not present in JSON).
     */
    @objid ("631a713d-19cc-404a-a4f0-053cd0a2a3ab")
    @JsonCreator
    public static FrozenProvidedSource fromJson() {
        return new FrozenProvidedSource(List.of());
    }

}
