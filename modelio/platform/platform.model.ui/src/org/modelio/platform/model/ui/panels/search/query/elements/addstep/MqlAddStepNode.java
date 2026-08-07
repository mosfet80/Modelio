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
package org.modelio.platform.model.ui.panels.search.query.elements.addstep;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;

/**
 * Marker model object for the "+" add-step node at the end of the pipeline.
 * <p>
 * This node is not a real step; it is a visual placeholder that allows the user
 * to append a new step by clicking the "+" circle in the pipeline diagram.
 */
@objid ("cec014f5-beda-4e8f-9ec4-af4311852322")
public final class MqlAddStepNode {
    @objid ("61f7977c-b6eb-4fe0-827e-74e74239f97b")
    private final MqlQueryModel owner;

    @objid ("0f492b33-3012-4309-bde3-80f4588a616a")
    public MqlAddStepNode(final MqlQueryModel owner) {
        this.owner = owner;
    }

    @objid ("10f77435-7915-437d-8552-fe2d7b873b28")
    public MqlQueryModel getOwner() {
        return this.owner;
    }

}
