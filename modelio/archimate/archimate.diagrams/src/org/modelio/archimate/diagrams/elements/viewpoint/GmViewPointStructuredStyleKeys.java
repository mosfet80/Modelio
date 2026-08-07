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
package org.modelio.archimate.diagrams.elements.viewpoint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmViewPoint when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("2498e524-27e7-4d1a-8af6-19257afb735f")
public class GmViewPointStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d20f0c5e-9748-4c97-8828-1fb6121de93e")
    static final StyleKey FILLCOLOR = createStyleKey("VIEWPOINT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("3da68b04-ef6c-4925-aeb4-4332dc301838")
    static final StyleKey FILLMODE = createStyleKey("VIEWPOINT_FILLMODE", MetaKey.FILLMODE);

    @objid ("1c36eb79-cc24-4904-a2af-6232aeb41691")
    static final StyleKey LINECOLOR = createStyleKey("VIEWPOINT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("e9972d23-c779-4c27-846d-fac8d6a58c8e")
    static final StyleKey LINEWIDTH = createStyleKey("VIEWPOINT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("c379bead-894a-4b95-ba61-c6ab53e95208")
    static final StyleKey FONT = createStyleKey("VIEWPOINT_FONT", MetaKey.FONT);

    @objid ("7f1208d7-45d4-48ac-8c36-4e0bdf2bc2b7")
    static final StyleKey TEXTCOLOR = createStyleKey("VIEWPOINT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("719051f9-f867-49d7-8390-d6d403af69b4")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("VIEWPOINT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("9af668b2-fd6e-48cf-9c13-11a9adfeb24e")
    static final StyleKey SHOWTAGS = createStyleKey("VIEWPOINT_SHOWTAGS", MetaKey.SHOWTAGS);

}
