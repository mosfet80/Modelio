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
package org.modelio.platform.search.engine.searchers.query.api.model.result;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Query termination reason.
 * <p>
 * FIXME rename this enum to QueryCompletionStatus .
 */
@objid ("66593b89-6629-45f4-9ce5-c03f4b36368d")
public enum QueryCompletionStatus {
    @objid ("2d947aa1-757a-45b9-8739-5c7b9698c7f1")
    ENDED,
    @objid ("59305093-6c7d-44bf-b61e-797bf49d51b7")
    CANCELLED,
    @objid ("cb04eef7-0b73-4afa-a88e-cd88746f6fde")
    FAILED;

}
