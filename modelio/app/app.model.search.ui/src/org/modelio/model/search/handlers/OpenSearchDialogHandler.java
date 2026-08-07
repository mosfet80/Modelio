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
package org.modelio.model.search.handlers;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.widgets.Shell;
import org.modelio.gproject.core.IGProject;
import org.modelio.model.search.QuickSearchCombo;
import org.modelio.model.search.dialog.SearchDialog;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.platform.search.engine.api.DefaultSearchCriteria;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Handler to open the search dialog.
 */
@objid ("000f3f70-c59e-10ab-8258-001ec947cd2a")
public class OpenSearchDialogHandler {
    @objid ("000f47fe-c59e-10ab-8258-001ec947cd2a")
    @Execute
    public void execute(final IProjectService projectService, final IModelioNavigationService navigationService, @Named(IServiceConstants.ACTIVE_SHELL) final Shell shell, final IEventBroker eventBroker, MWindow window, EPartService partService, ESelectionService selectionService) {
        final IGProject project = projectService.getOpenedProject();
        if (project == null) {
            return;
        }

        // Get text from the Quick Search combo
        String expression = QuickSearchCombo.getSearchText();

        final ICoreSession session = project.getSession();

        final SearchDialog searchDialog = SearchDialog.getInstance(shell, session, navigationService,eventBroker,window,partService,selectionService);
        searchDialog.setBlockOnOpen(false);
        searchDialog.open();
        final DefaultSearchCriteria searchCriteria = new DefaultSearchCriteria();
        searchCriteria.setOption("name", expression);
        searchDialog.setDisplayedContent(searchCriteria);
    }

    @objid ("000f9812-c59e-10ab-8258-001ec947cd2a")
    @CanExecute
    public boolean canExecute(final IProjectService projectService) {
        return (projectService.getOpenedProject() != null);
    }

}
