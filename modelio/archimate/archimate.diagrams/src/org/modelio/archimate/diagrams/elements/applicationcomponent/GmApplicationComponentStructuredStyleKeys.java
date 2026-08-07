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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationComponent when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("8dbdf5fb-eeb1-40d7-ae27-2879aab97de6")
public class GmApplicationComponentStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("72ca7dbc-6095-4e79-9820-862babd221d3")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONCOMPONENT_REPMODE", MetaKey.REPMODE);

    @objid ("80f7dc98-e9bf-4052-9970-598db74d25ff")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONCOMPONENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("76c1bf91-9809-49fe-9f48-d028fa661c24")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONCOMPONENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("5d0b7a25-e813-47f5-a38c-16934b718a5d")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONCOMPONENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("8c7d5c63-50fd-46a4-8042-f948b3ee8b01")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONCOMPONENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("de5fa0a6-436b-4fc9-82de-471e90ff94a0")
    static final StyleKey FONT = createStyleKey("APPLICATIONCOMPONENT_FONT", MetaKey.FONT);

    @objid ("5b0a2af0-c73b-40bc-9fbd-e2ec8c85e553")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONCOMPONENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("b779d401-4118-4a2b-9c11-40e5ea1f1bfb")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONCOMPONENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("1fa6ba14-6400-4cd9-b1e5-b9d3beff74d8")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONCOMPONENT_SHOWTAGS", MetaKey.SHOWTAGS);

}
