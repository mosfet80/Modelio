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
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.modelio.platform.ui.UIColor;

/**
 * A circle figure with a "+" label, used as the "add step" button at the end
 * of the pipeline diagram.
 */
@objid ("dd026920-4913-446b-bfe5-898d6832ffa8")
public final class MqlAddStepFigure extends Ellipse {
    @objid ("5cccbab9-c9de-47c5-a997-de9383095ca1")
    private static final int SIZE = 28;

    @objid ("fe335dcc-77c3-4f77-a952-370985519ff3")
    private final Label plusLabel;

    @objid ("b071a8cb-17e6-4e8e-93e7-6453f30c5365")
    public MqlAddStepFigure() {
        setLayoutManager(new StackLayout());
        setPreferredSize(new Dimension(SIZE, SIZE));
        setSize(SIZE, SIZE);

        setBackgroundColor(UIColor.WHITE);
        setForegroundColor(new Color(74, 128, 26));
        setOpaque(true);
        setAntialias(SWT.ON);
        setLineWidth(2);
        setOutline(true);



        this.plusLabel = new Label("+");
        this.plusLabel.setForegroundColor(new Color(74, 128, 26));
        add(this.plusLabel);

        setToolTip(new Label("Click to add a new step"));
    }

    @objid ("ceaa195c-fc97-4ec2-85b4-6f1baa714cc4")
    @Override
    public void addNotify() {
        super.addNotify();
        // Attempt to set a larger bold font for the "+"
        Font parentFont = getFont();
        if (parentFont != null) {
            FontData[] fds = parentFont.getFontData();
            for (FontData fd : fds) {
                fd.setHeight(fd.getHeight() + 4);
                fd.setStyle(SWT.BOLD);
            }
            Font bigFont = new Font(Display.getCurrent(), fds);
            this.plusLabel.setFont(bigFont);
        }
    }

}
