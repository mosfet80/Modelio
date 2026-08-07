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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenIsExpr;

/**
 * Kind expression: type filter by kind (metaclass or stereotype).
 * <p>
 * Kind inheritance semantics:
 * <ul>
 * <li>If the kind resolves to a CONCRETE metaclass or stereotype,
 * only elements of that EXACT type are matched</li>
 * <li>If the kind resolves to an ABSTRACT metaclass or stereotype,
 * elements of that type AND all its subtypes are matched</li>
 * </ul>
 * <p>
 * If multiple valid interpretations exist (e.g., both metaclass and stereotype
 * with the same name), the execution will be the UNION of all alternatives,
 * and a warning will be added to diagnostics.
 */
@objid ("bac4b82c-011a-4593-b03b-a83e9c938213")
public final class IsExpr implements Expr {
    @objid ("e408205b-c1cc-4bb5-abfb-4262b803b62a")
    @JsonProperty(required = true)
    private String ofQualifiedName;

    /**
     * Kind expression constructor.
     *
     * @param ofQualifiedName kind reference (metaclass or stereotype name)
     * @throws IllegalArgumentException if ofQualifiedName is null or blank
     */
    @objid ("98e32675-68c9-49ac-8be6-bb3c28781277")
    public IsExpr(String ofQualifiedName) {
        if (ofQualifiedName == null || ofQualifiedName.isBlank()) {
            throw new IllegalArgumentException("ofQualifiedName must not be null/blank");
        }
        this.ofQualifiedName = ofQualifiedName;
    }

    /**
     * Kind expression copy constructor.
     *
     * @param other the IsExpr to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("d23a35b1-2176-4044-8fa8-bffe0be35e16")
    public IsExpr(IsExpr other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.ofQualifiedName = other.ofQualifiedName;
    }

    /**
     * Kind expression constructor from frozen (immutable) version.
     *
     * @param frozen the frozen IsExpr
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("f83d0bdc-9350-4776-ada7-ac9e685591c4")
    public IsExpr(FrozenIsExpr frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.ofQualifiedName = frozen.ofQualifiedName();
    }

    /**
     * Gets the kind reference (metaclass or stereotype name).
     *
     * @return the qualified kind name
     */
    @objid ("aa9fa595-dada-4dcf-87c3-5f1e5cd72dc6")
    public String getOfQualifiedName() {
        return this.ofQualifiedName;
    }

    /**
     * Sets the kind reference.
     *
     * @param ofQualifiedName the kind reference
     * @throws IllegalArgumentException if ofQualifiedName is null or blank
     */
    @objid ("19650f91-304f-4e4a-a19c-ed4a6c4491e0")
    public void setOfQualifiedName(String ofQualifiedName) {
        if (ofQualifiedName == null || ofQualifiedName.isBlank()) {
            throw new IllegalArgumentException("ofQualifiedName must not be null/blank");
        }
        this.ofQualifiedName = ofQualifiedName;
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this is expression
     */
    @objid ("8517aaa2-98e7-4dad-87fa-e884d1ce5111")
    @Override
    public FrozenIsExpr freeze() {
        return new FrozenIsExpr(this.ofQualifiedName);
    }

    @objid ("9372a15d-7ee7-446c-abd8-038c6d07e4a3")
    @Override
    public IsExpr deepCopy() {
        return new IsExpr(this);
    }

}
