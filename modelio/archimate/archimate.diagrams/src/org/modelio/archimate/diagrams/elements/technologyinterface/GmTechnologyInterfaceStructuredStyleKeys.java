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
package org.modelio.archimate.diagrams.elements.technologyinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyInterface when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("57cef351-bbf8-49b4-8a6e-91b2caefbcc7")
public class GmTechnologyInterfaceStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("b948211f-f0fc-4c24-bfd2-4e9b9c8395d4")
    static final StyleKey REPMODE = createStyleKey("TECHNOLOGYINTERFACE_REPMODE", MetaKey.REPMODE);

    @objid ("6e2f29cc-eb74-43ba-b54c-d7e036e53e6d")
    static final StyleKey FILLCOLOR = createStyleKey("TECHNOLOGYINTERFACE_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ee326e84-2961-49a4-aec6-fe3b6b7339d3")
    static final StyleKey FILLMODE = createStyleKey("TECHNOLOGYINTERFACE_FILLMODE", MetaKey.FILLMODE);

    @objid ("b1d9505a-4f0c-4edc-912d-b965dd99ec06")
    static final StyleKey LINECOLOR = createStyleKey("TECHNOLOGYINTERFACE_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("2151dad7-3864-4557-b4c1-171cac1d7d31")
    static final StyleKey LINEWIDTH = createStyleKey("TECHNOLOGYINTERFACE_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("1729d347-3c3e-4e17-a846-38c8f1907620")
    static final StyleKey FONT = createStyleKey("TECHNOLOGYINTERFACE_FONT", MetaKey.FONT);

    @objid ("7046de0a-22ca-4f83-b0bf-0d9288bd955f")
    static final StyleKey TEXTCOLOR = createStyleKey("TECHNOLOGYINTERFACE_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b9accc9f-6fe2-47b6-994b-a591fb02ed09")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("TECHNOLOGYINTERFACE_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("c032d75c-6165-4af2-9e07-2a85c1fa937e")
    static final StyleKey SHOWTAGS = createStyleKey("TECHNOLOGYINTERFACE_SHOWTAGS", MetaKey.SHOWTAGS);

}
