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
package org.modelio.archimate.exchange.ui.imports;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy.ExchangeFormatVersion;
import org.modelio.archimate.exchange.service.exception.ArchimateException;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.platform.core.project.ICurrentProjectService;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.vcore.smkernel.AccessDeniedException;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("cd49b1c4-bbf9-4264-938f-63fa994c749a")
public class ArchiImportHandler {
    @objid ("9c77badb-2a8c-4989-9b31-5d30082fb001")
    @Execute
    public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection, @Named(IServiceConstants.ACTIVE_SHELL) final Shell activeShell, ICurrentProjectService projectService, IEclipseContext eclipseContext) {
        Object context = SelectionHelper.getFirst(selection, IGModelFragment.class);
        if (context == null) {
            context = SelectionHelper.getFirst(selection, Element.class);
        }

        ArchiImportModel model = new ArchiImportModel();
        model.setKeepId(false);

        model.setVersion(ExchangeFormatVersion.V31);

        ArchiImportDialog dialog = new ArchiImportDialog(activeShell, model);
        if (dialog.open() == IDialogConstants.OK_ID) {
            IDiagramService diagramService = eclipseContext.get(IModuleContext.class).getModelioServices().getDiagramService();
            importArchiModel(context, model, projectService, diagramService, activeShell);
        }
    }

    @objid ("43757867-6a84-4f5b-bdd7-89fcc8fb9e29")
    private void importArchiModel(Object context, ArchiImportModel model, ICurrentProjectService projectService, IDiagramService diagramService, Shell activeShell) {
        File target = new File(model.getImportPath());
        target.getParentFile().mkdirs();
        ArchimateExchangeProxy importService = new ArchimateExchangeProxy(projectService.getSession(), diagramService, model.getVersion());

        IRunnableWithProgress runnable = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                try {
                    importService.setProgressMonitor(monitor);
                    importService.importArchimateModel(target.toPath(), context, model.isKeepId(),model.isApplyNativeStyle());
                } catch (ArchimateException ex) {
                    throw new InvocationTargetException(ex, ex.getLocalizedMessage());
                }
            }
        };

        try {
            new ProgressMonitorDialog(activeShell).run(true, false, runnable);
            MessageDialog.openInformation(activeShell, ArchiExchange.I18N.getMessage("ui.command.import.success.title"), ArchiExchange.I18N.getMessage("ui.command.import.success.message", target.getName()));
        } catch (InvocationTargetException ex) {
            ArchiExchange.LOG.error(ex);
            if(ex.getTargetException() instanceof AccessDeniedException) {
                MessageDialog.openError(activeShell, ArchiExchange.I18N.getMessage("ui.command.import.faillure.title"), ArchiExchange.I18N.getMessage("ui.command.import.faillure.access.message", ex.getTargetException().getLocalizedMessage()));
            }
            else {
                MessageDialog.openError(activeShell, ArchiExchange.I18N.getMessage("ui.command.import.faillure.title"), ArchiExchange.I18N.getMessage("ui.command.import.faillure.message", ""));
            }
        } catch (InterruptedException ex) {
            // nothing
        }
    }

    @objid ("80e6dcee-d300-4677-9f3f-1512406cc1e6")
    @CanExecute
    public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection) {
        final List<MObject> selectedElements = SelectionHelper.toList(selection, MObject.class);
        final List<IGModelFragment> selectedFragments = SelectionHelper.toList(selection, IGModelFragment.class);
        if (selectedElements.size() != 1 && selectedFragments.size() != 1) {
            return false;
        }
        if (selectedElements.size() == 1) {
            MObject mObject = selectedElements.get(0);
            return (mObject instanceof ArchimateProject);
        } else if (selectedFragments.size() == 1) {
            return true;
        }
        return false;
    }

}
