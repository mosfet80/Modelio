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
package org.modelio.platform.model.ui.panels.search.query.elements.repeat;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;
import org.modelio.platform.model.ui.plugin.CoreUi;

/**
 * Figure for a repeat step with nested body steps.
 */
@objid ("96b583da-5f24-4955-97cf-c50fa7ec851e")
public class MqlRepeatFigure extends RoundedRectangle {
    @objid ("613fc95a-0c8c-4498-9414-4207df1858c2")
    private final Label title;

    @objid ("db07a35c-11aa-4c05-b0af-f7fa2c2f2e28")
    private final Figure bodyPane;

    @objid ("0e58212f-aece-44db-bb7b-448bb1ac0b0b")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this,3,0);
    }

    @objid ("7fb71ae3-4562-406e-9cc9-ef4b52f09aa5")
    public MqlRepeatFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(2);
        setLayoutManager(layout);;

        NodeStyles.DEFAULT.applyTo(this);
        setLineWidth(2);

        this.title = new Label(CoreUi.I18N.getString("MqlQueryEditor.repeatFigure.short"));

        this.bodyPane = new Figure();
        ToolbarLayout bodyLayout = new ToolbarLayout(true);
        bodyLayout.setSpacing(12);
        bodyLayout.setStretchMinorAxis(false);
        bodyLayout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        this.bodyPane.setLayoutManager(bodyLayout);
        this.bodyPane.setBorder(new MarginBorder(6));
        this.bodyPane.setBackgroundColor(new Color(215,215,255));

        add(this.title);
        add(this.bodyPane);
    }

    @objid ("c317481c-a95f-45f7-9b39-14730ef7d744")
    public Figure getBodyPane() {
        return this.bodyPane;
    }

}
