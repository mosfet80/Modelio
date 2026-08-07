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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.ICompositeLayoutAlgorithme;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnCollaborationDiagram;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * Layout algorithm for BPMN Collaboration Diagrams.
 * This algorithm processes each participant in the collaboration diagram and applies a layout to their respective processes.
 */
@objid ("d61a0f07-03d0-4cbd-ac01-4ffebc6f9024")
public class BPMNCollaborationDiagramLayout implements ICompositeLayoutAlgorithme {
    @objid ("621ffa68-75ac-445e-a04d-78bc8e5bb6e1")
    private BpmnCollaborationDiagram diagram;

    @objid ("bf8010eb-684b-42a2-8c22-493074d0ae87")
    private IDiagramService diagramService;

    @objid ("87f72250-de05-4ebd-8ecd-d370031ad40d")
    private List<IDiagramNode> selection;

    @objid ("d653d585-4c76-4d0d-b112-0b2cfd01f13d")
    public BPMNCollaborationDiagramLayout() {

    }

    @objid ("71c44385-fc93-4a7d-a62d-28057fa71b71")
    @Override
    public ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService) {
        if (!(diagram instanceof BpmnCollaborationDiagram)) {
            throw new IllegalArgumentException("The diagram must be a BpmnCollaborationDiagram");
        }
        this.diagram = (BpmnCollaborationDiagram) diagram;
        this.diagramService = diagramService;
        return this;
    }

    @objid ("ac4d2361-6f17-484d-8c34-533d7871c6bf")
    @Override
    public ILayoutAlgorithme withSelection(List<IDiagramNode> selection) {
        this.selection = selection;
        return this;
    }

    @objid ("8a5c2a5a-92f5-4cc7-b952-11cc5883c994")
    @Override
    public void runLayout() {
        getSubLayoutAlgorithmes().forEach(subLayout -> {
            subLayout.runLayout();
            subLayout.compactDiagramBounds(0);
            subLayout.postProcessing();
        });
    }

    @objid ("3057a05b-a0ce-41b4-8c2b-39b0a535e423")
    @Override
    public void postProcessing() {
        // TODO Auto-generated method stub
    }

    @objid ("77cebaaa-46a4-464c-93a6-18d3f2b2a2d2")
    @Override
    public void compactDiagramBounds(int PADDING) {
        // TODO Auto-generated method stub
    }

    @objid ("533a2953-0401-48df-b4a5-4c2ba0335fc6")
    @Override
    public List<IDiagramNode> getSelection() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @objid ("2ee5169e-de5b-4022-9786-f856453e9e25")
    @Override
    public List<ILayoutAlgorithme> getSubLayoutAlgorithmes() {
        List<ILayoutAlgorithme> algo = new ArrayList<>();
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(this.diagram)) {
            // Perform Specific algo for each Lane
            getParticipants(handle.getDiagramNode()).forEach(partNode -> {
                BPMNProcessDesignDiagramLayout subLayout = new BPMNProcessDesignDiagramLayout();
                BpmnParticipant participant = (BpmnParticipant) partNode.getElement();
                if (participant.getProcess() != null && participant.getProcess().getProduct().size() > 0) {
                    subLayout.withDiagram(participant.getProcess().getProduct().get(0), this.diagramService);
                    algo.add(subLayout);
                }
            });
        }
        return algo;
    }

    @objid ("ea4cef30-1753-49be-a53c-39162ceb1b47")
    private List<IDiagramNode> getParticipants(IDiagramNode diagramNode) {
        List<IDiagramNode> participants = new ArrayList<>();
        for (IDiagramNode childrenNode : diagramNode.getNodes()) {
            if (childrenNode.getElement() instanceof BpmnParticipant) {
                BpmnParticipant participant = (BpmnParticipant) childrenNode.getElement();
                if (participant.getProcess() != null) {
                    participants.add(childrenNode);
                }
            } else {
                participants.addAll(getParticipants(childrenNode));
            }

        }

        return participants;
    }

}
