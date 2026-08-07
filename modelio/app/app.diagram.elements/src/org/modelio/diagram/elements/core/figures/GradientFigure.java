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
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.graphics.RGB;
import org.modelio.diagram.elements.core.figures.geometry.Direction;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

/**
 * Base class for rectangle figure with gradient background.
 */
@objid ("7fa261af-1dec-11e2-8cad-001ec947c8cc")
public class GradientFigure extends Figure implements IBrushOptionsSupport, IPenOptionsSupport, HandleBounds {
    @objid ("21bbe186-0313-42be-a283-09cc991f4b79")
    private Direction gradientDirection = Direction.NORTH;

    @objid ("7fa261b5-1dec-11e2-8cad-001ec947c8cc")
    protected final BrushOptions brushOptions;

    @objid ("7fa261b9-1dec-11e2-8cad-001ec947c8cc")
    protected final PenOptions penOptions;

    @objid ("6330be17-1e83-11e2-8cad-001ec947c8cc")
    private static Rectangle tempRect = new Rectangle();

    @objid ("7fa261ba-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public Rectangle getHandleBounds() {
        return getBounds().getCopy();
    }

    /**
     * Set the gradient orientation. The gradient goes from the fill color to the gradient derived color. The direction value designates the side of the figure that is colored by the fill color.
     * <ul>
     * <li>EAST horizontal gradient, fill color on the left side, derived color on the right side</li>
     * <li>WEST horizontal gradient, fill color on the right side, derived color on the left side</li>
     * <li>NORTH vertical gradient, fill color on the top side, derived color on the bottom side</li>
     * <li>SOUTH vertical gradient, fill color on the bottom side, derived color on the top side</li>
     * </ul>
     */
    @objid ("2ae519d2-d098-46f0-82ff-09c78d7fcb44")
    public void setGradientDirection(Direction direction) {
        this.gradientDirection = direction;
    }

    /**
     * Creates a gradient figure.
     */
    @objid ("7fa261c1-1dec-11e2-8cad-001ec947c8cc")
    public GradientFigure() {
        this.brushOptions = new BrushOptions();
        this.penOptions = new PenOptions();
    }

    @objid ("7fa261c4-1dec-11e2-8cad-001ec947c8cc")
    @Override
    protected void paintFigure(Graphics graphics) {
        if (isOpaque() && this.brushOptions.fillColor != null) {
            graphics.setAlpha(this.brushOptions.alpha);

            withGradientFill(graphics, () -> {
                Rectangle paintRect = getPaintRectangle();
                graphics.fillRectangle(paintRect);
                //graphics.fillRectangle(getBounds());
            });
        }

        graphics.restoreState();
    }

    /**
     * Execute the runnable with a gradient fill set up with {@link Graphics#setBackgroundPattern(Pattern)}.
     * <p>
     * This method sets the background color to the fill color and the foreground color to a derived gradient color.
     * The gradient color is computed from the fill color using {@link #computeGradientColor(Color)}.
     * <p>
     * If the brush options specify a gradient fill, it creates a gradient pattern using {@link GradientFactory#createGradient(Graphics, Rectangle, Color, int, Direction)} and
     * executes the runnable with this pattern set as the background pattern.
     * If the brush options does not specify a gradient fill, it simply sets the background color to the fill color and executes the runnable without any gradient.
     * If the figure is not opaque or if the fill color is null, it does nothing and returns immediately.
     * <p>
     * This method is typically used to paint a gradient background.
     * The gradient fill is applied to the graphics context, and the runnable is executed within this context.
     * The gradient fill is disposed after the runnable is executed to free resources.
     *
     * @param graphics the graphics context to use for drawing
     * @param backgroundPainter the code to execute with the gradient fill
     */
    @objid ("5c2718e1-ca43-4323-ba75-78eb667db05e")
    protected void withGradientFill(Graphics graphics, Runnable backgroundPainter) {
        if (! isOpaque() || this.brushOptions.fillColor == null)
            return; // Transparent or no fill color, do not paint the background.

        // Setup the gradient fill
        graphics.setAlpha(this.brushOptions.alpha);
        if (this.brushOptions.useGradient && this.brushOptions.fillColor != null) {
            Color gradientFillColor = computeGradientColor(this.brushOptions.fillColor);
            graphics.setBackgroundColor(this.brushOptions.fillColor);
            graphics.setForegroundColor(gradientFillColor);
            graphics.setFillRule(SWT.FILL_WINDING);
            Pattern pattern = GradientFactory.createGradient(graphics, getPaintRectangle(), this.brushOptions.fillColor, this.brushOptions.alpha, this.gradientDirection);
            try {
                graphics.setBackgroundPattern(pattern);
                backgroundPainter.run();
                graphics.setBackgroundPattern(null);
            } finally {
                // Dispose the gradient fill
                pattern.dispose();
            }

        } else {
            graphics.setBackgroundColor(this.brushOptions.fillColor);
            graphics.setFillRule(SWT.FILL_WINDING);
            backgroundPainter.run();
        }
    }

    @objid ("7fa261ca-1dec-11e2-8cad-001ec947c8cc")
    protected Color computeGradientColor(Color base) {
        // float[] hsb = base.getRGB().getHSB();
        // Color derivedColor = new Color(base.getDevice(), new RGB(hsb[0], hsb[1] * 0.1f, hsb[2] /*Math.min(hsb[2] * 1.1f, 1.0f)*/ ));
        Color derivedColor = new Color(base.getDevice(), new RGB(255, 255, 255));
        return derivedColor;
    }

    @objid ("7fa261cf-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setFillColor(Color fillColor) {
        if (this.brushOptions.fillColor != fillColor) {
            setBackgroundColor(fillColor);
            this.brushOptions.fillColor = fillColor;
            this.repaint();
        }
    }

    @objid ("7fa261d3-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public Color getFillColor() {
        return this.brushOptions.fillColor;
    }

    @objid ("7fa261d8-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public boolean getUseGradient() {
        return this.brushOptions.useGradient;
    }

    @objid ("7fa261dd-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setUseGradient(boolean useGradient) {
        if (this.brushOptions.useGradient != useGradient) {
            this.brushOptions.useGradient = useGradient;
            this.repaint();
        }
    }

    @objid ("7fa261e1-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public Color getLineColor() {
        return this.penOptions.lineColor;
    }

    @objid ("7fa261e6-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public int getLineWidth() {
        return this.penOptions.lineWidth;
    }

    @objid ("7fa261eb-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public Color getTextColor() {
        return this.penOptions.textColor;
    }

    @objid ("7fa261f0-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public Font getTextFont() {
        return this.penOptions.textFont;
    }

    @objid ("7fa261f5-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setLineColor(Color lineColor) {
        if (this.penOptions.lineColor != lineColor) {
            this.penOptions.lineColor = lineColor;
            this.repaint();
        }
    }

    @objid ("7fa4c40a-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setLineWidth(int lineWidth) {
        if (this.penOptions.lineWidth != lineWidth) {
            this.penOptions.lineWidth = lineWidth;
            this.repaint();
        }
    }

    @objid ("7fa4c40e-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setTextColor(Color textColor) {
        if (this.penOptions.textColor != textColor) {
            this.penOptions.textColor = textColor;
            this.repaint();
        }
    }

    @objid ("7fa4c412-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setTextFont(Font textFont) {
        if (this.penOptions.textFont != textFont) {
            this.penOptions.textFont = textFont;
            this.repaint();
        }
    }

    @objid ("7fa4c416-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public LinePattern getLinePattern() {
        return this.penOptions.linePattern;
    }

    @objid ("7fa4c41b-1dec-11e2-8cad-001ec947c8cc")
    @Override
    public void setLinePattern(LinePattern lineStyle) {
        if (this.penOptions.linePattern != lineStyle) {
            this.penOptions.linePattern = lineStyle;
            this.repaint();
        }
    }

    @objid ("8e1447f4-a6ee-4e12-a9b2-70b54a996a7f")
    @Override
    public void setFillAlpha(int alpha) {
        if (this.brushOptions.alpha != alpha) {
            this.brushOptions.alpha = alpha;
            this.repaint();
        }
    }

    @objid ("d12ba4b3-4884-4030-8eeb-0a91ef43bbc8")
    @Override
    public int getFillAlpha() {
        return this.brushOptions.alpha;
    }

    /**
     * Copy constructor.
     * <p>
     * Copy only what can be safely be copied, skip layout manager, Border and composition hierarchy.
     *
     * @param orig the original figure.
     */
    @objid ("e98df5b2-c891-4034-a851-af50e389a784")
    public GradientFigure(GradientFigure orig) {
        // No copy constructor on Figure ;-(
        super();

        // Figure copy constructor emulation
        this.bounds.setBounds(orig.getBounds());
        // don't set border nor layout manager : we usually have no copy constructor for them.

        // GradientFigure specific
        this.brushOptions = new BrushOptions(orig.brushOptions);
        this.penOptions = new PenOptions(orig.penOptions);
    }

    @objid ("e6b25987-b256-454b-bbde-79316a90607e")
    @Override
    public String toString() {
        return String.format("%s [%s%sbounds = %s, id=%s]",
                getClass().getSimpleName(),
                isVisible() ? "" : "invisible ",
                getParent() == null ? "orphan, " : "",
                getBounds(),
                java.lang.System.identityHashCode(this));
    }

    /**
     * The rectangle to be painted by the gradient. It is computed by shrinking the figure bounds by the (outer) border insets (only the 'margin' part of the border)
     *
     * This method might require re-definition in sub-classes, should these subclasses use a different approach to draw the gradient background.
     *
     * Typically {@link ShapedFigure} uses a clippath to limit the gradient drawing instead of relying on their shaped border.
     *
     * @return the static tempRect is returned to avoid expensive rectangle allocations.
     */
    @objid ("3217fcd8-e156-4637-b4d3-509eb98e73f7")
    protected Rectangle getPaintRectangle() {
        Border b = this.getBorder();
        Insets insets = NO_INSETS;
        if (b != null && b instanceof CompoundBorder) {
            insets = ((CompoundBorder) b).getOuterBorder().getInsets(this);
        }
        tempRect = getBounds().getShrinked(insets);
        return tempRect;
    }

}
