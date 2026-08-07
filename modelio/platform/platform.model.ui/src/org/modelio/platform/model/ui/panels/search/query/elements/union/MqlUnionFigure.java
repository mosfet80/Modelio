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
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;
import org.modelio.platform.model.ui.plugin.CoreUi;

/**
 * Figure for a union step with branch lanes.
 */
@objid ("d9fd450a-da56-441b-a4f1-3ba8e7280334")
public class MqlUnionFigure extends RoundedRectangle {
    @objid ("d2692ee4-e1b3-4fb1-9cf8-4f3cb5d24632")
    private final Label title;

    @objid ("81e0dfce-67b8-4637-8329-fe25ce077727")
    private final Figure branchesPane;

    @objid ("c12be947-f58d-4db9-8d45-3e9670872211")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this,2,0);
    }

    @objid ("5e3327e8-5738-4879-82fd-3498f73cc673")
    public MqlUnionFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(8);
        setLayoutManager(layout);

        NodeStyles.DEFAULT.applyTo(this);
        setLineWidth(2);

        this.title = new Label( CoreUi.I18N.getMessage("MqlQueryEditor.unionFigure.shortName",0));

        this.branchesPane = new Figure();
        ToolbarLayout branchesLayout = new ToolbarLayout();
        branchesLayout.setSpacing(12);
        this.branchesPane.setLayoutManager(branchesLayout);

        add(this.title);
        add(this.branchesPane);
    }

    @objid ("d4277447-e8c2-4b62-9fe1-739d8814be80")
    public Figure getBranchesPane() {
        return this.branchesPane;
    }

    @objid ("b240f926-8ab4-46bd-9d13-9eca5e879160")
    public void setBranchCount(final int count) {
        this.title.setText( CoreUi.I18N.getMessage("MqlQueryEditor.unionFigure.shortName",count));
    }

}
