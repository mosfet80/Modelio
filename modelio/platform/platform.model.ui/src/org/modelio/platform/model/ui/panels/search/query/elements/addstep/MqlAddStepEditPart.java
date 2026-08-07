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
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.ui.UIColor;

/**
 * Edit part for the "+" add-step node.
 * <p>
 * Clicking this node shows a popup menu to choose which step type to add
 * at the end of the pipeline.
 */
@objid ("9a5096d9-e6b7-41e8-b281-95738ab80731")
public final class MqlAddStepEditPart extends AbstractGraphicalEditPart {
    @objid ("2870da33-7b7b-4265-b0a5-45c570e2f591")
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

    @objid ("281d756f-6902-4560-9b29-6abbc9273ac3")
    @Override
    protected void createEditPolicies() {
        // no edit policies – this is a virtual add button
    }

    @objid ("98a5b6c7-3b42-4636-883f-80cb2bc9d801")
    private void showAddStepMenu() {
        MqlAddStepNode addNode = (MqlAddStepNode) getModel();
        MqlQueryModel queryModel = addNode.getOwner();
        Control control = getViewer().getControl();

        Menu menu = new Menu(control);

        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.property"),   queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.PROPERTY));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.type"),   queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.KIND));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.composite"),   queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.COMPOSITE));

        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.navigation"), queryModel, () -> MqlStepCommands.createDefaultTraverseStep(queryModel));
        addMenuItem(menu,  CoreUi.I18N.getString("MqlBrowser.itemcreation.union"), queryModel, () -> MqlStepCommands.createDefaultUnionStep(queryModel));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.loop"), queryModel, () -> MqlStepCommands.createDefaultRepeatStep(queryModel));

        // Position the menu near the "+" node
        IFigure figure = getFigure();
        org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds().getCopy();
        figure.translateToAbsolute(bounds);
        Point displayPt = control.toDisplay(bounds.x, bounds.y + bounds.height);
        menu.setLocation(displayPt);
        menu.setVisible(true);
    }

    @objid ("a674498b-a8c8-4a7f-aca1-64aafbf24a93")
    private static void addMenuItem(final Menu menu, final String label, final MqlQueryModel model, final java.util.function.Supplier<Step> factory) {
        MenuItem item = new MenuItem(menu, SWT.PUSH);
        item.setText(label);
        item.addListener(SWT.Selection, e -> model.addStep(factory.get()));
    }

}
