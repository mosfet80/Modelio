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
package org.modelio.archimate.diagrams.elements.common.figures.motivation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.figures.BeveledRectangleFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;

/**
 * Motivation figure for Archimate.<br/>
 * Features:
 * <ul>
 * <li>a beveled rectangle</li>
 * <li>a ToolbarLayoutWithGrab layout</li>
 * </ul>
 */
@objid ("6b3e562a-a59a-4ad9-ac96-4c221c4a325c")
public class MotivationFigure extends BeveledRectangleFigure {
    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("fcf943ed-2232-4f07-9d8b-b5fd4256dd6b")
    public MotivationFigure() {
        super();
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);

    }

}
