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
package org.modelio.platform.model.ui.panels.search.query.elements.union;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;

/**
 * Lane figure used to render a union branch.
 */
@objid ("4d4e9cc4-0198-4df6-b2dc-76f7e46553b0")
public class MqlBranchFigure extends Figure {
    @objid ("db811447-7ec3-491f-b598-993802e7af63")
    private final Figure content;

    @objid ("edeff1e2-1dc1-463c-80c5-4abea9bfa870")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this,2,0);
    }

    @objid ("52560d0c-3eb0-4ef3-8202-adb1339df441")
    public MqlBranchFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(2);
        setLayoutManager(layout);

        NodeStyles.DEFAULT.applyTo(this);

        setBackgroundColor(new Color(215,215,255));


        this.content = new Figure();
        ToolbarLayout inner = new ToolbarLayout(true);
        inner.setSpacing(12);
        inner.setStretchMinorAxis(false);
        inner.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        this.content.setLayoutManager(inner);
        this.content.setBorder(new MarginBorder(6));
        add(this.content);
    }

    @objid ("8734dd19-2199-4278-8cb1-c541e1389309")
    public Figure getContentPane() {
        return this.content;
    }

}
