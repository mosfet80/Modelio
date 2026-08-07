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
package org.modelio.archimate.ui.audit;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.audit.engine.core.AbstractRule;

@objid ("171e3bf6-033a-49e3-8fb2-146ddd15b8f3")
public abstract class AbstractArchimateRule extends AbstractRule {
    @objid ("da8141a6-52cb-4fc3-bd7a-98d4d05bce1d")
    public abstract void autoRegister(ArchimateAuditPlan plan);

}
