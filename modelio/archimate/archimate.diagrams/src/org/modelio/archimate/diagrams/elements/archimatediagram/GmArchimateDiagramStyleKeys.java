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
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.elements.common.abstractdiagram.GmAbstractDiagramStyleKeys;
import org.modelio.diagram.elements.common.abstractdiagram.LayoutAssistantStyleKeys;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a {@link GmArchimateDiagram} when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("227ff2f8-e8ea-442a-87e6-bd35025cd1ae")
public class GmArchimateDiagramStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Snap to geometry.
     */
    @objid ("47522300-d1b1-479e-b2e5-202f1acd8427")
    static final StyleKey SNAPTOGEOMETRY = GmAbstractDiagramStyleKeys.SNAPTOGEOMETRY;

    /**
     * Diagram background color.
     */
    @objid ("e48c20e5-2850-4684-8520-5defe8d57e75")
    public static final StyleKey FILLCOLOR = GmAbstractDiagramStyleKeys.FILLCOLOR;

    /**
     * View grid.
     */
    @objid ("961b15f4-817a-4df2-a760-c5f26394aac3")
    public static final StyleKey VIEWGRID = GmAbstractDiagramStyleKeys.VIEWGRID;

    /**
     * Activate snap to grid.
     */
    @objid ("c509fef0-d6c6-41d4-a542-2e2af5c2d6f6")
    public static final StyleKey SNAPTOGRID = GmAbstractDiagramStyleKeys.SNAPTOGRID;

    /**
     * Grid spacing in pixels.
     */
    @objid ("06f4ca8e-10f3-4ef9-9fed-71144c051c5c")
    public static final StyleKey GRIDSPACING = GmAbstractDiagramStyleKeys.GRIDSPACING;

    /**
     * Anchor spacing in pixel
     */
    @objid ("3f8c6517-4231-4d41-877d-3bb1458e3946")
    public static final StyleKey ANCHORSPACING = GmAbstractDiagramStyleKeys.ANCHORSPACING;

    /**
     * Grid color.
     */
    @objid ("095fa2b0-0242-4a55-aaaa-1f08babdb708")
    public static final StyleKey GRIDCOLOR = GmAbstractDiagramStyleKeys.GRIDCOLOR;

    /**
     * Grid transparency: Integer value from 0 (full transaprency) to 255 (no transparency)
     */
    @objid ("907feb56-2eaf-4c91-829d-b9f8988e92c6")
    public static final StyleKey GRIDALPHA = GmAbstractDiagramStyleKeys.GRIDALPHA;

    /**
     * Diagram background image.
     */
    @objid ("eab64c94-c59b-440b-91b9-529faed01f50")
    public static final StyleKey FILLIMAGE = GmAbstractDiagramStyleKeys.FILLIMAGE;

    /**
     * Diagram image transparency. This StyleKey defines the fill transparency. The value applies to both the fill image and the fill color. Integer value from 0 (full transparency) to 255 (no transparency)
     */
    @objid ("a626e823-6462-431c-9f3e-748704cf8d05")
    public static final StyleKey FILLALPHA = GmAbstractDiagramStyleKeys.FILLALPHA;

    /**
     * This StyleKey defines the page boundaries lines visibility. Boolean value.
     */
    @objid ("b49a9d98-c339-42d3-a7b9-3ca8f8294e1c")
    public static final StyleKey SHOW_PAGES = GmAbstractDiagramStyleKeys.SHOW_PAGES;

    /**
     * This StyleKey defines the page size. String value. Supported string format:
     * <li>discrete values: A5H,A4H,A3H,A2H,A1H,A0H, A5V,A4V,A3V,A2V,A1V,A0V
     * <li>inches values: '8.5" x 3.4"'
     * <li>mm values: '210 mm x 297 mm'
     */
    @objid ("d8af6b50-f565-42f5-9d62-d220340411c4")
    public static final StyleKey PAGE_SIZE = GmAbstractDiagramStyleKeys.PAGE_SIZE;

    @objid ("e79f4b01-c4f8-4a02-85c9-b182ff5ec165")
    static final LayoutAssistantStyleKeys autoLayoutStyle = GmAbstractDiagramStyleKeys.autoLayoutStyle;

    @objid ("5ae7c846-a180-412d-9449-f46df158ad98")
    static final StyleKey SHOW_SMARTLINK_HANDLE = GmAbstractDiagramStyleKeys.SHOW_SMARTLINK_HANDLE;

}
