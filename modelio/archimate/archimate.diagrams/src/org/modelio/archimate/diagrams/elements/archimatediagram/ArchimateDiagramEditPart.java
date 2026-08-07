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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramEditPart;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeFinishCreationEditPolicy;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.policies.CreateLinkIntermediateEditPolicy;
import org.modelio.diagram.elements.core.requests.CreateLinkConstants;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart (== controller in the GEF model) for {@link ArchimateView} background.
 */
@objid ("96fee150-51e3-4796-8608-9e17cbe87ff2")
public class ArchimateDiagramEditPart extends AbstractDiagramEditPart {
    /**
     *
     * @see AbstractDiagramEditPart#createEditPolicies()
     */
    @objid ("65a5dacd-d6c0-476f-b401-9ee5a858646a")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        // Override the default drop policy.
        installEditPolicy(ModelElementDropRequest.TYPE, new ArchimateDiagramElementDropEditPolicy());

        // Policy to add nodes on the diagram
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new ArchimateDiagramEditLayoutPolicy());

        // Policy to create notes
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_END, new LinkedNodeFinishCreationEditPolicy());

        // Policy to add bend points to connections being created
        installEditPolicy(CreateLinkConstants.REQ_CONNECTION_ADD_BENDPOINT, new CreateLinkIntermediateEditPolicy());

        // Remove the default DIRECT_EDIT policy: we don't want the diagram
        // background to delegate direct edit requests.
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, null);

    }

    /**
     * Creates the Figure to be used as this part's visuals
     *
     * @see AbstractDiagramEditPart#createFigure()
     */
    @objid ("f1f8151f-dad9-49e1-bbee-a605d7253136")
    @Override
    protected IFigure createFigure() {
        Figure diagramFigure = new ArchimateDiagramFigure();
        IStyle style = ((GmAbstractObject) this.getModel()).getDisplayedStyle();

        // Set style independent properties

        // Set style dependent properties
        refreshFromStyle(diagramFigure, style);
        return diagramFigure;
    }

    @objid ("53663dee-75d5-401d-8a01-a635c87a96d1")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        // TODO Auto-generated method stub
        super.refreshFromStyle(aFigure, style);

    }

}
