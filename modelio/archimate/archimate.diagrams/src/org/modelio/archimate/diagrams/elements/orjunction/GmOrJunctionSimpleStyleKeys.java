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
package org.modelio.archimate.diagrams.elements.orjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmOrJunction when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("e7ac5d59-2c37-4f69-988d-10d932c5f7b5")
public class GmOrJunctionSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Fill color
     */
    @objid ("9d0d2f3d-d87a-414b-88e8-1a35e6f0843e")
    static final StyleKey FILLCOLOR = createStyleKey("ORJUNCTION_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Fill mode
     */
    @objid ("16ad6364-6aa1-486e-b6cd-338a70cf154d")
    static final StyleKey FILLMODE = createStyleKey("ORJUNCTION_FILLMODE", MetaKey.FILLMODE);

    /**
     * Line color
     */
    @objid ("eb17651c-391d-4b24-9a09-eac15a3caa40")
    static final StyleKey LINECOLOR = createStyleKey("ORJUNCTION_LINECOLOR", MetaKey.LINECOLOR);

    /**
     * Line width
     */
    @objid ("4c146fd1-2e80-4528-bfc2-e26e795d2b8c")
    static final StyleKey LINEWIDTH = createStyleKey("ORJUNCTION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("0707153a-beed-4446-b30d-269e4149fbec")
    static final StyleKey FONT = createStyleKey("ORJUNCTION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("f162690c-8381-4815-9627-941328c51fd9")
    static final StyleKey TEXTCOLOR = createStyleKey("ORJUNCTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("8f4d7cf5-b690-4784-8a73-87577a9f41b4")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ORJUNCTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("744bbaf1-070a-4902-b4bd-bf4079131712")
    static final StyleKey SHOWTAGS = createStyleKey("ORJUNCTION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Show the element name label.
     */
    @objid ("f2ded547-1574-4f1e-8a00-27bf105c7f5b")
    static final StyleKey SHOWLABEL = createStyleKey("ORJUNCTION_SHOWLABEL", MetaKey.SHOWLABEL);

}
