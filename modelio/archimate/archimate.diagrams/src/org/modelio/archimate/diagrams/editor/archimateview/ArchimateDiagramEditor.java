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
package org.modelio.archimate.diagrams.editor.archimateview;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.editor.AbstractDiagramEditor;
import org.modelio.diagram.elements.core.figures.routers.AutoOrthogonalRouter;
import org.modelio.diagram.elements.core.link.ConnectionRoutingServices;

/**
 * Graphical Editor for Archimate Diagrams.
 */
@objid ("075fccac-02f7-48bd-83e8-1c75d7245757")
public class ArchimateDiagramEditor extends AbstractDiagramEditor {
    /**
     * public ID of this editor.
     */
    @objid ("323d19cc-52d0-4368-addc-5f21e76e0d50")
    public static final String ID = "org.modelio.archimate.diagrams.ArchimateDiagramEditorID";

    @objid ("72623854-61d0-46d8-b084-4066207c71ad")
    private static final String POPUP_ID = "org.modelio.archimate.diagrams.menu.popupmenu";

    /**
     * C'tor.
     */
    @objid ("44be7d4e-a77f-497b-9d54-88d6e30048fa")
    public ArchimateDiagramEditor() {
        super();
    }

    @objid ("2deeb623-fbe5-4929-a75a-ac6e3c72f556")
    @Override
    protected String getPopupId() {
        return ArchimateDiagramEditor.POPUP_ID;
    }

    /**
     * Change orthogonal router to new {@link AutoOrthogonalRouter}.
     *
     * @since 5.0.2
     */
    @objid ("7eed65d1-c9eb-4ebf-9696-46de4460822a")
    @Override
    protected ConnectionRoutingServices initializeConnectionRoutingServices() {
        return ConnectionRoutingServices.builder()
                .withAutoOrthogonalDefaults()
                .build();
    }

}
