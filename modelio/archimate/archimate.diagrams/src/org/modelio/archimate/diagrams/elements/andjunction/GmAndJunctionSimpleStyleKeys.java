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
package org.modelio.archimate.diagrams.elements.andjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmAndJunction when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("1984859a-6af3-4c6f-9f36-1fce20695ae2")
public class GmAndJunctionSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    /**
     * Fill color
     */
    @objid ("529831b4-8e25-4974-9b7e-e56aaf4b15d1")
    static final StyleKey FILLCOLOR = createStyleKey("ANDJUNCTION_FILLCOLOR", MetaKey.FILLCOLOR);

    /**
     * Fill mode
     */
    @objid ("5734a440-a0f4-4865-831e-bb8c13cc0ea3")
    static final StyleKey FILLMODE = createStyleKey("ANDJUNCTION_FILLMODE", MetaKey.FILLMODE);

    /**
     * Line width
     */
    @objid ("693ad7bc-2187-4569-a289-1d54455cd17b")
    static final StyleKey LINEWIDTH = createStyleKey("ANDJUNCTION_LINEWIDTH", MetaKey.LINEWIDTH);

    /**
     * Text font
     */
    @objid ("1811e811-41e4-4742-b09d-2b0a4ab221b7")
    static final StyleKey FONT = createStyleKey("ANDJUNCTION_FONT", MetaKey.FONT);

    /**
     * Text color
     */
    @objid ("59570f21-9926-4033-9c45-61ef0f9ff6f9")
    static final StyleKey TEXTCOLOR = createStyleKey("ANDJUNCTION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    /**
     * Show stereotypes
     */
    @objid ("cd6734f6-bdfc-4ed2-8127-fb04dc3a21bd")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ANDJUNCTION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    /**
     * Show tagged values
     */
    @objid ("d3df15bc-9cb0-4391-8a2f-ab0f41b49d56")
    static final StyleKey SHOWTAGS = createStyleKey("ANDJUNCTION_SHOWTAGS", MetaKey.SHOWTAGS);

    /**
     * Show the element name label.
     */
    @objid ("c3bdc4d0-a010-48f5-b3d0-36d485972bc3")
    static final StyleKey SHOWLABEL = createStyleKey("ANDJUNCTION_SHOWLABEL", MetaKey.SHOWLABEL);

}
