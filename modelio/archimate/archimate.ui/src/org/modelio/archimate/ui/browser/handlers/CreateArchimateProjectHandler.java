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
package org.modelio.archimate.ui.browser.handlers;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.platform.core.IModelioEventService;
import org.modelio.platform.core.IModelioService;
import org.modelio.platform.core.events.ModelioEvent;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.vcore.model.api.IElementNamerService;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmClass;

/**
 * Specific handler for Archimate project creation.
 */
@objid ("1105d1da-152d-4be3-b770-b29fee99bbc7")
public class CreateArchimateProjectHandler {
    /**
     * Creates an ArchiMate project in the selected editable fragment.
     *
     * @param selection the current platform selection.
     * @param projectService the project service, to get session and metamodel from.
     * @param selectionService the selection service, to update the platform selection with.
     * @param eventService the event service, to open the created diagrams with.
     */
    @objid ("4fc42f3c-a214-469e-ae5b-d9228b10c41e")
    @Execute
    public final void execute(@Named (IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection, IProjectService projectService, IModelioNavigationService selectionService, IModelioEventService eventService) {
        IGModelFragment fragment = SelectionHelper.getFirst(selection, IGModelFragment.class);

        List<AbstractDiagram> diagrams = new ArrayList<>();
        final ICoreSession session = projectService.getSession();
        try (ITransaction t = session.getTransactionSupport().createTransaction("Create ArchiMate Project")) {
            MTools mTools = MTools.get(session);
            IElementNamerService namer = mTools.getNamer();
            IArchimateModelFactory modelFactory = mTools.getModelFactory(IArchimateModelFactory.class);

            ArchimateProject newProject = modelFactory.createArchimateProject("", fragment.getRepository());
            newProject.setName(namer.getUniqueName(namer.getBaseName(newProject), newProject));

            for (ViewPoint viewPoint : newProject.getViewPoints()) {
                diagrams.addAll(viewPoint.getProduct());
            }
            t.commit();

            selectionService.fireNavigate(newProject);
        } catch (Exception e) {
            ArchiUi.LOG.error("CreateArchimateProjectHandler: \n\tCannot create an Archimate Project");
            ArchiUi.LOG.error(e);
        }

        // Open all diagrams on viewpoints
        for (AbstractDiagram diagram : diagrams) {
            if (!(diagram instanceof ViewPointDiagram)) {
                openDiagram(diagram, eventService);
            }
        }

    }

    @objid ("b13e829c-50a9-49f6-8b78-b47602986105")
    private void openDiagram(AbstractDiagram diagram, IModelioEventService eventService) {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                eventService.postAsyncEvent(new IModelioService() {
                    @Override
                    public String getName() {
                        return "openEditor : AbstractDiagram";
                    }
                }, ModelioEvent.EDIT_ELEMENT, diagram);
            }
        });

    }

    /**
     *
     * @param selection the current platform selection.
     * @param projectService the project service, to get session and metamodel from.
     * @return <code>true</code> if the project can be created, <code>false</code> otherwise.
     */
    @objid ("4f1eb5a2-a240-49d5-a9b1-e21f24ecea22")
    @CanExecute
    public boolean canExecute(@Named (IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection, IProjectService projectService) {
        if (projectService.getSession() == null) {
            return false;
        }

        if (selection.size() != 1) {
            return false;
        }

        // Fragment checks
        IGModelFragment fragment = SelectionHelper.getFirst(selection, IGModelFragment.class);
        if (! fragment.getAccessRights().isEditable()) {
            return false;
        }

        SmClass mClass = projectService.getSession().getMetamodel().getMClass(ArchimateProject.class);
        if (mClass == null) {
            return false;
        }
        for (MObject umlProject : fragment.getRepository().findByClass(mClass, true)) {
            if (umlProject.isValid()) {
                return false;
            }
        }
        return true;
    }

}
