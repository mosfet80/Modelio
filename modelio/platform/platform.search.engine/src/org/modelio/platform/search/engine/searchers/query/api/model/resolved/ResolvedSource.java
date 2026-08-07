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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Internal, resolved source specification.
 * <p>
 * Sources must be independent of the public unresolved AST types.
 */
@objid ("22feedd3-70f2-4daa-a641-561dfc23ff76")
public sealed interface ResolvedSource permits org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource.AllSource, org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource.ProvidedSource {
    /**
     * Source: iterate all model elements matching a resolved kind reference.
     */
    @objid ("fea5aa79-ef5f-4fb0-87e6-ab775542f653")
    record AllSource ( ResolvedKind kind )  implements ResolvedSource {
        @objid ("210fa101-79c3-4a0f-b380-9603d789b76a")
        public AllSource {
            if (kind == null) {
                throw new IllegalArgumentException("kind must not be null");
            }
        }

    }

    /**
     * Source: start from an explicit list of provided model elements.
     */
    @objid ("78340641-431b-4972-9431-a9a06e3b4b70")
    record ProvidedSource ( Iterable<MObject> elements )  implements ResolvedSource {
        @objid ("650536e3-8c61-477e-8ecc-87cb706aaa94")
        public ProvidedSource {
            elements = (elements == null) ? List.of() : elements;
        }

    }

}
