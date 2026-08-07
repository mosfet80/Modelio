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
package org.modelio.archimate.diagrams.elements.representation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRepresentation when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("a646ba56-a274-4b0a-bb34-49e68b633bad")
public class GmRepresentationStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0dc64aa9-855c-465e-9997-3bc40e2b5738")
    static final StyleKey REPMODE = createStyleKey("REPRESENTATION_REPMODE", MetaKey.REPMODE);

    @objid ("d0e36da7-797a-459c-b892-f73dcb873465")
    static final StyleKey FILLCOLOR = createStyleKey("REPRESENTATION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("47895045-9b4b-41a6-9e86-2c1eaa9c887b")
    static final StyleKey FILLMODE = createStyleKey("REPRESENTATION_FILLMODE", MetaKey.FILLMODE);

    @objid ("9a4aed17-d776-4583-b690-5f8d40bec18e")
    static final StyleKey LINECOLOR = createStyleKey("REPRESENTATION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("7d2150b2-07d1-45f3-97d5-2ce700d5dfe2")
    static final StyleKey LINEWIDTH = createStyleKey("REPRESENTATION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("ae9a5f38-e5b4-4b18-8c66-8c624c2e881a")
    static final StyleKey FONT = createStyleKey("REPRESENTATION_FONT", MetaKey.FONT);

    @objid ("c08591ff-325e-413a-89b6-cffd536d7804")
    static final StyleKey TEXTCOLOR = createStyleKey("REPRESENTATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("be561dde-af88-4716-ae48-49970a6f46f9")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("REPRESENTATION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("d7e639a0-a800-44ac-93ba-6965a1632a1c")
    static final StyleKey SHOWTAGS = createStyleKey("REPRESENTATION_SHOWTAGS", MetaKey.SHOWTAGS);

}
