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
package org.modelio.archimate.diagrams.editor.wizard;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Named;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.plugin.DiagramElements;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.platform.core.navigate.IModelioNavigationService;
import org.modelio.platform.core.project.ICurrentProjectService;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.ITransactionSupport;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("657c5d83-9b99-449a-ae1a-a9653aa9e8e2")
public class ModelTransformHandler {
    @objid ("98ab5222-11f0-46be-8b94-8a2196d98578")
    @Execute
    public void execute(@Named("transformerindex") String transformerindex, @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection, ICurrentProjectService projectService, IEclipseContext context) {
        IModelTransformer transformer = TransformerRegistry.getInstance(context).getTransformer(Integer.parseInt(transformerindex));

        // Get the modeling session and open a transaction
        ICoreSession modelingSession = projectService.getSession();
        ITransactionSupport transactionManager = modelingSession.getTransactionSupport();
        String actionName = String.format("Run %s Model transformer on %s", transformer.getClass().getSimpleName(), SelectionHelper.toList(selection, MObject.class));
        try (ITransaction transaction = transactionManager.createTransaction(actionName)) {
            transformer.transform(selection);

            // Commit the transaction.
            transaction.commit();
        } catch (Exception e) {
            DiagramElements.LOG.error("%s failed: %s", actionName, e);
            DiagramElements.LOG.error(e);

            MessageDialog.openError(Display.getCurrent().getActiveShell(), "Model transformation failed", "An unexpected error occurred, please send Modelio log file to the support team.");
        }
    }

    @objid ("d953a464-0008-4b46-ad86-de8b12bd1910")
    @CanExecute
    public boolean canExecute(@Named("transformerindex") String transformerindex, final IModelioNavigationService navigationService, @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection, IEclipseContext context) {
        EditPart ep = SelectionHelper.getFirst(selection, EditPart.class);
        if (ep == null) {
            return false;
        }

        AbstractDiagram diagram = ((GmModel) ep.getModel()).getDiagram().getRelatedElement();
        IModelTransformer transformer = TransformerRegistry.getInstance(context).getTransformer(Integer.parseInt(transformerindex));

        if (transformer == null || !transformer.canExecute(diagram, selection)) {
            return false;
        }

        // Check if diagram is modifiable
        if (!diagram.isModifiable()) {
            return false;
        }


        // Check all elements and their folders
        for (MObject element : SelectionHelper.toList(selection, MObject.class)) {
            if (!element.isModifiable())
                return false;

            MObject parent = element.getCompositionOwner();
            if (parent != null && !parent.isModifiable())
                return false;

            // Check target folder for ArchiMate transformations
            String targetFolderType = extractFolderType(transformer.getTargetMetaclassName());
            if (targetFolderType != null) {
                MObject targetFolder = getTargetFolder(element, transformer.getTargetMetaclassName());

                if (targetFolder == null)
                    return false;

                if (!targetFolder.isModifiable())
                    return false;
            }


            if (element instanceof Concept) {
                Concept concept = (Concept) element;

                // Check incoming relationship
                for (Relationship relationship : new ArrayList<>(concept.getRelatedFrom())) {
                    if (!(relationship.getFrom().isModifiable())) {
                        return false;
                    }
                }

                // Check related diagram
                for( AbstractDiagram diag: concept.getDiagramElement()) {
                    if (!(diag.isModifiable())) {
                        return false;
                    }
                }

                //Check incomming dependencies
                for (Dependency dep : concept.getImpactedDependency() ) {
                     if (!(dep.isModifiable())) {
                         return false;
                     }
                }

            }else {
                // Check Concept Archimate
                return false;
            }
        }

        return true;
    }

    /**
     * Check if all ArchiMate views containing this element are modifiable
     */
    @objid ("5ba111c1-c1a2-41db-b236-712770224800")
    private boolean areAllRelatedArchimateViewsModifiable(MObject element) {
        try {
            // Find ArchiMate Model
            MObject model = element;
            while (model != null && !model.getMClass().getName().equals("Model")) {
                model = model.getCompositionOwner();
            }

            if (model == null) return true;

            // Check all ArchiMate views in the model
            for (MObject child : model.getCompositionChildren()) {
                if ("ArchimateView".equals(child.getMClass().getName())) {
                    AbstractDiagram archimateView = (AbstractDiagram) child;

                    // Check if this element is used in this view
                    if (isElementUsedInView(element, archimateView)) {
                        if (!archimateView.isModifiable()) {
                            return false;
                        }
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if an element is used in a specific ArchiMate view
     */
    @objid ("47a0581f-d374-4dac-85dd-8a7d20a1460e")
    private boolean isElementUsedInView(MObject element, AbstractDiagram view) {
        try {
            return view.getRepresented().contains(element);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get target folder for the transformation
     */
    @objid ("80b5e0db-1184-4438-9160-0160a4344a59")
    private MObject getTargetFolder(MObject element, String targetMetaclass) {
        // Find ArchiMate Model
        MObject model = element;
        while (model != null && !model.getMClass().getName().equals("Model")) {
            model = model.getCompositionOwner();
        }

        if (model == null) return null;

        String targetFolderType = extractFolderType(targetMetaclass);
        if (targetFolderType == null) return null;

        // Find matching folder
        for (MObject folder : model.getCompositionChildren()) {
            if (targetFolderType.equals(folder.getMClass().getName())) {
                return folder;
            }
        }

        return null;
    }

    /**
     * Extract folder type from metaclass name
     */
    @objid ("c2962f86-4c6b-48a9-b56a-8c33000e6209")
    private String extractFolderType(String targetMetaclass) {
        // Physical elements
        if (targetMetaclass.contains("Facility") || targetMetaclass.contains("Equipment") ||
                targetMetaclass.contains("DistributionNetwork") || targetMetaclass.contains("Material")) {
            return "PhysicalFolder";
        }
        // Technology elements
        else if (targetMetaclass.contains("Node") || targetMetaclass.contains("Device") ||
                targetMetaclass.contains("SystemSoftware") || targetMetaclass.contains("TechnologyCollaboration") ||
                targetMetaclass.contains("TechnologyInterface") || targetMetaclass.contains("TechnologyInteraction") || targetMetaclass.contains("TechnologyProcess") ||
                targetMetaclass.contains("TechnologyFunction") || targetMetaclass.contains("TechnologyService") ||
                targetMetaclass.contains("TechnologyEvent") || targetMetaclass.contains("Artifact") ||
                targetMetaclass.contains("CommunicationNetwork") || targetMetaclass.contains("Path")) {
            return "TechnologyFolder";
        }
        // Application elements
        else if (targetMetaclass.contains("ApplicationComponent") || targetMetaclass.contains("ApplicationCollaboration") ||
                targetMetaclass.contains("ApplicationInterface") || targetMetaclass.contains("ApplicationInteraction") || targetMetaclass.contains("ApplicationProcess") ||
                targetMetaclass.contains("ApplicationFunction") || targetMetaclass.contains("ApplicationService") ||
                targetMetaclass.contains("ApplicationEvent") || targetMetaclass.contains("DataObject")) {
            return "ApplicationFolder";
        }
        // Business elements
        else if (targetMetaclass.contains("BusinessActor") || targetMetaclass.contains("BusinessRole") ||
                targetMetaclass.contains("BusinessCollaboration") || targetMetaclass.contains("BusinessInterface") ||
                targetMetaclass.contains("BusinessProcess") || targetMetaclass.contains("BusinessFunction") || targetMetaclass.contains("BusinessInteraction") ||
                targetMetaclass.contains("BusinessService") || targetMetaclass.contains("BusinessEvent") ||
                targetMetaclass.contains("BusinessObject") || targetMetaclass.contains("Contract") ||
                targetMetaclass.contains("Representation") || targetMetaclass.contains("Product")){
            return "BusinessFolder";
        }
        // Strategy elements
        else if (targetMetaclass.contains("Resource") || targetMetaclass.contains("Capability") ||
                targetMetaclass.contains("CourseOfAction") || targetMetaclass.contains("ValueStream")) {
            return "StrategyFolder";
        }
        // Motivation elements
        else if (targetMetaclass.contains("Stakeholder") || targetMetaclass.contains("Driver") ||
                targetMetaclass.contains("Assessment") || targetMetaclass.contains("Goal") ||
                targetMetaclass.contains("Outcome") || targetMetaclass.contains("Principle") ||
                targetMetaclass.contains("Requirement") || targetMetaclass.contains("Constraint") ||
                targetMetaclass.contains("Meaning") || targetMetaclass.contains("Value")) {
            return "MotivationFolder";
        }
        // Implementation elements
        else if (targetMetaclass.contains("WorkPackage") || targetMetaclass.contains("Deliverable") ||
                targetMetaclass.contains("ImplementationEvent") || targetMetaclass.contains("Plateau") ||
                targetMetaclass.contains("Gap")) {
            return "ImplementationFolder";
        }
        else if (targetMetaclass.contains("Location") || targetMetaclass.contains("Grouping")) {
            return null;
        }

        return null;
    }

}
