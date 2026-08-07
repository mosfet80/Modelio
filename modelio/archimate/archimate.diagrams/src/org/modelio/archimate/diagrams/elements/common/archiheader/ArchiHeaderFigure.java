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
package org.modelio.archimate.diagrams.elements.common.archiheader;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.modelio.diagram.elements.common.header.IHeaderFigure;
import org.modelio.diagram.elements.core.figures.FigureUtilities2;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.figures.ToolbarRLayout;
import org.modelio.diagram.elements.core.figures.labelum.LabelumFigure;
import org.modelio.platform.ui.CoreFontRegistry;

/**
 * The ArchiHeader features:
 * <ul>
 * <li>a top label as a labelum, visible if non empty. See {@link ArchiHeaderFigure#setTopLabel(String)}</li>
 * <li>a main label as a labelum always visible. See {@link ArchiHeaderFigure#setMainLabel(String)}</li>
 * <li>a bottom label as a labelum visible if non empty. See {@link ArchiHeaderFigure#setBottomLabel(String)}</li>
 * <li>a left icon area (horizontal layout) visible is not empty. See {@link ArchiHeaderFigure#setLeftIcons(List)}</li>
 * <li>a right icon area (horizontal layout) visible is not empty. See {@link ArchiHeaderFigure#setRightIcons(List)}</li>
 * <li>two different layout modes that can be swapped at any moment. See {@link ArchiHeaderFigure#setWideMode(boolean)}</li>
 * </ul>
 */
@objid ("a648af59-7da4-46e8-a4bb-5e6727abbd74")
public class ArchiHeaderFigure extends GradientFigure implements IHeaderFigure {
    @objid ("b7b8656d-c475-451c-ac53-b0cc029c8bc0")
    private Font bottomLabelFont;

    @objid ("f6691588-d840-4613-b2e3-6f3909fafcd1")
    private Figure centerArea;

    @objid ("58880fc5-14e8-4dca-b278-e30fbb3e6290")
    private Figure leftIconsArea;

    @objid ("68ab5ceb-9d4a-4026-ba1b-5b7f363c311c")
    private Figure rightIconsArea;

    @objid ("dba496f5-e331-4351-9e2a-c76a92624c92")
    private Font topLabelFont;

    @objid ("aa8d5396-8483-456e-9156-a03990d96425")
    private LabelumFigure bottomLabel;

    @objid ("b31e65fa-5356-4cb1-bdc5-525ce39ad8ce")
    private LabelumFigure centerLabel;

    @objid ("1491ebf3-5fb5-457c-9175-244ff7183720")
    private LabelumFigure topLabel;

    /**
     * The header figure is a 'BorderLayout' container. Children layout: Children are transparent without borders
     */
    @objid ("4be73661-0c6b-4782-9415-7e14cf36169e")
    public ArchiHeaderFigure() {
        setLayoutManager(new BorderLayout());

        // The top label
        this.topLabel = new LabelumFigure();
        this.topLabel.setLabelAlignment(PositionConstants.CENTER);
        this.topLabel.setBorder(new MarginBorder(1, 2, 1, 2));

        // The main label
        this.centerLabel = new LabelumFigure();
        this.centerLabel.setLabelAlignment(PositionConstants.CENTER);
        this.centerLabel.setBorder(new MarginBorder(2, 1, 2, 1));

        // The bottom label
        this.bottomLabel = new LabelumFigure();
        this.bottomLabel.setLabelAlignment(PositionConstants.CENTER);
        this.bottomLabel.setBorder(new MarginBorder(1, 2, 1, 2));

        this.leftIconsArea = new Figure();
        ToolbarLayout tbLayout = new ToolbarLayout(true);
        tbLayout.setMinorAlignment(OrderedLayout.ALIGN_TOPLEFT);
        tbLayout.setSpacing(1);
        this.leftIconsArea.setLayoutManager(tbLayout);
        this.leftIconsArea.setOpaque(false);

        this.rightIconsArea = new Figure();
        ToolbarLayout tbRLayout = new ToolbarRLayout();
        tbRLayout.setVertical(true);
        tbRLayout.setSpacing(2);
        this.rightIconsArea.setLayoutManager(tbRLayout);
        this.rightIconsArea.setOpaque(false);
        this.rightIconsArea.setBorder(new MarginBorder(0, 1, 0, 1));

        standardlayout();
    }

    @objid ("94cf1ee8-32a5-4ae6-ae24-222dc5342d9c")
    @Override
    public LabelumFigure getMainLabelFigure() {
        return this.centerLabel;
    }

    @objid ("2624c283-1205-4f27-bd6d-54ef1dcf4b65")
    @Override
    public Color getTextColor() {
        return this.centerLabel.getForegroundColor();
    }

    @objid ("4f858391-b608-4f17-a860-1cc7bc3792a5")
    @Override
    public Font getTextFont() {
        return this.centerLabel.getFont();
    }

    @objid ("0b7ea48d-9d55-4f31-884d-bc46b2860301")
    @Override
    public boolean isWrapped() {
        return false;
    }

    @objid ("b9c38a07-d914-4857-93df-909221bca42f")
    @Override
    public void setBottomLabel(String text) {
        if (text == null || text.isEmpty()) {
            this.bottomLabel.setVisible(false);
        } else {
            this.bottomLabel.setVisible(true);
            this.bottomLabel.setText(text);
        }
    }

    @objid ("53cbf3f2-6079-4bec-98af-e84b2bac7a0c")
    @Override
    public void setKeywordLabel(String text) {
        if (text == null || text.isEmpty()) {
            this.topLabel.setVisible(false);
        } else {
            this.topLabel.setText(text);
            this.topLabel.setVisible(true);
        }
    }

    /**
     * Set the icons displayed on the upper left corner.
     *
     * @param icons The left icons
     */
    @objid ("42ffc73d-3797-4e59-bb4e-b61c980f0e4a")
    @Override
    public void setLeftIcons(List<Image> icons) {
        // remove existing labels
        this.leftIconsArea.removeAll();
        // add new image figures
        for (Image img : icons) {
            ImageFigure imgFigure = new ImageFigure(img);
            this.leftIconsArea.add(imgFigure);
        }
        this.leftIconsArea.setVisible(!icons.isEmpty());
    }

    @objid ("5f952980-e8c8-467f-8dec-7478a112e444")
    @Override
    public void setMainLabel(String s) {
        this.centerLabel.setText(s);
        revalidate();
    }

    /**
     * Set the icons displayed on the upper right corner.
     *
     * @param icons The right icons
     */
    @objid ("c4c22248-bceb-4532-9a42-94af621da3ef")
    @Override
    public void setRightIcons(List<Image> icons) {
        // remove existing labels
        this.rightIconsArea.removeAll();
        // add new image figures
        for (Image img : icons) {
            ImageFigure imgFigure = new ImageFigure(img);
            this.rightIconsArea.add(imgFigure);
        }
        this.rightIconsArea.setVisible(!icons.isEmpty());
    }

    @objid ("67b26713-13cf-40c3-b083-82d53863edd0")
    @Override
    public void setStrikeThrough(boolean strikeThrough) {
        this.centerLabel.setStrikeThrough(strikeThrough);
    }

    @objid ("d7517bf0-c7e7-4101-a26a-55b195fcfb3a")
    @Override
    public void setTextColor(Color textColor) {
        this.topLabel.setTextColor(textColor);
        this.centerLabel.setTextColor(textColor);
        this.bottomLabel.setTextColor(textColor);
    }

    @objid ("6c2f1f3a-2d82-421a-9423-0d23ff372eaa")
    @Override
    public void setTextFont(Font textFont) {
        updateDerivedFonts(textFont);
        this.topLabel.setTextFont(this.topLabelFont);
        this.centerLabel.setTextFont(textFont);
        this.bottomLabel.setTextFont(this.bottomLabelFont);
    }

    @objid ("3d341951-cbbf-4f85-9e11-cfe0b9f59c06")
    @Override
    public void setTopLabel(String text) {
        if (text == null || text.isEmpty()) {
            this.topLabel.setVisible(false);
        } else {
            this.topLabel.setVisible(true);
            this.topLabel.setText(text);
        }
    }

    @objid ("b17595c2-7a1f-421e-832d-8ea67d04b346")
    @Override
    public void setUnderline(boolean underline) {
        this.centerLabel.setUnderline(underline);
    }

    /**
     * Wrapping change not supported, do nothing.
     */
    @objid ("cbb72a2e-86a0-4541-a037-9e9a3a39e4e3")
    @Override
    public boolean setWrapped(boolean val) {
        return false;
    }

    @objid ("3927a6d1-f873-4ff8-9cab-152844239443")
    private void updateDerivedFonts(Font baseFont) {
        if (this.centerLabel.getFont() == baseFont && this.bottomLabelFont != null && this.topLabelFont != null) {
            return;
        }

        this.topLabelFont = FigureUtilities2.getSmallerFont(baseFont);
        this.bottomLabelFont = CoreFontRegistry.getModifiedFont(this.topLabelFont, SWT.ITALIC, 1);
    }

    /**
     * [AI generated] Set the layout mode of the header figure.
     * <p>
     * Changes the header layout between standard mode and wide mode:
     * <ul>
     * <li>When wide mode is on (true), places the icons and top label in a horizontal
     * arrangement at the top, with center and bottom labels stacked below.</li>
     * <li>When wide mode is off (false), creates a standard layout with icons on the sides
     * and all three labels stacked in the center.</li>
     * </ul>
     *
     * @param onOff true to enable wide layout mode, false for standard layout mode
     * @AiGeneratedJavadoc
     */
    @objid ("34cc328a-9034-4fde-bf19-bbf90a9675a8")
    public void setWideMode(boolean onOff) {
        if (onOff)
            wideLayout();
        else
            standardlayout();
    }

    /**
     * Creates a wide layout for the header figure.
     * <p>
     * This layout places:
     * <ul>
     * <li>Left icons, top label, and right icons in a horizontal arrangement at the top</li>
     * <li>The center label in the middle</li>
     * <li>The bottom label at the bottom</li>
     * </ul>
     * This arrangement is used when the archimate node has children.
     * @AiGeneratedJavadoc
     */
    @objid ("6fa04aa5-cd33-4753-b91a-26ad67da2214")
    private void wideLayout() {
        this.removeAll();

        this.add(this.leftIconsArea, BorderLayout.LEFT);
        this.add(this.rightIconsArea, BorderLayout.RIGHT);

        Figure area = new Figure();
        area.setLayoutManager(new BorderLayout());
        this.add(area, BorderLayout.CENTER);

        area.add(this.centerLabel , BorderLayout.TOP);
        area.add(this.topLabel, BorderLayout.CENTER);
        area.add(this.bottomLabel, BorderLayout.BOTTOM);
    }

    /**
     * Creates a standard layout for the header figure.
     * <p>
     * This layout places:
     * <ul>
     * <li>Left icons area on the left side</li>
     * <li>Right icons area on the right side</li>
     * <li>A center area containing all three labels stacked vertically:
     * <ul>
     * <li>Top label at the top</li>
     * <li>Center label in the middle</li>
     * <li>Bottom label at the bottom</li>
     * </ul>
     * </li>
     * </ul>
     * This is the default layout arrangement for the header figure.
     * @AiGeneratedJavadoc
     */
    @objid ("a9d23ed3-036b-46b6-b44a-e9f6051712fa")
    private void standardlayout() {
        this.removeAll();

        this.add(this.leftIconsArea, BorderLayout.LEFT);
        this.add(this.rightIconsArea, BorderLayout.RIGHT);

        Figure area = new Figure();
        area.setLayoutManager(new BorderLayout());
        this.add(area, BorderLayout.CENTER);

        area.add(this.centerLabel , BorderLayout.TOP);
        area.add(this.topLabel, BorderLayout.CENTER);
        area.add(this.bottomLabel, BorderLayout.BOTTOM);
    }

}
