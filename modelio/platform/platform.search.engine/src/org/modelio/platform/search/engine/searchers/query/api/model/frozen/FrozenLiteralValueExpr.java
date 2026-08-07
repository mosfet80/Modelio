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
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueType;

/**
 * Immutable value expression: literal.
 *
 * @param valueType value type
 * @param value literal value
 */
@objid ("bbb73cfa-0d95-4540-99d1-e134c964a6ea")
public record FrozenLiteralValueExpr ( @JsonProperty(defaultValue = "string")
        ValueType valueType,
        Object value )  implements FrozenValueExpr {
    /**
     * Constructor.
     *
     * @param valueType value type
     * @param value literal value
     */
    @objid ("6010e32c-8f5c-4cc3-a7b0-f1867911ceb8")
    public FrozenLiteralValueExpr(ValueType valueType, Object value) {
        if (valueType == null) {
            this.valueType = ValueType.STRING;
            throw new IllegalArgumentException("valueType must not be null");
        }
        this.valueType = valueType;
        this.value = value;
    }

    /**
     *
     * @param value string literal
     * @return literal value expression
     */
    @objid ("4a3af543-1e25-4caa-98ac-43d1a16e5c1c")
    public static FrozenLiteralValueExpr ofString(final String value) {
        return new FrozenLiteralValueExpr(ValueType.STRING, value);
    }

    /**
     *
     * @param value numeric literal
     * @return literal value expression
     */
    @objid ("7831d182-18b7-4062-b734-2cdce9256ce4")
    public static FrozenLiteralValueExpr ofNumber(final Number value) {
        return new FrozenLiteralValueExpr(ValueType.NUMBER, value);
    }

    /**
     *
     * @param value boolean literal
     * @return literal value expression
     */
    @objid ("d34de977-14e0-4ef5-91a1-8a88a3fff936")
    public static FrozenLiteralValueExpr ofBool(final boolean value) {
        return new FrozenLiteralValueExpr(ValueType.BOOL, value);
    }

}
