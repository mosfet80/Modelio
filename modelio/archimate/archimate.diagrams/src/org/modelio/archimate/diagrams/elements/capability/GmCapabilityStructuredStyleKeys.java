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
package org.modelio.archimate.diagrams.elements.capability;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmCapability when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("ecf93c58-f062-4f8c-9566-077d1b9c159e")
public class GmCapabilityStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("8b4e12f5-0b01-4ee6-b336-e13676332c2e")
    static final StyleKey REPMODE = createStyleKey("CAPABILITY_REPMODE", MetaKey.REPMODE);

    @objid ("23a1176c-f2db-4eed-8c22-0f85b9edf84d")
    static final StyleKey FILLCOLOR = createStyleKey("CAPABILITY_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("51dc3e74-5d01-4025-ac0f-2f931e8859e4")
    static final StyleKey FILLMODE = createStyleKey("CAPABILITY_FILLMODE", MetaKey.FILLMODE);

    @objid ("18cb424e-ecab-4a3c-876e-29e25c8bbb84")
    static final StyleKey LINECOLOR = createStyleKey("CAPABILITY_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("97f03959-cd3c-49fb-bc89-3ec92c299db5")
    static final StyleKey LINEWIDTH = createStyleKey("CAPABILITY_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("84a7a9ed-7881-4f02-9fc5-48c70038b314")
    static final StyleKey FONT = createStyleKey("CAPABILITY_FONT", MetaKey.FONT);

    @objid ("bbf5b76f-48ea-4ecb-aa95-763070c20924")
    static final StyleKey TEXTCOLOR = createStyleKey("CAPABILITY_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("3d44b979-cf8e-4dc3-b627-1299db9ccb67")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("CAPABILITY_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b5e76936-e5f8-4581-a12c-7a2353af0deb")
    static final StyleKey SHOWTAGS = createStyleKey("CAPABILITY_SHOWTAGS", MetaKey.SHOWTAGS);

}
