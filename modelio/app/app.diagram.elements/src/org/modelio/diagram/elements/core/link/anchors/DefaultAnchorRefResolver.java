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
package org.modelio.diagram.elements.core.link.anchors;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Default implementation of the anchor ref resolver always returning the center of the figure as a reference.
 *
 * @since 5.1
 */
@objid ("f8bbc1c2-5406-498f-8686-3b5605746c52")
public final class DefaultAnchorRefResolver implements IAnchorRefResolver {
    @objid ("e7a31f83-bad6-4f0d-9591-2ebf3f1e45d8")
    private static final DefaultAnchorRefResolver INSTANCE = new DefaultAnchorRefResolver();

    /**
     * Default empty c'tor.
     */
    @objid ("0b6a1175-6d75-4a61-8549-5333067115b8")
    private DefaultAnchorRefResolver() {
        super();
    }

    @objid ("7380b3ea-e7ae-4b49-94cd-54a3b804824d")
    @Override
    public Point resolveAnchorRef(AbstractGraphicalEditPart source, AbstractGraphicalEditPart target, MObject linkElement) {
        Rectangle sb = source.getFigure().getBounds().getCopy();
        Rectangle tb = target.getFigure().getBounds().getCopy();

        source.getFigure().translateToAbsolute(sb);
        target.getFigure().translateToAbsolute(tb);


        if(Math.max(sb.x, tb.x) - Math.min(sb.x + sb.width, tb.x + tb.width) < 0) {
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
        }else if(Math.max(sb.y, tb.y) - Math.min(sb.y + sb.height, tb.y + tb.height) < 0) {
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

        return getAbsoluteFigureCenter(source);
    }

    /**
     * Get the center of the figure bounds in absolute coordinates.
     *
     * @param editPart a figure edit part
     * @return the center of the figure.
     */
    @objid ("1dac62a6-29c8-4dc1-ac5d-1cbbd9b1322f")
    protected static final Point getAbsoluteFigureCenter(final AbstractGraphicalEditPart editPart) {
        IFigure fig = editPart.getFigure();
        fig.getUpdateManager().performValidation();
        Point ret = fig.getBounds().getCenter();
        fig.translateToAbsolute(ret);
        return ret;
    }

    /**
     *
     * @return the singleton instance.
     */
    @objid ("f33bfd97-32cd-42cb-a077-82fa28fc0753")
    public static DefaultAnchorRefResolver get() {
        return INSTANCE;
    }

}
