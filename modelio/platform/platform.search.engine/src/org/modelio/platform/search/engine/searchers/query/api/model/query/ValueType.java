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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Enumeration of literal value types supported by MQL.
 */
@objid ("707f2f3d-c0c3-43f1-8a3c-da0280505c96")
public enum ValueType {
    /**
     * String literal type.
     */
    @objid ("77d50e21-b3f7-4768-a8ad-bc77d412800a")
    STRING("string"),
    /**
     * Number literal type (integer or float).
     */
    @objid ("1a936b36-7b9a-42fb-ac17-9858073bc229")
    NUMBER("number"),
    /**
     * Boolean literal type (true/false).
     */
    @objid ("85aae63b-2931-478e-b8f5-ebf043a2aa15")
    BOOL("bool");

    @objid ("01fdce4c-4f74-4489-a168-58164c93c7fd")
    private final String jsonValue;

    @objid ("4f2a6680-b86f-48b0-90d4-7e5248c2476e")
    ValueType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    /**
     * Gets the JSON representation of this value type.
     * <p>
     * Used by Jackson for serialization.
     *
     * @return the JSON value: "string", "number", or "bool"
     */
    @objid ("26ecb551-bf03-49d4-9c52-f68ba62a9689")
    @JsonValue
    public String getJsonValue() {
        return this.jsonValue;
    }

    /**
     * Creates a ValueType from its JSON string representation.
     * <p>
     * Used by Jackson for deserialization.
     *
     * @param value the JSON value: "string", "number", or "bool"
     * @return the corresponding ValueType
     * @throws IllegalArgumentException if value is not recognized
     */
    @objid ("9b4a9154-329d-4aba-92ac-e4108d07c76a")
    @JsonCreator
    public static ValueType fromString(String value) {
        for (ValueType type : values()) {
            if (type.jsonValue.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown valueType: " + value);
    }

}
