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
package org.modelio.platform.model.ui.panels.search.query.elements.source;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIColor;

/**
 * Visual representation of the query source.
 */
@objid ("dfa320a3-700e-4870-9fa1-6ce01a390a50")
public class MqlSourceFigure extends RoundedRectangle {
    @objid ("4bfeb01f-981e-4280-8898-f48d059aa33f")
    private final Label titleLabel;

    @objid ("79c861f8-462f-4b6d-aca1-497a91b426e6")
    private final Label detailsLabel;

    @objid ("45136a04-0380-4fbb-8f66-25492861f899")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this,2,0);
    }

    @objid ("f90177c1-b6ee-450a-a5c2-4721394cab89")
    public MqlSourceFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(2);
        setLayoutManager(layout);

        NodeStyles.DEFAULT.applyTo(this);
        setLineWidth(2);

        //Configure Corner
        setCornerDimensions(new Dimension(5, 5));


        this.titleLabel = new Label(CoreUi.I18N.getString("MqlBrowser.itemcreation.source"));
        this.detailsLabel = new Label("");
        this.detailsLabel.setForegroundColor(UIColor.GRAY);

        add(this.titleLabel);
        add(this.detailsLabel);
    }

    @objid ("34dfc320-d599-4412-aafe-033bcc7f96f7")
    public void setAllSource(final String kindRef) {
        String kindLabel =  kindRef.contains(".") ?  kindRef.substring(kindRef.indexOf(".") +1) : kindRef;
        this.titleLabel.setText(CoreUi.I18N.getString("MqlBrowser.itemcreation.source"));
        this.detailsLabel.setText(kindLabel != null ? CoreUi.I18N.getString("MqlBrowser.itemcreation.source.all")+ " "+kindLabel : "");
    }

    @objid ("a6ee61cb-333c-40c6-983c-bf00c01e22fa")
    public void setProvidedSource(final int count) {
        this.titleLabel.setText(CoreUi.I18N.getString("MqlBrowser.itemcreation.source"));
        this.detailsLabel.setText(CoreUi.I18N.getString("MqlBrowser.itemcreation.source.selection"));
    }

}
