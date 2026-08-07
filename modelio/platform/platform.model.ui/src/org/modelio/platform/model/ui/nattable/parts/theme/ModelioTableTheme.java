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
package org.modelio.platform.model.ui.nattable.parts.theme;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.nebula.widgets.nattable.style.BorderStyle;
import org.eclipse.nebula.widgets.nattable.style.HorizontalAlignmentEnum;
import org.eclipse.nebula.widgets.nattable.style.VerticalAlignmentEnum;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.modelio.platform.ui.CoreColorRegistry;
import org.modelio.platform.ui.UIColor;

/**
 * Modelio-specific theme for a NatTable.
 */
@objid ("1c6712d4-cf4b-48d0-b6a9-d6b2ea118b37")
public class ModelioTableTheme {
    @objid ("3c108f3e-80b0-47f1-88be-7c00069318c2")
    public static int DEFAULT_COLUMN_WIDTH = 40;

    @objid ("3ef14841-cce7-42b3-b2a1-4c1402d012d0")
    public static int DEFAULT_ROW_HEIGHT = 24 + 4;

    @objid ("dc978171-0ddf-49e2-a109-8d9f6442d3ca")
    public final HorizontalAlignmentEnum cellHAlign;

    @objid ("6447c016-400a-478e-b35d-44ce69c13a95")
    public final VerticalAlignmentEnum cellVAlign;

    @objid ("9f89746e-267c-4619-af0a-ebcd8e3aadae")
    public final HorizontalAlignmentEnum horizontalColumnHeaderHAlign;

    @objid ("ed1df0af-1d97-40a3-b20f-778636089f60")
    public final VerticalAlignmentEnum horizontalColumnHeaderVAlign;

    @objid ("914dc991-9701-47cb-9e31-ac15f7122242")
    public HorizontalAlignmentEnum rowHeaderHAlign;

    @objid ("bf2a5cdf-b112-48aa-a64b-2aec51b44d30")
    public VerticalAlignmentEnum rowHeaderVAlign;

    @objid ("bb8dc0be-bddc-44da-bb26-08318942759f")
    public final HorizontalAlignmentEnum verticalColumnHeaderHAlign;

    @objid ("041de8c8-526b-46e1-9315-559e0abd9489")
    public final VerticalAlignmentEnum verticalColumnHeaderVAlign;

    @objid ("7e79f7f8-41d7-4e63-a465-6ebb627cddc3")
    public final Color cellBackground;

    // Normal (unselected) cell
    @objid ("7b209333-b806-4a87-945c-799657872b25")
    public final Font cellFont;

    @objid ("8d05fe4b-c85a-4861-92b1-b82f6eccba96")
    public final Color cellForeGround;

    @objid ("72a0daca-f5fd-498e-bbe6-beb39569f01d")
    public final Color evenRowBackground;

    // Normal (unselected) header
    @objid ("677ab7db-d9e4-4857-859d-858cf64dadfa")
    public final Color headerBackground;

    @objid ("81b26c50-7bf7-498a-ab8d-a564624fb8bb")
    public final Font headerFont;

    @objid ("c872c59b-c8f0-487c-87bd-bf981439c5d7")
    public final Color headerForeground;

    @objid ("8718be41-a3ea-455e-8142-0a85cd239e26")
    public final Color headerGradientBackground;

    @objid ("d5ef6910-a872-4d97-8c09-a568f4dd20e9")
    public final Color headerGradientForeground;

    // Alternate row background colors
    @objid ("0c32a8ad-c73a-4c4d-8fb9-531103d52769")
    public final Color oddRowBackground;

    @objid ("69c78ce4-052f-445e-9b14-84fbeba5eeb3")
    public final Color selectedCellBackground;

    @objid ("69b0ebad-042c-40bc-a12a-9c729a08a470")
    public final Font selectedCellFont;

    @objid ("d07682eb-46fc-49c2-8583-eafc2fb6da1e")
    public final Color selectedCellForeground;

    // Selected cell
    @objid ("7de50724-e0c2-47ea-a4b7-e437ecafec79")
    public final Color selectedCellGridlineColor;

    // Selected header
    @objid ("c3c99cc4-1410-4934-b17b-da3ac7002a24")
    public final Color selectedHeaderBackground;

    @objid ("bb0534da-859f-49c9-98d4-b6fed313d1c7")
    public final Font selectedHeaderFont;

    @objid ("13809e0a-7d5f-4e4f-a2fe-e73c12d9690a")
    public final Color selectedHeaderForeground;

    @objid ("1a19ad52-0d85-47ec-880c-15f72aa2f6a7")
    public final Color selectedHeaderGradientBackground;

    @objid ("8b9eaea2-40b1-4d75-8c9e-350956f48780")
    public final Color selectedHeaderGradientForeground;

    @objid ("3db4a469-7384-495b-92da-467a06b44cd1")
    public final Color selectedRowColumnBackground;

    @objid ("784feaa4-ba80-4b29-ba09-b0dfd17e24c8")
    public final Font selectedRowColumnFont;

    @objid ("fc76a00b-9e3b-4c15-b47c-047722d7980a")
    public final Color selectedRowColumnForeground;

    @objid ("e416db22-5c5c-4e88-8489-5f39eede7130")
    public final BorderStyle selectedCellGridBorderStyle;

    @objid ("30a77a1b-ef08-4e3d-82e1-75e8a668e185")
    private static ModelioTableTheme instance = null;

    @objid ("371a6bc6-5477-490b-bd92-86f5f4445541")
    public static ModelioTableTheme getInstance() {
        return new ModelioTableTheme();
    }

    @objid ("d0812a1e-6d57-4527-9b75-03fa76da87d2")
    private ModelioTableTheme() {
        // Use platform theme values where possible
        Color systemSelectionBackground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION);
        Color systemSelectionForeground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);
        Font defaultFont = Display.getCurrent().getSystemFont();

        // Normal (unselected) cell
        this.cellBackground = UIColor.WHITE;
        this.cellForeGround = UIColor.BLACK;
        this.cellFont = defaultFont;
        this.cellHAlign = HorizontalAlignmentEnum.LEFT;
        this.cellVAlign = VerticalAlignmentEnum.TOP;

        // Normal (unselected) header
        this.headerBackground = UIColor.TABLE_HEADER_BG;
        this.headerGradientBackground = this.headerBackground;
        this.headerGradientForeground = CoreColorRegistry.getDerivedColor(UIColor.WHITE, 1.5f);
        this.headerForeground = UIColor.TABLE_HEADER_FG;

        this.headerFont = defaultFont;

        this.verticalColumnHeaderHAlign = HorizontalAlignmentEnum.CENTER;
        this.verticalColumnHeaderVAlign = VerticalAlignmentEnum.MIDDLE;

        this.horizontalColumnHeaderHAlign = HorizontalAlignmentEnum.CENTER;
        this.horizontalColumnHeaderVAlign = VerticalAlignmentEnum.MIDDLE;

        this.rowHeaderHAlign = HorizontalAlignmentEnum.LEFT;
        this.rowHeaderVAlign = VerticalAlignmentEnum.TOP;

        // Alternate row background colors
        this.oddRowBackground = UIColor.TABLE_ODDROW_BG; // CoreColorRegistry.getColor(new
        // RGB(249, 249,
        // 255));
        this.evenRowBackground = UIColor.TABLE_EVENROW_BG; // GUIHelper.COLOR_WHITE;

        // Selected cell
        this.selectedCellGridlineColor = systemSelectionBackground;
        this.selectedCellGridBorderStyle = new BorderStyle(2, this.selectedCellGridlineColor, BorderStyle.LineStyleEnum.SOLID);

        this.selectedCellFont = defaultFont;
        this.selectedCellBackground = this.cellBackground; // systemSelectionBackground;
        this.selectedCellForeground = this.cellForeGround; // systemSelectionForeground;

        this.selectedRowColumnFont = defaultFont;
        this.selectedRowColumnBackground = systemSelectionBackground;
        this.selectedRowColumnForeground = systemSelectionForeground;

        // Selected header
        this.selectedHeaderFont = defaultFont;
        this.selectedHeaderBackground = systemSelectionBackground;
        this.selectedHeaderGradientBackground = this.selectedHeaderBackground;
        this.selectedHeaderGradientForeground = this.selectedHeaderBackground;

        this.selectedHeaderForeground = systemSelectionForeground;
    }

}
