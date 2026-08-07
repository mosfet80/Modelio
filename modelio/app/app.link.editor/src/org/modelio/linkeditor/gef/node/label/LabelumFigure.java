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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.linkeditor.gef.node.label;

import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.modelio.linkeditor.plugin.LinkEditor;

/**
 * This is a rotatable wrapped label with an icon .
 * <p>
 * The word wrap strategy is set using a {@link ILabelumTextLayouter}.
 * <p>
 * <h3>Implementation:</h3>
 * <li>It is copied from the {@link org.eclipse.draw2d.Label} implementation.
 * <li>It can be viewed as a rectangle containing a rotated rectangle that
 * take the maximum place.
 *
 * @since Modelio 3.4
 */
@objid ("b141152b-77ae-4c29-926a-df1291df5995")
public class LabelumFigure extends Figure implements IPenOptionsSupport, PositionConstants {
    @objid ("0ec32850-490b-461a-bb07-03f2c4331b5a")
    private static boolean DEBUG = false;

    @objid ("3758cc33-4898-4bdb-bd8a-e410ba338768")
    private static String ELLIPSIS = "...";

    @objid ("9c6e05f5-ece1-401c-974f-2430074f54d3")
    private int iconAlignment = PositionConstants.CENTER;

    @objid ("e55d04ca-f2ef-4cd8-af61-4de7f64908b9")
    private int iconTextGap = 3;

    @objid ("818bac1d-02ef-4716-8686-63cf247da435")
    private int labelAlignment = PositionConstants.CENTER;

    /**
     * rotation angle in degrees.
     * <p>
     * Is guaranteed to be between 0 and 359.
     */
    @objid ("628eb4d4-5ce4-479c-a36a-f444696fd221")
    private int orientation;

    /**
     * The amount of the Label's current text will fit in the Label,
     * including an elipsis "..." if truncation is required.
     */
    @objid ("b35a0c56-f3bb-429c-adf5-917ef579768b")
    private String subStringText;

    @objid ("e481a248-c5e1-4986-8057-fab8ad7ca21d")
    private String text = "";

    @objid ("48104f09-0d0a-441d-866e-3ae666426d07")
    private int textAlignment = PositionConstants.CENTER;

    @objid ("6a4594e7-1e1c-43ed-8166-e4272a2e4ee1")
    private int textPlacement = PositionConstants.EAST;

    @objid ("64dee7d2-cff6-4e25-a036-5f7b8f97d462")
    private Image icon;

    /**
     * Shared SWT {@link TextLayout} used for layouting text and drawing it.
     */
    @objid ("35e5f468-d9c0-4b4b-a0f7-1720cf15e686")
    private static TextLayout textDrawer = null;

    @objid ("1777bbc4-7a4f-41b0-9767-9679c4652b82")
    private TextStyle textStyle = new TextStyle();

    /**
     * Icon location in the inner rectangle coordinates
     */
    @objid ("c5cb39fb-8518-41b9-88f3-79b4a8e65b4b")
    private Point iconLocation;

    @objid ("362fb5a0-ee1a-4496-9de4-bdd1aaf2defa")
    private Dimension iconSize = new Dimension(0, 0);

    /**
     * The inner rotated rectangle coordinates.
     */
    @objid ("bf2c11f0-0e57-463b-b9af-0fe604895977")
    private PrecisionRectangle innerRectangle;

    @objid ("d1eb48d2-2298-4f26-bd37-086ce1a611fc")
    private Dimension subStringTextSize;

    /**
     * Text location in the inner rectangle coordinates
     */
    @objid ("de57e261-ef75-4098-b84b-9a5bc4b8f6cd")
    private Point textLocation;

    @objid ("1365c6cf-2a40-432e-a5d3-46973eddd4e2")
    private Dimension textSize;

    @objid ("02e3cae8-4135-4020-bdbf-0440ccc242a8")
    private ILabelumTextLayouter textLayouter = NativeTextLayouter.INSTANCE;

    /**
     * Creates an empty label figure oriented horizontally.
     */
    @objid ("5b4f29bd-88fd-4f31-99e9-b139115295b3")
    public LabelumFigure() {
        init();
    }

    /**
     * Construct a Label with passed String as its text.
     *
     * @param s the label text
     */
    @objid ("60afa957-4c8a-4155-900a-65b626bfc675")
    public LabelumFigure(String s) {
        setText(s);
        init();
    }

    /**
     * Construct a Label with passed Image as its icon.
     *
     * @param i the label image
     */
    @objid ("b63d88ee-cc93-44cb-8184-4dc7f5df8bf9")
    public LabelumFigure(Image i) {
        setIcon(i);
        init();
    }

    /**
     * Construct a Label with passed String as text and passed Image as its
     * icon.
     *
     * @param s the label text
     * @param i the label image
     */
    @objid ("58501218-486c-4c05-a661-d68fa82506bc")
    public LabelumFigure(String s, Image i) {
        setText(s);
        setIcon(i);
        init();
    }

    @objid ("0fa3f6c2-0794-43cd-9fa9-f33d1e6e1730")
    @Override
    public Font getFont() {
        // the font is stored in the text style.
        if (this.textStyle.font != null) {
            return this.textStyle.font;
        }

        if (getParent() != null) {
            return getParent().getFont();
        }
        return null;
    }

    /**
     * Returns the Label's icon.
     *
     * @return the label icon
     * @since 2.0
     */
    @objid ("05efc211-ad3d-4827-b48b-cbc2ce84072e")
    public Image getIcon() {
        return this.icon;
    }

    /**
     * Returns the current alignment of the Label's icon. The default is
     * {@link PositionConstants#CENTER}.
     *
     * @return the icon alignment
     * @since 2.0
     */
    @objid ("d5df186c-3a65-44c7-8ab5-3ff5429b5c74")
    public int getIconAlignment() {
        return this.iconAlignment;
    }

    /**
     * Returns the bounds of the Label's icon.
     *
     * @return the icon's bounds
     * @since 2.0
     */
    @objid ("06db9165-f5cd-4bb3-aff9-e98ea31f13b0")
    public Rectangle getIconBounds() {
        Rectangle b = getBounds();
        return new Rectangle(b.getLocation().translate(getIconLocation()),
                        getIconSize());
    }

    /**
     * Returns the gap in pixels between the Label's icon and its text.
     *
     * @return the gap
     * @since 2.0
     */
    @objid ("d0bb57ac-d51b-453a-88e9-70e9221cb37b")
    public int getIconTextGap() {
        return this.iconTextGap;
    }

    /**
     * Returns the alignment of the entire label (icon and text). The default
     * label alignment is {@link PositionConstants#CENTER}.
     *
     * @return the label alignment
     * @since 3.5
     */
    @objid ("545ab9fa-5845-4e1c-bece-7b6b6d6b573a")
    public int getLabelAlignment() {
        return this.labelAlignment;
    }

    @objid ("38dabf03-b6a0-450a-b6f9-1cf5813c73eb")
    @Override
    public LayoutManager getLayoutManager() {
        LayoutManager manager = super.getLayoutManager();
        return manager;
    }

    @objid ("e385ef03-30a9-41bc-aec0-df6ee6c2ce85")
    @Override
    public Color getLineColor() {
        return this.textStyle.underlineColor;
    }

    @objid ("07d54184-eb12-408f-94ca-0a0dd71d3f1a")
    @Override
    public int getLineWidth() {
        return 0;
    }

    /**
     * Get the orientation angle in counter-clockwise degrees.
     *
     * @return the orientation angle in degrees. 0 means horizontal.
     */
    @objid ("0d140a26-7333-4f58-82ad-289ad7df7fe1")
    public int getOrientation() {
        return this.orientation;
    }

    /**
     * Calculates the amount of the Label's current text will fit in the Label,
     * including an elipsis "..." if truncation is required.
     *
     * @return the substring
     */
    @objid ("c9733056-f27a-4b9d-a2ef-8ad57f049e8f")
    public String getSubStringText() {
        if (this.subStringText == null) {
            // Compute subStringText and subStringTextSize
            final String origText = getText();

            // Format text to dimensions
            PrecisionRectangle ir = getInnerRectangle();
            Dimension availTextSize = calculateAvailableTextSize(new PrecisionDimension(ir.preciseWidth(), ir.preciseHeight()));
            this.subStringText = this.textLayouter.formatText(this, origText, availTextSize);

            // Configure text drawer to ask him text size
            // Store text size
            TextLayout td = getTextDrawer(this.subStringText, availTextSize.width());
            org.eclipse.swt.graphics.Rectangle ttb = td.getBounds();
            this.subStringTextSize = new Dimension(ttb.width, ttb.height);

        }
        return this.subStringText;
    }

    /**
     * Returns the bounds of the label's text. Note that the bounds are
     * calculated using the label's displayed text, truncated if needed.
     *
     * @return the bounds of this label's complete text
     */
    @objid ("680d453d-7a61-494b-881f-c3b6fc38b72a")
    public Rectangle getSubStringBounds() {
        Rectangle tb = getBounds().getCopy();
        tb.translate(getTextLocation());
        tb.setSize(getSubStringTextSize());
        return tb;
    }

    /**
     * Returns the text of the label. Note that this is the complete text of the
     * label, regardless of whether it is currently being truncated. Call
     * {@link #getSubStringText()} to return the label's current text contents
     * with truncation considered.
     *
     * @return the complete text of this label
     * @since 2.0
     */
    @objid ("1c4b3f57-2898-482f-bad1-cf214cadda09")
    public String getText() {
        return this.text;
    }

    /**
     * Returns the current alignment of the Label's text. The default text
     * alignment is {@link PositionConstants#CENTER}.
     *
     * @return the text alignment
     */
    @objid ("2c695cef-a574-4eb9-aace-1f61fbca3ad5")
    public int getTextAlignment() {
        return this.textAlignment;
    }

    /**
     * Returns the bounds of the label's text. Note that the bounds are
     * calculated using the label's complete text regardless of whether the
     * label's text is currently truncated.
     *
     * @return the bounds of this label's complete text
     */
    @objid ("d4991eae-9a16-48e0-8bc5-c3bffe65dbc7")
    public Rectangle getTextBounds() {
        Rectangle tb = getBounds().getCopy();
        tb.translate(getTextLocation());
        tb.setSize(getTextSize());
        return tb;
    }

    @objid ("56ce3066-6162-4921-a1e7-b72e1bfe7805")
    @Override
    public Color getTextColor() {
        return this.textStyle.foreground;
    }

    /**
     * Provides a TextLayout that can be used by the {@link LabelumFigure} and {@link ILabelumTextLayouter} for layout and drawing.
     * <p>
     * The returned {@link TextLayout} is ready to draw the given text with the labelum style.
     * <p>
     * This TextLayout must not be disposed by clients. The provided TextLayout's orientation will be LTR.
     *
     * @param textToDraw the text to draw
     * @param width the available width to draw text. -1 means no limit. Justification and text centering need a positive value.
     * @return a SWT TextLayout that can be used for Bidi
     */
    @objid ("1e2c930d-f25d-4dbf-9568-f04be7beb231")
    public TextLayout getTextDrawer(final String textToDraw, int width) {
        if (LabelumFigure.textDrawer == null) {
            LabelumFigure.textDrawer = new TextLayout(Display.getDefault());
        }

        TextLayout tl = LabelumFigure.textDrawer;
        try {
            if (isMirrored()) {
                tl.setOrientation(SWT.RIGHT_TO_LEFT);
            } else {
                tl.setOrientation(SWT.LEFT_TO_RIGHT);
            }

        } catch (@SuppressWarnings ("unused") org.eclipse.swt.SWTException e) {
            // the diagram is probably already disposed...
            return tl;
        }

        // Abort if the TextLayout is already configured with same parameters
        if (tl.getWidth() == width
                && Objects.equals(tl.getFont(), getTextFont())
                && textToDraw.equals(tl.getText())
                && (textToDraw.isEmpty() || this.textStyle.equals(tl.getStyle(0)))) {
            return tl;
        }

        // 0 is illegal,
        // -1 = disable wrap for drawing
        tl.setWidth(width > 0 ? width : -1);

        switch (this.labelAlignment) {
        case LEFT:
        case ALWAYS_LEFT:
        default:
            tl.setAlignment(SWT.LEFT);
            tl.setJustify(false);
            break;
        case RIGHT:
        case ALWAYS_RIGHT:
            tl.setAlignment(SWT.RIGHT);
            tl.setJustify(false);
            break;
        case CENTER:
            tl.setAlignment(SWT.CENTER);
            tl.setJustify(false);
            break;
        case (PositionConstants.LEFT + PositionConstants.RIGHT):
            tl.setAlignment(SWT.LEFT);
            tl.setJustify(true);
            break;
        }

        tl.setFont(getTextFont());
        tl.setText(textToDraw);
        tl.setStyle(this.textStyle, 0, textToDraw.length());
        return tl;
    }

    @objid ("675fe819-65dd-4e56-89b1-31a116c7f548")
    @Override
    public Font getTextFont() {
        return getFont();
    }

    /**
     * Get the line breaking strategy for this labelum.
     *
     * @return the labelum text layouter.
     */
    @objid ("40fdce95-2ec4-463b-b90d-84bd51e6d395")
    public ILabelumTextLayouter getTextLayouter() {
        return this.textLayouter;
    }

    /**
     * Returns the current placement of the label's text relative to its icon.
     * The default text placement is {@link PositionConstants#EAST}.
     *
     * @return the text placement
     */
    @objid ("f4c7a5d9-0645-4f4e-96c3-ec5a83a89aa1")
    public int getTextPlacement() {
        return this.textPlacement;
    }

    /**
     * Get the <code>LabelumFigure</code> text style.
     * <p>
     * Provides direct access to the text style.
     * Many text style fields can be set using the setter methods
     * on the <code>LabelumFigure</code>:
     * <ul>
     * <li>{@link #setTextFont(Font)} : {@link TextStyle#font}
     * <li>{@link #setTextColor(Color)} : {@link TextStyle#foreground}
     * <li>{@link #setLineColor(Color)} : {@link TextStyle#underlineColor}
     * <li>{@link #setUnderline(boolean)} : {@link TextStyle#underline}
     * <li>{@link #setStrikeThrough(boolean)}: {@link TextStyle#strikeout}
     * </ul>
     * You may need to call {@link #repaint()} after changing the text style fields.
     *
     * @return the text style
     */
    @objid ("caceeebb-a2cb-40fb-b7f3-4c7b3e409386")
    public TextStyle getTextStyle() {
        return this.textStyle;
    }

    /**
     * Gets the <code>TextUtilities</code> instance to be used in measurement
     * calculations.
     *
     * @return a <code>TextUtilities</code> instance
     * @since 3.4
     */
    @objid ("49481b29-9bf8-4156-9f41-6dd41def8bc7")
    public TextUtilities getTextUtilities() {
        return TextUtilities.INSTANCE;
    }

    @objid ("17f8f532-0e3b-4fdd-bdc2-692a82a8e2ec")
    @Override
    public void invalidate() {
        super.invalidate();

        this.innerRectangle = null;
        this.prefSize = null;
        this.minSize = null;
        clearLocations();
        this.textSize = null;
        this.subStringTextSize = null;
        this.subStringText = null;
    }

    @objid ("165eeddf-0851-430b-a746-e973749dc6f3")
    @Override
    public void setFont(Font f) {
        if (!Objects.equals(f, this.textStyle.font)) {
            this.textStyle.font = f;
            revalidate();
            repaint();
        }
    }

    /**
     * Sets the label's icon to the passed image.
     *
     * @param image the new label image
     * @since 2.0
     */
    @objid ("36829a2b-805d-4a36-aeab-3019dc6a927c")
    public void setIcon(Image image) {
        if (this.icon == image) {
            return;
        }
        this.icon = image;
        // Call repaint, in case the image dimensions are the same.
        repaint();
        if (this.icon == null) {
            setIconDimension(new Dimension());
        } else {
            setIconDimension(new Dimension(image));
        }
    }

    /**
     * This method sets the alignment of the icon within the bounds of the
     * label. If the label is larger than the icon, then the icon will be
     * aligned according to this alignment. Valid values are:
     * <UL>
     * <LI><EM>{@link PositionConstants#CENTER}</EM>
     * <LI>{@link PositionConstants#TOP}
     * <LI>{@link PositionConstants#BOTTOM}
     * <LI>{@link PositionConstants#LEFT}
     * <LI>{@link PositionConstants#RIGHT}
     * </UL>
     *
     * @param align the icon alignment
     */
    @objid ("f2a3b460-46d2-445b-bcaa-7bdb42387af7")
    public void setIconAlignment(int align) {
        if (this.iconAlignment == align) {
            return;
        }
        this.iconAlignment = align;
        clearLocations();
        repaint();
    }

    /**
     * Sets the gap in pixels between the label's icon and text to the passed
     * value. The default is 4.
     *
     * @param gap the gap
     */
    @objid ("232c2c3d-d3c2-42b7-a404-771829cf001a")
    public void setIconTextGap(int gap) {
        if (this.iconTextGap == gap) {
            return;
        }
        this.iconTextGap = gap;
        repaint();
        revalidate();
    }

    /**
     * Sets the alignment of the label (icon and text) within the figure. If
     * this figure's bounds are larger than the size needed to display the
     * label, the label will be aligned accordingly. Valid values are:
     * <UL>
     * <LI><EM>{@link PositionConstants#CENTER}</EM>
     * <LI>{@link PositionConstants#TOP}
     * <LI>{@link PositionConstants#BOTTOM}
     * <LI>{@link PositionConstants#LEFT}
     * <LI>{@link PositionConstants#RIGHT}
     * <LI>{@link PositionConstants#LEFT} + {@link PositionConstants#RIGHT} = Takes the whole place and justify text.
     * </UL>
     *
     * @param align label alignment
     */
    @objid ("4bc5fe8b-2bb9-4046-9ed4-d45cc51cafbb")
    public void setLabelAlignment(int align) {
        if (this.labelAlignment == align) {
            return;
        }

        this.labelAlignment = align;

        clearLocations();
        repaint();
    }

    @objid ("3e3e8e42-2e7a-4178-857b-f612f37d0261")
    @Override
    public void setLayoutManager(LayoutManager manager) {
        if (manager == null) {
            throw new IllegalArgumentException(String.format("%s must be a LabelumFigure.LM ", manager));
        }

        super.setLayoutManager(manager);
    }

    @objid ("2670e46a-c7f1-4353-bd9e-39e8388bd774")
    @Override
    public void setLineColor(Color lineColor) {
        this.textStyle.underlineColor = lineColor;
        this.textStyle.strikeoutColor = lineColor;
        repaint();
    }

    @objid ("28101930-bf8f-4b1a-9840-849060b35bef")
    @Override
    public void setLineWidth(int lineWidth) {
        // ignore
    }

    /**
     * Rotates the label by the given counter-clockwise angle.
     * <p>
     * The angle is specified in degrees and for the identity transform 0 degrees is
     * at the 3 o'clock position.
     * A positive value indicates a counter-clockwise rotation while a negative value
     * indicates a clockwise rotation.
     *
     * @param orientation the orientation in degrees.
     */
    @objid ("4734ce20-1c7f-4eab-a74e-45047f99e7ad")
    public void setOrientationAngle(int orientation) {
        this.orientation = orientation % 360;
        if (this.orientation < 0) {
            this.orientation = 360 + this.orientation;
        }

        revalidate();
    }

    /**
     * Set the label orientation using one of the {@link PositionConstants} constants.
     * <p>
     * {@link PositionConstants#EAST} is the default horizontal direction,
     * {@link PositionConstants#NORTH} is the default vertical direction.
     *
     * @param orientation the label orientation
     */
    @objid ("3976030e-d75b-4e04-817b-0d05a004ac50")
    public void setOrientationDirection(int orientation) {
        switch (orientation) {
        case PositionConstants.NORTH:
            setOrientationAngle(90);
            break;
        case PositionConstants.NORTH_EAST:
            setOrientationAngle(45);
            break;
        case PositionConstants.NORTH_WEST:
            setOrientationAngle(90 + 45);
            break;
        case PositionConstants.EAST:
            setOrientationAngle(0);
            break;
        case PositionConstants.SOUTH:
            setOrientationAngle(-90);
            break;
        case PositionConstants.SOUTH_EAST:
            setOrientationAngle(-45);
            break;
        case PositionConstants.SOUTH_WEST:
            setOrientationAngle(-90 - 45);
            break;
        case PositionConstants.WEST:
            setOrientationAngle(180);
            break;
        default:
            throw new IllegalArgumentException(String.valueOf(orientation));
        }
    }

    /**
     * Set whether the main label is underlined.
     *
     * @param strikeThrough true to strike the label
     */
    @objid ("060d2494-bd99-4147-a797-fb09805bb88a")
    public void setStrikeThrough(final boolean strikeThrough) {
        if (this.textStyle.strikeout != strikeThrough) {
            this.textStyle.strikeout = strikeThrough;
            repaint();
        }
    }

    /**
     * Sets the label's text.
     *
     * @param s the new label text
     * @since 2.0
     */
    @objid ("25b6d1b4-f62e-4ba7-aca2-00a7c8bc5af4")
    public void setText(String s) {
        // "text" will never be null.
        String ls = s;
        if (ls == null) {
            ls = "";//$NON-NLS-1$
        }
        if (this.text.equals(ls)) {
            return;
        }
        this.text = ls;
        revalidate();
        repaint();
    }

    @objid ("f172ac55-6537-446e-9c09-5bf251c0342f")
    @Override
    public void setTextColor(Color textColor) {
        if (!Objects.equals(this.textStyle.foreground, textColor)) {
            this.textStyle.foreground = textColor;
            repaint();
        }
    }

    @objid ("c8ce2b7e-387d-4480-8aac-7f681cc7dfc8")
    @Override
    public void setTextFont(Font textFont) {
        setFont(textFont);
    }

    /**
     * Set the text layouter used to define where text lines are broken.
     *
     * @param labellumLayouter the text layouter.
     */
    @objid ("96878fd0-a697-4d76-99f4-5175659c7168")
    public void setTextLayouter(ILabelumTextLayouter labellumLayouter) {
        if (!Objects.equals(this.textLayouter, labellumLayouter)) {
            this.textLayouter = labellumLayouter;
            revalidate();
            repaint();
        }
    }

    /**
     * Sets the minor alignment of the text <b>relative to the icon</b> within the label.
     * <p>
     * If you want to set the text horizontal alignment, use {@link #setLabelAlignment(int)}.
     * <p>
     * The text alignment must be orthogonal to the text placement. For example, if
     * the placement is EAST, then the text can be aligned using TOP, CENTER, or
     * BOTTOM. Valid values are:
     * <UL>
     * <LI><EM>{@link PositionConstants#CENTER}</EM>
     * <LI>{@link PositionConstants#TOP}
     * <LI>{@link PositionConstants#BOTTOM}
     * <LI>{@link PositionConstants#LEFT}
     * <LI>{@link PositionConstants#RIGHT}
     * </UL>
     *
     * @param align the text alignment
     * @see #setLabelAlignment(int)
     */
    @objid ("e562e85e-c57e-4f6e-8fb0-d80eafd4bc9a")
    public void setTextMinorAlignment(int align) {
        if (this.textAlignment == align) {
            return;
        }
        this.textAlignment = align;
        clearLocations();
        repaint();
    }

    /**
     * Sets the placement of the text relative to the icon within the label.
     * Valid values are:
     * <UL>
     * <LI><EM>{@link PositionConstants#EAST}</EM>
     * <LI>{@link PositionConstants#NORTH}
     * <LI>{@link PositionConstants#SOUTH}
     * <LI>{@link PositionConstants#WEST}
     * </UL>
     *
     * @param where the text placement
     * @since 2.0
     */
    @objid ("b328b1a1-1688-46ca-bdc4-c634e3677557")
    public void setTextPlacement(int where) {
        if (this.textPlacement == where) {
            return;
        }
        this.textPlacement = where;
        revalidate();
        repaint();
    }

    /**
     * Set whether the main label is underlined.
     *
     * @param underline true to underline the main label
     */
    @objid ("8e4e7c1d-7753-44c0-bd27-186ab30236b2")
    public void setUnderline(final boolean underline) {
        if (this.textStyle.underline != underline) {
            this.textStyle.underline = underline;
            repaint();
        }
    }

    /**
     * Calculates the size available for text using the passed Dimension as the size
     * of the whole Label's figure.
     *
     * @param figureSize the precalculated size of the label's figure.
     * @return the available text size
     */
    @objid ("e9a50ada-0eb6-42e1-8709-b032fb0a1f8d")
    protected Dimension calculateAvailableTextSize(Dimension figureSize) {
        int gap = getIconTextGap();
        if (getIcon() == null || getText().isEmpty()) {
            gap = 0;
        }

        Dimension d = new Dimension(0, 0);
        final int txtPlacement = getTextPlacement();
        if (txtPlacement == PositionConstants.WEST || txtPlacement == PositionConstants.EAST) {
            d.width = figureSize.width() - getIconSize().width() - gap;
            d.height = Math.max(getIconSize().height(), figureSize.height());
        } else {
            d.width = Math.max(getIconSize().width(), figureSize.width());
            d.height = figureSize.height() - getIconSize().height() - gap;
        }

        if (figureSize.width() == -1) {
            d.width = -1;
        }
        if (figureSize.height() == -1) {
            d.height = -1;
        }
        return d;
    }

    /**
     * Calculates the size of the Label using the passed Dimension as the size
     * of the Label's text.
     *
     * @param txtSize the precalculated size of the label's text
     * @return the label's size in a new Dimension.
     * @since 2.0
     */
    @objid ("ed008915-f0a6-4b52-a8cb-70e29db0b7e4")
    protected Dimension calculateLabelSize(Dimension txtSize) {
        int gap = getIconTextGap();
        if (getIcon() == null || getText().equals("")) {
            gap = 0;
        }
        Dimension d = new Dimension(0, 0);
        if (this.textPlacement == PositionConstants.WEST || this.textPlacement == PositionConstants.EAST) {
            d.width = getIconSize().width + gap + txtSize.width;
            d.height = Math.max(getIconSize().height, txtSize.height);
        } else {
            d.width = Math.max(getIconSize().width, txtSize.width);
            d.height = getIconSize().height + gap + txtSize.height;
        }
        return d;
    }

    /**
     * Called by the layout manager.
     *
     * @param w rectangle width
     * @param h rectangle height
     * @return The minimum size
     */
    @objid ("ffe613eb-c171-44f2-b845-443965aa5c8b")
    protected Dimension calculateMinimumSize(int w, int h) {
        Dimension availTextSize;
        if (w == -1 && h == -1) {
            availTextSize = new Dimension(-1, -1); // unlimited size
        } else {
            availTextSize = calculateAvailableTextSize(calculateMaxRotatedRectangleSize(w, h));
        }

        // reformat text into availTextSize, setup the text layouter and compute its size
        String tt = getTextLayouter().formatText(LabelumFigure.this, getText(), availTextSize);
        TextLayout td = getTextDrawer(tt, -1 /* availTextSize.width() */);
        org.eclipse.swt.graphics.Rectangle ttBounds = td.getBounds();
        Dimension ttDim = new Dimension(ttBounds.width, ttBounds.height);

        // Compute ellipsis size
        Dimension truncatedTextSize = getTextUtilities().getTextExtents(getTruncationString(), getFont());

        // Compute needed label bounds for text or ellipsis
        Dimension lMinSize = calculateRotatedRectangleBounds(calculateLabelSize(truncatedTextSize.union(ttDim)), new Dimension());

        // Add insets
        Insets insets = getInsets();
        lMinSize.expand(insets.getWidth(), insets.getHeight());
        return lMinSize;
    }

    /**
     * Called by the layout manager.
     *
     * @param wHint The width hint
     * @param hHint The height hint
     * @return The preferred size
     */
    @objid ("8f86920f-c68d-4954-8005-59ee0b23e293")
    protected Dimension calculatePreferredSize(int wHint, int hHint) {
        Dimension lprefSize = calculateRotatedRectangleBounds(calculateLabelSize(getTextSize()), new Dimension());
        Insets insets = getInsets();
        lprefSize.expand(insets.getWidth(), insets.getHeight());

        if ((wHint >= 0 && wHint < lprefSize.width) || (hHint >= 0 && hHint < lprefSize.height)) {
            // Default preferred size is too big for given hints,
            // calculate minimum size for them.

            Dimension result = getMinimumSize(wHint, hHint).getCopy();
            result.width = Math.max(result.width, wHint);
            result.height = Math.max(result.height, hHint);

            return result;
        } else if ((wHint >= 0 && wHint > lprefSize.width && this.labelAlignment == PositionConstants.LEFT + PositionConstants.RIGHT)) {
            // Justified text and remaining place, take the whole space and justify
            lprefSize.width = wHint;
        }
        return lprefSize;
    }

    /**
     * Calculates and returns the size of the Label's text. Note that this
     * Dimension is calculated using the Label's full text, regardless of
     * whether or not its text is currently truncated. If text size considering
     * current truncation is desired, use {@link #getSubStringTextSize()}.
     *
     * @return the size of the label's text, ignoring truncation
     * @since 2.0
     */
    @objid ("dad27cf4-be6a-4530-b793-f5f6930c7612")
    protected Dimension calculateTextSize() {
        TextLayout td = getTextDrawer(getText(), -1);
        org.eclipse.swt.graphics.Rectangle ttb = td.getBounds();
        Dimension textExtents = new Dimension(ttb.width, ttb.height);
        return textExtents;
    }

    /**
     * Returns the location of the Label's icon relative to the Label.
     *
     * @return the icon's location
     * @since 2.0
     */
    @objid ("9b47e64d-5c5a-4adf-b9ea-49b16edd7e46")
    protected Point getIconLocation() {
        if (this.iconLocation == null) {
            calculateLocations();
        }
        return this.iconLocation;
    }

    /**
     * Gets the icon size
     *
     * @return the icon size
     * @since 3.4
     */
    @objid ("c15ad65f-b648-41cf-b9ce-b9f1ea4f77bd")
    protected Dimension getIconSize() {
        return this.iconSize;
    }

    @objid ("a1822fa3-5c2b-466d-840f-78e485d7ffb2")
    protected PrecisionRectangle getInnerRectangle() {
        if (this.innerRectangle == null) {
            PrecisionRectangle r = new PrecisionRectangle();
            Dimension size = getSize();
            r.setSize(calculateMaxRotatedRectangleSize(size.width, size.height));

            this.innerRectangle = r;
            double innerW = this.innerRectangle.preciseWidth();
            double innerH = this.innerRectangle.preciseHeight();
            double sinr = Math.sin(Math.toRadians(this.orientation));
            double cosr = Math.cos(Math.toRadians(this.orientation));

            // Translate the rotated inner rectangle so that it fits inside the figure bounds.
            if (this.orientation <= 90) {
                // final double dy = size.preciseHeight() / 2;
                final double dy = this.innerRectangle.width() * sinr;
                this.innerRectangle.translate(0.0, dy);
            } else if (this.orientation > 90 && this.orientation <= 180) {
                // double dx = - size.width() / 2.0;
                double dx = -innerW * cosr;
                double dy = innerW * sinr - innerH * cosr;
                this.innerRectangle.translate(dx, dy /* getSize().height */);
            } else if (this.orientation > 180 && this.orientation <= 270) {
                double dx = -innerW * cosr - innerH * sinr;
                double dy = -innerH * cosr;
                this.innerRectangle.translate(dx, dy);
            } else {
                double dx = -innerH * sinr;
                final double dy = 0;
                this.innerRectangle.translate(dx, dy);
            }
        }
        return this.innerRectangle;
    }

    /**
     * Returns the size of the Label's current text. If the text is currently
     * truncated, the truncated text with its ellipsis is used to calculate the
     * size.
     *
     * @return the size of this label's text, taking into account truncation
     * @since 2.0
     */
    @objid ("877dcb23-002a-4efe-9d42-d6481138caa3")
    protected Dimension getSubStringTextSize() {
        if (this.subStringTextSize == null) {
            getSubStringText(); // compute text and text size
        }
        return this.subStringTextSize;
    }

    /**
     * Returns the location of the label's text relative to the label.
     * <p>
     * The point is in the inner rectangle coordinates.
     *
     * @return the text location
     */
    @objid ("19bfe0f8-6ea6-47a0-81aa-f68827f75ef6")
    protected Point getTextLocation() {
        if (this.textLocation != null) {
            return this.textLocation;
        }
        calculateLocations();
        return this.textLocation;
    }

    /**
     * Returns the size of the label's complete text. Note that the text used to
     * make this calculation is the label's full text, regardless of whether the
     * label's text is currently being truncated and is displaying an ellipsis.
     * If the size considering current truncation is desired, call
     * {@link #getSubStringTextSize()}.
     *
     * @return the size of this label's complete text
     * @since 2.0
     */
    @objid ("0c5a1a49-925e-4257-8ccd-7808b62c999a")
    protected Dimension getTextSize() {
        if (this.textSize == null) {
            this.textSize = calculateTextSize();
        }
        return this.textSize;
    }

    /**
     * Gets the string that will be appended to the text when the label is
     * truncated. By default, this returns an ellipsis.
     *
     * @return the string to append to the text when truncated
     * @since 3.4
     */
    @objid ("41e443a7-4c17-455b-b49d-afba43ce5de1")
    protected String getTruncationString() {
        return LabelumFigure.ELLIPSIS;
    }

    @objid ("72d242bb-a7cc-4df9-a406-bf1a49980f6e")
    @Override
    protected void paintFigure(final Graphics graphics) {
        graphics.setTextAntialias(SWT.ON);

        if (isOpaque()) {
            super.paintFigure(graphics);
        }

        Rectangle lbounds = getBounds();
        graphics.translate(lbounds.x, lbounds.y);

        final Rectangle innerRect = getInnerRectangle();

        if (this.orientation != 0) {
            if (LabelumFigure.DEBUG) {
                graphics.setAlpha(40);
                graphics.drawRectangle(1, 0, lbounds.width() - 1, lbounds.height() - 1);
                graphics.setAlpha(255);
            }

            graphics.pushState();
            graphics.translate((float) innerRect.preciseX(), (float) innerRect.preciseY());
            graphics.rotate(-this.orientation);
            if (LabelumFigure.DEBUG) {
                graphics.setAlpha(40);
                graphics.drawRectangle(0, 0, innerRect.width(), innerRect.height());
                graphics.setAlpha(255);
            }
        }

        try {

            if (this.icon != null) {
                graphics.setInterpolation(SWT.HIGH);
                graphics.drawImage(this.icon, getIconLocation());
            }

            final Point lTextLocation = getTextLocation();

            Dimension toDrawSize = getSubStringTextSize();
            String toDrawText = getSubStringText();

            if (toDrawText.isEmpty())
                return;

            if (LabelumFigure.DEBUG) {
                graphics.setAlpha(140);
                graphics.drawRectangle(lTextLocation.x(), lTextLocation.y(), toDrawSize.width(), toDrawSize.height());
                graphics.setAlpha(255);
            }

            translateGraphics(graphics, lTextLocation.preciseX(), lTextLocation.preciseY());

            if (LabelumFigure.DEBUG) {
                graphics.setAlpha(100);
                graphics.drawRectangle(0, 0, toDrawSize.width(), toDrawSize.height());
                graphics.setAlpha(255);
            }

            TextLayout tl = getTextDrawer(toDrawText, calculateAvailableTextSize(innerRect.getSize()).width());

            // workaround draw2d resource leak in ScaledGraphics.zoomTextLayout when width < -1 or width == 0
            int relWidth = tl.getWidth();
            if (relWidth < -1 || relWidth == 0)
                return;

            double absWidth = graphics.getAbsoluteScale() * relWidth;
            if (absWidth < 1.0)
                return;

            if (!isEnabled()) {
                translateGraphics(graphics, 1, 1);
                graphics.setForegroundColor(ColorConstants.buttonLightest);

                graphics.drawTextLayout(tl, 0, 0);

                translateGraphics(graphics, -1, -1);
                graphics.setForegroundColor(ColorConstants.buttonDarker);
            }

            graphics.drawTextLayout(tl, 0, 0);

        } finally {
            if (this.orientation != 0) {
                graphics.popState();
            }
        }
    }

    @objid ("f5c789b5-7a76-4091-8168-297a1d0eb51c")
    private void alignOnHeight(Point loc, Dimension size, int alignment) {
        Rectangle ref = getInnerRectangle();
        Insets insets = getInsets();
        switch (alignment) {
        case TOP:
            loc.y = insets.top;
            break;
        case BOTTOM:
            loc.y = ref.height - size.height - insets.bottom;
            break;
        default:
            loc.y = (ref.height - size.height) / 2;
        }
    }

    @objid ("41bea393-52d8-4eb0-8ac5-77dde0e502f4")
    private void alignOnWidth(Point loc, Dimension size, int alignment) {
        Rectangle ref = getInnerRectangle();
        Insets insets = getInsets();
        switch (alignment) {
        case LEFT:
            loc.x = insets.left;
            break;
        case RIGHT:
            loc.x = ref.width - size.width - insets.right;
            break;
        default:
            loc.x = (ref.width - size.width) / 2;
        }
    }

    @objid ("4d381d56-4625-4279-bccf-8eee84e79170")
    private void calculateAlignment() {
        switch (this.textPlacement) {
        case EAST:
        case WEST:
            alignOnHeight(this.textLocation, getSubStringTextSize(), this.textAlignment);
            alignOnHeight(this.iconLocation, getIconSize(), this.iconAlignment);
            break;
        case NORTH:
        case SOUTH:
        default:
            alignOnWidth(this.textLocation, getSubStringTextSize(), this.textAlignment);
            alignOnWidth(this.iconLocation, getIconSize(), this.iconAlignment);
            break;
        }
    }

    @objid ("31b700fc-fef1-4a50-b17e-8ea292c8a0dc")
    private void calculateLocations() {
        this.textLocation = new PrecisionPoint();
        this.iconLocation = new PrecisionPoint();

        calculatePlacement();
        calculateAlignment();

        Dimension offset = preciseSize(getInnerRectangle()).getShrinked(getSubStringTextSize());
        switch (this.labelAlignment) {
        case CENTER:
            offset.scale(0.5);
            break;
        case LEFT:
        case PositionConstants.LEFT + PositionConstants.RIGHT:
            offset.scale(0.0);
            break;
        case RIGHT:
            offset.scale(1.0);
            break;
        case TOP:
            offset.setHeight(0);
            offset.scale(0.5);
            break;
        case BOTTOM:
            // offset.height = offset.height * 2;
            offset.scale(0.5, 1);
            break;
        default:
            offset.scale(0.5f);
            break;
        }

        switch (this.textPlacement) {
        case EAST:
        case WEST:
            offset.setHeight(0);
            break;
        case NORTH:
        case SOUTH:
        default:
            offset.setWidth(0);
            break;
        }

        this.textLocation.translate(offset);
        this.iconLocation.translate(offset);
    }

    /**
     * Calculate the max size of a rectangle inside the given rectangle size rotated by the labelum angle .
     * <p>
     *
     * @param w rectangle width
     * @param h rectangle height
     * @return the inner rotated rectangle dimension
     */
    @objid ("c585f314-1c81-4bbd-846c-8a2901e7714a")
    private PrecisionDimension calculateMaxRotatedRectangleSize(int w, int h) {
        if (this.orientation == 0 || this.orientation == 180) {
            // Horizontal
            return new PrecisionDimension(w, h);
        } else if (this.orientation == 90 || this.orientation == 270) {
            // Vertical
            return new PrecisionDimension(h, w);
        } else {
            return guessLargestRotatedTextSize(this.orientation, w, h);
        }
    }

    @objid ("e0c3d42d-0cf7-4fc1-93bf-e74c1c510784")
    private void calculatePlacement() {
        int gap = getIconTextGap();
        if (this.icon == null || this.text.equals("")) {
            gap = 0;
        }
        Insets insets = getInsets();

        switch (this.textPlacement) {
        case EAST:
            this.iconLocation.x = insets.left;
            this.textLocation.x = getIconSize().width + gap + insets.left;
            break;
        case WEST:
            this.textLocation.x = insets.left;
            this.iconLocation.x = getSubStringTextSize().width + gap + insets.left;
            break;
        case NORTH:
            this.textLocation.y = insets.top;
            this.iconLocation.y = getTextSize().height + gap + insets.top;
            break;
        default:
        case SOUTH:
            this.textLocation.y = getIconSize().height + gap + insets.top;
            this.iconLocation.y = insets.top;
        }
    }

    /**
     * Compute the size of the a rectangle after rotation.
     *
     * @param d the initial size.
     * @param target the dimension in which the bounds size of the rotated rectangle will be computed.
     * @return the bounds of the rotated dimension : target for convenience.
     */
    @objid ("6170b357-e731-4c63-b523-e2b78abf6371")
    private Dimension calculateRotatedRectangleBounds(Dimension d, Dimension target) {
        if (this.orientation == 0 || this.orientation == 180) {
            target.setSize(d);
        } else if (this.orientation == 90 || this.orientation == -90) {
            target.setSize(d);
            target.transpose();
        } else {
            // http://stackoverflow.com/questions/3231176/how-to-get-size-of-a-rotated-rectangle/3234405#3234405
            double rad = Math.toRadians(this.orientation);
            double cos = Math.cos(rad);
            double sin = Math.sin(rad);

            double a = Math.abs(d.width * cos) + Math.abs(d.height * sin);
            double b = Math.abs(d.width * sin) + Math.abs(d.height * cos);

            target.setSize((int) Math.ceil(a), (int) Math.ceil(b));
        }
        return target;
    }

    @objid ("38599097-e729-417a-8ac3-0a95631208cc")
    private void clearLocations() {
        this.iconLocation = this.textLocation = null;
    }

    /**
     * Guess the ideal text width for the given dimensions.
     *
     * @param angle the rotation angle in degrees
     * @param origWidth the constrained width.
     * @param origHeight the constrained height
     * @return the best text size.
     */
    @objid ("ff7a6c28-c97e-40c5-b0ee-59b5161336cb")
    private PrecisionDimension guessLargestRotatedTextSize(double angle, int origWidth, int origHeight) {
        org.eclipse.swt.graphics.Rectangle swtbounds = getTextDrawer(getText(), -1).getBounds();
        PrecisionDimension ret = new PrecisionDimension(swtbounds.width, swtbounds.height);

        int limitWidth = origWidth;
        boolean vertical = false;

        int quarter = (int) ((angle + 45) / 90);
        if (quarter == 1 || quarter == 3) {
            limitWidth = origHeight;
            vertical = true;
        }

        Dimension cbounds = calculateRotatedRectangleBounds(ret, new Dimension());
        if (limitWidth == -1 || cbounds.width() < limitWidth) {
            // inside constraints
            return ret;
        }

        int wrapCur = swtbounds.width;
        int wrapHigh = wrapCur;
        int wrapLow = 0;
        Dimension wrapDim = new Dimension(-1, -1);

        while (wrapHigh - wrapLow > 2) {
            wrapCur = (wrapHigh + wrapLow) / 2;
            wrapDim.setWidth(wrapCur);

            String formatedText = getTextLayouter().formatText(this, getText(), wrapDim);
            swtbounds = getTextDrawer(formatedText, wrapDim.width()).getBounds();
            ret.setSize(swtbounds.width, swtbounds.height);
            cbounds = calculateRotatedRectangleBounds(ret, cbounds);

            if (cbounds.width() > limitWidth) {
                // outside constraints
                wrapHigh = wrapCur;
            } else if (cbounds.width() < limitWidth) {
                // inside constraints
                wrapLow = wrapCur;
            } else {
                // On the constraint, probably the better size
                return ret;
            }
        }

        // Crop the other side to other limits
        if (!vertical) {
            // the text is horizontal
            if (origHeight != -1 && cbounds.height() > origHeight) {
                double sin = Math.sin(Math.toRadians(angle));
                double cos = Math.cos(Math.toRadians(angle));
                ret.height = (int) ((origHeight - (ret.width * sin)) / cos);
            }
        } else {
            // the text is vertical
            if (origWidth != -1 && cbounds.width() > origWidth) {
                double sin = Math.sin(Math.toRadians(angle));
                double cos = Math.cos(Math.toRadians(angle));
                ret.width = (int) ((origWidth - (ret.height * sin)) / cos);
            }
        }
        return ret;
    }

    @objid ("e2d8e320-5c36-4dd8-82e6-6fb1ce72e2b4")
    private void init() {
        setLayoutManager(new LM());
    }

    @objid ("73000d2b-3792-45cd-b008-e00ffaac6c4c")
    private static PrecisionDimension preciseSize(PrecisionRectangle r) {
        return new PrecisionDimension(r.preciseWidth(), r.preciseHeight());
    }

    /**
     * Sets the label's icon size to the passed Dimension.
     *
     * @param d the new icon size
     */
    @objid ("6721a361-eb66-4d74-b0a3-1ba93a21efdb")
    private void setIconDimension(Dimension d) {
        if (d.equals(getIconSize())) {
            return;
        }
        this.iconSize = d;
        revalidate();
    }

    /**
     * Wrapper aroung {@link Graphics#translate(float, float)} that ignores
     * thrown {@link NullPointerException} because of GEF bug.
     *
     * @param graphics the Graphics to translate
     * @param x the horizontal offset
     * @param y the vertical offset
     * @see Graphics#translate(float, float)
     */
    @objid ("3f985b29-5b2b-44cd-bf67-c1538a613632")
    private void translateGraphics(final Graphics graphics, double x, double y) {
        try {
            graphics.translate((float) x, (float) y);
        } catch (NullPointerException e) {
            LinkEditor.LOG.debug(e.toString());
            // Ignore draw2d bug because there is no clip:
            // java.lang.NullPointerException
            // at org.eclipse.draw2d.SWTGraphics.checkSharedClipping(SWTGraphics.java:338)
            // at org.eclipse.draw2d.SWTGraphics.translate(SWTGraphics.java:1349)
            // at org.eclipse.draw2d.ScaledGraphics.translate(ScaledGraphics.java:884)
            // at org.modelio.diagram.elements.core.figures.labelum.LabelumFigure.paintFigure(LabelumFigure.java:101)
        }
    }

    /**
     * Custom {@link AbstractHintLayout} layout manager.
     */
    @objid ("9d86c1e1-f67b-4aa3-ad55-456b78b5fd0a")
    protected static class LM extends AbstractHintLayout {
        @objid ("bfbff3ea-a5dd-4574-9887-745d80be4f1e")
        @Override
        public void layout(IFigure container) {
            // nothing to do
        }

        @objid ("c71602e5-6664-48f5-a5fc-bfaa572e906b")
        @Override
        protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
            return ((LabelumFigure) container).calculatePreferredSize(wHint, hHint);
        }

        @objid ("19208413-d075-4506-814e-a31ad6ee746f")
        @Override
        protected Dimension calculateMinimumSize(IFigure container, int wHint, int hHint) {
            return ((LabelumFigure) container).calculateMinimumSize(wHint, hHint);
        }

    }

}
