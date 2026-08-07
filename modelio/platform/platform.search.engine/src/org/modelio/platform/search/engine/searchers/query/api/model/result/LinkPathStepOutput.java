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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Path step representing a traversal over a link model object.
 * <p>
 * Defined in MQL Technical Specification, Section 4.4 "Edge step in paths" (link variant).
 * <p>
 * A link step describes traversal via a link that is itself a model element ({@code MObject}).
 * Examples include UML Generalization, Dependency, Realization, Association, etc.
 * <ul>
 * <li>The link has identity (UUID) and a metaclass</li>
 * <li>The link may have stereotypes applied to it</li>
 * <li>The link defines well-defined endpoints (from/to, sub/super, source/target, etc.)</li>
 * </ul>
 * <p>
 * <b>Direction semantics:</b>
 * <ul>
 * <li><b>Forward</b> - traversal follows the natural direction defined by the link type's name and semantics.
 * Example: {@code Generalization} naturally goes from subclass to superclass.</li>
 * <li><b>Backward</b> - traversal follows the opposite direction.
 * Example: {@code Generalization} backward goes from superclass to subclass.</li>
 * </ul>
 * <p>
 * The natural direction for each link type is determined by UML/metamodel semantics and the link's name.
 * <p>
 * <b>Example:</b> A traversal from {@code Class "Customer"} to its superclass via generalization produces:
 * <pre>
 * LinkPathStepOutput(
 * link = Generalization MObject,
 * direction = Forward
 * )
 * </pre>
 * <p>
 *
 * @param link the traversed link object (never null, transient: serialized as {mc, uuid, name})
 * @param direction traversal direction: {@code Forward} follows natural link semantics, {@code Backward} follows opposite direction
 */
@objid ("abb7759a-6cc8-4d97-a882-0ca023d38a5c")
public record LinkPathStepOutput ( MObject link,
        Direction direction )  implements PathStepOutput {
    @objid ("659d5bf2-b800-4c72-bfe9-b4070363517f")
    public LinkPathStepOutput {
        if (link == null) {
            throw new IllegalArgumentException("link must not be null");
        }
    }

}
