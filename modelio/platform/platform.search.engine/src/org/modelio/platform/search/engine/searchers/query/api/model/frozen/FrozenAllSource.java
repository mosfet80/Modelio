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
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Source specification: all elements matching a kind.
 *
 * @param of kind reference (metaclass name or stereotype name)
 */
@objid ("b78ef597-e3f6-4120-b3a4-3e06ce7eb410")
public record FrozenAllSource ( @JsonProperty(required = true)
        String of )  implements FrozenSource {
    /**
     * Create a FrozenAllSource representing all elements having a stereotype.
     *
     * @param stereotype the stereotype
     * @return the source specification
     */
    @objid ("7c767bf6-b2be-424c-bb17-4d2ca5764816")
    public static FrozenAllSource of(Stereotype stereotype) {
        return new FrozenAllSource(stereotype.getName());
    }

    /**
     * Create a FrozenAllSource representing all elements of a metaclass.
     *
     * @param mclass the metaclass
     * @return the source specification
     */
    @objid ("3f49b821-41f0-4378-8eeb-7b15be971c1b")
    public static FrozenAllSource of(MClass mclass) {
        return new FrozenAllSource(mclass.getQualifiedName());
    }

    @objid ("ea00f001-0062-4e62-a63a-bbbe5365a610")
    public FrozenAllSource {
        if (of == null || of.isBlank()) {
            throw new IllegalArgumentException("of must not be null/blank");
        }
    }

}
