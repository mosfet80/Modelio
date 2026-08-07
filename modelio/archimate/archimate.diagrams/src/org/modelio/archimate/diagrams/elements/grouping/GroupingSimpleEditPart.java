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
package org.modelio.archimate.diagrams.elements.grouping;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.ArchiHeaderEditPart;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.common.freezone.FreeZoneEditPart;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.umlcommon.packaze.PackageFigure;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

/**
 * EditPart for a {@link GmGrouping} Node in simple mode.
 */
@objid ("e9e7b518-f9fc-4907-b445-54b80ee6d4ff")
public class GroupingSimpleEditPart extends ArchiElementEditPart {
    @objid ("a0a7e6ad-87b8-4699-912d-4d0b9acc08f8")
    @Override
    protected IFigure createFigure() {
        // create the figure
        PackageFigure figure1 = new PackageFigure();

        // set style independent properties
        MinimumSizeLayout.apply(figure1, 250, 150);

        // set style independent properties
        figure1.setLinePattern(LinePattern.LINE_DASH);

        // set style dependent properties
        refreshFromStyle(figure1, getModelStyle());

        // return the figure
        return figure1;
    }

    @objid ("e2572b49-7916-4294-a889-7e2335d3828f")
    @Override
    protected void addChildVisual(EditPart child, int index) {
        IFigure childFigure = ((GraphicalEditPart) child).getFigure();

        if (child instanceof FreeZoneEditPart) {
            getFigure().setContentsFigure(childFigure);
        } else if (child instanceof ArchiHeaderEditPart) {
            getFigure().setHeaderFigure(childFigure);
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Cannot add ");
            msg.append(child.toString());
            msg.append(" child edit part to GroupingEditPart");
            throw new IllegalArgumentException(msg.toString());
        }

    }

    @objid ("7551fc3b-2b59-4802-a297-6e9e51ed5662")
    @Override
    protected void removeChildVisual(EditPart child) {
        if (child instanceof FreeZoneEditPart) {
            getFigure().setContentsFigure(null);
        } else if (child instanceof ArchiHeaderEditPart) {
            getFigure().setHeaderFigure(null);
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Cannot remove ");
            msg.append(child.toString());
            msg.append(" child edit part from GroupingEditPart");
            throw new IllegalArgumentException(msg.toString());
        }

    }

    @objid ("22d44d16-c35a-4bbd-a919-4febbe5620e1")
    @Override
    protected void refreshVisuals() {
        final IFigure fig = getFigure();
        final GmAbstractObject model = getModel();

        fig.getParent().setConstraint(fig, model.getLayoutData());

    }

    /**
     * Get the casted package figure.
     *
     * @return the package figure.
     */
    @objid ("ef2513c6-349a-4bca-8027-f1c6c232a6e3")
    @Override
    public PackageFigure getFigure() {
        return (PackageFigure) super.getFigure();
    }

    @objid ("f716761f-0890-4075-b23d-d0ddae0d160c")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof PackageFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final GmArchiElementPrimaryNode<?> gmModel = (GmArchiElementPrimaryNode<?>) getModel();
            switch (gmModel.getRepresentationMode()) {
            case STRUCTURED:
                gmModel.getHeader().setShowMetaclassIcon(true);
                break;
            case IMAGE:
            case SIMPLE:
            case USER_IMAGE:
                gmModel.getHeader().setShowMetaclassIcon(false);
                break;
            default:
                break;
            }
        }

    }

    @objid ("fc79e709-9ced-438a-8984-ebe1aad36ef1")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
