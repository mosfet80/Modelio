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

/**
 * Query source: defines the initial collection of elements to process in an MQL query.
 * <p>
 * A Source specifies where the query execution begins. Two types of sources are supported:
 * <ul>
 * <li>{@link AllSource}: Iterate over all elements matching a specific Kind (metaclass or stereotype)</li>
 * <li>{@link ProvidedSource}: Start from a collection of elements provided by API integration</li>
 * </ul>
 * <p>
 * The source is the first stage of query execution, producing the initial element stream
 * that flows through the pipeline steps.
 *
 * @see AllSource
 * @see ProvidedSource
 */
@objid ("e1dfb864-69c9-40d2-bb3a-5a73a3404a8b")
public sealed interface Source permits AllSource, ProvidedSource {
    /**
     * Create a deep copy of this source.
     *
     * @return a new independent copy of this source
     */
    @objid ("0653981c-6c4e-4318-ad76-f0c3009bceca")
    Source deepCopy();

}
