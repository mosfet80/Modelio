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
package org.modelio.archimate.diagrams.elements.archimatediagram;

import java.util.Deque;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.modelio.archimate.diagrams.elements.common.archielement.UnmaskEquivalentElementCommand;
import org.modelio.archimate.metamodel.ArchimateMetamodel;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramElementDropEditPolicyExtension;
import org.modelio.diagram.elements.common.abstractdiagram.DiagramElementDropEditPolicy;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Drop extension for {@link ArchimateView}.
 * <p>
 * Smart interactions are:
 * <ul>
 * <li>dropping some Analyst elements creates equivalent Archimate elements.</li>
 * </ul>
 * </p>
 */
@objid ("9bd0671f-af12-4cce-9e45-166f95d0cf08")
public class ArchimateDiagramDropEditPolicyExtension extends AbstractDiagramElementDropEditPolicyExtension {
    @objid ("95412765-cdd6-4c62-bcd9-15337773a859")
    @Override
    public Command getUnmaskCommandFor(DiagramElementDropEditPolicy dropPolicy, MObject droppedElement, Point dropLocation) {
        if (droppedElement != null) {
            if (isArchimateElement(droppedElement)) {
                return super.getUnmaskCommandFor(dropPolicy, droppedElement, dropLocation);
            } else if (droppedElement.getMClass().getOrigin().getName().equals("Analyst")) {
                if (droppedElement.getMClass().getQualifiedName().equals("Analyst.Goal")
                        || droppedElement.getMClass().getQualifiedName().equals("Analyst.Requirement")
                        || droppedElement.getMClass().getQualifiedName().equals("Analyst.Term")) {
                    return getEquivalenceUnmaskCommand(dropPolicy, droppedElement, dropLocation);
                }
            }
        }
        return null;
    }

    /**
     * Hierarchy is complete when an Archimate element is unmasked.
     */
    @objid ("9c95bd30-d5e2-42f4-87aa-58e96ba742b7")
    @Override
    public boolean isToBeAddedToHierarchy(IGmDiagram context, Deque<MObject> hierarchy, MObject candidate) {
        MObject lastElement = hierarchy.peek();
        return (lastElement == null || !isArchimateElement(lastElement)) && isArchimateElement(candidate);
    }

    @objid ("ad013843-8125-4c20-b12e-9b5af8900657")
    private boolean isArchimateElement(MObject mObj) {
        return mObj.getMClass().getOrigin().getName().equals(ArchimateMetamodel.NAME);
    }

    @objid ("d22aedde-aaca-4c60-b6d7-e7048cca9695")
    private Command getEquivalenceUnmaskCommand(AbstractEditPolicy dropPolicy, MObject droppedElement, Point dropLocation) {
        final GmModel gmModel = (GmModel) dropPolicy.getHost().getModel();
        final IGmDiagram gmDiagram = gmModel.getDiagram();
        final ArchimateView diagram = (ArchimateView) gmDiagram.getRelatedElement();
        final Model owner = getArchimateModel(diagram);
        return new UnmaskEquivalentElementCommand(dropLocation, droppedElement, dropPolicy.getHost(), owner);
    }

    @objid ("75b88c1e-7e2c-4610-a158-e8353ab6a939")
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
