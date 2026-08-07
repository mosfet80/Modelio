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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * Interface for layout algorithms.
 */
@objid ("70bd4611-4b89-4fcb-875c-849dde1decf3")
public interface ILayoutAlgorithme {
    /**
     * Configures the layout algorithm with the given diagram.
     *
     * @param diagram the diagram to configure the layout algorithm with
     * @return the current instance of the layout algorithm
     */
    @objid ("a402966d-e89d-412e-a408-3f1156a8f106")
    ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService);

    /**
     * Configures the layout algorithm with the given selection.
     *
     * @param selection the selection to configure the layout algorithm with
     * @return the current instance of the layout algorithm
     */
    @objid ("25a9cbef-bac9-4661-884e-625b515f2c7e")
    ILayoutAlgorithme withSelection(List<IDiagramNode> selection);

    /**
     * Apply the layout algorithm to the diagram or sub selection of diagram elements
     *
     * @param diagramService the diagram service
     * @param session the Core Session
     */
    @objid ("429dcc1d-0b84-43ca-aa2d-a6d3eb6c5ea2")
    void runLayout();

    /**
     * Post-processing after the layout algorithm has been run.
     * This method is called to perform any necessary adjustments or finalizations
     */
    @objid ("ad0cb698-df7c-43af-8c14-17251cc58abf")
    void postProcessing();

    /**
     * Compact the diagram bounds by removing empty space around the nodes.
     *
     * @param PADDING the padding to apply around the diagram bounds
     */
    @objid ("8c1f60a8-ab42-4a29-aab2-80169f6918f0")
    void compactDiagramBounds(int PADDING);

    /**
     * Get the diagram elements associated with this layout algorithm.
     *
     * @return the diagram
     */
    @objid ("634882ab-7946-4d72-b42f-d79b22340f37")
    List<IDiagramNode> getSelection();

}
