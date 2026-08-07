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
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Marker model object for the "+" add-step node at the end of a repeat body.
 * <p>
 * This node is not a real step; it is a visual placeholder that allows the user
 * to append a new step to the repeat body by clicking the "+" circle.
 */
@objid ("7801eeb1-d61a-45bb-93ed-c9fc9b386f77")
public final class MqlAddRepeatBodyStepNode {
    @objid ("bded3afe-ffa1-479c-b626-df92f0519cfb")
    private final MqlStepNode repeatStep;

    @objid ("5b86d85b-b662-42bf-a9e9-18c1089b7fa0")
    public MqlAddRepeatBodyStepNode(final MqlStepNode repeatStep) {
        this.repeatStep = repeatStep;
    }

    @objid ("424cbe6a-56cf-4564-a16e-970e97ab3dab")
    public MqlStepNode getRepeatStep() {
        return this.repeatStep;
    }

    @objid ("cda0d8d9-b605-4a25-b27e-be87b46b977c")
    public MqlQueryModel getQueryModel() {
        return this.repeatStep.getRoot();
    }

}
