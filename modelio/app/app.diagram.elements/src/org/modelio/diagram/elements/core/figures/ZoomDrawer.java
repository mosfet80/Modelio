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
package org.modelio.diagram.elements.core.figures;

import java.util.Map;
import java.util.WeakHashMap;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.Platform.OS;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PrinterGraphics;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.internal.DPIUtil;
import org.eclipse.swt.widgets.Display;

/**
 * Utility class to handle line drawing when the diagram is zoomed.
 * <p>
 * This class contains factorize (many tries of) workarounds of SWT and Draw2D issues
 * that occurs when scaling diagrams, views and.
 * In this case the line width is also zoomed .
 *
 * @author cmarin
 */
@objid ("7fcfae67-1dec-11e2-8cad-001ec947c8cc")
public class ZoomDrawer {
    /**
     * Cache for SWTGraphics scale
     * <p>
     * This cache is used to store the scale factor for each Graphics instance.
     * The key is the Graphics instance and the value is the scale factor.
     * This is to workaround the scale is not accessible from the {@link SWTGraphics} instance.
     */
    @objid ("e34d167c-279a-47c8-847a-04a0a266e91e")
    private static final WeakHashMap<Graphics, Double> swtGraphicsScaleCache = new WeakHashMap<>();

    /**
     * Use line offset to compensate for the line width.
     * <p>
     * This is used to ensure that the line is drawn correctly when the line width is 1 and the scale is 100%.
     * This is a workaround for the SWT and Draw2D issues that occurs when scaling diagrams, views and.
     * This is set to true by default on Windows at hi-res.
     * <p>
     * This Was an Eclipse preference in Archi.
     *
     * If this is set to true, the line will be offset by half of the line width.
     * If this is set to false, the line will not be offset.
     */
    @objid ("96ea9b99-88a7-4ec4-bfb7-1c8aaa6a1273")
    private static boolean useLineOffset = OS.isWindows() && getDeviceZoom() > 100;

    /**
     * Set the graphics line width depending on the zoom level and the graphics type.
     *
     * @param g the graphics
     * @param width line width
     */
    @objid ("7fcfae69-1dec-11e2-8cad-001ec947c8cc")
    public static void setLineWidth(Graphics g, int width) {
        if (false) {
            g.setLineWidth(width > 1 ? width : 1);
        } else if ( !(g instanceof PrinterGraphics)) {
            // Disabled: seems line width needs to be zoomed only on ScaledGraphics that is not used anymore.
            float dw = (float) (width * g.getAbsoluteScale());
            //g.setLineWidth((int) Math.ceil(dw));
            if (dw < 1 && width > 0) {
                dw = 1.0f;
            }
            g.setLineWidthFloat(dw );
        } else {
            g.setLineWidth(width);
        }
    }

    /**
     * Set the line width and compensate the figure bounds width and height for this line width and translate the graphics instance.
     * <p>
     * Same as bounds.shrink(lineWidth / 2, lineWidth / 2), but works better with odd widths and scaled graphics.
     *
     * @param graphics The graphics instance, it may be translated.
     * @param lineWidth The line width
     * @param bounds The bounds of the object. It will be directly modified.
     * @author Credits to Archi , see AbstractDiagramModelObjectFigure
     */
    @objid ("4ea037eb-1026-4aca-8bae-ceef4f77a784")
    public static void setLineWidth(Graphics graphics, int lineWidth, Rectangle bounds) {
        final double scale = getGraphicsScale(graphics);

        if (true) {
            // ensure line width is at least 1
            graphics.setLineWidth(lineWidth > 1 ? lineWidth : 1);
        } else {
            // Disabled: seems line width needs to be zoomed only on ScaledGraphics that is not used anymore.
            float dw = (float) (lineWidth * scale);
            //g.setLineWidth((int) Math.ceil(dw));
            if (dw < 1 && lineWidth > 0) {
                dw = 1.0f;
            }
            graphics.setLineWidthFloat(dw );
        }


        // If line width is 1 and scale is 100% and don't use offset then do nothing
        if(lineWidth == 1 && scale == 1.0 && !useLineOffset ) {
            return;
        }

        if (scale < 1.0)
            graphics.setAntialias(SWT.ON);


        // x,y offset is half of line width
        float offset = (float)lineWidth / 2;

        // If this is a non hi-res device and scale == 100% round up to integer to stop anti-aliasing
        if(getDeviceZoom() == 100 && scale == 1.0) {
            offset = (float)Math.ceil(offset);
        }
        graphics.translate(offset, offset);

        // Width and height reduced to compensate for x,y offset
        bounds.resize(-offset * 2, -offset * 2);
    }

    /**
     *
     * @return The actual device zoom level.
     * @author Credits to Archi , see ImageFactory
     */
    @objid ("149daf9e-b767-4785-855d-a9e956be958e")
    @SuppressWarnings("restriction")
    public static int getDeviceZoom() {
        // Note - Not sure if we need this any more...but just in case
        Display.getDefault();

        return DPIUtil.getDeviceZoom();

        // Alternate method which I suppose is the official way
        //String deviceZoom = System.getProperty("org.eclipse.swt.internal.deviceZoom"); //$NON-NLS-1$
        //return deviceZoom == null ? 100 : Integer.parseInt(deviceZoom);
    }

    /**
     *
     * @return The Current Zoom drawing scale for a Figure
     */
    @objid ("a4d65b4e-cce9-4ff8-b47d-9ff2e6632d62")
    public static double getFigureScale(IFigure figure) {
        if(figure instanceof ScalableFigure) {
            return ((ScalableFigure)figure).getScale();
        }

        return figure == null ? 1.0 : getFigureScale(figure.getParent());
    }

    /**
     * Record the scale factor for the Graphics instance
     * <p>
     * This is to workaround the scale is not accessible from the {@link SWTGraphics} instance.
     *
     * @param graphics The Graphics instance
     * @param scale The scale factor
     * @since 6.1.1 22/05/2025
     */
    @objid ("754d500b-e17d-4800-af02-2e18adb79a5a")
    public static void onScaledGraphics(Graphics graphics, double scale) {
        if(graphics instanceof SWTGraphics) {
            swtGraphicsScaleCache.compute(graphics, (k,v) -> (v==null) ? scale : v * scale);
        }
    }

    /**
     * Get the scale factor of the Graphics instance.
     * <p>
     * This is to workaround the scale is not accessible from the {@link SWTGraphics} instance.
     *
     * @return The scale factor of the Graphics instance
     * @since 6.1.1 22/05/2025
     */
    @objid ("be514946-3dd5-4ef1-979c-ecefb09e7357")
    public static double getGraphicsScale(Graphics graphics) {
        if(graphics instanceof SWTGraphics) {
            return swtGraphicsScaleCache.getOrDefault(graphics, 1.0);
        }
        else if(graphics instanceof ScaledGraphics) {
            return graphics.getAbsoluteScale();
        }
        return 1.0;
    }

    /**
     * Create a Path from a points list
     *
     * @param points The points list
     * @return The Path - callers should dispose of it
     * @author Credits to Archi , see FigureUtils
     * @since 6.1.1 22/05/2025
     */
    @objid ("07250891-edd6-4d73-8e22-730e58567c1c")
    public static Path createPathFromPoints(PointList points) {
        return createPathFromPoints(points.toIntArray());
    }

    /**
     * Create a Path from a points list
     *
     * @param points The points as x,y
     * @return The Path - callers should dispose of it
     * @author Credits to Archi , see FigureUtils
     * @since 6.1.1 22/05/2025
     */
    @objid ("e4374805-9d36-4e35-b3f4-fca31b56b3bb")
    public static Path createPathFromPoints(int[] points) {
        Path path = new Path(null);

        path.moveTo(points[0], points[1]);

        for(int i = 2; i < points.length; i += 2) {
            path.lineTo(points[i], points[i + 1]);
        }

        path.lineTo(points[0], points[1]);

        return path;
    }

}
