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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.elements.common.abstractdiagram.GmAbstractDiagramStyleKeys;
import org.modelio.diagram.elements.common.abstractdiagram.LayoutAssistantStyleKeys;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a {@link GmViewPointDiagram} when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("9164121f-174f-4994-a326-a8edc1405e29")
public class GmViewPointDiagramStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Enable Auto Layout.
     */
    @objid ("1c92417e-9e04-43c3-9d78-4c42389bb8f7")
    static final StyleKey AUTOLAYOUT = createStyleKey("VIEW_POINT_DIAGRAM_AUTOLAYOUT", Boolean.class);

    /**
     * Number of columns in auto layout model.
     */
    @objid ("a2089ff7-4052-459f-9dde-fa1261ba8404")
    static final StyleKey LAYOUTCOLUNMS = createStyleKey("VIEW_POINT_DIAGRAM_LAYOUTCOLUNMS", Integer.class);

    /**
     * Snap to geometry.
     */
    @objid ("7e7a9bff-3cb3-4f5c-a1c7-a7c43bc2828e")
    static final StyleKey SNAPTOGEOMETRY = GmAbstractDiagramStyleKeys.SNAPTOGEOMETRY;

    /**
     * Diagram background color.
     */
    @objid ("e09e8c41-bd24-412c-8ae0-906e82be76b7")
    public static final StyleKey FILLCOLOR = GmAbstractDiagramStyleKeys.FILLCOLOR;

    /**
     * View grid.
     */
    @objid ("314b026c-687b-4ee6-94ea-2e937d7d7282")
    public static final StyleKey VIEWGRID = GmAbstractDiagramStyleKeys.VIEWGRID;

    /**
     * Activate snap to grid.
     */
    @objid ("2d553c5f-2834-46fc-ba92-840dacedaa56")
    public static final StyleKey SNAPTOGRID = GmAbstractDiagramStyleKeys.SNAPTOGRID;

    /**
     * Grid spacing in pixels.
     */
    @objid ("8c52df31-51ec-451e-85bd-9b7a32e91b67")
    public static final StyleKey GRIDSPACING = GmAbstractDiagramStyleKeys.GRIDSPACING;

    /**
     * Anchor spacing in pixel
     */
    @objid ("2b79d2e9-14d1-4755-b6c4-5bd9448e0312")
    public static final StyleKey ANCHORSPACING = GmAbstractDiagramStyleKeys.ANCHORSPACING;

    /**
     * Grid color.
     */
    @objid ("f5fa1c3f-c0d4-4bed-a8d0-4ac14d520c33")
    public static final StyleKey GRIDCOLOR = GmAbstractDiagramStyleKeys.GRIDCOLOR;

    /**
     * Grid transparency: Integer value from 0 (full transaprency) to 255 (no transparency)
     */
    @objid ("ec59009b-6e56-40c6-89b5-0dc85f78dfae")
    public static final StyleKey GRIDALPHA = GmAbstractDiagramStyleKeys.GRIDALPHA;

    /**
     * Diagram background image.
     */
    @objid ("4363c156-0b26-44ed-9511-c5998bad4316")
    public static final StyleKey FILLIMAGE = GmAbstractDiagramStyleKeys.FILLIMAGE;

    /**
     * Diagram image transparency. This StyleKey defines the fill transparency. The value applies to both the fill image and the fill color. Integer value from 0 (full transparency) to 255 (no transparency)
     */
    @objid ("c8b5920b-2caa-44b7-a209-a9381d5fd815")
    public static final StyleKey FILLALPHA = GmAbstractDiagramStyleKeys.FILLALPHA;

    /**
     * This StyleKey defines the page boundaries lines visibility. Boolean value.
     */
    @objid ("008958bc-cba9-42b1-ac09-35eb32445a47")
    public static final StyleKey SHOW_PAGES = GmAbstractDiagramStyleKeys.SHOW_PAGES;

    /**
     * This StyleKey defines the page size. String value. Supported string format:
     * <li>discrete values: A5H,A4H,A3H,A2H,A1H,A0H, A5V,A4V,A3V,A2V,A1V,A0V
     * <li>inches values: '8.5" x 3.4"'
     * <li>mm values: '210 mm x 297 mm'
     */
    @objid ("22929e3d-bcaf-4455-824d-80612b7082b0")
    public static final StyleKey PAGE_SIZE = GmAbstractDiagramStyleKeys.PAGE_SIZE;

    @objid ("c010714c-f2cb-4dca-8044-7b019f5ef90a")
    static final LayoutAssistantStyleKeys autoLayoutStyle = GmAbstractDiagramStyleKeys.autoLayoutStyle;

    @objid ("43a5d695-688c-4e24-abfc-303754681d7f")
    static final StyleKey ELEMENTSIZE = createStyleKey("VIEW_POINT_DIAGRAM_ELEMENTSIZE", ElementSize.class);

    @objid ("4424263a-2b24-4a41-9a0e-97738cd36eda")
    public enum ElementSize {
        @objid ("1dae3a50-2e28-4213-8f9c-8c309f6440c4")
        SMALL,
        @objid ("e8193046-e081-406f-a902-cc26f29dc499")
        MEDIUM,
        @objid ("659056dc-a5c2-452a-8ecd-4f0432aced2c")
        LARGE;

    }

}
