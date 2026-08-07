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
package org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep;

/**
 * Resolved EXISTS expression.
 *
 * @param in the sub request steps
 * @param where the WHERE clause of the EXISTS expression
 */
@objid ("b016eb29-5cfa-48f0-b4cf-8fe2bc234114")
public record ResolvedExistsExpr ( List<ResolvedStep> in,
ResolvedExpr where )  implements ResolvedExpr {
    @objid ("f7de6956-1eb2-431d-96a0-f236f7975a02")
    public ResolvedExistsExpr {
        if (in == null) {
            in = List.of();
        }
        in = List.copyOf(in);
    }

}
