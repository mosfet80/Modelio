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
package org.modelio.archimate.diagrams.elements.viewpoint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.modelio.archimate.diagrams.elements.common.anchors.ArchimateAnchors;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;
import org.modelio.metamodel.diagrams.AbstractDiagram;

/**
 * EditPart for a {@link GmViewPoint} Node.
 */
@objid ("7b40c063-c940-4e15-8c00-1c12e297c4c5")
public class ViewPointEditPart extends AbstractNodeEditPart {
    @objid ("6b8e5d93-c4b9-4f93-a8fb-d98e4bd9984c")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final RectangularFigure fig = new RectangularFigure();
        fig.setOpaque(true);

        // Add layout
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        fig.setLayoutManager(layout);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 200, 200);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    /**
     * Open the related diagram on double click.
     */
    @objid ("0bd4a3d3-98ad-44f6-b7c0-4054f07f8484")
    @Override
    public void performRequest(final Request req) {
        if (req.getType().equals(RequestConstants.REQ_OPEN)) {
            ViewPoint viewPoint = (ViewPoint) getModel().getRelatedElement();
            for (AbstractDiagram diag : viewPoint.getProduct()) {
                if (diag instanceof ViewPointDiagram) {
                    getModel().getDiagram().getModelManager().getActivationService().activateMObject(diag);
                }
            }
        } else {
            super.performRequest(req);
        }

    }

    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("22320cf5-01c4-4991-ac5b-fa26400688c0")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return ArchimateAnchors.defaultFor(this);
    }

    @objid ("cecb6342-9994-4429-9be4-112ba7f18707")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        // Remove the default DIRECT_EDIT policy: we don't want the diagram
        // background to delegate direct edit requests.
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, null);
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

    @objid ("bdd6ca31-1607-4556-984a-49d23a3e1f31")
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        GmAbstractObject model = getModel();
        getFigure().getParent().setConstraint(getFigure(), model.getLayoutData());

    }

}
