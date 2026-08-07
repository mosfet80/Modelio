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
package org.modelio.platform.model.ui.panels.search.query.editpolicies;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;

@objid ("d4c8f653-de3a-45c6-95b2-54b3435ee6e0")
public class MqlSelectionFeedbackPolicy extends SelectionEditPolicy {
    @objid ("227a8c86-ddde-4c92-9af5-e4a1e6c73c4c")
    @Override
    protected void showSelection() {
        NodeStyles.SELECTED.applyTo((Figure)getHostFigure());
        getHostFigure().repaint();
    }

    @objid ("aeaff926-22be-4c13-a235-249ca89c01e3")
    @Override
    protected void hideSelection() {
        NodeStyles.DEFAULT.applyTo((Figure)getHostFigure());
        getHostFigure().repaint();
    }

    @objid ("3b2238e2-da72-4aae-8499-d6be81af37cc")
    @Override
    protected void showFocus() {
        showSelection();
    }

    @objid ("60de369d-1fc6-49f4-8718-2aecd921a194")
    @Override
    protected void hideFocus() {
        hideSelection();
    }

}
