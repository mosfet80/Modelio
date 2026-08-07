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
import org.modelio.diagram.editor.DiagramEditorInput;
import org.modelio.diagram.editor.IDiagramEditorInputProvider.GmDiagramCreator;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * ViewPoint Diagram editor input.
 */
@objid ("c67a4a7f-d729-4a35-89a0-d9d510617e86")
public class ViewPointDiagramEditorInput extends DiagramEditorInput {
    /**
     * Initialize the editor input.
     * <p>
     * Creates the diagram graphic model and load it from the diagram model element.
     *
     * @param modelManager the link between the Gm model and the Ob model.
     * @param diagram the diagram to edit.
     * @param gmDiagramCreator a small factory to instanciate the Gm diagram itself.
     */
    @objid ("1d081aa8-b1ff-411f-a813-c7813543146b")
    public ViewPointDiagramEditorInput(IModelManager modelManager, AbstractDiagram diagram, GmDiagramCreator gmDiagramCreator) {
        super(diagram, modelManager, gmDiagramCreator);
    }

    @objid ("59cfc919-be20-4fbb-9087-a7d7d97ae62e")
    @Override
    public String getEditorId() {
        return ViewPointDiagramEditor.ID;
    }

}
