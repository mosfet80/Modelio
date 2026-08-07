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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathOutput;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Internal pipeline item carrying a single traversal path.
 * Used inside the execution pipeline chain. Never exported outside the executor package.
 * Converted to {@code NodeWithExplainOut} at flush time in the terminal consumer.
 */
@objid ("2efcef68-13ef-4f39-ba01-0b9615aa3103")
public record TraversalItem ( MObject node,
        PathOutput path )  {
    @objid ("30d74384-fae6-4f8d-a36c-780f4dc9f578")
    public TraversalItem {
        Objects.requireNonNull(node, "node must not be null");
        Objects.requireNonNull(path, "path must not be null");
    }

}
