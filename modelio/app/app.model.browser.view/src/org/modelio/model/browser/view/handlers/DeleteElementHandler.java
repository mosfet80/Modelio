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
package org.modelio.model.browser.view.handlers;

import java.text.MessageFormat;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.metamodel.diagrams.DiagramSet;
import org.modelio.metamodel.uml.infrastructure.AbstractProject;
import org.modelio.model.browser.view.plugin.BrowserViewActivator;
import org.modelio.platform.core.project.ICurrentProjectService;
import org.modelio.platform.model.ui.swt.InputHelper;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.TransactionException;
import org.modelio.vcore.smkernel.AccessDeniedException;
import org.modelio.vcore.smkernel.IllegalModelManipulationException;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Basic "delete element" handler.
 * Available only when the selected elements are modifiable.
 */
@objid ("96ed3002-13a8-11e2-8060-002564c97630")
public class DeleteElementHandler {
    @objid ("9b72925a-13a8-11e2-8060-002564c97630")
    @Inject
    protected ICurrentProjectService projectService;

    /**
     * Available only when the selected elements are modifiable.
     *
     * @param selection the current modelio selection.
     * @return true if the handler can be executed.
     */
    @objid ("9b72e083-13a8-11e2-8060-002564c97630")
    @CanExecute
    public final boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) final Object selection) {
        // Sanity checks
        if (this.projectService.getSession() == null) {
            return false;
        }

        // Must have at least an element
        List<MObject> selectedElements = InputHelper.toList(selection, MObject.class);
        if (selectedElements.isEmpty()) {
            return false;
        }

        for (MObject element : selectedElements) {
            if (! canDeleteElement(element)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Delete the currently selected elements.
     *
     * @param selection the current modelio selection.
     */
    @objid ("9b744038-13a8-11e2-8060-002564c97630")
    @Execute
    public final void execute(@Named(IServiceConstants.ACTIVE_SELECTION) final Object selection) {
        // Sanity checks
        if (this.projectService.getSession() == null) {
            return;
        }

        // Must have at least an element
        List<MObject> selectedElements = InputHelper.toList(selection, MObject.class);
        if (selectedElements.isEmpty()) {
            return;
        }


        String transactionName = MessageFormat.format("Delete {0,choice,0#nothing|1#\"{1}\" {2}|1<{0} elements}."
                , selectedElements.size()
                , selectedElements.get(0).getName()
                , selectedElements.get(0).getMClass().getName());

        BrowserViewActivator.LOG.debug(transactionName);

        try (ITransaction t = this.projectService.getSession().getTransactionSupport().createTransaction(transactionName)) {
            for (MObject element : selectedElements) {
                element.delete();
            }
            t.commit();
        } catch (AccessDeniedException | IllegalModelManipulationException | TransactionException e) {
            BrowserViewActivator.LOG.warning(e);
            MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", e.getLocalizedMessage());
        }
    }

    @objid ("cef72ab7-4ba3-4245-9a60-cd41168a1896")
    private boolean canDeleteElement(MObject element) {
        MObject owner = element.getCompositionOwner();
        // cannot delete root diagram set
        if (element instanceof DiagramSet) {
            return false;
        }

        if (element instanceof AbstractProject && element.getStatusLazy().isCmsManaged()) {
            // SVN managed Sub project cannot be deleted with this command:
            // their deletion is not undoable and is immediately SVN committed.
            return false;
        }

        if (owner != null && !MTools.getAuthTool().canRemoveFrom(element, owner)) {
            return false;
        }
        return true;
    }

}
