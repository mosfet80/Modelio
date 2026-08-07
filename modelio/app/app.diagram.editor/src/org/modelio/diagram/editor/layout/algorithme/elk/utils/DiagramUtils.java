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
package org.modelio.diagram.editor.layout.algorithme.elk.utils;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramNode.Role;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.dg.IDiagramDG;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("8aaf2c64-0cca-41c9-988d-e74cc17c6cb8")
public class DiagramUtils {
    @objid ("0fcaeb52-129b-4718-a252-541fd2a3f167")
    public static List<IDiagramNode> getAllNodes(AbstractDiagram diagram, IDiagramService diagramService) {
        List<IDiagramNode> result = new ArrayList<>();

        try (IDiagramHandle handle = diagramService.getDiagramHandle(diagram)) {
            handle.getDiagramNode().getNodes().get(0).isSelected();
            IDiagramDG diagramDg = handle.getDiagramNode();

            result.addAll(getSubNodes(diagramDg));

        }
        return result;
    }

    @objid ("6ce61c77-867a-48ba-93fe-e27903f04f01")
    public static List<IDiagramNode> getAllSelectedNodes(AbstractDiagram diagram, IDiagramService diagramService) {
        List<IDiagramNode> result = new ArrayList<>();

        try (IDiagramHandle handle = diagramService.getDiagramHandle(diagram)) {
            handle.getDiagramNode().getNodes().get(0).isSelected();
            IDiagramDG diagramDg = handle.getDiagramNode();

            result.addAll(getSelectedSubdNodes(diagramDg));

        }
        return result;
    }

    @objid ("116c2171-52b5-4c17-8e38-b2caba1d89ff")
    private static List<IDiagramNode> getSubNodes(IDiagramNode node) {
        List<IDiagramNode> result = new ArrayList<>();

        for (IDiagramNode subNode : node.getNodes(Role.INNER)) {
            result.add(subNode);
        }

        for (IDiagramNode subNode : node.getNodes(Role.PORT)) {
            result.add(subNode);
        }

        return result;
    }

    @objid ("d66d4c82-d24b-4a89-9827-ba9fdf982423")
    private static List<IDiagramNode> getSelectedSubdNodes(IDiagramNode node) {
        List<IDiagramNode> result = new ArrayList<>();

        for (IDiagramNode subNode : node.getNodes(Role.INNER)) {
            if (subNode.isSelected()) {
                result.add(subNode);
            }
        }

        for (IDiagramNode subNode : node.getNodes(Role.PORT)) {
            if (subNode.isSelected()) {
                result.add(subNode);
            }
        }

        return result;
    }

}
