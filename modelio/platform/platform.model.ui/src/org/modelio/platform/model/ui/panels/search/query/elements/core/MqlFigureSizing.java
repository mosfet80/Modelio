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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;

/**
 * Shared sizing helpers for MQL editor figures.
 */
@objid ("1c21db61-6e09-4807-8edd-e8ced4611277")
public final class MqlFigureSizing {
    @objid ("d0b2431d-d79d-456b-bb3a-2bed530787bb")
    private MqlFigureSizing() {
        // utility class
    }

    /**
     * Apply a minimum height corresponding to the given number of text lines, plus insets.
     */
    @objid ("a83af2f3-cead-43c6-8fc8-07fa08ae0c69")
    public static void applyMinimumHeightLines(final IFigure figure, final int lineCount, final int extraPixels) {
        if (figure == null || lineCount <= 0) {
            return;
        }

        final Font font = figure.getFont();
        if (font == null) {
            // Not yet attached to a parent: call later (typically from addNotify()).
            return;
        }

        final FontMetrics metrics = FigureUtilities.getFontMetrics(font);
        final int lineHeight = metrics.getHeight();
        final int minHeight = (lineCount * lineHeight) + figure.getInsets().getHeight() + Math.max(0, extraPixels);
        figure.setMinimumSize(new Dimension(-1, minHeight));
    }

}
