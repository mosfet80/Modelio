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

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.modelio.api.modelio.model.scope.ElementScope;
import org.modelio.archimate.diagrams.elements.common.utils.RelationshipHelper;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.diagram.elements.common.freezone.FreeZoneEditPart;
import org.modelio.diagram.elements.common.freezone.FreeZoneLayout;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.mda.infra.MdaResources;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.osgi.framework.Bundle;

/**
 * Archimate free zone edit part.
 */
@objid ("cd05b03f-6470-4702-b02c-7a24633348db")
public class ArchiFreeZoneEditPart extends FreeZoneEditPart {
    @objid ("14bef7c7-eb33-435a-8a76-d9cbec1c980f")
    private static final Image HYBRIDNESTING_IMAGE = ArchiFreeZoneEditPart.getHybridNestingImage();

    /**
     * Constructor
     */
    @objid ("c81857cd-87a1-4679-b585-0e915e45115f")
    public ArchiFreeZoneEditPart() {
        super();
    }

    @objid ("1d640d42-6214-40f1-ada1-2e213d3f1ba2")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("8684b504-4bde-4d05-b918-0e1a0948e684")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        // Override the default drop policy.
        installEditPolicy(ModelElementDropRequest.TYPE, new ArchiFreeZoneElementDropEditPolicy());

        // Override the default layout policy.
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new ArchiFreeZoneLayoutEditPolicy());

    }

    @objid ("39a4d9a2-97c4-4966-a17a-2ab87a2a4563")
    @Override
    protected IFigure createFigure() {
        Figure groupFigure = new ArchiFreeZoneFigure();

        // Style independent properties
        groupFigure.setOpaque(false);
        groupFigure.setBackgroundColor(null);
        groupFigure.setBorder(new MarginBorder(3, 2, 3, 2));
        final FreeZoneLayout layout = new FreeZoneLayout();
        groupFigure.setLayoutManager(layout);

        /*
         * // debug free zone position FreeZoneEditPart thisEp = this; groupFigure.addFigureListener(new FigureListener() { private Rectangle oldBounds;
         *
         * @Override public void figureMoved(IFigure source) { Rectangle newBounds = source.getBounds(); if (this.oldBounds == null ) { this.oldBounds = newBounds.getCopy(); } else if (! this.oldBounds.equals(newBounds)) { if (this.oldBounds.x() >
         * newBounds.x()) { DiagramElements.LOG.debug("   FreeZoneEditPart.FigureListener: %s LEFT moved from %s to %s", thisEp, this.oldBounds, newBounds); } else { DiagramElements.LOG.debug("   FreeZoneEditPart.FigureListener: %s moved from %s to %s",
         * thisEp, this.oldBounds, newBounds); } this.oldBounds.setBounds(newBounds); } } });
         */

        // Set style dependent properties
        refreshFromStyle(groupFigure, getModelStyle());
        return groupFigure;
    }

    /**
     *
     * @return the hybrid nesting image loaded from the plugin's resources.
     */
    @objid ("511b1bdc-6eff-4aa0-afc3-7cd4c647caed")
    private static Image getHybridNestingImage() {
        Bundle bundle = ArchiDiagrams.getContext().getBundle();
        URL imageUrl = FileLocator.find(bundle, new Path("icons/hybridnesting.png"), null);
        ImageDescriptor descriptor = ImageDescriptor.createFromURL(imageUrl);
        return descriptor != null ? descriptor.createImage() : null;
    }

    @objid ("9907dee9-75f8-4eee-b7db-f6b0cad3bf73")
    @Override
    public ArchiFreeZoneFigure getFigure() {
        return (ArchiFreeZoneFigure) super.getFigure();
    }

    @objid ("f7251cd0-6caa-4c95-ab1a-f338b0c2a3e9")
    @Override
    protected void refreshChildren() {
        super.refreshChildren();
        refreshNestingCause();

    }

    @objid ("d3b989dd-0188-43fa-b826-30379517e065")
    private void refreshNestingCause() {
        GmModel model = getModel();
        MObject relatedElement = model.getRelatedElement();
        if (relatedElement instanceof Element) {
            Set<ElementScope> nestingCauses = new HashSet<>();

            for (Object child : getChildren()) {
                if (child instanceof AbstractGraphicalEditPart) {
                    AbstractGraphicalEditPart childEditPart = (AbstractGraphicalEditPart) child;
                    GmModel childModel = (GmModel) childEditPart.getModel();
                    MObject childModelRelatedElement = childModel.getRelatedElement();
                    if (childModelRelatedElement instanceof Element) {
                        List<StructuralRelationship> relationships = RelationshipHelper.getStructuralRelationships(model.getDiagram().getModelManager(), (Element) relatedElement, (Element) childModelRelatedElement, null);
                        if (relationships.isEmpty()) {
                            nestingCauses.add(null);
                        } else {
                            for (StructuralRelationship relationship : relationships) {
                                EList<Stereotype> stereotypes = relationship.getExtension();
                                if (stereotypes.isEmpty()) {
                                    nestingCauses.add(new ElementScope(relationship.getMClass(), false, null, false));
                                } else {
                                    nestingCauses.add(new ElementScope(relationship.getMClass(), false, stereotypes.get(0), false));
                                }
                            }
                        }
                    } else {
                        nestingCauses.add(null);
                    }
                }
            }

            if (nestingCauses.isEmpty()) {
                getFigure().setIndicator(null);
            } else if (nestingCauses.size() == 1) {
                ElementScope firstCause = nestingCauses.iterator().next();
                Image indicator;
                if (firstCause == null) {
                    indicator = null;
                } else if (firstCause.getStereotype() == null) {
                    indicator = MetamodelImageService.getIcon(firstCause.getMetaclass());
                } else {
                    indicator = MdaResources.getIcon(firstCause.getStereotype());
                }
                getFigure().setIndicator(indicator);
            } else {
                getFigure().setIndicator(ArchiFreeZoneEditPart.HYBRIDNESTING_IMAGE);
            }
        }

    }

    @objid ("1a7a9133-055b-4920-983d-b61704a4ef01")
    private static class ArchiFreeZoneFigure extends Figure {
        @objid ("5941a0ca-2670-4f1e-96f5-89c09a6635a1")
        private Image indicator = null;

        @objid ("72155c19-9180-42ed-b533-17cfeaf95992")
        public void setIndicator(Image image) {
            this.indicator = image;
        }

        @objid ("cf8b047c-4507-4886-9376-3491d6123b7e")
        @Override
        protected void paintClientArea(Graphics graphics) {
            super.paintClientArea(graphics);
            Rectangle r = getClientArea();
            if (this.indicator != null) {
                graphics.drawImage(this.indicator, r.x, r.y + r.height - this.indicator.getImageData().height);
            }

        }

        @objid ("5eaaa3e5-68ab-428c-8a60-22a9b02f477a")
        public ArchiFreeZoneFigure() {
            super();
        }

    }

}
