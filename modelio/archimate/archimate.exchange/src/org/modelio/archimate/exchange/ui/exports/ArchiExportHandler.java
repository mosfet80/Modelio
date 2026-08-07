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
package org.modelio.archimate.exchange.ui.exports;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
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
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.platform.core.project.ICurrentProjectService;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.ui.desktop.SystemOpener;

@objid ("d42590ca-8f71-45b4-8009-f0e15c8c2130")
public class ArchiExportHandler {
    @objid ("8d30efd6-055f-4175-8346-7af6b5d8e312")
    private static final String ARCHIMATE_SUBDIR = "ArchiMate";

    /**
     * Allow execution if the selection contains:
     * <ul>
     * <li>a Models</li>
     * <li>ArchiMate projects with at least one model</li>
     * </ul>
     *
     * @param selection the current selection in Modelio.
     * @return <code>true</code> if the command can be executed.
     */
    @objid ("12e10167-bc64-472b-ae93-9195798c9b78")
    @CanExecute
    public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection) {
        for (Object o : selection.toArray()) {
            if (!(o instanceof ArchimateProject || o instanceof Model)) {
                return false;
            }
        }
        return getSelectedModels(selection).size() > 0;
    }

    @objid ("bf9b358e-cee3-43d0-83fc-5d5b3a6fb164")
    @Execute
    public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) final IStructuredSelection selection, @Named(IServiceConstants.ACTIVE_SHELL) final Shell activeShell, ICurrentProjectService projectService, IEclipseContext eclipseContext) {
        Collection<Model> models = getSelectedModels(selection);

        ArchiExportModel dlgModel = new ArchiExportModel();

        dlgModel.setVersion(ExchangeFormatVersion.V31);

        Path projectSpacePath = projectService.getOpenedProject().getPfs().getProjectPath();
        boolean isMultiModel = models.size() > 1;
        if (isMultiModel) {
            dlgModel.setExportPath(projectSpacePath.resolve(ArchiExportHandler.ARCHIMATE_SUBDIR).toString());
        } else {
            dlgModel.setExportPath(projectSpacePath.resolve(ArchiExportHandler.ARCHIMATE_SUBDIR).resolve(models.iterator().next().getProject().getName() + ".xml").toString());
        }

        ArchiExportDialog dialog = new ArchiExportDialog(activeShell, dlgModel, isMultiModel);
        if (dialog.open() == IDialogConstants.OK_ID) {
            IDiagramService diagramService = eclipseContext.get(IModuleContext.class).getModelioServices().getDiagramService();

            exportArchiModel(models,
                    Paths.get(dlgModel.getExportPath()),
                    dlgModel.getVersion(),
                    diagramService,
                    projectService,
                    activeShell);
        }
    }

    @objid ("01d3dfd3-efbb-4a36-9ed4-fda1f1bac606")
    private void exportArchiModel(Collection<Model> models, Path exportPath, ExchangeFormatVersion version, IDiagramService diagramService, ICurrentProjectService projectService, Shell activeShell) {
        ArchimateExchangeProxy exportService = new ArchimateExchangeProxy(projectService.getSession(), diagramService, version);

        IRunnableWithProgress runnable = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                try {

                    if (models.size() > 1) {
                        SubMonitor mon = SubMonitor.convert(monitor, models.size());
                        Files.createDirectories(exportPath);

                        for (Entry<String, List<Model>> entry : models
                                .stream()
                                .collect(Collectors.groupingBy(m -> m.getName()))
                                .entrySet()) {
                            if (entry.getValue().size() > 1) {
                                // file name = "projectname_modelname.xml"
                                for (Model model : entry.getValue()) {
                                    Path targetFile = exportPath.resolve(model.getProject().getName() + "_" + model.getName() + ".xml");
                                    exportService.setProgressMonitor(mon.newChild(1));
                                    exportService.exportArchimateModel(targetFile, model);
                                }
                            } else {
                                for (Model model : entry.getValue()) {
                                    Path targetFile = exportPath.resolve(model.getName() + ".xml");
                                    exportService.setProgressMonitor(mon.newChild(1));
                                    exportService.exportArchimateModel(targetFile, model);
                                }
                            }
                        }
                    } else {
                        Files.createDirectories(exportPath.getParent());
                        exportService.setProgressMonitor(monitor);
                        exportService.exportArchimateModel(exportPath, models.iterator().next());
                    }
                } catch (IOException | ArchimateException ex) {
                    throw new InvocationTargetException(ex, ex.getLocalizedMessage());
                } catch (CancellationException e) {
                    throw (InterruptedException) new InterruptedException().initCause(e);
                }
            }
        };

        try {
            new ProgressMonitorDialog(activeShell).run(true, false, runnable);

            if (models.size() == 1) {
                MessageDialog.openInformation(activeShell,
                        ArchiExchange.I18N.getMessage("ui.command.export.success.title"),
                        ArchiExchange.I18N.getMessage("ui.command.export.success.message.1",
                                models.iterator().next().getName(),
                                exportPath.toString()));

                //openInExplorer(exportPath.getParent());
            } else {
                MessageDialog.openInformation(activeShell,
                        ArchiExchange.I18N.getMessage("ui.command.export.success.title"),
                        ArchiExchange.I18N.getMessage("ui.command.export.success.message.n",
                                models.size(),
                                exportPath.toString()));

                //openInExplorer(exportPath);
            }
        } catch (InvocationTargetException ex) {
            ArchiExchange.LOG.error(ex);
            MessageDialog.openError(activeShell,
                    ArchiExchange.I18N.getMessage("ui.command.export.faillure.title"),
                    ArchiExchange.I18N.getMessage("ui.command.export.faillure.message",
                            exportPath.getFileName()));
        } catch (InterruptedException ex) {
            // operation canceled
        }
    }

    @objid ("5feac9d7-828f-41ae-b939-e0bf968207f8")
    private Collection<Model> getSelectedModels(final IStructuredSelection selection) {
        Collection<ArchimateProject> projects = SelectionHelper.toList(selection, ArchimateProject.class);
        Collection<Model> models = new HashSet<>(SelectionHelper.toList(selection, Model.class));

        for (ArchimateProject proj : projects) {
            models.addAll(proj.getModel());
        }
        return models;
    }

    @objid ("2679f47c-d61a-40dd-9660-b687974f81c7")
    private void openInExplorer(Path exportPath) {
        try {
            SystemOpener.open(exportPath);
        } catch (IOException | RuntimeException e) {
            ArchiExchange.LOG.warning(e);
        }
    }

}
