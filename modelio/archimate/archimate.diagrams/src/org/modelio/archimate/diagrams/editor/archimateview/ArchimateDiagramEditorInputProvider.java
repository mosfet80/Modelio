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
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.diagram.editor.DiagramEditorInput;
import org.modelio.diagram.editor.IDiagramEditorInputProvider;
import org.modelio.diagram.editor.IDiagramEditorInputProvider.GmDiagramCreator;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Diagram input provider for {@link ArchimateView} metaclasses.
 */
@objid ("37dfa4fa-cbc7-4212-882f-45287fc7aa4a")
public class ArchimateDiagramEditorInputProvider implements IDiagramEditorInputProvider {
    /**
     * Initialize the provider.
     */
    @objid ("3393f0a9-efa7-401f-b203-1db789879694")
    public ArchimateDiagramEditorInputProvider() {
        super();
    }

    @objid ("fbf15848-7540-4a8c-83f5-49d7e8dc3766")
    @Override
    public DiagramEditorInput compute(String diagramUid, IModelManager modelManager) {
        AbstractDiagram diagram = (AbstractDiagram) modelManager.getModelServices().findByRef(new MRef(ArchimateView.MQNAME, diagramUid));
        return diagram != null ? new ArchimateDiagramEditorInput(modelManager, diagram, getDiagramCreator()) : null;
    }

    @objid ("3b5095a2-04f8-46ca-9c57-c3545acc816c")
    @Override
    public DiagramEditorInput compute(AbstractDiagram diagram, IModelManager modelManager) {
        return diagram instanceof ArchimateView ? new ArchimateDiagramEditorInput(modelManager, diagram, getDiagramCreator()) : null;
    }

    @objid ("e21b3202-a368-4cf1-8020-cc5502c02437")
    @Override
    public GmDiagramCreator getDiagramCreator() {
        return new ArchimateGmDiagramCreator();
    }

}
