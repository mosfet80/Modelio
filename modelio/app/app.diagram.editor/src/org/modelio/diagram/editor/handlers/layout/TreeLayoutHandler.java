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
package org.modelio.diagram.editor.handlers.layout;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.diagram.editor.AbstractDiagramEditor;
import org.modelio.diagram.editor.layout.DiagramLayoutEngine;
import org.modelio.diagram.editor.layout.DiagramLayoutEngine.LayoutAlgorithmeType;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.DiagramUtils;
import org.modelio.diagram.editor.plugin.DiagramEditor;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.platform.core.IModelioEventService;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.vcore.session.api.transactions.ITransaction;

/**
 * Handler for the tree layout.
 * <p>
 * This handler is used to apply a tree layout to the selected elements in the diagram editor.
 * It uses the {@link DiagramLayoutEngine} to create and run the layout algorithm.
 * </p>
 */
@objid ("63662141-f0e8-4857-a7f8-1e392be18abd")
public class TreeLayoutHandler {
    @objid ("929a2b61-1124-4317-9c92-28de48c31f2d")
    @Execute
    public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) final ISelection selection, @Named(IServiceConstants.ACTIVE_PART) final MPart part, IProjectService projectService, IModelioEventService eventService, IEclipseContext eclipseContext) {
        IDiagramService diagramService = eclipseContext.get(IModuleContext.class).getModelioServices().getDiagramService();
        AbstractDiagramEditor editor = (AbstractDiagramEditor) part.getObject();

        AbstractDiagram diagram = editor.getEditorInput().getDiagram();

        List<IDiagramNode> selectedElements = DiagramUtils.getAllSelectedNodes(diagram, diagramService);

        try (ITransaction transaction = projectService.getSession().getTransactionSupport().createTransaction("TreeLayoutHandler - > Run Tree Layout");) {
            DiagramLayoutEngine.createLayoutAlgorithme(LayoutAlgorithmeType.TREE)
            .withDiagram(diagram, diagramService)
            .withSelection(selectedElements).runLayout();
            transaction.commit();
        } catch (Exception e) {
            DiagramEditor.LOG.error(e);
        }
    }

    @objid ("78fd1a67-e49f-491a-b238-67eae420145c")
    @CanExecute
    public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection) {
        return SelectionHelper.toList(selection, GraphicalEditPart.class).size()>1;
    }

}
