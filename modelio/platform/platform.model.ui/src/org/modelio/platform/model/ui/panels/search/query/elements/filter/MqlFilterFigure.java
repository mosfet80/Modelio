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
package org.modelio.platform.model.ui.panels.search.query.elements.filter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlFigureSizing;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.ui.UIColor;

/**
 * Figure for a filter step.
 */
@objid ("68579fec-3236-45a3-8cf7-ac16ee13234a")
public class MqlFilterFigure extends TrapezoidShape {
    @objid ("8a5a830f-92fe-4eae-a478-dac4e6608453")
    private final Label title;

    @objid ("231598ce-d757-4a08-ad2a-953ecbca4f23")
    private final Label predicate;

    @objid ("0bae2f04-9719-446e-b35c-10e586478f48")
    @Override
    public void addNotify() {
        super.addNotify();
        MqlFigureSizing.applyMinimumHeightLines(this, 2, 0);
    }

    @objid ("920b96f2-6907-4fd8-99e6-078888935fd1")
    public MqlFilterFigure() {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(2);
        setLayoutManager(layout);

        NodeStyles.DEFAULT.applyTo(this);
        setLineWidth(2);

        // Configure trapezoid inset
        setTopInset(15);

        this.title = new Label(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.propertyFilter.header"));
        this.predicate = new Label(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.where.prefix") + CoreUi.I18N.getString("MqlQueryEditor.filterFigure.where.none"));
        this.predicate.setForegroundColor(UIColor.GRAY);

        add(this.title);
        add(this.predicate);
    }

    @objid ("a521600b-0ce6-4bad-83ad-9ef65a454bf7")
    public void setPredicateSummary(final String summary) {
        this.predicate.setText(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.where.prefix") + (summary != null && !summary.isBlank() ? summary : CoreUi.I18N.getString("MqlQueryEditor.filterFigure.where.none")));
    }

    @objid ("19f6141f-18eb-4fd2-91e8-c19e9b6a7073")
    public void setFilterKind(final org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep.FilerStepKind kind) {
        switch (kind) {
        case PROPERTY:
            this.title.setText(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.propertyFilter.labe"));
            break;
        case KIND:
            this.title.setText(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.typeFilter.label"));
            break;
        case COMPOSITE:
            this.title.setText(CoreUi.I18N.getString("MqlQueryEditor.filterFigure.complexFilter.label"));
            break;
        default:

        }
    }

}
