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
package org.modelio.diagram.editor.layout.algorithme.elk;

import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkNode;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * IElkLayoutAlgorithme is an interface for layout algorithms that use the ELK framework.
 * It provides methods to access the ELK nodes and links created during the layout process.
 */
@objid ("095250e2-4e21-4627-8e59-3e0a685b8e95")
public interface IElkLayoutAlgorithme extends ILayoutAlgorithme {
    /**
     * Returns a map of ELK nodes associated with diagram nodes.
     *
     * @return a map where keys are IDiagramNode and values are ElkConnectableShape
     */
    @objid ("01ced1d5-ccd0-4221-abee-21e5755cd622")
    Map<IDiagramNode, ElkConnectableShape> getElkNodes();

    /**
     * Returns a map of ELK links associated with diagram links.
     *
     * @return a map where keys are IDiagramLink and values are lists of ElkEdge
     */
    @objid ("c42b2a22-01d3-4999-9b29-b4cdfd592db4")
    Map<IDiagramLink, List<ElkEdge>> getElKLinks();

    /**
     * Returns the root ELK node of the layout.
     *
     * @return the ElkNode representing the root of the layout
     */
    @objid ("a1421af6-73ea-4a30-a23d-576055ddcde0")
    ElkNode getElkRootNode();

    @objid ("de916665-d067-4ca8-aca5-456a639b25d8")
    void configureLayout();

    @objid ("dd3a6bc9-7511-4a71-bd65-1a48af1d3314")
    void applyLayoutToModel(IDiagramHandle diagramHandle);

    @objid ("b82f60d6-4ee4-4689-89bf-9940fa7eba0f")
    AbstractDiagram getDiagram();

    @objid ("ae6e6a98-de6f-48b9-b64d-bc317445a7b5")
    IDiagramService getDiagramService();

    @objid ("90219d8f-13c3-4199-8301-1bc1c9cd458f")
    void buildElkModel(IDiagramHandle diagramHandle);

    @objid ("5e39f807-2727-4f53-a17e-13fe0778bf27")
    ElkNode getClosedParent(IDiagramHandle diagramHandle, IDiagramNode iDiagramNode);

}
