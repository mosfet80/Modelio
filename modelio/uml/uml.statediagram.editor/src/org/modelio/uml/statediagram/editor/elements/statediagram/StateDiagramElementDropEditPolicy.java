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
package org.modelio.uml.statediagram.editor.elements.statediagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramEditPart;
import org.modelio.diagram.elements.common.abstractdiagram.DiagramElementDropEditPolicy;
import org.modelio.diagram.elements.common.abstractdiagram.UnmaskLinkCommand;
import org.modelio.diagram.elements.core.link.GmLink;
import org.modelio.diagram.elements.core.link.anchors.IAnchorRefResolver;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InternalTransition;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Extension of {@link DiagramElementDropEditPolicy} handling InternalTransition as nodes instead of links.
 */
@objid ("d192e5e2-f75c-4ebc-bf2d-e24448ac9b25")
class StateDiagramElementDropEditPolicy extends DiagramElementDropEditPolicy {
    @objid ("7271cf3c-4ca8-4fce-91b3-d2a972b9235a")
    @Override
    protected Command getSmartDropCommand(ModelElementDropRequest request) {
        final CompoundCommand command = new CompoundCommand();

        Point dropLocation = request.getDropLocation();

        for (final MObject toUnmask : request.getDroppedElements()) {
            if (toUnmask instanceof InternalTransition) {
                // Unmask InternalTransition as nodes instead of links
                command.add(createDropCommandForElement(dropLocation, toUnmask));
            } else if (toUnmask != null) {
                // Deal with 'non-smart' drops
                command.add(createSubCommand(request, dropLocation, toUnmask));
            }
            // Introduce some offset, so that all elements are not totally
            // on top of each other.
            dropLocation = dropLocation.getTranslated(20, 20);
        }
        return command;
    }

    /**
     * Create a standard unmask request
     */
    @objid ("53abbed5-2649-49d6-b68f-e6cb512834e9")
    private Command createSubCommand(final ModelElementDropRequest request, final Point dropLocation, final MObject toUnmask) {
        final ModelElementDropRequest subReq = new ModelElementDropRequest();
        subReq.setDroppedElements(new MObject[] { toUnmask });
        subReq.setExtendedData(request.getExtendedData());
        subReq.setLocation(dropLocation);
        subReq.setSmart(request.isSmart());
        return getDropCommand(subReq);
    }

    @objid ("13540c1b-99f6-47ef-92ba-64721388bb0c")
    @Override
    protected UnmaskLinkCommand createUnmaskCommandForLink(Point dropLocation, GmLink link) {
        UnmaskLinkCommand unmaskCommand = super.createUnmaskCommandForLink(dropLocation, link);
        unmaskCommand.setSourceAnchorResolver(new StateSourceAnchorRefResolver());
        unmaskCommand.setTargetAnchorResolver(new StateTargetAnchorRefResolver());
        return unmaskCommand;
    }

    @objid ("cd8bf14a-ea3c-4df8-96a9-92b1763a977a")
    @Override
    public Command createDropCommandForLink(final Point dropLocation, final IGmLink link) {
        return new UnmaskLinkCommand(link, (AbstractDiagramEditPart) getHost(), dropLocation, new StateSourceAnchorRefResolver(), new StateTargetAnchorRefResolver());
    }

    /**
     * Get the default source anchor reference point for link creation request in State diagrams.
     */
    @objid ("add76dfb-1213-4e0a-867e-3b762ad8a844")
    private static class StateSourceAnchorRefResolver implements IAnchorRefResolver {
        @objid ("36841290-1510-409f-8682-c5bf22bbd35c")
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


            return getDefaultAncor(sourceEditPart, targetEditPart);
        }

        @objid ("2d9d1efe-b479-45a6-89bb-23701996cb81")
        private Point getDefaultAncor(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart) {
            IFigure sourceFig = sourceEditPart.getFigure();
            sourceFig.getUpdateManager().performValidation();
            Rectangle sourceBounds = sourceFig.getBounds();

            IFigure targetFig = targetEditPart.getFigure();
            targetFig.getUpdateManager().performValidation();
            Rectangle targetBounds = targetFig.getBounds();

            final Point ret;
            if (sourceBounds.right() > targetBounds.x() && sourceBounds.y() > targetBounds.bottom()) {
                ret = sourceBounds.getTop();
            } else if (sourceBounds.right() > targetBounds.x() && sourceBounds.bottom() < targetBounds.y()) {
                ret = sourceBounds.getBottom();
            } else {
                ret = sourceBounds.getRight();
            }

            sourceFig.translateToAbsolute(ret);
            return ret;
        }

        @objid ("cb39d731-7c75-4019-ad66-1b3cde390f5d")
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

        @objid ("14f62ae4-9c91-488d-8534-6ca21c6e2319")
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
     * Get the default target anchor reference point for link creation request in State diagrams.
     */
    @objid ("1297adf1-eaae-438a-91c0-d15d101352c2")
    private static class StateTargetAnchorRefResolver implements IAnchorRefResolver {
        @objid ("2e842459-1529-4272-97f3-5ddab467a5dd")
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


            return getDefaultAncor(sourceEditPart, targetEditPart);
        }

        @objid ("ae694261-31b4-4bdb-a670-3c0b27c65295")
        private Point getDefaultAncor(AbstractGraphicalEditPart sourceEditPart, AbstractGraphicalEditPart targetEditPart) {
            IFigure sourceFig = sourceEditPart.getFigure();
            sourceFig.getUpdateManager().performValidation();
            Rectangle sourceBounds = sourceFig.getBounds();

            IFigure targetFig = targetEditPart.getFigure();
            targetFig.getUpdateManager().performValidation();
            Rectangle targetBounds = targetFig.getBounds();

            final Point ret;
            if (sourceBounds.right() > targetBounds.x() && sourceBounds.y() > targetBounds.bottom()) {
                ret = targetBounds.getBottom();
            } else if (sourceBounds.right() > targetBounds.x() && sourceBounds.bottom() < targetBounds.y()) {
                ret = targetBounds.getTop();
            } else {
                ret = targetBounds.getLeft();
            }

            targetFig.translateToAbsolute(ret);
            return ret;
        }

        @objid ("738c7a02-fbe0-4f4c-b45c-a95ade206d13")
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

        @objid ("fbba9a83-14ec-411a-9af2-5096e13f6c73")
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

}
