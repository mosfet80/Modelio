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
package org.modelio.archimate.diagrams.elements.applicationcollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationCollaboration when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("0c89c84f-891f-46ff-aa1a-e49e775fb490")
public class GmApplicationCollaborationStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("84394d48-364b-4221-ba18-1c6125a8cf5e")
    static final StyleKey REPMODE = createStyleKey("APPLICATIONCOLLABORATION_REPMODE", MetaKey.REPMODE);

    @objid ("84639a39-fde1-4828-9a90-96b0dcc7abc6")
    static final StyleKey FILLCOLOR = createStyleKey("APPLICATIONCOLLABORATION_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("6e249db4-ebf5-4b1b-bcbe-538f4e41ffed")
    static final StyleKey FILLMODE = createStyleKey("APPLICATIONCOLLABORATION_FILLMODE", MetaKey.FILLMODE);

    @objid ("d0934fe2-36f0-4c41-80ac-9083133927a1")
    static final StyleKey LINECOLOR = createStyleKey("APPLICATIONCOLLABORATION_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("e382e35b-4f0f-49a2-980a-4ba3c71d9cb3")
    static final StyleKey LINEWIDTH = createStyleKey("APPLICATIONCOLLABORATION_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("551d8510-4e63-4309-a627-42ad7b29859f")
    static final StyleKey FONT = createStyleKey("APPLICATIONCOLLABORATION_FONT", MetaKey.FONT);

    @objid ("1a112f17-7fe3-456f-b705-7ac671218914")
    static final StyleKey TEXTCOLOR = createStyleKey("APPLICATIONCOLLABORATION_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("a64a97f2-bfdf-4ec7-8134-6ad878e9bebd")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("APPLICATIONCOLLABORATION_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("dfdecbc9-05c1-4c00-afc0-37bc56fe6c09")
    static final StyleKey SHOWTAGS = createStyleKey("APPLICATIONCOLLABORATION_SHOWTAGS", MetaKey.SHOWTAGS);

}
