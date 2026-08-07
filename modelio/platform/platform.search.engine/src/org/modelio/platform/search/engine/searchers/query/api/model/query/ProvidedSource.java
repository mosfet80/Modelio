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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenProvidedSource;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Provided Source: start from a collection of elements provided by API integration.
 * <p>
 * This source type uses a pre-defined collection of model elements as the starting point.
 * It is typically used when:
 * <ul>
 * <li>The query operates on a user's current selection in the UI</li>
 * <li>Results from a previous query are used as input to another query</li>
 * <li>The API integration has already identified specific elements of interest</li>
 * </ul>
 * <p>
 * The provided elements can be of mixed types (different metaclasses/stereotypes).
 * Subsequent pipeline steps will process all provided elements.
 *
 * @see AllSource
 */
@objid ("79eea5bd-6347-4fc7-879e-2c4d6a07963f")
public final class ProvidedSource implements Source {
    @objid ("7cb6d5d2-0fde-419d-8ea6-41f0a11f9688")
    private Iterable<MObject> elements;

    /**
     * Constructor.
     *
     * @param elements starting elements
     */
    @objid ("78c29dc9-5d01-4a14-b0dc-0f6e3c4a2075")
    public ProvidedSource(Iterable<MObject> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }
        this.elements = elements;
    }

    /**
     * Copy constructor.
     */
    @objid ("b875c841-be58-4e34-9c73-8d7415415052")
    public ProvidedSource(ProvidedSource other) {
        this.elements = other.elements;
    }

    /**
     * Constructor from frozen.
     */
    @objid ("ecf07c6a-12af-45ef-bf6e-de22bbdb85a8")
    public ProvidedSource(FrozenProvidedSource frozen) {
        this.elements = frozen.elements();
    }

    @objid ("fa1bb881-6656-4fcf-9fdc-a983d0764112")
    public Iterable<MObject> getElements() {
        return this.elements;
    }

    @objid ("03112ed7-475b-4080-8cb5-537f2e71df16")
    public void setElements(Iterable<MObject> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements must not be null");
        }
        this.elements = elements;
    }

    /**
     * Convert to frozen (immutable) version.
     */
    @objid ("2f3ccde5-611e-4c6b-8242-8b83123a33ed")
    public FrozenProvidedSource freeze() {
        return new FrozenProvidedSource(this.elements);
    }

    @objid ("10a77aa8-684c-4b3e-9b0a-6bad6f307294")
    @Override
    public ProvidedSource deepCopy() {
        return new ProvidedSource(this);
    }

}
