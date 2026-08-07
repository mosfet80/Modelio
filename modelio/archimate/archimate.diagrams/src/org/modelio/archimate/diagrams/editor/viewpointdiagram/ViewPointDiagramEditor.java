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
package org.modelio.archimate.diagrams.editor.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.editor.AbstractDiagramEditor;

/**
 * Graphical Editor for ViewPoint Diagrams.
 */
@objid ("595ce087-379f-48af-aa30-72aca5762496")
public class ViewPointDiagramEditor extends AbstractDiagramEditor {
    /**
     * public ID of this editor.
     */
    @objid ("b1c70237-7d61-45a5-916c-c294dc52bf8c")
    public static final String ID = "org.modelio.archimate.diagrams.ViewPointDiagramEditorID";

    @objid ("be66d9d2-dd89-4d82-9d55-db029940ffdd")
    private static final String POPUP_ID = "org.modelio.archimate.diagrams.menu.popupmenu";

    /**
     * C'tor.
     */
    @objid ("2aa6d439-0c08-4dd2-a008-eab78a8344e5")
    public ViewPointDiagramEditor() {
        super();
    }

    @objid ("58da4475-5b95-473b-ae51-87b4844037ec")
    @Override
    protected String getPopupId() {
        return ViewPointDiagramEditor.POPUP_ID;
    }

}
