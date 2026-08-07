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
package org.modelio.archimate.diagrams.dg;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.diagram.api.dg.common.DiagramDG;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.api.services.DiagramNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * Represents an archimate diagram.
 */
@objid ("537140fb-5e3b-4802-a936-80cb38d5fc8f")
public class ArchimateDiagramDG extends DiagramDG {
    /**
     * Initialize the diagram graphic element.
     *
     * @param diagramHandle The diagram handle
     * @param node The internal graphic node representing the diagram.
     */
    @objid ("21fbd232-1965-4a08-bfee-ff1363281d58")
    public ArchimateDiagramDG(DiagramHandle diagramHandle, GmNodeModel node) {
        super(diagramHandle, node);
    }

    @objid ("625e1fc4-354e-44dc-942e-5f617600a8ef")
    @Override
    public DiagramNode getParent() {
        return null;
    }

    @objid ("6cb21947-de8b-46d4-a22a-44d63dec9da3")
    @Override
    public List<IDiagramLink> getFromLinks() {
        return Collections.emptyList();
    }

    @objid ("0199076a-d10f-484c-bc8f-a1e2df258583")
    @Override
    public List<IDiagramLink> getToLinks() {
        return Collections.emptyList();
    }

}
