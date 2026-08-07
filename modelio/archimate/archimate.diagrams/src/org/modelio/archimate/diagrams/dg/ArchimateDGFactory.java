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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.archimate.diagrams.elements.andjunction.GmAndJunction;
import org.modelio.archimate.diagrams.elements.archimatediagram.GmArchimateDiagram;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.orjunction.GmOrJunction;
import org.modelio.archimate.diagrams.elements.viewpoint.GmViewPoint;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.GmViewPointDiagram;
import org.modelio.diagram.api.dg.IDGFactory;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * Diagram graphic factory for the Archimate metamodel fragment.
 */
@objid ("06ece1a4-3701-4974-abb2-f32aaf34ddd5")
public class ArchimateDGFactory implements IDGFactory {
    @objid ("060a9966-7087-47ac-8832-85c260b57dc8")
    @Override
    public IDiagramLink getDiagramLink(IDiagramHandle diagramHandle, IGmLink gmLink) {
        // GmArchiRelationship
        if (gmLink instanceof GmArchiRelationship<?>) {
            return new ArchiRelationshipDG((DiagramHandle) diagramHandle, gmLink);
        }
        return null;
    }

    @objid ("fd6d9f5d-97c3-4649-8adb-530baae4f6a7")
    @Override
    public IDiagramNode getDiagramNode(IDiagramHandle diagramHandle, GmNodeModel gmNodeModel) {
        // GmArchiElementPortContainer
        if (gmNodeModel instanceof GmArchiElementPortContainer<?>) {
            return new ArchiElementPortContainerDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmArchiElement
        if (gmNodeModel instanceof GmArchiElement<?>) {
            return new ArchiElementDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmArchimateDiagram
        if (gmNodeModel instanceof GmArchimateDiagram) {
            return new ArchimateDiagramDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmViewPointDiagram
        if (gmNodeModel instanceof GmViewPointDiagram) {
            return new ArchimateDiagramDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmOrJunction
        if (gmNodeModel instanceof GmOrJunction) {
            return new JunctionPortContainerDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmAndJunction
        if (gmNodeModel instanceof GmAndJunction) {
            return new JunctionPortContainerDG((DiagramHandle) diagramHandle, gmNodeModel);
        }

        // GmViewPoint
        if (gmNodeModel instanceof GmViewPoint) {
            return new ViewPointDG((DiagramHandle) diagramHandle, gmNodeModel);
        }
        return null;
    }

}
