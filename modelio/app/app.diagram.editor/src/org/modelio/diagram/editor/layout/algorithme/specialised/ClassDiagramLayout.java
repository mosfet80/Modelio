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
package org.modelio.diagram.editor.layout.algorithme.specialised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkCompositeLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.TreeLayout;
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * ClassDiagramLayout is a specialized layout algorithm for class diagrams.
 * It extends the DefaultElkCompositeLayout to provide specific configurations for class diagrams.
 */
@objid ("5a9597c6-4bb5-4420-9a70-469d66d4d860")
public class ClassDiagramLayout extends DefaultElkCompositeLayout {
    @objid ("368ff013-4176-4a38-8dad-db56d5b407ac")
    public ClassDiagramLayout() {
        super(new LayeredLayout());
    }

    /**
     * Indentify Sub Layout in Diagram.
     * Extract Tree based on Generalisation and InterfaceRealization links to create sub-layouts.
     */
    @objid ("0944bd64-5f3d-443c-b286-1d1ea05e1feb")
    @Override
    public List<ILayoutAlgorithme> getSubLayoutAlgorithmes() {
        if (this.getDiagram() == null || this.getDiagramService() == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        Map<MObject, ILayoutAlgorithme> subAlgoMap = new HashMap<>();
        try (IDiagramHandle handle = this.getDiagramService().getDiagramHandle(this.getDiagram())) {
            for (IDiagramLink linkDg : handle.getDiagramNode().getLinks()) {

                if (!(linkDg.getElement() instanceof Generalization || linkDg.getElement() instanceof InterfaceRealization)) {
                    continue;
                }

                IDiagramGraphic source = linkDg.getFrom();
                IDiagramGraphic target = linkDg.getTo();

                // We Search Generalisation
                if (!(source instanceof IDiagramNode) || !(target instanceof IDiagramNode)) {
                    continue;
                }

                // We search link between two nodes that are in the same composition
                if (!source.getElement().getCompositionOwner().equals(target.getElement().getCompositionOwner())) {
                    continue;
                }

                if (subAlgoMap.get(source.getElement()) == null && subAlgoMap.get(target.getElement()) == null) {
                    // New Tree
                    ILayoutAlgorithme subAlgo = new TreeLayout() {
                        @Override
                        public void applyLayoutToModel(IDiagramHandle diagramHandle) {
                            // Nothing to do here, the layout is already applied to the model
                        }

                        @Override
                        public   void compactDiagramBounds(int PADDING) {
                            // Nothing to do here, the layout is already applied to the model
                        }
                    };
                    subAlgo.withDiagram(getDiagram(), getDiagramService()).withSelection(Arrays.asList((IDiagramNode) source, (IDiagramNode) target));
                    subAlgoMap.put(target.getElement(), subAlgo);
                    subAlgoMap.put(source.getElement(), subAlgo);
                } else if (subAlgoMap.get(source.getElement()) != null && subAlgoMap.get(target.getElement()) == null) {
                    // Add target to existing source subAlgo
                    ILayoutAlgorithme subAlgo = subAlgoMap.get(source.getElement());
                    List<IDiagramNode> selection = new ArrayList<>(subAlgo.getSelection());
                    selection.add((IDiagramNode) target);
                    subAlgo.withSelection(selection);
                    subAlgoMap.put(target.getElement(), subAlgo);
                } else if (subAlgoMap.get(source.getElement()) == null && subAlgoMap.get(target.getElement()) != null) {
                    // Add source to existing target subAlgo
                    ILayoutAlgorithme subAlgo = subAlgoMap.get(target.getElement());
                    List<IDiagramNode> selection = new ArrayList<>(subAlgo.getSelection());
                    selection.add((IDiagramNode) source);
                    subAlgo.withSelection(selection);
                    subAlgoMap.put(source.getElement(), subAlgo);
                } else if (subAlgoMap.get(source.getElement()) != null && subAlgoMap.get(target.getElement()) != null) {
                    // Both source and target are already in subAlgoMap, merge them
                    ILayoutAlgorithme subAlgoSource = subAlgoMap.get(source.getElement());
                    ILayoutAlgorithme subAlgoTarget = subAlgoMap.get(target.getElement());
                    if (subAlgoSource != subAlgoTarget) {
                        List<IDiagramNode> selection = new ArrayList<IDiagramNode>(subAlgoSource.getSelection());
                        selection.addAll(subAlgoTarget.getSelection());
                        subAlgoSource.withSelection(selection);
                        subAlgoTarget.getSelection().forEach(slt -> {
                            subAlgoMap.put(slt.getElement(), subAlgoSource);
                        });
                    }
                }
            }
        }
        List<ILayoutAlgorithme> subLayoutAlgorithmes = new ArrayList<>();
        subAlgoMap.values().forEach(algo -> {
            if (!subLayoutAlgorithmes.contains(algo)) {
                subLayoutAlgorithmes.add(algo);
            }
        });
        return subLayoutAlgorithmes;
    }

}
