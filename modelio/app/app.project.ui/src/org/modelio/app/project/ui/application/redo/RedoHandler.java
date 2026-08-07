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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.app.project.ui.application.redo;

import java.util.Optional;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.statusreporter.StatusReporter;
import org.eclipse.e4.ui.model.application.ui.menu.MItem;
import org.eclipse.swt.widgets.ToolItem;
import org.modelio.app.project.ui.plugin.AppProjectUi;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.transactions.IUndoRedoSupport;
import org.modelio.vcore.session.api.transactions.TransactionRollbackFailedException;

/**
 * Handler for 'redo' command.
 */
@objid ("d40927a5-3259-11e2-ad6b-002564c97630")
public class RedoHandler {
    @objid ("d40927a6-3259-11e2-ad6b-002564c97630")
    @Execute
    public void execute(final IProjectService projectService, StatusReporter statusReporter) {
        try {
            AppProjectUi.LOG.info("Redo transaction");
            ICoreSession session = projectService.getSession();
            session.getTransactionSupport().getUndoRedoSupport().redo();
        } catch (TransactionRollbackFailedException e) {
            // Redo failed AND undoing the redo also failed !
            AppProjectUi.LOG.error(e);

            statusReporter.show(StatusReporter.ERROR, AppProjectUi.I18N.getMessage("RedoHandler.TransactionRollbackFailedException"), e);
        } catch (RuntimeException e) {
            AppProjectUi.LOG.error(e);
            statusReporter.show(StatusReporter.ERROR, AppProjectUi.I18N.getMessage("RedoHandler.Failed"), e);
        }
    }

    @objid ("d40927ab-3259-11e2-ad6b-002564c97630")
    @CanExecute
    public boolean canExecute(final IProjectService projectService, @org.eclipse.e4.core.di.annotations.Optional MItem item, @org.eclipse.e4.core.di.annotations.Optional ToolItem swtItem) {
        ICoreSession session = projectService.getSession();
        if (session==null)
            return false;

        IUndoRedoSupport undoRedoSupport = session.getTransactionSupport().getUndoRedoSupport();

        Optional<String> firstUndoable = undoRedoSupport.streamRedoStack().findFirst();
        if (firstUndoable.isEmpty()) {
            updateLabels(item, swtItem, AppProjectUi.I18N.getMessage("RedoHandler.nothing"));
            return false;
        }

        if (!undoRedoSupport.hasRedo())
            return false;

        updateLabels(item, swtItem, AppProjectUi.I18N.getMessage("RedoHandler.label", firstUndoable.get()));
        return true;
    }

    @objid ("94710c9d-bdfd-49e3-a0b9-be323e4f378c")
    private void updateLabels(MItem e4Item, ToolItem swtItem, String label) {
        if (e4Item != null) {
            e4Item.setLabel(label);
            e4Item.setTooltip(label);
        }
        if (swtItem != null) {
            swtItem.setText("");
            swtItem.setToolTipText(label);
        }
    }

}
