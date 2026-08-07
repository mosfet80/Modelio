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
package org.modelio.diagram.editor.layout;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.diagram.editor.layout.algorithme.specialised.ActivityDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.BPMNCollaborationDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.BPMNProcessDesignDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.BPMNProcessDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.ClassDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.DeploymentDiagramLayout;
import org.modelio.diagram.editor.layout.algorithme.specialised.UseCaseLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.BoxLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.CompactionLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.ForceLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.OverlapLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.PackingLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.RadialLayout;
import org.modelio.diagram.editor.layout.algorithme.standard.TreeLayout;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnCollaborationDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessDesignDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnSubProcessDiagram;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.diagrams.ActivityDiagram;
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.diagrams.CommunicationDiagram;
import org.modelio.metamodel.diagrams.CompositeStructureDiagram;
import org.modelio.metamodel.diagrams.DeploymentDiagram;
import org.modelio.metamodel.diagrams.ObjectDiagram;
import org.modelio.metamodel.diagrams.StateMachineDiagram;
import org.modelio.metamodel.diagrams.UseCaseDiagram;

@objid ("b7a32fe3-d266-46cd-8b1e-6db920167d9b")
public class DiagramLayoutEngine {
    @objid ("b4d544af-e015-4755-9913-3666368492ac")
    public static ILayoutAlgorithme createLayoutAlgorithme(AbstractDiagram diagram, IDiagramService diagramService) {
        if (diagram instanceof UseCaseDiagram) {
            return new UseCaseLayout().withDiagram(diagram, diagramService);
        }else if (diagram instanceof StateMachineDiagram) {
            return createLayoutAlgorithme(LayoutAlgorithmeType.LAYERED).withDiagram(diagram, diagramService);
        } else if (diagram instanceof ActivityDiagram) {
            return new ActivityDiagramLayout().withDiagram(diagram, diagramService);
        }else if (diagram instanceof CommunicationDiagram) {
            return createLayoutAlgorithme(LayoutAlgorithmeType.LAYERED).withDiagram(diagram, diagramService);
        } else if (diagram instanceof CompositeStructureDiagram) {
            return createLayoutAlgorithme(LayoutAlgorithmeType.FORCE).withDiagram(diagram, diagramService);
        } else if (diagram instanceof DeploymentDiagram) {
            return new DeploymentDiagramLayout().withDiagram(diagram, diagramService);
        } else if (diagram instanceof ObjectDiagram) {
              return createLayoutAlgorithme(LayoutAlgorithmeType.LAYERED).withDiagram(diagram, diagramService);
        }else if (diagram instanceof ClassDiagram) {
            return new ClassDiagramLayout().withDiagram(diagram, diagramService);
        }else if (diagram instanceof BpmnProcessDesignDiagram) {
            return new BPMNProcessDesignDiagramLayout().withDiagram(diagram, diagramService);
        }else if (diagram instanceof BpmnSubProcessDiagram) {
            return new BPMNProcessDiagramLayout().withDiagram(diagram, diagramService);
        }else if(diagram instanceof BpmnCollaborationDiagram){
            return new BPMNCollaborationDiagramLayout().withDiagram(diagram, diagramService);
        }else {
            return createLayoutAlgorithme(LayoutAlgorithmeType.LAYERED).withDiagram(diagram, diagramService);
        }
    }

    @objid ("9817827a-3e31-46f4-a26a-0be01f6bbba8")
    public static ILayoutAlgorithme createLayoutAlgorithme(LayoutAlgorithmeType type) {
        switch (type) {
        case LAYERED:
            return new LayeredLayout();
        case TREE:
            return new TreeLayout();
        case PACKING:
            return new PackingLayout();
        case FORCE:
            return new ForceLayout();
        case RADIAL:
            return new RadialLayout();
        case BOX:
            return new BoxLayout();
        case COMPACTION:
            return new CompactionLayout();
        case OVERLAP:
            return new OverlapLayout();
        }
        return new OverlapLayout();
    }

    @objid ("90226c6d-4c7f-46fe-aad0-6f655001d0d0")
    public enum LayoutAlgorithmeType {
        @objid ("71ccbcb7-3400-451b-a9d1-415e8ddbd6d1")
        LAYERED,
        @objid ("91ee6f90-44ee-466d-853d-dd04fdfbaf59")
        TREE,
        @objid ("d83dc44d-f6f4-430d-b53e-8efe3c564b8d")
        PACKING,
        @objid ("7be323a3-fb09-426b-94ea-5b354ffad33e")
        FORCE,
        @objid ("61eb4bfa-dbae-4820-a6ae-37a31f5b8458")
        RADIAL,
        @objid ("8301bfdf-1278-423d-8e6c-88cadd85ed6f")
        BOX,
        @objid ("1bf3d2f6-0696-40b6-8e9e-592ad17999bc")
        COMPACTION,
        @objid ("fcbd8efd-c389-4872-9466-06282a1caa28")
        OVERLAP;

    }

}
