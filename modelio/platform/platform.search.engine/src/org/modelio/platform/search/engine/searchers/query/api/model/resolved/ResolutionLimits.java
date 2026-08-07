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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Named constants for nesting depth limits during query resolution.
 * <p>
 * When the nesting depth of nested steps (union branches, repeat bodies) reaches
 * {@link #WARNING_DEPTH}, a WARNING diagnostic is emitted. When it reaches
 * {@link #ERROR_DEPTH}, an ERROR diagnostic is emitted and resolution stops going deeper.
 */
@objid ("3fd942c9-9cd1-4407-8c5a-cd9626132653")
public final class ResolutionLimits {
    /**
     * Nesting depth at which a WARNING diagnostic is emitted during resolution.
     */
    @objid ("edb1b5c9-f0cf-4dfb-8c3e-8d559fca5194")
    public static final int WARNING_DEPTH = 10;

    /**
     * Nesting depth at which an ERROR diagnostic is emitted and deep resolution is stopped.
     */
    @objid ("b2da0b74-7bdc-4941-8b38-f59d906772e2")
    public static final int ERROR_DEPTH = 20;

    @objid ("25625f9b-7741-4ce6-b20e-335ae3bb73f6")
    private ResolutionLimits() {
        // utility class — not instantiable
    }

}
