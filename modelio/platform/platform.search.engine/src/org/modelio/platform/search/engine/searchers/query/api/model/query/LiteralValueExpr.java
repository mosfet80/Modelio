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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLiteralValueExpr;

/**
 * Literal Value expression: a literal constant value.
 * <p>
 * Supports three value types:
 * <ul>
 * <li>{@link ValueType#STRING} : string literal</li>
 * <li>{@link ValueType#NUMBER} : numeric literal (integer or float)</li>
 * <li>{@link ValueType#BOOL} : boolean literal (true/false)</li>
 * </ul>
 */
@objid ("7621fe8a-203d-4331-8b6b-23549886be29")
public final class LiteralValueExpr implements ValueExpr {
    @objid ("06f5308b-b213-4d4b-8014-606f097077f3")
    private ValueType valueType;

    @objid ("bc41144f-4659-498d-af48-999c740bcabe")
    private Object value;

    /**
     * Constructor.
     *
     * @param valueType the type of the literal
     * @param value the literal value
     * @throws IllegalArgumentException if valueType is null
     */
    @objid ("8540ec11-73f4-496d-b48d-ebab9d59ccaa")
    public LiteralValueExpr(ValueType valueType, Object value) {
        if (valueType == null) {
            throw new IllegalArgumentException("valueType must not be null");
        }
        this.valueType = valueType;
        this.value = value;
    }

    /**
     * Copy constructor.
     *
     * @param other the LiteralValueExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("9be963a2-e71d-42ee-a0ce-5a04073fb060")
    public LiteralValueExpr(LiteralValueExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.valueType = other.valueType;
        this.value = other.value;
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen LiteralValueExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("5e6c8ae8-9c19-4b02-8dd1-341fbde0d15f")
    public LiteralValueExpr(FrozenLiteralValueExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.valueType = frozen.valueType();
        this.value = frozen.value();
    }

    /**
     * Gets the value type.
     *
     * @return the type
     */
    @objid ("3a76000b-c90e-4847-99ab-b489ae5391e3")
    public ValueType getValueType() {
        return this.valueType;
    }

    /**
     * Sets the value type.
     *
     * @param valueType the type
     * @throws IllegalArgumentException if valueType is null
     */
    @objid ("13fc7ff7-3cc2-4ca1-89dc-96e771bd7b89")
    public void setValueType(ValueType valueType) {
        if (valueType == null) {
            throw new IllegalArgumentException("valueType must not be null");
        }
        this.valueType = valueType;
    }

    /**
     * Gets the literal value.
     *
     * @return the value object
     */
    @objid ("99954728-fc77-4b6c-864c-7b94227732e8")
    public Object getValue() {
        return this.value;
    }

    /**
     * Sets the literal value.
     *
     * @param value the value object
     */
    @objid ("1b600675-d86c-4ce7-97f4-d22c8ccd91bd")
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Creates a string literal value expression.
     *
     * @param value the string value
     * @return a new LiteralValueExpr with type STRING
     */
    @objid ("8f123058-a9af-4410-b6d7-aea4c9827255")
    public static LiteralValueExpr ofString(final String value) {
        return new LiteralValueExpr(ValueType.STRING, value);
    }

    /**
     * Creates a numeric literal value expression.
     *
     * @param value the numeric value
     * @return a new LiteralValueExpr with type NUMBER
     */
    @objid ("ac9f9e5f-8d03-482d-9caf-2db39f0c9205")
    public static LiteralValueExpr ofNumber(final Number value) {
        return new LiteralValueExpr(ValueType.NUMBER, value);
    }

    /**
     * Creates a boolean literal value expression.
     *
     * @param value the boolean value
     * @return a new LiteralValueExpr with type BOOL
     */
    @objid ("00b6aea2-4008-496f-b30e-44b9c5f3be84")
    public static LiteralValueExpr ofBool(final boolean value) {
        return new LiteralValueExpr(ValueType.BOOL, value);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this literal value expression
     */
    @objid ("f7f909fd-d100-43cf-af63-80bace693141")
    @Override
    public FrozenLiteralValueExpr freeze() {
        return new FrozenLiteralValueExpr(this.valueType, this.value);
    }

    @objid ("7df8782f-0ec7-475d-af94-4607c4fc55f5")
    @Override
    public LiteralValueExpr deepCopy() {
        return new LiteralValueExpr(this);
    }

}
