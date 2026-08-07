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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.modelio.platform.model.ui.panels.search.query.commands.MqlStepCommands;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;

/**
 * Edit part for the "+" add-step node inside a repeat body.
 * <p>
 * Clicking this node shows a popup menu to choose which step type to add
 * at the end of the repeat body.
 */
@objid ("84eaf9de-f1f4-4684-9479-bf0879ca0fae")
public final class MqlAddRepeatBodyStepEditPart extends AbstractGraphicalEditPart {
    @objid ("2b74c1ca-011a-4852-9dd8-0328278d474e")
    @Override
    protected IFigure createFigure() {
        MqlAddStepFigure fig = new MqlAddStepFigure();
        fig.addMouseListener(new MouseListener.Stub() {
            @Override
            public void mousePressed(MouseEvent me) {
                showAddStepMenu();
            }
        });
        return fig;
    }

    @objid ("fb034a49-9fc4-4082-a53e-9383c48af964")
    @Override
    protected void createEditPolicies() {
        // no edit policies – this is a virtual add button
    }

    @objid ("3593c4b8-4e4c-4f9b-993c-e6b402324199")
    private void showAddStepMenu() {
        MqlAddRepeatBodyStepNode addNode = (MqlAddRepeatBodyStepNode) getModel();
        MqlStepNode repeatStep = addNode.getRepeatStep();
        MqlQueryModel queryModel = addNode.getQueryModel();
        Control control = getViewer().getControl();

        Menu menu = new Menu(control);

        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.property"),   repeatStep, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.PROPERTY));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.type"),   repeatStep, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.KIND));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.composite"),   repeatStep, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.COMPOSITE));

        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.navigation"), repeatStep, queryModel, () -> MqlStepCommands.createDefaultTraverseStep(queryModel));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.union"),    repeatStep, queryModel, () -> MqlStepCommands.createDefaultUnionStep(queryModel));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.loop"),   repeatStep, queryModel, () -> MqlStepCommands.createDefaultRepeatStep(queryModel));

        // Position the menu near the "+" node
        IFigure figure = getFigure();
        org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds().getCopy();
        figure.translateToAbsolute(bounds);
        Point displayPt = control.toDisplay(bounds.x, bounds.y + bounds.height);
        menu.setLocation(displayPt);
        menu.setVisible(true);
    }

    @objid ("7aaa542e-e9d2-4b4e-abcc-80b00a478b07")
    private static void addMenuItem(final Menu menu, final String label, final MqlStepNode repeatStep, final MqlQueryModel queryModel, final java.util.function.Supplier<Step> factory) {
        MenuItem item = new MenuItem(menu, SWT.PUSH);
        item.setText(label);
        item.addListener(SWT.Selection, e -> {
            int insertAt = repeatStep.getRepeatBody().size();
            repeatStep.insertRepeatBodyStep(insertAt, factory.get());
        });
    }

}
