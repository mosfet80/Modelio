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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.geometry.Direction;

/**
 * Gradient Pattern factory
 * <p>
 * This class is used to create a gradient pattern for the given graphics and rectangle.
 * It takes into account the scale of the graphics and the rectangle location and dimension.
 * It also provides a method to create a gradient pattern with a given {@link Direction}.
 * <p>
 * The default end color is set to white, and the alpha transparency is applied to both the starting and ending colors.
 * <p>
 * The gradient pattern is created using the SWT {@link Pattern} class, which allows for smooth gradients between two colors.
 * The gradient can be used to fill shapes or backgrounds in SWT graphics.
 * This class is particularly useful for creating visually appealing gradients in SWT-based applications.
 *
 * @author Credits to Archi , see FigureUtils
 * @since 6.1.1 22/05/2025
 */
@objid ("7bd43c44-e12c-4f3c-a177-8e7daa52b611")
public class GradientFactory {
    /**
     * Create a Pattern class with consideration to the scale of the Graphics class
     * Adapted from https://www.eclipse.org/forums/index.php?t=msg&th=198946&goto=894610&#msg_894610
     */
    @objid ("23351e6c-7c46-445d-8060-bfa61b20b701")
    public static Pattern createGradient(Graphics graphics, Device device, float x1, float y1, float x2, float y2, Color color1, int alpha1, Color color2, int alpha2) {
        double scale = graphics.getAbsoluteScale();

        return new Pattern(device, (int)(x1 * scale), (int)(y1 * scale), (int)(x2 * scale), (int)(y2 * scale), color1, alpha1, color2,
                alpha2);
    }

    /**
     * Create a Pattern class with consideration to the scale of the Graphics class using the given gradient direction and default gradient end color.
     * <p>
     * This method creates a gradient pattern that extends the gradient area to cover the rectangle
     * and the end color is set to white.
     *
     * @param graphics the graphics context to use for creating the gradient
     * @param r the rectangle area to cover with the gradient
     * @param color the starting color of the gradient
     * @param direction the direction of the gradient (NORTH, SOUTH, EAST, WEST)
     * @return a Pattern object representing the gradient
     */
    @objid ("9f9ad5ac-572c-4f2e-9a98-1b22333d52a5")
    public static Pattern createGradient(Graphics graphics, Rectangle r, Color color, Direction direction) {
        return createGradient(graphics, r, color, 255, direction);
    }

    /**
     * Create a Pattern class with consideration to the scale of the Graphics class using the
     * given gradient direction and default gradient end color and alpha transparency
     * <p>
     * This method creates a gradient pattern that extends the gradient area to cover the rectangle
     * and the end color is set to white.
     *
     * @param graphics the graphics context to use for creating the gradient
     * @param r the rectangle area to cover with the gradient
     * @param color the starting color of the gradient
     * @param alpha the alpha transparency value for both colors
     * @param direction the direction of the gradient (NORTH, SOUTH, EAST, WEST)
     * @return a Pattern object representing the gradient
     */
    @objid ("fa8f86da-562b-41ca-9dc5-4620a47f6624")
    public static Pattern createGradient(Graphics graphics, Rectangle r, Color color, int alpha, Direction direction) {
        if(direction == null) {
            return null;
        }

        Color endColor = ColorConstants.white;

        return createGradient(graphics, r, color, endColor, alpha, direction);
    }

    /**
     * Create a Pattern class with consideration to the scale of the Graphics class using the
     * given gradient direction and default gradient end color and alpha transparency
     * <p>
     * This method creates a gradient pattern that extends the gradient area to cover the rectangle
     * and the end color is set to white.
     *
     * @param graphics the graphics context to use for creating the gradient
     * @param r the rectangle area to cover with the gradient
     * @param color the starting color of the gradient
     * @param endColor the ending color of the gradient
     * @param alpha the alpha transparency value for both colors
     * @param direction the direction of the gradient (NORTH, SOUTH, EAST, WEST)
     * @return a Pattern object representing the gradient
     * @since 6.1.1 27/05/2025
     *
     * @implNote This method is designed to create a gradient pattern that can be used in SWT graphics.
     * It takes into account the scale of the graphics and the rectangle dimensions.
     * The end color is set to white, and the alpha transparency is applied to both the starting and ending colors.
     * This method is useful for creating visually appealing gradients in SWT-based applications.
     * @implNote This method is particularly useful for creating gradients that extend beyond the bounds of the rectangle,
     * allowing for a more seamless transition to the background color.
     * The deltaFactor can be adjusted to control how much the gradient extends beyond the rectangle.
     */
    @objid ("cd9f663c-7999-46a1-838b-7a8e63cc21d0")
    public static Pattern createGradient(Graphics graphics, Rectangle r, Color color, Color endColor, int alpha, Direction direction) {
        // Disabled: Gradienting all the way to pure white is too much, this extends the gradient area to cover that
        float deltaFactor = 0; //0.15f;

        switch(direction) {
        case NORTH:
        default:
            int delta = (int) (r.height * deltaFactor);
            return createGradient(graphics, Display.getCurrent(), r.x, r.y, r.x, r.bottom() + delta, color, alpha, endColor, alpha);

        case WEST:
            delta = (int) (r.width * deltaFactor);
            return createGradient(graphics, Display.getCurrent(), r.x, r.y, r.right() + delta, r.y, color, alpha, endColor, alpha);

        case EAST:
            delta = (int) (r.width * deltaFactor);
            return createGradient(graphics, Display.getCurrent(), r.right(), r.y, r.x - delta, r.y, color, alpha, endColor, alpha);

        case SOUTH:
            delta = (int) (r.height * deltaFactor);
            return createGradient(graphics, Display.getCurrent(), r.x, r.bottom(), r.x, r.y - delta, color, alpha, endColor, alpha);
        }
    }

}
