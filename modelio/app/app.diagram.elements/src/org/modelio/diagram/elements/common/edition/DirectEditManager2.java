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
package org.modelio.diagram.elements.common.edition;

import java.util.ArrayList;
import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmObject;

/**
 * Specialization of GEF {@link DirectEditManager} that temporarily disables context key bindings during edition.<br>
 * Key bindings are restored when edition is done.
 * <p>
 * <b>Note:</b> when redefining the {@link #initCellEditor()} method, do not forget to call the super method.
 */
@objid ("7e2e72d8-1dec-11e2-8cad-001ec947c8cc")
public abstract class DirectEditManager2 extends DirectEditManager {
    @objid ("dd437a93-62fb-4fe3-a6c5-cf6022900e6a")
    private Collection<String> activeContexts;

    @objid ("f88905f6-c0c5-4e33-9c35-e0ab944acc71")
    private EContextService contextService;

    @objid ("68f9370a-2e23-4bb0-9c58-eb98fecc01b3")
    private Runnable refreshEnabler;

    /**
     * Constructs a new DirectEditManager2 for the given source edit part. The cell editor will be created by
     * instantiating the type <i>editorType</i>. The cell editor will be placed using the given CellEditorLocator.
     *
     * @param source the source edit part
     * @param editorType the cell editor type
     * @param locator the locator
     */
    @objid ("7e2e72dc-1dec-11e2-8cad-001ec947c8cc")
    public DirectEditManager2(GraphicalEditPart source, Class<? extends CellEditor> editorType, CellEditorLocator locator) {
        super(source, editorType, locator);
    }

    /**
     * Constructs a new DirectEditManager2 for the given source edit part. The cell editor will be created by
     * instantiating the type <i>editorType</i>. The cell editor will be placed using the given CellEditorLocator.
     *
     * @param source the source edit part
     * @param editorType the cell editor type
     * @param locator the locator
     * @param feature If the EditPart supports direct editing of multiple features, this parameter can be used to
     * discriminate among them.
     * @since phv
     */
    @objid ("7e2e72e8-1dec-11e2-8cad-001ec947c8cc")
    public DirectEditManager2(GraphicalEditPart source, Class<? extends CellEditor> editorType, CellEditorLocator locator, Object feature) {
        super(source, editorType, locator, feature);
    }

    /**
     * <b>Note:</b> when redefining, do not forget to call the {@link DirectEditManager#initCellEditor()} super method.
     */
    @objid ("7e2e72f5-1dec-11e2-8cad-001ec947c8cc")
    @Override
    protected void initCellEditor() {
        IGmDiagram gmDiagram = ((IGmObject)getEditPart().getModel()).getDiagram();

        // Suspend refresh of the diagram while something is being edited
        this.refreshEnabler = gmDiagram.suspendRefresh();
        getCellEditor().getControl().addDisposeListener(ev -> reactivateRefresh());

        // keep contextService in a field because in some corner case the GmDiagram is disposed in #bringDown()
        this.contextService = gmDiagram.getModelManager().getContextService();

        // Store those contexts for further reactivation
        this.activeContexts = new ArrayList<>(this.contextService.getActiveContextIds());
        for (String contextId : this.activeContexts) {
            this.contextService.deactivateContext(contextId);
        }
    }

    @objid ("31eba330-718b-40fd-8708-5dc0fa7312f9")
    private void reactivateRefresh() {
        if (this.refreshEnabler == null)
            return;

        // Reactivate refresh asynchronously to avoid reentrant call to bringDown()
        Display.getDefault().asyncExec(() -> {
            if (this.refreshEnabler == null)
                return;
            this.refreshEnabler.run();
            this.refreshEnabler = null;
        });
    }

    @objid ("7e30d532-1dec-11e2-8cad-001ec947c8cc")
    @Override
    protected void bringDown() {
        // Restore previously deactivated contexts
        if (this.activeContexts != null) {
            for (String contextId : this.activeContexts) {
                this.contextService.activateContext(contextId);
            }
            this.activeContexts = null;
        }

        super.bringDown();

        // Reactivate refresh at the end, it may trigger reentrant call to bringDown()
        reactivateRefresh();
    }

}
