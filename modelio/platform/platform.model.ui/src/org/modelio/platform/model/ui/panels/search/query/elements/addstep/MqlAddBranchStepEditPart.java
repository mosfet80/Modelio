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
 * Edit part for the "+" add-step node inside a union branch.
 * <p>
 * Clicking this node shows a popup menu to choose which step type to add
 * at the end of the branch.
 */
@objid ("829dfa87-e794-4c3a-9351-290693e8d8dc")
public final class MqlAddBranchStepEditPart extends AbstractGraphicalEditPart {
    @objid ("f50f6087-65cb-438c-87a1-5ab4fd142ec8")
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

    @objid ("bcade069-dd90-4b4c-85f9-5c10529a71c9")
    @Override
    protected void createEditPolicies() {
        // no edit policies – this is a virtual add button
    }

    @objid ("70ba9b8d-8ff7-43eb-8a1c-7a333443d5d4")
    private void showAddStepMenu() {
        MqlAddBranchStepNode addNode = (MqlAddBranchStepNode) getModel();
        MqlStepNode unionStep = addNode.getUnionStep();
        MqlQueryModel queryModel = addNode.getQueryModel();
        int branchIndex = addNode.getBranchIndex();
        Control control = getViewer().getControl();

        Menu menu = new Menu(control);

        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.property"),   unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.PROPERTY));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.type"),   unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.KIND));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.composite"),   unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultFilterStep(queryModel,FilterStep.FilerStepKind.COMPOSITE));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.navigation"), unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultTraverseStep(queryModel));
        addMenuItem(menu,  CoreUi.I18N.getString("MqlBrowser.itemcreation.union"),    unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultUnionStep(queryModel));
        addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.loop"),   unionStep, branchIndex, queryModel, () -> MqlStepCommands.createDefaultRepeatStep(queryModel));

        // Position the menu near the "+" node
        IFigure figure = getFigure();
        org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds().getCopy();
        figure.translateToAbsolute(bounds);
        Point displayPt = control.toDisplay(bounds.x, bounds.y + bounds.height);
        menu.setLocation(displayPt);
        menu.setVisible(true);
    }

    @objid ("b33d78dd-2c3d-48cd-8629-df2b93c47f0e")
    private static void addMenuItem(final Menu menu, final String label, final MqlStepNode unionStep, final int branchIndex, final MqlQueryModel queryModel, final java.util.function.Supplier<Step> factory) {
        MenuItem item = new MenuItem(menu, SWT.PUSH);
        item.setText(label);
        item.addListener(SWT.Selection, e -> {
            int insertAt = unionStep.getUnionBranches().get(branchIndex).size();
            unionStep.insertUnionBranchStep(branchIndex, insertAt, factory.get());
        });
    }

}
