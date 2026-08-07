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
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.diagram.editor.DiagramEditorInput;
import org.modelio.diagram.editor.IDiagramEditorInputProvider;
import org.modelio.diagram.editor.IDiagramEditorInputProvider.GmDiagramCreator;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Diagram input provider for {@link ViewPointDiagram} metaclasses.
 */
@objid ("c70db296-b0ee-4950-b969-5e662ec0c3c0")
public class ViewPointDiagramEditorInputProvider implements IDiagramEditorInputProvider {
    /**
     * Initialize the provider.
     */
    @objid ("5434be2e-c63a-4a4e-b39b-0c6462b20a33")
    public ViewPointDiagramEditorInputProvider() {
        super();
    }

    @objid ("4e484a53-7628-4a7b-9b6b-cf8723924cfb")
    @Override
    public DiagramEditorInput compute(String diagramUid, IModelManager modelManager) {
        ViewPointDiagram diagram = (ViewPointDiagram) modelManager.getModelingSession().getModel().findByRef(new MRef(ViewPointDiagram.MQNAME, diagramUid));
        return diagram != null ? new ViewPointDiagramEditorInput(modelManager, diagram, getDiagramCreator()) : null;
    }

    @objid ("6965e4c8-56c2-4ea4-af29-4bb6bacc4fe0")
    @Override
    public DiagramEditorInput compute(AbstractDiagram diagram, IModelManager modelManager) {
        return diagram instanceof ViewPointDiagram ? new ViewPointDiagramEditorInput(modelManager, diagram, getDiagramCreator()) : null;
    }

    @objid ("6b11d6b3-82dc-4411-93da-27f30630b433")
    @Override
    public GmDiagramCreator getDiagramCreator() {
        return new ViewPointGmDiagramCreator();
    }

}
