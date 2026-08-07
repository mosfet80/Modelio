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
package org.modelio.platform.search.engine.searchers.query.api.model.query;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenPropertyValueExpr;

/**
 * Mutable value expression: accesses an element property by key.
 * <p>
 * A property key may resolve to multiple underlying definitions:
 * <ul>
 * <li>MAttribute (metaclass attribute, e.g., "name", "final")</li>
 * <li>TagType (stereotype tagged value type)</li>
 * <li>NoteType (stereotype note type)</li>
 * <li>PropertyDefinition (stereotype property definition)</li>
 * </ul>
 * <p>
 * If multiple definitions exist for the key, the execution is the UNION of all alternatives,
 * and a warning is emitted in diagnostics.
 */
@objid ("5bb42c07-4893-49aa-acd4-9ceae56315f4")
public final class PropertyValueExpr implements ValueExpr {
    @objid ("3d51fd5d-3465-4449-90f5-83b1c8c6c87d")
    private String property;

    /**
     * Constructor.
     *
     * @param key the property key reference
     * @throws IllegalArgumentException if key is null or blank
     */
    @objid ("22672f49-aa4b-4888-b5a4-b203c55c9e37")
    public PropertyValueExpr(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("key must not be null/blank");
        }
        this.property = key;
    }

    /**
     * Copy constructor.
     *
     * @param other the PropertyValueExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("85771d17-d1b0-4ae2-9ccc-76d1f0eb160c")
    public PropertyValueExpr(PropertyValueExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.property = other.property;
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen PropertyValueExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("cb463907-da0f-41d1-84fb-42660e1abeab")
    public PropertyValueExpr(FrozenPropertyValueExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.property = frozen.property();
    }

    /**
     * Gets the property key.
     *
     * @return the property key reference
     */
    @objid ("1c53c9a3-cda5-494e-8536-89e1177db5a6")
    public String getProperty() {
        return this.property;
    }

    /**
     * Sets the property key.
     *
     * @param property the property key reference
     * @throws IllegalArgumentException if property is null or blank
     */
    @objid ("90839a8d-67e6-44bc-a000-f7ae23ae0965")
    public void setProperty(String property) {
        if (property == null || property.isBlank()) {
            throw new IllegalArgumentException("property must not be null/blank");
        }
        this.property = property;
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this property value expression
     */
    @objid ("4347c83b-6bb6-41f0-b8a0-8b074762f6e9")
    @Override
    public FrozenPropertyValueExpr freeze() {
        return new FrozenPropertyValueExpr(this.property);
    }

    @objid ("5372d31b-e55b-432c-9f23-14221e5c45aa")
    @Override
    public PropertyValueExpr deepCopy() {
        return new PropertyValueExpr(this);
    }

}
