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
package org.modelio.archimate.diagrams.elements.common.archielement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.policies.DefaultElementDropEditPolicy;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Redefinition of the drop edit policy making unmasking of an already unmasked element possible.
 */
@objid ("bf2aa80e-3a8b-45ab-94c9-be2ce952fd0e")
public class ArchiFreeZoneElementDropEditPolicy extends DefaultElementDropEditPolicy {
    /**
     * Default c'tor, allowing multiple unmask for model elements.
     */
    @objid ("5f9ff8d3-ad6b-4226-a429-db63f0205a05")
    public ArchiFreeZoneElementDropEditPolicy() {
        super(true);
    }

    @objid ("2792a4b7-7702-4dc0-9bbd-9c1082bcd143")
    @Override
    protected Command getSmartDropCommand(ModelElementDropRequest request) {
        Point dropLocation = request.getDropLocation();
        CompoundCommand command = new CompoundCommand();
        for (MObject droppedElement : request.getDroppedElements()) {
            if (droppedElement.getMClass().getOrigin().getName().equals("Analyst")) {
                // Smart drop
                if (droppedElement.getMClass().getQualifiedName().equals("Analyst.Goal")
                        || droppedElement.getMClass().getQualifiedName().equals("Analyst.Requirement")
                        || droppedElement.getMClass().getQualifiedName().equals("Analyst.Term")) {
                    command.add(getEquivalenceUnmaskCommand(this, droppedElement, dropLocation));
                }
                // Other analyst elements are ignored
            } else {
                // Standard drop
                Command subCmd = createDropCommandForElement(dropLocation, droppedElement);
                if (subCmd != null) {
                    command.add(subCmd);
                }
            }

            // Introduce some offset, so that all elements are not totally
            // on top of each other.
            dropLocation = dropLocation.getTranslated(20, 20);
        }
        return command;
    }

    @objid ("2ec7698b-519a-4f49-81bd-14e6b70c0894")
    private Command getEquivalenceUnmaskCommand(AbstractEditPolicy dropPolicy, MObject droppedElement, Point dropLocation) {
        final GmModel gmModel = (GmModel) dropPolicy.getHost().getModel();
        final IGmDiagram gmDiagram = gmModel.getDiagram();
        final ArchimateView diagram = (ArchimateView) gmDiagram.getRelatedElement();
        final Model owner = getArchimateModel(diagram);
        return new UnmaskEquivalentElementCommand(dropLocation, droppedElement, dropPolicy.getHost(), owner);
    }

    @objid ("83cfc434-80f5-45ff-a618-2a6a0636013b")
    private Model getArchimateModel(ModelElement elt) {
        if (elt instanceof ArchimateView) {
            ArchimateView diagram = (ArchimateView) elt;
            if (diagram.getContext() != null) {
                return diagram.getContext();
            } else {
                return getArchimateModel(diagram.getOrigin());
            }
        } else if (elt instanceof ViewPoint) {
            ViewPoint vp = (ViewPoint) elt;
            if (vp.getContext() != null) {
                return vp.getContext();
            } else {
                return getArchimateModel(vp.getParent());
            }
        } else {
            return null;
        }

    }

}
