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
package org.modelio.platform.model.ui.panels.search.query.elements.traverse;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIColor;

/**
 * Figure for a traverse step.
 */
@objid ("50c1943d-3bf8-44c8-aa82-9abd276a09da")
public class MqlTraverseFigure extends ArowShape {
    @objid ("a92297cd-cce1-4f70-ba0a-9caf0d431238")
    private final Label title;

    @objid ("498e0ea5-b9fa-489b-9c66-a3019e399952")
    private final Label edge;

    //@objid ("ae3af5b0-cfba-4d1e-b8e5-5f99d106d680")
    //private final Label edgeFilter;
    @objid ("a4b77542-4a4c-4529-aa70-85043424cdf0")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this,2,0);
    }

    @objid ("6bd2b8e6-0583-4af1-aecc-6651b355e884")
    public MqlTraverseFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(2);
        setLayoutManager(layout);

        NodeStyles.DEFAULT.applyTo(this);
        setLineWidth(2);

        // Configure trapezoid inset
        setTopInset(15);

        this.title = new Label(CoreUi.I18N.getString("MqlQueryEditor.navigationFigure.short"));
        this.edge = new Label(CoreUi.I18N.getString("MqlQueryEditor.navigationFigure.noselection"));
        this.edge.setForegroundColor(UIColor.GRAY);

        //  this.edgeFilter = new Label("");

        add(this.title);
        add(this.edge);
        //  add(this.edgeFilter);
    }

    @objid ("f4e2c068-2b87-44f4-b121-d1ac0cacbc45")
    public void setEdgeText(final String value, String direction) {
        String texte = value != null && !value.isBlank() ? value : CoreUi.I18N.getString("MqlQueryEditor.navigationFigure.noselection");
        if(direction != null && direction.equals("backward")) {
            texte = texte + " ("  + CoreUi.I18N.getString("MqlQueryEditor.navigationFigure.direction.inverse") + ")";
        }
        this.edge.setText(texte);
    }

}
