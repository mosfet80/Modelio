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
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkNode;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkCompositeLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnSubProcessDiagram;

/**
 * BpmnProcessDesignDiagramLayout is a specialized layout algorithm for BPMN
 * process design diagrams.
 * It apply sub-layouts for each BpmnSubProcess in the diagram.
 */
@objid ("f02b0725-9d2b-4e64-833d-abaed53203cf")
public class BPMNProcessDiagramLayout extends DefaultElkCompositeLayout {
    @objid ("9b9ad29a-0615-4f61-8def-3263c37b0a6c")
    public BPMNProcessDiagramLayout() {
        super(new LayeredLayout());
    }

    /**
     * Identify SUb Layout Create a sub-layout for each BpmnSubProcess in the
     * diagram.
     */
    @objid ("0681d25c-752b-4e46-8803-57325908c8f1")
    @Override
    public List<ILayoutAlgorithme> getSubLayoutAlgorithmes() {
        if (getDiagram() == null || getDiagramService() == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        List<ILayoutAlgorithme> subLayouts = new ArrayList<>();
        List<IDiagramNode> subProcess = new ArrayList<>();

        try (IDiagramHandle handle = getDiagramService().getDiagramHandle(getDiagram())) {
            // Perform Specific algo for each Lane
            subProcess.addAll(getSubProcess(handle.getDiagramNode()));
        }

        subProcess.forEach(subprocessNode -> {
            BpmnSubProcess subProcessElement = (BpmnSubProcess) subprocessNode.getElement();
            if (!subProcessElement.getProduct().isEmpty()) {
                BpmnSubProcessDiagram diagram = (BpmnSubProcessDiagram) subProcessElement.getProduct().get(0);

                try (IDiagramHandle subProcessDiagram = getDiagramService().getDiagramHandle(diagram)) {
                    List<IDiagramNode> allChildren = getAllChildren(subProcessDiagram.getDiagramNode());
                    if (!allChildren.isEmpty()) {
                        BPMNProcessDiagramLayout subLayout = new BPMNProcessDiagramLayout();
                        subLayout.withDiagram(diagram, getDiagramService()).withSelection(allChildren);
                        subLayouts.add(subLayout);
                    }
                }
            }
        });

        return subLayouts;
    }

    @objid ("38c2c5ee-2bf6-4ebd-becd-146bcea9367c")
    public List<IDiagramNode> getSubProcess(IDiagramNode diagramNode) {
        List<IDiagramNode> lanes = new ArrayList<>();
        if (diagramNode.getElement() instanceof BpmnSubProcess) {
            if (diagramNode.getNodes().size() > 0) {
                lanes.add(diagramNode);
            }
        }
        diagramNode.getNodes().forEach(node -> {
            lanes.addAll(getSubProcess(node));
        });
        return lanes;
    }

    @objid ("43e8b184-7668-4f7c-9289-0e213e822afb")
    private List<IDiagramNode> getAllChildren(IDiagramNode node) {
        List<IDiagramNode> allChildren = new ArrayList<>();
        node.getNodes().forEach(child -> {
            allChildren.add(child);
            allChildren.addAll(getAllChildren(child));
        });
        return allChildren;
    }

    @objid ("d94be64b-9472-48fc-bcf4-64567cac35dc")
    public void applyLayoutToModel(IDiagramHandle diagramHandle) {
        this.mainLayout.applyLayoutToModel(diagramHandle);
    }

    @objid ("6bf22fdc-5850-4f6f-b7a8-a102eb24c43b")
    public ElkNode getElkRootNode() {
        return this.mainLayout.getElkRootNode();
    }

    @objid ("6f04ec93-aea4-4895-ae57-ac3f33f07f8f")
    public Map<IDiagramNode, ElkConnectableShape> getElkNodeMap() {
        return this.mainLayout.getElkNodes();
    }

    @objid ("452f4df3-aa73-4b31-929d-47b47152b949")
    public Map<IDiagramLink, List<ElkEdge>> getElKLink() {
        return this.mainLayout.getElKLinks();
    }

}
