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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramEditPart;
import org.modelio.diagram.elements.common.abstractdiagram.DiagramElementDropEditPolicy;
import org.modelio.diagram.elements.common.abstractdiagram.UnmaskLinkCommand;
import org.modelio.diagram.elements.core.figures.routers.AutoOrthoConstants;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.link.anchors.IAnchorRefResolver;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Extension of {@link DiagramElementDropEditPolicy} handling InternalTransition as nodes instead of links.
 */
@objid ("d5eeeca6-d4d2-434c-a599-15d56e8078cf")
class ArchimateDiagramElementDropEditPolicy extends DiagramElementDropEditPolicy {
    /**
     * C'tor allowing multiple unmask for model elements.
     */
    @objid ("d4f1c9d6-5cf5-432a-a587-1166cf1dffd4")
    public ArchimateDiagramElementDropEditPolicy() {
        super(true);
    }

    @objid ("26677e1e-ba53-4a18-aafb-3efd77a72532")
    @Override
    protected UnmaskLinkCommand createUnmaskCommandForLink(Point dropLocation, GmLink link) {
        UnmaskLinkCommand unmaskCommand = super.createUnmaskCommandForLink(dropLocation, link);
        unmaskCommand.setSourceAnchorResolver(new ArchiMateSourceAnchorRefResolver());
        unmaskCommand.setTargetAnchorResolver(new ArchiMateTargetAnchorRefResolver());
        return unmaskCommand;
    }

    @objid ("1a1c6158-fc38-46e8-be99-84015cd90843")
    @Override
    public Command createDropCommandForLink(final Point dropLocation, final IGmLink link) {
        return new UnmaskLinkCommand(link, (AbstractDiagramEditPart) getHost(), dropLocation, new ArchiMateSourceAnchorRefResolver(), new ArchiMateTargetAnchorRefResolver());
    }

    /**
     * Get the default source anchor reference point for link creation request in ArchiMate diagrams.
     * <p>
     * The current algorithm choose anchors according to 4 cases of relative positions.
     * </p>
     */
    @objid ("6849b051-7a39-4933-939b-e0ad4a6efe9d")
    private static class ArchiMateSourceAnchorRefResolver implements IAnchorRefResolver {
        @objid ("dbf8d8cf-b140-4dac-84eb-aa838a81d71e")
        @Override
        public Point resolveAnchorRef(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart, MObject linkElement) {
            Rectangle sourceBounds = sourceEditPart.getFigure().getBounds().getCopy();
            Rectangle targetBounds = targetEditPart.getFigure().getBounds().getCopy();

            sourceEditPart.getFigure().translateToAbsolute(sourceBounds);
            targetEditPart.getFigure().translateToAbsolute(targetBounds);


            if(Math.max(sourceBounds.x, targetBounds.x) - Math.min(sourceBounds.x + sourceBounds.width, targetBounds.x + targetBounds.width) < 0) {
                return getAbsoluteXCommonSegmentCenter(sourceBounds, targetBounds);
            }else if(Math.max(sourceBounds.y, targetBounds.y) - Math.min(sourceBounds.y + sourceBounds.height, targetBounds.y + targetBounds.height) < 0) {
                return getAbsoluteYCommonSegmentCenter(sourceBounds, targetBounds);
            }


            return getDafaultSourceAncor(sourceEditPart, targetEditPart);
        }

        @objid ("7b2d5c3e-8550-4e13-be58-43812def3d6d")
        private Point getDafaultSourceAncor(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart) {
            IFigure sourceFig = sourceEditPart.getFigure();
            sourceFig.getUpdateManager().performValidation();
            Rectangle sourceBounds = sourceFig.getBounds().getExpanded(AutoOrthoConstants.MIN_DIST, AutoOrthoConstants.MIN_DIST);

            IFigure targetFig = targetEditPart.getFigure();
            targetFig.getUpdateManager().performValidation();
            Rectangle targetBounds = targetFig.getBounds();

            final Point ret;
            if (sourceBounds.x() > targetBounds.right()) {
                ret = sourceBounds.getLeft();
            } else if (sourceBounds.right() < targetBounds.x()) {
                ret = sourceBounds.getRight();
            } else if (sourceBounds.y() > targetBounds.bottom()) {
                ret = sourceBounds.getTop();
            } else if (sourceBounds.bottom() < targetBounds.y()) {
                ret = sourceBounds.getBottom();
            } else {
                // Nodes are overlapping, let the anchor provider choose something
                ret = sourceBounds.getCenter();
            }

            sourceFig.translateToAbsolute(ret);
            return ret;
        }

        @objid ("d55a9945-0a7e-4dba-b987-3fa511fcb085")
        private Point getAbsoluteYCommonSegmentCenter(Rectangle sb, Rectangle tb) {
            Point p = new Point();
            if(sb.y < tb.y) {
                if(sb.y+ sb.height < tb.y + tb.height) {
                    p.y = tb.y + (sb.y + sb.height - tb.y) / 2;
                }else {
                    p.y = tb.y + tb.height / 2;
                }

            } else {
                if(sb.y+ sb.height > tb.y+ tb.height) {
                    p.y = sb.y + (tb.y + tb.height - sb.y) / 2;
                } else {
                    p.y = sb.y + sb.height / 2;
                }
            }

            if(sb.x < tb.x) {
                p.x = sb.x + sb.width;
            } else {
                p.x =sb.x;
            }
            return p;
        }

        @objid ("2ee0c048-e8d6-463e-a4d0-a9f5a7ac84ab")
        private Point getAbsoluteXCommonSegmentCenter(Rectangle sb, Rectangle tb) {
            Point p = new Point();

            if(sb.x < tb.x) {
                if(sb.x+ sb.width < tb.x + tb.width) {
                    p.x = tb.x + (sb.x + sb.width - tb.x) / 2;
                }else {
                    p.x = tb.x + tb.width / 2;
                }

            } else {
                if(sb.x+ sb.width > tb.x+ tb.width) {
                    p.x = sb.x + (tb.x + tb.width - sb.x) / 2;
                } else {
                    p.x = sb.x + sb.width / 2;
                }
            }

            if(sb.y < tb.y) {
                p.y = sb.y + sb.height;
            } else {
                p.y = sb.y;
            }
            return p;
        }

    }

    /**
     * Get the default target anchor reference point for link creation request in ArchiMate diagrams.
     * <p>
     * The current algorithm choose anchors according to 4 cases of relative positions.
     * </p>
     */
    @objid ("b7aeecec-5b4d-48bc-ba32-111d92b10311")
    private static class ArchiMateTargetAnchorRefResolver implements IAnchorRefResolver {
        @objid ("cbcf0384-74b3-4b56-b715-dc10e2823f2a")
        @Override
        public Point resolveAnchorRef(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart, MObject linkElement) {
            Rectangle sourceBounds = sourceEditPart.getFigure().getBounds().getCopy();
            Rectangle targetBounds = targetEditPart.getFigure().getBounds().getCopy();

            sourceEditPart.getFigure().translateToAbsolute(sourceBounds);
            targetEditPart.getFigure().translateToAbsolute(targetBounds);


            if(Math.max(sourceBounds.x, targetBounds.x) - Math.min(sourceBounds.x + sourceBounds.width, targetBounds.x + targetBounds.width) < 0) {
                return getAbsoluteXCommonSegmentCenter(sourceBounds, targetBounds);
            }else if(Math.max(sourceBounds.y, targetBounds.y) - Math.min(sourceBounds.y + sourceBounds.height, targetBounds.y + targetBounds.height) < 0) {
                return getAbsoluteYCommonSegmentCenter(sourceBounds, targetBounds);
            }

            return getDefaultTargetAncor(sourceEditPart, targetEditPart);
        }

        @objid ("58b1593d-7326-4861-bdc5-22d9e7c5051d")
        private Point getAbsoluteYCommonSegmentCenter(Rectangle sb, Rectangle tb) {
            Point p = new Point();
            if(sb.y < tb.y) {
                if(sb.y+ sb.height < tb.y + tb.height) {
                    p.y = tb.y + (sb.y + sb.height - tb.y) / 2;
                }else {
                    p.y = tb.y + tb.height / 2;
                }

            } else {
                if(sb.y+ sb.height > tb.y+ tb.height) {
                    p.y = sb.y + (tb.y + tb.height - sb.y) / 2;
                } else {
                    p.y = sb.y + sb.height / 2;
                }
            }

            if(sb.x < tb.x) {
                p.x = sb.x + sb.width;
            } else {
                p.x =sb.x;
            }
            return p;
        }

        @objid ("25825fce-9311-40e9-8dad-59b30505c2f3")
        private Point getAbsoluteXCommonSegmentCenter(Rectangle sb, Rectangle tb) {
            Point p = new Point();

            if(sb.x < tb.x) {
                if(sb.x+ sb.width < tb.x + tb.width) {
                    p.x = tb.x + (sb.x + sb.width - tb.x) / 2;
                }else {
                    p.x = tb.x + tb.width / 2;
                }

            } else {
                if(sb.x+ sb.width > tb.x+ tb.width) {
                    p.x = sb.x + (tb.x + tb.width - sb.x) / 2;
                } else {
                    p.x = sb.x + sb.width / 2;
                }
            }

            if(sb.y < tb.y) {
                p.y = sb.y + sb.height;
            } else {
                p.y = sb.y;
            }
            return p;
        }

        @objid ("82358c2a-363d-4e27-837d-51c2b866c0ef")
        private Point getDefaultTargetAncor(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart) {
            IFigure sourceFig = sourceEditPart.getFigure();
            sourceFig.getUpdateManager().performValidation();
            Rectangle sourceBounds = sourceFig.getBounds().getExpanded(AutoOrthoConstants.MIN_DIST, AutoOrthoConstants.MIN_DIST);

            IFigure targetFig = targetEditPart.getFigure();
            targetFig.getUpdateManager().performValidation();
            Rectangle targetBounds = targetFig.getBounds();

            final Point ret;
            if (sourceBounds.x() > targetBounds.right()) {
                ret = targetBounds.getRight();
            } else if (sourceBounds.right() < targetBounds.x()) {
                ret = targetBounds.getLeft();
            } else if (sourceBounds.y() > targetBounds.bottom()) {
                ret = targetBounds.getBottom();
            } else if (sourceBounds.bottom() < targetBounds.y()) {
                ret = targetBounds.getTop();
            } else {
                // Nodes are overlapping, let the anchor provider choose something
                ret = targetBounds.getCenter();
            }

            targetFig.translateToAbsolute(ret);
            return ret;
        }

    }

}
