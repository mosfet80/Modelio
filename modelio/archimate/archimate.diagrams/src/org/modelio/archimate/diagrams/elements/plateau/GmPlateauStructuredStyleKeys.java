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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPlateau when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("eb038ef5-d0de-482e-bc56-a6c939985cca")
public class GmPlateauStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("21d7c590-144e-4060-93f0-6a80fd628b43")
    static final StyleKey REPMODE = createStyleKey("PLATEAU_REPMODE", MetaKey.REPMODE);

    @objid ("960438d8-9050-44d1-a531-0358b4c6b7a1")
    static final StyleKey FILLCOLOR = createStyleKey("PLATEAU_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("ad8099c2-97ec-45c6-8807-27d97aa2505e")
    static final StyleKey FILLMODE = createStyleKey("PLATEAU_FILLMODE", MetaKey.FILLMODE);

    @objid ("c86c3f58-f9f6-45b8-8e04-8c65a7115946")
    static final StyleKey LINECOLOR = createStyleKey("PLATEAU_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("bbfbc0a9-ea6d-41d9-b319-0d00f51d10da")
    static final StyleKey LINEWIDTH = createStyleKey("PLATEAU_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("ad039953-3dbe-40fa-a978-256d9a911994")
    static final StyleKey FONT = createStyleKey("PLATEAU_FONT", MetaKey.FONT);

    @objid ("ca640d64-252d-404c-a11f-61f17bcc455f")
    static final StyleKey TEXTCOLOR = createStyleKey("PLATEAU_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("49631d3f-bafe-4659-93e5-d593e0f53cf1")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("PLATEAU_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("b95ceccc-b16b-41e2-a6b1-ad53fc2db55d")
    static final StyleKey SHOWTAGS = createStyleKey("PLATEAU_SHOWTAGS", MetaKey.SHOWTAGS);

}
